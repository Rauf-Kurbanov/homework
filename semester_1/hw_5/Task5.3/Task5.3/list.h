#pragma once

typedef int ElementType;

struct List;

struct ListElement;

List *createList();  //������� ����� ������

void addToEnd(List *list, ElementType value); //�������� �������� � ����� ������

void addToCyclicalList(List *list, ElementType value); //�������� �������� � ����� ������������ ������
 
void deleteFromList(List *list, ElementType value); //������� ������� �� ������ 

void deleteList(List *list); //������� ������

void printList(List *list); //����������� ������

ListElement *getListHead(List *list); //��������� �������� ������ ������

ElementType elementValue(ListElement *element); //�������� �������� ��������

ListElement* getNext(ListElement *element); //������� � ���������� �������� ������

int listCounter(List *list); //�������� �������� �������� ������

void moveHead(List *list, ListElement *element); //��������� ������ ����� �� ������������ �������
