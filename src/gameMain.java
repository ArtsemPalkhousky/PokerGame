import java.util.Scanner;


public class gameMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int AmountOfPlayers = 5;

        Player[] players = new Player[AmountOfPlayers];
        Table table = new Table();


        int j = 0;
        do {
            players[j] = new Player();
            System.out.printf("Enter name of %d player\n", j + 1);
            players[j].setName(in.next());
            j++;
        } while(j < AmountOfPlayers);

        j = 0;  do {
            System.out.printf("%d) %s bank acc: %d \n", j + 1, players[j].getName(), players[j].getBank());
            j++;
        } while(j < AmountOfPlayers);  j = 0;

        Deck deck = new Deck();
        deck.shuffleIt();
        deck.shuffleIt();
        deck.shuffleIt();

        // Раздать карты
        for (Player player : players) {
            Card[] arm = new Card[2];
            arm[0] = deck.takeCardFromDeck();
            arm[1] = deck.takeCardFromDeck();
            player.setArm(arm);
        }

        for (Player player : players) {
            System.out.printf("\n%d) %s \n", j + 1, player.getName());
            player.arm[0].print();
            System.out.print(" ");
            player.arm[1].print();
            j++;
        }

        // Поставить первую ставку

        // Положить на стол три карты
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.printBoard();
    }
}