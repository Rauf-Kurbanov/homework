#pragma once

typedef int ElementType;

struct Node;

typedef Node Tree;

Node *createNode(ElementType value); //создать узел

Tree *createTree(); //создать дерево

void addToTree(Tree *&tree, ElementType value); //добавить узел в дерево

void deleteTree(Tree *&tree); //удалить дерево

void deleteNode(Tree *&tree, ElementType value); //удалить узел из дерева

bool exists(Tree *tree, ElementType value); //проверяет, принадлежит ли узел дереву

void incPrintTree(Tree *tree); //печать списка по возрастанию

void decPrintTree(Tree *tree); //печать списка по убыванию
