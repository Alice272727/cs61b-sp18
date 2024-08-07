package synthesizer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 * 
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        for (int i = 0; i < 4; i++) {
            arb.enqueue((double) i);

        }
        for (int i = 0; i < 4; i++) {
            arb.dequeue();
            
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
