import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void printGUI() {
		System.out.println("App Menu: ");
		System.out.println("Enter 1 to view information about a specific travel location.");
		System.out.println("Enter 2 to get top 5 locations for your holiday!");
		System.out.println("Enter 0 to close the app.");
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
				LocationDetails details = new LocationDetails();
				details.getDetails(countries, scan);
				break;
			case 2:
				TopFive topFive = new TopFive();
				topFive.topFive(reader, countries, scan);
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
