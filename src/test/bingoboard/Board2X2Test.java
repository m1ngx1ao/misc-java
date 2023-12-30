package test.bingoboard;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import misc.BingoBoard;

class Board2X2Test {

	BingoBoard cut;
	
	@BeforeEach
	void setUp() {
		cut = new BingoBoard(new int[][] {
			new int[] {1,2},
			new int[] {3,4}
		});
	}
	
	@Test
	void initial() {
		assertEquals(false, cut.isBingo());
		assertEquals(10, cut.getSumOfUnmarked());
	}
	
	@Test
	void markOne() {
		cut.mark(1);
		
		assertEquals(false, cut.isBingo());
		assertEquals(9, cut.getSumOfUnmarked());
	}
	
	@Test
	void markTwoBingoInRow() {
		cut.mark(1);
		cut.mark(2);
		
		assertEquals(true, cut.isBingo());
		assertEquals(7, cut.getSumOfUnmarked());
	}
	
	@Test
	void markTwoBingoInColumn() {
		cut.mark(1);
		cut.mark(3);
		
		assertEquals(true, cut.isBingo());
		assertEquals(6, cut.getSumOfUnmarked());
	}

	@Test
	void markTwoNoBingo() {
		cut.mark(1);
		cut.mark(4);
		
		assertEquals(false, cut.isBingo());
		assertEquals(5, cut.getSumOfUnmarked());
	}
	
}
