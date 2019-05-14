package ua.edu.ukma.ykrukovska.graphApp;

import javax.swing.*;
import java.awt.*;

public class GraphApp extends JFrame {

    private JPanel graphPanel= new JPanel();
    private JPanel infoPanel = new JPanel();
    private final static int WIDTH = 600;
    private final static int HEIGHT = 400;
    private GraphCanvas canvas;


    public GraphApp() {

        setTitle("Graph App");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        infoPanel.setLayout(new GridLayout(1, 6));
        infoPanel.setSize(new Dimension(600, 50));

        JLabel aLabel = new JLabel("a = ");
        JTextField aField = new JTextField();
        JLabel krok = new JLabel("Krok = ");
        JTextField krokField = new JTextField();
        JButton saveButton = new JButton("Save");
        JButton drawButton = new JButton("Draw");




        infoPanel.add(aLabel);
        infoPanel.add(aField);
        infoPanel.add(krok);
        infoPanel.add(krokField);
        infoPanel.add(saveButton);
        infoPanel.add(drawButton);

        drawGraphCanvas();


        add(infoPanel, BorderLayout.NORTH);
        add(graphPanel,BorderLayout.SOUTH);

        setVisible(true);


    }

    public void drawGraphCanvas() {
        if (canvas != null) {
            this.remove(canvas);
        }
        canvas = new GraphCanvas();
        this.add(canvas);
        this.setVisible(true);
    }


}
