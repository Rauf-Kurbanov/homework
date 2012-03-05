#pragma once

struct Pair 
{
	char name[15];
	unsigned long long number;
};

typedef Pair *ElementType;

struct List;

struct ListElement;

List *createList(); //������ ������

void addToEnd(List *list, ElementType element); //��������� ������� � ����� ������

void deleteList(List *list); //������� ������

int listCounter(List *list); //���������� ������ ��������� ������

ListElement *getListHead(List *list); //��������� �������� ������ ������

ListElement *createListElement(); //������� ������� ������

ElementType elementValue(ListElement *element); //�������� �������� ��������

ListElement* getNext(ListElement *element); //������� � ���������� �������� ������

void printList(List *list); //����������� ������

void clearList(List *list); //�������� ������

unsigned long long getNum(ListElement *element); //���������� ����� ��������

char* getName(ListElement *element); //���������� ���