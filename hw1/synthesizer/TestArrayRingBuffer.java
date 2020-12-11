package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);

        arb.enqueue(33.1);
        arb.enqueue(44.8);
        arb.enqueue(62.3);
        arb.enqueue(-3.4);
        assertEquals(false, arb.isEmpty());
        assertEquals(true, arb.isFull());

        assertEquals(Double.valueOf(33.1), arb.dequeue());
        arb.enqueue(-34.5);
        assertEquals(Double.valueOf(44.8), arb.dequeue());
        assertEquals(Double.valueOf(62.3), arb.dequeue());
        assertEquals(Double.valueOf(-3.4), arb.dequeue());
        assertEquals(Double.valueOf(-34.5), arb.dequeue());
//        assertEquals(Double.valueOf(-34.5), arb.dequeue());
//        arb.dequeue()

    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {

        runClasses(TestArrayRingBuffer.class);

    }
} 
