import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ArrayList<Card> p1 = new ArrayList<>();
        for(int i = 1; i <= 2; i ++){
            System.out.print("Enter card " + i + " rank (2-14, where 11=J, 12=Q, 13=K, 14=A): ");
            int rank = reader.nextInt();
            System.out.print("Enter card " + i + " suit (Hearts/Diamnonds/Spades/Clubs): ");
            String suit = reader.next();
            Card card = new Card(rank, suit);
            p1.add(card);
        }

        MonteCarloEngine engine = new MonteCarloEngine(p1);
        engine.runSimulation();
    }
}
