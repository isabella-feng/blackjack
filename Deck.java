/**
*File: Deck.java
*Author: Isabella Feng
*Date: 09/06/2020
**/

import java.util.ArrayList;
import java.util.Random;

public class Deck{
    
    ArrayList<Card> arr;

    //use an ArrayList to build a deck of 52 cards
    public Deck(){
        arr = new ArrayList<Card>();
        build();
    }

    //build a deck of 52 cards
    public void build(){
        for (int i = 1; i <= 4; i++){
            for (int v = 2; v < 10; v++){
                Card theCard1 = new Card(v);
                arr.add(theCard1);
            }
            Card theCard2 = new Card(11);
            arr.add(theCard2);
        }
        for (int i = 1; i <= 16; i++){
            Card theCard3 = new Card(10);
            arr.add(theCard3);
        }
    }

    //returns the number of cards in the deck
    public int size(){
        return arr.size();
    }

    //reset the deck to empty
    public void reset(){
        arr.clear();
    }

    //returns the top card (position zero) and removes it from the deck
    public Card deal(){
        Card removed = arr.remove(0);
        return removed;
    }

    //returns the card at position i and removes it from the deck
    public Card pick(int i){
        Card removed = arr.remove(i);
        return removed;
    }

    //shuffles the deck
    public void shuffle(){

        ArrayList<Card> shuffled = new ArrayList<Card>();

        Random ran = new Random(System.currentTimeMillis());
        //Random ran = new Random();

        int size = arr.size();

        // randomly remove an item from the oringinal arraylist and assign to the new shuffled arraylist
        for (int i = 0; i < size; i++) {
            int ind = ran.nextInt(size - i);
            Card removed = arr.remove(ind);
            shuffled.add(removed);
        }

        arr = shuffled;
    }

    //returns a String that has the contents of the deck "written" in a nice format
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (Card c : arr){
            sb.append(c.getValue());
            sb.append(",");
        }
        return "The " + Integer.toString(size()) + " Cards you have in the Deck are: " + sb.toString();
    }

    //reset the deck and shuffle it
    public void newAndShuffle(){
        reset();
        build();
        shuffle();
    }

//Extension
    //6 deck
    public void deck6(){

        ArrayList<Card> deck6 = new ArrayList<Card>();

        // move the card in one deck to the deck6 for 6 times
        
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            Card removed = arr.remove(0);
            for (int times = 0; times < 6; times++) {
                deck6.add(removed);
            }
        }
        arr = deck6;
    }
    
    //reset the deck and shuffle it
    public void deck6AndShuffle(){
        reset();
        build();
        deck6();
        shuffle();
    }

    //a main method that uses each of the class methods to demonstrate that they work
    public static void main(String[] args){
        Deck myDeck = new Deck();
        System.out.println(myDeck);
        myDeck.shuffle();
        System.out.println(myDeck);
        //myDeck.deal();
        //System.out.println(myDeck);
        myDeck.newAndShuffle();
        System.out.println(myDeck);
        //myDeck.deck6AndShuffle();
        //System.out.println(myDeck);
    }
}

