#include <stdio.h>
#include <iostream>
#include <fstream>
#include "map.h"
using namespace std;

int main()
{
	ifstream in("test1.txt");
	if (!in)
    {
        cerr << "File not found" << endl;
        return 1;
    }

	Map *map = createMap(in);
	in.close();

	campaign(map);

	deleteMap(map);
	return 0;
}