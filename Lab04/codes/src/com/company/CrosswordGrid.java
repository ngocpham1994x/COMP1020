package com.company;

/**
 * A class that will generate a blank "grid"
 * for a crossword puzzle, with the numbers
 * for the across and down words, and a pattern
 * of black and white squares read in from a
 * text file. The text file must contain:
 *    the number of rows (r)
 *    the number of columns (c)
 *    r*c integers with -1 for a black square
 *        and 0 for a white one.
 * Small example:
 *    4  4
 *    -1  0  0 -1
 *     0  0  0  0
 *     0  0  0  0
 *    -1  0  0 -1
 */
import java.util.Scanner; //For reading in the integers in the file
import java.io.*;         //For reading from files
import javax.swing.*;     //For the dialog box
import javax.swing.filechooser.FileNameExtensionFilter; //To restrict to text files

public class CrosswordGrid {
  
  //The array to hold the representation of the grid
  // -1=black   0=white  1..=white with a number in it
  int[][] grid;
  
  //The constructor
  public CrosswordGrid() { 
    Scanner inFile = getScannerFromFile(); //Set up a Scanner to read from a text file.

    //create a crossword based on given txt template
    int rowNum = inFile.nextInt();
    int colNum = inFile.nextInt();

    grid = new int[rowNum][colNum];


    //fill in the newborn crossword with 0s and (-1)s, aka color the box
    for(int i=0; i<grid.length;i++){
      for(int j=0; j< grid[i].length; j++){
        grid[i][j] = inFile.nextInt();
      }
    }



    putInNumbers(); //Put the numbers in the grid
  }//constructor
  
  private void putInNumbers(){
    /* Put numbers in some of the white squares in the grid,
     * so that the across and down clues can be given. This
     * is done by changing 0's to the proper clue number.
     */

    int inNum = 1;

    for(int i=0; i<grid.length;i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if(grid[i][j] == 0) {

          // An empty square should get a number if
          // it is in the top row, or it is in the leftmost column.
          if(i==0 || j==0) {
            grid[i][j] = inNum;
            inNum++;  // incrementing the fill-in number
          }

          // An empty square should get a number if there is
          // a black square immediately to the left of it,
          // or a black square immediately above it
          if (i > 0 && j > 0)
            if(grid[i][j-1] == -1 || grid[i - 1][j] == -1) {
            grid[i][j] = inNum;
            inNum++;  // incrementing the fill-in number
          }


        }

      }  // for-loop of column
    } // for-loop of row


  }//putInNumbers
  
  private Scanner getScannerFromFile() {
    /* Open a file selected by the user which should be in
     * the format described at the top of the file. It will
     * create and return a suitable Scanner to read that file.
     */
    Scanner inFile = null;
    try {
      File file = openInputFile();
      if(file==null) System.exit(0);
      inFile = new Scanner(file);
    }
    catch(Exception e) {
      System.out.println("Couldn't create the Scanner. Bailing!");
      System.exit(0);
    }
    return inFile;
  }//getScannerFromFile
  
  public void draw() {
    /* Use the StdDraw window to draw the crossword grid in
     * graphical form.
     */
    for(int row=0; row<grid.length; row++){
      for(int col=0; col<grid[0].length; col++){
        if(grid[row][col]== -1)
          //Draw a black square
          StdDraw.filledRectangle((2*col+1)/(2.0*grid[0].length),  
                                  1.0-(2*row+1)/(2.0*grid.length),  
                                  1.0/(2.0*grid[0].length),  
                                  1.0/(2.0*grid.length));
        else {
          //Draw a white square
          StdDraw.rectangle((2*col+1)/(2.0*grid[0].length),  
                                  1.0-(2*row+1)/(2.0*grid.length),  
                                  1.0/(2.0*grid[0].length),  
                                  1.0/(2.0*grid.length));
          if(grid[row][col]!=0)
            //Draw a number in the square if one exists
            StdDraw.text((2*col+1)/(2.0*grid[0].length)-(1.0/(4.0*grid[0].length)),  
                                  1.0-(2*row+1)/(2.0*grid.length)+(1.0/(4.0*grid.length)),  
                         Integer.toString(grid[row][col]));
        }//else (white square)
      }//for col
    }//for row
  }//draw
  
  public static File openInputFile() {
    /* A utility method that will open a text file from the
     * current directory using a standard dialog box provided
     * by the swing class.
     */
    try {
      JFileChooser choose = new JFileChooser("."); //current directory
      FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
      choose.setFileFilter(filter);
      int result = choose.showOpenDialog(null); //Standard file open dialog
      if(result!=JFileChooser.APPROVE_OPTION){
        JOptionPane.showMessageDialog(null,"File selection cancelled.");
        return null;
      }//if
      File f = choose.getSelectedFile(); //Open up the file, or at least try to.
      if(!f.exists()){
        JOptionPane.showMessageDialog(null,"Can't find that file.");
        return null;
      }//if
      return f;
    }//try
    catch(Exception e) {
      System.out.println("I couldn't open the file for some reason.");
      return null;
    }//catch
  }//openInputFile
}//CrosswordGrid
