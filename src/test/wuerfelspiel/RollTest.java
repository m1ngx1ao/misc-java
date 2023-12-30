package test.wuerfelspiel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import wuerfelspiel.Roll;


class RollTest {
	@Test
	void testToString() {
		Roll cut = new Roll();
		cut.append(2);
		cut.append(4);
		cut.append(1);
		assertTrue("241".equals(cut.toString()));
	}
	
	@Test
	void testStringConstructor() {
		assertTrue("241".equals(new Roll("241").toString()));
	}
	
	@Test
	void testSideCount() {
		Roll cut = new Roll("1232");
		assertEquals(2, cut.countSide(2));
		assertEquals(1, cut.countSide(3));
		assertEquals(0, cut.countSide(4));
	}

	@Test
	void test123() {
		assertEquals(100, new Roll("123").getValue());
	}
	
	@Test
	void testFourOnes() {
		assertEquals(1100, new Roll("111213").getValue());
	}
	
	@Test
	void testFourFives() {
		assertEquals(550, new Roll("555253").getValue());
	}
	
	@Test
	void testThreeEquals() {
		assertEquals(400, new Roll("4434").getValue());
	}
	
	@Test
	void testSixOnes() {
		assertEquals(10000, new Roll("111111").getValue());
	}
	
	@Test
	void testSixSixes() {
		assertEquals(6000, new Roll("666666").getValue());
	}
}
