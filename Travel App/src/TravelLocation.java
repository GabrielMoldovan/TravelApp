import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TravelLocation {

	String name, country, region, city;
	int pricePerDay, numberOfActivities;
	ArrayList<String> activities = new ArrayList<String>();
	Calendar startDate;
	Calendar endDate;

	public TravelLocation(String name, String country, String region, String city, int pricePerDay,
			int numberOfActivities, ArrayList<String> activities, Calendar startDate, Calendar endDate) {
		setName(name);
		setCountry(country);
		setRegion(region);
		setCity(city);
		setPricePerDay(pricePerDay);
		setNumberOfActivities(numberOfActivities);
		setActivities(activities);
		setStartDate(startDate);
		setEndDate(endDate);

	}

	//
	public void printInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println();
		System.out.println("Location name: " + getName());
		System.out.println("Located in " + getCountry() + ", " + getRegion() + ", " + getCity());
		System.out.println("Activity list: " + getActivities());
		System.out.println("Available from " + sdf.format(getStartDate().getTime()) + " to " + sdf.format(getEndDate().getTime()));
		System.out.println();
	}
	

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfActivities() {
		return numberOfActivities;
	}

	public void setNumberOfActivities(int numberOfActivities) {
		this.numberOfActivities = numberOfActivities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public ArrayList<String> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<String> activities) {
		this.activities = activities;
	}

}
