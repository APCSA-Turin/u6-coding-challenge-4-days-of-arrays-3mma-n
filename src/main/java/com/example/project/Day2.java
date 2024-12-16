
package com.example.project;
import java.util.Random;

public class Day2{
    public static String[][] nameSort(String[] names){ // your will be tested on this method
        boolean[] assignments = new boolean[names.length];
        String[] niceList = new String[names.length];
        String[] naughtyList = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (Math.random() < 0.5) {
                niceList[i] = names[i];
            } else {
                naughtyList[i] = names[i];
            }
        }
        String[][] combinedList = {niceList, naughtyList};
        return combinedList;

        // int niceNum = 0;
        // int naughtyNum = 0;
        // for (int i = 0; i < names.length; i++) {
        //     if (Math.random() < 0.5) {
        //         assignments[i] = true;
        //         niceNum += 1;
        //     } else {
        //         assignments[i] = false;
        //         naughtyNum += 1;
        //     }
        // }

        // String[] niceList = new String[niceNum];
        // String[] naughtyList = new String[naughtyNum];
        // int nextNiceIDX = 0;
        // int nextNaughtyIDX = 0;
        // for (int i = 0; i < names.length; i++) {
        //     if (assignments[i]) {
        //         niceList[nextNiceIDX] = names[i];
        //         nextNiceIDX++;
        //     } else {
        //         naughtyList[nextNaughtyIDX] = names[i];
        //         nextNaughtyIDX++;
        //     }
        // }
        // String[][] combinedList = {niceList, naughtyList};
        // return combinedList;
    }

    public static void main(String[] args) {
        //Two dimensional array basics

        // Array Intialised and Assigned
        String[] names = {"A", "B", "C", "D", "E"};
        String[][] arr = nameSort(names);

        // Printing the Array
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}