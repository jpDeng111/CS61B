import static org.junit.Assert.*;
import org.junit.Test;

public class TestFlik{
    @Test
    public void testInteger(){
        Flik exm = new Flik();
        assertTrue(exm.isSameNumber(129,129));
        assertTrue(exm.isSameNumber(128,128));
        assertTrue(exm.isSameNumber(-128,-128));
        assertFalse(exm.isSameNumber(129,127));
    }
//    @Test
//    public void test
}