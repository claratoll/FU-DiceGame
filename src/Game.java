import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();

    public Game() {
        initialize();
    }

    private static ArrayList<Player> initialize() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hur många spelare vill spela? ");
        int playerNum = userInput.nextInt();

        userInput.nextLine();
        for (int i = 0; i < playerNum; i++) {
            System.out.println("Skriv in namn på Spelare " + (i + 1));
            String playerName = userInput.nextLine();
            players.add(new Player(playerName));
        }

        for (Player player : players) {
            System.out.println(player.getName() + ", hur många tärningar vill du ha? ");
            int dieNum = userInput.nextInt();

            System.out.println("Hur många sidor vill du ha? ");
            int dieSides = userInput.nextInt();

            for (int i = 0; i < dieNum; i++) {
                player.addDie(dieSides);
            }
        }

        for (int i = 0; i < 5; i++) {
            takeTurn(players);
        }

        for (Player winner : getWinners(players)) {
            System.out.format("Vinnare: %s - %d poäng\n", winner.getName(), winner.getPoints());
        }
        return players;
    }
    private static void takeTurn(ArrayList<Player> players) {
        Scanner userInput = new Scanner(System.in);
        for (Player player : players) {
            player.rollDice();

            System.out.println(player.getName() + ", gissa den totala summan? ");
            int guess = userInput.nextInt();
            if (player.getDieValue() == guess) {
                player.increaseScore();
                System.out.println("You got point");
            } else {
                System.out.println("You guessed wrong");
            }

            System.out.println("Total dice value: " + player.getDieValue());
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<Player>();

        int maxPoints = -1; //Assuming it is not possible to have negative points
        for (int i = 0; i < players.size(); i++)
        {
            int points = players.get(i).getPoints();
            if (points >= maxPoints) {
                if (points >= maxPoints) {
                    winners.add(players.get(i));
                }
                maxPoints = points;
            }
        }

        return winners;
    }
}