#include "list.h"
#include <stdio.h>
#include <iostream>

using namespace std;

struct ListElement
{
	ListElement *next;
	ElementType value;
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
	newEl->next = NULL;
	return newEl;
}

void addToEnd(List *list, ElementType value)
{
	ListElement *newEl = createListElement();
	list->tail->next = newEl; 
	list->tail = newEl;
	list->count++;
	list->tail->value = value;
}

void addToCyclicalList(List *list, ElementType value)
{
	ListElement *newEl = createListElement();
	list->tail->next = newEl; 
	list->tail = newEl;
	list->count++;
	list->tail->value = value;
	list->tail->next = list->head->next;
}

void deleteFromList(List *list, ElementType value)
{
	if (value == list->head->next->value)
		list->head->next = list->head->next->next;
	ListElement *temp = list->head;
	for (int i = 0 ; i < list->count; i++)
	{
		if (temp->next->value == value)
		{
			ListElement *memory = temp->next;
			temp->next = temp->next->next;
			delete memory;
			list->count--;
			break;
		}
		else
			temp = temp->next;
	}
}

void deleteList(List *list)
{
	ListElement *temp = list->head;
	for (int i = 0; i < list->count; i++)
	{
		ListElement *t = temp->next;
		delete temp;
		temp = t;
	}
	delete list;
}

void printList(List *list)
{
	ListElement *temp = list->head->next;
	for (int i = 0; i < list->count; i++)
	{
		cout << temp->value << endl;
		temp = temp->next;
	}
}

ListElement *getListHead(List *list)
{
	return list->head->next;
}

ElementType elementValue(ListElement *element)
{
	return element->value;
}

ListElement* getNext(ListElement *element)
{
	return element->next;
}

int listCounter(List *list)
{
	return list->count;
}

void moveHead(List *list, ListElement *element)
{
	list->head->next = element;
}




