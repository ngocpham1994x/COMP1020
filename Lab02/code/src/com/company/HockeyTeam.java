package com.company;
import java.util.Arrays;
import java.util.*;


public class HockeyTeam implements Comparable {

    // instantiate class variables
    private String name;               // class var
    private int wins,losses,otLosses;  // class var
    private static final int MAX_CAPACITY = 64;
    private static int population = 0;
    private static HockeyTeam[] arr = new HockeyTeam[MAX_CAPACITY]; //create array of itself storing itself objects

    // Constructor method ALWAYS runs when instantiate new object
    public HockeyTeam(String name, int wins, int losses, int otLosses){
        this.name = name;   // assign instance var to class var
        this.wins = wins;
        this.losses = losses;
        this.otLosses = otLosses;
        arr[population] = this;   // add instance to array of objects
        population++;   // keeps track of number of instances in the array
    }

    /*
    This method prints all of the teams in the list, one per line
     */
    public static void listTeams(){
        for (int i= 0; i< population; i++)
            System.out.println(arr[i]);
    }

    /*
    This method calculates new points of each corresponding if team wins, losses, or otLosses
     */
    public void won() { wins += 1;}
    public void lost() { losses +=1 ;}
    public void lostOvertime() { otLosses += 1; }

    /*
    This method calculates total points of the team (instance / object)
     */
    public int points(){
        return 2 * wins + 0 * losses + 1 * otLosses;
    }

    /*
    Default method toString() method is modified as below.
    This method ALWAYS returns the object to String datatype when System.out.println(object) is used.
     */
    public String toString(){
        return name + "(" + wins + ","+ losses + "," + otLosses + "=" + points() + ")";
    }

    /*
    This method compares a HockeyTeam object to some other object.
    The type Object is a generic type that can refer to any object.
    This method should return a negative number if the other team is “larger” and should appear later in the list,
    a positive number if the other team is “smaller” and should appear earlier in the list,
    and a zero if the two teams are equal and can appear in either order.
     */
    /*
    The other object is the order of the array.
    the Arrays.sort() method will call the compareTo() method in its algorithm to determine
    the ordering of the array to make sure it is always in ascending order
     */
    public int compareTo(Object other) {
        HockeyTeam newTeam = (HockeyTeam) other;
        Integer x = this.points();
        Integer y = newTeam.points();
        int rank = 0;
        rank = x.compareTo(y);

               return rank;
    }

    /*
    This method sort the array of Hockeyteam objects in descending order.
    It will first calls the compareTo() method to compare the total points,
    then sort the array by the total points.
     */
    public static void sortTeams(){
        Arrays.sort(arr, 0, population, Collections.reverseOrder());
    }



} //HockeyTeam

