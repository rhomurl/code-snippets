#include <iostream>
#include <limits> //std::numeric_limits
#include <fstream>
#include <sstream>
#include <string>
#include <ctime>
#include <vector>
#include <bits/stdc++.h>
#include <sys/stat.h>
#include <sys/types.h>

using namespace std;

int dist, ps_type, choicefirst = 0, additional, newFare;
float sum = 0.00;
string filename = "month/";
string directory_file;
int current_day, current_month, current_year;
string passengertype[] = {"Normal Passenger", "Student", "Senior Citizen/PWD"};
float discount = 0.20;
float tempFare, currentFare, totalFare;

void GetFare(char addDistance);
void GetReceipt(float currentFare, float newFare);
void CreateLog(float totalFare);
void GetDateTime();
void getDailyTransaction();
void clear();

int main(int argc, char** argv){
  char rerun, addDistance;

  if (mkdir("month", 0777) == -1)
  {
    //Created month folder
  }  

	do {
    cout << "[1] Ride a bus\n[2] Today's transaction\n";
    cout << "\nChoose one: ";
    cin >> choicefirst;

    switch(choicefirst)
    {
      case 2:
        getDailyTransaction();
      break;

      case 1:
        cout << "\nPassenger Type: " << endl;
        for(int z=0; z < 3; z++){
          if((z ==  1) || (z ==  2)){
            cout << "[" << z+1 <<  "] " << passengertype[z] << " (20%)\n";
          }
          else{
            cout << "[" << z+1 <<  "] " << passengertype[z] << "\n";
          }
        }

        cout << "Passenger Type: ";
        while (!(cin >> ps_type)) {
          cout << "Invalid Loyalty Card" << endl << endl;
          cout << "Loyalty Card Type: ";
          cin.clear();
          cin.ignore(3, '\n');
        }

        cout << "Travel Distance (km): ";
        while (!(cin >> dist)) {
          cout << "Invalid Input" << endl << endl;
          cout << "Travel Distance: ";
          cin.clear();
          cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }

        GetFare(addDistance);
        tempFare = currentFare;
        cout << endl;

        cout << "Would you like to add travel distance? [Y/N]: ";
        cin >> addDistance;

        switch(addDistance){
          case 'Y':
            addDistance = 'Y';
          break;
          case 'y':
            addDistance = 'Y';
          break;
          case 'N':
            addDistance = 'N';
          break;
          case 'n':
            addDistance = 'N';
          break;
          default:
            addDistance = 'N';
          break;
        }
        
        if(addDistance == 'Y' || addDistance == 'y'){

          cout << "Enter additional distance (km): ";
          additional = dist;

          while (!(cin >> dist)) {
            cout << "Invalid Input" << endl << endl;
            cout << "Enter additional distance (km): ";
            cin.clear();
            cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
          }
        }

        GetFare(addDistance);
        cout << "\nAnother Transaction? [Y/N]: ";
        cin >> rerun;
        clear();
        cout << endl;
        totalFare = 0;
        addDistance = ' ';
      break;

      default:
        return 0;
      break;
  } 
} while (rerun != 'N' && rerun != 'n');
	return 0;
}

void GetFare(char addDistance){
    float newFare;
    switch(ps_type){
    case 1:
        currentFare = dist * 1.95;
        break;
    case 2:
        currentFare = dist * 1.95;
        currentFare = currentFare - (currentFare * discount);
        break;
    case 3:
        currentFare = dist * 1.95;
        currentFare = currentFare - (currentFare * discount);
        break;
    default:
        currentFare = dist * 1.95;
        break;
    }

    if(addDistance == 'N' || addDistance == 'n'){
        totalFare = totalFare + currentFare;
        GetReceipt(currentFare, 0);
    }else if(addDistance == 'Y' || addDistance == 'y'){
        newFare = tempFare + currentFare;
        totalFare = totalFare + newFare;
        GetReceipt(currentFare, newFare);
        tempFare = 0;
    }
}

void GetReceipt(float currentFare, float newFare){
    cout << "\n===Bus Fare Transaction Receipt===" << endl;
    cout << "Travel Distance: ";
    if(newFare == 0){
        cout << dist;
    }else{
        cout << additional;
    }
    cout << endl;

    cout << "Passenger Type: ";
    if(ps_type == 1){
        cout << "Normal Passenger";
    }else if(ps_type == 2){
        cout << "Student";
    }else if(ps_type == 3){
        cout << "Senior Citizen/PWD";
    }
    cout << endl;

    cout << "Discount: ";
    if(ps_type == 1){
        cout << "0%";
    }else if(ps_type == 2 || ps_type == 3){
        cout << "20%";
    }
    cout << endl;

    cout << "Fare: Php" << tempFare << endl;

    cout << "Additional Travel Distance: ";
    if(newFare == 0){
        cout << "N/A";
    }else{
        cout << dist;
    }
    cout << endl;

    cout << "Additional Fare: ";
    if(newFare == 0){
        cout << "N/A";
    }else{
        cout << "Php " << currentFare;
    }
    cout << endl;

    cout << "Total Fare: Php";
    if(newFare == 0){
        cout << currentFare;
    }else{
        cout << newFare;
    }
    cout << endl;
    cout << "=================================";
    CreateLog(totalFare);
}

void CreateLog(float totalFare){
  GetDateTime();
   ofstream fout;
   ifstream fin;


  if (mkdir("month/1", 0777) == -1 || mkdir("month/2", 0777) == -1 || mkdir("month/3", 0777) == -1 || mkdir("month/4", 0777) == -1 || mkdir("month/5", 0777) == -1 || mkdir("month/6", 0777) == -1 || mkdir("month/7", 0777) == -1 || mkdir("month/8", 0777) == -1 || mkdir("month/9", 0777) == -1 || mkdir("month/10", 0777) == -1 || mkdir("month/11", 0777) == -1 || mkdir("month/12", 0777) == -1)
  {
    //Directories for Months Created
  }

directory_file = filename + "/" + to_string(current_month) + "/" + to_string(current_day) + ".txt" ; 
  fin.open(directory_file);
  fout.open (directory_file,ios::app);

  if(fin.is_open())
      GetDateTime();
      if(newFare < 0){
        totalFare = newFare;
      }
      fout << totalFare << endl;;
    cout<<"\nData has been sucessfully recorded"<<endl;
    fin.close();
    fout.close();
}

void GetDateTime(){
    time_t t = time(NULL);
    tm* tPtr = localtime(&t);
    current_day = tPtr->tm_mday;
    current_month = tPtr->tm_mon+1;
    current_year = tPtr->tm_year+1900;
}

void getDailyTransaction(){
  GetDateTime();
  string filename = "month/";
  directory_file = filename + "/" + to_string(current_month) + "/" + to_string(current_day) + ".txt" ; 
   fstream MyFile;  // declare a file
        MyFile.open(directory_file, ios::in); // open the file
        string line;
        while (getline(MyFile, line))  //reading a line from the file while possible
        {
            sum = sum + stoi(line);    //Convert the string to int and add it to the sum
        }
        MyFile.close();   //Close the file
        if(sum == 0){
          cout << "\nThere are no transactions today" << endl;
        }else {
          cout << "\nToday's Total Transaction is: " << sum << endl << endl;  // sum for today
        }
    cin.get();
}

void clear()
{
  cout << "\x1B[2J\x1B[H";
}

