//Реализовать возведение в степень - в лоб и придумать, как быстрее, за О(log n)

#include <iostream>
using namespace std;

int power1(int a, int b) // в лоб
{
	int res = 1;
	for (int i = 1; i <= b; i++)
		res *= a;
	return res;
}


int power2(int a, int b) // быстрее
{
	int res = 1;
	while (b > 0)
	{
		if (b % 2 == 1)
			res *= a;
		b /= 2;
		a *= a;
	}
	return res;
}


int main()
{
	int x,y;

	cout << "Enter x and y" << endl;
	cin >> x >> y;

	if (x == 0)
		cout << "x ^ y = 0";
	else
	{
		cout << power1(x, y) << endl;
		cout << power2(x, y) << endl;
	}

	return 0;
		
}




