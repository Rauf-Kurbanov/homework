#pragma once
#include <string>
#include "list.h"

using namespace std;

struct HT;

HT *createHT(int size); //������� ���-�������

void deleteHT(HT *table); //������� ���-�������

int HFunc(ElementType value); //���-�������

void addHT(string value, HT *table); //�������� ������� � �������

bool exist(string value, HT *table); //���������, ����������� �� ���� �������

void printHT(HT *table); //����������� �������

void riseFreq(string key, List *bucket); //��������� ������� �������� � �������
