package Pages;
import Models.Gym;
import Models.Trainee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginPage extends JFrame {
    private JPasswordField passwordFiled;
    private JFormattedTextField userIdFiled;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel ImageLogo;
    private JPanel LoginPanel;
    private Gym gym;

    public LoginPage(String title, Gym gym)  {
        super(title);
        ImageLogo.setIcon(new ImageIcon("LOGO.jpg"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,560));
        this.setContentPane(LoginPanel);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
        this.gym = gym;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new RegisterPage("SAN Fitness Club Register Page", gym);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                ArrayList<Trainee> trainees = gym.getTrainees();
                for (int i =0;i<trainees.size();i++){
                    if (trainees.get(i).getTraineeId() == Integer.parseInt(userIdFiled.getText()) && trainees.get(i).getPassword().equals(String.valueOf(passwordFiled.getPassword()))){
                        JFrame frame = new MainPage("SAN Fitness Club Main Page", trainees.get(i),gym.getWorkouts());
                        frame.setVisible(true);
                        flag= true;
                        setVisible(false);
                        break;
                    }
                }
                if(!flag) {
                    JOptionPane.showMessageDialog(LoginPanel, "User Id or Password are incorrect", "User Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


}

