/**
*File: Interactive.java
*Author: Isabella Feng
*Date: 09/06/2020
**/

import java.util.Scanner;

public class Interactive{


    public static void main(String[] args) {
        Blackjack myGame = new Blackjack();
        myGame.theDeck.shuffle();
        myGame.deal();

        Scanner playerIn = new Scanner(System.in);
        System.out.println(myGame.playerHand);
        System.out.println("Enter 'h' to Hit, enter 's' to Stand.");
        String playerInput = playerIn.nextLine();

        while (playerInput.equals(myGame.hit)){
            myGame.playerTurnInteractive();
            System.out.println(myGame.playerHand);
            if (myGame.playerWithinRange){
                playerIn = new Scanner(System.in);
                System.out.println("Enter 'h' to Hit, Enter 's' to Stand.");
                playerInput = playerIn.nextLine();
            }else{
                playerInput = "s";
            }
        }

        myGame.dealerTurnInteractive();

        //print out game result
        if (myGame.playerWithinRange){
            if (myGame.dealerWithinRange){
                if (myGame.dealerHand.getTotalValue() < myGame.playerHand.getTotalValue()){
                    System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". You won!");
                } else if (myGame.dealerHand.getTotalValue() > myGame.playerHand.getTotalValue()){ 
                    System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". You lost!");
                } else{
                    System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". It's a tie!");
                }
            }else{
                System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". You won!");
            }
        }else if (myGame.dealerWithinRange){
            System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". You lost!");
        }else{
            System.out.println("Your sum: " + myGame.playerHand.getTotalValue() + ". Dealer's sum: " + myGame.dealerHand.getTotalValue() + ". Nobody wins!");
        }
    }
}

