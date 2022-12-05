import java.util.Random;

public class Deck {
    Card[] deck = new Card[52];
    private int counter = 0;

    void addCardToDeck(Lear lear, Value value, int i){
        deck[i] = new Card(lear, value);
    };

    public Deck(){
        newDeck();
    }

    void newDeck() {
        int i = 0;
        counter = 0;
        for (Lear lear : Lear.values()) {
            for (Value value: Value.values()) {
                addCardToDeck(lear, value, i);
                i++;
            }
        }
    }

    void shuffleIt() {
        Random rand = new Random();
        counter = 0;
        for(int i = 0; i < deck.length; i++){
            int randomIndexToSwap = rand.nextInt(deck.length);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    void printAllCards(){
        for (Card card: deck) {
            card.print();
        }
    }

    Card takeCardFromDeck(){
        return deck[counter++];
    }
}
