/* *
 * [World]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [7]
 *
 * PURPOSE: [Create a World class.]
 */

//Status of the class: complete as per assignment

/*
The world will contain a list of all of the clans,
and provide a few methods that will complete the functionality of the game.
 */
//package com.company;

import java.util.*;

public class World {
    // private variable:
    //instance variable(s) that store a list of up to 10 Clans.
    // The number of clans will change during the game
    private ArrayList clansList;

    //a constructor (no parameters) that creates a world containing no clans.
    public World(){
        clansList = new ArrayList();
    }

    //addClan(Clan c) method to add a new clan to the world.
    // not need to check to see if the maximum number of clans has been exceeded.
    public void addClan(Clan c){
        clansList.add(c);
    }

    //getNumClans() method which will return the current number of clans in the world.
    public int getNumClans(){
        return clansList.size();
    }

    //attack(int clan1, int clan2) which will cause the two clans to attack each other.
    // (The clans are identified by index number, not by name.)
    // It should print a message indicating that this is happening, including the names of the two clans.
    // Surviving fighters in each clan should gain power.
    // If either (or both) clans no longer have any living fighters, they should be deleted from the world.
    // A message should also be printed when a clan is deleted.
    // You may want to write additional private methods to support this method.
    public void attack(int clan1, int clan2) {
        Clan theClan1 = (Clan) clansList.get(clan1);
        Clan theClan2 = (Clan) clansList.get(clan2);

        System.out.println("Clan " + theClan1.getName() + " attacks " + theClan2.getName() + "!\n");

        theClan1.attack(theClan2);

        theClan1.gainPower();
        theClan2.gainPower();


        if (theClan1.isDead()){
            clansList.remove(clan1);
            System.out.println("Clan " + theClan1.getName() + " is wiped out! !\n");
        }

        if (theClan2.isDead()){
            clansList.remove(clan2);
            System.out.println("Clan " + theClan2.getName() + " is wiped out! !\n");
        }

    }

    //toString() method that will return a multi-line String listing the entire world, and all the clans in it.
    // It should give the number of clans in the world, and then list each clan.
    // Add some sort of dividing line to separate the clans and make them more visible.
    public String toString(){
        String s = "";
        s="There are " + clansList.size() + " clans in the world. \n";
        for(int i= 0; i<clansList.size(); i++)
            s += "----- \n" + clansList.get(i).toString() ;
        return s;
    }

}
