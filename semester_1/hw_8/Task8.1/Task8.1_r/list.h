#pragma once
#include <string>

using namespace std;

struct Pair 
{
	string key;
	int freq;
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

void deleteFromList(List *list, ElementType value); //������� ������� �� ������ 

string elementKey(ListElement *element); //�������� ���� ��������

int elementFreq(ListElement *element); //�������� ������� ��������

void riseElFreq(ListElement *element); //��������� ����� ������� �������� ������