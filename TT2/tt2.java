package com.company;

import java.io.*;

public class tt2 {

    public static void parseFile(String filename, char theChar) {

        try{
            //Open a file using FileReader
            FileReader fileRdr = new FileReader(filename);

            //Open a BufferedReader.
            BufferedReader inFile = new BufferedReader(fileRdr);

            final int MAX_WORD = 100;
            int size = 0;
            String line;
            String[][] words = new String[MAX_WORD][];  //row = line, words = columns

            //read line-by-line, each line is a row of array words[line][theWord]
            while((line = inFile.readLine()) != null)
            {
                words[size++] = line.split(" ");  //split words by space
            }

            //select the words that end with theChar
            for (int i=0; i < size; i++){
                for(int j=0; j < words[i].length; j++){
                    int lastCharPosition =  words[i][j].length() - 1;       //index of last char in the word
                    if (words[i][j].charAt(lastCharPosition) == theChar)    //compare theChar vs the last char of the word
                        System.out.println(words[i][j]);                    //if true then print the word to console
                }
            }


            inFile.close();

        }
        catch (IOException e) {
            System.out.println("We have IO Exception");
            e.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("We have an Exception");
            ex.printStackTrace();
        }

    }

}



