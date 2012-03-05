#include "stack.h"
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

int prior(char sym)
{
	if (sym == '+' || sym == '-')
		return 1;
	if (sym == '*' || sym == '/')
		return 2;
}

int type(char sym)
{
	if (sym == '-' || sym == '+' || sym == '*' || sym == '/')
		return 1; //оператор
	if (sym == '(')
		return 2; //открывающаяся скобка
	if (sym == ')')
		return 3; //закрывающаяся скобка
	if (sym >= '0' && sym <= '9')
		return 4; //цифра
}

int main()
{
	ifstream in("input2.txt");
	ofstream out("output.txt");
    if (!in)
    {
        cerr << "File not found" << endl;
        return 1;
    }

	Stack *funcStack = createStack();

	char temp = 0;
	int num = 0;
	while (in >> temp)
	{
		switch (type(temp))
		{
		case 1:
			while (type(stackTop(funcStack)) == 1 && prior(temp) <= prior(stackTop(funcStack)))
			{
				out << stackTop(funcStack) << ' ';
				cout << stackTop(funcStack) << ' '; //
				pop(funcStack);
			}
			push(temp, funcStack);
			break;
		case 2:
			push(temp, funcStack);
			break;
		case 3:
			while (stackTop(funcStack) != '(')
			{
				if (stackTop(funcStack) == '\0')
				{
					out << endl << "Error: parentheses mismatched" << endl;
					cout << endl << "Error: parentheses mismatched" << endl; //
					return 1;
				}
				out << stackTop(funcStack) << ' ';
				cout << stackTop(funcStack) << ' '; //
				pop(funcStack);
			}
			pop(funcStack);
			if (type(temp) == 1)
			{
				out << temp << ' ';
				cout << temp << ' '; //
			}
			break;
		case 4:
			out << temp << ' ';
			cout << temp << ' '; //
			break;
		}
	}
	in.close();

	while (stackTop(funcStack) != '\0')
	{
		if (stackTop(funcStack) == '(')
		{
			out << endl << "Error: parentheses mismatched" << endl;
			cout << endl << "Error: parentheses mismatched" << endl; //
			return 1;
		}	
		out << stackTop(funcStack) << ' ';
		cout << stackTop(funcStack) << ' '; //
		pop(funcStack);
	}
	out.close();

	deleteStack(funcStack);
	return 0;
}