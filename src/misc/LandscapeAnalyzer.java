package misc;

import java.util.ArrayList;
import java.util.List;

import api.FileReader;

public class LandscapeAnalyzer {
	
	private int[][] landscape;

	public LandscapeAnalyzer(String filename) {
		List<String> lines = FileReader.getLines(filename);
		this.landscape = new int[lines.size()][];
		for (int y = 0 ; y < lines.size() ; y++) {
			String[] line = lines.get(y).split("");
			this.landscape[y] = new int[line.length];
			for (int x = 0 ; x < line.length ; x++) {
				this.landscape[y][x] = Integer.valueOf(line[x]);
			}
		}
	}
	
	public int getPoint(int x, int y) {
		return this.landscape[y][x];
	}

	public int getHighest() {
		List<Integer> a = this.getHighestCoordinates();
		return this.getPoint(a.get(0), a.get(1));
	}

	public List<Integer> getHighestCoordinates() {
		List<Integer> highestCoordinates = new ArrayList<Integer>();
		int highestNumber = 0;
		for (int y = 0 ; y < this.landscape.length ; y++) {
			for (int x = 0 ; x < this.landscape[0].length ; x++) {
				if (this.landscape[y][x] > highestNumber) {
					highestNumber = this.landscape[y][x];
					highestCoordinates.clear();
					highestCoordinates.add(x);
					highestCoordinates.add(y);
				}
			}
		}
		return highestCoordinates;
	}
	
	private boolean isPeak(int x, int y) {
		for (int nextToX = x - 1; nextToX <= x + 1; nextToX++) {
			for (int nextToY = y - 1; nextToY <= y + 1; nextToY++) {
				if (nextToY != -1 
						&& nextToX != -1 
						&& nextToY != this.landscape.length 
						&& nextToX != this.landscape[0].length
						&& this.landscape[nextToY][nextToX] > this.landscape[y][x]) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Integer> getPeaksHeight() {
		List<Integer> peaksHeight = new ArrayList<Integer>();
		for (int y = 0 ; y < this.landscape.length ; y++) {
			for (int x = 0 ; x < this.landscape[0].length ; x++) {
				if (this.isPeak(x, y)) {
					peaksHeight.add(this.landscape[y][x]);
				}
			}
		}
		return peaksHeight; 
	}
}
