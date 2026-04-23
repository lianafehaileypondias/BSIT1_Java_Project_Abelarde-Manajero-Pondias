import java.util.*;
import java.util.regex.*;

	public class FinalProject
	{
		// MAIN //
		public static void main(String[] args) 
		{
		    Scanner scan = new Scanner(System.in);
				// Enum for BA-R route //
			enum B2RRoute 
			{
			    DXSS (Bangkal)(4), 
                Tahimik Avenue(5), 
                Matina Crossing(6), 
                ABS-CBN Junction(7),
                SM City Davao(9), 
                Ecoland Terminal Crossing(9), 
                Almendras Gym(10), 
                Roxas Avenue(11);
                
			    private final int km;
			    B2RRoute(int km) { this.km = km; }
			    public int getKm() { return km; }
			}
			
			// Enum for R-BA route 
			enum R2BRoute 
			{
                Tulip Drive(4), 
                La Suerte Gallera(5), 
                Matina Crossing(6), 
                Tahimik Avenue(7),
                DXSS (Bangkal)(8), 
                Ulas(9), 
                Puan(10), 
                Bago Aplaya(11);
			
			    private final int km;
			    R2BRoute(int km) { this.km = km; }
			    public int getKm() { return km; }
			}
			
			ArrayList<String> route = askRoute(scan);

	        String currLoc = askCurrLoc(scan);
	        String desLoc = askDesLoc(scan);
	
	        printLocs(route, currLoc, desLoc);
		}

    // 1.1 ASK ROUTE
    static ArrayList<String> askRoute(Scanner scan)
    {
		// 
        System.out.print("Route (1. Bago-Roxas | 2. Roxas-Bago): ");
        int routeChoice = scan.nextInt();
        scan.nextLine();

        ArrayList<String> b2rStops = new ArrayList<>();
        b2rStops.add("Bago Aplaya"); 
        b2rStops.add("Puan");
        b2rStops.add("Ulas");
        b2rStops.add("DXSS (Bangkal)"); 
        b2rStops.add("Tahimik Avenue"); 
        b2rStops.add("Matina Crossing");
        b2rStops.add("ABS-CBN Junction");
        b2rStops.add("SM City Davao"); 
        b2rStops.add("Ecoland Terminal Crossing");
        b2rStops.add("Almendras Gym");
        b2rStops.add("Roxas Avenue");

        ArrayList<String> r2bStops = new ArrayList<>();
        r2bStops.add("Roxas Avenue");
        r2bStops.add("Almendras Gym");
        r2bStops.add("Ecoland Terminal Crossing");
        r2bStops.add("Tulip Drive");
        r2bStops.add("La Suerte Gallera");
        r2bStops.add("Matina Crossing"); 
        r2bStops.add("Tahimik Avenue");
        r2bStops.add("DXSS (Bangkal)");
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

	// 1.2 ASK CURRENT LOCATION //
    static String askCurrLoc(Scanner scan)
    {
        System.out.print("Current Location: ");
        return scan.nextLine();
    }

	// 1.3 ASK DESTINATION LOCATION //
    static String askDesLoc(Scanner scan)
    {
        System.out.print("Destination Location: ");
        return scan.nextLine();
    }

	// 1.4 PRINT LOCATIONS //
    static void printLocs(ArrayList<String> route, String currLoc, String desLoc)
    {
    	 System.out.println("Your ride: " + currLoc + " - " + desLoc);
    }
}
