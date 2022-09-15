import java.util.ArrayList;

public class Player {
    private String name;
    private int points;
    private ArrayList<Die> dice = new ArrayList<Die>();

    public Player(String name) {
        this.name = name;
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getDieValue() {
        int total = 0;
        for (Die die : dice) {
            total += die.getCurrentDice();
        }

        return total;
    }

    public void increaseScore() {
        points++;
    }

    public void addDie(int sides) {
        dice.add(new Die(sides));
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Die> getDice() {
        return dice;
    }
}