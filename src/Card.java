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
        System.out.print(lear + " " + value);
    }
}

enum Lear{
    s,     //пика
    c,     //креста
    h,     //чирва
    t      //бубна
}

enum Value{
    two,    three,    four,    five,
    six,    seven,    eight,   nine,
    ten,    jack,     queen,   king,
    ace
}
