#include<iostream>
using namespace std;
int main ()
{
int num = 37; int input; int lives = 2;
cout << "Guess my number: ";
cin >> input;
goto guess;
guess2:
lives-=1;
cout << "\nGuess my number again: ";
cin >> input;
goto guess;
guess:if ((input > num) && (lives > 0))
{
cout << "\nSorry, it is higher than my number." << endl;
goto guess2;
}
else if ((input < num) && (lives > 0))
{
cout << "\nSorry, it is lower than my number." << endl;
goto guess2;
}
else if (input == num)
{
cout << "\nCongratulations! You got it!!";
}
else {
cout << "\nSorry, better luck next time!";
}
}
