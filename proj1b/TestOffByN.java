import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    @Test
    public void testOffByN(){
        Palindrome palin = new Palindrome();
        CharacterComparator cc_N = new OffByN(3);
        assertTrue(palin.isPalindrome("whiffet", cc_N));
        assertFalse(palin.isPalindrome("dio", cc_N));
        // need the non-alphabetical output false?
    }
}
