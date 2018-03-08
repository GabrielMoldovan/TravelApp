import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	//Afiseaza meniul pentru utilizator
	public static void printGUI() {
		System.out.println("App Menu: ");
		System.out.println("Enter 1 to view information about a specific travel location.");
		System.out.println("Enter 2 to get top 5 locations for your holiday!");
		System.out.println("Enter 3 to find out where is the cheapest place to practice your favourite activity for 10 days!");
		System.out.println("Enter 0 to close the app.");
	}


	public static void main(String[] args) throws FileNotFoundException {
		//DataReader este o clasa ce citeste datele locatiilor din fisier
		//si le organizeaza in structura ierarhica: Oras->Regiune->Tara
		DataReader reader = new DataReader();
		ArrayList<Country> countries = reader.readData(args[0]);
		Scanner scan = new Scanner(System.in);
		printGUI();
		int x = scan.nextInt();
		while (x != 0) {
			System.out.println();
			switch (x) {

			case 1:
				//Obtine informatii despre o anumite locatie (in funcite de numele acesteia)
				LocationDetails details = new LocationDetails();
				details.getDetails(countries, scan);
				break;

			case 2:
				//Obtine top 5 cele mai ieftine locatii in care sa mergi in perioada selectata
				//de tine, in tara / regiunea / orasul selectat de tine.
				TopFive topFive = new TopFive();
				topFive.topFive(reader, countries, scan);
				break;

			case 3:
				//Afla unde este cel mai ieftin sa practici activitatea favorita timp de 10 zile
				FindCheapestPlace cheap = new FindCheapestPlace();
				cheap.findCheapest(countries, scan);
				break;

			default:
				break;
			}
			printGUI();
			x = scan.nextInt();
		}
		scan.close();

	}
}
