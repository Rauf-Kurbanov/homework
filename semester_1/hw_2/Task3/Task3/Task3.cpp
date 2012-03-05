//Написать сортировки пузырьком и подсчётом

#include <iostream> 
#include <stdlib.h>

using namespace std;

int main()
{
	const int length = 10;
	int mass[length] ;

	
	for (int i = 0; i < length ; i++)
	{
		mass[i] = rand () % 101;
		cout << mass[i] << " ";
	}

	cout << endl;
	
	
	for (int i = 0; i < length; i++)
		for (int j = length - 1; j > i; j--)
			if (mass[j - 1] > mass[j])
			{
				int t = mass[j];
				mass[j] = mass[j - 1];
				mass[j - 1] = t;
			}

	for (int i = 0; i < length; i++)
		cout << mass[i] << " ";
	cout << endl;

	//////////////////////////////////////

	
	int id[101];
	for (int i = 0; i < 101; i++)
		id[i] = 0;

	for(int j = 0; j < length; j++)
		id[mass[j]]++;

	for (int i = 0; i < 100; i++)
		if (id[i] != 0)
			for (int j = 0; j < id[i]; j++)
				cout << i << " ";
	cout << endl;


	
	return 0;
}