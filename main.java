import java.util.*;
import java.util.regex.*;

// Enum for BA-R route 
enum B2RRoute {
    DXSS(4), TAHIMIK(5), MATINA(6), ABSCBN(7),
    SM(9), ECOLAND(9), ALMENDRAS(10), ROXAS(11);

    private final int km;
    BARRoute(int km) { this.km = km; }
    public int getKm() { return km; }
}

// Enum for R-BA route 
enum R2BRoute {
    TULIP(4), LASUERTE(5), MATINA(6), TAHIMIK(7),
    DXSS(8), ULAS(9), PUAN(10), BAGO(11);

    private final int km;
    RBARoute(int km) { this.km = km; }
    public int getKm() { return km; }
}
	public class FinalProject
	{
		// MAIN //
		public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

		int route = askRoute(scan);
		
	    String currLoc = askCurrLoc(scan);
	    String destinationLoc = askDesLoc(scan);
	    
	}

	// 1.1 ASK ROUTE //
	static int askRoute(Scanner scan)
	{
		System.out.print("Route (1. Bago-Roxas | 2. Roxas-Bago): ");
		String route = scan.nextInt();
		scan.nextLine();
		return route;
	}

	// 1.2 ASK CURRENT LOCATION //
	static String askCurrLoc(Scanner scan)
	{
		System.out.print("Current Location: ");
		String currLoc = scan.nextLine();
		return currLoc;
	}

	// 1.3 ASK DESTINATION LOCATION //
	static String askDesLoc(Scanner scan)
	{
		System.out.print("Destination Location: ");
		String desLoc = scan.nextLine();
		return desLoc;
	}


	static String determineRoute(String currLoc, String destinationLoc)
	{
		ArrayList<String> brStops = new ArrayList<>();
		    b2rStops.add("Bago Aplaya"); 
		    b2rStops.add("Puan Crossing");
		    b2rStops.add("Ulas");
		    b2rStops.add("DXSS (Bangkal)"); 
		    b2rStops.add("Tahimik Avenue"); 
		    b2rStops.add("Matina Crossing");
		    b2rStops.add("ABS-CBN Junction");
		    b2rStops.add("SM City Davao"); 
		    b2rStops.add("Ecoland Terminal Crossing");
		    b2rStops.add("Almendras Gym");
		    b2rStops.add("Roxas Avenue");

		ArrayList<String> rbStops = new ArrayList<>();
		   	r2bStops.add("Roxas Avenue");
			r2bStops.add("Almendras Gym");
			r2bStops.add("Ecoland Terminal Crossing");
		   	r2bStops.add("Tulip Drive");
		   	r2bStops.add("La Suerte Gallera");
		   	r2bStops.add("Matina Crossing"); 
		   	r2bStops.add("Tahimik Avenue");
		   	r2bStops.add("DXSS (Bangkal)");
		   	r2bStops.add("Ulas");
		   	r2bStops.add("Puan Crossing");
		   	r2bStops.add("Bago Aplaya");

			
	}

}
