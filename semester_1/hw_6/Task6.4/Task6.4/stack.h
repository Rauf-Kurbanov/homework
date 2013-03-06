#pragma once

typedef char StackElementType;

struct StackElement;

struct Stack;

void push(StackElementType value, Stack *stack); //добавить элемент в стек

void pop(Stack *stack); //удалить элемент из стека

StackElementType stackTop(Stack *stack);

Stack *createStack(); //создать стек

void deleteStack(Stack *stack); //удалить стек

StackElement *createStackElement(); //создать элемент стека

