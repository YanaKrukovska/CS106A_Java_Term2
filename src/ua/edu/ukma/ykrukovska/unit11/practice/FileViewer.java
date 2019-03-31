package ua.edu.ukma.ykrukovska.unit11.practice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileViewer extends JFrame {

    private JTextArea textArea;
    private JButton chooseButton;
    private JLabel fileName = new JLabel();
    private JScrollPane scrollPane;


    public FileViewer() {

        setTitle("File chooser");
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        add(createPanel());
        validate();
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        fileName.setBounds(50, 20, 500, 40);
        createButton();


        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 100, 500, 400);
        scrollPane.setVisible(true);


        panel.add(fileName);
        panel.add(chooseButton);
        panel.add(scrollPane);
        panel.setVisible(true);
        return panel;
    }

    private void createButton() {
        chooseButton = new JButton("Choose");
        chooseButton.setBounds(0, 60, 500, 40);
        chooseButton.setVisible(true);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == chooseButton) {
                    JFileChooser fileChooser = new JFileChooser();
                    int file = fileChooser.showDialog(null, "Open file");

                    if (file == JFileChooser.APPROVE_OPTION) {
                        fileName.setText(fileChooser.getSelectedFile().getName());

                        File chosenFile = fileChooser.getSelectedFile();
                        BufferedReader bufferedReader = null;
                        try {
                            bufferedReader = new BufferedReader(new FileReader(chosenFile));
                            textArea.read(bufferedReader, "Inside of opened txt file");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            }
        });
    }

    public static void main(String[] args) {
        new FileViewer();
    }
}
