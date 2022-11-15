package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static int PROPORTION = 4;
    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        JButton saveButton = new JButton("Save");
        panel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void dispay() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static final void main(String[] args) {
        new SimpleGUI().dispay();
    }


}
