package ua.edu.ukma.ykrukovska.unit10.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {


    private JLabel userLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");

    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    private JButton loginButton = new JButton("Login");


    public LoginFrame() {

        setTitle("Log In");
        setBounds(100, 100, 500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        userLabel.setBounds(50, 65, 100, 50);
        usernameField.setBounds(150, 65, 250, 40);
        passwordLabel.setBounds(50, 115, 100, 50);
        passwordField.setBounds(150, 115, 250, 40);
        loginButton.setBounds(200, 200, 100, 30);



        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton) {
                    String username = usernameField.getText();
                    String password = new String (passwordField.getPassword());


                    if (username.equals("Student") && password.equals("naukma")) {
                        JOptionPane.showMessageDialog(getParent(), "Login Successful. Oleg Vynnyk is better than Poplavskyi");
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Error");
                    }

                }
            }
        });

    }


}


