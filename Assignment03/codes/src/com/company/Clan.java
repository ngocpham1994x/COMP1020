/* *
 * [Clan]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [6]
 *
 * PURPOSE: [Create a Clan class.]
 */

//Status of the class: complete as per assignment

//A clan must have a name, and a list of Citizens.
//package com.company;

import java.util.*;

public class Clan {

    //private variables
    private String name;
    private ArrayList citizensList;

    /*constructor:
    create a clan with the given name, and the given number of citizens.
    The number of citizens will never change later, although some of them (the fighters) may become dead.
    The constructor should create and store the correct number of random citizens,
    using the randomCitizen method of the Citizen class.
    Since a clan will be deleted from the game when it has no fighters left,
    it is important that the clan has at least one to start with.
    Make sure the first citizen is an Archer or Barbarian.
    */
    public Clan(String clanName, int clanSize) {
        name = clanName;
        citizensList = new ArrayList();
        if (clanSize > 0){
            for (int i = 0; i < clanSize; i++)
                citizensList.add(Citizen.randomCitizen());
        }
        while(citizensList.get(0).toString() == "Civilian")
            citizensList.set(0,Citizen.randomCitizen());
    }

    //Provide a getName() accessor method.
    public String getName(){
        return this.name;
    }

    //totalAttackPower() method finds the total attack power of all Fighters
    // in this clan who are not dead (sum of all attack power of all Fighters)
    private int totalAttackPower(){
        int totalAttackPoint = 0;
        for(int i = 0; i < citizensList.size(); i++)
            if(citizensList.get(i).toString() != "Civilian" && ((Fighter) citizensList.get(i)).isDead() == false)
                totalAttackPoint += ( (Fighter) citizensList.get(i) ).getCurrentAttack();

        return totalAttackPoint;
    }

    //numFightersAlive() method counts the number of Fighters in this clan who are not dead
    private int numFightersAlive(){
        int aliveFightersCount = 0;
        for(int i=0; i < citizensList.size(); i++)
            if(citizensList.get(i).toString() != "Civilian" && ((Fighter) citizensList.get(i)).isDead() == false)
                aliveFightersCount++;
        return aliveFightersCount;
    }

    // attack() method causes two clans to fight each other (this clan, and the others).
    // When clan A attacks clan B, the maximum possible damage to members of clan B is
    // the total attack power of clan A divided by the number of living fighters in clan B.
    // The health of each living fighter in clan B should be reduced by a random value between 0 and this maximum value.
    // This should be done in both directions as if both clans are attacking each other at the same time
    // (this clan attacks the others, but the others attack this clan, too.)
    public void attack(Clan others){
        int damagePointThisClanToOthers = this.totalAttackPower() / others.numFightersAlive();
        int damagePointOthersClanToThis = others.totalAttackPower() / this.numFightersAlive();

        //damage this clan to another clan
        for (int i =0; i < others.citizensList.size(); i++) {
            if ( others.citizensList.get(i).toString() != "Civilian" && ( (Fighter) others.citizensList.get(i)).isDead() == false ){
                int randomDamageThisClanToOther = (int) (Math.random() * damagePointThisClanToOthers + 1);
                ( (Fighter) others.citizensList.get(i)).decreaseHp(randomDamageThisClanToOther);
            }
        }

        //damage of another clan to this clan
        for (int i =0; i < this.citizensList.size(); i++) {
            if ( this.citizensList.get(i).toString() != "Civilian" && ( (Fighter) this.citizensList.get(i)).isDead() == false ){
                int randomDamageOthersClanToThis = (int) (Math.random()*damagePointOthersClanToThis + 1);
                ( (Fighter) this.citizensList.get(i)).decreaseHp(randomDamageOthersClanToThis);
            }
        }

    }

    //isDead() method which will return true if there are no living fighters in this clan.
    public boolean isDead(){
        if(this.numFightersAlive() == 0)
            return true;
        else
            return false;
    }

    // gainPower() method which will increase the attack power of every living fighter in this clan.
    // This will be called (in the World class, below) to increase the power of the survivors of a fight.
    // Don't increase the attack power of dead fighters!
    public void gainPower(){
        for(int i=0; i < citizensList.size(); i++)
            if(citizensList.get(i).toString() != "Civilian" && ((Fighter) citizensList.get(i)).isDead() == false)
                ( (Fighter) citizensList.get(i)).gainPower();
    }

    // toString() method, which will return a multi-line String showing the information on the whole clan:
    // o The first line should give the clan's name.
    // o The second line should give the clan's total attack power.
    // o The remaining lines should list the citizens, one per line,
    //      using the Strings provided by their toString methods.
    //      Do not list dead fighters, only living ones.
    public String toString(){
        String s = "";
        s = "Clan " + name + ":\nTotal attack power: " + totalAttackPower() + "\n";
        for(int i=0; i < citizensList.size(); i++){
            if ( citizensList.get(i).toString() != "Civilian" && ( (Fighter) citizensList.get(i) ).isDead() == false)
                s += citizensList.get(i).toString() + "\n";
            if ( citizensList.get(i).toString() == "Civilian")
                s += citizensList.get(i).toString() + "\n";
        }

        return s;
    }

}
