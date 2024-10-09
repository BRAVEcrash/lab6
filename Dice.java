import java.util.Random;

public class Dice {
    private int sides;
    private int currentValue;
    private Random rand;

    public Dice(int sides) {
        this.sides = sides;
        rand = new Random();
        roll();
    }

    public void roll() {
        currentValue = rand.nextInt(sides) + 1;
    }

    @Override
    public String toString() {
        return "현재 주사위 상태 : " + currentValue;
    }
}
