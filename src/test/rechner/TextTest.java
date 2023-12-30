package test.rechner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import misc.Rechner;

class TextTest {

	Rechner cut;
	
	@BeforeEach
	void setUp() throws Exception {
		cut = new Rechner();
	}

	@Test
	void addByText() {
		cut.add(5);
		cut.add("8");
		assertEquals(13, cut.getState());
	}

	@Test
	void evaluateTextOneAdd() {
		cut.add("8");
		cut.evaluate("add 4.2");
		assertEquals(12.2, cut.getState());
	}
	
	@Test
	void evaluateTextOneMultiply() {
		cut.add("8");
		cut.evaluate("multiply 4.2");
		assertEquals(33.6, cut.getState());
	}
	
	@Test
	void evaluateTextMultiple() {
		cut.evaluate("add -8");
		cut.evaluate("divide -2");
		cut.evaluate("gcd 10");
		assertEquals(2, cut.getState());
	}
	
	@Test
	void evaluateTaskFile() {
		cut.evaluateTaskFile("RechnerTasks.txt");
		assertEquals(9, cut.getState());
	}
	
}
