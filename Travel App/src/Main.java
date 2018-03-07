import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	
	public static void printGUI() {
		System.out.println("App Menu: ");
		System.out.println("Enter 1 to view information about a specific travel location.");
		System.out.println("Enter 0 to close the app.");
	}
	
	public static TravelLocation searchByName(String name, ArrayList<TravelLocation> locations) {
		for (TravelLocation travelLocation : locations) {
			if (travelLocation.getName().equals(name)) {
				return travelLocation;
			}
		}
		
		return null;
		
	}
	
	public static Calendar readDate(String[] date) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, 
				Integer.parseInt(date[0]));
		return calendarDate;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream(args[0]));
		int numberOfLocations = Integer.parseInt(s.nextLine());
		ArrayList<TravelLocation> locations = new ArrayList<TravelLocation>();
		for (int i = 0; i < numberOfLocations; i++) {
			
			String[] dates = s.nextLine().split(" ");
			int numberOfActivities = Integer.parseInt(s.nextLine());
			String[] activityList = s.nextLine().split(" ");
			
			ArrayList<String> activities = new ArrayList<String>();
			for(int j = 0; j < numberOfActivities; j++) {
				activities.add(activityList[j]);
				
			}

			String[] beginDate = s.next().split("/");
			String[] stopDate = s.next().split("/");
			Calendar startDate = readDate(beginDate);
			Calendar endDate = readDate(stopDate);
			
			locations.add(new TravelLocation(dates[0], dates[1], dates[2], dates[3],
					Integer.parseInt(dates[4]), numberOfActivities, activities, startDate, endDate));
			
			
		}
		s.close();
		Scanner scan = new Scanner(System.in);
		printGUI();
		int x = scan.nextInt();
		while(x != 0) {
			System.out.println();
			switch (x) {
			case 1:
				System.out.println("Introduce-ti numele locatiei:");
				String name = scan.next();
				TravelLocation location = searchByName(name, locations);
				if(location == null) {
					System.out.println("We couldn't find that location.");
					break;
				}else {
					location.printInfo();
				}
				break;

			default:
				printGUI();
				x = scan.nextInt();
				break;
			}
			printGUI();
			x = scan.nextInt();
		}
		scan.close();
		
		
		
		
		
	}
}
