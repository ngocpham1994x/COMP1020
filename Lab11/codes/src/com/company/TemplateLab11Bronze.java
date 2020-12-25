package com.company;

/* Template
 * Lab 11 Bronze Exercise
 * COMP 1020
 */
import java.util.ArrayList;

public class TemplateLab11Bronze {
  
  //Constants controlling the random test data
  static final int LIST_SIZE = 20;
  static final int MAX_NUMBER = 50;
  
  public static void main(String[] args) {
    //Create a random list of integers
    ArrayList<Integer> test = new ArrayList<Integer>();
    for(int i=0; i<LIST_SIZE; i++)
      test.add((int)(Math.random()*MAX_NUMBER));
    //Print the list, before and after testing the
    //printInOrder method.
    System.out.println("Original list: \n"+test);
    System.out.println("Print the list in ascending order:");
    printInOrder(test);
    System.out.println("Original list (should be empty): \n"+test);
  }//main
  
  
  public static void printInOrder(ArrayList<Integer> data){
    //Print out the elements of the ArrayList in ascending order
    //The ArrayList will be destroyed in the process, becoming empty.
    String s = "";

    for(int k=0; k<=data.size()-2; k++) {
      //Find the smallest number from data[k] to data[n-1]
      int min = data.get(k); //The smallest number
      int where = k; //it was found in data[where]
      for (int i = k+1; i < data.size(); i++) {
        if (data.get(i) < min) { //a new champion min!
          min = data.get(i);
          where = i;
        }
      }
      //Swap data[k] and min, which was found in data[where]
      data.set(where,data.get(k));
      data.set(k,min);
    }//for


    while(data.size()>0){
      s += data.remove(0) + " ";
    }

    System.out.println(s);

  }//printInOrder

}//TemplateLab11Bronze
