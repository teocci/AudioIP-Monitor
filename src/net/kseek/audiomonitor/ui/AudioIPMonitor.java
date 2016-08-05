package net.kseek.audiomonitor.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by teocci on 6/20/16.
 */
public class AudioIPMonitor extends JFrame{

    final static int gapSize = 0;
    GridLayout gl = new GridLayout(2, 3);

    public AudioIPMonitor(String name) {
        super(name);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel jp = new JPanel();
        jp.setLayout(gl);

        //Set up components preferred size
        jp.add(new ServerUI(8880));
        jp.add(new ServerUI(8293));

        jp.setPreferredSize(new Dimension(1200, 720));

        //Set up the horizontal gap value
        gl.setHgap(gapSize);
        //Set up the vertical gap value
        gl.setVgap(gapSize);
        //Set up the layout of the buttons
        gl.layoutContainer(jp);

        pane.add(jp, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        AudioIPMonitor f = new AudioIPMonitor("Monitor");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Set up the content pane.
        f.addComponentsToPane(f.getContentPane());
        //Display the window.
        f.pack();
        f.setVisible(true);
    }
}
