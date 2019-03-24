package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view;

import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.controller.GameController;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.Game;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {

    private Game gameModel;
    private JTable table;
    private final GameController gameController;
    private JLabel maxNumberLabel = new JLabel("max number");
    private JLabel taskAmountLabel = new JLabel("amount of tasks");

    private JTextField maxNumberField = new JTextField();
    private JTextField taskAmountField = new JTextField();

    private JButton startButton = new JButton("start");
    private JButton submitButton = new JButton("submit");

    public GameView(GameController gameController, Game gameModel) throws HeadlessException {

        this.gameController = gameController;
        this.gameModel = gameModel;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setBounds(200, 200, 600, 500);


        JPanel summaryPanel = createTopPanel();
        add(summaryPanel);

    }

    public JPanel createTopPanel() {
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(null);

        summaryPanel.add(new JLabel("rita"));

        maxNumberField.setText("10");
        taskAmountField.setText("5");

        maxNumberLabel.setBounds(30, 15, 100, 50);
        maxNumberField.setBounds(120, 20, 30, 30);

        taskAmountLabel.setBounds(170, 15, 100, 50);
        taskAmountField.setBounds(270, 20, 30, 30);
        startButton.setBounds(360, 20, 100, 30);
        submitButton.setBounds(460, 20, 100, 30);

        startButtonListener();
        submitButtonListener();


        summaryPanel.add(maxNumberLabel);
        summaryPanel.add(maxNumberField);
        summaryPanel.add(taskAmountLabel);
        summaryPanel.add(taskAmountField);
        summaryPanel.add(startButton);
        summaryPanel.add(submitButton);

        return summaryPanel;
    }

    private void submitButtonListener() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {

                    AbstractTableModel tableModel = (AbstractTableModel) table.getModel();
                    tableModel.fireTableDataChanged();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        System.out.println(tableModel.getValueAt(i, 1));
                    }

                }
            }
        });

    }

    public void startButtonListener() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startButton) {
                    boolean readyToPlay = true;
                    int maxNumber = gameController.checkIfInputIsNumber(maxNumberField.getText());

                    if (maxNumber != -1) {
                        if (maxNumber < 10) {
                            JOptionPane.showMessageDialog(getParent(), "Number's too small");
                            readyToPlay = false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }

                    int taskAmount = gameController.checkIfInputIsNumber(taskAmountField.getText());

                    if (taskAmount != -1) {
                        if (taskAmount < 0 || taskAmount > 25) {
                            JOptionPane.showMessageDialog(getParent(), "Out of task amount range");
                            readyToPlay = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }

                    if (readyToPlay) {

                        createTable();

                        // Task[] tasks = gameModel.generateTasks(maxNumber, taskAmount);

                    }


                }
            }
        });
    }

    public void createTable() {


        String[] columnNames = {"Expression",
                "Answer", "Status"};

        Object[][] data = {
                {"Kathy", null, null},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };
        if (table == null) {
            table = new JTable(data, columnNames);
            JScrollPane panel = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            add(panel);
        }


    }


}
