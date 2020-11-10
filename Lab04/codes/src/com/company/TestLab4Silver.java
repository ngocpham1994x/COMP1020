package com.company;

/**
 * Lab 4 COMP 1020 Fall 2016
 * This file will test the
 * MagicSquare class.
 */
import java.util.Scanner;

public class TestLab4Silver {
  
  public static void main(String[] args) { 
    Scanner keyboard = new Scanner(System.in);
    
    int n; //The order of the desired magic square
    do {
      System.out.print("Enter a small odd number, or 0 to quit:");
      n = keyboard.nextInt();
      if(n!=0) {
        MagicSquare ms = new MagicSquare(n);
        System.out.println("\nThe magic square is:\n"+ms);
      }//if
    } while(n!=0);
    System.out.println("That was fun. Bye!");
  }//main
  
}//TestLab4Silver
