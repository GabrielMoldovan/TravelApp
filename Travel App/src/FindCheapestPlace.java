import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FindCheapestPlace {
	public FindCheapestPlace() {
		// TODO Auto-generated constructor stub
	}

	//obtine diferenta in zile dintre doua date calendaristice
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d1.getTime() - d2.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	
	public static void cheapest(String activity, ArrayList<Country> countries) {
		//itereaza prin locatii si obtine o lista cu locatiile ce contin o anumita activitate
		//si au o perioada de valabilitate >= 10 zile
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		for (Country country : countries) {
			for (Region region : country.getRegions()) {
				for (City city : region.getCities()) {
					for (TravelLocation location : city.getLocations()) {
						if (location.getActivities().contains(activity)) {
							if (getDifferenceDays(location.getEndDate().getTime(),
									location.getStartDate().getTime()) >= 10) {
								locations.add(location);
							}
						}
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
		//sorteaza locatiile si afiseaza informatii despre cea mai accesibila ca si pret
		Collections.sort(locations);
		locations.get(0).printInfo();
	}
	
	//gaseste si afiseaza informatii despre cea mai ieftina locatie in care poti practica
	//activitatea favorita
	public void findCheapest(ArrayList<Country> countries, Scanner scan) {

		System.out.println("Please enter an activity");
		String activity = scan.next();
		cheapest(activity, countries);
	}
}
