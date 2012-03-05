#include <stdio.h>
#include <iostream>
#include <fstream>
#include "list.h"
#include "hashTable.h"

using namespace std;

int main()
{
	setlocale(0,"Rus");

	int size = 0;

	cout << "Enter the size of hash-table\n";
	cin >> size;
	HT *table = createHT(size);

	ifstream in("test1.txt");
	if (!in)
	{
        cerr << "File not found" << endl;
        return 1;
	}

	string reader = "";
	string corrector = "";

	while(in)
	{
		in >> reader;
		if(!in.fail())
		{
			if (reader[reader.length() - 1] == '.' || reader[reader.length() - 1] == ',') //считываем в таблицу слова без точек и запятых
				for (int i = 0; i < reader.length() - 1; i++)
					corrector = corrector + reader[i];
			else
				corrector = reader;
			addHT(corrector, table);
			corrector = "";
		}
	}

	in.close();
	printHT(table);
	deleteHT(table);
	return 0;
}