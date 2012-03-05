#pragma once

struct Pair 
{
	char name[15];
	unsigned long long number;
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

void printList(List *list); //распечатать список

void clearList(List *list); //очистить список

unsigned long long getNum(ListElement *element); //возвращает номер телефона

char* getName(ListElement *element); //возвращает имя