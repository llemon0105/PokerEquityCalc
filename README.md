# PokerEquityCalc

A Texas Hold'em equity calculator built in Java. Given your hole cards, it simulates 
10,000 random board runouts using Monte Carlo simulation to estimate your probability 
of winning against a random opponent's hand.

## Features
- Full 52-card deck representation with shuffling and dealing
- Hand evaluator supporting all 10 poker hand rankings
- Best 5-card selection from 7 cards (2 hole cards + 5 community cards)
- Monte Carlo simulation engine running 10,000 randomized runouts
- Win/Loss/Tie equity output as percentages

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. In Main.java, choose one of the two ways to set your hole cards:

Option 1 - Specify your own cards:
ArrayList<Card> p1 = new ArrayList<>();
p1.add(new Card(14, "Spades"));  // Ace of Spades
p1.add(new Card(14, "Clubs"));  // Ace of Clubs

Option 2 - Deal random hole cards:
Deck deck = new Deck();
deck.shuffle();
ArrayList<Card> p1 = new ArrayList<>();
p1.add(deck.dealCard());
p1.add(deck.dealCard());

4. Run Main.java

## Technologies
- Java 26
- IntelliJ IDEA
- Git

## Example Output
Your hand: A♠ A♣

Results after 10,000 simulations:

Win:  49.6%

Loss: 13.7%

Tie:  36.7%

Note: Tie % is elevated due to known limitation — see Known Limitations below.

## Roadmap
- [ ] Tiebreaker/kicker comparison within same hand category
- [ ] Opponent range input (e.g. top 15% of hands)
- [ ] Known board cards input (flop/turn/river)
- [ ] JavaFX visual dashboard
- [ ] Export results to CSV

## Known Limitations
- Tiebreaker logic within the same hand category is not yet implemented
  (e.g. Ace-high flush vs King-high flush counts as a tie)
- As a result, Tie % is inflated, and Win % is lower than real-world equity
- Win + Tie combined (~86%) closely approximates true pocket aces equity
- Future versions will implement kicker comparison for more accurate results
