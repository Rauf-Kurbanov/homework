#pragma once

struct List;

struct ListElement;

List *createList();  //создать новый список

ListElement *createListElement(); //создать новый элемент списка

void addToEnd (List *list, int value); //добавить значение в конец списка

void addToSortedList (List *list,int value); //добавить значение в соритрованный список

void deleteFromList(List *list, int value); //удалить знаение из списка 

void deleteList(List *list); //удалить список

void printList(List *list); //распечатать список
