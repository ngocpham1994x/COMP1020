/* *
 * [Board]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [2]
 * QUESTION: [3]
 *
 * PURPOSE: [Create a Othello board instance]
 *
 * I tried my best to complete all phases. Please read my work since I put in lots of effort.. (Thank you!)
 * However, phase 2 test gave me NUllPointerExceptionError boils down to "adjacent" parameter in
 * getAdjacentRowCoor() and  getAdjacentColCoor() methods are null. I could not figure out why.
 * In phase 3, please note that there was a discussion between next-line char is '\r\n' or '\n' on UMLearn,
 * and Prof Ali is aware of that and say don't worry about it. Therefore, I only wrote for testing with '\n'.
 */



/*
a Board class that will handle all of the tasks needed to play a Reversi game.
This includes finding valid moves, making moves, flipping pieces, detecting the end of the game, etc.
But it does not contain any user interface code for actually playing the game.
 */
//package com.company;


import java.io.*;
import java.io.IOException;

/* 1) current state of a Reversi board (which pieces are on the board, and where),
* 2) provide relevant information about that state (e.g. what the valid moves are),
* 3) and change that state (make moves and flip pieces)
 */

public class Board {

    /* instance vars
    * a multidimensional array of int values.
    * The board will always be square, but it may be any size from 2x2 up
     */
    private int[][] othello;
    public static final int EMPTY =0, BLACK =1, WHITE =2;
    private int size;



    /* 1st constructor
    * takes a single int parameter giving the desired size of the board,
    * and sets up the board for the start of a game. There are always 2 black pieces and 2 white pieces
    * in an X pattern in the centre of the board at the start of a game.
    * If the size of the board is an even number, they should be in the exact centre.
    * If the size of the board is an odd number, place them slightly up and to the left since they can't go in the centre.
    * The piece closest to the top left should be a white one.
     */
    public Board(int n){
        if(n>2) {
            size = n;
            othello = new int[n][n];
            for (int i = 0; i < size; i++) {        // iterate through rows
                for (int j = 0; j < size; j++) {    // iterate through columns of a row
                    othello[i][j] = EMPTY;          // give each cell an EMPTY value
                }
            }
        }

        int c = (n/2);  // c =  centre number, i.e: 5/2 = 2, 6/2=3
        othello[c-1][c-1] = WHITE;  //first white: top left, from center
        othello[c][c] = WHITE;      //second white: bottom right, from center
        othello[c-1][c] = BLACK;    //first black: top right, from center
        othello[c][c-1] = BLACK;    //second black: bottom left, from center

    }// end 1st constructor

