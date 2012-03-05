#include "list.h"
#include "sort.h"
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

struct ListElement
{
	ElementType value;
	ListElement *next;
};

struct List
{
	int count;
	ListElement *head;
	ListElement *tail;
};

List *createList()
{
	List *rootList = new List;
	ListElement *guard = new ListElement;
	rootList->head = guard;
	rootList->tail = guard;
	rootList->tail->next = NULL;
	rootList->count = 0;
	return rootList;
}

ListElement *createListElement()
{
	ListElement *newEl = new ListElement;
	newEl->value = NULL;
	newEl->next = NULL;
	return newEl;
}

void addToEnd(List *list, ElementType value)
{
	ListElement *newEl = createListElement();
	list->tail->next = newEl; 
	list->tail = newEl;
	list->tail->value = value;
	list->count++;
}

void clearList(List *list)
{
	ListElement *temp = list->head->next;
	while (temp != NULL)
	{
		ListElement *t = temp->next;
		delete temp;
		temp = t;
	}
}

void deleteList(List *list)
{
	ListElement *temp = list->head;
	while (temp != NULL)
	{
		ListElement *t = temp->next;
		delete temp;
		temp = t;
	}
	delete list;
}

int listCounter(List *list)
{
	return list->count;
}

ListElement* getNext(ListElement *element)
{
	return element->next;
}

ListElement *getListHead(List *list)
{
	return list->head->next;
}

ElementType elementValue(ListElement *element)
{
	return element->value;
}

unsigned long long getNum(ListElement *element)
{
	return element->value->number;
}

char* getName(ListElement *element)
{
	return element->value->name;
}

void printList(List *list)
{
	ListElement *temp = list->head->next;
	for (int i = 0; i < list->count; i++)
	{
		cout << temp->value->number << ' ' << temp->value->name << endl;
		temp = temp->next;
	}
}
