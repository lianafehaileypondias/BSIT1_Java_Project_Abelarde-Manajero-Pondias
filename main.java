import java.util.*;
import java.util.regex.*;
import java.text.DecimalFormat;

    // 0.0 CLASS DECLARATION (Lesson: Class)
    public class main
    {
        public static void main(String[] args) 
        {
            Scanner scan = new Scanner(System.in);

            // 1.0 LOGIN MENU DISPLAY
            System.out.println();
            System.out.println("======== LOGIN =======");
            System.out.println("1. Access with account");
            System.out.println("2. Access as guest");
            System.out.println();
            System.out.print("\tEnter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            // 1.1 LOGIN CHOICE (Lesson: Do While Loops & If else condition)
            do
            {
                System.out.println("Invalid. Try again...");
                System.out.print("\tEnter choice: ");
                choice = scan.nextInt();
                scan.nextLine();

                if (choice == 1)
                {
                    userLogin(scan);
                    runProgram(scan);
                }
                else if (choice == 2)
                {
                    runProgram(scan);
                }
                
            } while (choice != 1 && choice != 2);

        }

        // 2.0 USER LOG-IN (Lesson: Function)
        static void userLogin(Scanner scan)
        {
            boolean validEmail;
            do // 2.1 EMAIL INPUT LOOP (Lesson: Do-while)
            {
                System.out.println();
                System.out.print("\tEnter E-mail: ");
                String email = scan.nextLine();

                // 2.2 EMAIL VALIDATION CALL (Lesson: Function + RegEx)
                validEmail = validateEmail(email);
                
                if (validEmail) // 2.3 EMAIL VALIDATION CHECK (Lesson: If)
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
            validatePin(scan); // 2.4 PIN VALIDATION CALL (Lesson: Function)
        }

        // 2.5 VALIDATE EMAIL (Lesson: Function + RegEx)
        static boolean validateEmail(String email)
        {
            String pattern = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; // pattern = "user@example.com"

            return email.matches(pattern);
        }

        // 2.6 VALIDATE PIN (Lesson: Function + RegEx + Do-while)
        static void validatePin(Scanner scan)
        {
            boolean isValidPin;
            do
            {
                System.out.print("\tEnter Pin (4-digit pin): ");
                String userPin = scan.nextLine();

                // 2.7 PIN PATTERN MATCHING (Lesson: RegEx)
                String pinPattern = "^\\d{4}$"; // pattern requires exactly 4 digits

                isValidPin = userPin.matches(pinPattern);

                if (!isValidPin) // 2.8 PIN VALIDATION CHECK (Lesson: If)
                {
                    System.out.println("Invalid Pin. Try again...");
                }
            }
            while (!isValidPin);

            System.out.println("Pin accepted. Signing in...");
            System.out.println();
        }

        // 3.0 MAIN PROGRAM EXECUTION (Lesson: Function)
        static void runProgram(Scanner scan)
        {
            DecimalFormat df = new DecimalFormat("0.00");
            boolean proceed = true;
            
            printRouteMap(); // 3.1 ROUTE MAP DISPLAY (Lesson: Array)

            do // 3.2 MAIN LOOP (Lesson: Do-while)
            {
                // 3.3 ROUTE SELECTION (Lesson: Function + ArrayList)
                ArrayList<String> route = askRoute(scan);

                // 3.4 USER INPUT LOCATIONS
                System.out.print("\tCurrent Location: ");
                String currLoc = scan.nextLine();
                System.out.print("\tDestination: ");
                String desLoc = scan.nextLine();

                // 3.5 LOCATION VALIDATION (Lesson: Function)
                String validOrInvalid = validateLocs(route, currLoc, desLoc);

                // 3.6 VALID ROUTE CONDITION (Lesson: If)
                if (validOrInvalid.equals("Valid"))
                {  
                    // 3.7 DISTANCE COMPUTATION (Lesson: Function)
                    double distance = computeDistance(route, currLoc, desLoc);
                    System.out.println("Distance: " + df.format(distance) + " km");

                    // 3.8 FARE COMPUTATION (Lesson: Function + Switch)
                    double fare = computeFare(distance, scan);
                    String fareText = "Fare: Php " + df.format(fare);
                    int width = 25;
                    int padSize = (width - fareText.length()) / 2;
                    String padded = " ".repeat(padSize) + fareText + " ".repeat(width - fareText.length() - padSize);
                    System.out.println();
                    System.out.println("=============================");
                    System.out.printf("║ %s ║%n", padded);
                    System.out.println("============================="); 
                    System.out.println();

                    // 3.9 CONTINUE PROMPT
                    System.out.print("\tWould you like to proceed? (Yes/No): ");
                    String proceedChoice = scan.nextLine();
                    proceed = proceedChoice.equalsIgnoreCase("Yes");
                }
                else 
                {
                    // 3.10 RETRY PROMPT
                    System.out.print("\tTry again? (Yes/No): ");
                    String retry = scan.nextLine();
                    proceed = retry.equalsIgnoreCase("Yes");
                    continue;
                }
            } while (proceed);
        }

        // 4.0 ROUTE MAP DISPLAY (Lesson: 2D Array + Enums Concept)
        static void printRouteMap() {
            String[][] routeMap = new String[12][2]; // Lesson: Array

            // 4.1 ROUTE DATA INITIALIZATION (Enums-like fixed values)
            // Bago-Roxas
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

            // Roxas-Bago
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

            int colWidth = 35; // Column widths

            // 4.2 TABLE DISPLAY
            System.out.println(); 
            System.out.println("+" + "-".repeat(colWidth) + "+" + "-".repeat(colWidth) + "+");

            // Print each row with borders
            for (int i = 0; i < routeMap.length; i++) {
                System.out.printf("|%-35s|%-35s|%n", routeMap[i][0], routeMap[i][1]);
                System.out.println("+" + "-".repeat(colWidth) + "+" + "-".repeat(colWidth) + "+");
            }
        }
    
        // 5.0 ROUTE SELECTION (Lesson: Function + ArrayList)
        static ArrayList<String> askRoute(Scanner scan)
        {
            /// 5.1 ROUTE LIST INITIALIZATION (Lesson: ArrayList)
            // List of locations under the Bago-Roxas Route
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

            // List of locations under the Roxas-Bago Route
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

            System.out.println();
            System.out.println("============ CHOOSE ROUTE ============");
            System.out.println("1. Bago Aplaya ---> Roxas Avenue Route");
            System.out.println("2. Roxas Avenue ---> Bago Aplaya Route");
            System.out.println();

            int routeChoice = 0;

            do {
                System.out.print("\tEnter chosen route: ");

                routeChoice = scan.nextInt();
                scan.nextLine();

                if (routeChoice == 1) {
                    return b2rStops;
                } else if (routeChoice == 2) {
                    return r2bStops;
                } else {
                    System.out.println("Invalid Route. Try again...");
                }
            } while (true);

        }

        // 5.3 LOCATION INDEX FINDER (Lesson: Function + RegEx)
        static int findLocationIndex(ArrayList<String> route, String input) 
        {
            for (int i = 0; i < route.size(); i++) 
            {
                String stop = route.get(i);

                // 5.4 Pattern Matching (Lesson: RegEx)
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

        // 5.5 LOCATION VALIDATION LOGIC (Lesson: Function + If)
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
                    System.out.println();
                    System.out.println("Invalid. Recheck your locations...");
                    validOrInvalid = "Invalid";
                }
                else
                {
                    System.out.println();
                    System.out.println("Your ride: " + currName + " -> " + desName);
                    validOrInvalid = "Valid";
                }
            }
            else 
            {
                System.out.println();
                System.out.println("Invalid locations. Consider taking the other route...");
                validOrInvalid = "Invalid";
            }
            return validOrInvalid;
        }

        // 6.0 DISTANCE COMPUTATION (Lesson: Function + If + Array + Map)
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

            // 6.1 Distance Condition (Lesson: If)
            // If distance is <= 4 stops, keep old logic
            if (stopDistance <= 4) 
            {
                return stopDistance;
            }

            // 6.2 DISTANCE MAPPING (Lesson: Array/Map)
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

        // 7.0 FARE COMPUTATION (Lesson: Function + If + Switch)
        static double computeFare(double distance, Scanner scan)
        {
            double regFare = 12.00;
            double baseFare = 0; 
            double discRate = 0;
            double discAmount = 0;
            double fare = 0;

            // 7.1 BASE FARE CONDITION (Lesson: If)
            if (distance <= 4)
            {
                baseFare = regFare;
            }
            else if (distance > 4)
            {
                baseFare = regFare + (1.80 * distance);
            }

            // 7.2 PASSENGER TYPE SELECTION
            System.out.println();
            System.out.println("===== PASSENGER TYPE =====");
            System.out.println("- Regular (R)\n" + "- Student (St)\n" + "- Senior (Sr) \n" + "- PWD Passenger (PWD)\n");
            System.out.print("\tEnter choice: ");
            String passType = scan.nextLine().toLowerCase();

            // 7.3 DISCOUNT SELECTION (Lesson: Switch)
            switch (passType)
            {
                case "r":
                    discRate = 0.00;
                    break;
                case "st":
                    discRate = 0.20;
                    break;
                case "sr":
                    discRate = 0.20;
                    break;
                case "pwd":
                    discRate = 0.20;
                    break;
                default:
                    System.out.println("Invalid Choice."); 
                    break;
            }

            // 7.4 FARE CALCULATION
            discAmount = baseFare - (baseFare * discRate);  
            fare = discAmount;

            // 7.5 FARE ROUNDING
            fare = Math.round(fare * 4) / 4.0;

            return fare;
        }
    }
