/**
 * File: Card.java
 * Author: Isabella Feng
 * Date: 09/05/2020
 **/

class Card{
    private int value;

    //Constructor (when no value is assigned)
    public Card(){
        value = 0;
    }

    //Constructor with the value of the card, with range checking
    public Card(int v){
        if (v >= 1 && v <= 11){
            value = v;
        }
    }

    //return the numeric value of the card
    public int getValue(){
        return value;
    }

    //return a string that represents the card object
    public String toString(){
        return Integer.toString(value);
    }

    //main function that demonstrate that the codes above work
    public static void main(String[] args){
        Card myCard1 = new Card();
        System.out.println(myCard1);
        Card myCard2 = new Card(10);
        System.out.println(myCard2);
        Card myCard3 = new Card(13);
        System.out.println(myCard3);

    }
}