    /* 2nd constructor
     * create a new Board based on the imported Board setup by calling the
     * importBoardSetup(String fileName) inside your constructor.
     */
    public Board(String fileName){
        try{
            importBoardSetUp(fileName);
        }
        //catch any Exception, custom Exception, IOException
        catch (Exception e) {
            System.out.println( "" + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }


    /* method: toString
    * return a suitable representation of the board.
    * You could use X and O for Black and White
     */
    public String toString(){
        String s = "";
        for (int i = 0; i < size; i++){     // iterate through rows
            for(int j=0; j < size; j++){    // iterate through columns of a row
                if( othello [i][j] == EMPTY)
                    s += ".";
                if( othello [i][j] == WHITE)
                    s += "O";
                if( othello [i][j] == BLACK)
                    s += "X";
            }
            s += "\n";
        }
        return s;
    }



    /*method: opponentOf
    * return the integer representing the other player.
    * So opponentOf(BLACK) should give WHITE, and vice-versa.
    * input type: integer
    * output type: integer
     */
    public static int opponentOf(int player){
        int opponent = EMPTY;
        if( player == BLACK )
            opponent = WHITE;
        if ( player == WHITE)
            opponent = BLACK;
        return opponent;
    }


    /*method: nameOf
    * return a String giving the name of that player. Simply return "Black" or "White".
     */
    public static String nameOf(int player){
        String s = "";
        if (player == BLACK)
            s = "BLACK";
        if (player == WHITE)
            s = "WHITE";
        return s;
    }


    /*method: getScore
    * return the score in the game, which is simply the number of black pieces on the board minus the number of white pieces.
    * A positive number means Black is winning, and a negative number means White is winning.
     */
    public int getScore(){
        int diff = 0;
        int countBLACK = 0, countWHITE =0;
        for (int i = 0; i < size; i++) {        // iterate through rows
            for (int j = 0; j < size; j++) {    // iterate through columns of a row
                if ( othello [i][j] == BLACK)
                    countBLACK++;
                if ( othello [i][j] == WHITE)
                    countWHITE++;
            }
        }
        diff = countBLACK - countWHITE;
        return diff;
    }


    /*method: allValidMoves
     * return a list of all of the valid moves that could be made by the indicated player.
     * a Move object contains a list of all the directions in which opponent's pieces will be flipped.
     * A move is valid if:
     * 1) it is played on an empty square, and
     * 2) it flips at least one of the opponent's pieces.
     * If there are no valid moves, it should return an empty list (not just null).
     *
     * Starting by creating a "MoveList" which contains all valid possible "Moves"
     * iterating through each cell of Othello.
     * If the cell is empty, check for its 8 adjacent cells to verify if this cell is a potential / possible / valid move.
     * a Move object contains a list of all the directions in which opponent's pieces will be flipped.
     * So the 1 of 8 adjacent cells is valid when it holds TRUE for both: isValid and hasOppInBetween (see Helper method #4 for details)
     * once the adjacent is valid, if the adjacent disc's color is the opponent's color,
     * then Finally we can add this adjacent "change coordinate / Direction" to the flipList - the list contains Directions
     * of opponent's disc to be flipped by player.
     * If no adjacent move between 8 adjacent is valid, the "theValidMoveList" will be empty.
     */
    public MoveList allValidMoves(int player) {
        MoveList theValidMovesList = new MoveList();
        for (int i = 0; i < othello.length; i++) {        // iterate through rows
            for (int j = 0; j < othello.length; j++) {    // iterate through columns of a row
                if( isThisCellEmpty(i,j) ){
                    DirectionList flipList = new DirectionList();              // list of flipping opponents
                    DirectionList allAdjacent = DirectionList.allDirections(); // list of 8 possible directions
                    for(int k = 0; k < allAdjacent.length(); k++){             // for each adjacent cells around this empty cell
                        Direction theAdjacent = allAdjacent.getDirection(k);
                        if ( isAdjacentValid(i,j,player, theAdjacent) )        // if this adjacent cell is valid
                            if ( isAdjacentOpposite(i,j,player,theAdjacent) )  // and this adjacent cell is the opposite color of the player
                                flipList.addDirection(theAdjacent);            // add this adjacent to the flipList
                    }

                    if (flipList.length() != 0)
                        theValidMovesList.addMove(new Move(i, j, flipList));   // add the coordinate of the move and the flipList to theValidMoveList
                } //end isThisCellEmpty
            } // end column iteration
        } // end row iteration
        return theValidMovesList;
    }



    //Helper method #1
    //method: Adjacent actual coordinate of row on othello
    private int getAdjacentRowCoor(int row, Direction adjacent){
        int dx = adjacent.getRowChange();
        return row + dx;
    }

    //Helper method #2
    //method: Adjacent actual coordinate of column on othello
    private int getAdjacentColCoor(int col, Direction adjacent){
        int dy = adjacent.getColumnChange();
        return col + dy;
    }


    //Helper method #3
    //method: checking empty cell
    private boolean isThisCellEmpty(int row, int col) { return (othello[row][col] == EMPTY) ? true : false;}


    //Helper method #4
    /*method: checking 1 of 8 adjacent cells of this empty cell
    * If the adjacent cell is opposite with color of the player (black's opponent is white),
    * then this cell has the opponent, good.
    * If the adjacent cell is same as player (same as black or same as white),
    * then check if this adjacent cell already has the opponent adjacent to
    * then it is valid to play down a disc on this cell
    * Example:
    * . . X O X
    * . . . X .     // X on this row has O on top as opponent, good.
    * It also has the top-left or top-right same color, but these adjacent cells are valid to play too.
    * Because top-right or top-left X hasOppInBetween which is O.
    * This method satisfies the 2nd condition of the assignment phase 2: it flips at least one of the opponent's pieces.
     */
    private boolean isAdjacentValid(int row, int col, int player, Direction adjacent){
        int opponent = opponentOf(player);

        //the adjacent coordinate
        int curRow = getAdjacentRowCoor(row,adjacent);
        int curCol = getAdjacentColCoor(col,adjacent);

        //initialize some booleans
        boolean isValid = false;
        boolean hasOppInBetween = false;


        //check 1 direction (among 8 directions) around this cell
        if (curRow >= 0 && curRow < size && curCol >= 0 && curCol < size) {    //checking within size of othello board, accounted for border
            if (othello[curRow][curCol] == opponent){    //if the adjacent is opponent
                hasOppInBetween = true;                 //set the potential of being in between players to true
                isValid = true;
            }
            else if ((othello[curRow][curCol] == player) && (hasOppInBetween))   //opponent is on diagonal
                isValid = true;

            // end 1 out of 8 adjacent cells check
        }

        return isValid;
    }




    //Helper method #5
    //method: isAdjacentOpposite
    private boolean isAdjacentOpposite(int row, int col, int player, Direction adjacent) {
        int adjacentRowCoor = getAdjacentRowCoor(row, adjacent);
        int adjacentColCoor = getAdjacentColCoor(col, adjacent);
        if (othello[adjacentRowCoor][adjacentColCoor] == opponentOf(player))
            return true;
        else return false;
    }







    /*method: makeMove
    * make the given move, for the given player.
    * This is the only method that will actually make changes to the board.
    * It must place the new piece on the board, and flip all of the appropriate opponent pieces,
    * in the directions indicated by theMove.
     */
    public void makeMove(int player, Move theMove){
        int row = theMove.getRow();             //get coordinates of the move
        int col = theMove.getColumn();
        int flipRowCoor = 0, flipColCoor = 0;   // initialize coordinate of flipping cell
        DirectionList flipLocation = theMove.getFlipLocation();   // potential flipping cells

        othello[row][col] = player;   // player plays the disc

        //flipping all opponent discs
        for (int i=0; i < flipLocation.length(); i++){
            flipRowCoor = getAdjacentRowCoor(row, flipLocation.getDirection(i));   // get coordinate of the flipping disc
            flipColCoor = getAdjacentColCoor(col, flipLocation.getDirection(i));
            othello[flipRowCoor][flipColCoor] = opponentOf(player);    // flip the disc

        } // end "for" flipping all discs
    }// end makeMove






    /*method: saveFile
    * Want to save the progress has been made and save it as a text file by calling
    * saveFile(String fileName) method. This file has a special format.
    * The first line of the file will be the dimension of the board and the following lines represent
    * the board setup (. for Empty, O for Black, and X for White). Here is an example:
    * 4
    * ..o.
    * .oo.
    * xxxx
    * .o.x
     */

    public void saveFile(String fileName){
        try {
            //Create new file or append to existing file
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));


            outFile.println(size);   //print out the size of the othello
            outFile.print(this);


            outFile.close();

        }// end try
        catch (IOException e) {
            System.out.println("We have IO Exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch (Exception ex) {
            System.out.println("We have an Exception");
            ex.printStackTrace();
            System.exit(0);
        }

    }


    /*method: importBoardSetup
     * use a method with which you can import a specific board setup.
     * reads the data from a text file specified by ‘fileName’ and set the dimension as well as
     * set the values of the 2D array representing the board. The following is an example of an input text file:
     * ..xxx.
     * o.xxx.
     * .oxox.
     * ..o.x.
     * ....x.
     * This method should be able to throw IOException if the data in not valid.
     * Special exception message includes:
     * “The number of columns and rows doesn’t match”
     * “Unrecognized character”, for example if there is a character(s) other than ., x, o in the file
     * “number of rows/columns less than 2”
     */
    public void importBoardSetUp(String fileName){
        try {
            //Open a file using FileReader
            FileReader fileRdr = new FileReader(fileName);

            //Open a BufferedReader.
            BufferedReader inFile = new BufferedReader(fileRdr);


            int rowNum = 0, colNum = 0, colFirstRow = 0;

            //Read the file char-by-char
            int nextChar;
            char theChar = 0, prevChar;
            do {
                nextChar = inFile.read();   //char in integer
                theChar = (char) nextChar;  //actual character

                //if char is not last char and not last-line char
                // note that last char may contains 2 chars which are "\r\n".
                // I only test with '\n' due to Prof Ali said don't worry about it.
                //https://universityofmanitoba.desire2learn.com/d2l/le/390044/discussions/threads/979584/View
                if (nextChar != -1 && theChar != '\n') {

                    colNum++;

                    // Exception for unrecognized char
                    // note that valid chars are CAP X, CAP O, and .
                    // since it's not clearly stated in problem
                    if (theChar != 'X' && theChar != 'O' && theChar != '.') {
                        throw new Exception("Unrecognized character");
                    }
                }


                //if char is not last char and char is next-line char
                if (nextChar != -1 && theChar == '\n' ){
                    if( rowNum == 0 ){
                    colFirstRow = colNum;  //save the colNum of the firstRow, to compare later with colNum of next row
                    }

                    //Exception for not same number of columns on rows
                    if (colFirstRow != colNum) {
                        throw new Exception("The number of columns and rows doesn’t match");
                    }
                    colNum = 0;            //reset number of column for next row
                    rowNum++;              //onto next row
                }


            } while (nextChar != 1);


            ////Exception for total columns not same number as total rows
            if (rowNum != colNum) {
                throw new Exception("The number of columns and rows doesn’t match");
            }


            // Exception for number of rows or columns is too less
            if (rowNum < 2 || colNum < 2){
            throw new Exception("number of rows/columns less than 2");
            }


            inFile.close();

        } catch (IOException e) {
            System.out.println("IO Exception: No file is found");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println( "" + e.getMessage());
            System.exit(0);
        }

    }// end importBoardSetUp


}// end Board

