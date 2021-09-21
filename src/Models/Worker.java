package Models;
import java.util.Date;

public class Worker extends Person {
    protected int workerId;
    protected Double salary;
    protected Date joinDate;

    public Worker(int id, String fullName, String email, String phoneNumber, Date dateOfBirth, int workerId, Double salary, Date joinDate) {
        super(id, fullName, email, phoneNumber, dateOfBirth);
        this.workerId = workerId;
        this.salary = salary;
        this.joinDate = joinDate;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Double calculateSalary() {
        return salary;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " WorkerId: " + workerId + " Join Date: " + joinDate;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}

