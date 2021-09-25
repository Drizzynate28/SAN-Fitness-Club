package com.company;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    private JPasswordField passwordFiled;
    private JFormattedTextField userIdFiled;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel ImageLogo;
    private JPanel LoginPanel;

    public LoginPage(String title)  {
        super(title);
        ImageLogo.setIcon(new ImageIcon("LOGO.jpg"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,560));
        this.setContentPane(LoginPanel);
        this.pack();

    }


}

