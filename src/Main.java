import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        Card c1 = new Card(11, "Hearts");
//        System.out.println(c1);
//
//        Card c2 = new Card(1,"Spades");
//        System.out.println(c2);

//        Deck d1 = new Deck();
//        System.out.println(d1.getCards().size());
//        System.out.println(d1.dealCard());
//        System.out.println(d1.getCards().size());
//        System.out.println(d1.dealCard());

        Deck d1 = new Deck();
        d1.shuffle();
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            cards.add(d1.dealCard());
        }
        System.out.println(cards);

        HandEvaluator h = new HandEvaluator();
//        boolean ans = h.isTwoPair(cards);
//        System.out.println(ans);

        boolean three = h.isThreeOfAKind(cards);
        System.out.println(three);


    }
}
