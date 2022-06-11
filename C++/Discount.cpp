#include<iostream>
using namespace std;
int main ()
{
int item_price, quantity, total, total_dsc, change, tendered;
cout << "Enter item price: ";
cin >> item_price;
cout << "Enter quantity : ";
cin >> quantity;
total = item_price * quantity;
cout << "Total amount: " << total << "\n\n";
if (total > 1000)
{
total_dsc = total-(total * 0.12);
total_dsc = total-total_dsc;
cout << "You have a 12% discount!\n\n";
cout << "Amount Due: " << total_dsc << endl;
cout << "Amount Tendered: "  <<;
cin >> tendered;
change = tendered - total_dsc;
cout << "Change: " << change << endl;
}
else
{
cout << "Amount Due: " << total << endl;
cout << "Amount Tendered: "  <<;
cin >> tendered;
change = tendered - total;
cout << "Change: " << change;
}
}
