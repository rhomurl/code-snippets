import java.util.Scanner;

public class PassengerFare {
    // Constants for discount rates
    private static final double STUDENT_DISCOUNT = 0.20;  // 20%
    private static final double SENIOR_DISCOUNT = 0.40;   // 40%
    private static final double PWD_DISCOUNT = 0.60;      // 60%
    private static final double UMASA_DISCOUNT = 0.86;    // 86%
    
    // Constants for base fares
    private static final double TANAUAN_FARE = 30.0;
    private static final double MALVAR_FARE = 16.0;
    
    // Constants for menu options
    private static final int STUDENT = 1;
    private static final int SENIOR = 2;
    private static final int PWD = 3;
    private static final int UMASA = 4;
    
    private static final String DIVIDER = "+---------------------------------------------------+";
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            processPassengerFare(scanner);
        }
    }
    
    private static void processPassengerFare(Scanner scanner) {
        displayMainMenu();
        int passengerType = getValidInput(scanner, 1, 4);
        
        switch (passengerType) {
            case STUDENT:
                processFareWithDiscount(scanner, "Student", STUDENT_DISCOUNT);
                break;
            case SENIOR:
                processFareWithDiscount(scanner, "Senior Citizen", SENIOR_DISCOUNT);
                break;
            case PWD:
                processFareWithDiscount(scanner, "PWD", PWD_DISCOUNT);
                break;
            case UMASA:
                processUmasaFare(scanner);
                break;
            default:
                System.out.println("Invalid selection!");
        }
    }
    
    private static void displayMainMenu() {
        System.out.println(DIVIDER);
        System.out.println("Passenger's Fare (Please choose where you belong)");
        System.out.println(DIVIDER);
        System.out.println("Price:");
        System.out.println("[1] Student (20% discount)");
        System.out.println("[2] Senior Citizen (40% discount)");
        System.out.println("[3] PWD (60% discount)");
        System.out.println("[4] Umasa (86% discount)");
        System.out.println(DIVIDER);
    }
    
    private static void displayDestinationMenu() {
        System.out.println("Choose your destination");
        System.out.println(DIVIDER);
        System.out.println("[1] Tanauan (₱" + TANAUAN_FARE + ")");
        System.out.println("[2] Malvar (₱" + MALVAR_FARE + ")");
        System.out.println(DIVIDER);
    }
    
    private static int getValidInput(Scanner scanner, int min, int max) {
        int input;
        do {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }
    
    private static void processFareWithDiscount(Scanner scanner, String passengerType, double discount) {
        System.out.println("\nYou selected " + passengerType + "!");
        displayDestinationMenu();
        
        int destination = getValidInput(scanner, 1, 2);
        double baseFare = (destination == 1) ? TANAUAN_FARE : MALVAR_FARE;
        double discountedFare = calculateDiscountedFare(baseFare, discount);
        
        processPayment(scanner, discountedFare);
    }
    
    private static void processUmasaFare(Scanner scanner) {
        System.out.println("\nYou selected Umasa!");
        System.out.println("Hindi ka nag-iisa, ok?");
        displayDestinationMenu();
        
        int destination = getValidInput(scanner, 1, 2);
        double baseFare = (destination == 1) ? TANAUAN_FARE : MALVAR_FARE;
        double discountedFare = calculateDiscountedFare(baseFare, UMASA_DISCOUNT);
        
        processPayment(scanner, discountedFare);
    }
    
    private static double calculateDiscountedFare(double baseFare, double discountRate) {
        return baseFare * (1 - discountRate);
    }
    
    private static void processPayment(Scanner scanner, double fare) {
        System.out.printf("Amount to pay: ₱%.2f%n", fare);
        double payment;
        
        do {
            System.out.print("Enter payment amount: ₱");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid amount!");
                scanner.next();
            }
            payment = scanner.nextDouble();
            
            if (payment < fare) {
                System.out.println("Insufficient payment! Please enter at least ₱" + fare);
            }
        } while (payment < fare);
        
        double change = payment - fare;
        System.out.println("\nThank you for choosing DLTBJeep!");
        System.out.printf("Change: ₱%.2f%n", change);
        System.out.println(DIVIDER);
    }
}
