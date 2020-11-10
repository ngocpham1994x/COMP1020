package com.company;

import java.util.ArrayList;
import java.util.Collection;

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
  
  public static ArrayList flatten(ArrayList a) {
    ArrayList flatArray = new ArrayList();
//    ArrayList current = new ArrayList();

    for (int i = 0; i < a.size(); i++) {
      Object element = (ArrayList) a.get(i);
      if (element.size() > 0) {
//        current = (ArrayList) element;
        flatArray.addAll(element);
      } else
        flatArray.add(element);
    }

    return flatArray;
  }

}//TemplateLab8Gold

//https://rosettacode.org/wiki/Flatten_a_list#Java
//https://www.geeksforgeeks.org/list-addall-method-in-java-with-examples/