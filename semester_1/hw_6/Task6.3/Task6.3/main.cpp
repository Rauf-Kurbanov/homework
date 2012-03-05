/*Написать программу проверки баланса скобок в строке, скобки могут быть трёх видов: (), [], {}. Скобочная последовательность вида ({)} 
считается некорректной, ({}) - корректной.*/

#include "stack.h"
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

int main()
{

	setlocale(0, "Rus");

	Stack *bracket = createStack();

	ifstream in("test.txt");
    if (!in)
    {
        cerr << "File not found" << endl;
        return 1;
    }

	ElementType temp = 0;
    while (in)
	{
        in >> temp;

		if (temp == '(' || temp == '[' || temp == '{')
				push(temp, bracket);
			
		if (temp == ')')
			if (stackTop(bracket) == '(') 
			pop(bracket);
			else
			{
				cout << "Not correct" << endl;
				deleteStack(bracket);
				return 0;
			}

			if (temp == ']')
				if (stackTop(bracket) == '[') 
					pop(bracket);
			else
			{
				cout << "Not correct" << endl;
				deleteStack(bracket);
				return 0;
			}

			if (temp == '}')
				if (stackTop(bracket) == '{') 
					pop(bracket);
			else
			{
				cout << "Not correct" << endl;
				deleteStack(bracket);
				return 0;
			}
				temp = '0';
	}
    in.close();

	if (stackTop(bracket) == '\0')
		cout << "Correct" << endl;
	else
		cout << "Not correct" << endl;

	deleteStack(bracket);
	return 0;
}