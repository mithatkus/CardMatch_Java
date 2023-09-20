import java.util.*;

/*
we identify three fields
*/

public class Player{
    private String name;
    private Card[] hand;
    private int numCards;

    /*
    constructior: takes a single parameter for the name of the player and initializes all of the fields
    */

    public Player(String playerName){
        this.name = playerName;
        this.hand = new Card[CardMatch.MAX_CARDS];
        this.numCards = 0;
    }

    /*
    getName: returns the player’s name.
    */

    public String getName(){
        return this.name;
    }

    /*
    getNumCards: that returns the current number of cards in the player’s hand.
    */

    public int getNumCards(){
        return this.numCards;
    }

    /*
    toString: returns the player’s name.
    */
    

    public String toString(){
        String str = this.getName();
        return str;
    }

    /*
    addCard: takes a Card object as a parameter and adds the specified card to the player’s hand, filling the array from 
    left to right.
    */

    public void addCard(Card newCard){
        if (newCard == null || this.numCards == this.hand.length){
            throw new IllegalArgumentException();
        }
        else{
            this.hand[this.numCards] = newCard;
            this.numCards++;
        }
    }

    /*
    getCard: takes an integer index as a parameter and returns the Card at the specified position in the player’s hand,
    without actually removing the card from the hand.
    */

    public Card getCard(int index){
        if (index < 0 || index > this.numCards - 1){
            throw new IllegalArgumentException();
        }
        return this.hand[index];
    }

    /*
    getHandValue: computes and returns the total value of the player’s current hand .
    */

    public int getHandValue(){
        int totalPoints = 0;
        if (this.numCards == CardMatch.MAX_CARDS){
            totalPoints += CardMatch.MAX_CARDS_PENALTY;
        }
        for (int i = 0; i < this.numCards; i ++){
            totalPoints += this.hand[i].getValue();
        }
        return totalPoints;
    }

    /*
    displayHand: prints the current contents of the player’s hand, preceded by a heading that includes the player’s name.
    */

    public void displayHand(){
        System.out.println(this.name + "'s hand:");
        for(int i = 0; i < this.numCards; i++){
            System.out.println("  " + i + ": " + this.hand[i].getColor() + " " + this.hand[i].getValue());
        }
    }
    
    /*
    removeCard: takes an integer index as a parameter and both removes and returns the Card at that position of the 
    player’s hand.
    */

    public Card removeCard(int index){
        Card removed = this.hand[index];
        if (index < 0 || index > this.numCards - 1){
            throw new IndexOutOfBoundsException();
        }
        if (index != this.numCards - 1){
            for (int i = index; i < this.numCards - 1; i++){
                this.hand[i] = this.hand[i+1];
                if (i == this.numCards - 2){
                    Card last = this.hand[index];
                    this.hand[index] = this.hand[i];
                    this.hand[i] = last;
                }
            }
        }
        this.numCards -= 1;
        return removed;
    }

    /*
    getPlay: determines and returns the number corresponding to the player’s next play: either -1 if the player wants to draw a card, 
    or the number/index of the card that the player wants to discard from his/her hand.
    */

    public int getPlay(Scanner scan, Card topCard){
        int num;

        while (true){
            System.out.print(this.name + ":  number of card to play (-1 to draw)? " );
            num = scan.nextInt();

            if (num >= 0 || num < this.numCards){
                System.out.print(this.name + "discards" + this.hand[num].getColor() + " " + this.hand[num].getValue() + ".");
                break;
            }
            else if (num == -1){
                System.out.println(this.name + " draws a card.");
                break;
            }
        }
        scan.close();
        return num;
        
    }

}