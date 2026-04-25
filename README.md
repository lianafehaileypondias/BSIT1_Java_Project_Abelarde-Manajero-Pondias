# BayadPo – Jeepney Fare Calculator and Route Validation System for Jeepney Routes in Davao City.

## Project Title
BayadPo is a Java program that serves as a fare calculation and route validation system based on public transportation routes in Davao City. At present, the program covers only the Bago Aplaya–Roxas Avenue route, but it already demonstrates its usefulness by helping commuters estimate fares before traveling, supporting better budgeting, promoting fairness through automated discounts, and encouraging efficient route awareness by showing valid stops.

## Purpose and Problem Being Solved
By reducing confusion and human error in fare computation, BayadPo provides a transparent, accurate, and accessible way to calculate fares, which is especially important today as rising oil prices continue to affect daily transportation costs. The program allows users to log in, choose a route, input their current location and destination, and then compute both the distance and the fare, including applicable discounts for students, seniors, and PWD passengers.

## Features
- Login system with email and PIN validation  
- Route selection between 'Bago Aplaya to Roxas Avenue' or 'Roxas Avenu to Bago Aplaya'
- Location validation using regular expressions for flexible input
- Distance calculation based on stops or mapped kilometers  
- Fare computation with discounts for students, seniors, and PWDs  
- Interactive loop allowing multiple trips until the user exits 

## Instructions on How to Run
1. Compile the Java program using: 'javac BayadPo.java'
2. Run the program with: 'java BayadPo'
3. Choose to log in with an email and 4-digit PIN or access as a guest.
4. Select your route, input your current location and destination.
5. The program validates inputs, computes distance, calculates fare, applies discounts, and displays the result.
6. Decide whether to continue or exit the program.

## Mapping of the 5 Lessons Used:
- Regular Expressions → Used in email and location validation → Ensures accurate and flexible input handling.
- Loops (Do-while) → Used in the main program loop → Keeps the system interactive until the user exits.
- Conditional Statements & Switch → Used in fare computation and passenger type selection → Provides decision-making logic for discounts and routes.
- Functions/Methods → Used throughout (e.g., userLogin, askRoute, computeFare) → Organizes code into reusable and modular components.
- Arrays & ArrayLists, HashMaps → Used in route storage and distance mapping → Efficiently manages stops and realistic distance calculations.
- Classes (Object-Oriented Programming) → Used to separate responsibilities (e.g., User, Route, FareCalculator, BayadPo) → Encapsulates logic into distinct modules, improves readability, and supports reusability across the program.

## Credits:
Developed by the BSIT1 Java Project team: Abelarde, Manajero, and Pondias.
