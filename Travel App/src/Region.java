import java.util.ArrayList;

public class Region {
	ArrayList<City> cities;
	String name;

	public Region(City city, String name) {
		// TODO Auto-generated constructor stub
		ArrayList<City> cities = new ArrayList<City>();
		cities.add(city);
		setCities(cities);
		setName(name);

	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
