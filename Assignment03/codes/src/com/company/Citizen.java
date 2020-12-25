/* *
 * [Citizen]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [1]
 *
 * PURPOSE: [Create an abstract Citizen class.]
 */

//Status of the class: complete as per assignment

/*
 Since it will not be possible to create an object of this class, its methods will be very simple.
 There are no instance variables. This class exists only to allow polymorphism to occur later.
 */

//package com.company;

public abstract class Citizen {

    /*
    Implement a String toString() method which returns "Citizen".
     */
    public String toString(){
        return "Citizen";
    }

    /*
    Implement randomCitizen() method, that is a static method which will return a random Citizen.
    It should return a Civilian, Archer, or Barbarian, at random.
     */
    public static Citizen randomCitizen(){
        Citizen theCitizen;
        int randomNum = (int) (Math.random() * 3);
        if (randomNum == 0)
            theCitizen = new Civilian();
        else if (randomNum == 1)
            theCitizen = new Archer();
        else
            theCitizen = new Barbarian();

        return theCitizen;
    }
}
