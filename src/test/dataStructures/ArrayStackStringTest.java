package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.*;

public class ArrayStackStringTest {
    ArrayStack<String> cut;

    @BeforeEach
    void setup() {
        cut = new ArrayStack<String>();
    }

    @Test
    void emptyPopNull() {
        assertEquals(null, cut.pop());
    }

    @Test
    void pushXPopX() {
        String elem = "Element";
        cut.push(elem);
        assertEquals(elem, cut.pop());
    }

    @Test
    void pushXYPopYXNull() {
        String elemX = "ElementX";
        cut.push(elemX);
        String elemY = "ElementY";
        cut.push(elemY);
        assertEquals(elemY, cut.pop());
        assertEquals(elemX, cut.pop());
        assertEquals(null, cut.pop());
    }
}
