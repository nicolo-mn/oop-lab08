package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI(final Controller controller) {
        this.controller = controller;
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final JTextField textField = new JTextField();
        final JButton print = new JButton("Print");
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.setNextString(textField.getText());
                controller.printString();
            }

        });
        final JButton history = new JButton("Show History");
        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                String toDisplay = "";
                for (String string : controller.getHistory()) {
                    toDisplay = toDisplay + string + "\n";
                }
                textArea.setText(toDisplay);
            }

        });
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        final JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(print);
        southPanel.add(history);
        panel.add(southPanel, BorderLayout.SOUTH);
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

    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).dispay();
    }

}
