#pragma once

struct Node;

Node *createParseTree(int num,char ch); //������� ���� 

void addParseTree(Node *subTree, Node *&tree); //�������� ��������� 

void printExpression(Node *parseTree); //����������� 

int countExpression(Node *parseTree); //��������� ��������� 

void deleteTree(Node *&tree); //������� ������