import java.util.ArrayList;
import java.util.Scanner;

/**
 * Template
 * Lab 8 Silver Exercise
 * COMP 1020
 */
public class TemplateLab8Silver {
  
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
    return null; //Dummy - remove
  }
  
  public static void shuffle(ArrayList deck){
  }
  
  public static ArrayList[ ] deal(ArrayList deck,
                                  int numHands, int numCards){
    return null; //Dummy - remove
  }
  
}//TemplateLab8Silver
