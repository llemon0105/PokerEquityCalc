import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HandEvaluator {

    public boolean isFlush(ArrayList<Card> hand) {
        String firstSuit = hand.get(0).getSuit();

        for (Card card : hand) {
            if (!card.getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight(ArrayList<Card> hand) {
        ArrayList<Card> sorted = new ArrayList<>(hand);
        sorted.sort(Comparator.comparingInt(Card::getRank));

        int firstRank = sorted.get(0).getRank();

        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).getRank() != firstRank + i) {
                return false;
            }
        }
        return true;
    }

    public boolean isPair(ArrayList<Card> hand) {
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

    public boolean isStraightFlush(ArrayList<Card> hand) {
        return isStraight(hand) && isFlush(hand);
    }

    public boolean isRoyalFlush(ArrayList<Card> hand) {
        ArrayList<Card> sorted = new ArrayList<>(hand);
        sorted.sort(Comparator.comparingInt(Card::getRank));

        int lowestRank = sorted.get(0).getRank();

        return isStraightFlush(hand) && lowestRank == 10;
    }

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
        } else if (score == 2){
            return "Pair";
        }else{
            return "High Card";
        }
    }


}
