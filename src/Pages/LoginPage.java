package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.StandardSocketOptions;
import java.util.Scanner;

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
                String data = "";
                try {
                    File myObj = new File("src/Files/Trainees.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                }
                if(data.length()==0){
                    JOptionPane.showMessageDialog(LoginPanel, "User Id or Password are incorrect", "User Not Found", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String[] arrOfStr = data.split("\n");
                boolean flag = false;
                for (int i =0;i<arrOfStr.length;i++){
                    String[] strUser = arrOfStr[i].split("-");
                    if (strUser[3].equals(userIdFiled.getText()) && strUser[4].equals(String.valueOf(passwordFiled.getPassword()))){
                        JFrame frame = new MainPage("SAN Fitness Club Main Page", strUser[1]);
                        frame.setVisible(true);
                        flag= true;
                        break;
                    }
                }
                if(!flag) {
                    JOptionPane.showMessageDialog(LoginPanel, "User Id or Password are incorrect", "User Not Found", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }


}

