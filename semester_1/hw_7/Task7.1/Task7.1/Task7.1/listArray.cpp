#include "listArray.h"
#include <stdio.h>
#include <iostream>
using namespace std;

namespace arrayList
{
	struct ListElement
	{
		ElementType value;
		ListElement *next;
	};

	const int maxSize = 100;

	struct List
	{
		int count;
		ListElement* Elems[maxSize];
	};

	List *createList()
	{
		List *newList = new List;
		for (int i = 0; i < maxSize; i++)
		{
			newList->Elems[i] = new ListElement;

			newList->Elems[i]->value = 0;
		}
		newList->count = 0;
		return newList;
	}

	void addToEnd(List *list, ElementType element)
	{
		int i = 0;
		ListElement *tmp = new ListElement;
		tmp->value = element;
		for (;list->Elems[i]->value;i++);
		if (i >= maxSize)
			cerr << "Overflow\n";
		else
		{
			list->Elems[i] = tmp;
			list->Elems[i]->next = NULL;
			if (i > 0)
				list->Elems[i - 1]->next = list->Elems[i];
			list->count++;
		}
	}

	void deleteList(List *list)
	{
		delete[] *list->Elems;
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
		return list->Elems[0];
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
		for (int i = 0; i < list->count; i++)
			cout << list->Elems[i]->value->number << ' ' << list->Elems[i]->value->name << endl;
	}
}