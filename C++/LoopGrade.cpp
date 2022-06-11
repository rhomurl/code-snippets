#include <iostream>
using namespace std;
main()
{
 int k,n, student,subject; char input;
    sta:
    cout<<"Enter number of students: ";
    cin>>student;
    cout<<"Enter number of subjects: ";
    cin>>subject;
    if ((student <= 10 && student >= 2) && subject <= 5 && (subject >= 2))
    {
        for (n = 1; n <= student; n++)
        {
            float total=0; float score = 0;
            cout << "\n\nGrade for student # " << n <<endl;

            for (k = 1; k <= subject; k++)
            {
                cout << "\tSubject" << k << ": ";
                cin >> score;
                if (score < 50 || score > 100) {
                    cout << "Enter valid score!" << endl;
                    k--;
                    continue;
                    }
                total += score;
            }
            total=total/subject;
            cout << "Average: " << total;
        }
    }
    else
    {
        cout << "Invalid inputs!";
    }
        cout << "\n\nTry again? [Y / N]: ";
        cin >> input;
    if (input == 'Y' || input =='y')
    {
        goto sta;
    }
}
