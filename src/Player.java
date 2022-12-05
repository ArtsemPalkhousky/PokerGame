public class Player {
    String name;
    int bank = 100;
    Card[] arm = new Card[2];

    public Player(){

    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArm(Card[] arm) {
        this.arm = arm;
    }

    public int getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public Card[] getArm() {
        return arm;
    }
}