package com.example.project;

public class FunExtraThing {

    public static String[][] nameSort(String[] names, int numLists, int min, int max) {
        System.out.println(numLists + " " + max + " " + names.length);
        if (min * numLists > names.length) {
            throw new IllegalArgumentException("The fewest possible items that can be sorted into " + numLists + 
            " lists with a min size of " + min + " is " + (min * numLists) + " <Entered " + names.length + ">");
        } else if (min > max) {
            throw new IllegalArgumentException("The minimum list length cannot be greater than the max <" + min + " is greater than " + max + ">");
        } else if (numLists * max < names.length) {
            throw new IllegalArgumentException("The most possible items that can be sorted into " + numLists + 
            " lists with a max size of " + max + " is " + (max * numLists) + " <Entered " + names.length + ">");
        }
        int[] assignments = new int[names.length];
        int[] numEach = new int[numLists];
        String[][] fullList = new String[numLists][names.length];
        for (int i = 0; i < numLists; i++) {
            for (int j = 0; j < min; j++) {
                int idx = (int) (Math.random() * names.length);
                while (names[idx] == null) {
                    idx = (int) (Math.random() * names.length);
                }
                fullList[i][j] = names[idx];
                names[idx] = null;
            }
            numEach[i] = min;
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                int randVal = (int) (Math.random() * numLists);
                while(numEach[randVal] >= max) {
                    randVal = (int) (Math.random() * numLists);
                }
                numEach[randVal]++;
                fullList[randVal][i] = names[i];
                assignments[i] = randVal;
            }
        }

        // for (int i = 0; i < numLists; i++) {
        //     while (numEach[i] < min) {
        //         int randVal = (int) (Math.random() * names.length);
        //         while (numEach[assignments[randVal]] <= min) {
        //             randVal = (int) (Math.random() * names.length);
        //         }
        //         fullList[i][randVal] = fullList[assignments[randVal]][randVal];
        //         fullList[assignments[randVal]][randVal] = null;
        //         numEach[i]++;
        //         numEach[assignments[randVal]]--;

                
        //         // int randVal = (int) (Math.random() * numLists);
        //         // while (numEach[randVal] <= min) {
        //         //     randVal = (int) (Math.random() * numLists);
        //         // }

        //         // int randTwo = (int) (Math.random() * names.length);
        //         // while (fullList[randVal][]) {
        //         //     randTwo = (int) (Math.random() * names.length);
        //         // }
        //     }
        // }

        for (int i = 0; i < numLists; i++) {
            System.out.print(numEach[i] + " ");
        }

        for (int i = 0; i < numLists; i++) {
            String[] shortVer = new String[numEach[i]];
            int numAdded = 0;
            for (int j = 0; j < names.length; j++) {
                if (fullList[i][j] != null) {
                    System.out.print(numAdded + " ");
                    shortVer[numAdded] = fullList[i][j];
                    numAdded++;
                }
            }
            System.out.println();
            fullList[i] = shortVer;
        }
        return fullList;
    }

    public static void main(String[] args) {
        //Two dimensional array basics

        // Array Intialised and Assigned
        // String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] names = new String[100];
        for (int i = 0; i < names.length; i++) {
            names[i] = "" + (10 + i);
        }
        String[][] arr = nameSort(names, 20, 4, 100);

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