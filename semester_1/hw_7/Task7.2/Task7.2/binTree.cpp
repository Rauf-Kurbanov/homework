#include "binTree.h"
#include <stdio.h>
#include <iostream>

using namespace std;

struct Node
{
   ElementType value;
   Node *left;
   Node *right;
};

Node *createNode(ElementType value)
{
	Node *newTree = new Node;
	newTree->value = value;
	newTree->left = NULL;
	newTree->right = NULL;
	return newTree;
}

Tree *createTree()
{
	Tree *newTree = NULL;
	return newTree;
}

void addToTree(Node *&tree, int value)
{
   if (!tree)
       tree = createNode(value);
   else if (tree->value == value)
       return;
   else if (tree->value < value)
       addToTree(tree->right, value);
   else
       addToTree(tree->left, value);
}

ElementType deleteMin(Node *&tree)
{
   if (!tree->left)
   {
        int result = tree->value;
        tree = tree->right;
        return result;
   }
   else
       return deleteMin(tree->left);
}

void deleteNode(Node *&tree, ElementType value)
{
   if (tree)
   {
  	 if (value < tree->value)
  		 deleteNode(tree->left, value);
  	 else if (value > tree->value)
  		 deleteNode(tree->right, value);
  	 else if (tree->left == NULL && tree->right == NULL) 
	 {
  		 delete tree;
  		 tree = NULL;
  	 }
	 else if (!tree->left)
	 {
		 Tree* tmp = tree;
  		 tree = tree->right;
		 delete tmp;
	 }
  	 else if (!tree->right)
	 {
		 Tree* tmp = tree;
  		 tree = tree->left;
		 delete tmp;
	 }
  	 else
  		 tree->value = deleteMin(tree->right);
   }
}

void deleteTree(Node *&tree)
{
	if (!tree->left && !tree->right)
		delete tree;
	else if (!tree->left)
		{
			Tree* tmp = tree;
			tree = tree->right;
			deleteTree(tree);
		}
		else if (!tree->right)
		{
			tree = tree->left;
			deleteTree(tree);
		}
		else
		{
			deleteTree(tree->left);
			deleteTree(tree->right);
			deleteTree(tree);
		}
}

bool exists(Node *tree, ElementType value) 
{
   if (!tree)
       return false;
   if (tree->value == value)
       return true;
   if (tree->value < value)
       return exists(tree->right, value);
   return exists(tree->left, value);
}

void incPrintTree(Tree *tree)
{
	if (!tree)
	{
		cerr << "Empty\n";
		return;
	}
	if (tree->left)
		incPrintTree(tree->left);
	cout << tree->value << " ,";
	if (tree->right)
		incPrintTree(tree->right);	
}

void decPrintTree(Tree *tree)
{
	if (!tree)
	{
		cerr << "Empty\n";
		return;
	}
	if (tree->right)
		decPrintTree(tree->right);
	cout << tree->value << " ,";
	if (tree->left)
		decPrintTree(tree->left);	
}