package lotteryjvs;

import javax.swing.*;
import java.util.*;

public class Lottery {
    public static void main(String[] args) {
        Lotto game = new Lotto();
        game.start();
    }
}

class Lotto {
    private static final int NUMBERS_TO_PICK = 6;
    private static final int MAX_NUMBER = 49;
    private static final int TICKET_PRICE = 20;
    private static final String[] ORDINALS = {"first", "second", "third", "fourth", "fifth", "sixth"};
    private static final String[] PRIZES = {"", "", "", "", "50,000", "2,000,000", "10,000,000"};
    
    private final ImageIcon icon = new ImageIcon("src//LotteryJvs/icon.png");
    private final int[] userNumbers = new int[NUMBERS_TO_PICK];
    private int[] lotteryNumbers;
    
    public void start() {
        do {
            showWelcomeMessage();
            if (askToPlay()) {
                playGame();
            } else {
                showGoodbyeMessage();
                break;
            }
        } while (true);
        System.exit(0);
    }
    
    private void playGame() {
        getUserNumbers();
        generateLotteryNumbers();
        int matchCount = countMatches();
        handleResult(matchCount);
    }
    
    private void getUserNumbers() {
        JOptionPane.showMessageDialog(null, 
            "Please enter your desired lotto numbers\nNo repetition of numbers ok", 
            "Lottery Game", 
            JOptionPane.INFORMATION_MESSAGE);
            
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < NUMBERS_TO_PICK; i++) {
            int num;
            do {
                num = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "What is your " + ORDINALS[i] + " number? (1-" + MAX_NUMBER + " only)", 
                    "Lottery Game", 
                    JOptionPane.QUESTION_MESSAGE));
            } while (!isValidNumber(num, uniqueNumbers));
            
            userNumbers[i] = num;
            uniqueNumbers.add(num);
        }
    }
    
    private boolean isValidNumber(int num, Set<Integer> existingNumbers) {
        return num >= 1 && num <= MAX_NUMBER && !existingNumbers.contains(num);
    }
    
    private void generateLotteryNumbers() {
        lotteryNumbers = new Random()
            .ints(1, MAX_NUMBER + 1)
            .distinct()
            .limit(NUMBERS_TO_PICK)
            .sorted()
            .toArray();
        
        JOptionPane.showMessageDialog(null, "Rolling all numbers!", 
            "Lottery Game", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private int countMatches() {
        Set<Integer> lotterySet = Arrays.stream(lotteryNumbers).boxed().collect(java.util.stream.Collectors.toSet());
        return (int) Arrays.stream(userNumbers).filter(lotterySet::contains).count();
    }
    
    private void handleResult(int matches) {
        showNumbers();
        
        if (matches >= 4) {
            handleWin(matches);
        } else {
            handleLoss();
        }
    }
    
    private void showNumbers() {
        String userNums = Arrays.stream(userNumbers)
            .mapToObj(String::valueOf)
            .collect(java.util.stream.Collectors.joining(" "));
        String lotteryNums = Arrays.stream(lotteryNumbers)
            .mapToObj(String::valueOf)
            .collect(java.util.stream.Collectors.joining(" "));
            
        JOptionPane.showMessageDialog(null, 
            "Your numbers are: " + userNums + 
            "\nLottery numbers are: " + lotteryNums, 
            "Lottery Game", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void handleWin(int matches) {
        JOptionPane.showMessageDialog(null, 
            "Congratulations! " + matches + " numbers matched!\n" +
            "You won " + PRIZES[matches] + " pesos!", 
            "Lottery Game", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void handleLoss() {
        JOptionPane.showMessageDialog(null,
            "You lose the game. Better luck next time!\nPlease pay your ticket!",
            "Lottery Game",
            JOptionPane.INFORMATION_MESSAGE);
        processPayment();
    }
    
    private void processPayment() {
        int payment;
        do {
            payment = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Enter payment", 
                "Lottery Game", 
                JOptionPane.INFORMATION_MESSAGE));
                
            if (payment < TICKET_PRICE) {
                JOptionPane.showMessageDialog(null,
                    "Insufficient payment! Please try again",
                    "Lottery Game",
                    JOptionPane.ERROR_MESSAGE);
            }
        } while (payment < TICKET_PRICE);
        
        int change = payment - TICKET_PRICE;
        JOptionPane.showMessageDialog(null,
            "Your change is " + change + " PHP\nThank you for playing!",
            "Lottery Game",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean askToPlay() {
        return JOptionPane.showConfirmDialog(null,
            "Do you want to play?",
            "Lottery Game",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    private void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null,
            "Welcome to 6/49 Lottery Game",
            "Lottery Game",
            JOptionPane.PLAIN_MESSAGE,
            icon);
    }
    
    private void showGoodbyeMessage() {
        JOptionPane.showMessageDialog(null,
            "Thanks for playing! Bye!",
            "Lottery Game",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
