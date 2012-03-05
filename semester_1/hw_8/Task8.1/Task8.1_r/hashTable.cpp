#include "hashTable.h"
#include "list.h"
#include <iostream>

struct HT
{
	int size;
	List **buckets;
};

unsigned HFunc(string value)
{
	unsigned result = 0;
	for (int i = 0; i < value.length(); i++)
		result = int(value[i]) % 19 + result;
	return result;
}

HT *createHT(int size)
 {
	 HT *newTab = new HT;
	 newTab->buckets = new List*[size];
	 for (int i = 0; i < size; i++)
		 newTab->buckets[i] = createList();
	 newTab->size = size;
	 return newTab;
 }

void deleteHT(HT *table)
{
	for (int i = 0; i < table->size; i++)
		deleteList(table->buckets[i]);
	delete table;
}

bool exist(string value, HT *table)
{
	bool ifExist = false;
	ListElement *temp = getListHead(table->buckets[HFunc(value) % table->size]);
	while (temp)
	{
		if (elementKey(temp) == value)
			ifExist = true;
		temp = getNext(temp);
	}
	return ifExist;
}

void riseFreq(string key, List *bucket)
{
	ListElement *temp = getListHead(bucket);
	while (temp)
	{
		if (elementKey(temp) == key)
		{
			riseElFreq(temp);
			break;
		}
		temp = getNext(temp);
	}
}

void addHT(string value, HT *table)
{
	Pair *temp = new Pair;
	temp->key = value;
	temp->freq = 1;
	if (!exist(value, table))
		addToEnd(table->buckets[HFunc(value) % table->size], temp);
	else 
		riseFreq(value, table->buckets[HFunc(value) % table->size]);
}

void printHT(HT *table)
{
	for (int i = 0; i < table->size; i++)
	{
		ListElement *tmp = getListHead(table->buckets[i]);
		while(tmp)
		{
			cout << elementKey(tmp) << " " << elementFreq(tmp) << endl;
			tmp = getNext(tmp);
		}
	}
}

