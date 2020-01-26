import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {

        Deck deck = new Deck();
        ArrayList<Card> hand = (ArrayList<Card>) deck.assign(5);
        deck.printAllSpades(hand);
        deck.collectHearts(hand);
        deck.getColors(hand);
        deck.getSumOfFaces(hand);
        deck.findQueenOfSpades(hand);
        deck.checkIfFlush(hand);


    }

}
