/*Написать программу, которая в диалоговом режиме позволяет осуществлять следующие операции: 
0 - выйти 
1 - добавить значение в сортированный список 
2 - удалить значение из списка 
3 - распечатать список 
Все операции должны сохранять сортированность. Начинаем с пустого списка. Ограничений на длину списка нет.*/

#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	cout << "0 - exit" << endl;
	cout << "1 - add value in a sorted list" << endl;
	cout << "2 - remove the value form the list" << endl;
	cout << "3 - print list" << endl;

	List *list = createList();

	int command = -1;
	int value = 0;
	bool isEmpty = true; 
	while (true)
	{
		cout << "Enter command:";
		cin >> command;

		switch (command)
		{
		case 0:
			deleteList(list);
			return 0;
		case 1:
			{
				cout << "Enter value" << endl;
				cin >> value;
				if (isEmpty)
				{
					addToEnd(list, value);
					isEmpty = false;
				}
				else
					addToSortedList (list, value);
				break;
			}
		case 2:
			cout << "Enter value" << endl;
			cin >> value;
			deleteFromList(list, value);
			break;
		case 3:
			printList(list);
		}
	}

	return 0;
}