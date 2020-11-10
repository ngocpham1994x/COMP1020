package com.company;

import com.company.List;

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
    double totalSum = 0;
    int size = 0;

    for (int i=0;i< myData.length;i++){
      System.out.println("Element #" + i + " in myData has the sum is: " + myData[i].valueOf());
      totalSum += myData[i].valueOf();
      if (myData[i] instanceof List)
        size += ((List) myData[i]).length();
      else
        size += 1;
    }

    System.out.println();
    System.out.println("The sum of everything is " + String.format("%.1f",totalSum));

    //***** YOUR SILVER CODE HERE *****
    System.out.println("There are " + size + " values in total");


  }//main
  

  public static Data[] convert(Object[] objects){
    final int MAX_LIST_SIZE = 10;
  //***** YOUR GOLD CODE HERE *****

    Data[] newData = new Data[objects.length];   //shallow copy

    for (int i=0; i < objects.length; i++){

      boolean a = objects[i] instanceof List;
      boolean b = objects[i] instanceof Single;
      boolean c = objects[i] instanceof String;

      if(a == true || b == true){
        newData[i] = (Data) objects[i];
      }

      if ( c ) {
        //scan the string
        Scanner input = new Scanner((String)(objects[i]));

        //prep variables for reading string
        double[] arr = new double[MAX_LIST_SIZE];
        double num = 0;
        int arrSize = 0;

        // adding double to array
        while(input.hasNext()){
          if (input.hasNextDouble()) {
            num = input.nextDouble();
            arr[arrSize++] = num;
          }
          else
            input.next();
        } //end for of adding double-type element to array

        //create array with actual size of double numbers
        double[] actualArr = new double[arrSize];
        System.arraycopy(arr,0,actualArr,0,arrSize);

        //convert actualArr to List. Here is when String becomes List
        List newList = new List(actualArr);   //passing double-type array to List class constructor, create full list object
        newData[i] = (Data)newList;           //adding this new list from String element to newData, technically don't need "(Data)" here

      } //end if of String element

      //any other kind of object to be List with length 0 array
      if(a == false && b == false && c == false){
        List otherKind = new List(new double[0]);
        newData[i] = (Data)otherKind;         //technically don't need "(Data)" here
      }

    }//end for iterating newData

    return newData;
  }//convert
  
}//TemplateLab7Gold
