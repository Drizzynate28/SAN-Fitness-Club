package Models;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class Worker extends Person {
    protected static int workerId;
    protected Double salary;

    public Worker(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, Double salary, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth, joinDate);
        this.workerId ++;
        this.salary = salary;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double calculateSalary() {
        return salary;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "~" + workerId + "~" + joinDate;
    }

    @Override
    public String toString() {
        return super.toString() + " WorkerId: " + workerId + " Join Date: " + joinDate;
    }
}

