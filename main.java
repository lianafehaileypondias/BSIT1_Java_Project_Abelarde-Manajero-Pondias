import java.util.*;

	public class FinalProject
	{
		// MAIN //
		public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    String currLoc = askCurrLoc(scan);
	    String destinationLoc = askDesLoc(scan);
	    
	}

	// 1. ASK CURRENT LOCATION //
	static String askCurrLoc(Scanner scan)
	{
		System.out.print("Current Location: ");
		String currLoc = scan.nextLine();
		return currLoc;
	}

	// 1.1 ASK DESTINATION LOCATION //
	static String askDesLoc(Scanner scan)
	{
		System.out.print("Destination Location: ");
		String desLoc = scan.nextLine();
		return desLoc;
	}


	static String determineRoute(String currLoc, String destinationLoc)
	{
		ArrayList<String> brStops = new ArrayList<>();
		    brStops.add("Bago Aplaya"); 
		    brStops.add("Puan Crossing");
		    brStops.add("Ulas");
		    brStops.add("DXSS (Bangkal)"); 
		    brStops.add("Tahimik Avenue"); 
		    brStops.add("Matina Crossing");
		    brStops.add("ABS-CBN Junction");
		    brStops.add("SM City Davao"); 
		    brStops.add("Ecoland Terminal Crossing");
		    brStops.add("Almendras Gym");
		    brStops.add("Roxas Avenue");

		ArrayList<String> rbStops = new ArrayList<>();
		   	rbStops.add("Roxas Avenue");
			rbStops.add("Almendras Gym");
			rbStops.add("Ecoland Terminal Crossing");
		   	rbStops.add("Tulip Drive");
		   	rbStops.add("La Suerte Gallera");
		   	rbStops.add("Matina Crossing"); 
		   	rbStops.add("Tahimik Avenue");
		   	rbStops.add("DXSS (Bangkal)");
		   	rbStops.add("Ulas");
		   	rbStops.add("Puan Crossing");
		   	rbStops.add("Bago Aplaya");

			for (int i=0; )

		for (int i=0; i < routeStops.size(); i++)
		{
			if (routeStops.indexOf(currLoc))
		}


		    int currLocIndex = routeStops.indexOf(currLoc);
		    int desLocIndex = routeStops.indexOf(destinationLoc);

		    if (currLocIndex < desLocIndex) 
		    {
        		return "Bago Aplaya-Roxas Avenue Route";
		    } 
		    else if (currLocIndex > desLocIndex) 
		    {
		        return "Roxas Avenue-Bago Aplaya Route";
		    } 
		    else 
		    {
		        return "Current/Destination Locations are the same";
		    }
	}

}
