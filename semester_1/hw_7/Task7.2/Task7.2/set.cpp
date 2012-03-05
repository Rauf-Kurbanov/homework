#include "set.h"
#include "binTree.h"
#include <stdio.h>
#include <iostream>

using namespace std;

Node *createSet()
{
	Node *newSet = createTree();
	return newSet;
}

void deleteSet(Node *&set)
{
	deleteTree(set);
}

void addToSet(Node *&set, ElementType value)
{
	addToTree(set, value);
}

void deleteFromSet(Node *&set, ElementType value)
{
	deleteNode(set, value);
}

bool checkValue(Node *set, ElementType value)
{
	return exists(set, value);
}

void incPrint(Node *set)
{
	incPrintTree(set);
}

void decPrint(Node *set)
{
	decPrintTree(set);
}
