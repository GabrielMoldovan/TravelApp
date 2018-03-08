import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;


public class TopFive {

	public TopFive() {
		// TODO Auto-generated constructor stub
	}

	public static void topFiveCountry(String name, Calendar startDate, Calendar endDate, ArrayList<Country> countries) {
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		for (Country country : countries) {
			if (country.getName().equals(name)) {
				for (Region region : country.getRegions()) {
					for (City city : region.getCities()) {
						for (TravelLocation location : city.getLocations()) {
							if (location.getStartDate().compareTo(startDate) < 0
									&& location.getEndDate().compareTo(endDate) > 0) {
								locations.add(location);
							}
						}
					}
				}
				break;
			}
		}

		if (locations.isEmpty()) {
			System.out.println("-----------");
			System.out.println("We couldn't find any locations that fit your requirements");
			System.out.println("-----------");
			return;
		}
		Collections.sort(locations);
		for (int i = 0; i < 5 && i < locations.size(); i++) {
			System.out.println();
			System.out.println("-----" + (i + 1) + "-----");
			locations.get(i).printInfo();
			System.out.println("-----------");
		}
	}

	public void topFive(DataReader reader, ArrayList<Country> countries, Scanner scan) {
		String name;
		System.out.println();
		System.out.println("Please enter a begining and a ending date for your trip (dd/mm/yyyy)");
		String[] beginDate = scan.next().split("/");
		String[] stopDate = scan.next().split("/");
		Calendar startDate = reader.readDate(beginDate);
		Calendar endDate = reader.readDate(stopDate);
		System.out.println("Enter 1 to search by country, 2 to search by region or 3 to search by city ");
		int y = scan.nextInt();
		switch (y) {
		case 1:
			System.out.println();
			System.out.println("Please enter a country name");
			name = scan.next();
			topFiveCountry(name, startDate, endDate, countries);
			break;
		case 2:
			System.out.println();
			System.out.println("Please enter a region name");
			name = scan.next();
			topFiveRegion(name, startDate, endDate, countries);
			break;
		case 3:
			System.out.println();
			System.out.println("Please enter a city name");
			name = scan.next();
			topFiveCity(name, startDate, endDate, countries);
			break;
		default:
			break;
		}

	}

	public static void topFiveRegion(String name, Calendar startDate, Calendar endDate, ArrayList<Country> countries) {
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		for (Country country : countries) {
			for (Region region : country.getRegions()) {
				if (region.getName().equals(name)) {
					for (City city : region.getCities()) {
						for (TravelLocation location : city.getLocations()) {
							if (location.getStartDate().compareTo(startDate) < 0
									&& location.getEndDate().compareTo(endDate) > 0) {
								locations.add(location);
							}
						}
					}
					break;
				}
			}
		}

		if (locations.isEmpty()) {
			System.out.println("-----------");
			System.out.println("We couldn't find any locations that fit your requirements");
			System.out.println("-----------");
			return;
		}
		Collections.sort(locations);
		for (int i = 0; i < 5 && i < locations.size(); i++) {
			System.out.println();
			System.out.println("-----" + (i + 1) + "-----");
			locations.get(i).printInfo();
			System.out.println("-----------");
		}
	}

	public static void topFiveCity(String name, Calendar startDate, Calendar endDate, ArrayList<Country> countries) {
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		for (Country country : countries) {
			for (Region region : country.getRegions()) {
				for (City city : region.getCities()) {
					if (city.getName().equals(name)) {
						for (TravelLocation location : city.getLocations()) {
							if (location.getStartDate().compareTo(startDate) < 0
									&& location.getEndDate().compareTo(endDate) > 0) {
								locations.add(location);
							}
						}
						break;
					}
				}
			}
		}

		if (locations.isEmpty()) {
			System.out.println("-----------");
			System.out.println("We couldn't find any locations that fit your requirements");
			System.out.println("-----------");
			return;
		}
		Collections.sort(locations);
		for (int i = 0; i < 5 && i < locations.size(); i++) {
			System.out.println();
			System.out.println("-----" + (i + 1) + "-----");
			locations.get(i).printInfo();
			System.out.println("-----------");
		}
	}

}
