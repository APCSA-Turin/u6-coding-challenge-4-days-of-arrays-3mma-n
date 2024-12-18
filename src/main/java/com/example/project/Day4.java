package com.example.project;

import java.util.Random;

public class Day4 {
    
    private static String[] reindeer_names = {"Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen"};

    public static class Reindeer { // you must have at least a name, distance travelled, speed, run duration, and rest duration attribute
        private String name;
        private int distTraveled;
        private int speed;
        private int runTime;
        private int restTime;
        private int time;

        // Constructor 
        public Reindeer(String name, int speed, int runDuration, int restDuration) {
            this.name = name;
            this.speed = speed;
            runTime = runDuration;
            restTime = restDuration;
            distTraveled = 0;
            time = 0;
        }

        public int getDistanceTraveled(){ // this method is required
            return distTraveled;
        }
        
        public String getName() {
            return name;
        }

        public void simulateSecond(){ //this method is required but not tested
            if (time % (runTime + restTime) < runTime) {
                distTraveled += speed;
            }
            time++;
        }

    }

    public static String simulateRace(int time, Reindeer[] reindeers){ //you will be tested on this method
        Reindeer highest = reindeers[0];
        for (int i = 0; i < reindeers.length; i++) {
            for (int j = 0; j < time; j++) {
                reindeers[i].simulateSecond();
            }
            if (reindeers[i].getDistanceTraveled() > highest.getDistanceTraveled()) {
                highest = reindeers[i];
            }
        }
        return highest.getName();
    }

    
    public static void main(String[] args) { // for testing purposed
        Reindeer reindeer = new Day4.Reindeer("Dasher", 100, 5, 2);
        // Simulate 5 seconds of running
        for (int i = 0; i < 5; i++) {
            reindeer.simulateSecond();
        }
        System.out.println(reindeer.getDistanceTraveled());
        // Simulate 2 seconds of resting
        for (int i = 0; i < 3; i++) {
            reindeer.simulateSecond();
        }
        System.out.println(reindeer.getDistanceTraveled());
    }
}

 



