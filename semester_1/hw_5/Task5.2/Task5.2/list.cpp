#include "list.h"
#include <stdio.h>
#include <iostream>

using namespace std;

struct ListElement
{
	ListElement *next;
	int value;
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

void addToEnd (List *list, int value)
{
	ListElement *newEl = createListElement();
	list->tail->next = newEl; 
	list->tail = newEl;
	list->count++;
	list->tail->value = value;
}

void addToSortedList (List *list,int value)
{
	ListElement *temp = list->head;
	ListElement *newEl = createListElement();
	ListElement *memory = temp->next;
	newEl->value = value;
	while (true)
	{
		if (temp != list->tail)
		{
			if (temp->next->value > newEl->value )
			{
				memory = temp->next;
				temp->next = newEl;
				newEl->next = memory;
				list->count++;
				break;
			}
		}
		else
		{
			list->tail->next = newEl; 
			list->tail = newEl;
			list->count++;
			break;
		}
		
		temp = temp->next;
	}
}

void deleteFromList(List *list, int value)
{
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





