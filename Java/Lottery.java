/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteryjvs;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author user
 */
public class Lottery {
    public static void main(String[] args) {
        Lotto sf = new Lotto();
        do {
            JOptionPane.showMessageDialog(null,"Welcome to 6/49 Lottery Game", "Lottery Game", JOptionPane.PLAIN_MESSAGE, sf.icon);
            sf.choice = JOptionPane.showConfirmDialog(null,"Do you want to play?","Lottery Game", JOptionPane.YES_NO_OPTION);
            sf.lottery_game();
        } while(sf.choice == JOptionPane.YES_OPTION);
        System.exit(0);
    }
}

class Lotto{
    ImageIcon icon = new ImageIcon("src//LotteryJvs/icon.png");
    int choice,prompt,numz,payment,change,rep,prizey;
    int price = 20; int yourNum[] = new int[6];
    String nummy[] = {"first", "second", "third", "fourth", "fifth", "sixth"};
    String storemyNum=""; String storelotNum=""; String myprize[] = new String[] {"","","","","50,000","2,000,000","10,000,000"};
    Object claimpr[] = {"Claim Prize"}; Object plAgain[] = {"Play Again"};

    //Random numbers minimum = 1 & maximum = 49. You can adjust sir the maximum to 7 to check if our conditional statements are all working :)
    int []lottery = new Random().ints(1, 7).distinct().limit(6).sorted().toArray();

