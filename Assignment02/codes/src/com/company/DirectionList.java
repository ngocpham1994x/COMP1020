/* *
 * [DirectionList]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [2]
 * QUESTION: [1]
 *
 * PURPOSE: [Create a DirectionList instance which contains instances from Direction class]
 */



/*
An object of type DirectionList will hold a list of Directions (0 to 7)
 */

//package com.company;


public class DirectionList {

    /* instance vars
     * store the list of Direction, max size and current size
     */
    private Direction[] directionsList;
    private static final int MAX_SIZE = 8;
    private static int size;

    /*constructor
    * create an empty list
    */
    public DirectionList(){
        directionsList = new Direction[MAX_SIZE];
        size = 0;
    }

    /*method: addDirection
     * to add a Direction to the end of the list.
     * input: a "Direction" instance
     */
    public void addDirection(Direction d){
        if( size < MAX_SIZE){
        directionsList[size] = d;
        size++;
        }
    }

    /*method: length
     * return the current size of the list.
     * output type: integer
     */
    public int length(){
        return size;
    }

    /* method: getDirection
     * (get the "Direction" in the "DirectionList" instance)
     * return the element at position i in the list
     * input type: integer, to iterate through the list
     * output type: "Direction"
     */
    public Direction getDirection(int i){
        return directionsList[i];
    }

    /*method: toString
     * list the Directions in the list, surrounded by { } and separated by commas.
     * For example, {<right>,<down right>,<left>}. Don't put a comma after the last one.
     */
    public String toString(){
        String s = "{";
        for (int i = 0; i < size; i++){
            if(i != size-1)
                s += directionsList[i] + ",";
            if (i == size-1)
                s += directionsList[i] ;
        }
        s += "}";
        return s;
    }

    /*method: allDirections
     * return a list of all 8 possible directions.
     * This will be very useful later in the assignment. Note that this is a static method.
     */
    public static DirectionList allDirections(){
        DirectionList all = new DirectionList();
        all.addDirection(new Direction(-1,-1)); //top left
        all.addDirection(new Direction(-1,0));  //top
        all.addDirection(new Direction(-1,1));  //top right
        all.addDirection(new Direction(0,-1));  //left
        all.addDirection(new Direction(0,1));   //right
        all.addDirection(new Direction(1,-1));  //bottom left
        all.addDirection(new Direction(1,0));  //bottom
        all.addDirection(new Direction(1,1));  //bottom right
        return all;
    }



} // end DirectionList
