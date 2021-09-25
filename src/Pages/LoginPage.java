package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new RegisterPage("SAN Fitness Club Register Page");
                frame.setVisible(true);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // to login logic here
                JFrame frame = new MainPage("SAN Fitness Club Main Page");
                frame.setVisible(true);
            }
        });
    }


}

