package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.*;

public class ArrayQueueCharTest {
    ArrayQueue<Character> cut;

    @BeforeEach
    void setup() {
        cut = new ArrayQueue<Character>();
    }

    @Test
    void emptyDequeueNull() {
        assertEquals(null, cut.dequeue());
    }

    @Test
    void enqueueXDequeueX() {
        cut.enqueue('A');
        assertEquals('A', cut.dequeue());
    }

    @Test
    void enqueueXYDequeueXYNull() {
        cut.enqueue('A');
        cut.enqueue('B');
        assertEquals('A', cut.dequeue());
        assertEquals('B', cut.dequeue());
        assertEquals(null, cut.dequeue());
    }

    @Test
    void enqueueDequeueXEnqueueDequeueY() {
        cut.enqueue('A');
        assertEquals('A', cut.dequeue());
        cut.enqueue('B');
        assertEquals('B', cut.dequeue());
    }

    @Test
    void enqueueDequeuePattern10k() {
        cut.enqueue('C');
        for (int i = 0; i < 10000; i++) {
            cut.enqueue('A');
            cut.enqueue('B');
            cut.enqueue('C');
            assertEquals('C', cut.dequeue());
            assertEquals('A', cut.dequeue());
            assertEquals('B', cut.dequeue());
        }
        assertEquals('C', cut.dequeue());
        assertEquals(null, cut.dequeue());
    }
}
