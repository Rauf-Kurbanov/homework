/*"����������" -- ����� �� 41-�� �������, ���������� ����������� �������� �������, �� ������� ��������� � ���� ������������� ��� ������������� ����� ������.
������� ����� � ���� � ������������, ��� ������ ��� ����� ����� ������� ��������, ���� �� �������� ���. ������������ � ������ ����, �� ���, 
��� � ����� ������ ��������� ���������, ������ ����� ��� ���������. ����� ������, ������������� ���� �������, ����� ������ ���������, 
��� ����� ����� ��� � ��� �����, ����� �������� ����������, �� �� ��� ����, ����� ����� ���� �����, � ����� ����� �������� ��������. 
� ����� ������ ��������� n ������ � ������� ������� m-��. ��������� ���������� ����� k ��������� ������� �����, ������� ������ ����� �������� ���������. 
������� � ������� ������������ ������.*/

#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	int amount = 0;
	cout << "Enter amount" << endl;
	cin >> amount;
	int kill = 0;
	cout << "Enter killed number" << endl;
	cin >> kill;

	List *army = createList();
	ElementType tmp = 0;
	for (int i = 0; i < amount; i++)
		addToCyclicalList(army, i + 1);

	int counter = 1;
	ListElement *temp = getListHead(army);
	ElementType memory = 0;
	
	while (true)
	{
		if (listCounter(army) == 1)
			break;
		if (counter == kill)
		{
			memory = elementValue(temp);
			temp = getNext(temp);
			deleteFromList(army, memory);
			counter = 1;
		}
		else
		{
			temp = getNext(temp);
			counter++;
		}
	}

	cout << "Last solider position" << endl;
	printList(army);

	deleteList(army);
	return 0;
}