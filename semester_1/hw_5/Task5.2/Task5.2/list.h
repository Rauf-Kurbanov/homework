#pragma once

struct List;

struct ListElement;

List *createList();  //������� ����� ������

ListElement *createListElement(); //������� ����� ������� ������

void addToEnd (List *list, int value); //�������� �������� � ����� ������

void addToSortedList (List *list,int value); //�������� �������� � ������������� ������

void deleteFromList(List *list, int value); //������� ������� �� ������ 

void deleteList(List *list); //������� ������

void printList(List *list); //����������� ������
