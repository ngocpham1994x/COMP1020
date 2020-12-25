/* *
 * [Barbarian]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [5]
 *
 * PURPOSE: [Create an Barbarian class as a subclass of the Fighter class.]
 */

//Status of the class: complete as per assignment

//package com.company;

public class Barbarian extends Fighter {

    /*constructor:
    Barbarians always start with 200 health and 20 attack power.
    Provide a constructor with no parameters which does this.
     */
    public Barbarian() {
        super(200, 20);
    }

    //toString() method which returns the String produced by the Fighter superclass, with "(Barbarian)" added to the end.
    public String toString(){
        String s ="";
        s = super.toString() + " (Barbarian)";
        return s;
    }

    //void gainPower() which adds 15 to the barbarian’s attack power.
    public void gainPower(){
        super.gainPower(15);
    }


}
