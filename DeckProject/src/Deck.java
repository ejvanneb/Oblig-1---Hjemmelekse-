import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Deck {

    public ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        this.fillDeck();
    }

public void fillDeck() {
        if(deck.size() > 0) {
        for(int i2 = 0; i2 < deck.size(); i2++) {

            deck.remove(i2);
        }
       }

        for(int i = 1; i < 14; i++) {

            deck.add(new Card('H', i));
            deck.add(new Card('D', i));
            deck.add(new Card('C', i));
            deck.add(new Card('S', i));
        }

}

    public Collection<Card> assign(int n) {

            ArrayList<Card> hand = new ArrayList<>();
            int testCounter = 0;
            int currentAmountOfCards = 51;
            if(n > 0 || n < 52) {
                for (int i = 0; i < n; i++) {
                    int number = (int) (Math.random() * currentAmountOfCards);
                    hand.add(deck.get(number));
                    deck.remove(number);
                    currentAmountOfCards = currentAmountOfCards - 1;
                    System.out.println(hand.get(testCounter).getDetails());
                    testCounter = testCounter + 1;
                }
                return hand;
            } else {
                System.out.println("Please choose a number between 1 and 52");
                return null;
            }
    }

    public void printHand() {

        System.out.print(deck.get(45).getDetails());
    }

    public void printAllSpades(ArrayList<Card> hand) {

        hand.stream().filter((card -> card.getSuit() == 'S')).forEach(Card::printCard);
    }

    public Collection<Card> collectHearts(ArrayList<Card> hand) {

        List<Card> hearts = hand.stream().filter((card -> card.getSuit() == 'H')).collect(Collectors.toList());

            hearts.forEach(Card::printCard);
            return hearts;
    }

    public List<String> getColors(ArrayList<Card> hand) {

        List<String> colors = hand.stream().map(card -> card.getSuitAsColor()).collect(Collectors.toList());
        System.out.println(colors);
        return colors;
    }

    public int getSumOfFaces(ArrayList<Card> hand) {

        int sumOfFaces = hand.stream().reduce(0, (integer, card) -> integer + card.getFace(), Integer::sum);
        System.out.println(sumOfFaces);
        return sumOfFaces;
    }

    public boolean findQueenOfSpades(ArrayList<Card> hand) {

        boolean queenOfSpadesFound = hand.stream().anyMatch(card -> card.getFace() == 12 && card.getSuit() == 'S');
        System.out.println(queenOfSpadesFound);
        return queenOfSpadesFound;
    }
        //Denne oppgaven kan definitivt løses på en bedre måte, men er usikker på hvordan.
    public boolean checkIfFlush(ArrayList<Card> hand) {

        List<Card> heart = hand.stream().filter((card -> card.getSuit() == 'H')).collect(Collectors.toList());
        List<Card> spade = hand.stream().filter((card -> card.getSuit() == 'S')).collect(Collectors.toList());
        List<Card> club = hand.stream().filter((card -> card.getSuit() == 'C')).collect(Collectors.toList());
        List<Card> diamond = hand.stream().filter((card -> card.getSuit() == 'D')).collect(Collectors.toList());

        int reds = (int) heart.stream().count() + (int) diamond.stream().count();
        int blacks = (int) spade.stream().count() + (int) club.stream().count();

        if(reds == 5 || blacks == 5) {
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }
    }
}