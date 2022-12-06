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

    public void setToCountCards(Card[] toCountCards) {
        this.toCountCards = toCountCards;
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

    public Card[] getArmCards() { return armCards; }
}