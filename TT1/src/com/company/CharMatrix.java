package com.company;

public class CharMatrix {
    //instance variable
    private char[][] matrix;

    //constructors
    public CharMatrix(int nbRows, int nbCols){
        matrix = new char[nbRows][nbCols];
    }

    public CharMatrix(int nbRows, int nbCols, char c){
        matrix = new char[nbRows][nbCols];
    }


    public void fillOtherRow(char c, char x){
        for(int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = c;   //c is "-", fill all matrix with "-"
                if(i%2 != 0){   // access even rows
                    matrix[i][0] = x;  // fill the first column with x
                    if(j%3 == 0)
                        matrix[i][j] = x;   // access columns that divisible to 3, fill with x
                }
            }
        }
    }


    public String toString(){
        String mat = "";
        for(int i=0; i < matrix.length; i++){
            for (int j=0; j < matrix[i].length; j++)
                mat += matrix[i][j] + " " ;
            mat += "\n";
        }
        return mat;
    }

}



    public static void modify(int[][] matrix) {
    for(int i=1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[i].length; j++){
            matrix[i][j] = matrix[i][j-1] * matrix[i-1][j] / matrix[i-1][j-1];   //current cell = left column * above row / left diagonal
        }
    }
    }


    public void clone(){

        MyComputer newComp =  new MyComputer;
        newComp.numProcessors = this.numProcessors;
        newComp.brandName = this.brandName;
        newComp.memorySlots= this.memorySlots;

        System.arraycopy (this.memorySlots, 0, newComp.memorySlots, 0, this.memorySlots.length);

        return newComp;



        Person newPerson = new Person();
        newPerson.name = this.name;   // "this" is not necessary
        newPerson.age = this.age;     // "this" is not necessary
        return newPerson;




    } // end clone

