import java.util.Scanner;


public class gameMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int AmountOfPlayers = 2;                   ////// Любое значение > 0 && < 26

        Player[] players = new Player[AmountOfPlayers];
        for (int i = 0; i < AmountOfPlayers; i++) {
            players[i] = new Player();
        }
        Table table = new Table();

        int j = 0;
        do {
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
        for (Player player: players) {
            Card[] armCards = new Card[2];
            armCards[0] = deck.takeCardFromDeck();
            armCards[1] = deck.takeCardFromDeck();
            player.setArmCards(armCards);
        }

        for (Player player: players) {
            System.out.printf("\n%d) %s \n", j + 1, player.getName());
            player.getArmCards()[0].print();
            System.out.print(" ");
            player.getArmCards()[1].print();
            j++;
        }

        // Поставить первую ставку
        // Положить 3 карты
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.printBoard();

        //...
        //Положить 4 карты
        table.putToBoard(deck.takeCardFromDeck());
        table.printBoard();

        //...
        //Положить 5 карт
        table.putToBoard(deck.takeCardFromDeck());
        table.printBoard();

        //...

        // 5 массивов по 7 элементов
        Card[] bCards = table.getBoard();
        for (Player player: players) {
            Card[] pCards = player.getArmCards();
            Card[] toCountCards = new Card[5+2];
            int i;
            for (i = 0; i < 5; i++){
                toCountCards[i] = bCards[i];
            }
            toCountCards[i++] = pCards[0];
            toCountCards[i] = pCards[1];
            player.setToCountCards(toCountCards);
        }

        for (Player player: players){
            Card[] toCountCards = player.getToCountCards();
            System.out.printf("\n\nName: %s\nCards: ", player.getName());
            for (Card card: toCountCards) {
                card.print();
            }
        }

        int[] AllResults = new int[AmountOfPlayers];
        int maxIndex = 0;
        for (Player player: players) {
            int Result = countFinalCombination(player.getToCountCards());
            AllResults[maxIndex] = Result;
        }

        int max = AllResults[0];
        for (int i = 1; i < AllResults.length; i++) {
            if (AllResults[i] > max) {
                max = AllResults[i];
                maxIndex = i;
            }
        }

        System.out.printf("\n\nWe have a WINNER!!!\n%d) %s with   ", maxIndex + 1, players[maxIndex].getName());
        boards winner = boards.values()[max];
        System.out.print(winner);
    }

    public static int countFinalCombination(Card[] toCountCards){

        //----------------------- Парные комбинации -----------------------
        return boards.FourOfAKind.ordinal();
//        return boards.FullHouse.ordinal();
//        return boards.ThreeOfAKind.ordinal();
//        return boards.TwoPair.ordinal();
//        return boards.Pair.ordinal();
//        //----------------------- Для флешей и стритов --------------------
//        return boards.RoyalFlush.ordinal();
//        return boards.StraightFlush.ordinal();
//        return boards.Flush.ordinal();
//        return boards.Straight.ordinal();
//        //----------------------- Для старшей карты -----------------------
//        return boards.HighCard.ordinal();
    }


}