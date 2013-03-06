#pragma once
#include "binTree.h"

typedef int ElementType;

Node *createSet(); //создать множество

void deleteSet(Node *&set); //удалить множество

void addToSet(Node *&set, ElementType value); //добавить значение в множество

void deleteFromSet(Node *&set, ElementType value); //удалить значение из множества

bool checkValue(Node *set, ElementType value); //проверить, принадлежит ли значение множеству

void incPrint(Node *set); //печать множества в порядке возрастания

void decPrint(Node *set); //печать множества в порядке убывания