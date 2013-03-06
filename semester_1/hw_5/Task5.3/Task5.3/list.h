#pragma once

typedef int ElementType;

struct List;

struct ListElement;

List *createList();  //создать новый список

void addToEnd(List *list, ElementType value); //добавить значение в конец списка

void addToCyclicalList(List *list, ElementType value); //добавить значение в конец циклического списка
 
void deleteFromList(List *list, ElementType value); //удалить элемент из списка 

void deleteList(List *list); //удалить список

void printList(List *list); //распечатать список

ListElement *getListHead(List *list); //присвоить элементу начало списка

ElementType elementValue(ListElement *element); //получить значение элемента

ListElement* getNext(ListElement *element); //перейти к следующему элементу списка

int listCounter(List *list); //получить значение счётчика списка

void moveHead(List *list, ListElement *element); //переводит голову спика на передаваемый элемент
