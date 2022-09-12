# Interactive Blackjack Game :black_joker:
A blackjack game in Java, Project 1 of CS231


## :bookmark_tabs: Abstract
In this project, I use Java classes to create the game “Blackjack”, in which the player is able to play with the computer. I’ve utilized Java’s object-orientated design, as well as Arraylist.

## 🤗 How did I make an interactive game
In Blackjack class:
1. The playerTurnInteractive() method takes a card from the deck and adds it to hand each time it’s called. If the total value exceeds 21, the playerWithinRange variable would be assigned “false”.
2. The dealerTurnInteractive() automatically keeps drawing cards from the deck. My strategy for the dealer is to stop drawing when the total value exceeds 21 or when the dealers’ total value exceeds the player’s. If dealer’s total value exceeds 21, the dealer WithinRange variable would be assigned “false”.
In the Interactive class:
1. I used the Scanner object and methods to read the lines that user inputs in Terminal.
2. The player gets to choose either to hit “h” or stand “s” after each deal. Once the player chooses “s” or the player’s total value exceeds 21, the game will switch to the dealer’s turn.
3. The cards in the hand as well as the sum is printed after each deal, so the player can see what they have and the progress of the game is clear.
