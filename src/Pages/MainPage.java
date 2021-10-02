package Pages;

import Models.Gym;
import Models.Trainee;
import Models.Workout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainPage extends JFrame{
    private JButton RegisterButton;
    private JPanel MainPanel;
    private JLabel LogoLabel;
    private JLabel HelloLabel;
    private Trainee trainee;
    private ArrayList<Workout> workouts;
    public MainPage(String title, String fullName, Trainee trainee, ArrayList<Workout> workouts) {
        super(title);
        LogoLabel.setIcon(new ImageIcon("MainPageLOGO.jpeg"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,600));
        this.setContentPane(MainPanel);
        this.HelloLabel.setText(this.HelloLabel.getText()+" " + fullName);
        this.pack();
        this.trainee = trainee;
        this.workouts = workouts;
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new SignUpWorkoutPage("SAN Fitness Club Sign up to Workout Page", trainee, workouts);
                frame.setVisible(true);
            }
        });
    }




}
