public class Document {

    public String[] splitWords(String sentence) {
        return sentence.trim().split("\\s+");
    }

    public int[] countLetters(String[] words) {
        int[] letterCount = new int[26];
        for (String word : words) {
            for (char ch : word.toLowerCase().toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    letterCount[ch - 'a']++;
                }
            }
        }
        return letterCount;
    }

    public int totalLetters(int[] counter) {
        int total = 0;
        for (int count : counter) {
            total += count;
        }
        return total;
    }
}
