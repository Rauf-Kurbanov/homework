#pragma once

typedef char StackElementType;

struct StackElement;

struct Stack;

void push(StackElementType value, Stack *stack); //�������� ������� � ����

void pop(Stack *stack); //������� ������� �� �����

StackElementType stackTop(Stack *stack);

Stack *createStack(); //������� ����

void deleteStack(Stack *stack); //������� ����

StackElement *createStackElement(); //������� ������� �����

