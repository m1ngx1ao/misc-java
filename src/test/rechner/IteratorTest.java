package test.rechner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import misc.Rechner;

class IteratorTest {

	private Rechner cut;
	
	@BeforeEach
	void setup() {
		this.cut = new Rechner();
	}
	
	@Test
	void powerPositive() {
		cut.add(3);
		cut.power(4);
		assertEquals(81, cut.getState());
	}

	@Test
	void powerNegative() {
		cut.add(2);
		cut.power(-3);
		assertEquals(0.125, cut.getState());
	}
	
	@Test
	void gcdIsOne() {
		cut.add(11);
		cut.greatestCommonDivisor(18);
		assertEquals(1, cut.getState());
	}
	
	@Test
	void gcdIsNotOne() {
		cut.add(42);
		cut.greatestCommonDivisor(51);
		assertEquals(3, cut.getState());
	}
	
	@Test
	void gcdIgnoreFraction() {
		cut.add(9.4);
		cut.greatestCommonDivisor(12);
		assertEquals(3, cut.getState());
	}
	
	@Test
	void addMultiple() {
		cut.add(9);
		double[] a = new double[3];
		a[0] = 2;
		a[1] = 4;
		a[2] = 8;
		cut.add(a);
		assertEquals(23, cut.getState());
	}
	
	@Test
	void primesNone() {
		cut.add(1.7);
		
		List<Integer> result = cut.primesUpToState();
		
		assertEquals(0, result.size());
	}
	
	@Test
	void primesOne() {
		cut.add(2.5);
		
		List<Integer> result = cut.primesUpToState();
		
		assertEquals(1, result.size());
		assertEquals(2, (int) result.get(0));
	}
	
	@Test
	void primesSeveral() {
		cut.add(19.3);
		
		List<Integer> result = cut.primesUpToState();
		
		assertEquals(8, result.size());
		assertEquals(2, (int) result.get(0));
		assertEquals(5, (int) result.get(2));
		assertEquals(11, (int) result.get(4));
		assertEquals(17, (int) result.get(6));
		assertEquals(19, (int) result.get(7));
	}
	
}
