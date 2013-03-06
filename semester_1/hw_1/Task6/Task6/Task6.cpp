#include <iostream>
#include "stdlib.h"

using namespace std;

int main()
{
	int N = 0, summ1 = 0, summ2 = 0, num = 0, ticket = 0;
	int mass[30] ;
	for (int i = 0; i <= 27; i++)
		mass[i] = 1;
	cout << " Enter the amount of tickets" << endl;
	cin >> N;
	for (int i = 1; i <= N; i++)
	{
		ticket = (rand() % 900+100)*1000+ (rand() % 1000);
		cout << ticket << endl;

			for (int j = 1; j <= 3; j++)
			{
				summ1 = summ1 + (ticket % 10);
				ticket = ticket / 10;
			}
			for (int j = 1; j <= 3; i++)
			{
				summ2 = summ2 + (ticket % 10);
				ticket = ticket / 10;
			}
			if (summ1 == summ2) 
				mass[summ1] ++ ;
			summ1 = 0;
			summ2 = 0;
	}
	for (int i = 0; i <= 27; i++)
		if (mass[i] > 1)
		num = num + mass[i];
	cout << num << endl;
	cin >> num;
	return 0;
}

			








