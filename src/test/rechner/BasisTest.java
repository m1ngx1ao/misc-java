package test.rechner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import misc.Rechner;

class BasisTest {

	private Rechner cut;
	
	@BeforeEach
	void setup() {
		this.cut = new Rechner();
	}
	
	@Test
	void zeroOnStart() {
		assertEquals(0, cut.getState());
	}

	@Test
	void add() {
		cut.add(3);
		cut.add(4);
		assertEquals(7, cut.getState());
	}

	@Test
	void multiply() {
		cut.add(3);
		cut.multiply(4);
		assertEquals(12, cut.getState());
	}

	@Test
	void sub() {
		cut.add(3);
		cut.sub(4);
		assertEquals(-1, cut.getState());
	}

	@Test
	void divide() {
		cut.add(6);
		cut.divide(4);
		assertEquals(1.5, cut.getState());
	}

	@Test
	void memory() {
		cut.add(6);
		cut.store();
		cut.add(4);
		cut.retrieve();
		assertEquals(6, cut.getState());
	}

}
