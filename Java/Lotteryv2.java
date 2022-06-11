import java.util.Scanner;
import java.util.Random;
class Lotteryv2 {
  public static void main(String[] args) {
    Random rand = new Random(); Scanner scan = new Scanner(System.in);
    int lotto[] = new int[6]; int lottocpu[] = new int[6]; int win_num=0;
    System.out.println("Enter your numbers (1 - 37)");
    for(int x=0; x < 6; x++)
    {
      do
      {
        System.out.print("Lotto ["+ (x+1) + "]: ");
        lotto[x] = scan.nextInt();
      }while(lotto[x] < 0 || lotto[x] > 37);
      lottocpu[x] = rand.nextInt(38); 
    }

    System.out.print("\nYour input numbers are: ");
    for(int x=0; x < 6; x++)
    {
       System.out.print(lotto[x] + " ");
    }

    System.out.print("\nThe winning numbers are: ");
    for(int x=0; x < 6; x++)
    {
       System.out.print(lottocpu[x] + " ");
    }
    System.out.println();
    for(int i=0; i < 6; i++){
      for(int j=0; j < 6; j++){
        if(lottocpu[i] == lotto[j]){
            System.out.println("Number is " + lottocpu[i]);
            win_num++;
        }
      }
    }

    if(win_num > 2)
    {
      System.out.println("You got (" + win_num +") matched numbers. Congratulations.");
    }
    else if(win_num == 0)
    {
      System.out.println("Your numbers didn't matched to any numbers. Sorry try again.");
    }
    else
    {
      System.out.println("You only got (" + win_num +") matched number/s. Sorry try again.");
    }
  }
}
