package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final static int PROPORTION = 4;
    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUIWithFileChooser() {
        controller = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        mainPanel.add(textArea, BorderLayout.CENTER);
        final JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                controller.saveToFile(textArea.getText());
            }
            
        });
        mainPanel.add(saveButton, BorderLayout.SOUTH);

        final JTextField fileChosen = new JTextField();
        fileChosen.setEditable(false);
        final JButton browseFiles = new JButton("Browse...");
        browseFiles.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                final JFileChooser fileChooser = new JFileChooser();
                final int chooserResult = fileChooser.showSaveDialog(frame);
                switch (chooserResult) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setCurrentFile(fileChooser.getSelectedFile());
                        fileChosen.setText(fileChooser.getSelectedFile().getName());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, fileChooser, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        upperPanel.add(fileChosen, BorderLayout.CENTER);
        upperPanel.add(browseFiles, BorderLayout.LINE_END);

        frame.setContentPane(mainPanel);
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
        new SimpleGUIWithFileChooser().dispay();
    }

}
