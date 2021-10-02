package Models;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Trainee extends Person {
    private static int countTrainees = 1;
    private int traineeId = 1;
    private String password;
    private ArrayList<Workout> workouts;

    public Trainee(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, String password, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth,joinDate);
        this.traineeId = countTrainees++;
        this.password = password;
        workouts = new ArrayList<Workout>();
    }

    public void WriteToFile(){
            try {
                FileWriter myWriter = new FileWriter("src/Files/Trainees.txt", true);
                myWriter.write("\n" + this.getDetails());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }

    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public String toString() {
        return getDetails();
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "~"+ traineeId + "~"+ password;
    }

    public int getTraineePayment(){
        long difference_In_Time = new Date().getTime() - joinDate.getTime();
        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));

        return (int) (200 - (difference_In_Years * 10));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
