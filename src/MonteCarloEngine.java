import java.util.ArrayList;

public class MonteCarloEngine {

    private ArrayList<Card> p1;
    private ArrayList<Card> p2;

    public MonteCarloEngine(ArrayList<Card> p1) {
        this.p1 = p1;
    }

    public void runSimulation() {
        int wins = 0;
        int losses = 0;
        int ties = 0;

        for (int i = 0; i < 10000; i++) {
            Deck deck = new Deck();
            deck.shuffle();

            for (Card card : p1) {
                deck.getCards().remove(card);
            }
            p2 = new ArrayList<>();
            p2.add(deck.dealCard());
            p2.add(deck.dealCard());

            ArrayList<Card> community = new ArrayList<Card>();

            for (int j = 0; j < 5; j++) {
                community.add(deck.dealCard());
            }
            ArrayList<Card> hero = new ArrayList<Card>(p1);
            ArrayList<Card> villain = new ArrayList<Card>(p2);
            hero.addAll(community);
            villain.addAll(community);

            HandEvaluator evaluator = new HandEvaluator();
            int score1 = evaluator.evaluateBestHand(hero);
            int score2 = evaluator.evaluateBestHand(villain);

            if (score1 > score2) {
                wins++;
            } else if (score1 < score2) {
                losses++;
            } else {
                int tieBreak = evaluator.breakTie(hero, villain, score1);
                if (tieBreak == 1) {
                    wins++;
                } else if (tieBreak == 2) {
                    losses++;
                } else {
                    ties++;
                }
            }
        }
        System.out.print("Your hand: ");
        for (int k = 0; k < p1.size(); k++) {
            System.out.print(p1.get(k) + " ");
        }
        ;
        System.out.println("\nResults after 10,000 simulations:");
        System.out.println("Win: " + (wins * 100.0 / 10000) + "%");
        System.out.println("Loss: " + (losses * 100.0 / 10000) + "%");
        System.out.println("Tie: " + (ties * 100.0 / 10000) + "%");
    }


}
