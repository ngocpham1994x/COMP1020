package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Template
 * Lab 8 Silver Exercise
 * COMP 1020
 */
public class Lab8Silver {
  
  public static final int DECK_SIZE = 20; //Keep it small for testing
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    //Create a brand new deck, still in sequence.
    ArrayList deck = makeDeck(DECK_SIZE);
    System.out.println("The new deck is "+deck);

    //Shuffle it and print it again
    shuffle(deck);
    System.out.println("The shuffled deck is "+deck);

    //Ask how many hands to deal, and of what size
    System.out.print("How many hands should be dealt? ");
    int numHands = keyboard.nextInt();
    System.out.print("How many cards in each hand? ");
    int numCards = keyboard.nextInt();
    
    //Deal the hands and print them.
    ArrayList[] theHands = deal(deck,numHands,numCards);
    System.out.println("The hands are:");
    for(int i=0; i<numHands; i++)
      System.out.println("Hand "+i+": "+theHands[i]);
    System.out.println("The remaining deck: "+deck);
    
  }//main
  
  public static ArrayList makeDeck(int numCards){
    ArrayList deck = new ArrayList();
    for (int i = 0; i < numCards; i++)
      deck.add(i);
    return deck;
  }
  
  public static void shuffle(ArrayList deck){
    for(int i=0; i < deck.size(); i++){    // [0-19]
      int randomPosition = 0;
      int deletedCard;

      randomPosition =  i + (int) (Math.random() * (deck.size()-i)) ;
      // search space decreases
      // 0 & deck.size() = [0,19] = [0,20)
      // 1 & deck.size()-1 = [1,19]
      // 2 & deck.size()-2 = [2,19]
      // 3 & deck.size()-3 = [3,19]
      // 4 & deck.size()-4 = [4,19]
      //...
      // There’s no need to select a random card to go into position deck.size()-1 because there’s only one card left at that point anyway

      deletedCard = (int) deck.remove(randomPosition);
      deck.add(i,deletedCard);
    }
  }
  
  public static ArrayList[ ] deal(ArrayList deck,
                                  int numHands, int numCards){
    ArrayList[] hands = new ArrayList[numHands];  //array of ArrayList, need specific size

    //create an ArrayList for each hand
    for(int j = 0; j< numHands; j++)
      hands[j] = new ArrayList();  //no need specific size

    //distribute each card (first card in the deck) to each hand, in circle just like in real life
    for (int i = 0; i < numCards;i++) {
      int j;  // each hand
      for (j = 0; j < numHands; j++) {
        hands[j].add(deck.get(0));
        deck.remove(0);
      }
    }

    return hands;
  }
  
}//TemplateLab8Silver
