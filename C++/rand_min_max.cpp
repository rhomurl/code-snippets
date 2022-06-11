#include <iostream>
#include <stdlib.h>
#include <time.h>
//#include <bits/stdc++.h> 
using namespace std;
//sort(x, x + 5, greater<int>()); 
int main() 
{
  int x[5]; int min=49; int max=0; srand(time(NULL)); 
  // greater than (>) or less than (<
  cout << "\nNumbers:" << endl;  
  for(int a=0; a < 5; a++)
  {
    x[a]=rand() % 50 + 1;
    cout << "Value of x[" << a << "] is: " << x[a] << endl;

    if(x[a] < min) 
    {
    // greater 
      min = x[a];
    }
    if(x[a] > max)
    {
      //less than
      max = x[a];
    }
  }
  cout << endl;
  cout << "Minimum value is: " << min << endl;
  cout << "Maximum value is: " << max << endl;
}
