import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
        String [] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};

        for(int i = 0; i < 4; i ++){
            for(int j = 2; j <= 14 ; j ++){
                cards.add(new Card(j, suits[i]));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        return cards.remove(0);
    }

    public ArrayList<Card> getCards(){
        return cards;
    }




}
