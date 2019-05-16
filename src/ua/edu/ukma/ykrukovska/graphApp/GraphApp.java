package ua.edu.ukma.ykrukovska.graphApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphApp extends JFrame {

    private JPanel graphPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private final static int WIDTH = 1000;
    private final static int HEIGHT = 450;
    private GraphCanvas canvas;
    public JTextField aField = new JTextField();
    public JTextField krokField = new JTextField();
    public JTextField xMinField = new JTextField();
    public JTextField xMaxField = new JTextField();

    public double krokValue;
    public double minX;
    public double maxX;
    public double a;

    public GraphApp() {

        setTitle("Graph App");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        infoPanel.setLayout(new GridLayout(1, 10));
        infoPanel.setSize(new Dimension(1000, 50));

        JLabel aLabel = new JLabel("a = ");

        JLabel krok = new JLabel("Krok = ");

        JLabel xMin = new JLabel("X min");
        JLabel xMax = new JLabel("X max");


        JButton saveButton = new JButton("Save");
        JButton drawButton = new JButton("Draw");

        addSaveButtonListener(saveButton);
        addDrawButtonListener(drawButton);


        infoPanel.add(aLabel);
        infoPanel.add(aField);
        infoPanel.add(xMin);
        infoPanel.add(xMinField);
        infoPanel.add(xMax);
        infoPanel.add(xMaxField);
        infoPanel.add(krok);
        infoPanel.add(krokField);
        infoPanel.add(saveButton);
        infoPanel.add(drawButton);


        add(infoPanel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.SOUTH);
        setVisible(true);


    }

    private void addDrawButtonListener(JButton drawButton) {

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drawGraphCanvas();
                } catch (NumberFormatException f) {
                  //  JOptionPane.showMessageDialog(new JFrame(),
                   //         "Wrong input", "Wrong value!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private void addSaveButtonListener(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileToSave = new JFileChooser();
                int ret = fileToSave.showDialog(null, "Save");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileToSave.getSelectedFile();
                    try {
                        BufferedImage image = new BufferedImage(getWidth(), getHeight() - 50, BufferedImage.TYPE_INT_RGB);
                        Graphics2D graphics2D = image.createGraphics();
                        getContentPane().paint(graphics2D);
                        ImageIO.write(image, "jpeg", file);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "There is no graph yet!", "Oops", JOptionPane.ERROR_MESSAGE);
                }
            }


        });
    }

    public void drawGraphCanvas() {
        if (canvas != null) {
            this.remove(canvas);
        }
        /*krokValue = Double.parseDouble(krokField.getText());
        minX = Double.parseDouble(xMinField.getText());
        maxX = Double.parseDouble(xMaxField.getText());
        a = Double.parseDouble(aField.getText());*/

        krokValue = 1;
        minX = -1;
        maxX = 1;
        a = 1;
        canvas = new GraphCanvas(krokValue, minX, maxX, a);

        this.add(canvas);
        this.setVisible(true);
    }

}
