package com.company;

/**
 * Create and perform some simple processing on a
 * list of Data objects which is a mixture of
 * Single and List objects
 */
public class TemplateLab7 {

  public static void main(String[] args) {

    Data[] myData = {
      new Single(2.4),
      new List(new double[] {3.2,6.8}),
      new List(new double[] {1.2,7.9,4.5}),
      new Single(9.8)
      };

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
    System.out.println("The sum of everything is " + totalSum);

    //***** YOUR SILVER CODE HERE *****
    System.out.println("There are " + size + " values in total");

  }//main

}//TemplateLab7
