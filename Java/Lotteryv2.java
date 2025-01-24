import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lotteryv2 {
    private static final int LOTTERY_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 37;
    private static final int MIN_WINNING_NUMBERS = 3;
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] userNumbers = getUserNumbers(scanner);
            int[] winningNumbers = generateWinningNumbers();
            
            displayResults(userNumbers, winningNumbers);
            processMatches(userNumbers, winningNumbers);
        }
    }
    
    private static int[] getUserNumbers(Scanner scanner) {
        System.out.printf("Enter %d numbers (%d - %d)%n", LOTTERY_SIZE, MIN_NUMBER, MAX_NUMBER);
        int[] numbers = new int[LOTTERY_SIZE];
        Set<Integer> usedNumbers = new HashSet<>();
        
        for (int i = 0; i < LOTTERY_SIZE; i++) {
            numbers[i] = getValidNumber(scanner, i + 1, usedNumbers);
            usedNumbers.add(numbers[i]);
        }
        
        return numbers;
    }
    
    private static int getValidNumber(Scanner scanner, int position, Set<Integer> usedNumbers) {
        while (true) {
            System.out.printf("Lotto [%d]: ", position);
            int number = scanner.nextInt();
            
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.printf("Please enter a number between %d and %d%n", MIN_NUMBER, MAX_NUMBER);
                continue;
            }
            
            if (usedNumbers.contains(number)) {
                System.out.println("Number already used. Please enter a different number.");
                continue;
            }
            
            return number;
        }
    }
    
    private static int[] generateWinningNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        
        while (numbers.size() < LOTTERY_SIZE) {
            numbers.add(random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
        }
        
        return numbers.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
    
    private static void displayResults(int[] userNumbers, int[] winningNumbers) {
        System.out.println("\nYour input numbers are: " + formatNumbers(userNumbers));
        System.out.println("The winning numbers are: " + formatNumbers(winningNumbers));
    }
    
    private static String formatNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
    }
    
    private static void processMatches(int[] userNumbers, int[] winningNumbers) {
        Set<Integer> winningSet = Arrays.stream(winningNumbers)
                                      .boxed()
                                      .collect(Collectors.toSet());
                                      
        int matchCount = (int) Arrays.stream(userNumbers)
                                   .filter(winningSet::contains)
                                   .count();
                                   
        Arrays.stream(userNumbers)
              .filter(winningSet::contains)
              .forEach(num -> System.out.println("Matched number: " + num));
              
        displayMatchResult(matchCount);
    }
    
    private static void displayMatchResult(int matchCount) {
        if (matchCount >= MIN_WINNING_NUMBERS) {
            System.out.printf("You got (%d) matched numbers. Congratulations!%n", matchCount);
        } else if (matchCount == 0) {
            System.out.println("Your numbers didn't match any numbers. Sorry, try again.");
        } else {
            System.out.printf("You only got (%d) matched number%s. Sorry, try again.%n", 
                matchCount, matchCount > 1 ? "s" : "");
        }
    }
}
