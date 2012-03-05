//Найти наиболее часто встречающийся элемент в массиве быстрее, чем за O(n^2).
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <fstream>
#include "header.h"

using namespace std;

int main()
{
	setlocale(0,"Rus");

	const int length = 10;

	int *mass = new int[length];

	ifstream in("test1.txt");
    if (!in)
    {
        cerr << "File not found" << endl;
        return 1;
    }

    int size = 0;
    in >> mass[size];
    while (size < length && in)
        in >> mass[++size];

    in.close();

    for (int i = 0; i < size; i++)
        cout << mass[i] << ' ';
    cout << endl;

	qSort(mass, 0, length - 2 );

	int n1 = 1;
	int n2 = 1;
	int max = mass[0];

	for (int i = 1; i < length; i++)
	{
		if (mass[i] == mass[i - 1])
			n2 ++;
		else
		{
			if (n2 > n1)
			{
				max = mass[i - 1];
				n1 = n2;
			}
			n2 = 1;
		}
	}

	cout << "Наиболее часто встречающийся элемент в массиве = " << max << endl;
	
	delete[] mass;
	return 0;
}