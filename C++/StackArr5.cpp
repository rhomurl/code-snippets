#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;
int content[5]={0,0,0,0,0};  

void display()
{
  for(int z=0; z < 5; z++)
  {
    cout << content[z] << "\t";
    
  }    
}
int main() {
  srand(time(NULL)); int index=0;
  //int n = sizeof(content)/sizeof(content[0]); 
  int ra; char choice;
  cout << "\t\tSelect operation: \nA. Push\nB. Pop\nC. Exit";
  
  while(choice != 'C')
  {
    
    ra=rand() % 50 + 1;
    cout << "\n\nEnter your choice: ";
    cin >> choice;

    switch(choice)
    {
      case 'A': //push
      if (index == 5)
      {
        cout << "Stack overflow :>";
      }
      else
      {
        cout <<"Push! Added number is: " << ra << "\tIndex is: " << index << endl;
        content[index]=ra; display(); index++;
      }
      break;

      case 'B': //pop
      if (index == 0)
      {
        cout << "Empty stack :>";
      }
      else 
      {
        index--;
        cout <<"Pop! Removed number is: " << content[index] << "\tIndex is: " << index << endl;
        content[index]=0; display();
      }
      break;
    }
    
  }
   return 0;
}
