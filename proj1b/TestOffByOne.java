import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testNewIsPalindrome(){
        Palindrome palin = new Palindrome();
        assertTrue(palin.isPalindrome("flake" , offByOne));
        assertTrue(palin.isPalindrome("aewdb", offByOne));
    }
}
