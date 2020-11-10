/* *
 * [MoveList]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [2]
 * QUESTION: [1]
 *
 * PURPOSE: [Create a MoveList instance which contains instances from Move class]
 */


/*
An object of type MoveList will hold a list of 0 or more Moves.
 */
//package com.company;

public class MoveList {

    /* instance vars
    * store the list of moves
    * use an array, give it a maximum capacity of 32 moves.
     */
    private Move[] moveList;
    private static final int MAX_MOVES = 32;
    private int size;

    /*constructor
    * create an empty list of moves.
     */
    public MoveList(){
        moveList = new Move[MAX_MOVES];
        size = 0;
    }

    /*method: addMove
    * add a Move to the list.
    * input: "Move" instance, which has coordinates of THE MOVE and FLIPLIST to opponent cells
     */
    public void addMove(Move m){
        moveList[size] = m;
        size++;
    }


    /*method: toString
    * return a multi-line String using '\n' characters to separate the moves,
    * so that if the String were printed it would look like this:
    * (1,2) flips directions {<down>}
    * (2,0) flips directions {<right>,<down right>}
    * (2,5) flips directions {<left>,<down left>}
    * (4,0) flips directions {<right>}
     */
    public String toString(){
        String s = "";
        for (int i=0; i < size; i++) {
            s += moveList[i] + "\n";
        }
        return s;
    }


    /*method: isEmpty
    * returns true if the list is empty
     */
    public boolean isEmpty(){ return size == 0; }


    /*method: randomMove()
    * returns one of the moves in the list, at random. If the list is empty, it should return null.
    * Math.random() returns an double between 0.0 (inclusive) to 1.0 (exclusive)
    * Multiplying this with array.length gives a double between 0.0 (inclusive) and array.length (exclusive)
    * Casting to int will round down giving an integer between 0 (inclusive) and array.length-1 (inclusive)
     */
    public Move randomMove(){
        if( this.isEmpty() )
            return null;
        else {
            int rand = (int)(Math.random()*size);
            return moveList[rand];
        }
    }

} // end MoveList

