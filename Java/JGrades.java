import java.util.Scanner;
public class JGrades{
	public static void main(String[]args){

		
		 Scanner keyboard = new Scanner(System.in);

		 
		 	/* Math */
			System.out.println("Enter your grades in Math");
	        System.out.println("What is your WW & E score? ");
	        double mathwwe = Integer.parseInt(keyboard.nextLine());
	        double mathwwe1 = (((mathwwe / 150) * 100 * 0.50) + 50);
	        double mathwwe2 = Math.round(mathwwe1 * 100.0) / 100.0;
	        System.out.println("What is your PT score? ");
	        double mathpt = Integer.parseInt(keyboard.nextLine());
	        double mathpt1 = (((mathpt / 200) * 100 * 0.50) + 50);
	        double mathpt2 = Math.round(mathpt1 * 100.0) / 100.0;
	        double math = Math.round(((mathwwe2 + mathpt2)/2) * 100.0 / 100.0);
	        System.out.println("Your grade in Math is: " + math);
	        
	        System.out.println("");
	        
	        /* Filipino */
	        System.out.println("Enter your grades in Filipino");
	        System.out.println("What is your WW & E score? ");
	        double filwwe = Integer.parseInt(keyboard.nextLine());
	        double filwwe1 = (((filwwe / 150) * 100 * 0.50) + 50);
	        double filwwe2 = Math.round(filwwe1 * 100.0) / 100.0;
	        System.out.println("What is your PT score? ");
	        double filpt = Integer.parseInt(keyboard.nextLine());
	        double filpt1 = (((filpt / 200) * 100 * 0.50) + 50);
	        double filpt2 = Math.round(filpt1 * 100.0) / 100.0;
	        double fil = Math.round(((filwwe2 + filpt2)/2) * 100.0 / 100.0);
	       
	        System.out.println("Your grade in Filipino is: " + fil);
	        
	        /* Filipino */
	        System.out.println("Enter your grades in English");
	        System.out.println("What is your WW & E score? ");
	        double engwwe = Integer.parseInt(keyboard.nextLine());
	        double engwwe1 = (((engwwe / 150) * 100 * 0.50) + 50);
	        double engwwe2 = Math.round(engwwe1 * 100.0) / 100.0;
	        System.out.println("What is your PT score? ");
	        double engpt = Integer.parseInt(keyboard.nextLine());
	        double engpt1 = (((engpt / 200) * 100 * 0.50) + 50);
	        double engpt2 = Math.round(engpt1 * 100.0) / 100.0;
	        double eng = Math.round(((engwwe2 + engpt2)/2) * 100.0 / 100.0);
	       
	        System.out.println("Your grade in Filipino is: " + fil);
	        System.out.println("");
	        

	        System.out.println("");
	        System.out.println("");
	        String namen = "Name:"; String namep = "Juan Dela Cruz";
	        String sec = "Section:"; String secp = "ICT - C";
	        String head1 = "Subject"; String head2 = "Grade"; 
	        String head3 = "WW & E Score"; String head4 = "PT Score";
	        String div = "+-------------+--------------+----------+-------+";
	        String course1 = "Math"; String course2 = "Filipino";
	        String course3 = "English"; String course4 = "History";
	        String course5= "Programming";
	        String eline = "|";
	        String aver = "Average grade";
	        System.out.printf("%1s %5s %n", namen, namep);
	        System.out.printf("%1s %5s %n", sec, secp);
	        System.out.println(div);
	        System.out.printf("%1s %9s %3s %1s %1s %1s %1s %1s %1s %n", eline, head1, eline, head3, eline, head4, eline, head2, eline);
	        System.out.println(div);
	        System.out.printf("%1s %2s %7s %2s %2s %2s %2s %5s %2s %n", eline, course1, eline, mathwwe2, eline,  mathpt2, eline, math, eline);
	        System.out.printf("%1s %2s %3s %2s %2s %2s %2s %2s %2s %n", eline, course2, eline, filwwe2, eline, filpt2, eline, fil, eline);
	        System.out.printf("%1s %2s %3s %2s %2s %2s %2s %2s %2s %n", eline, course3, eline, engwwe2, eline,  engpt2, eline, eng, eline);
	        System.out.println(div);
	       
	}
	
}
