#pragma once
#include <fstream>

struct Map;

Map *createMap(std::ifstream &in); //build a map of the input file

void deleteMap(Map *map); //delete map from memory

void campaign(Map *map); //start capitals expansion