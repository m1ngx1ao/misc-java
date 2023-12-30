package misc;

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import api.FileReader;
*/

public class Starter {
	
	private static void print(Object parameter) {
		System.out.println(parameter);
	}
	
	private static void print(int parameter) {
		System.out.println(Integer.valueOf(parameter).toString());
	}
	
	/*
	private static void print(double parameter) {
		System.out.println(Double.valueOf(parameter).toString());
	}
	*/
	
	public static void main(String[] args) {
		print("Je suis une étoile. Libère moi vite! Je veux t'appartenir!");
		print(sumOfFuelRequirements("aoc/2019/01.txt"));
	}
	
	//////////////// TEMPORARY AREA
	private static double fromMass(double mass) {
		double result = Math.floor(mass / 3);
		result = result - 2;
		return result;
	}
	
	private static int sumOfFuelRequirements(String filename) {
		double fuel = 0;
		int fuelRequirements = 0;
		for (String number : api.FileReader.getLines(filename)) {
			fuel = fromMass(Double.valueOf(number));
			fuelRequirements += fuel;
		}
		return fuelRequirements;
	}
	
}
