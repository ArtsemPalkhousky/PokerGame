import java.util.Scanner;

public class gameMain {
    public static void main(String[] args) {
        int AmountOfPlayers = 3;
        Player[] players = new Player[AmountOfPlayers];
        for (int i = 0; i < AmountOfPlayers; i++) {
            players[i] = new Player();
        }

        Scanner in = new Scanner(System.in);
        int j = 0;
        Deck deck = new Deck();
        deck.shuffleIt();
        deck.shuffleIt();
        deck.shuffleIt();
        deck.shuffleIt();

        for (Player player: players) {
            Card[] armCards = new Card[2];
            armCards[0] = deck.takeCardFromDeck();
            armCards[1] = deck.takeCardFromDeck();
            player.setArmCards(armCards);
        }

        for (Player player: players) {
            System.out.printf("\n      %s \n", player.getName());
            player.getArmCards()[0].print();
            System.out.print(" ");
            player.getArmCards()[1].print();
            j++;
        }

        Table table = new Table();
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.putToBoard(deck.takeCardFromDeck());
        table.printBoard();

        for (Player player: players) {
            player.setToCountCards(table.getBoard());
        }

        int[] AllResults = new int[AmountOfPlayers];
        int maxIndex = 0;
        for (Player player: players) {
            int Result = countCombination(player.getToCountCards());
            AllResults[maxIndex] = Result;
            maxIndex++;
        }

        int max = AllResults[0];
        maxIndex = 0;
        for (int i = 1; i < AllResults.length; i++) {
            if (AllResults[i] >= max) {
                max = AllResults[i];
                maxIndex = i;
            }
        }

        System.out.print("\nWe have a WINNERs!!!  ");
        boards winner = boards.values()[max];
        System.out.println(winner);
        for (int i = 0; i < AllResults.length; i++) {
            if (AllResults[i] == max) {
                System.out.printf("%d) %s\n", i + 1, players[i].getName());
            }
        }
    }


    public static int countCombination(Card[] toCountCards) {
        int[] bytesCombination = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bytesValue = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bytesLear = {0, 0, 0, 0};
        for (Card card : toCountCards) {
            bytesValue[card.getValue().ordinal()]++;
            bytesLear[card.getLear().ordinal()]++;
        }

        //-----------------------------------------Для парных комбинаций----------------------------------------------------
        boolean wasPairCombination = false;
        for (int i = 0; i < 13; i++) {
            if (bytesValue[i] >= 2) {
                wasPairCombination = true;
                if (bytesValue[i] == 4) {
                    bytesCombination[boards.FourOfAKind.ordinal()] = 1;         // Каррэ
                    break;
                } else {
                    if (bytesValue[i] == 3) {
                        bytesCombination[boards.ThreeOfAKind.ordinal()] = 1;    // Сет
                    } else {
                        if (bytesValue[i] == 2) {
                            bytesCombination[boards.Pair.ordinal()] = 1;        // Пара
                        }
                    }
                }
            }
            for (int j = 0; j < 13; j++) {
                if (j == i) continue;
                if (bytesValue[j] >= 2) {
                    if (bytesValue[j] == 2 && bytesCombination[boards.ThreeOfAKind.ordinal()] == 1) {
                        bytesCombination[boards.FullHouse.ordinal()] = 1;       // Фулл хаус
                        break;
                    } else {
                        if (bytesValue[j] == 3 && bytesCombination[boards.Pair.ordinal()] == 1) {
                            bytesCombination[boards.FullHouse.ordinal()] = 1;   // Фулл хаус
                            break;
                        } else {
                            if (bytesCombination[boards.Pair.ordinal()] == 1) {
                                if (bytesCombination[boards.Pair.ordinal()] < j) {
                                    bytesCombination[boards.TwoPair.ordinal()] = 1; // Две пары
                                }
                            }
                            else {
                                bytesCombination[boards.Pair.ordinal()] = 1;
                            }
                        }
                    }
                }
            }
            break;
        }
        //-----------------------------------------Для флешей и стритов-----------------------------------------------------
        boolean wasFlush = false;
        boolean wasStraight = false;
        for (int i = 0; i < 4; i++) {
            if (bytesLear[i] == 5) {
               bytesCombination[boards.Flush.ordinal()] = 1;               // Флеш
               wasFlush = true;
               break;
            }
        }
        int Index = 1;
        for (int i = 0; i < 9; i++) {
            if (bytesValue[i] == 1) {
                while (bytesValue[i + Index] == 1) {
                    Index++;
                    if (Index == 5) {
                       bytesCombination[boards.Straight.ordinal()]++;     // Стрит
                       wasStraight = true;                                // bytesCombination[boards.Straight.ordinal()]
                    }                                                     // can be from 1 to 3
                    if (Index + i == 13) {
                        break;
                    }
                }
            }
            if (Index == 3 || Index == 4) {
                break;
            }
            else {
                Index = 1;
            }
        }
        if (wasStraight && wasFlush) {
            if (bytesValue[Value.Ace.ordinal()] == 1) {
                bytesCombination[boards.RoyalFlush.ordinal()] = 1;             // Рояль Флеш
            }
        }
        //--------------------------------------------Для старшей карты-------------------------------------------------------
        if (!wasPairCombination && !wasStraight && !wasFlush) {
            bytesCombination[boards.HighCard.ordinal()] = 1;                   // Старшая карта
        }
        for (int i = bytesCombination.length - 1; i >= 0; i--) {               // return index of first highest Combination
            if (bytesCombination[i] >= 1) {
                return i;
            }
        }
        return 1000;                                                           // error returns
    }
}