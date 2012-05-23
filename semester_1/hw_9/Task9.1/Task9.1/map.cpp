#include "map.h"
#include <fstream>
#include <iostream>

struct Map
{
	int townsAmt; //towns amount
	int capAmt; //capitals
	int **ways; //lengths of roads between towns
	int **shortWay; //lengths of shortest ways to towns
	bool *ifCapital; //shows if the town capital
	bool *ifCaptured; //shows if the town captured
};

void skipStr(std::ifstream &in) //skips string in input file
{
	char temp = 0;
	in >> temp;
	while (temp != ':') 
		in >> temp;
};

Map *createMap(std::ifstream &in)
{
	Map *newMap = new Map;

	skipStr(in);
	in >> newMap->townsAmt;

	skipStr(in);
	in >> newMap->capAmt;

	skipStr(in);
	newMap->ifCapital = new bool[newMap->townsAmt + 1]; //newMap declaration
	for (int i = 0; i < newMap->townsAmt + 1; i++)
		newMap->ifCapital[i] = false; 

	int capital = 0;
	for (int i = 0; i < newMap->capAmt; i++) //newMap initialization
	{
		in >> capital;
		newMap->ifCapital[capital] = true;
	}

	skipStr(in);
	newMap->ways = new int*[newMap->townsAmt + 1]; //ways declaration
	for (int i = 0; i < newMap->townsAmt + 1; i++) 
		newMap->ways[i] = new int[newMap->townsAmt + 1];

	for (int i = 0; i < newMap->townsAmt + 1; i++) //ways initialization
		for (int j = 0; j < newMap->townsAmt + 1; j++)
			in >> newMap->ways[i][j];

	newMap->ifCaptured = new bool[newMap->townsAmt + 1];  //ifCaptured declaration

	for (int i = 1; i < newMap->townsAmt + 1; i++) //ifCaptured initialization
		if (newMap->ifCapital[i])
			newMap->ifCaptured[i] = true;
		else
			newMap->ifCaptured[i] = false;

	newMap->shortWay = new int*[newMap->townsAmt + 1]; //shortWay declaration
	for (int i = 0; i < newMap->townsAmt + 1; i++) 
		newMap->shortWay[i] = new int[newMap->townsAmt + 1];

	for (int i = 0; i < newMap->townsAmt + 1; i++) //shortWay initialization
		for (int j = 0; j < newMap->townsAmt + 1; j++)
			if (i == j)
				newMap->shortWay[i][j] = 0;
			else
				newMap->shortWay[i][j] = INT_MAX;
	////////////////////////////////////////////////////

	/*for (int i = 1; i < newMap->townsAmt + 1; i++)
	{
		for (int j = 1; j < newMap->townsAmt + 1; j++)
			std::cout << newMap->ways[i][j] << ' ';
		std::cout << std::endl;
	}

	std::cout << std::endl;

	for (int i = 1; i < newMap->townsAmt + 1; i++)
	{
		for (int j = 1; j < newMap->townsAmt + 1; j++)
			std::cout << newMap->ifCaptured[i][j] << ' '; 
		std::cout << std::endl;
	}*/

	return newMap;
}

void deleteMap(Map *map)
{
	for (int i = 0; i < map->townsAmt + 1; i++)
		delete[] map->ways[i];
	delete[] map->ways;

	for (int i = 0; i < map->townsAmt + 1; i++)
		delete[] map->shortWay[i];
	delete[] map->shortWay;

	delete[] map->ifCapital;

	delete[] map->ifCaptured;
}

void improveShortWay(Map *map, int cap, int currCond, int currLength) 
{
	for (int j = 1; j < map->townsAmt + 1; j++) 
		if (map->ways[currCond][j] && currLength + map->ways[currCond][j] < map->shortWay[cap][j])
			map->shortWay[cap][j] = currLength + map->ways[currCond][j];
	map->ifCaptured[currCond] = true;
}

int selectTarget(Map *map, int cap, int currCond)
{
	int min = INT_MAX;
	int attack = 0;
	for (int j = 1; j < map->townsAmt + 1; j++)
		if (map->ways[currCond][j] && map->shortWay[cap][j] < min && !map->ifCaptured[j]) //choose next town to capture
		{
			min = map->shortWay[cap][j];
			attack = j;
		}
	return attack;
}

void campaign(Map *map)
{
	int *currCond = new int[map->townsAmt + 1]; //keeps current condition for each capital
	for (int i = 0; i < map->townsAmt + 1; i++)
		currCond[i] = i;

	int *currLength = new int[map->townsAmt + 1]; //keeps current way length for each capital
	for (int i = 0; i < map->townsAmt + 1; i++)
		currLength[i] = 0;

	for (;;)
	{
		int flag = 0;

		for (int i = 1; i < map->townsAmt + 1; i++)
		{
			if (!map->ifCapital[i])
				continue;
			
			int attack = selectTarget(map, i, currCond[i]); //choose next town to capture
			if (attack) //capture town
			{
				currCond[i] = attack;
				for (int k = 0; k < i; k++) //cout captured towns
					std::cout << ' ';
				std::cout << currCond[i];
			}
			else
				if (currCond[i] != i)
					flag++;
				else
				{
					for (int k = 0; k < i - 1; k++) //cout capital 
						std::cout << ' ';
					std::cout << '[' << currCond[i] << ']';
				}

			improveShortWay(map, i, currCond[i], currLength[i]); //correcting shortest way to town
		}
		std::cout << std::endl;

		if (flag == map->capAmt) //if there is no free towns return function
			return;
	}
}


