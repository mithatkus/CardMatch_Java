import java.util.*;

public class ComputerPlayer extends Player{

    /*
    constructor: takes the name of the player as a parameter and calls the constructor of the superclass to do the actual 
    work of initializing the inherited fields.
    */
    
    public ComputerPlayer(String nameOfPlayer){
        super(nameOfPlayer);
    }

    /*
    displayHand: overrides the inherited version of that method. This version of the method should simply print the number
    of cards in the ComputerPlayer‘s hand.
    */

    public void displayHand(){
        System.out.println(this.getName() + "'s hand:");
        if (this.getNumCards() == 1){
            System.out.println("  " + this.getNumCards() + " card" );
        }
        else{
            System.out.println("  " + this.getNumCards() + " cards" );
        }
    }

    /*
    getPlay: overrides the inherited version of that method. This version of the method should figure out if the computer has
    a card that matches the card at the top of the discard pile
    */

    public int getPlay(Scanner scan, Card topCard){
        int latestIndex = -1;
        for (int i = 0; i < this.getNumCards(); i++){
            if (this.getCard(i).matches(topCard) == true){
                latestIndex = i;
            }
        }
        return latestIndex;
    }
}