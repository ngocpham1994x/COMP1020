package com.company;

/**
 Name: Ngoc Pham
 Student number: 7891063
 **/

import java.util.*;

public class Lab1Gold {

    public static void main(String[] args) {
        int[] myArray = new int[100];
        int numberRead = readData(myArray);          // read valid entries
        double avg = average(myArray,numberRead);    // average of valid entries only
        double med = median(myArray,numberRead);     // median of valid entries only
        //and print out the result that was returned
        System.out.println(numberRead + " valid entries were read in.");
        printArray(myArray,numberRead);              // print out array of valid entry only
        System.out.println("Their average is " + avg);
        System.out.println("Their median is " + med);
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
        int x = 0;      //keyboard entry value

        while (true) {
            System.out.println("Enter an integer from 1 to 100 (0 to quit): ");
            x = keyboard.nextInt();
            if (1 <= x && x <= 100) {
                System.out.println("Entry " + x + " accepted");
                a[count] = x;    //append valid entries to array
                count++;
            }
            if (x == 0)
                break;
            if (x < 0 || x > 100)
                System.out.println("Invalid entry rejected");
        }
//        Arrays.sort(a);

        // sorting array within valid number of entries only
        int temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }   // output:    # # # # # 0 0 0 0 0 0 0 .....

//        // test print array 100 elements
//        for (int element : a)
//            System.out.println(element);

        keyboard.close();

        return count;

    }//readData

    static void printArray(int[] a, int n) {
        /* This method takes in account of valid entries only.
         * The method will create a new array of valid entry, using size as is propagated from readData() method.
         * The method will create a new array of valid entry, using size as is propagated from readData() method.
         * Then print out the valid entries array, separated by comma.
         * Last entry will have no comma.
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
    } //printArray

    static double average(int[] a, int n) {
        /* This method calculates the average of valid entries.
         */

        double avg, total = 0;       // total is default as double
        for (int i = 0; i < a.length; i++)
            total += a[i];           // sum of valid integer entries is a double
        avg = total / n;

        return avg;
    } //average

    static double median(int[] a, int n){
        /*
         * This method calculate the median of valid-entries array.
         * If number of valid entries is odd, median is the middle value.
         * If number of valid entries is even, median is the average of the two middle values.
         */

        double med = 0;
//        // median method using if statements
//        for (int i = 0; i < n; i++){
//            if (n % 2 == 1)
//                med = a[n/2];
//            if (n % 2 == 0)
//                med = ((double)(a[n/2] + a[n/2-1]))/2;    // conversion/casting int to double
//        }

        // median method using 1 line of code
        return med = (1 == n % 2) ? a[n/2] : ((double)(a[n/2] + a[n/2-1]))/2;
    } //median
}// Gold ends

