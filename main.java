import java.util.*;
import java.util.regex.*;

	public class piste
	{
		// MAIN //
		public static void main(String[] args) 
		{
		    Scanner scan = new Scanner(System.in);

		    // LOG IN //
			userLogin(scan);
			
			ArrayList<String> route = askRoute(scan);

			System.out.print("Current Location: ");
        	String currLoc = scan.nextLine();
			System.out.print("Destination: ");
        	String desLoc = scan.nextLine();
	        
	
	        printLocs(route, currLoc, desLoc);
	        
	        double distance = computeDistance(route, currLoc, desLoc);
	        System.out.println("Distance: " + distance);

	        double fare = computeFare(distance, scan);
	        System.out.println("Fare: Php " + fare);
		}

	static void userLogin(Scanner scan)
    {
        boolean validEmail;

            do
            {
                System.out.print("Enter E-mail: ");
                String email = scan.nextLine();
                validEmail = validateEmail(email);
                if (validEmail) // checks if email is valid to proceed to signing up user pin
                {
                    System.out.println("Valid Email. Proceed...");
                    System.out.println();
                }

                if (!validEmail)
                {
                    System.out.println("Invalid. Try again..."); // asks for another email input if the previous is invalid
                    System.out.println();
                }
            }
            while (!validEmail);

            validatePin(scan); // checks if pin is valid to proceed to next user
    }

    // FUNCTION - Validating Email based on given pattern
    static boolean validateEmail(String email)
    {
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; // pattern = "user@example.com"

        return email.matches(pattern);
    }

    // FUNCTION - Validating Pin based on given pattern
    static void validatePin(Scanner scan)
    {
        boolean isValidPin;
        do
        {
            System.out.print("Enter Pin (4-digit pin): ");
            String userPin = scan.nextLine();
            String pinPattern = "^\\d{4}$"; // pattern requires exactly 4 digits

            isValidPin = userPin.matches(pinPattern);

            if (!isValidPin)
            {
                System.out.println("Invalid Pin. Try again...");
            }
        }
        while (!isValidPin);

        System.out.println("Pin accepted. Signing in...");
        System.out.println();
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

    static double computeDistance(ArrayList<String> route, String currLoc, String desLoc) 
{
    int currIndex = route.indexOf(currLoc);
    int desIndex = route.indexOf(desLoc);

    if (currIndex == -1 || desIndex == -1 || currIndex > desIndex) 
    {
        return -1;
    }

    int stopDistance = desIndex - currIndex;

    // If distance is <= 4 stops, keep old logic
    if (stopDistance <= 4) 
    {
        return stopDistance;
    }

    // Otherwise, use mapped distances
    HashMap<String, Double> distMap = new HashMap<>();

    if (route.get(0).equals("Bago Aplaya")) 
    { 
		// Bago-Roxas
    	distMap.put("Bago Aplaya", 0.0);
        distMap.put("Tahimik Avenue", 0.9722222222);
        distMap.put("Matina Crossing", 1.944444444);
        distMap.put("ABSCBN", 3.055555556);
        distMap.put("SM City Davao", 4.027777778);
        distMap.put("Ecoland Terminal Crossing", 5.0);
        distMap.put("Almendras Gym", 5.972222222);
        distMap.put("Roxas Avenue", 6.944444444);
    } 
    else 
    { 
		// Roxas-Bago
    	distMap.put("Roxas Avenue", 0.0);
        distMap.put("La Suerte Gallera", 0.9722222222);
        distMap.put("Matina Crossing", 1.944444444);
        distMap.put("Tahimik Avenue", 3.055555556);
        distMap.put("Bangkal", 4.027777778);
        distMap.put("Ulas", 5.0);
        distMap.put("Puan", 5.972222222);
        distMap.put("Bago Aplaya", 6.944444444);
    }

    Double currDist = distMap.get(currLoc);
    Double desDist = distMap.get(desLoc);

    if (currDist != null && desDist != null) 
	{
        return desDist - currDist;
    }

    return stopDistance;
}

	static double computeFare(double distance, Scanner scan)
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
			baseFare = regFare + (1.80 * distance);
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
				discRate = 0.20;
				break;
			case "Sr":
				discRate = 0.20;
				break;
			case "PWD":
				discRate = 0.20;
				break;
			default:
				System.out.println("Invalid Choice."); 
				break;
		}

		discAmount = baseFare - (baseFare * discRate);
		fare = discAmount;

		// round off to the nearest 25 centavos
		fare = Math.round(fare * 4) / 4.0;

		return fare;
	}


}

