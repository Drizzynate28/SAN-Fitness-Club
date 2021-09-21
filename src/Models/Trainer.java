package Models;
import java.util.ArrayList;
import java.util.Date;

public class Trainer extends Worker {
    ArrayList<Workout> trainingWorkouts;

    public Trainer(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, int workerId, Double salary, Date joinDate, ArrayList<Workout> trainingWorkouts) {
        super(id, fullName, email, phoneNumber, dateOfBirth, workerId, salary, joinDate);
        this.trainingWorkouts = trainingWorkouts;
    }

    public ArrayList<Workout> getTrainingWorkouts() {
        return trainingWorkouts;
    }

    public void setTrainingWorkouts(ArrayList<Workout> trainingWorkouts) {
        this.trainingWorkouts = trainingWorkouts;
    }

    // the trainer will earn extra 100 NIS for every workout he trained
    @Override
    public Double calculateSalary() {
        return salary + trainingWorkouts.size() * 100;
    }

    public int getNumberOfWorkouts() {
        return trainingWorkouts.size();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
