package com.company;
import Models.*;
import Pages.LoginPage;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class Main {

    //Natanel Endelshtein 316426659
    //Siel Farage  311360549
    //Alex Kalenyuk 313237844
    public static void main(String[] args) {
	    // Workers Initialize
        Trainer trainer = new Trainer(125, "Roni Levy", "BeerSheva4@gmail.com", "0541111111", new Date(85, 1, 2), 20000.0, new Date(120, 1, 20));
        Clark clark = new Clark(123, "Itay Shechter", "BS4Life@gmail.com", "0521111111", new Date(90, 1, 1), 5300.5, new Date(120, 1, 20));
        Manager manager = new Manager(124, "Nadav Wallach", "BeerSheva@gmail.com", "0501111111", new Date(95, 1, 2), 30000.0, new Date(120, 1, 20));
        ArrayList<Worker> workers = new ArrayList<Worker>();
        workers.add(trainer);
        workers.add(clark);
        workers.add(manager);

        // Workout Initialize
        Workout yoga = new Workout(1,"YOGA",50,trainer);
        Workout weights = new Workout(2,"Weights",60,trainer);
        Workout hit = new Workout(3,"HIT",40,trainer);
        Workout zomba = new Workout(4,"Zomba",50,trainer);
        Workout bodyBump = new Workout(5,"BodyBump",50,trainer);
        Workout swimming = new Workout(6,"Swimming",50,trainer);
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        workouts.add(yoga);
        workouts.add(weights);
        workouts.add(hit);
        workouts.add(zomba);
        workouts.add(bodyBump);
        workouts.add(swimming);

        // Trainee Initialize
        // read trainees from file if exists
        String data = "";
        String traineeStr ="";
        try {
            File myObj = new File("src/Files/Trainees.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                traineeStr += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
        ArrayList<Trainee> trainees = new ArrayList<Trainee>();
        if(data.length()==0){
            Trainee trainee1 = new Trainee(1, "Siel Farage", "SielFarage@Gmail.com", "0525520783", new Date(93, 8, 19), "1234",new Date(120, 1, 2));
            trainee1.WriteToFile();
            Trainee trainee2 = new Trainee(2, "Natanel Endelshtein", "Natanel770@Gmail.com", "0524205066", new Date(95, 8, 2), "1234",new Date(120, 1, 12));
            trainee2.WriteToFile();
            Trainee trainee3 = new Trainee(3, "Alex Kalenyuk", "Alexampm@Gmail.com", "052250783", new Date(95, 5, 19), "1234",new Date(120, 2, 20));
            trainee3.WriteToFile();
            trainees.add(trainee1);
            trainees.add(trainee2);
            trainees.add(trainee3);
        }
        else {
            String[] arrOfStr = traineeStr.split("\n");
            for (int i = 0;i<arrOfStr.length;i++){
                String[] strUser = arrOfStr[i].split("~");
                String [] strBirthday = strUser[4].split("/");
                String [] strJoin = strUser[5].split("/");
                Trainee trainee = new Trainee(Integer.parseInt(strUser[0]),strUser[1],strUser[2],strUser[3],new Date(Integer.parseInt(strBirthday[2])-1900,Integer.parseInt(strBirthday[1]),Integer.parseInt(strBirthday[0])),strUser[7],new Date(Integer.parseInt(strJoin[2])-1900,Integer.parseInt(strJoin[1]),Integer.parseInt(strJoin[0])));
                trainees.add(trainee);
            }
        }

        Gym gym = new Gym(1,"Netanya",workers,trainees,workouts);

        System.out.println("For trainee Menu Press 1 for worker menu press 2:");
        Scanner scan = new Scanner(System.in);
        int Choice = scan.nextInt();
        do {
            if (Choice == 1) {
                JFrame frame = new LoginPage("SAN Fitness Club",gym);
                frame.setVisible(true);
            } else if (Choice == 2) {
                int choice =0;
                ArrayList<Worker> gymWorkers = gym.getWorkers();
                do {
                    System.out.println("Press your option:");
                    System.out.println("1 for Manager");
                    System.out.println("2 for Trainer");
                    System.out.println("3 for Clark");
                    System.out.println("4 for Gym");
                    System.out.println("0 for Exit");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 0:
                            System.out.println("Have A Good Day Bye Bye !");
                            break;
                        case 1:
                            for (int i = 0; i < gymWorkers.size(); i++) {
                                if (gymWorkers.get(i) instanceof Manager) {
                                    Manager currentManager = (Manager) gymWorkers.get(i);
                                    System.out.println(currentManager.toString());
                                    System.out.println("Salary:" + currentManager.calculateSalary());
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < gymWorkers.size(); i++) {
                                if (gymWorkers.get(i) instanceof Trainer) {
                                    Trainer currentTrainer = (Trainer) gymWorkers.get(i);
                                    System.out.println(currentTrainer.toString());
                                    System.out.println("Salary:" + currentTrainer.calculateSalary());
                                    System.out.println("Number of workouts trained:" + currentTrainer.numOfTrainings);
                                }
                            }
                            break;
                        case 3:
                            for (int i = 0; i < gymWorkers.size(); i++) {
                                if (gymWorkers.get(i) instanceof Clark) {
                                    Clark currentClark = (Clark) gymWorkers.get(i);
                                    System.out.println(currentClark.toString());
                                    System.out.println(" Salary:" + currentClark.calculateSalary());
                                }
                            }
                            break;
                        case 4:
                            System.out.println(gym.toString());
                            System.out.println("Outcomes:" + gym.calculateOutcomes());
                            System.out.println("Income:" + gym.calculateIncomes());
                            System.out.println("Profit:" + gym.calculateProfit());
                            break;
                        default:
                            System.out.println("Wrong Input Please Try Again");
                    }
                }while(choice <=4 && choice>0);
            } else {
                System.out.println("Wrong Input ! \n For trainee Menu Press 1 for worker menu press 2:");
            }
        }while (Choice!=1&&Choice!=2);
    }
}
