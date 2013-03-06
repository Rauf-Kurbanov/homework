#include "parseTree.h"
#include <stdio.h>
#include <iostream>
using namespace std;

struct Node
{
   int numValue;
   char operation;
   Node *left;
   Node *right;
};

Node *createParseTree(int num,char op)
{
	Node *newNode = new Node;
	newNode->numValue = num;
	newNode->operation = op;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}

void deleteTree(Node *&tree)
{
	if (tree->left)
		deleteTree(tree->left);
	if (tree->right)
		deleteTree(tree->right);
	delete tree;
}

void addParseTree(Node *subTree, Node *&tree)
{
	if (!tree)
		tree = subTree;
	else if (!tree->left)
		tree->left = subTree;
	else if (!tree->right)
		tree->right = subTree;
	else 
		cerr << "Error!\n";
}

void printNode(Node *parseNode)
{
	if (parseNode->numValue)
		cout << parseNode->numValue << " ";
	else if (parseNode->operation)
		cout << parseNode->operation << " ";
	else
		cout << "Empty node\n";
}

void printExpression(Node *parseTree)
{
	if (!parseTree)
		cerr << "Error\n";
	else
	{
		if (parseTree->left)
			cout << '(';
		printNode(parseTree);
		if (parseTree->left)
			printExpression(parseTree->left);
		if (parseTree->right)
			printExpression(parseTree->right);
		if (parseTree->left)
			cout << ") ";
	}
}

int countExpression(Node *parseTree)
{
	if (!parseTree)
		cerr << "Error\n";
	if (!parseTree->operation)
		return parseTree->numValue;

	switch (parseTree->operation)
	{
	case '+':
		return countExpression(parseTree->left) + countExpression(parseTree->right);
	case '-':
		return countExpression(parseTree->left) - countExpression(parseTree->right);
	case '*':
		return countExpression(parseTree->left) * countExpression(parseTree->right);
	case '/':
		return countExpression(parseTree->left) / countExpression(parseTree->right);
	default:
		cerr < "Invalid operator\n";
		return 0;
	}
}
