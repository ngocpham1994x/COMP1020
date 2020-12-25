/* Template
 * Lab 11 Gold Exercise
 * COMP 1020
 */
import java.util.ArrayList;

public class TemplateLab11Gold {
  
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
    System.out.println("Original list (should be unchanged): \n"+test);
  }//main
  
  
  public static void printInOrder(ArrayList<Integer> data){
    //Print out the elements of the ArrayList in ascending order
    //The ArrayList must not be altered at any time, and no
    //temporary arrays, ArrayLists, linked lists, etc. may be used.
    
  }//printInOrder
  
}//TemplateLab11Gold
