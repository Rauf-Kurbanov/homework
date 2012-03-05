/*Ввести два числа, перевести в двоичное представление (в каком-либо из кодов) и напечатать, сложить, вывести сумму,
перевести в десятичное, вывести результат в десятичном виде. Все сообщения писать по-русски.*/
#include <iostream>
#include <conio.h>

using namespace std;

int *recode(int a, int len)
{
	int mask = 1;
	int *bin = new int[len];
	for (int i = 0; i < len ; i++)
		bin[len - i - 1] = bool(((mask << i) & a) >> i);
	return bin;
}

int *sumBin(int *bin1, int *bin2, int len)
{
	int *summ = new int[len];
	int memory = 0;
	for (int i = len - 1; i > -1; i--)
	{ 
		summ[i] = (bin1[i] + bin2[i] + memory) % 2;
		memory = (bin1[i] + bin2[i] + memory) / 2;
	}
	return summ;
}

int main()
{
	setlocale(0, "Rus");

	//ввод
	cout << "Введите два числа" << endl; 
	int n1 = 0;
	int n2 = 0;
	cin >> n1 >> n2;

	//перевод в двоичное
	const int length = sizeof(int) * 8;
	int *bin1 = recode(n1, length);
	int *bin2 = recode(n2, length);
	
	cout << "n1 = ";
	for (int i = 0; i < length; i++)
		cout << bin1[i];
	cout << endl;

	cout << "n2 = ";
	for (int i = 0; i < length; i++)
		cout << bin2[i];
	cout << endl;

	//сумма в двоичной
	int *summ = sumBin(bin1, bin2, length);
	cout << "summBin = ";
	for (int i = 0; i < length; i++)
		cout << summ[i];
	cout << endl;

	//перевод в десятичную
	int summDeg = 0;
	int temp = 1;
	for (int i = length - 1; i > -1; i--)
	{
		summDeg += summ[i] * temp;
		temp *= 2;
	}

	cout << "summDeg = " << summDeg << endl;

	delete[] summ;
	delete[] bin1;
	delete[] bin2;
	return 0;
}