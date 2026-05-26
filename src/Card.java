public class Card {

    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String rankStr;
        if (rank == 14) {
            rankStr = "A";
        } else if (rank == 13) {
            rankStr = "K";
        } else if (rank == 12) {
            rankStr = "Q";
        } else if (rank == 11) {
            rankStr = "J";
        } else {
            rankStr = String.valueOf(rank);
        }

        String suitSym;
        if (suit.equals("Spades")) {
            suitSym = "♠";
        } else if (suit.equals("Clubs")) {
            suitSym = "♣";
        } else if (suit.equals("Hearts")) {
            suitSym = "♥";
        } else {
            suitSym = "♦";
        }

        return rankStr + suitSym;
    }


}