    public void lottery_game(){
        if(rep == 1){
            choice = JOptionPane.showConfirmDialog(null,"Do you want to play again?","Lottery Game", JOptionPane.YES_NO_OPTION);
        }
        if(choice == JOptionPane.YES_OPTION){
            user_input();
            cond();
        }

        else{
            JOptionPane.showMessageDialog(null, "Thanks for playing! Bye!", "Lottery Game", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void user_input(){
        JOptionPane.showMessageDialog(null,"Please enter your desired lotto numbers\nNo repetition of numbers ok", "Lottery Game", JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 6; i++) {
            yourNum[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your " + nummy[i] + " number? (1-49 only)", "Lottery Game", JOptionPane.QUESTION_MESSAGE));
        }
        JOptionPane.showMessageDialog(null,"Rolling all numbers!", "Lottery Game", JOptionPane.INFORMATION_MESSAGE);

    }

    public void showNummy(){
        for (int i = 0; i < yourNum.length; i++) {
            storemyNum += yourNum[i] + " " ;
            storelotNum += lottery[i] + " " ;
        }

        JOptionPane.showMessageDialog (null, "Your numbers are: " + storemyNum + "\nLottery numbers are: " + storelotNum, "Lottery Game", JOptionPane.INFORMATION_MESSAGE);
    }

    public void payTicket(){
        payment = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter payment", "Lottery Game", JOptionPane.INFORMATION_MESSAGE));
        do{
            if(payment < price){
            payment = Integer.parseInt(JOptionPane.showInputDialog(null, "Insufficient payment! Please enter your payment again", "Lottery Game", JOptionPane.ERROR_MESSAGE));
            }
        } while(payment < price);
        change = payment - price;
        JOptionPane.showMessageDialog (null, "Your change is " + change + " PHP\nThank you for playing!", "Lottery Game", JOptionPane.INFORMATION_MESSAGE);
        resetnums();
    }

    public void wonprompt(){
        rep = 1;
        showNummy();
        prizey = JOptionPane.showOptionDialog (null, "Congratulations! " + numz + " numbers matched!\nPlease claim your prize!", "Lottery Game", JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, claimpr, claimpr[0]);
        if(prizey == JOptionPane.YES_OPTION){
            //Show prize
            JOptionPane.showMessageDialog(null, "You won " + myprize[numz] + " pesos!");
            resetnums();
            lottery_game();
        }

    }

    public void loseprompt(){
        rep = 1;
        showNummy();
        JOptionPane.showMessageDialog (null,
                "You lose the game. Better luck next time!\nPlease pay your ticket!",
                "Lottery Game",
                JOptionPane.INFORMATION_MESSAGE);
        payTicket();
        lottery_game();
    }
    public void cond(){
        if((yourNum[0] == lottery[0] || yourNum[0] == lottery[1] || yourNum[0] == lottery[2] || yourNum[0] == lottery[3] || yourNum[0] == lottery[4] || yourNum[0] == lottery[5]) &&
                (yourNum[1] == lottery[0] || yourNum[1] == lottery[1] || yourNum[1] == lottery[2] || yourNum[1] == lottery[3] || yourNum[1] == lottery[4] || yourNum[1] == lottery[5]) &&
                (yourNum[2] == lottery[0] || yourNum[2] == lottery[1] || yourNum[2] == lottery[2] || yourNum[2] == lottery[3] || yourNum[2] == lottery[4] || yourNum[2] == lottery[5]) &&
                (yourNum[3] == lottery[0] || yourNum[3] == lottery[1] || yourNum[3] == lottery[2] || yourNum[3] == lottery[3] || yourNum[3] == lottery[4] || yourNum[3] == lottery[5]) &&
                (yourNum[4] == lottery[0] || yourNum[4] == lottery[1] || yourNum[4] == lottery[2] || yourNum[4] == lottery[3] || yourNum[4] == lottery[4] || yourNum[4] == lottery[5]) &&
                (yourNum[5] == lottery[0] || yourNum[5] == lottery[1] || yourNum[5] == lottery[2] || yourNum[5] == lottery[3] || yourNum[5] == lottery[4] || yourNum[5] == lottery[5]))
        {
            //6 Matched
            numz = 6;
            wonprompt();
        }
        else if(
            //If lottery 1 != to any number
                ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                        (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                        (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                        (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                        (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                        (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 2 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 3 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 4 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5]))
                )
        {
            //5 Matched
            numz = 5;
            wonprompt();
            //   log("\nKulang pa ba ang pagmamahal ko? Sabihin mo lamang at aking dadagdagan. \nLima ang ang tumama. Yung isa naligaw na ng landas");
        }
        else if(

            //If lottery 1 and 2 != to any number
                ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                        (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                        (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                        (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                        (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                        (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 1 and 3 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 1 and 4 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 1 and 5 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 1 and 6 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        // If lottery 2 and 3 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 2 and 4 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 2 and 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||
                        // If lottery 2 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        // If lottery 3 and 4 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 3 and 5!= to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 3 and 6!= to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||


                        // If lottery 4 and 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        // If lottery 4 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        // If lottery 5 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5]))
                ){
            //4 Matched numbers
            numz = 4;
            wonprompt();
            //  log("\nSaan ba ito patungo? Maghihintay pa ba ako?\nHanggang dulo akong lalaban sa pagibig natin\n4 lang ang tumama. Naligaw ng landas yung dalawa");;
        }

        else if (
            //If lottery 1, 2 and 3 != to any number
                ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                        (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                        (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                        (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                        (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                        (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 1, 2 and 4 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5]))||

                        //If lottery 1, 2 and 5 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 1, 2 and 6 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 1, 3and 4 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 1 and 3, 5 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 1,3,6 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 1, 4 and 5 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 1, 4 and 6 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 1, 5 and 6 != to any number
                        ((lottery[0] != yourNum[0] || lottery[0] != yourNum[1] || lottery[0] != yourNum[2] || lottery[0] != yourNum[3] || lottery[0] != yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 2, 3and 4 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 2 and 3, 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5]) &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 2,3,6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 2, 4 and 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 2, 4 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        // If lottery 2, 5 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] != yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] != yourNum[5]) &&
                                (lottery[1] != yourNum[0] || lottery[1] != yourNum[1] || lottery[1] != yourNum[2] || lottery[1] != yourNum[3] || lottery[1] != yourNum[4] || lottery[1] != yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 3, 4 and 5 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] == yourNum[0] || lottery[5] == yourNum[1] || lottery[5] == yourNum[2] || lottery[5] == yourNum[3] || lottery[5] == yourNum[4] || lottery[5] == yourNum[5])) ||

                        //If lottery 3, 4 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] == yourNum[0] || lottery[4] == yourNum[1] || lottery[4] == yourNum[2] || lottery[4] == yourNum[3] || lottery[4] == yourNum[4] || lottery[4] == yourNum[5]) &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //If lottery 3, 5 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] != yourNum[0] || lottery[2] != yourNum[1] || lottery[2] != yourNum[2] || lottery[2] != yourNum[3] || lottery[2] != yourNum[4] || lottery[2] != yourNum[5]) &&
                                (lottery[3] == yourNum[0] || lottery[3] == yourNum[1] || lottery[3] == yourNum[2] || lottery[3] == yourNum[3] || lottery[3] == yourNum[4] || lottery[3] == yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5])) ||

                        //if lottery 4,5 and 6 != to any number
                        ((lottery[0] == yourNum[0] || lottery[0] == yourNum[1] || lottery[0] == yourNum[2] || lottery[0] == yourNum[3] || lottery[0] == yourNum[4] || lottery[0] == yourNum[5]) &&
                                (lottery[1] == yourNum[0] || lottery[1] == yourNum[1] || lottery[1] == yourNum[2] || lottery[1] == yourNum[3] || lottery[1] == yourNum[4] || lottery[1] == yourNum[5]) &&
                                (lottery[2] == yourNum[0] || lottery[2] == yourNum[1] || lottery[2] == yourNum[2] || lottery[2] == yourNum[3] || lottery[2] == yourNum[4] || lottery[2] == yourNum[5]) &&
                                (lottery[3] != yourNum[0] || lottery[3] != yourNum[1] || lottery[3] != yourNum[2] || lottery[3] != yourNum[3] || lottery[3] != yourNum[4] || lottery[3] != yourNum[5]) &&
                                (lottery[4] != yourNum[0] || lottery[4] != yourNum[1] || lottery[4] != yourNum[2] || lottery[4] != yourNum[3] || lottery[4] != yourNum[4] || lottery[4] != yourNum[5])  &&
                                (lottery[5] != yourNum[0] || lottery[5] != yourNum[1] || lottery[5] != yourNum[2] || lottery[5] != yourNum[3] || lottery[5] != yourNum[4] || lottery[5] != yourNum[5]))
                ) {
            showNummy();
                choice = (JOptionPane.showOptionDialog(null,
                    "Congratulations! You won another ticket!",
                    "Lottery Game",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    plAgain, plAgain[0]));
                resetnums();
                user_input();
        }
        else{
            loseprompt();
        }
    }
    public void resetnums() {
        this.storemyNum="";
        this.storelotNum="";
    }
}
