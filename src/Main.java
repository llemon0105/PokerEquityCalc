import java.security.spec.RSAOtherPrimeInfo;

public class Main {

    public static void main(String[] args) {

//        Card c1 = new Card(11, "Hearts");
//        System.out.println(c1);
//
//        Card c2 = new Card(1,"Spades");
//        System.out.println(c2);

        Deck d1 = new Deck();
        System.out.println(d1.getCards().size());
        System.out.println(d1.dealCard());
        System.out.println(d1.getCards().size());
        System.out.println(d1.dealCard());


    }
}
