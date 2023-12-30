package motorway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ObservationType {

	private static String getVehicle(double number) {
		List<String> lines = api.FileReader.getLines("motorway/vehicles.csv");
		for (String line : lines) {
			String[] parts = line.split(";");
			if (parts[0].charAt(0) != '#') {
				if (Double.valueOf(parts[1]) > number) {
					return parts[0];
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line != null && line.length() > 0) {
			String[] parts = line.split(";"); 
			if (parts[0].charAt(0) != '#') {
				System.out.println(getVehicle(Double.valueOf(parts[2])));
			}
			line = br.readLine();
		}
		br.close();
	}

}
