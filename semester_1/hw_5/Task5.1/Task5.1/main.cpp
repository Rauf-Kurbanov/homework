/*�������� ��������� - ���������� ����������. ��� ������ ����� ������� ����� � ������ ���������, � ������������� ������ ������������ ��������� ��������: 
0 - ����� 
1 - �������� ������ (��� � �������) 
2 - ����� ������� �� ����� 
3 - ����� ��� �� �������� 
4 - ��������� ������� ������ � ���� 
��� ������� ��������� ������ ������ ������ �� �����, ���� ����� ��� - �������� � ������ ���� �������. ������ ���� ��������� ������ �������, 
��� ��� ��� ����������� ������������� ����� ������������ ������. ������ ������������� ������ � ����� ��������� ��������������.*/

#include "list.h"
#include <stdio.h>
#include <conio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	setlocale(0, "Rus");
	cout << "0 - �����\n";
	cout << "1 - �������� ������ (������� � ���)\n";
	cout << "2 - ����� ������� �� �����\n";
	cout << "3 - ����� ��� �� ��������\n";
	cout << "4 - ��������� ������� ������ � ����\n\n";

	ifstream in("directory.txt");
	//getch();
	
	List *directory = createList();
	char c[100];
	in.getline(c, 100);
	while(in)
	{
		ElementType tempValue = new Pair; 
	
		sscanf(c, "%llu%s", &tempValue->number, tempValue->name);
		addToEnd(directory, tempValue);
	
		in.getline(c, 100);
	}
	in.close();
	
	unsigned long long num = 0;     
	while (true)
	{
		cout << "������� �������:";
		int command = -1;
		cin >> command;

		switch (command)
		{
		default:
			cerr << "�������� �������" << endl;
			break;
		case 0:
			deleteList(directory);
			return 0;
		case 1:
			{
				ElementType tempValue = new Pair;
				cin >> tempValue->number >> tempValue->name;
				addToEnd(directory, tempValue);
				break;
			}
		case 2:
			{
				char name[15]; 
				cin >> name;
				ListElement *temp = getListHead(directory);
				for (int i = 0; i < listCounter(directory); i++)
				{
					if (strcmp(elementValue(temp)->name, name) == 0)
						cout << elementValue(temp)->number << endl;
					temp = getNext(temp);
				}
				break;
			}
		case 3:
			{
				cin >> num;
				ListElement *temp = getListHead(directory);
				for (int i = 0; i < listCounter(directory); i++)
				{
					if (elementValue(temp)->number == num)
						cout << elementValue(temp)->name << endl;
					temp = getNext(temp);
				}
				break;
			}
		case 4:
			ofstream out("directory.txt");
			ListElement *temp = getListHead(directory);
			for (int i = 0; i < listCounter(directory); i++)
			{
				out << elementValue(temp)->number << " " << elementValue(temp)->name << endl;
				temp = getNext(temp);
			}
			out.close();
			break;
		}
	}
	
	deleteList(directory);
	return 0;
}
