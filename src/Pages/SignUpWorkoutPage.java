package Pages;
import Models.Trainee;
import Models.Workout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUpWorkoutPage extends JFrame {
    private JPanel WorkoutPanel;
    private JList WorkoutList;
    private JButton SignupButton;
    private Trainee trainee;
    private ArrayList<Workout> traineeWorkouts;
    String strDate = "";

    public SignUpWorkoutPage(String title, Trainee trainee, ArrayList<Workout>workouts)  {
        super(title);
        this.traineeWorkouts = workouts;
        this.trainee = trainee;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 360));
        this.setContentPane(WorkoutPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // read the workouts file
        try {
            File myObj = new File("src/Files/Workouts.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                strDate += data + "\n";
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }

        // initialize existing trainee workout
        String[] gymWorkouts = strDate.split("\n");
        for (int k = 0;k<gymWorkouts.length;k++){
            String[] workout = gymWorkouts[k].split(":");
            if(workout.length>1) {
                String [] assignTraineeWorkouts = workout[1].split(",");
                for (int j = 0; j < assignTraineeWorkouts.length; j++) {
                    if(Integer.parseInt(assignTraineeWorkouts[j]) ==trainee.getTraineeId()) {
                        trainee.getWorkouts().add(traineeWorkouts.get(k));
                    }
                }
            }
        }
        // act if the trainee already assigned to some workout
        int countRemove =0;
        for (int i =0;i<traineeWorkouts.size();i++){
            for (int j = 0; j<trainee.getWorkouts().size();j++)
                if(trainee.getWorkouts().get(j).getName() == traineeWorkouts.get(i).getName()){
                    ((DefaultListModel) WorkoutList.getModel()).remove(i-countRemove);
                    countRemove++;
                }
        }

        SignupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedValue = (String) WorkoutList.getSelectedValue();

                if (selectedValue != null) {
                    DefaultListModel model = (DefaultListModel) WorkoutList.getModel();
                    int selectedIndex = WorkoutList.getSelectedIndex();
                        model.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(WorkoutPanel, "Please Select Workout", "Workout Not Selected", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String[] workouts = strDate.split("\n");
                String newStr = "";
                for (int i = 0; i < workouts.length; i++) {
                    String[] workout = workouts[i].split(":");
                    if (workout.length>1) {
                        if (workout[0].equals(selectedValue)) {
                            // check if the workout not full
                            if(workout[1].split(",").length < 20) {
                                newStr += workout[0] + ":" + workout[1] + "," + trainee.getTraineeId() + "\n";
                            }
                            else {
                                JOptionPane.showMessageDialog(WorkoutPanel, "Please Select Different Workout", "Workout Is Full", JOptionPane.ERROR_MESSAGE);
                                newStr+= workout[0] + ":" + workout[1] +"\n";
                            }

                        } else {
                            newStr += workout[0] + ":" + workout[1] + "\n";
                        }
                    }
                    else {
                        if (workout[0].equals(selectedValue)) {
                            newStr += workout[0] + ":" + trainee.getTraineeId() + ",\n";
                        } else {
                            newStr += workout[0] + ":"  + "\n";
                        }
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
