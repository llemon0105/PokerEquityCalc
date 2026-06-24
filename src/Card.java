//Represents a single playing card with a rank (2-12) and suit
public class Card {
    private int rank; //2-10 = face values, 11=J, 12=Q, 13=K, 14=A
    private String suit; //Hearts, Diamonds, Clubs, Spades

    //Creates a card with the given rank and suit
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

    //Returns the card as a readable string (e.g. A♠, K♥, 7♦)
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

    //Checks the equality based on rank and suit
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Card)) {
            return false;
        }

        Card other = (Card) o;
        return this.rank == other.rank && this.suit.equals(other.suit);
    }
}
