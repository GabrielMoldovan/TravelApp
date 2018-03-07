import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DataReader {



	public static Calendar readDate(String[] date) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]));
		return calendarDate;
	}

	public ArrayList<Country> readData(String inputFile) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream(inputFile));
		int numberOfLocations = Integer.parseInt(s.nextLine());
		ArrayList<Country> countries = new ArrayList<Country>();

		for (int i = 0; i < numberOfLocations; i++) {

			String[] dates = s.nextLine().split(" ");
			int numberOfActivities = Integer.parseInt(s.nextLine());
			String[] activityList = s.nextLine().split(" ");

			ArrayList<String> activities = new ArrayList<String>();
			for (int j = 0; j < numberOfActivities; j++) {
				activities.add(activityList[j]);

			}

			String[] beginDate = s.next().split("/");
			String[] stopDate = s.next().split("/");
			Calendar startDate = readDate(beginDate);
			Calendar endDate = readDate(stopDate);

			TravelLocation location = new TravelLocation(dates[0], dates[1], dates[2], dates[3],
					Integer.parseInt(dates[4]), numberOfActivities, activities, startDate, endDate);

			City city = new City(location, dates[3]);
			Region region = new Region(city, dates[2]);
			Country country = new Country(region, dates[1]);
			int countryIndex = countries.indexOf(country);
			if (countryIndex > 0) {
				int regionIndex = countries.get(countryIndex).getRegions().indexOf(region);
				if (regionIndex > 0) {
					int cityIndex = countries.get(countryIndex).getRegions().get(regionIndex).getCities().indexOf(city);
					if (cityIndex > 0) {
						countries.get(countryIndex).getRegions().get(regionIndex).getCities().get(cityIndex)
								.getLocations().add(location);
					} else {
						countries.get(countryIndex).getRegions().get(regionIndex).getCities().add(city);
					}
				} else {
					countries.get(countryIndex).getRegions().add(region);
				}
			} else {
				countries.add(country);
			}

		}
		s.close();
		return countries;

	}
}
