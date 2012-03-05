#include "list.h"
#include <stdio.h>
#include <iostream>

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

void addToEnd (List *list, ElementType value)
{
	ListElement *newEl = createListElement();
	list->tail->next = newEl; 
	list->tail = newEl;
	list->tail->value = value;
	list->count++;
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

string elementKey(ListElement *element)
{
	return element->value->key;
}

int elementFreq(ListElement *element)
{
	return element->value->freq;
}

string pairKey(Pair *element)
{
	return element->key;
}

void riseElFreq(ListElement *element)
{
	element->value->freq++;
}