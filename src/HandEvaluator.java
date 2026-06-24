import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

//Evaluates poker hands and determines the best hand from a set of cards
public class HandEvaluator {

    //Return true if all 5 cards share the same suit
    public boolean isFlush(ArrayList<Card> hand) {
        String firstSuit = hand.get(0).getSuit();

        for (Card card : hand) {
            if (!card.getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }

    //Returns true if the 5 cards form a consecutive sequence of ranks
    public boolean isStraight(ArrayList<Card> hand) {
        //Copy to avoid modifying the original hand
        ArrayList<Card> sorted = new ArrayList<>(hand);
        //Sort by rank to check consecutiveness
        sorted.sort(Comparator.comparingInt(Card::getRank));

        int firstRank = sorted.get(0).getRank();

        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).getRank() != firstRank + i) {
                return false;
            }
        }
        return true;
    }

    //Returns true if exactly two cards share the same rank
    public boolean isPair(ArrayList<Card> hand) {
        //Count occurrences of each rank using a HashMap
        HashMap<Integer, Integer> rankCount = new HashMap<>();

        for (int i = 0; i < hand.size(); i++) {
            int rank = hand.get(i).getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCount.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    //Returns true if two different ranks each appear exactly twice
    public boolean isTwoPair(ArrayList<Card> hand) {
        HashMap<Integer, Integer> rankCount = new HashMap<>();

        for (int i = 0; i < hand.size(); i++) {
            int rank = hand.get(i).getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        int counter = 0;

        for (int count : rankCount.values()) {
            if (count == 2) {
                counter++;
            }
        }

        if (counter == 2) {
            return true;
        }
        return false;
    }

    //Returns true if exactly three cards share the same rank
    public boolean isThreeOfAKind(ArrayList<Card> hand) {
        HashMap<Integer, Integer> rankCount = new HashMap<>();

        for (int i = 0; i < hand.size(); i++) {
            int rank = hand.get(i).getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCount.values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    //Returns true if the hand contain both a three of a kind and a pair
    public boolean isFullHouse(ArrayList<Card> hand) {
        HashMap<Integer, Integer> rankCount = new HashMap<>();
        boolean hasTwo = false;
        boolean hasThree = false;

        for (int i = 0; i < hand.size(); i++) {
            int rank = hand.get(i).getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCount.values()) {
            if (count == 2) {
                hasTwo = true;
            }
            if (count == 3) {
                hasThree = true;
            }
        }
        return hasTwo && hasThree;
    }

    //Return true if exactly four cards share the same rank
    public boolean isFourOfAKind(ArrayList<Card> hand) {
        HashMap<Integer, Integer> rankCount = new HashMap<>();

        for (int i = 0; i < hand.size(); i++) {
            int rank = hand.get(i).getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCount.values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    //Returns true if the hand is both a straight and a flush
    public boolean isStraightFlush(ArrayList<Card> hand) {
        return isStraight(hand) && isFlush(hand);
    }

    //Returns true if the hand is a straight flush with a lowest rank of 10 (10-J-Q-K-A)
    public boolean isRoyalFlush(ArrayList<Card> hand) {
        ArrayList<Card> sorted = new ArrayList<>(hand);
        sorted.sort(Comparator.comparingInt(Card::getRank));

        int lowestRank = sorted.get(0).getRank();

        return isStraightFlush(hand) && lowestRank == 10;
    }

    //Evaluates a 5-card hand and returns a score from 1 (High Card) to 10 (Royal Flush)
    public int evaluateHand(ArrayList<Card> hand) {
        if (isRoyalFlush(hand)) {
            return 10;
        } else if (isStraightFlush(hand)) {
            return 9;
        } else if (isFourOfAKind(hand)) {
            return 8;
        } else if (isFullHouse(hand)) {
            return 7;
        } else if (isFlush(hand)) {
            return 6;
        } else if (isStraight(hand)) {
            return 5;
        } else if (isThreeOfAKind(hand)) {
            return 4;
        } else if (isTwoPair(hand)) {
            return 3;
        } else if (isPair(hand)) {
            return 2;
        } else {
            return 1;
        }
    }

    //Returns the name of the hand as a string based on its score
    public String handTitle(ArrayList<Card> hand) {
        int score = evaluateHand(hand);

        if (score == 10) {
            return "Royal Flush";
        } else if (score == 9) {
            return "Straight Flush";
        } else if (score == 8) {
            return "Four of a Kind";
        } else if (score == 7) {
            return "Full House";
        } else if (score == 6) {
            return "Flush";
        } else if (score == 5) {
            return "Straight";
        } else if (score == 4) {
            return "Three of a Kind";
        } else if (score == 3) {
            return "Two Pair";
        } else if (score == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    //Tries all 21 possible 5-card combinations from 7 cards and return the best score
    public int evaluateBestHand(ArrayList<Card> sevenCards) {
        int best = 0;

        for (int i = 0; i < sevenCards.size(); i++) {
            for (int j = i + 1; j < sevenCards.size(); j++) {
                ArrayList<Card> fiveCards = new ArrayList<>(sevenCards);
                //Remove higher index first to avoid index shifting
                fiveCards.remove(j);
                fiveCards.remove(i);
                int score = evaluateHand(fiveCards);
                if (score > best) best = score;
            }
        }
        return best;
    }

    //Compares two hands of equal category and returns 1 if hand1 wins, 2 if hand2 wins, and 0 if true tie
    public int breakTie(ArrayList<Card> hand1, ArrayList<Card> hand2, int handScore) {
        //Sort both hands highest to lowest for card-by-card comparison
        ArrayList<Card> sorted1 = new ArrayList<Card>(hand1);
        sorted1.sort(Comparator.comparingInt(Card::getRank).reversed());
        ArrayList<Card> sorted2 = new ArrayList<Card>(hand2);
        sorted2.sort(Comparator.comparingInt(Card::getRank).reversed());

        for (int i = 0; i < sorted1.size(); i++) {
            if (sorted1.get(i).getRank() > sorted2.get(i).getRank()) {
                return 1;
            }
            if (sorted1.get(i).getRank() < sorted2.get(i).getRank()) {
                return 2;
            }
        }
        return 0;
    }
}
