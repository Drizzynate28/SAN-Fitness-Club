package Models;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    protected Date joinDate;

    public Person(int id, String fullName, String email, String phoneNumber, Date dateOfBirth,Date joinDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }


    public String getDetails() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String jDate = dateFormat.format(joinDate);
        String bDate = dateFormat.format(dateOfBirth);
        return id + "~" + fullName + "~" + email + "~" + phoneNumber + "~" + bDate +"~" + jDate;
    }

    @Override
    public String toString() {
        return "id:" + id + " Full Name:" + fullName + " Email:" + email + " Phone Number: " + phoneNumber + " Date Of Birth: " + dateOfBirth+ " Join Date:" + joinDate;
    }

}
