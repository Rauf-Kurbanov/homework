//start time 22:51
//expected time 3 hours
//real time 5.30

#include <stdio.h>
#include <iostream>
#include <string>
#include "parseTree.h"
using namespace std;

Node *buildTree(FILE*& stream) 
{
	char ch = 0;
	int num = 0;
	Node *parseTree = NULL;
	Node *subTree = NULL;

	while (fscanf(stream, "%c", &ch) != -1)
	{
		if (ch == ' ')
			continue;
		else if (ch == ')')
			return parseTree;
		else if (ch == '(')
			addParseTree(buildTree(stream), parseTree);
		else
			if (ch >= '0' && ch <= '9')
			{
				ungetc(ch, stream);
				ch = NULL;
				(fscanf(stream, "%d", &num));
				subTree = createParseTree(num, ch);
				addParseTree(subTree, parseTree);
			}
			else
			{
				num = NULL;
				subTree = createParseTree(num, ch);
				addParseTree(subTree, parseTree);
			}	
	}
	return parseTree;
}
int main()
{
	FILE *stream = fopen("test1.txt", "r");
	Node *parseTree = buildTree(stream); //строим дерево по входным данным
	fclose(stream);

	printExpression(parseTree);
	cout << "= " << countExpression(parseTree);
	cout << endl;

	deleteTree(parseTree);

	return 0;
}