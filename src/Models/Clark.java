package Models;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Clark extends Worker {

    public Clark(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, Double salary, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth, salary, joinDate);
    }

    // the clark salary is based on the base salary + 100 NIS on every month of work
    @Override
    public Double calculateSalary() {
        Calendar m_calendar=Calendar.getInstance();
        m_calendar.setTime(joinDate);
        int nMonth1=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(new Date());
        int nMonth2=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        return this.salary +Math.abs(nMonth2-nMonth1) * 20;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
