/**
*File: Blackjack.java
*Author: Isabella Feng
*Date: 09/06/2020
**/

public class Blackjack{

    Deck theDeck = new Deck();
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();
    int cutoff = 52;

    //store the reshuffleCutoff and set up a game
    //default constructor
    public Blackjack(){
        reset();
    }
    
    //store the reshuffleCutoff and set up a game
    public Blackjack(int reshuffleCutoff){
        cutoff = reshuffleCutoff;
        reset();
    }

    //reset the game
    public void reset(){
        playerHand.reset();
        dealerHand.reset();
        if (theDeck.size() < cutoff){
            theDeck.newAndShuffle();
        }
    }

    //deal out two cards to both players from the Deck
    public void deal(){
        playerHand.add(theDeck.deal());
        dealerHand.add(theDeck.deal());
    }

    //have the player draw cards until the total value of the player's hand is equal to or above 16
    public boolean playerTurn(){
        while (playerHand.getTotalValue() < 16){
            playerHand.add(theDeck.deal());
        }
        if (playerHand.getTotalValue() > 21){
            return false;
        }
        return true;
    }

    public boolean dealerTurn(){
        while (dealerHand.getTotalValue() < 17){
            dealerHand.add(theDeck.deal());
        }
        if (dealerHand.getTotalValue() > 21){
            return false;
        }
        return true;
    }

    //assign the new cutoff value to the internal reshuffle cutoff field
    public void setReshuffleCutoff(int reshuffleCutoff){
        cutoff = reshuffleCutoff;
    } 

    //returns the current value of the reshuffle cutoff field
    public int getReshuffleCutoff(){
        return cutoff;
    }

    //returns a String that has represents the state of the game
    public String toString(){
        if (playerTurn()){
            if (dealerTurn()){
                if (dealerHand.getTotalValue() < playerHand.getTotalValue()){
                    return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". The player wins!";
                } else if (dealerHand.getTotalValue() > playerHand.getTotalValue()){ 
                    return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". The dealer wins!";
                } else{
                    return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". It's a tie!";
                }
            }else{
                return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". The player wins!";
            }
        }else if (dealerTurn()){
            return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". The dealer wins!";
        }else{
            return "Player's sum: " + Integer.toString(playerHand.getTotalValue()) + ". Dealer's sum: " + Integer.toString(dealerHand.getTotalValue()) + ". Nobody wins!";
        }
    }

    //play a single game of Blackjack and return int
    public int game(boolean verbose) {
        reset();
        deal();
        playerTurn();
        dealerTurn();
        if (playerTurn()){
            if (dealerTurn()){
                if (dealerHand.getTotalValue() < playerHand.getTotalValue()){
                    return 1;
                } else if (dealerHand.getTotalValue() > playerHand.getTotalValue()){
                    return -1;    
                } else{
                    return 0;
                }
            }else{
                return 1;
            }
        }else if (dealerTurn()){
            return -1;
        }else{
            return 0;
        }
    }

    //variables that records the results
    int dealerWin = 0;
    int playerWin = 0;
    int push = 0;

    //determine who wins and change the win time accordingly
    public void determination(){
        if (playerTurn()){
            if (dealerTurn()){
                if (dealerHand.getTotalValue() < playerHand.getTotalValue()){
                    playerWin++;
                } else if (dealerHand.getTotalValue() > playerHand.getTotalValue()){
                    dealerWin++;    
                } else{
                    push++;
                }
            }else{
                playerWin++;
            }
        }else if (dealerTurn()){
            dealerWin++;
        }else{
            push++;
        }
    }

    //play a single game of Blackjack and change the result variables
    public void autoGame(boolean verbose) {
        reset();
        deal();
        playerTurn();
        dealerTurn();
        determination();
    }


//Extensions:

    boolean playerWithinRange = true;
    boolean dealerWithinRange = true;
    String hit = "h";
    String stand = "s";

    //Interactive method
    public void playerTurnInteractive(){
        playerHand.add(theDeck.deal());
        if (playerHand.getTotalValue() > 21){
            playerWithinRange = false;
        }
    }

    //Dealer's strategy: keep making new deals until sum is higher that player's
    public void dealerTurnInteractive(){
        System.out.println("\nDealer's turn:");
        System.out.println(dealerHand);

        if (playerWithinRange){
            while (dealerHand.getTotalValue() < 21 && dealerHand.getTotalValue() < playerHand.getTotalValue()){
                dealerHand.add(theDeck.deal());
                System.out.println(dealerHand);
            }
        }

        if (dealerHand.getTotalValue() > 21){ 
            dealerWithinRange = false;
        }
    }

    public static void main(String[] args) {
        Blackjack myBlackjack = new Blackjack(52);
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nGame "+i+" result:");
            System.out.println(myBlackjack.game(true));
            System.out.println(myBlackjack);
        }
    }

}

