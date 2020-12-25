/* *
 * [Archer]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [4]
 *
 * PURPOSE: [Create an Archer class as a subclass of the Fighter class.]
 */

//Status of the class: complete as per assignment

//package com.company;

public class Archer extends Fighter{

    /*constructor:
    Archers always start with 100 health and 15 attack power.
    Provide a constructor with no parameters which does this.
     */
    public Archer() {
        super(100, 15);
    }

    //toString() method which returns the String produced by the Fighter superclass, with "(Archer)" added to the end.
    public String toString(){
        String s ="";
        s = super.toString() + " (Archer)";
        return s;
    }

    //gainPower() which adds 10 to the archer's attack power.
    public void gainPower(){
        super.gainPower(10);
    }



}
