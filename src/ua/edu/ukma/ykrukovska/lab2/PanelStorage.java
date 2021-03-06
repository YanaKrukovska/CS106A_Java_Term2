package ua.edu.ukma.ykrukovska.lab2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PanelStorage extends JFrame {
    private Storage storageModel = new Storage();

    private static final String PATH = "C:\\IdeaProjects\\Files\\";
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
    private JButton jGroupPrice = new JButton("Group price");
    private JButton searchWare = new JButton("Search ware");

    private JButton submit1 = new JButton("Submit");
    private JButton submit2 = new JButton("Submit");
    private JButton submit3 = new JButton("Submit");
    private JButton submit4 = new JButton("Submit");
    private JButton submit5 = new JButton("Submit");
    private JButton submit6 = new JButton("Submit");
    private JButton submit7 = new JButton("Submit");
    private JButton submit8 = new JButton("Submit");
    private JButton submit9 = new JButton("Submit");
    private JButton submit10 = new JButton("Submit");
    private JButton search = new JButton("Search");
    private JButton save = new JButton("Save");

    private JLabel lAddGroup = new JLabel("Name group");
    private JTextField lAddGroupField = new JTextField();
    private JLabel lEditGroup = new JLabel("Edit name of group: old name / new name ");
    private JTextField lEditGroupField = new JTextField();
    private JTextField lEditGroupOldNameField = new JTextField();
    private JLabel lDeleteGroup = new JLabel("Delete group");
    private JTextField lDeleteGroupField = new JTextField();
    private JLabel lAddQuantityOfWare = new JLabel("Add quantity of ware");
    private JTextField lAddQuantityOfWareField = new JTextField();
    private JLabel lDeleteQuantityOfWare = new JLabel("Delete quantity of ware");
    private JTextField lDeleteQuantityOfWareField = new JTextField();

    private JLabel wareName = new JLabel("Ware name");
    private JLabel wareDescription = new JLabel("Description");
    private JLabel wareProducer = new JLabel("Producer");
    private JLabel warePrice = new JLabel("Price");
    private JLabel wareGroup = new JLabel("Group");
    private JTextField wareNameField = new JTextField();
    private JTextField wareDescriptionField = new JTextField();
    private JTextField wareProducerField = new JTextField();
    private JTextField warePriceField = new JTextField();
    private JTextField wareGroupField = new JTextField();

    private JLabel wareNameEdited = new JLabel("Ware name");
    private JLabel wareDescriptionEdited = new JLabel("Description");
    private JLabel warePoducerEdited = new JLabel("Producer");
    private JLabel warePriceEdited = new JLabel("Price");
    private JLabel wareGroupEdited = new JLabel("Group");
    private JTextField wareNameFieldEdited = new JTextField();
    private JTextField wareDescriptionFieldEdited = new JTextField();
    private JTextField wareProducerFieldEdited = new JTextField();
    private JTextField warePriceFieldEdited = new JTextField();
    private JTextField wareGroupFieldEdited = new JTextField();

    private JLabel wareNameToDelete = new JLabel("Ware name to delete");
    private JTextField wareNameToDeleteField = new JTextField();
    private JTextArea textAreaGroupStatistic;
    private JTextField groupStatisticNameField;
    private JLabel addWareQuantName = new JLabel("Name of ware");
    private JTextField wareNameToAdd = new JTextField();
    private JLabel takeAwayQuantName = new JLabel("Name of ware");
    private JTextField wareNameTakeAwayField = new JTextField();
    private JTextField searchWareNameField = new JTextField();

    private static JTable table;
    private int tableRow = 0;

    static GraphicsConfiguration gc;
    JFrame frame = new JFrame(gc);
    private JTextArea foundWareArea;
    private JTextArea textAreaGroupPrice;
    private JTextField groupPriceNameField;

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
        jGroupPrice.setBounds(150, 550, 200, 50);
        panel.add(jGroupPrice);
        searchWare.setBounds(150, 600, 200, 50);
        panel.add(searchWare);
        save.setBounds(150, 650, 200, 50);
        panel.add(save);

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
        addGroupPriceListener();
        addSearchListener();
        saveOverallPriceListener();

        return panel;
    }


    private void addGroupPriceListener() {
        jGroupPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jGroupPrice) {
                    JFrame frame = new JFrame("Price of wares of the group ");
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setSize(400, 500);
                    frame.setLocation(800, 100);
                    frame.setLayout(new GridLayout(4, 1));
                    JLabel label = new JLabel("Group name");
                    textAreaGroupPrice = new JTextArea();
                    groupPriceNameField = new JTextField();
                    frame.add(label);
                    frame.add(groupPriceNameField);
                    textAreaGroupPrice.setText("");
                    frame.add(textAreaGroupPrice);
                    frame.add(submit10);

                    textAreaGroupPrice.setVisible(true);
                    frame.setVisible(true);
                    addSubmitGroupPriceListener();

                }
            }
        });

    }

    private void addSubmitGroupPriceListener() {
        submit10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit10) {
                    if (groupPriceNameField.getText() != null) {
                        textAreaGroupPrice.setText("");
                        textAreaGroupPrice.append(storageModel.showOverallPrice(storageModel.listGroupWares(groupPriceNameField.getText())));
                    }
                }
            }
        });

    }


    private void addSearchListener() {
        searchWare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == searchWare) {
                    JFrame frame = new JFrame("Search for ware");
                    foundWareArea = new JTextArea();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setSize(400, 500);
                    frame.setLocation(800, 100);
                    frame.setLayout(new GridLayout(4, 1));
                    JLabel label = new JLabel("Name of the ware you want to find");
                    frame.add(label);
                    frame.add(searchWareNameField);
                    frame.add(foundWareArea);
                    frame.add(search);
                    foundWareArea.setText("");

                    addSearchButtonListener();
                    foundWareArea.setVisible(true);
                    frame.setVisible(true);

                }
            }
        });

    }


    private void addSearchButtonListener() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == search) {
                    if (searchWareNameField.getText() != null || searchWareNameField.getText().length() == 0 || searchWareNameField.getText().trim().length() == 0) {
                        foundWareArea.setText("");
                        foundWareArea.append(storageModel.getByName(searchWareNameField.getText()).toString());
                    }
                }
            }
        });

    }


    private void addOverallPriceListener() {
        jOverallPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jOverallPrice) {
                    JFrame frame = new JFrame("Overall price");
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
                    textAreaGroupStatistic.revalidate();
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
                    textAreaGroupStatistic.setText("");
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
                    textAreaGroupStatistic.setText("");
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
                    JFrame frame = new JFrame("Overall statistic");
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
                    form1.add(lAddGroup);
                    form1.add(lAddGroupField);
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
                        if (table.getValueAt(i, 0) != null && table.getValueAt(i, 0).equals(lDeleteGroupField.getText())) {
                            clearRow(i);
                        }
                    }
                }
            }
        });

    }

    private void clearRow(int i) {
        table.setValueAt(null, i, 0);
        table.setValueAt(null, i, 1);
        table.setValueAt(null, i, 2);
        table.setValueAt(null, i, 3);
        table.setValueAt(null, i, 4);
        table.setValueAt(null, i, 5);
        table.validate();
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
                    form4.add(wareProducer);
                    form4.add(wareProducerField);
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
                                    wareProducerField.getText(), Double.parseDouble(warePriceField.getText()), wareGroupField.getText()));

                            for (int i = 0; i < tableRow; i++) {
                                if (table.getValueAt(i, 1) != null && table.getValueAt(i, 1).equals(storageModel.getByName(wareNameField.getText()).getName())) {
                                    canPutInTable = false;
                                }
                            }
                            if (canPutInTable) {
                                table.setValueAt(wareGroupField.getText(), tableRow, 0);
                                table.setValueAt(wareNameField.getText(), tableRow, 1);
                                table.setValueAt(wareDescriptionField.getText(), tableRow, 2);
                                table.setValueAt(wareProducerField.getText(), tableRow, 3);
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
                    form5.add(wareProducerFieldEdited);
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

                    if (checkIfInputIsNumber(warePriceFieldEdited.getText()) != -1) {
                        double amount = storageModel.getByName(wareNameFieldEdited.getText()).getAmount();
                        storageModel.editWare(new Ware(wareNameFieldEdited.getText(), wareDescriptionFieldEdited.getText(),
                                wareProducerFieldEdited.getText(), Double.parseDouble(warePriceFieldEdited.getText()), wareGroupFieldEdited.getText()));
                        storageModel.getByName(wareNameFieldEdited.getText()).setAmount(amount);

                        for (int i = 0; i < tableRow; i++) {
                            if (wareNameFieldEdited.getText() != null && table.getValueAt(i, 1).equals(wareNameFieldEdited.getText())) {
                                storageModel.addGroup(wareGroupFieldEdited.getText());
                                table.setValueAt(wareGroupFieldEdited.getText(), i, 0);
                                table.setValueAt(wareNameFieldEdited.getText(), i, 1);
                                table.setValueAt(wareDescriptionFieldEdited.getText(), i, 2);
                                table.setValueAt(wareProducerFieldEdited.getText(), i, 3);
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
                            clearRow(i);

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
                    form7.add(wareNameToAdd);
                    form7.add(lAddQuantityOfWare);
                    form7.add(lAddQuantityOfWareField);
                    lAddQuantityOfWareField.setText("");

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

                    if (checkIfInputIsNumber(lAddQuantityOfWareField.getText()) != -1) {

                        storageModel.addWareAmount(wareNameToAdd.getText(), Double.parseDouble(lAddQuantityOfWareField.getText()));
                        lAddQuantityOfWareField.setText("");
                        for (int i = 0; i < tableRow; i++) {
                            if (table.getValueAt(i, 1) != null && table.getValueAt(i, 1).equals(wareNameToAdd.getText())) {
                                table.setValueAt(storageModel.getByName(wareNameToAdd.getText()).getAmount(), i, 4);
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
                    form8.add(wareNameTakeAwayField);
                    form8.add(lDeleteQuantityOfWare);
                    form8.add(lDeleteQuantityOfWareField);
                    lDeleteQuantityOfWareField.setText("");

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

                    if (checkIfInputIsNumber(lDeleteQuantityOfWareField.getText()) != -1) {
                        storageModel.deleteWareAmount(wareNameTakeAwayField.getText(), Double.parseDouble(lDeleteQuantityOfWareField.getText()));

                        for (int i = 0; i < tableRow; i++) {
                            if (table.getValueAt(i, 1) != null && table.getValueAt(i, 1).equals(wareNameTakeAwayField.getText())) {
                                table.setValueAt(storageModel.getByName(wareNameTakeAwayField.getText()).getAmount(), i, 4);
                                table.validate();
                            }
                        }

                    }
                }
            }
        });

    }

    private int checkIfInputIsNumber(String input) {
        int number;
        try {
            number = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return -1;
        }
        return number;
    }

    private void saveOverallPriceListener() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == save) {
                    try {
                        save(storageModel.showInformation(storageModel.getWares()));
                    } catch (NullPointerException ex) {
                        System.out.println("You didn't add information in the table. File can`t be save");
                    }
                }
            }
        });

    }

    private static void save(String text1) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(PATH + "OverallPrice.txt"));
            out.writeObject(text1);
            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}