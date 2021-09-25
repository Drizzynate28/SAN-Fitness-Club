package Pages;

import javax.swing.*;
import java.awt.*;

public class RegisterPage extends JFrame{
    private JPanel RegisterPanel;
    private JTextField NameFiled;
    private JTextField EmailField;
    private JComboBox MonthCB;
    private JComboBox YearCB;
    private JComboBox DayCB;
    private JPasswordField passwordPasswordField;
    private JTextField PhoneField;
    private JButton RegisterButton;

    public RegisterPage(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,360));
        this.setContentPane(RegisterPanel);
        this.pack();
    }
}
