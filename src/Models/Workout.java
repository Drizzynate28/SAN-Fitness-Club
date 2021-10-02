package Models;

public class Workout {
    private int workoutId;
    private String name;
    private int duration;

    public Workout(int workoutId, String name, int duration,Trainer trainer) {
        this.workoutId = workoutId;
        this.name = name;
        this.duration = duration;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getDetails(){
        return workoutId + "-" + name + "-" + duration + " minutes";
    }

    @Override
    public String toString() {
        return "WorkoutId: " + workoutId + " Name: " + name + " Duration: " + duration + " minutes";
    }
}
