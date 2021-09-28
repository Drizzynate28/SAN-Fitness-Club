package Models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Trainee extends Person {
    private static int countTrainees = 1;
    private int traineeId = 1;
    private String password;
    private ArrayList<Workout> workouts;

    public Trainee(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, String password) {
        super(id, fullName, email, phoneNumber, dateOfBirth);
        this.traineeId = countTrainees++;
        this.password = password;
        workouts = new ArrayList<Workout>();
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
        return super.getDetails() + " Trainee ID + Password: -"+ traineeId + "-"+ password;
    }

    public int getTraineePayment(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date join = null;
        try {
            join = sdf.parse("2000-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date(System.currentTimeMillis());

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(now.getTime() - join.getTime());
        int numberOfYearsMembership = c.get(Calendar.YEAR)-1970;
        return 200 - (numberOfYearsMembership * 10);
    }
}
