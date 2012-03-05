#pragma once
#include <string>
#include "list.h"

using namespace std;

struct HT;

HT *createHT(int size); //создать хэш-таблицу

void deleteHT(HT *table); //удалить хэш-таблицу

int HFunc(ElementType value); //хэш-функция

void addHT(string value, HT *table); //добавить элемент в таблицу

bool exist(string value, HT *table); //проверить, принадлежит ли ключ таблице

void printHT(HT *table); //распечатать таблицу

void riseFreq(string key, List *bucket); //увеличить частоту элемента в таблице
