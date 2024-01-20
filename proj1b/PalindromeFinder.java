/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt"); // I thought it's wrong but right!
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByOne();
        CharacterComparator cc_N = new OffByN(3);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,cc_N)) {
                System.out.println(word);
            }
        }
    }
}
