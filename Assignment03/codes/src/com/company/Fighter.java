/* *
 * [Fighter]
 *
 * COMP 1020 SECTION [A01]
 * INSTRUCTOR: [Ali Neshati]
 * NAME: [Ngoc Pham]
 * ASSIGNMENT: [3]
 * QUESTION: [3]
 *
 * PURPOSE: [Create an abstract Fighter class as a subclass of the Citizen class.]
 */

//Status of the class: complete as per assignment

//package com.company;

public abstract class Fighter extends Citizen{

    /*private variables:
    Fighters have two private int instance variables: the “currentHealth”, and the “currentAttack”.
    When fighters attack each other, each one's attack power is used to decrease the other one's health.
    When a fighter's health reaches 0, it dies.
     */
    private int currentHealth, currentAttack;

    /*constructor
    Create a custom constructor with two parameters which initializes both the health and the attack power.
    The first input parameter of your constructor should be currentHealth and the second one should be currentAttack.
     */
    public Fighter(int health, int attack){
        currentHealth = health;
        currentAttack = attack;
    }

    //toString() method which returns "Fighter" followed by the values of health and attack power.
    public String toString() {
        return "Fighter: " + "health=" + currentHealth + " attack=" + currentAttack ;
    }


    //accessor (get) method of getCurrentHealth only if needed by other classes.
    public int getCurrentHealth(){
        return this.currentHealth;
    }

    //accessor (get) method of getCurrentAttack only if needed by other classes.
    public int getCurrentAttack(){
        return this.currentAttack;
    }

    //decreaseHp(int) which will reduce the health of this fighter by the given amount.
    // Health should not go below 0.
    public void decreaseHp(int amount){
        if(currentHealth > 0) {
            currentHealth -= amount;
            if(currentHealth <= 0)
                currentHealth = 0;
        }
    }

    //isDead() which will detect when the fighter is dead (health is zero).
    public boolean isDead(){
        if(currentHealth == 0)
            return true;
        else
            return false;
    }

    //gainPower() which does nothing.
    // But subclasses of this class will use this method, and so the superclass must also have one to allow polymorphism
    public void gainPower(){    }

    //gainPower(int) which increases the attack power by the given amount.
    // Survivors of a fight will gain attack power, and this can be useful in the subclasses to override the gainPower() method.
    public void gainPower(int amount){
        currentAttack += amount;
    }

    //Note that health only goes down, never up, and attack power only goes up, never down.
    // "What doesn't kill you makes you stronger."

}
