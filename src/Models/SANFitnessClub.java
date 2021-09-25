package Models;

import java.util.ArrayList;

public class SANFitnessClub {
    private ArrayList<Gym> gyms;

    public SANFitnessClub(ArrayList<Gym> gyms) {
        this.gyms = gyms;
    }

    public ArrayList<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(ArrayList<Gym> gyms) {
        this.gyms = gyms;
    }
}
