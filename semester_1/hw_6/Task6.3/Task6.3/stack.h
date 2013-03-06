#pragma once

typedef char ElementType;

struct StackElement;

struct Stack;

void push(ElementType value, Stack *stack); //�������� ������� � ����

void pop(Stack *stack); //������� ������� �� �����

ElementType stackTop(Stack *stack);

Stack *createStack(); //������� ����

void deleteStack(Stack *stack); //������� ����

StackElement *createStackElement();

