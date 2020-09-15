/* Test Program
 * Lab 11 Silver Exercise
 * COMP 1020
 */
public class TestLab11Silver {
  
  //Constants controlling the random test data
  static final int LIST_SIZE = 20;
  static final int MAX_NUMBER = 50;
  
  public static void main(String[] args) { 
    //Create a random list of integers
    IntLL test = new IntLL();
    for(int i=0; i<LIST_SIZE; i++)
      test.add((int)(Math.random()*MAX_NUMBER));
    System.out.println("Original list: \n"+test);
    test.selSort();
    System.out.println("Sorted list: \n"+test);
  }//main

}//TestLab11Silver
