package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        arb.enqueue(5);
        arb.enqueue(7);
        arb.enqueue(9);
        arb.enqueue(12);
        assertEquals(12,arb.peek());
        assertEquals(5,arb.fillCount);
    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        arb.enqueue(5);
        arb.enqueue(7);
        arb.enqueue(9);
        arb.enqueue(12);
        arb.dequeue();
        arb.dequeue();
        assertEquals(12,arb.peek());
        assertEquals(3,arb.fillCount);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
