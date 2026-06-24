import java.util.ArrayList;
import java.util.Collections;

//Represents a standard 52-card deck with shuffling and dealing functionality
public class Deck {
    private ArrayList<Card> cards;

    //Builds a full 52-card deck with all ranks (2-14) and suits
    public Deck() {
        cards = new ArrayList<Card>();
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};

        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 14; j++) {
                cards.add(new Card(j, suits[i]));
            }
        }
    }

    //Randomly shuffles the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //Removes and returns the top card from the deck
    public Card dealCard() {
        return cards.remove(0);
    }

    //Returns the remaining cards in the deck
    public ArrayList<Card> getCards() {
        return cards;
    }
}
