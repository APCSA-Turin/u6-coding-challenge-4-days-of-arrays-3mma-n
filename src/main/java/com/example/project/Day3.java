package com.example.project;

public class Day3 {
    public static String[][] generateSnowflake(int size) { //you will be tested on this method
        String[][] grid = new String[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }

        int middleIDX = size / 2;
        for (int i = 0; i < size; i++) {
            if (i == middleIDX) {
                for (int j = 0; j < size; j++) {
                    grid[i][j] = "*";
                }
            } else {
                int distToMid = Math.abs(i - middleIDX);
                grid[i][middleIDX] = "*";
                grid[i][middleIDX - distToMid] = "*";
                grid[i][middleIDX + distToMid] = "*";
                }
            }
        return grid;
    }

    // Prints the snowflake  will be useful if tests fail (you will not be tested on this method)
    public static void printSnowflake(String[][] snowflake) {
        for(int i = 0; i < snowflake.length; i++) {
            for (int j = 0; j < snowflake[i].length; j++) {
                System.out.print(snowflake[i][j]);
            }
            System.out.println();
        }
    }

    // Test for the snowflake generation
    public static void main(String[] args) {
        printSnowflake(generateSnowflake(11));
    }
}
