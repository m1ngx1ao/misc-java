package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	private int getDistanceCrapIngineering(int distance) {
		int fuel = 0;
		for (int a = 0; a <= distance; a++) {
			fuel += a;
		}
		return fuel;
	}
	
	@Test
	void test1() {
		assertEquals(55, getDistanceCrapIngineering(10));
	}

}
