package test.landscape;

import misc.LandscapeAnalyzer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LandscapeTest {

	LandscapeAnalyzer cut;
	
	@BeforeEach
	void setUp() {
		cut = new LandscapeAnalyzer("Landscape.txt");
	}

	@Test
	void init() {
	}

	@Test
	void point() {
		assertEquals(1, cut.getPoint(1, 2));
	}
	
	@Test
	void highest() {
		assertEquals(9, cut.getHighest());
	}
	
	@Test
	void highestCoord() {
		List<Integer> result = cut.getHighestCoordinates();
		
		assertEquals(2, result.size());
		assertEquals(12, (int) result.get(0));
		assertEquals(10, (int) result.get(1));
	}
	
	@Test
	void peaks() {
		List<Integer> result = cut.getPeaksHeight();
		
		Collections.sort(result);
		String sortedResult = "";
		for (int num : result) {
			sortedResult += num;
		}
		assertEquals("000000001222356788889", sortedResult);
	}
	
}
