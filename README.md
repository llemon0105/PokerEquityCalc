# PokerEquityCalc

A Texas Hold'em equity calculator built in Java. Given your hole cards, it simulates 
10,000 random board runouts using Monte Carlo simulation to estimate your probability 
of winning against a random opponent's hand.

## Features
- Full 52-card deck representation with shuffling and dealing
- Hand evaluator supporting all 10 poker hand rankings
- Best 5-card selection from 7 cards (2 hole cards + 5 community cards)
- Monte Carlo simulation engine running 10,000 randomized runouts
- Interactive CLI — enter your hole cards at runtime
- Win/Loss/Tie equity output as percentages

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run Main.java
4. Enter your two hole cards when prompted (rank as 2-14, suit as Hearts/Diamonds/Clubs/Spades)

## Technologies
- Java 26
- IntelliJ IDEA
- Git

## Example Output
Enter card 1 rank (2-14, where 11=J, 12=Q, 13=K, 14=A): 14

Enter card 1 suit (Hearts/Diamonds/Spades/Clubs): Spades

Enter card 2 rank (2-14, where 11=J, 12=Q, 13=K, 14=A): 14

Enter card 2 suit (Hearts/Diamonds/Spades/Clubs): Clubs

Your hand: A♠ A♣

Results after 10,000 simulations:

Win:  86.17%

Loss: 13.74%

Tie:  0.09%

## Roadmap
- [x] Interactive CLI input
- [x] Tiebreaker logic using rank comparison
- [ ] Category-specific tiebreakers (pair vs pair, flush vs flush, etc.)
- [ ] Opponent range input (e.g. top 15% of hands)
- [ ] Multi-way pot support (3+ players)
- [ ] Known board cards input (flop/turn/river)
- [ ] JavaFX visual dashboard
- [ ] Export results to CSV
