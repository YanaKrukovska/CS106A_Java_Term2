package ua.edu.ukma.ykrukovska.lab2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStorage extends JFrame {
    private Storage storageModel = new Storage();


    private JButton jAddGroup = new JButton("Add Group");
    private JButton jEditGroup = new JButton("Edit Group");
    private JButton jDeleteGroup = new JButton("Delete Group");

    private JButton jAddWare = new JButton("Add Ware");
    private JButton jEditWare = new JButton("Edit Ware");
    private JButton jDeleteWare = new JButton("Delete Ware");

    private JButton jAddQuantityOfWare = new JButton("Add quantity of ware");
    private JButton jTakeAwayQuantityOdWare = new JButton("Take away quantity of ware");
    private JButton jOverallStatistic = new JButton("Show overall storage statistic");
    private JButton jGroupStatistic = new JButton("Show overall group statistic");
    private JButton jOverallPrice = new JButton("Show overall price");

    private JButton submit1 = new JButton("Submit");
    private JButton submit2 = new JButton("Submit");
    private JButton submit3 = new JButton("Submit");
    private JButton submit4 = new JButton("Submit");
    private JButton submit5 = new JButton("Submit");
    private JButton submit6 = new JButton("Submit");
    private JButton submit7 = new JButton("Submit");
    private JButton submit8 = new JButton("Submit");
    private JButton submit9 = new JButton("Submit");

    private JLabel lAddGroup = new JLabel("Name group");
    private JTextField lAddGroupField = new JTextField();
    private JLabel lEditGroup = new JLabel("Edit name of group: old name / new name ");
    private JTextField lEditGroupField = new JTextField();
    private JTextField lEditGroupOldNameField = new JTextField();
    private JLabel lDeleteGroup = new JLabel("Delete group");
    private JTextField lDeleteGroupField = new JTextField();
    private JLabel lAddWare = new JLabel("Add name of ware");
    private JTextField lAddWareField = new JTextField();
    private JLabel lAddQuantityOfWare = new JLabel("Add quantity of ware");
    private JTextField lAddQuantityOfWareField = new JTextField();
    private JLabel lDeleteQuantityOfWare = new JLabel("Delete quantity of ware");
    private JTextField lDeleteQuantityOfWareField = new JTextField();

    private JLabel wareName = new JLabel("Ware name");
    private JLabel wareDescription = new JLabel("Description");
    private JLabel warePoducer = new JLabel("Producer");
    private JLabel warePrice = new JLabel("Price");
    private JLabel wareGroup = new JLabel("Group");
    private JTextField wareNameField = new JTextField();
    private JTextField wareDescriptionField = new JTextField();
    private JTextField warePoducerField = new JTextField();
    private JTextField warePriceField = new JTextField();
    private JTextField wareGroupField = new JTextField();

    private JLabel wareNameEdited = new JLabel("Ware name");
    private JLabel wareDescriptionEdited = new JLabel("Description");
    private JLabel warePoducerEdited = new JLabel("Producer");
    private JLabel warePriceEdited = new JLabel("Price");
    private JLabel wareGroupEdited = new JLabel("Group");
    private JTextField wareNameFieldEdited = new JTextField();
    private JTextField wareDescriptionFieldEdited = new JTextField();
    private JTextField warePoducerFieldEdited = new JTextField();
    private JTextField warePriceFieldEdited = new JTextField();
    private JTextField wareGroupFieldEdited = new JTextField();

    private JLabel wareNameToDelete = new JLabel("Ware name to delete");
    private JTextField wareNameToDeleteField = new JTextField();

    private static JTable table;
    private int tableRow = 0;

    static GraphicsConfiguration gc;
    JFrame frame = new JFrame(gc);
    private JTextArea textAreaGroupStatistic;
    private JTextField groupStatisticNameField;
    private JLabel addWareQuantName = new JLabel("Name of ware");
    private JTextField addWareQuantField = new JTextField();
    private JLabel takeAwayQuantName = new JLabel("Name of ware");
    ;
    private JTextField takeAwayQuantNameField = new JTextField();

    public static void createTable() {
        JFrame frameTable = new JFrame("Table");
        frameTable.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        String[] columnNames = {
                "Group of storage",
                "Name of ware",
                "Description",
                "Producer",
                "Quantity on stock",
                "Price of one ware"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 15);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        frameTable.getContentPane().add(scrollPane);
        frameTable.setPreferredSize(new Dimension(800, 400));
        frameTable.pack();
        frameTable.setLocationRelativeTo(null);
        frameTable.setVisible(true);


    }


    PanelStorage() {

        setTitle("Documentation of Storage");
        setBounds(100, 100, 500, 820);
        setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        setVisible(true);

        add(createPanel());
        validate();

    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);


        jAddGroup.setBounds(150, 0, 200, 50);
        panel.add(jAddGroup);
        jEditGroup.setBounds(150, 50, 200, 50);
        panel.add(jEditGroup);
        jDeleteGroup.setBounds(150, 100, 200, 50);
        panel.add(jDeleteGroup);
        jAddWare.setBounds(150, 150, 200, 50);
        panel.add(jAddWare);
        jEditWare.setBounds(150, 200, 200, 50);
        panel.add(jEditWare);
        jDeleteWare.setBounds(150, 250, 200, 50);
        panel.add(jDeleteWare);
        jAddQuantityOfWare.setBounds(150, 300, 200, 50);
        panel.add(jAddQuantityOfWare);
        jTakeAwayQuantityOdWare.setBounds(150, 350, 200, 50);
        panel.add(jTakeAwayQuantityOdWare);
        jOverallStatistic.setBounds(150, 400, 200, 50);
        panel.add(jOverallStatistic);
        jGroupStatistic.setBounds(150, 450, 200, 50);
        panel.add(jGroupStatistic);
        jOverallPrice.setBounds(150, 500, 200, 50);
        panel.add(jOverallPrice);


        addGroupListener();
        editGroupListener();
        deleteGroupListener();
        addWareListener();
        editWareListener();
        deleteWareListener();
        jAddQuantityOfWareListener();
        jTakeAwayQuantityOdWareListener();
        jOverallStatisticListener();
        jGroupStatisticListener();
        addOverallPriceListener();

        return panel;
    }

    private void addOverallPriceListener() {
        jOverallPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jOverallPrice) {
                    JFrame frame = new JFrame();
                    JTextArea textArea = new JTextArea();
                    frame.add(textArea);
                    textArea.append(storageModel.showOverallPrice(storageModel.getWares()));
                    System.out.println(storageModel.showOverallPrice(storageModel.getWares()));
                    textArea.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setSize(400, 500);
                    frame.setLocation(800, 100);
                    frame.setVisible(true);

                }
            }
        });

    }

    private void jGroupStatisticListener() {
        jGroupStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jGroupStatistic) {
                    JFrame frame = new JFrame("Group statistic");
                    textAreaGroupStatistic = new JTextArea();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setSize(400, 500);
                    frame.setLocation(800, 100);
                    frame.setLayout(new GridLayout(4, 1));
                    JLabel label = new JLabel("Group name");
                    groupStatisticNameField = new JTextField();
                    frame.add(label);
                    frame.add(groupStatisticNameField);
                    frame.add(textAreaGroupStatistic);
                    frame.add(submit9);


                    addSubmitGroupStatisticListener();
                    textAreaGroupStatistic.setVisible(true);
                    frame.setVisible(true);

                }
            }
        });

    }

    private void addSubmitGroupStatisticListener() {
        submit9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit9) {

                    textAreaGroupStatistic.append(storageModel.showGroupWaresInformation(storageModel.listGroupWares(groupStatisticNameField.getText())));
                }
            }
        });

    }

    private void jOverallStatisticListener() {
        jOverallStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jOverallStatistic) {
                    JFrame frame = new JFrame();
                    JTextArea textArea = new JTextArea();
                    frame.add(textArea);
                    textArea.append(storageModel.showInformation(storageModel.getWares()));
                    textArea.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setSize(400, 500);
                    frame.setLocation(800, 100);
                    frame.setVisible(true);

                }
            }
        });

    }


    private void addGroupListener() {
        jAddGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jAddGroup) {

                    JFrame form1 = new JFrame("Add Group");
                    form1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form1.setSize(400, 500);
                    form1.setLayout(new GridLayout(4, 1));
                    form1.setLocation(800, 100);
                    frame.setVisible(false);
                    form1.setVisible(true);

//                    lAddGroup.setBounds(100, 100, 120, 50);
//                    lAddGroupField.setBounds(200, 100, 270, 40);
                    form1.add(lAddGroup);
                    form1.add(lAddGroupField);

//                    submit.setBounds(250, 420, 100, 50);
                    form1.add(submit1);

                    addGrSubmitListener();


                }
            }
        });

    }

    private void addGrSubmitListener() {
        submit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit1) {
                    storageModel.addGroup(lAddGroupField.getText());

                }
            }
        });

    }

    private void editGroupListener() {
        jEditGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jEditGroup) {

                    JFrame form2 = new JFrame("Edit Group");
                    form2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form2.setSize(400, 500);
                    form2.setLayout(new GridLayout(5, 1));
                    form2.setLocation(800, 100);
                    frame.setVisible(false);
                    form2.setVisible(true);

                    form2.add(lEditGroup);
                    form2.add(lEditGroupOldNameField);
                    form2.add(lEditGroupField);
                    form2.add(submit2);

                    editGrSubmitListener();

                }
            }
        });

    }

    private void editGrSubmitListener() {
        submit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit2) {
                    storageModel.editGroup(lEditGroupOldNameField.getText(), lEditGroupField.getText());

                    for (int i = 0; i < tableRow; i++) {
                        if (table.getValueAt(i, 0).equals(lEditGroupOldNameField.getText())) {
                            table.setValueAt(lEditGroupField.getText(), i, 0);
                            table.validate();
                        }
                    }

                }
            }
        });

    }

    private void deleteGroupListener() {
        jDeleteGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jDeleteGroup) {

                    JFrame form3 = new JFrame("Delete Group");
                    form3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form3.setSize(400, 500);
                    form3.setLayout(new GridLayout(3, 1));
                    form3.setLocation(800, 100);
                    frame.setVisible(false);
                    form3.setVisible(true);

                    submit3.setBounds(250, 420, 100, 50);
                    form3.add(lDeleteGroup);
                    form3.add(lDeleteGroupField);
                    form3.add(submit3);
                    deleteGrSubmitListener();

                }
            }
        });

    }

    private void deleteGrSubmitListener() {
        submit3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit3) {
                    storageModel.deleteGroup(lDeleteGroupField.getText());

                    for (int i = 0; i < tableRow; i++) {
                        if (table.getValueAt(i, 0).equals(lDeleteGroupField.getText())) {
                            table.setValueAt(null, i, 0);
                            table.setValueAt(null, i, 1);
                            table.setValueAt(null, i, 2);
                            table.setValueAt(null, i, 3);
                            table.setValueAt(null, i, 4);
                            table.setValueAt(null, i, 5);
                            table.validate();
                        }

                    }

                }
            }
        });

    }

    private void addWareListener() {
        jAddWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jAddWare) {

                    JFrame form4 = new JFrame("Add Ware");
                    form4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form4.setSize(400, 500);
                    form4.setLayout(new GridLayout(7, 2));
                    form4.setLocation(800, 100);
                    frame.setVisible(false);
                    form4.setVisible(true);
                    form4.add(wareName);
                    form4.add(wareNameField);
                    form4.add(wareDescription);
                    form4.add(wareDescriptionField);
                    form4.add(warePoducer);
                    form4.add(warePoducerField);
                    form4.add(warePrice);
                    form4.add(warePriceField);
                    form4.add(wareGroup);
                    form4.add(wareGroupField);


                    submit4.setBounds(250, 420, 100, 50);
                    form4.add(submit4);
                    addWareSubmitListener();
                }
            }
        });

    }

    private void addWareSubmitListener() {
        submit4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit4) {
                    boolean readyToPlay = true;
                    int taskAmount = checkIfInputIsNumber(warePriceField.getText());

                    if (taskAmount == -1) {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }
                    if (readyToPlay) {

                        boolean canPutInTable = true;
                        if (!wareGroupField.getText().equals("")) {
                            storageModel.addWare(new Ware(wareNameField.getText(), wareDescriptionField.getText(),
                                    warePoducerField.getText(), 0, wareGroupField.getText()));

                            for (int i = 0; i < tableRow; i++) {
                                if (wareNameField.getText().equals(storageModel.getByName(wareNameField.getText()).getName())) {
                                    canPutInTable = false;
                                }
                            }
                            if (canPutInTable) {
                                table.setValueAt(wareGroupField.getText(), tableRow, 0);

                                table.setValueAt(wareNameField.getText(), tableRow, 1);
                                table.setValueAt(wareDescriptionField.getText(), tableRow, 2);
                                table.setValueAt(warePoducerField.getText(), tableRow, 3);
                                table.setValueAt(warePriceField.getText(), tableRow, 5);
                                tableRow++;
                                table.validate();
                            }

                        }
                    }

                }
            }
        });

    }

    private void editWareListener() {
        jEditWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jEditWare) {

                    JFrame form5 = new JFrame("Edit Ware");
                    form5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form5.setLayout(new GridLayout(6, 2));
                    form5.setSize(400, 500);
                    form5.setLocation(800, 100);
                    frame.setVisible(false);
                    form5.setVisible(true);


                    form5.add(wareNameEdited);
                    form5.add(wareNameFieldEdited);
                    form5.add(wareDescriptionEdited);
                    form5.add(wareDescriptionFieldEdited);
                    form5.add(warePoducerEdited);
                    form5.add(warePoducerFieldEdited);
                    form5.add(warePriceEdited);
                    form5.add(warePriceFieldEdited);
                    form5.add(wareGroupEdited);
                    form5.add(wareGroupFieldEdited);

                    submit5.setBounds(250, 420, 200, 50);
                    form5.add(submit5);
                    editWareSubmitListener();
                }
            }
        });

    }

    private void editWareSubmitListener() {
        submit5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit5) {

                    boolean readyToPlay = true;
                    int taskAmount = checkIfInputIsNumber(warePriceFieldEdited.getText());

                    if (taskAmount == -1) {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }
                    if (readyToPlay) {
                        storageModel.editWare(new Ware(wareNameFieldEdited.getText(), wareDescriptionFieldEdited.getText(),
                                warePoducerFieldEdited.getText(), 0, wareGroupFieldEdited.getText()));


                        for (int i = 0; i < tableRow; i++) {
                            if (table.getValueAt(i, 0).equals(wareNameFieldEdited.getText())) {
                                table.setValueAt(wareNameFieldEdited.getText(), i, 1);
                                table.setValueAt(wareDescriptionFieldEdited.getText(), i, 2);
                                table.setValueAt(warePoducerFieldEdited.getText(), i, 3);
                                table.setValueAt(warePriceFieldEdited.getText(), i, 5);
                                table.validate();
                            }
                        }


                    }


                }
            }
        });

    }


    private void deleteWareListener() {
        jDeleteWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jDeleteWare) {

                    JFrame form6 = new JFrame("Delete Ware");
                    form6.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form6.setSize(400, 500);
                    form6.setLocation(800, 100);
                    form6.setLayout(new GridLayout(3, 1));
                    frame.setVisible(false);
                    form6.setVisible(true);
                    form6.add(wareNameToDelete);
                    form6.add(wareNameToDeleteField);


                    submit6.setBounds(250, 420, 100, 50);
                    form6.add(submit6);
                    deleteWareSubmitListener();
                }
            }
        });

    }

    private void deleteWareSubmitListener() {
        submit6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit6) {
                    storageModel.deleteWareByName(wareNameToDeleteField.getText());

                    for (int i = 0; i < tableRow; i++) {
                        if (table.getValueAt(i, 1).equals(wareNameToDeleteField.getText())) {
                            table.setValueAt(null, i, 0);
                            table.setValueAt(wareNameFieldEdited.getText(), i, 1);
                            table.setValueAt(wareDescriptionFieldEdited.getText(), i, 2);
                            table.setValueAt(warePoducerFieldEdited.getText(), i, 3);
                            table.setValueAt(warePriceFieldEdited.getText(), i, 5);
                            table.validate();
                        }
                    }

                }
            }
        });

    }

    private void jAddQuantityOfWareListener() {
        jAddQuantityOfWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jAddQuantityOfWare) {

                    JFrame form7 = new JFrame("Add quantity of ware");
                    form7.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form7.setSize(400, 500);
                    form7.setLayout(new GridLayout(4, 1));
                    form7.setLocation(800, 100);
                    frame.setVisible(false);
                    form7.setVisible(true);

                    form7.add(addWareQuantName);
                    form7.add(addWareQuantField);
                    form7.add(lAddQuantityOfWare);
                    form7.add(lAddQuantityOfWareField);

                    submit7.setBounds(250, 420, 100, 50);
                    form7.add(submit7);

                    addQuantityOfWareListener();
                }
            }
        });

    }

    private void addQuantityOfWareListener() {
        submit7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit7) {

                    boolean readyToPlay = true;
                    int taskAmount = checkIfInputIsNumber(lAddQuantityOfWareField.getText());

                    if (taskAmount == -1) {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }
                    if (readyToPlay) {
                        storageModel.addWareAmount(addWareQuantField.getText(), Double.parseDouble(lAddQuantityOfWareField.getText()));
                        System.out.println(storageModel.getByName(addWareQuantField.getText()).getAmount());

                        for (int i = 0; i < tableRow; i++) {
                            if (table.getValueAt(i, 1).equals(addWareQuantField.getText())) {
                                table.setValueAt(storageModel.getByName(addWareQuantField.getText()).getAmount(), i, 4);
                                table.validate();
                            }
                        }
                    }

                }
            }
        });

    }

    private void jTakeAwayQuantityOdWareListener() {
        jTakeAwayQuantityOdWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jTakeAwayQuantityOdWare) {

                    JFrame form8 = new JFrame("Take away quantity of ware");
                    form8.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    form8.setSize(400, 500);
                    form8.setLayout(new GridLayout(4, 1));
                    form8.setLocation(800, 100);
                    frame.setVisible(false);
                    form8.setVisible(true);

                    form8.add(takeAwayQuantName);
                    form8.add(takeAwayQuantNameField);
                    form8.add(lDeleteQuantityOfWare);
                    form8.add(lDeleteQuantityOfWareField);

                    submit8.setBounds(250, 420, 100, 50);
                    form8.add(submit8);

                    deleteQuantityOfWareListener();
                }
            }
        });

    }

    private void deleteQuantityOfWareListener() {
        submit8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit8) {
                    boolean readyToPlay = true;
                    int taskAmount = checkIfInputIsNumber(lDeleteQuantityOfWareField.getText());

                    if (taskAmount == -1) {
                        JOptionPane.showMessageDialog(getParent(), "It's not a number");
                        readyToPlay = false;
                    }
                    if (readyToPlay) {
                        storageModel.deleteWareAmount(takeAwayQuantNameField.getText(), Double.parseDouble(lDeleteQuantityOfWareField.getText()));
                        System.out.println(storageModel.getByName(takeAwayQuantNameField.getText()).getAmount());

                        for (int i = 0; i < tableRow; i++) {
                            if (table.getValueAt(i, 1).equals(takeAwayQuantNameField.getText())) {
                                table.setValueAt(storageModel.getByName(takeAwayQuantNameField.getText()).getAmount(), i, 4);
                                table.validate();
                            }
                        }
                    }
                }
            }
        });

    }

    public int checkIfInputIsNumber(String input) {
        int number;
        try {
            number = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return -1;
        }
        return number;
    }

}