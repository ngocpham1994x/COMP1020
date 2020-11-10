/* *
* [Direction]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Ali Neshati]
* NAME: [Ngoc Pham]
* ASSIGNMENT: [2]
* QUESTION: [1]
*
* PURPOSE: [Create a Direction instance from Direction class]
*/

/*
An object of type Direction will hold two int values to represent
one of the 8 possible vertical, horizontal, or diagonal directions on a game board
 */
//package com.company;

public class Direction {

    /*instance vars
     * one of the 8 possible vertical, horizontal, or diagonal CHANGE of directions
     */
    private int rowChange, columnChange;

    /*constructor
    * with two integer parameters to initialize the two instance variables
    * The two integers give the change to the row index, and to the column index,
    * that would move from one square to the next in the indicated direction.
    * These numbers will always be -1, 0, or +1.
    * The two numbers should not both be 0 (since that wouldn't change any index at all)
    */
    public Direction(int rowChange, int columnChange){
        if (rowChange != 0 || columnChange != 0) {
            this.rowChange = rowChange;
            this.columnChange = columnChange;
        }
    }

    /*method: getRowChange
     * accessor for row change
     * output type: integer
     */
    public int getRowChange(){
        return this.rowChange;
    }

    /*method: getColumnChange
     * access for column change
     * output type: integer
     */
    public int getColumnChange(){
        return this.columnChange;
    }

    /*method: toString
    * should return a String containing words, not integers.
    * Use the words "up", "down", "left", and "right" instead of -1 and +1.
    * Use either one word, or two words, whichever is appropriate,
    * and surround the words with "angle brackets" (< >)
    * Examples:
    * new Direction(-1,1).toString() should give "<up right>"
    * new Direction(1,-1).toString() should give "<down left>"
    * new Direction(1,0).toString() should give "<down>"
    * new Direction(0,-1).toString() should give "<left>
     */
    public String toString(){
        String s = "<";
        if (rowChange == -1){
            s += "up";
            if (columnChange == -1)
                s += " left";
            if (columnChange == 0)
                s += "";
            if (columnChange == 1)
                s += " right";
        }
        if (rowChange == 0){
            if (columnChange == -1)
                s += "left";
            if(columnChange == 1)
                s += "right";
        }
        if (rowChange == 1){
            s += "down";
            if (columnChange == -1)
                s += " left";
            if (columnChange == 0)
                s += "";
            if (columnChange == 1)
                s += " right";
        }
        s += ">";
        return s;
    }

} // end Direction

