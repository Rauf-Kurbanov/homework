/*
Ќаписать программу, котора€ заполн€ет массив случайными значени€ми (с использованием функции rand из stdlib.h),
потом преобразует его без использовани€ дополнительных массивов так, что в начале массива будут элементы, меньшие первого, а в конце - большие первого.
ѕрограмма должна работать за линейное врем€.
*/
#include <iostream>
#include <stdlib.h>


using namespace std;

int main()
{
	srand(1);
	int length = 0;

	cout << "Enter length" << endl;
	cin >> length;

	int *mass = new int[length];

	for (int i = 0; i < length; i++)
	{
		mass[i] = rand () % (101);
		cout << mass[i] << " ";
	}

	cout << endl;

	int begin = 1;
	int end = length - 1;
	int t = 0;


	while (true)
	{
		while (mass[begin] < mass[0])
			begin ++;
		while (mass[end] >= mass[0])
			end--;
		if (begin >= end)
			break;
		else
		{
			t = mass[begin];
			mass[begin] = mass[end];
			mass[end] = t;
		}
	}

	int i = 1;
	while (mass[i] <= mass[0])
		i++;
	t = mass[i - 1];
	mass[i - 1] = mass[0];
	mass[0] = t;

	for (int i = 0; i < length; i++)
		cout << mass[i] << " ";

	cout << endl;

	delete[] mass;
	return 0;
}