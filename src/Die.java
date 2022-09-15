import java.util.Random;

public class Die {
    private int currentDice;
    private int maxDice;

    private static Random random = new Random();

    public Die() {
        maxDice = 6;
    }

    public Die(int sides) {
        maxDice = sides;
    }

    public void roll() {
        currentDice = random.nextInt(maxDice) + 1;
    }

    public int getCurrentDice() {
        return currentDice;
    }

    public int getMaxDice() {
        return maxDice;
    }

    public Random getRandom() {
        return random;
    }
}