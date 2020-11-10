package com.company;

/**
 * Template
 * COMP 1020
 * Lab 5 Silver Exercise
 */
import java.io.*; //Required for most I/O operations
import java.util.Scanner;

public class TemplateLab5Silver {

  static final String INPUT_FILE = "Lab5SilverTest.java";
  static final String OUTPUT_FILE = "Lab5SilverOutput.java";
  
  public static void main(String[] args) {
    
    final int INDENT_AMOUNT = 5;
    
    //***COMPLETE THE MAIN METHOD***
    try{
      //Open a file using FileReader
      FileReader fileRdr = new FileReader(INPUT_FILE);

      //Open a BufferedReader.
      BufferedReader inFile = new BufferedReader(fileRdr);

      //Create new file or append to existing file
      PrintWriter outFile = new PrintWriter(new FileWriter(OUTPUT_FILE));



      String line;
      int lineCount = 1;
      int indentVal = 0;
      while((line = inFile.readLine()) != null)
      {
        line = blanks(indentVal) + line.trim(); //line structure, indentVal is taken from previous execution of while()

        if (lineCount == 1)
          indentVal = 0;
        if (line.contains("{"))
          indentVal += INDENT_AMOUNT;
        if (line.contains("}")) {
          indentVal -= INDENT_AMOUNT;
          line = blanks(indentVal) + line.trim();  //overwrite line structure after calculating indentVal, if the character is "}"
        }

        outFile.println(line);
        lineCount++;


      } // end while

      inFile.close();
      outFile.close();

    }// end try
    catch (IOException e) {
      System.out.println("We have IO Exception");
      e.printStackTrace();
    }
    catch (Exception ex) {
      System.out.println("We have an Exception");
      ex.printStackTrace();
    }
    
  }//main
  
  public static String blanks(int n){
    String result = "";
    for(int i=0; i<n; i++)
      result+= " ";
    return result;
  }//blanks
  
}//TemplateLab5Silver

