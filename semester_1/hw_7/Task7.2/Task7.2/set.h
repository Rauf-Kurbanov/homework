#pragma once
#include "binTree.h"

typedef int ElementType;

Node *createSet(); //������� ���������

void deleteSet(Node *&set); //������� ���������

void addToSet(Node *&set, ElementType value); //�������� �������� � ���������

void deleteFromSet(Node *&set, ElementType value); //������� �������� �� ���������

bool checkValue(Node *set, ElementType value); //���������, ����������� �� �������� ���������

void incPrint(Node *set); //������ ��������� � ������� �����������

void decPrint(Node *set); //������ ��������� � ������� ��������