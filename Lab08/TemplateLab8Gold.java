import java.util.ArrayList;

/**
 * Template
 * Lab 8 Gold Exercise
 * COMP 1020 Winter 2015
 */
public class TemplateLab8Gold {
  
  public static void main(String[] args){
    //Set up some sort of nested ArrayList structure
    ArrayList test = new ArrayList();
    ArrayList one = new ArrayList();
    ArrayList two = new ArrayList();
    ArrayList three = new ArrayList();
    ArrayList four = new ArrayList();
    test.add(23);
    one.add(19);
    one.add(46);
    test.add(one);
    test.add("Hello");
    two.add(45.5);
    two.add("World");
    two.add(three);
    test.add(two);
    three.add(11);
    three.add(22);
    four.add(33);
    three.add(four);
    System.out.println("The nested ArrayList is: "+test);
    
    //Flatten it and print the result
    System.out.println("The flattened ArrayList is: "+flatten(test));
    
  }//main
  
  public static ArrayList flatten(ArrayList a){
    return a; //Dummy - remove
  }
  
}//TemplateLab8Gold
