public class Table {
    int bet;
    Card[] board = new Card[5];
    private int counter = 0;


    public Table() {
        counter = 0;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void putToBoard(Card card){
        board[counter] = new Card();
        board[counter++] = card;
    }

    public Card[] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("\n\n    BOARD:");
        for (int i = 0; i < 5; i++) {
            if (board[i] != null) {
                board[i].print();
                System.out.print(" ");
            } else return;
        }
    }
}
