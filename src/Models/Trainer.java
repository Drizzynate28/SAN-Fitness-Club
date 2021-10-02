package Models;
import java.util.Date;

public class Trainer extends Worker {
    public int numOfTrainings = 0;

    public Trainer(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, Double salary, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth, salary, joinDate);
    }


    // the trainer will earn extra 50 NIS for every workout he trained
    @Override
    public Double calculateSalary() {
        return salary + numOfTrainings * 50;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
