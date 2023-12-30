package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExStreamMapper {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line != null && line.length() > 0) {
			System.out.println("Dice: " + line);
			line = br.readLine();
		}
		br.close();
	}

}
