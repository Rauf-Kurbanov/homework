#pragma once

typedef char ElementType;

struct StackElement;

struct Stack;

void push(ElementType value, Stack *stack); //добавить элемент в стек

void pop(Stack *stack); //удалить элемент из стека

ElementType stackTop(Stack *stack);

Stack *createStack(); //создать стек

void deleteStack(Stack *stack); //удалить стек

StackElement *createStackElement();

