/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author akshatajadhav
 */
public class VideoUtil {

    private static final long serialVersionUID = 1L;
    private String VIDEO_PATH;
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private JButton playButton;
    private JButton stopButton;
    private JPanel contentPane;

    public VideoUtil(String filename, JPanel panel) {
        VIDEO_PATH = "video\\"+filename+".flv";
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
//        contentPane = new JPanel();
        contentPane = panel;
        contentPane.removeAll();
        contentPane.setBackground(new Color(38, 38, 38));
        contentPane.setPreferredSize(new Dimension(639, 420));
        contentPane.setSize(639, 420);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        controlsPane.setBackground(Color.WHITE);
        controlsPane.add(playButton);
        controlsPane.add(stopButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        contentPane.repaint();
        contentPane.revalidate();
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().play();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().stop();
            }
        });
        mediaPlayerComponent.mediaPlayer().media().startPaused(VIDEO_PATH);
    }

    @Override
    public void finalize() {
        if (mediaPlayerComponent != null) {
            mediaPlayerComponent.release();
        }
    }

    public void releaseCamera() {
        if (mediaPlayerComponent != null) {
            mediaPlayerComponent.release();
            mediaPlayerComponent = null;
        }
    }
}
