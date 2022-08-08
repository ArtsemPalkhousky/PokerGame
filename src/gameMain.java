import java.util.Scanner;

public class gameMain {
    public static void main(String[] args) {
        System.out.println("Game is started!! Let's play");

        Scanner in = new Scanner(System.in);
        int num;
        do {
            System.out.println("Choose how many player would be play (2-4)");
            while (!in.hasNextInt()) {
                in.next();
            }
            num = in.nextInt();
        } while(num > 4 || num < 2) ;
        System.out.printf("Your choose: %d \n", num);
        in.close();


        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Player1 enter your name: ");
        while (!in.hasNextLine()){
            in.next();
        }
        player1.name = in.nextLine();
        System.out.println("Player2 enter your name: ");
        while (!in.hasNextLine()){
            in.next();
        }
        player2.name = in.nextLine();
        in.close();

        System.out.printf("%s bank acc: %d \n", player1.name, player1.bank);
        System.out.printf("%s bank acc: %d \n", player2.name, player2.bank);

    }
}