package com.company;


/**
 * A class that will generate magic squares of
 * odd order using de la Loubere's algorithm.
 */
public class MagicSquare {
  
  //An array to hold the magic square
  private int [][] magicSquare;
  private int rowNum, colNum;
  private int currentRow, currentCol;


  public MagicSquare(int n) { 
    /* Construct a magic square of order n
     * (n rows and columns containing numbers
     * from 1 to n*n).
     */
    magicSquare = new int[n][n];
    rowNum = n;
    colNum = n;
    currentRow = rowNum-1;
    currentCol = colNum/2;


    //Place the numbers in the square in order, from 1 to n^2, starting with the 1
    // placing 1 in the centre of the bottom row


    for (int i=1; i < n*n+1; i++){
      //placing the number
      magicSquare[currentRow][currentCol] = i;

      //If the number you just placed is divisible by n, then the next one goes immediately above it
      //example: at row 3, number is 5, which % 5 (if n=5). Next num is 6, will be located on row 2, same column
      //row 2 is calculated as = (3+5-1)%5 = 2

      if(i % n ==0){
        currentRow = (currentRow + n -1) % n;
        currentCol = currentCol;
      }

      //If the number you just placed is not divisible by n, then the next one goes diagonally down and to the right
      //If you go off the top of the square, reenter at the bottom. If you go off the bottom of the square, re-enter at the top.
      //example: at row 4, cant go down, wrap back to row 0 by (4+1)%5 = 0 - same for column

      else {
        currentRow = ((currentRow + 1) % n) ;
        currentCol = ((currentCol + 1) % n) ;
      }



    }


  } //constructor
  
  public String toString(){
    /* Return a String allowing the square to be
     * printed. Rows are separated by \n and columns
     * are separated by \t characters.
     */

    String s = "";
    for (int i = 0; i < magicSquare.length;i++){
      for (int j = 0; j < magicSquare[i].length; j++){
        s += magicSquare[i][j] + "\t";
      }
      s += "\n";
    }

    return s;

  }//toString
  
}//MagicSquare class
