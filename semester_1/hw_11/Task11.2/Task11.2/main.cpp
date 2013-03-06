//start time 22:05
//expected time 2 hours

#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int type(char sym)
{
	switch(sym)
	{
	case '/':
		return 2;
	case '*':
		return 3;
	default:
		return 1;
	}
}

int main()
{
	int conditions[6][6] = {0};
	ifstream in("transTable.txt");
    if (!in)
    {
        cerr << "File not found" << endl;
        return 1;
    }
	char temp = 0;
	while (temp != '#') //пропуск первой строки
		in >> temp;

	int reader = -2;
	for (int j = 0; j < 6; j++)                               
		for (int i = 0; i < 6; i++)
		{
			in >> reader;
			conditions[j][i] = reader;
		}

	in.close();

	/*for (int j = 0; j < 6; j++)               //проверяем, верно ли заполнена таблица
	{
		for (int i = 0; i < 6; i++)
			cout << conditions[j][i] << "  ";
		cout << endl;
	}*/

	
	ifstream inp("test1.txt");
    if (!inp)
    {
        cerr << "File not found" << endl;
        return 1;
    }
	const int print = 4;
	const int open = 5;
	int currCond = 0;
	char token = 0;
	while(inp)
	{
		inp >> noskipws >> token;
		if (conditions[currCond][open])
			cout << "/*";
		if (conditions[currCond][print])
			cout << token;

		currCond = conditions[currCond][type(token)];
		//cout << token;
	}

	in.close();
	return 0;
}