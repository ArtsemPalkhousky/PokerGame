public class Card {
    Lear lear;
    Value value;

    public Card(Lear lear, Value value){
        this.lear = lear;
        this.value = value;
    }

    public Card(){}

    public void setLear(Lear lear) {
        this.lear = lear;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Lear getLear() {
        return lear;
    }

    public Value getValue() {
        return value;
    }

    public void print() {
        System.out.print(value + " " + lear + " ");
    }
}

enum Lear{
    S,       //пика
    C,       //креста
    H,       //чирва
    D        //бубна
}

enum Value{
    Two,    Three,    Four,    Five,
    Six,    Seven,    Eight,   Nine,
    Ten,    Jack,     Queen,   King,
    Ace
}
