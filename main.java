import java.util.*;
import java.util.regex.*;

	public class piste
	{
		// MAIN //
		public static void main(String[] args) 
		{
		    Scanner scan = new Scanner(System.in);

		    // LOG IN //
			userLogin();

			
			
			ArrayList<String> route = askRoute(scan);

			System.out.print("Current Location: ");
        	String currLoc = scan.nextLine();
			System.out.print("Destination: ");
        	String desLoc = scan.nextLine();
	        
	
	        printLocs(route, currLoc, desLoc);
	        
	        int distance = computeDistance(route, currLoc, desLoc);
	        System.out.println("Distance: " + distance);

	        double fare = computeFare(distance, scan);
	        System.out.println("Fare: Php " + fare);
		}

    // 1.1 ASK ROUTE
    static ArrayList<String> askRoute(Scanner scan)
    {
		// Asks for the route to take //
        System.out.print("Route (1. Bago-Roxas | 2. Roxas-Bago): ");
        int routeChoice = scan.nextInt();
        scan.nextLine();

		// List of locations under the Bago-Roxas Route //
        ArrayList<String> b2rStops = new ArrayList<>();
        b2rStops.add("Bago Aplaya"); 
        b2rStops.add("Puan");
        b2rStops.add("Ulas");
        b2rStops.add("Bangkal"); 
        b2rStops.add("Tahimik Avenue"); 
        b2rStops.add("Matina Crossing");
        b2rStops.add("ABSCBN");
        b2rStops.add("SM City Davao"); 
        b2rStops.add("Ecoland Terminal Crossing");
        b2rStops.add("Almendras Gym");
        b2rStops.add("Roxas Avenue");

		// List of locations under the Roxas-Bago Route //
        ArrayList<String> r2bStops = new ArrayList<>();
        r2bStops.add("Roxas Avenue");
        r2bStops.add("Almendras Gym");
        r2bStops.add("Ecoland Terminal Crossing");
        r2bStops.add("Tulip Drive");
        r2bStops.add("La Suerte Gallera");
        r2bStops.add("Matina Crossing"); 
        r2bStops.add("Tahimik Avenue");
        r2bStops.add("Bangkal");
        r2bStops.add("Ulas");
        r2bStops.add("Puan");
        r2bStops.add("Bago Aplaya");

        if (routeChoice == 1) 
        {
            return b2rStops;
        } 
        else 
        {
            return r2bStops;
        }
    }

	// 1.2 PRINT LOCATIONS //
    static void printLocs(ArrayList<String> route, String currLoc, String desLoc)
    {
    	int currIndex = route.indexOf(currLoc);
		int desIndex = route.indexOf(desLoc);

    	if (route.contains(currLoc) && route.contains(desLoc)) 
    	{
    		if (currIndex < 0 || desIndex < 0 |currIndex > desIndex)
        	{
        		System.out.println("Invalid");
        	}
        	else
        	{
        		System.out.println("Your ride: " + currLoc + " -> " + desLoc);
        	}
        }
        else 
        {
            System.out.println("Invalid locations. Consider taking the other route...");
        }
    }

    static int computeDistance(ArrayList<String> route, String currLoc, String desLoc) {
    int currIndex = route.indexOf(currLoc);
    int desIndex = route.indexOf(desLoc);

    if (currIndex == -1 || desIndex == -1 || currIndex > desIndex) 
    {
        return -1;
    }

    return desIndex - currIndex; // distance in stops
	}

	static double computeFare(int distance, Scanner scan)
	{
	 	double regFare = 12.00;
	 	double baseFare = 0; 
	 	double discRate = 0;
	 	double discAmount = 0;
	 	double fare = 0;

		if (distance <= 4)
		{
			baseFare = regFare;
		}
		else if (distance > 4)
		{
			baseFare = regFare + (1.80 * (distance - 4));
		}

		// Computation of Discount: type of passenger
		System.out.print("Regular (R) / Student (St) / Senior (Sr) / PWD Passenger (PWD): ");
		String passType = scan.nextLine();

		switch (passType)
		{
			case "R":
				discRate = 0.00;
				break;
			case "St":
				discRate = 20.00;
				break;
			case "Sr":
				discRate = 20.00;
				break;
			case "PWD":
				discRate = 20.00;
				break;
			default:
				System.out.println("Invalid Choice."); 
				break;
		}

		discAmount = baseFare - (baseFare * discRate);
		fare = discAmount;

		return fare;
	}


}

