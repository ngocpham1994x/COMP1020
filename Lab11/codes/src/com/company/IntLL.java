package com.company;
/* Template - class IntLL
 * Lab 11 Silver Exercise
 * COMP 1020
 */

//A class that implements a simple linear linked
//list containing integer data.
public class IntLL {
  
  private Node top; //The only instance variable
  
  public IntLL() { 
    top = null;
  }//Constructor
  
  public void add(int newData){
    //Add a new node to the front of the list.
    top = new Node(newData, top);
  }
  
  /* Perform a selection sort on a simple linked list.
   * This uses the largestPrev() method below.
   */
  public void selSort(){
    for(Node next = top; next!=null; next = next.getLink())
      //Find the smallest number from a[k] to a[n-1]
      Node min = largestPrev(); //The smallest number
      int where = k; //it was found in a[where]
      for (int i = k+1; i < a.length; i++) {
        if (a[i] < min) { //a new champion min!
          min = a[i];
          where = i;
        }
      }
      //Swap a[k] and min, which was found in a[where]
      a[where] = a[k];
      a[k] = min;
    }//for

  }//selSort
  
  public Node largestPrev(){
    /* Return a reference to the Node *before* the
     * one containing the largest data value. If
     * the first node contains the largest value,
     * null will be returned. A non-empty list is assumed.
     */
    int maxFound = top.getData();
    Node prevFound = null;
    //Search from the second node, keeping track of the previous node.
    Node prev = top;
    Node next = top.getLink();
    while(next!=null){
      //Check for a new champion
      if(next.getData()>maxFound){
        maxFound = next.getData();
        prevFound = prev;
      }
      //Advance the pointers
      prev = next;
      next = next.getLink();
    }
    return prevFound;  
  }
  
  public String toString(){
    String answer = "<<";
    for(Node next = top; next!=null; next = next.getLink())
      answer += " "+next.getData()+" ";
    return answer+">>";
  }//toString
  
}
