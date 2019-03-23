package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view;

import javax.swing.*;
import java.awt.*;

public class MathGameView extends JFrame {

    private JLabel maxNumberLabel = new JLabel("max number");
    private JLabel taskAmountLabel = new JLabel("amount of tasks");

    private JTextField maxNumberField = new JTextField();
    private JTextField taskAmountField = new JTextField();
    private JTable table;

    private JButton startButton = new JButton("start");


    public MathGameView() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setBounds(200, 200, 600, 500);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        JScrollPane scrollPanel = new JScrollPane();
        table = createDataTable();
        scrollPanel.add(table);
        table.setFillsViewportHeight(true);
        scrollPanel.setLayout(new BorderLayout());
        scrollPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        scrollPanel.add(table, BorderLayout.CENTER);


        /*maxNumberLabel.setBounds(30, 15, 100, 50);
        maxNumberField.setBounds(120, 20, 30, 30);

        taskAmountLabel.setBounds(170, 15, 100, 50);
        taskAmountField.setBounds(270, 20, 30, 30);
        startButton.setBounds(360, 20, 100, 30);*/
        //table.setBounds(400, 200,100,100);

        panel.add(scrollPanel);
        panel.add(maxNumberLabel);
        panel.add(maxNumberField);
        panel.add(taskAmountLabel);
        panel.add(taskAmountField);
        panel.add(startButton);
        panel.add(table);

        add(panel, BorderLayout.CENTER);


    }

    private JTable createDataTable() {

        String[] columnNames = {"Task",
                "Answer"
        };

        Object[][] data = {
                {"2+2", new Integer(4)},
                {"1+4", new Integer(5)}

        };


        return new JTable(data, columnNames);
    }
}
