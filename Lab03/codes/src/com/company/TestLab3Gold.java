package com.company;

/**
 * This program will test the Gold exercise
 * for Lab 3 of COMP 1020.
 */
public class TestLab3Gold {
  
  public static void main(String[] args) {
    
    //Create a league of 7 HockeyTeam objects
    TeamList league = new TeamList();
    league.addTeam(new HockeyTeam("Winnipeg",22,14,8));
    league.addTeam(new HockeyTeam("Chicago",28,13,2));
    league.addTeam(new HockeyTeam("Colorado",18,17,8));
    league.addTeam(new HockeyTeam("St. Louis",27,13,3));
    league.addTeam(new HockeyTeam("Dallas",19,16,7));
    league.addTeam(new HockeyTeam("Minnesota",18,19,5));
    league.addTeam(new HockeyTeam("Nashville",29,9,4));
    
    //Sort the teams and print the standings
    league.sortTeams();
    System.out.println("Standings:\n"+league);
    
    //Gold test 1: There are no games.
    System.out.println("Test 1: Best Bet now should be null - there are no games.");
    System.out.println("league.bestBet() gives:"+league.bestBet()+"\n");
    
    //Create 3 Game objects
    System.out.println("Creating Nashville at Winnipeg game.");
    GameV2 game1 = new GameV2(league.findTeam("Winnipeg"),league.findTeam("Nashville"));
    System.out.println("Creating Minnesota at St. Louis game.");
    GameV2 game2 = new GameV2(league.findTeam("St. Louis"),league.findTeam("Minnesota"));
    System.out.println("Creating Dallas at Colorado game.");
    GameV2 game3 = new GameV2(league.findTeam("Colorado"),league.findTeam("Dallas"));
    System.out.println();

    //Gold test 2: Three games active. A home team is the best bet
    System.out.println("Test 2: Best Bet now should be St. Louis (16 points better)");
    System.out.println("league.bestBet() gives:"+league.bestBet()+"\n");
    
    //Gold test 3: Best game ended. An away team now best.
    game2.goal(league.findTeam("St. Louis"));
    game2.ended();
    System.out.println(game2);
    System.out.println("Test 3: Best Bet now should be Nashville (10 points better)");
    System.out.println("league.bestBet() gives:"+league.bestBet()+"\n");
    
    //Gold test 4: There are no active games at all.
    game3.goal(league.findTeam("Colorado"));
    game3.ended();
    System.out.println(game3);
    game1.goal(league.findTeam("Winnipeg"));
    game1.ended();
    System.out.println(game1);
    System.out.println("Test 4: No active games. Best Bet now should be null");
    System.out.println("league.bestBet() gives:"+league.bestBet()+"\n");

  }//main
  
}//TestLab2Gold
