/*Написать программу - телефонный справочник. Она должна уметь хранить имена и номера телефонов, в интерактивном режиме осуществлять следующие операции: 
0 - выйти 
1 - добавить запись (имя и телефон) 
2 - найти телефон по имени 
3 - найти имя по телефону 
4 - сохранить текущие данные в файл 
При запуске программа должна читать данные из файла, если файла нет - начинать с пустой базы номеров. Размер базы ограничен сотней записей, 
так что для внутреннего представления можно использовать массив. Формат представления данных в файле придумать самостоятельно.*/

#include "list.h"
#include <stdio.h>
#include <conio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	setlocale(0, "Rus");
	cout << "0 - выйти\n";
	cout << "1 - добавить запись (телефон и имя)\n";
	cout << "2 - найти телефон по имени\n";
	cout << "3 - найти имя по телефону\n";
	cout << "4 - сохранить текущие данные в файл\n\n";

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
		cout << "Введите команду:";
		int command = -1;
		cin >> command;

		switch (command)
		{
		default:
			cerr << "Неверная команда" << endl;
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
