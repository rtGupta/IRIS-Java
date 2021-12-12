/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JPanel;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 *
 * @author akshatajadhav
 */
public class CameraUtil {

    int captureWidth;
    int captureHeight;
    static FrameGrabber grabber;
    private boolean mac;
    Java2DFrameConverter converter;
    final FFmpegFrameRecorder recorder;
    final private static int FRAME_RATE = 30;
    final private static int GOP_LENGTH_IN_FRAMES = 60;
    final private static int AUDIO_DEVICE_INDEX = 0;
    private static long startTime = 0;
    private static long videoTS = 0;
    Thread startRecording;
    Thread startCamera;
    private Canvas canvas = null;
    private Color color = null;
    private Image image = null;
    private BufferedImage buffer = null;
    private boolean startRecord;
    JPanel panel;

    public CameraUtil(String filename, int width, int height) throws FrameGrabber.Exception {
        String os = System.getProperty("os.name");
        captureWidth = width;
        captureHeight = height;
        converter = new Java2DFrameConverter();
        if (os.contains("Mac")) {
            mac = true;
        } else {
            mac = false;
        }
        if (grabber == null) {
            if (mac) {
                grabber = new OpenCVFrameGrabber(0);
            } else {
                grabber = FrameGrabber.createDefault(0);
            }
        }
        grabber.setImageWidth(captureWidth);
        grabber.setImageHeight(captureHeight);
        grabber.start();
        recorder = new FFmpegFrameRecorder(filename + ".avi", captureWidth, captureHeight, 2);
        recorder.setInterleaved(true);
        recorder.setVideoOption("tune", "zerolatency");
        recorder.setVideoOption("preset", "ultrafast");
        recorder.setVideoOption("crf", "28");
        recorder.setVideoBitrate(2000000);
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
        recorder.setFormat("avi");
        recorder.setFrameRate(FRAME_RATE);
        recorder.setGopSize(GOP_LENGTH_IN_FRAMES);
        recorder.setAudioOption("crf", "0");
        recorder.setAudioQuality(0);
        recorder.setAudioBitrate(192000);
        recorder.setSampleRate(44100);
        recorder.setAudioChannels(2);
        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);

        startRecording = new Thread(new Runnable() {
            @Override
            public void run() {
                AudioFormat audioFormat = new AudioFormat(44100.0F, 16, 2, true, false);
                Mixer.Info[] minfoSet = AudioSystem.getMixerInfo();
                Mixer mixer = AudioSystem.getMixer(minfoSet[AUDIO_DEVICE_INDEX]);
                DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

                try {
                    final TargetDataLine line = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
                    line.open(audioFormat);
                    line.start();

                    final int sampleRate = (int) audioFormat.getSampleRate();
                    final int numChannels = audioFormat.getChannels();
                    final int audioBufferSize = sampleRate * numChannels;
                    final byte[] audioBytes = new byte[audioBufferSize];
                    final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
                    final CountDownLatch latch = new CountDownLatch(1);
                    exec.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (startRecord == false) {
                                    latch.countDown();
                                }
                                int nBytesRead = 0;
                                while (nBytesRead == 0) {
                                    nBytesRead = line.read(audioBytes, 0, line.available());
                                }
                                int nSamplesRead = nBytesRead / 2;
                                short[] samples = new short[nSamplesRead];
                                ByteBuffer.wrap(audioBytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(samples);
                                ShortBuffer sBuff = ShortBuffer.wrap(samples, 0, nSamplesRead);
                                recorder.recordSamples(sampleRate, numChannels, sBuff);
                            } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {

                            }
                        }
                    }, 0, (long) 1000 / FRAME_RATE, TimeUnit.MILLISECONDS);
                    latch.await();
                    exec.shutdownNow();
                } catch (LineUnavailableException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        startCamera = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Frame capturedFrame = null;
                    initCanvas(panel);
                    while ((capturedFrame = grabber.grab()) != null) {
                        showImage(capturedFrame);
                        if (startRecord) {
                            if (startTime == 0) {
                                startTime = System.currentTimeMillis();
                            }
                            videoTS = 1000 * (System.currentTimeMillis() - startTime);
                            if (videoTS > recorder.getTimestamp()) {
//                                        System.out.println(
//                                                "Lip-flap correction: "
//                                                + videoTS + " : "
//                                                + recorder.getTimestamp() + " -> "
//                                                + (videoTS - recorder.getTimestamp()));
//capturedFrame.timestamp = videoTS;
                                recorder.setTimestamp(videoTS);
                            }
                            recorder.record(capturedFrame);
                        }
                    }
                } catch (FrameGrabber.Exception ex) {
                    Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FFmpegFrameRecorder.Exception ex) {
                    Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );
    }

    public void startRecording() {
        try {
            this.startRecord = true;
            recorder.start();
            startRecording.start();
        } catch (FFmpegFrameRecorder.Exception ex) {
            Logger.getLogger(CameraUtil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startCamera(JPanel panel) {
        this.panel = panel;
        startCamera.start();
    }

    public void stopRecording() {
        try {
            this.startRecord = false;
            startRecording.stop();
            recorder.stop();
        } catch (FFmpegFrameRecorder.Exception ex) {
            Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopCamera() {
        try {
            stopRecording();
            startCamera.stop();
            grabber.stop();
        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initCanvas(JPanel p) {
        canvas = new Canvas() {
            @Override
            public void update(Graphics g) {
                paint(g);
            }

            @Override
            public void paint(Graphics g) {
                // Calling BufferStrategy.show() here sometimes throws
                // NullPointerException or IllegalStateException,
                // but otherwise seems to work fine.
                try {
                    if (canvas.getWidth() <= 0 || canvas.getHeight() <= 0) {
                        return;
                    }
                    BufferStrategy strategy = canvas.getBufferStrategy();
                    do {
                        do {
                            g = strategy.getDrawGraphics();
                            if (color != null) {
                                g.setColor(color);
                                g.fillRect(0, 0, getWidth(), getHeight());
                            }
                            if (image != null) {
                                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                            }
                            if (buffer != null) {
                                g.drawImage(buffer, 0, 0, getWidth(), getHeight(), null);
                            }
                            g.dispose();
                        } while (strategy.contentsRestored());
                        strategy.show();
                    } while (strategy.contentsLost());
                } catch (NullPointerException e) {
                } catch (IllegalStateException e) {
                }
            }
        };
//        if (fullScreen) {
//            canvas.setSize(getSize());
//            needInitialResize = false;
//        } else {
//            canvas.setSize(10,10); // mac bug
//            needInitialResize = true;
//        }
        canvas.setSize(640, 480);
        //p.setSize(640,480);
        p.removeAll();
        p.add(canvas);
        p.repaint();
        p.revalidate();
        canvas.setVisible(true);
        canvas.createBufferStrategy(2);
        //canvas.setIgnoreRepaint(true);
    }

    private void showImage(Frame image) {
        boolean flipChannels = false;
        double inverseGamma = 1.0;
        //double g = gamma == 0.0 ? getGamma(gd) : gamma;
        //inverseGamma = g == 0.0 ? 1.0 : 1.0/g;
        this.color = null;
        this.image = converter.getBufferedImage(image, converter.getBufferedImageType(image)
                == BufferedImage.TYPE_CUSTOM ? 1.0 : inverseGamma, flipChannels, null);
        canvas.paint(null);
    }

}
