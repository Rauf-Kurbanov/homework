#pragma once

typedef int ElementType;

struct Node;

typedef Node Tree;

Node *createNode(ElementType value); //������� ����

Tree *createTree(); //������� ������

void addToTree(Tree *&tree, ElementType value); //�������� ���� � ������

void deleteTree(Tree *&tree); //������� ������

void deleteNode(Tree *&tree, ElementType value); //������� ���� �� ������

bool exists(Tree *tree, ElementType value); //���������, ����������� �� ���� ������

void incPrintTree(Tree *tree); //������ ������ �� �����������

void decPrintTree(Tree *tree); //������ ������ �� ��������
