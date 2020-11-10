package com.company;

public class Game {
    private HockeyTeam home, away;
    private int homeScore, awayScore;

    public Game(HockeyTeam home, HockeyTeam away){
        this.home = home;
        this.away = away;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String toString(){
        return away.getName() + "(" + awayScore + ") at " +home.getName() + "("+ homeScore +")";
    }

    public void goal(HockeyTeam team){
        if(team.getName() == home.getName())
            homeScore++;
        if(team.getName() == away.getName())
            awayScore++;
        if(team.getName() != home.getName() & team.getName() != away.getName())
            System.out.println("That team isn't playing in this game!");
    }

} // end Game
