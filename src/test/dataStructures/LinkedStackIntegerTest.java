package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.*;

public class LinkedStackIntegerTest {
    LinkedStack<Integer> cut;

    @BeforeEach
    void setup() {
        cut = new LinkedStack<Integer>();
    }

    @Test
    void emptyPopNull() {
        assertEquals(null, cut.pop());
    }

    @Test
    void pushXPopX() {
        cut.push(3);
        assertEquals(3, cut.pop());
    }

    @Test
    void pushXYPopYXNull() {
        cut.push(6);
        cut.push(9);
        assertEquals(9, cut.pop());
        assertEquals(6, cut.pop());
        assertEquals(null, cut.pop());
    }

    @Test
    void push100Pop101() {
        for (int i = 0; i < 100; i++) {
            cut.push(Integer.valueOf(i));
        }
        for (int i = 99; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), cut.pop());
        }
        assertEquals(null, cut.pop());
    }
}
