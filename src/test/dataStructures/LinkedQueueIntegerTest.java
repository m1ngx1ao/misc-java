package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.*;

public class LinkedQueueIntegerTest {
    LinkedQueue<Integer> cut;

    @BeforeEach
    void setup() {
        cut = new LinkedQueue<Integer>();
    }

    @Test
    void emptyDequeueNull() {
        assertEquals(null, cut.dequeue());
    }

    @Test
    void enqueueXDequeueX() {
        cut.enqueue(3);
        assertEquals(3, cut.dequeue());
    }

    @Test
    void enqueueXYDequeueXYNull() {
        cut.enqueue(6);
        cut.enqueue(9);
        assertEquals(6, cut.dequeue());
        assertEquals(9, cut.dequeue());
        assertEquals(null, cut.dequeue());
    }

    @Test
    void enqueue100Dequeue101() {
        for (int i = 0; i < 100; i++) {
            cut.enqueue(Integer.valueOf(i));
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), cut.dequeue());
        }
        assertEquals(null, cut.dequeue());
    }
}
