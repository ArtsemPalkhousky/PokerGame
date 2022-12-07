public class Player {
    String name = "BOT";
    int bank = 100;
    Card[] armCards = new Card[2];
    Card[] toCountCards = new Card[5+2];

    public Player() {  }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArmCards(Card[] armCards) { this.armCards = armCards; }

    public void setToCountCards(Card[] boardCards) {
        int i;
        for (i = 0; i < 5; i++) {
            toCountCards[i] = boardCards[i];
        }
        toCountCards[i++] = armCards[0];
        toCountCards[i] = armCards[1];
    }

    public Card[] getToCountCards() {
        return toCountCards;
    }

    public int getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public Card[] getArmCards() {
        return armCards;
    }
}