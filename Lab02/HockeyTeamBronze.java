package com.company;

public class HockeyTeam {
    private String name;
    private int wins,losses,otlosses;

    public HockeyTeam(String name, int wins, int losses, int otlosses){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.otlosses = otlosses;
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

