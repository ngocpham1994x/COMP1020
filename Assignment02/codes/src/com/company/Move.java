/* *
 * [Move]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [2]
 * QUESTION: [1]
 *
 * PURPOSE: [Create a Move instance from Move class]
 */


/*
An object of type Move will hold information describing one possible move in a game of Reversi.
A move in this game will always "flip" opponent pieces in one or more directions,
a Move object will also keep track of these directions.
 */
//package com.company;

public class Move {

    /* instance vars
    * store the coordinates of the move (a row number and a column number),
    * and a DirectionList giving the directions in which opposing pieces will be flipped
     */
    private int row, column;
    private DirectionList flipLocation;

    /*constructor
     * accepts a row number, a column number, and a DirectionList.
     * DirectionList called flipList storing direction of occupied cells of the opponent to be flipped by player
     */
    public Move(int row, int column, DirectionList flipList){
        this.row = row;
        this.column = column;
        this.flipLocation = flipList;
    }

    /*method: getRow
     * accessor to get the row position / coordinate of the move
     */
    public int getRow() { return this.row;}


    /*method: getColumn
     * accessor to get the column position / coordinate of the move
     */
    public int getColumn() { return this.column;}



    /*method: getFlipLocation
     * accessor to get the flipList of the move: Direction of occupied cells being flipped by player
     */
    public DirectionList getFlipLocation() { return this.flipLocation;}


    /* method: toStirng
    * returns a String in the following format:
    * (2,5) flips directions {<left>,<down left>}
     */
    public String toString(){
        String s = "";
        s += "(" + row + "," + column + ") flips directions " + flipLocation;
        return s;
    }



} // end Move

