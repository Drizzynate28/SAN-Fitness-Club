# SAN-Fitness-Club 

<img src="LOGO.jpg">

Final Project - Software Engineering course @ Ruppin Academic Center.

**SAN-Fitness-Club** is a fitness club chain with a unique, state-of-the-art application
that aids with registration and participation in workouts.

Natanel Endelshtein  
Siel Farage  
Alex Kalenyuk

## Running the application

#### 1. Running directly from jar

##### Steps: 
    cd out/artifacts/SAN_Fitness_Club_jar
    java -jar SAN-Fitness-Club.jar

#### 2. Running the application using an IntelliJ IDE

##### Steps: 
    Open the project folder in IntelliJ, after that you can simply run the main() method in src/com.company/Main.

## Implementation 

#### Threading
We decided there is no sense to wait for operations like file close, for that reason,
we initiate these processes in a seperate thread and let them run asynchronously in [`RegisterPage.java`](https://github.com/Drizzynate28/SAN-Fitness-Club/blob/main/src/Pages/RegisterPage.java#L99).

#### File interaction
We write and read multiple "static" data using files:
- Trainee details: [`Trainee.java`](https://github.com/Drizzynate28/SAN-Fitness-Club/blob/main/src/Models/Trainee.java#L20).
- Trainees registering themselves to a specific workout: [`SignUpWorkoutPage.java`](https://github.com/Drizzynate28/SAN-Fitness-Club/blob/main/src/Pages/SignUpWorkoutPage.java#L116).
- Read workouts file: [`SignUpWorkoutPage.java`](https://github.com/Drizzynate28/SAN-Fitness-Club/blob/main/src/Pages/SignUpWorkoutPage.java#L33).

#### Main
The main covers all functionality, like a giant test.  
Upon startup, users are to choose: `For trainee Menu Press 1 for worker menu press 2:`;  
1 is a designed GUI that acts as the trainee menu.  
2 is the command line menu for the worker/employee menu.  
Feel free to try them both.

![](screenshots/1.png)

![](screenshots/2.png)

![](screenshots/3.png)
