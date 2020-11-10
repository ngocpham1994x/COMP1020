package com.company;

/**
 * Template
 * COMP 1020
 * Lab 5 Bronze Exercise
 */
import java.io.*; //Required for most I/O operations

public class TemplateLab5Bronze {
  
  static final String INPUT_FILE = "testLab5Bronze.txt";
  static final String OUTPUT_FILE = "outputLab5Bronze.txt";

  public static void main(String[] args) {
    try{
      //Open a file using FileReader
      FileReader fileRdr = new FileReader(INPUT_FILE);

      //Open a BufferedReader.
      BufferedReader inFile = new BufferedReader(fileRdr);

      //Create new file or append to existing file
      PrintWriter outFile = new PrintWriter(new FileWriter(OUTPUT_FILE));


      String line;
      int count = 1;
      while((line = inFile.readLine()) != null)
      {
        outFile.println(count + ": " + line);
        count++;
      }
      inFile.close();
      outFile.close();

    }
    catch (IOException e) {
      System.out.println("We have IO Exception");
      e.printStackTrace();
    }
    catch (Exception ex) {
      System.out.println("We have an Exception");
      ex.printStackTrace();
    }


  }//main
  
}//end TemplateLab5Bronze
