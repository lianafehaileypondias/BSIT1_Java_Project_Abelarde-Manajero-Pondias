import java.util.*;
import java.util.regex.*;
import java.text.DecimalFormat;

    public class piste 
    {
        public static void main(String[] args) 
        {
            Scanner scan = new Scanner(System.in);

            System.out.println("===== LOGIN =====");
            System.out.println("1. Access with account");
            System.out.println("2. Access as guest");
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1)
            {
                userLogin(scan);
                runProgram(scan);
            }
            else
            {
                runProgram(scan);
            }
        }

        // 2. USER LOG-IN
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

        // 2.1 VALIDATE EMAIL
        static boolean validateEmail(String email)
        {
            String pattern = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; // pattern = "user@example.com"

            return email.matches(pattern);
        }

        // 2.1 VALIDATE PIN
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

        static void runProgram(Scanner scan)
        {
            DecimalFormat df = new DecimalFormat("0.00");
           
            boolean proceed = true;
            
            printRouteMap();

            do
            {
                ArrayList<String> route = askRoute(scan);
                System.out.print("Current Location: ");
                String currLoc = scan.nextLine();
                System.out.print("Destination: ");
                String desLoc = scan.nextLine();

                String validOrInvalid = validateLocs(route, currLoc, desLoc);



                if (validOrInvalid.equals("Valid"))
                {  
                    double distance = computeDistance(route, currLoc, desLoc);
                    System.out.println("Distance: " + df.format(distance));

                    double fare = computeFare(distance, scan);
                    System.out.println("Fare: Php " + df.format(fare)); 

                    System.out.println();
                    System.out.print("Would you like to proceed? (Yes/No): ");
                    String proceedChoice = scan.nextLine();
                    proceed = proceedChoice.equalsIgnoreCase("Yes");
                }
                else 
                {
                    System.out.print("Try again? (Yes/No): ");
                    String retry = scan.nextLine();
                    proceed = retry.equalsIgnoreCase("Yes");
                    continue;
                }
            } while (proceed);
        }

        //PRINT ROUTE MAP
        static void printRouteMap() {
            String[][] routeMap = new String[12][2];

            // B2R
            routeMap[0][0] = "BAGO APLAYA -> ROXAS AVENUE ROUTE";
            routeMap[1][0] = "Bago Aplaya";
            routeMap[2][0] = "Puan";
            routeMap[3][0] = "Ulas";
            routeMap[4][0] = "Bangkal";
            routeMap[5][0] = "Tahimik Avenue";
            routeMap[6][0] = "Matina Crossing";
            routeMap[7][0] = "ABSCBN";
            routeMap[8][0] = "SM City Davao";
            routeMap[9][0] = "Ecoland Terminal Crossing";
            routeMap[10][0] = "Almendras Gym";
            routeMap[11][0] = "Roxas Avenue";

            // R2B
            routeMap[0][1] = "ROXAS AVENUE -> BAGO APLAYA ROUTE";
            routeMap[1][1] = "Roxas Avenue";
            routeMap[2][1] = "Almendras Gym";
            routeMap[3][1] = "Ecoland Terminal Crossing";
            routeMap[4][1] = "Tulip Drive";
            routeMap[5][1] = "La Suerte Gallera";
            routeMap[6][1] = "Matina Crossing";
            routeMap[7][1] = "Tahimik Avenue";
            routeMap[8][1] = "Bangkal";
            routeMap[9][1] = "Ulas";
            routeMap[10][1] = "Puan";
            routeMap[11][1] = "Bago";

            // Column widths
            int colWidth = 35;

            System.out.println("+" + "-".repeat(colWidth) + "+" + "-".repeat(colWidth) + "+");

            // Print each row with borders
            for (int i = 0; i < routeMap.length; i++) {
                System.out.printf("|%-35s|%-35s|%n", routeMap[i][0], routeMap[i][1]);
                System.out.println("+" + "-".repeat(colWidth) + "+" + "-".repeat(colWidth) + "+");
            }
        }
    
        // 1.1 ASK ROUTE
        static ArrayList<String> askRoute(Scanner scan)
        {
            // Asks for the route to take //
            System.out.println("========== CHOOSE ROUTE ==========");
            System.out.println("1. Bago Aplaya ---> Roxas Avenue Route");
            System.out.println("2. Roxas Avenue ---> Bago Aplaya Route");
            System.out.print("Enter chosen route: ");
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

        // for RegEx
        static int findLocationIndex(ArrayList<String> route, String input) 
        {
            for (int i = 0; i < route.size(); i++) 
            {
                String stop = route.get(i);

                // Case-insensitive + partial match
                Pattern p = Pattern.compile(".*" + Pattern.quote(input) + ".*", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(stop);

                if (m.matches()) 
                {
                    return i;
                }
            }
            return -1;
        }

        // 1.2 PRINT LOCATIONS //
        static String validateLocs(ArrayList<String> route, String currLoc, String desLoc)
        {

            int currIndex = findLocationIndex(route, currLoc);
            int desIndex = findLocationIndex(route, desLoc);
            String validOrInvalid = "Valid";

            // to display correct name
            String currName = route.get(currIndex);
            String desName = route.get(desIndex);

            if (currIndex != -1 && desIndex != -1) 
            {
                if (currIndex < 0 || desIndex < 0 || currIndex > desIndex)
                {
                    System.out.println("Invalid. Recheck your locations...");
                    validOrInvalid = "Invalid";
                }
                else
                {
                    System.out.println("Your ride: " + currName + " -> " + desName);
                    validOrInvalid = "Valid";
                }
            }
            else 
            {
                System.out.println("Invalid locations. Consider taking the other route...");
                validOrInvalid = "Invalid";
            }
            return validOrInvalid;
        }

        static double computeDistance(ArrayList<String> route, String currLoc, String desLoc) 
        {
            int currIndex = findLocationIndex(route, currLoc);
            int desIndex = findLocationIndex(route, desLoc);

            currLoc = route.get(currIndex);
            desLoc = route.get(desIndex);

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
            System.out.println("========== PASSENGER TYPE ==========");
            System.out.println("Regular (R)\n" + "Student (St)\n" + "Senior (Sr) \n" + "PWD Passenger (PWD)\n");
            System.out.print("Enter choice: ");
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
