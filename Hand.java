/**
*File: Hand.java
*Author: Isabella Feng
*Date: 09/05/2020
**/

import java.util.ArrayList;

public class Hand{
    ArrayList<Card> arr;

    //create a new arraylist
    public Hand(){
        arr = new ArrayList<Card>();
    }

    //reset the hand to empty
    public void reset(){
        arr.clear();
    }

    //add the card object to the hand
    public void add(Card card){
        arr.add(card);
    }

    // returns the number of cards in the hand
    public int size(){
        return arr.size();
    }

    //returns the card with index i
    public Card getCard(int i){
        return arr.get(i);
    }

    //returns the sum of the values of the cards in the hand
    public int getTotalValue(){
        int sum = 0;
        for(Card c : arr){
            sum = sum + c.getValue();
        }
        return sum;
    }

    //returns a String that has the contents of the hand presented in a nice format
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (Card c : arr){
            sb.append(c.getValue());
            sb.append(",");

            //sb = c.toString()+", ";
        }
        return "The " + Integer.toString(size()) + " Cards in Hand are: " + sb.toString() + " and the sum of the Cards is " + Integer.toString(getTotalValue());
    }

    //a main method that uses each of the class methods to demonstrate that they work
    public static void main(String[] args){
        Card myCard1 = new Card();
        System.out.println(myCard1);
        Card myCard2 = new Card(10);
        System.out.println(myCard2);
        
        Hand myHand = new Hand();
        myHand.add(myCard1);
        myHand.add(myCard2);
        System.out.println(myHand.getTotalValue());
        System.out.println(myHand);
    }
}