#include <iostream>
#include "stdlib.h"

using namespace std;

int main()
{
	bool func(int x)
	{
		for (int i = 2; i < x /2 ; i++)
			if (x % i == 0)
				return false;
		return true;
	}

	int t = 0;
	
	cout << "Enter number" << endl;
		cin >> t;

		for (int i = 2; i <= t; i++)
			if (func(i))
				cout << i << endl;
}

