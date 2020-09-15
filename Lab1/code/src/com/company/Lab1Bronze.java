package com.company;

/**
 * Template
 * Lab 1 Bronze exercise
 * COMP 1020
 */
import java.util.Scanner; //Allows the use of Scanner input

public class Lab1Bronze {
    public static void main(String[] args) {
        //Call the readData() method to test it,
        int numberRead = readData();
        //and print out the result that was returned.
        System.out.println(numberRead+" valid entries were read in.");
    }//main

    static int readData() {
        /* Prompt the user to enter integer values, one at a time.
         * Values between 1 and 100 are valid. They will be accepted,
         * and echoed in a suitable message. A value of 0 will
         * cause the method to terminate. All other values will
         * cause an error message to be printed. The number of valid
         * values entered (1-100, but not 0) will be returned.
         */
        Scanner keyboard = new Scanner(System.in);

        //**********YOUR CODE HERE******************
        int count = 0;
        int x;
        while ((x= keyboard.nextInt()) != 0){     //or while (true) then input token after
            System.out.println("Enter an integer from 1 to 100 (0 to quit): "+ x);
            if (1<=x && x<=100){
                System.out.println("Entry " + x + " accepted");
                count++;
            }
            if (x==0)
                break;
            if (x<1 || x>100)
                System.out.println("Invalid entry rejected");
        }
        keyboard.close();
        return count;

    }//readData

}//TemplateLab1Bronze
