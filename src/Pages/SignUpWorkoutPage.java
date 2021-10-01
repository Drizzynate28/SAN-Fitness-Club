package Pages;

import Models.Trainee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class SignUpWorkoutPage extends JFrame {
    private JPanel WorkoutPanel;
    private JList WorkoutList;
    private JButton SignupButton;

    public SignUpWorkoutPage(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 360));
        this.setContentPane(WorkoutPanel);
        this.pack();
        String data = "";
        SignupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String str = "";
                String selectedValue = (String) WorkoutList.getSelectedValue();

                if (selectedValue != null) {
                    try {
                        File myObj = new File("src/Files/Workouts.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            str += data + "\n";
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("An error occurred.");
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(WorkoutPanel, "Please Select Workout", "Workout Not Selected", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String[] workouts = str.split("\n");
                String newStr = "";
                for (int i = 0; i < workouts.length; i++) {
                    String[] workout = workouts[i].split(":");
                    if (workout[0].equals(selectedValue) && Integer.parseInt(workout[1]) <= 20) {
                        int workoutCount = Integer.parseInt(workout[1]) + 1;
                        newStr += workout[0] + ":" + workoutCount + "\n";
                    } else {
                        newStr += workout[0] + ":" + workout[1] + "\n";
                    }
                }
                final String strToBeWritten = newStr;
                Runnable asyncFileOperation = () -> {
                    try {
                        FileWriter myWriter = new FileWriter("src/Files/Workouts.txt");
                        myWriter.write(strToBeWritten);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException ex) {
                        System.out.println("An error occurred.");
                        ex.printStackTrace();
                    }
                };
                new Thread(asyncFileOperation).start();
            }
        });
    }
}
