import java.util.ArrayList;

//Runs Monte Carlo simulations to estimate poker hand equity
public class MonteCarloEngine {
    private ArrayList<Card> p1;
    private ArrayList<Card> p2;

    //Takes the players' two hole cards as input
    public MonteCarloEngine(ArrayList<Card> p1) {
        this.p1 = p1;
    }

    //Simulates 10,000 random board runouts and prints win/loss/tie equity
    public void runSimulation() {
        int wins = 0;
        int losses = 0;
        int ties = 0;

        for (int i = 0; i < 10000; i++) {
            //Create a fresh shuffled deck with each simulation
            Deck deck = new Deck();
            deck.shuffle();

            //Remove player's hole cards from deck so they can't be dealt again
            for (Card card : p1) {
                deck.getCards().remove(card);
            }

            //Deal two random cards to the opponent
            p2 = new ArrayList<>();
            p2.add(deck.dealCard());
            p2.add(deck.dealCard());

            //Deal 5 community cards
            ArrayList<Card> community = new ArrayList<Card>();
            for (int j = 0; j < 5; j++) {
                community.add(deck.dealCard());
            }

            //Combine hole cards and community cards into 7 cards
            ArrayList<Card> hero = new ArrayList<Card>(p1);
            ArrayList<Card> villain = new ArrayList<Card>(p2);
            hero.addAll(community);
            villain.addAll(community);

            //Evaluate the best 5-card hand for each player
            HandEvaluator evaluator = new HandEvaluator();
            int score1 = evaluator.evaluateBestHand(hero);
            int score2 = evaluator.evaluateBestHand(villain);

            if (score1 > score2) {
                wins++;
            } else if (score1 < score2) {
                losses++;
            } else {
                //Same hand category - use tiebreaker to compare card ranks
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

        //Print results as percentages
        System.out.print("Your hand: ");
        for (int k = 0; k < p1.size(); k++) {
            System.out.print(p1.get(k) + " ");
        }
        System.out.println("\nResults after 10,000 simulations:");
        System.out.println("Win: " + (wins * 100.0 / 10000) + "%");
        System.out.println("Loss: " + (losses * 100.0 / 10000) + "%");
        System.out.println("Tie: " + (ties * 100.0 / 10000) + "%");
    }
}
