//start time 18:08
//expected time 2 hours
//real time 1 hour 30 min
#include <stdio.h>
#include <iostream>
#include "set.h"

using namespace std;

enum Commands
{
	add = 1,
	del,
	check,
	printInc,
	printDec
};

int main()
{
	int command = -1;
	Node *mySet = createSet();

	while (command)
	{
		cout << endl;
		cout << "Enter 1 if you want to add the value to the set\n";
		cout << "Enter 2 if you want to delete the value from the set\n";
		cout << "Enter 3 if you want to check if value belongs to the set\n";
		cout << "Enter 4 if you want to print the set in increasing order\n";
		cout << "Enter 5 if you want to print the set in decreasing order\n";
		cout << "Enter 0 if you want to exit\n";
		cin >> command;

		ElementType value = 0;

		switch (command)
		{
		case add:
			cout << "Enter value\n";
			cin >> value;
			addToSet(mySet, value);
			break;
		case del:
			cout << "Enter value\n";
			cin >> value;
			deleteFromSet(mySet, value);
			break;
		case check:
			cout << "Enter value\n";
			cin >> value;
			if (checkValue(mySet, value))
				cout << "Belongs\n\n";
			else 
				cout << "Not belongs\n\n";
			break;
		case printInc:
			incPrint(mySet);
			break;
		case printDec:
			decPrint(mySet);
			break;
		default:
			if (command)
				cout << "Invalid command\n";
			break;
		}
	}

	if (mySet)
		deleteSet(mySet);

	return 0;
}