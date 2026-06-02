import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Option 1 - Specify your own cards:
        ArrayList<Card> p1 = new ArrayList<>();
        p1.add(new Card(14, "Spades"));  // Ace of Spades
        p1.add(new Card(14, "Clubs"));   // Ace of Clubs

        // Option 2 - Deal random hole cards (comment out Option 1 and uncomment this):
        // Deck deck = new Deck();
        // deck.shuffle();
        // ArrayList<Card> p1 = new ArrayList<>();
        // p1.add(deck.dealCard());
        // p1.add(deck.dealCard());

        MonteCarloEngine engine = new MonteCarloEngine(p1);
        engine.runSimulation();
    }
}
