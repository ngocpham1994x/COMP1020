package com.company;
import java.util.ArrayList;

public class HockeyTeam {

    // class variables
    private static String name;
    private static int wins, losses, otLosses;
//    public static int population = 0;
//    private static final int MAX_CAPACITY = 64;
//    private static HockeyTeam[] arr = new HockeyTeam[MAX_CAPACITY];
//    private static ArrayList<HockeyTeam> arr = new ArrayList<HockeyTeam>();

    // Constructor
    public HockeyTeam(String name, int wins, int losses, int otLosses){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.otLosses = otLosses;
//        HockeyTeam team = new HockeyTeam(name,wins,losses,otLosses);
//        arr.add(this);
//        HockeyTeam x = this;
//        arr[population] = x;
//        population++;
//        System.out.println(arr);
        }
//        arr.add(toString());

//    public static void listTeams(){
//        for(int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i));
//    for (int i=0; i<population;i++){
//            System.out.println(arr[i]);
//        }

    // public method: add one to the corresponding int value
    public void won(){ this.wins += 1; }
    public void lost(){ this.losses += 1; }
    public void lostOvertime() { this.otLosses += 1; }

    // public method: calculate and return the number of points that the team has
    public  int points(){
        int points;
        return points = 2 * wins + 0 * losses + 1 * otLosses;
    }

    // public method: toString() return a String giving info about the team and number of points that the team has
    public String toString(){
        String info;
        return info = name + "(" + wins + "," + losses + "," + otLosses + "=" + points() +")";
    }



}// Hockey team


