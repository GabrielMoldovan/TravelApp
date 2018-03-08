import java.util.ArrayList;


//structura unui oras
public class City {
	ArrayList<TravelLocation> locations;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City(TravelLocation location, String name) {
		// TODO Auto-generated constructor stub
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		locations.add(location);
		setLocations(locations);
		setName(name);
		
	}
	public ArrayList<TravelLocation> getLocations() {
		return locations;
	}
	public void setLocations(ArrayList<TravelLocation> locations) {
		this.locations = locations;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getName().equals(((City)obj).getName());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getName().hashCode();
	}
}
