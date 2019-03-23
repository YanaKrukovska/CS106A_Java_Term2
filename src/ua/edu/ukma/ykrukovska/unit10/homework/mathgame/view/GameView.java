package ua.edu.ukma.ykrukovska.unit10.homework.mathgame.view;

import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.controller.GameController;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.Game;
import ua.edu.ukma.ykrukovska.unit10.homework.mathgame.model.Task;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {

    private Game gameModel;
    private final JTable table;
    private final GameController gameController;
    private JLabel maxNumberLabel = new JLabel("max number");
    private JLabel taskAmountLabel = new JLabel("amount of tasks");

    private JTextField maxNumberField = new JTextField();
    private JTextField taskAmountField = new JTextField();

    private JButton startButton = new JButton("start");

    public GameView(GameController gameController, Game gameModel) throws HeadlessException {

        this.gameController = gameController;
        this.gameModel = gameModel;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setVisible(true);
        setBounds(200, 200, 600, 500);

        String[] columnNames = {"Task",
                "Answer"
        };

        Object[][] data = {
                {"2+2", new Integer(4)},
                {"1+4", new Integer(5)}

        };

        table = new JTable(data, columnNames);
        /*TableModel tableModel ;
        table = new JTable(tableModel);*/
        JScrollPane panel = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        JPanel summaryPanel = createTopPanel();
        add(summaryPanel);
        add(panel);
    }

    public JPanel createTopPanel() {
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(null);

        summaryPanel.add(new JLabel("rita"));

        maxNumberLabel.setBounds(30, 15, 100, 50);
        maxNumberField.setBounds(120, 20, 30, 30);

        taskAmountLabel.setBounds(170, 15, 100, 50);
        taskAmountField.setBounds(270, 20, 30, 30);
        startButton.setBounds(360, 20, 100, 30);

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
                        Task[] tasks = gameModel.generateTasks(maxNumber, taskAmount);
                    }
                }
            }
        });

        summaryPanel.add(maxNumberLabel);
        summaryPanel.add(maxNumberField);
        summaryPanel.add(taskAmountLabel);
        summaryPanel.add(taskAmountField);
        summaryPanel.add(startButton);

        return summaryPanel;
    }


}
