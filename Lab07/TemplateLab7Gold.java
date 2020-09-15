import java.util.Scanner;

/**
 * Create and perform some simple processing on a
 * list of Data objects which is a mixture of
 * Single and List and other Objects
 */
public class TemplateLab7Gold {
  
  public static void main(String[] args) { 
    
    //Changed for the Gold exercise
    Object[] mixedData = {
      new Single(2.4),
      "The data is 3.6",
      new List(new double[] {3.2,6.8}),
      "Nothing here at all",
      new Boolean(false), //What's he doing here?
      new List(new double[] {1.2,7.9,4.5}),
      "Anda 1 anda 2 anda 3",
      new Single(9.8) };
    
    //Call your new method first.
    Data[] myData = convert(mixedData);
    
    //***** YOUR BRONZE CODE HERE *****

    
    //***** YOUR SILVER CODE HERE *****

    
  }//main
  

  public static Data[] convert(Object[] objects){
    final int MAX_LIST_SIZE = 10;
  //***** YOUR GOLD CODE HERE *****
    return null; //Dummy statement - replace it
  }//convert
  
}//TemplateLab7Gold
