#include "list.h"
#include "sort.h"
#include <stdio.h>
#include <string.h>

List *mergeSort(List *list, int variant)
{
	List *exitList = createList();
	if (listCounter(list) > 1)
	{
		const int number = 1;
		const int name = 2;

		List *leftList = createList();
		List *rightList = createList();
		ListElement *temp = getListHead(list);
	
		for (int i = 0; i < listCounter(list) / 2; i++)
		{
			addToEnd(leftList, elementValue(temp));
			temp = getNext(temp);
		}

		for (int i = 0; i < listCounter(list) - listCounter(list) / 2; i++)
		{
			addToEnd(rightList, elementValue(temp));
			temp = getNext(temp);
		}

		List *leftList2 = mergeSort(leftList, variant);
		List *rightList2 = mergeSort(rightList, variant);

		temp = getListHead(leftList2);
		ListElement *temp2 = getListHead(rightList2);

		if (variant == number) 
		{
			for (int i = 0; i < listCounter(list); i++)
			{
				if (!temp)
				{
					addToEnd(exitList, elementValue(temp2));
					temp2 = getNext(temp2);
				}
				else
					if (!temp2)
					{
						addToEnd(exitList, elementValue(temp));
						temp = getNext(temp);
					}
					else
						if (getNum(temp) <= getNum(temp2))
						{
							addToEnd(exitList, elementValue(temp));
							temp = getNext(temp);
						}
						else
						{
							addToEnd(exitList, elementValue(temp2));	
							temp2 = getNext(temp2);
						}
			}
		}

		if (variant == name)
		{
			for (int i = 0; i < listCounter(list); i++)
			{
				if (!temp)
				{
					addToEnd(exitList, elementValue(temp2));
					temp2 = getNext(temp2);
				}
				else
					if (!temp2)
					{
						addToEnd(exitList, elementValue(temp));
						temp = getNext(temp);
					}
					else
						if (strcmp(getName(temp), getName(temp2)) <= 0)
						{
							addToEnd(exitList, elementValue(temp));
							temp = getNext(temp);
						}
						else
						{
							addToEnd(exitList, elementValue(temp2));	
							temp2 = getNext(temp2);
						}
			}
		}
		deleteList(leftList);
		deleteList(rightList);
		return exitList;
	}
	else
	{
		return list;
	}
	
}

	