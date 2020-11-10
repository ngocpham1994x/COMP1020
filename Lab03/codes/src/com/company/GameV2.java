package com.company;

public class GameV2 {
    public static int gameNum;
    private HockeyTeam home, away;
    private int homeScore, awayScore;
    private boolean gameEnded, gameOT;

    public GameV2(HockeyTeam home, HockeyTeam away){
        this.home = home;
        this.away = away;
        this.home.setGame(this);    //sending the current playing game with 2 teams to HockeyTeam
        this.away.setGame(this);    //sending the current playing game with 2 teams to HockeyTeam
        this.homeScore = 0;
        this.awayScore = 0;
        gameEnded = false;
        gameOT = false;
        gameNum++;
    }

    public String toString(){
        String extraString = "";

        if ( gameOT == false &  gameEnded == true)
            extraString = "Final";
        if ( gameOT == true & gameEnded == false)
            extraString = "OT";
        if ( gameOT == true & gameEnded == true)
            extraString = "OT Final";

        String s = away.getName() + "(" + awayScore + ") at " +home.getName() + "("+ homeScore +") " + extraString;


        return s;
    }

    public void goal(HockeyTeam team){
        if(gameOT == false) {
            if (team.getName() == home.getName())
                homeScore++;
            if (team.getName() == away.getName())
                awayScore++;
            if (team.getName() != home.getName() & team.getName() != away.getName())
                System.out.println("That team isn't playing in this game!");
        }
        if(gameOT == true){
            if(team.getName() == home.getName()) { homeScore++; gameEnded = true; home.won(); away.lostOvertime(); };
            if(team.getName() == away.getName()) { awayScore++;gameEnded = true; away.won(); home.lostOvertime();}
        }
    }

    public void overtime(){
        this.gameOT = true;
    }

    public void ended(){
        this.gameEnded = true;
        if (homeScore > awayScore) { home.won(); away.lost();}
        if(awayScore > homeScore) { away.won(); home.lost();}
    }




    // Gold level:
    public boolean isGameEnded(){
        gameNum--;
        return gameEnded;
    }

    public HockeyTeam getHome() { return home;}
    public HockeyTeam getAway() { return away;}



} // end Game
