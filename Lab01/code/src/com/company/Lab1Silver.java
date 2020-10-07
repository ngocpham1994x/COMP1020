package com.company;

/**
 * Template
 * Lab 1 Silver exercise
 * COMP 1020
 */


/**
*Student: Ngoc Pham
 * Student number: 7891063
 * COMP 1020
*/

import java.util.*;

public class Lab1Silver {

    public static void main(String[] args) {
        int[] myArray = new int[100];
        int numberRead = readData(myArray);          // read valid entries
        double avg = average(myArray,numberRead);    // average valid entries only
        //and print out the result that was returned
        System.out.println(numberRead + " valid entries were read in.");
        printArray(myArray,numberRead);              // print out array of valid entry only
        System.out.println("Their average is " + avg);
    }//main

    static int readData(int[] a) {
        /* Prompt the user to enter integer values, one at a time.
         * Values between 1 and 100 are valid. They will be accepted,
         * and echoed in a suitable message. A value of 0 will
         * cause the method to terminate. All other values will
         * cause an error message to be printed. The number of valid
         * values entered (1-100, but not 0) will be returned.
         */
        Scanner keyboard = new Scanner(System.in);

        //**********YOUR CODE HERE******************
        int count = 0;  // count valid inputs
        int x = 0;

        while (true) {
            System.out.println("Enter an integer from 1 to 100 (0 to quit): ");
            x = keyboard.nextInt();
            if (1 <= x && x <= 100) {
                System.out.println("Entry " + x + " accepted");
                a[count] = x;
                count++;
            }
                if (x == 0)
                    break;
                if (x < 0 || x > 100)
                    System.out.println("Invalid entry rejected");
        }

        keyboard.close();

        return count;

    }//readData

    static void printArray(int[] a, int n) {
        /* This method takes in account of valid entries only.
        The method will create a new array of valid entry, using size as is propagated from readData() method.
        The method will create a new array of valid entry, using size as is propagated from readData() method.
        Then print out the valid entries array, separated by comma.
        Last entry will have no comma.
         */


        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = a[i];
            if(i < n-1)
                System.out.print(array1[i] + ",");
            if (i == n-1)
                System.out.print(array1[i]);
        }
        System.out.println(); // to new line
    }

    static double average(int[] a, int n) {
        /*
        */

        double avg, total = 0;
        for (int i = 0; i < a.length; i++)
            total += a[i];
        avg = total / n;

        return avg;
    }

}//Silver ends

