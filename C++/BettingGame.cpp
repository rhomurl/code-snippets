#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;
//1. The program will use random function (1-13)
//2. User and computer have 5k pesos
//3. Compare the number of user and computer and will show win or lose
//4. Display the result and the updated money of user and computer
//Random things
//Set both money
int main()
{
	int umoney=5000; int user_ran,com_ran, bet; char choice;
	srand(time(NULL)); 

	do 
	{
	cout << "Welcome to STR's betting game!\nDo you want to play?(Y/N)?";
	cin >> choice;
		if(choice == 'Y')
		{
      cout << "The user's money is: " << umoney << endl;
      cout << "The computer's money is: " << cmoney << endl;
      
      while(umoney > 0)
      {
        user_ran=rand() % 10 + 1; com_ran=rand() % 10 + 1;
        cout << "Enter bet: "; cin >> bet;
        if (user_ran > com_ran)
        {
          umoney-=bet;
          cout << "Lower!";
          cout << "The user's money is: " << umoney << endl;
          cout << "The computer's money is: " << cmoney << endl;
          cout << com_ran << endl;
          
        }
        else if (user_ran < com_ran)
        {
          umoney-=bet;
          cout << "Higher!";
          cout << "The user's money is: " << umoney << endl;
          cout << "The computer's money is: " << cmoney << endl;
          cout << com_ran << endl;
          
        }
        else if (user_ran == com_ran)
        {
          cmoney-=bet;
          cout << "Correct!";
          cout << "The user's money is: " << umoney << endl;
          cout << "The computer's money is: " << cmoney << endl;
          cout << com_ran << endl;
           
        }
      }
		}
	}while(choice == 'Y');
}
