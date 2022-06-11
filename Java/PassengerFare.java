/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.util.*;
/*
/**
 *
 * PassengerFare with Hugot
 */
public class PassengerFare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        int amount, pf, change, loc;
        double st = 0.2; double sen = 0.4; double pwd = 0.6; double uma = 0.86;
        String div = "+---------------------------------------------------+";
        System.out.println(div);
        System.out.println("Passenger's Fare (Please choose on where you belong)");
        System.out.println(div);
        System.out.println("Price:" + "\n[1]Student (20%)\n[2]Senior (40%)\n[3]PWD (60%)\n[4]Umasa (86%)");
        System.out.println(div);
        Scanner pfare = new Scanner(System.in);
        pf = pfare.nextInt();
        switch (pf){
            case 4:
            System.out.println("You picked up Umasa!" + "\nHindi ka nagiisa ok?");
            System.out.println("Choose your destination" + "\n" + div + "\n[1]Tanauan\n[2]Malvar");
           
            System.out.println(div);   
            loc = pfare.nextInt();
                switch (loc){
                    case 1:
                 double st_tn = 30 - (st * 30) ;       
                 System.out.println("Amount: " + st_tn);
                 System.out.print("Enter pay: ");
                 amount = pfare.nextInt();   
                 System.out.println("Thank you for choosing DLJeepney!");
                 System.out.println("Change: " + (amount - st_tn) + " pesos");
                System.out.print(div);
                 break;
                    case 2:
                 double st_ml = 16 - (st * 16) ;       
                 System.out.println("Amount: " + st_ml);
                 System.out.print("Enter pay: ");
                 amount = pfare.nextInt();   
                 
                 System.out.println("Thank you for choosing DLTBJeep!");
                 System.out.println("Change: " + (amount - st_ml) + " pesos");
                 System.out.println(div);
                 break;
                }
          
        break;
             case 2:
            System.out.println("You picked up Senior!");
            System.out.println("Amount: " + sen);
            System.out.print("Enter pay: ");
                amount = pfare.nextInt();
            System.out.println("Thank you for choosing DLTBJeep!");
            System.out.println("Change: " + (amount - st) + "pesos");
        break;
        
        }     
}
    }
