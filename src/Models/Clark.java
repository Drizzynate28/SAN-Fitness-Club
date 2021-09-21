package Models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Clark extends Worker {

    public Clark(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, int workerId, Double salary, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth, workerId, salary, joinDate);
    }

    // the clark salary is based on the base salary + 100 NIS on every month of work
    @Override
    public Double calculateSalary() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date join = null;
        try {
            join = sdf.parse(joinDate.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        Date now = new Date(System.currentTimeMillis());

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(now.getTime() - join.getTime());
        return this.salary + c.get(Calendar.MONTH) * 100;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
