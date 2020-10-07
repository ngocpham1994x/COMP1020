package com.company;

public class HockeyTeam {
    private String name;
    private int wins,losses,otlosses;
    private static final int MAX_CAPACITY = 64;
    private static int population = 0;
    private static HockeyTeam[] arr = new HockeyTeam[MAX_CAPACITY]; //create array of itself storing

    public HockeyTeam(String name, int wins, int losses, int otlosses){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.otlosses = otlosses;
        arr[population] = this;
        population++;
    }

    public static void listTeams(){
        for (int i= 0; i< population; i++)
            System.out.println(arr[i]);
    }

    public void won() { wins += 1;}
    public void lost() { losses +=1 ;}
    public void lostOvertime() { otlosses += 1; }

    public int points(){
        return 2 * wins + 0 * losses + 1 * otlosses;
    }

    public String toString(){
        return name + "(" + wins + ","+ losses + "," + otlosses + "=" + points() + ")";
    }

} //HockeyTeam

