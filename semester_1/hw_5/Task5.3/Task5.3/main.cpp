/*"Считалочка" -- отряд из 41-го сикария, защищавший галилейскую крепость Массада, не пожелал сдаваться в плен блокировавшим его превосходящим силам римлян.
Сикарии стали в круг и договорились, что каждые два воина будут убивать третьего, пока не погибнут все. Самоубийство — тяжкий грех, но тот, 
кто в конце концов останется последним, должен будет его совершить. Иосиф Флавий, командовавший этим отрядом, якобы быстро рассчитал, 
где нужно стать ему и его другу, чтобы остаться последними, но не для того, чтобы убить друг друга, а чтобы сдать крепость римлянам. 
В нашем случае участвует n воинов и убивают каждого m-го. Требуется определить номер k начальной позиции воина, который должен будет остаться последним. 
Считать с помощью циклического списка.*/

#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	int amount = 0;
	cout << "Enter amount" << endl;
	cin >> amount;
	int kill = 0;
	cout << "Enter killed number" << endl;
	cin >> kill;

	List *army = createList();
	ElementType tmp = 0;
	for (int i = 0; i < amount; i++)
		addToCyclicalList(army, i + 1);

	int counter = 1;
	ListElement *temp = getListHead(army);
	ElementType memory = 0;
	
	while (true)
	{
		if (listCounter(army) == 1)
			break;
		if (counter == kill)
		{
			memory = elementValue(temp);
			temp = getNext(temp);
			deleteFromList(army, memory);
			counter = 1;
		}
		else
		{
			temp = getNext(temp);
			counter++;
		}
	}

	cout << "Last solider position" << endl;
	printList(army);

	deleteList(army);
	return 0;
}