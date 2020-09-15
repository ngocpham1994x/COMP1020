/**
 * Template
 * COMP 1020 
 * Lab 5 Gold Exercise
 */
public class TemplateLab5Gold {
  
  static final int INIT_SIZE = 2; //The initial capacity of the list of integers
  static final int MAX_SIZE = 16; //The maximum allowed capacity
  static int[] intArray = new int[INIT_SIZE]; //The integers in the list
  static int numElements = 0; //The number of elements currently in the list
  
  public static void main(String[] args) {
    for(int i=1; i<=20; i++) {
      addElement(i);
      System.out.println("element "+i+" added");
    }
  }//main
  
  public static void addElement(int newData) {
    insertIntoArray(newData);
  }//addElement
  
  public static void expandArray() {
    int[] biggerArray = new int[2*intArray.length];
    System.arraycopy(intArray,0,biggerArray,0,intArray.length);
    intArray = biggerArray;
  }//expandArray
  
  public static void insertIntoArray(int newElement) {
    intArray[numElements] = newElement;
    numElements++;
  }//appendElement
  
}//TemplateLab5Gold



//-----A separate class to create a customized type of Exception for this program -----

class TooFullException extends RuntimeException {
  public TooFullException(String s){
    super(s);
  }//constructor
}//TooFullException