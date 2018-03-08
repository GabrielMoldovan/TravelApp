import java.util.ArrayList;

//structura unei regiuni
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

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getName().equals(((Region) obj).getName());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getName().hashCode();
	}
}
