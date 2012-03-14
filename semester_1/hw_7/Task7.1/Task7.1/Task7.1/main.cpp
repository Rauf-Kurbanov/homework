//expected time 3 hours
//real time about 2 hours

#include "listArray.h"
#include "listPoint.h"
#include "sort.h"
#include <stdio.h>
#include <conio.h>
#include <iostream>
#include <fstream>
using namespace std;
//using namespace pointList;
using namespace arrayList;

int main()
{
	ifstream in("test1.txt");
	
	List *directory = createList();
	char c[100];
	in.getline(c, 100);
	while (in)
	{
		ElementType tempValue = new Pair; 
	
		sscanf(c, "%llu%s", &tempValue->number, tempValue->name);
		addToEnd(directory, tempValue);
	
		in.getline(c, 100);
	}
	in.close();

	int command = 0;
	
	cout << "If you want to sort by number enter 1\n";
	cout << "If you want to to sort by name enter 2\n";
	cin >> command;

	List *exitDirectory = mergeSort(directory, command);
	printList(exitDirectory);

	deleteList(directory);
	deleteList(exitDirectory);
	return 0;
}