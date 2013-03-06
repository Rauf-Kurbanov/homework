#pragma once

struct Node;

Node *createParseTree(int num,char ch); //создать узел 

void addParseTree(Node *subTree, Node *&tree); //добавить поддерево 

void printExpression(Node *parseTree); //распечатать 

int countExpression(Node *parseTree); //сосчитать выражение 

void deleteTree(Node *&tree); //удалить дерево