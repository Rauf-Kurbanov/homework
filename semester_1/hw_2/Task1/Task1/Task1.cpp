//Реализовать вычисление чисел Фибоначчи рекурсивно (и убедиться, что при n ~ 37 уже заметно медленно), реализовать итеративно, почувствовать разницу.

#include <iostream>
using namespace std;

int fib1(int x) //рекурсивно
{
	if (x < 3)
		return 1;
	else 
		return fib1(x - 2) + fib1(x - 1);
}

int fib2(int x) //итеративно
{
	int before1 = 1, before2 = 1;
	int now = 0;

	for (int i = 3; i <= x; i++)
	{
		now = before1 + before2;
		before2 = before1;
		before1 = now;
	}

	return now;
}


int main()
{
	setlocale(0,"Rus");

	int num;

	cout << "Введите номер числа Фибоначчи" << endl;
	cin >> num;

	cout << fib1(num) << endl; 

	cout << fib2(num) << endl; 

	return 0;
}




