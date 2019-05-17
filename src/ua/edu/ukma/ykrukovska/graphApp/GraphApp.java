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

    private final static int WIDTH = 900;
    private final static int HEIGHT = 450;
    private GraphCanvas canvas;
    private JTextField aField = new JTextField();
    private JTextField stepField = new JTextField();
    private JTextField xMinField = new JTextField();
    private JTextField xMaxField = new JTextField();

    private double step;
    public double a;

    public GraphApp() {

        setTitle("Graph App");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 10));
        infoPanel.setSize(new Dimension(WIDTH, 50));

        JLabel aLabel = new JLabel("a = ");
        JLabel step = new JLabel("Step = ");
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
        infoPanel.add(step);
        infoPanel.add(stepField);
        infoPanel.add(saveButton);
        infoPanel.add(drawButton);


        add(infoPanel, BorderLayout.NORTH);
        JPanel graphPanel = new JPanel();
        add(graphPanel, BorderLayout.SOUTH);
        setVisible(true);


    }

    private void addDrawButtonListener(JButton drawButton) {

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkValues()) {
                    drawGraphCanvas();
                }
            }
        });

    }

    private boolean checkValues() {
        boolean canDraw = false;

        if (isNull()) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Insert values before you draw", "Oops", JOptionPane.ERROR_MESSAGE);
            return false;

        } else {
            try {
                a = Double.parseDouble(aField.getText());
                step = Double.parseDouble(stepField.getText());

                if (Double.parseDouble(xMinField.getText()) <= Double.parseDouble(xMaxField.getText())) {
                    canDraw = true;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "x min can't be bigger than x max", "Wrong values!", JOptionPane.ERROR_MESSAGE);
                }
                if (Double.parseDouble(stepField.getText()) <= 0) {
                    canDraw = false;
                    JOptionPane.showMessageDialog(new JFrame(),
                            "step can't be less than zero", "Wrong value!", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException f) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Wrong input - it must be a number", "Wrong value!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return canDraw;
    }

    private boolean isNull() {
        return xMinField.getText() == null || xMinField.getText().length() == 0 ||
                xMaxField.getText() == null || xMaxField.getText().length() == 0 ||
                aField.getText() == null || aField.getText().length() == 0 ||
                stepField.getText() == null || stepField.getText().length() == 0;
    }

    private void addSaveButtonListener(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileToSave = new JFileChooser();
                int ret = fileToSave.showDialog(null, "Save");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileToSave.getSelectedFile();
                    try {
                        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
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

    private void drawGraphCanvas() {
        if (canvas != null) {
            this.remove(canvas);
        }
        step = Double.parseDouble(stepField.getText());
        double minX = Double.parseDouble(xMinField.getText());
        double maxX = Double.parseDouble(xMaxField.getText());
        a = Double.parseDouble(aField.getText());

        canvas = new GraphCanvas(step, minX, maxX, a);

        this.add(canvas);
        this.setVisible(true);
    }

}
