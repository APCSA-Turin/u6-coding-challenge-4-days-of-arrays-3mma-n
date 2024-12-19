package com.example.project;

public class FunExtraThing {

    public static String[][] nameSort(String[] names, int numLists, int min, int max){ // your will be tested on this method
        if (numLists * max < names.length) {
            throw new IllegalArgumentException("The most possible items that can be sorted into " + numLists + 
            " lists with a max size of " + max + " is " + (max * numLists) + " <Entered " + names.length + ">");
        }
        int[] assignments = new int[names.length];
        int[] numEach = new int[numLists];
        String[][] fullList = new String[numLists][names.length];

        for (int i = 0; i < names.length; i++) {
            int randVal = (int) (Math.random() * numLists);
            while(numEach[randVal] >= max) {
                randVal = (int) (Math.random() * numLists);
            }
            numEach[randVal]++;
            fullList[randVal][i] = names[i];
            assignments[i] = randVal;
        }

        for (int i = 0; i < numLists; i++) {
            System.out.println();
            while (numEach[i] < min) {
                int randVal = (int) (Math.random() * names.length);
                while (fullList[assignments[randVal]].length <= min) {
                    randVal = (int) (Math.random() * names.length);
                }
                fullList[i][randVal] = fullList[assignments[randVal]][randVal];
                fullList[assignments[randVal]][randVal] = null;
                numEach[i]++;
                numEach[assignments[randVal]]--;

                
                // int randVal = (int) (Math.random() * numLists);
                // while (numEach[randVal] <= min) {
                //     randVal = (int) (Math.random() * numLists);
                // }

                // int randTwo = (int) (Math.random() * names.length);
                // while (fullList[randVal][]) {
                //     randTwo = (int) (Math.random() * names.length);
                // }
            }
        }

        for (int i = 0; i < numLists; i++) {
            String[] shortVer = new String[numEach[i]];
            int numAdded = 0;
            for (int j = 0; j < names.length; j++) {
                if (fullList[i][j] != null) {
                    shortVer[numAdded] = fullList[i][j];
                    numAdded++;
                }
            }
            fullList[i] = shortVer;
        }
        return fullList;
    }

    public static void main(String[] args) {
        //Two dimensional array basics

        // Array Intialised and Assigned
        // String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] names = new String[90];
        for (int i = 0; i < names.length; i++) {
            names[i] = "" + (10 + i);
        }
        String[][] arr = nameSort(names, 20, 3, 7);

        // Printing the Array
        for (int i = 0; i < arr.length; i++){
            System.out.print("List " + (i + 1) + ": ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}