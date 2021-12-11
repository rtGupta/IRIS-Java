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
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 *
 * @author akshatajadhav
 */
public class VideoUtil {

    public VideoUtil(String filename, JPanel p) {
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(new File(filename + ".avi").getAbsolutePath());
            grabber.setFormat("avi");
            grabber.setFrameRate(30);
//            grabber.setInterleaved(true);
            grabber.setVideoOption("tune", "zerolatency");
            grabber.setVideoOption("preset", "ultrafast");
            grabber.setVideoOption("crf", "28");
            grabber.setVideoBitrate(2000000);
            grabber.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            grabber.setFormat("avi");

//        grabber.setGopSize(60);
            grabber.setAudioOption("crf", "0");
//        grabber.setAudioQuality(0);
            grabber.setAudioBitrate(192000);
            grabber.setSampleRate(44100);
            grabber.setAudioChannels(2);
            grabber.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
            grabber.start();
            Thread startCamera = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Frame capturedFrame = null;
                        initCanvas(p);
                        while ((capturedFrame = grabber.grab()) != null) {
                            showImage(capturedFrame);
//                            try {
//                                Thread.sleep(100);
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(VideoUtil.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                        }
                        grabber.stop();
                    } catch (FrameGrabber.Exception ex) {
                        Logger.getLogger(CameraUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            );
            startCamera.start();
        } catch (FFmpegFrameGrabber.Exception ex) {
            Logger.getLogger(VideoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Canvas canvas = null;
    private Color color = null;
    private Image image = null;
    private BufferedImage buffer = null;
    Java2DFrameConverter converter;

    private void initCanvas(JPanel p) {
        converter = new Java2DFrameConverter();
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
