/*�������� ���������, ������� ������� ���������� �������� ����� � �������� �����. ������ ��������� ������, ���� ������� ������ �� �������� � ���������
(������ \t), ��� � ��� ��� �������� ������.*/

#include <stdio.h>
#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

int main()
{
	setlocale(0,"Rus");
	const int maxSize = 300;

	ifstream in("text.txt");
    if (!in)
    {
        cerr << "���� �� ������" << endl;
        return 1;
    }

	char ch;
	int num = 0;
	bool flag = false;
    int size = 0;

    in >> noskipws >> ch;
    while (size < maxSize && in)
	{
        in >> ch;
		cout << ch ;
		if (ch != '\n' && ch != ' ' && ch != '\t')
			flag = true;
		if (ch == '\n')
			if (flag )
			{
				num ++;
				flag = false;
			}
			cout << '[' << flag << ']'; //
			cout << " num = " << num << endl; //
	}

	if (flag)
		num++;

    in.close();

	cout << endl;
	cout << "���������� �������� ����� = " << num << endl;

	return 0;
}