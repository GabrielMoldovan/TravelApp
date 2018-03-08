import java.util.ArrayList;
import java.util.Scanner;

public class LocationDetails {
	
	public LocationDetails() {
		// TODO Auto-generated constructor stub
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
	
	public void getDetails(ArrayList<Country> countries, Scanner scan) {
		System.out.println("Please enter a location name:");
		String name = scan.next();
		TravelLocation location = searchByName(name, countries);
		if (location == null) {
			System.out.println("We couldn't find that location.");
		} else {
			location.printInfo();
		}
	}

}
