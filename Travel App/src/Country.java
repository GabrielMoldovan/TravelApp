import java.util.ArrayList;


//structura unei tari
public class Country {
	ArrayList<Region> regions;
	String name;

	public Country(Region region, String name) {
		// TODO Auto-generated constructor stub
		ArrayList<Region> regions = new ArrayList<Region>();
		regions.add(region);
		setRegions(regions);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getName().equals(((Country)obj).getName());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getName().hashCode();
	}
}
