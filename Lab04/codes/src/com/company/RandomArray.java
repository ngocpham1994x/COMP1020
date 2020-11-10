package com.company;

/**
 * A class for rectangular arrays full of random
 * positive integers.
 */

public class RandomArray {
    
  //An instance variable to hold an array of integers
  private int[][] arr;
  private int rowNum;
  private int colNum;
  
  public RandomArray(int rows, int cols, int range) { 
    /* Construct a random array with the given number of
     * rows and columns, filled with random integers in 
     * the range  0..range-1.
     * Use the expression (int)(range*Math.random())
     */
    arr = new int[rows][cols];
    rowNum = rows;
    colNum = cols;
    int rand;

    for(int i=0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        rand = (int) (range * Math.random());   // [0, range-1)
        arr[i][j] = rand;
      }
    }


  }//constructor

  public int[] getRow(int r){
    //Return a copy (clone) of row r of the array
    int[] rowArr = new int[colNum];
    if(r < rowNum) {
      System.arraycopy(arr[r], 0, rowArr, 0, arr[r].length);
      return rowArr;
    }
    else
      return null;



  }//getRow method
  
  public int[] getCol(int c){
    //Return an int[] array containing the numbers from column c.

    int[] colArr = new int[rowNum];
    for (int i =0; i < arr.length; i++) {   // for each row of the column
        colArr[i] = arr[i][c];     // take a num of that row at the column position, and fill to new array
    }
    return colArr;

  }//getCol method


}//RandomArray class
