import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void printGUI() {
		System.out.println("App Menu: ");
		System.out.println("Enter 1 to view information about a specific travel location.");
		System.out.println("Enter 0 to close the app.");
	}

	public static TravelLocation searchByName(String name, ArrayList<Country> countries) {
		for (Country country : countries) {
			for (Region region : country.getRegions()) {
				for (City city : region.getCities()) {
					for (TravelLocation location : city.getLocations()) {
						if (location.getName().equals(name)) {
							return location;
						}
					}
				}
			}
		}

		return null;

	}

	public static void main(String[] args) throws FileNotFoundException {
		DataReader reader = new DataReader();
		ArrayList<Country> countries = reader.readData(args[0]);
		Scanner scan = new Scanner(System.in);
		printGUI();
		int x = scan.nextInt();
		while (x != 0) {
			System.out.println();
			switch (x) {
			case 1:
				System.out.println("Introduce-ti numele locatiei:");
				String name = scan.next();
				TravelLocation location = searchByName(name, countries);
				if (location == null) {
					System.out.println("We couldn't find that location.");
					break;
				} else {
					location.printInfo();
				}
				break;

			default:
				printGUI();
				x = scan.nextInt();
				break;
			}
			printGUI();
			x = scan.nextInt();
		}
		scan.close();

	}
}
