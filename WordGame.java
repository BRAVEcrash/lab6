import java.util.Random;

public class WordGame {
    private String[] words;

    public WordGame(String[] words) {
        this.words = words;
    }

    public String selectWord() {
        Random rand = new Random();
        return words[rand.nextInt(words.length)];
    }

    public static boolean check(String solution, StringBuffer answer, char guess) {
        boolean found = false;
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess) {
                answer.setCharAt(i, guess);
                found = true;
            }
        }
        return found && answer.toString().equals(solution);
    }
}
