package misc;

import java.util.ArrayList;
import java.util.List;

import api.FileReader;

public class Rechner {
	private double state = 0;
	
	private double memory = 0;
	
	public double getState() {
		return this.state;
	}
	
	public void add(double number) {
		this.state = this.state + number;
	}
	
	public void multiply(double number) {
		this.state = this.state * number;
	}
	
	public void divide(double number) {
		this.state = this.state / number;
	}
	
	public void sub(double number) {
		this.state = this.state - number;
	}
	
	public void store() {
		this.memory = this.state;
	}
	
	public void retrieve() {
		this.state = this.memory;
	}
	
	public void power(int number) {
		double d = 1;
		if (number < 0) {
			number = -number;
			this.state = 1 / this.state;
		}
		for (int c = 1 ; c <= number ; c++) {
			d = d * this.state;
		}
		this.state = d;
	}
	
	public void greatestCommonDivisor(int number) {
		int a = (int) this.state;
		int b = number;
		while (a != b && a != 1 && b != 1) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		if (a < b) {
			this.state = a;
		} else {
			this.state = b;
		}
	}
	
	public void add(double[] numbers) {
		for (int b = 0 ; b < numbers.length; b++) {
			this.state = this.state + numbers[b];
		}
	}
	
	public void add(String text) {
		this.state = this.state + Double.valueOf(text);
	}
	
	public void evaluate(String text) {
		String[] faecher = text.split(" ");
		if (faecher[0].equals("gcd")) {
			this.greatestCommonDivisor(Integer.valueOf(faecher[1]));
		}
		if (faecher[0].equals("multiply")) {
			this.multiply(Double.valueOf(faecher[1]));
		}
		if (faecher[0].equals("add")) {
			this.add(Double.valueOf(faecher[1]));
		}
		if (faecher[0].equals("divide")) {
			this.divide(Double.valueOf(faecher[1]));
		}
		if (faecher[0].equals("sub")) {
			this.sub(Double.valueOf(faecher[1]));
		}
	}
	
	public void evaluateTaskFile(String filename) {
		List<String> tasks = FileReader.getLines(filename);
		for (int b = 0 ; b < tasks.size(); b++) {
			this.evaluate(tasks.get(b));
		}
	}
	
	public List<Integer> primesUpToState() {
		List<Integer> primes = new ArrayList<Integer>();
		for (int candidate = 2 ; candidate <= this.state ; candidate++) {
			boolean isPrime = true;
			for (int k = 0 ; k < primes.size() ; k++) {
				if (candidate % primes.get(k) == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				primes.add(candidate);
			}
		}
		return primes;
	}
	
	
}
