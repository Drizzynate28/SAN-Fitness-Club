package Pages;

import javax.swing.*;
import java.awt.*;

public class SignUpWorkoutPage extends JFrame{
    private JPanel WorkoutPanel;
    private JList WorkoutList;
    private JButton SignupButton;

    public SignUpWorkoutPage(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,360));
        this.setContentPane(WorkoutPanel);
        this.pack();
    }
}
