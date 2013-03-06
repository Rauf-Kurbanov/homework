//start time 19:24
//expected time 3 hours
//end time 20:36
//real time 1:12

#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int type(char sym)
{
	if (sym >= '0' && sym <= '9')
		return 2;
	switch(sym)
	{
	case '#':
		return 1;
	case '.':
		return 3;
	case 'E':
		return 4;
	case '+':
		return 5;
	case '-':
		return 6;
	default:
		return 0;
	}
}

int main()
{
	int conditions[9][9] = {0};
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
	for (int j = 0; j < 9; j++)                    
		for (int i = 0; i < 9; i++)
		{
			in >> reader;
			conditions[j][i] = reader;
		}
	in.close();

	/*for (int j = 0; j < 9; j++)               //проверяем, верно ли заполнена таблица
	{
		for (int i = 0; i < 9; i++)
			cout << conditions[j][i] << "  ";
		cout << endl;
	}*/

	string token = "";
	string end = "#";
	cout << "Enter a real number\n";
	cin >> token;
	//cout <<  token;  //тоже проерка
	token = token + end;

	const int trueReal = 7;
	const int falseReal = 8;
	int currCond = 0;
	bool ifReal = false;

	for (int i = 0; i < token.length(); i++)
	{
		if (!type(token[i]))
			break;
		if (conditions[currCond][trueReal])
		{
			ifReal = true;
			break;
		}
		if (conditions[currCond][falseReal])
			break;

		currCond = conditions[currCond][type(token[i])];
	}

		if (conditions[currCond][trueReal])
			ifReal = true;

	if (ifReal)
		cout << "Correct\n";
	else
		cout << "Incorrect\n";
	return 0;
}