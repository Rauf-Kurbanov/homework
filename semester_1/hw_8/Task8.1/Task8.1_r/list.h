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

List *createList(); //создаёт список

void addToEnd(List *list, ElementType element); //добавляет элемент в конец списка

void deleteList(List *list); //удаляет список

int listCounter(List *list); //возвращает список элементов списка

ListElement *getListHead(List *list); //присвоить элементу начало списка

ListElement *createListElement(); //создать элемент списка

ElementType elementValue(ListElement *element); //получить значение элемента

ListElement* getNext(ListElement *element); //перейти к следующему элементу списка

void deleteFromList(List *list, ElementType value); //удалить элемент из списка 

string elementKey(ListElement *element); //получить ключ элемента

int elementFreq(ListElement *element); //получить частоту элемента

void riseElFreq(ListElement *element); //учеличить графу частота элемента списка