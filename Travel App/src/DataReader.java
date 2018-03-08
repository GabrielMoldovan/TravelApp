import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DataReader {

	public Calendar readDate(String[] date) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]));
		return calendarDate;
	}

	public ArrayList<Country> readData(String inputFile) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream(inputFile));
		int numberOfLocations = Integer.parseInt(s.nextLine());
		ArrayList<Country> countries = new ArrayList<Country>();
		//Citeste fiecare locatie din fisier
		for (int i = 0; i < numberOfLocations; i++) {
			String[] dates = s.nextLine().split(" ");

			int numberOfActivities = Integer.parseInt(s.nextLine());
			String[] activityList = s.nextLine().split(" ");

			ArrayList<String> activities = new ArrayList<String>();
			for (int j = 0; j < numberOfActivities; j++) {
				activities.add(activityList[j]);

			}

			String[] beginDate = s.nextLine().split("/");
			String[] stopDate = s.nextLine().split("/");
			Calendar startDate = readDate(beginDate);
			Calendar endDate = readDate(stopDate);
			//dates == {"Nume locatie", "Tara", "Regiune", "Oras", "Pret mediu pe zi"}
			TravelLocation location = new TravelLocation(dates[0], dates[1], dates[2], dates[3],
					Integer.parseInt(dates[4]), numberOfActivities, activities, startDate, endDate);

			City newCity = new City(location, dates[3]);
			Region newRegion = new Region(newCity, dates[2]);
			Country newCountry = new Country(newRegion, dates[1]);
			//Introducerea locatiei in ierarhie
			//Itereaza prin structura ierarhica, daca exista tara / regiune / oras cu acest nume
			//introducem locatia la locul potrivit, daca nu, creem o noua tara / regiune / oras
			int countryFlag = 0;
			for (Country country : countries) {
				if (country.equals(newCountry)) {
					countryFlag = 1;
					int regionFlag = 0;
					for (Region region : country.getRegions()) {
						if (region.equals(newRegion)) {
							regionFlag = 1;
							int cityFlag = 0;
							if (!(region.getCities().isEmpty())) {
								for (City city : region.getCities()) {
									if (city.equals(newCity)) {
										cityFlag = 1;
										city.getLocations().add(location);
									}
								}
							}
							if (cityFlag == 0) {
								region.getCities().add(newCity);
							}
						}
					}
					if (regionFlag == 0) {
						country.getRegions().add(newRegion);
					}
				}
			}
			if (countryFlag == 0) {
				countries.add(newCountry);
			}

		}
		s.close();
		return countries;

	}
}
