package Models;

import java.util.ArrayList;

public class Gym {
    private int gymId;
    private String address;
    private ArrayList<Worker> Workers;
    private ArrayList<Trainee> Trainees;

    public Gym(int gymId, String address, ArrayList<Worker> workers, ArrayList<Trainee> trainees) {
        this.gymId = gymId;
        this.address = address;
        Workers = workers;
        Trainees = trainees;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Worker> getWorkers() {
        return Workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        Workers = workers;
    }

    public ArrayList<Trainee> getTrainees() {
        return Trainees;
    }

    public void setTrainees(ArrayList<Trainee> trainees) {
        Trainees = trainees;
    }

    public double calculateOutcomes(){
        double sum =0;
        for(int i =0;i<Workers.size();i++)   {
            sum += Workers.get(i).calculateSalary();
        }
        return sum;
    }

    public double calculateIncomes(){
        double sum =0;
        for(int i =0;i<Trainees.size();i++)   {
            sum += Trainees.get(i).getTraineePayment();
        }
        return sum;
    }

    public double calculateProfit(){
        return calculateIncomes() - calculateOutcomes();
    }

    @Override
    public String toString(){
        return "GymId: "+ gymId + " Address: " + address;
    }
}
