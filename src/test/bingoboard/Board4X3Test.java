package test.bingoboard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import misc.BingoBoard;

class Board4X3Test {

	BingoBoard cut;
	
	@BeforeEach
	void setUp() {
		cut = new BingoBoard(new int[][] {
			new int[] {1,2,6,9},
			new int[] {3,4,7,1},
			new int[] {0,8,2,5}
		});
	}

	@Test
	void initial() {
		assertEquals(false, cut.isBingo());
		assertEquals(48, cut.getSumOfUnmarked());
	}

	@Test
	void markThreeBingoInLastColumn() {
		cut.mark(9);
		cut.mark(1);
		cut.mark(5);
		
		assertEquals(true, cut.isBingo());
		assertEquals(32, cut.getSumOfUnmarked());
	}
	
	@Test
	void markThreeBingoInLastRow() {
		cut.mark(0);
		cut.mark(8);
		cut.mark(2);
		cut.mark(5);
		
		assertEquals(true, cut.isBingo());
		assertEquals(31, cut.getSumOfUnmarked());
	}
	
}
