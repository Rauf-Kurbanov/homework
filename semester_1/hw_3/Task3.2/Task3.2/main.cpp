/*������ ������ � ����� �� ����������� ����������: �������� � ���������� 2 �����, n � k (1 <= n <= 5000, 1 <= k <=300000), ������������� ������ ��
n ����� �� 0 �� 10^9, ������������� k ����� ����� �� 0 �� 10^9, ��� ������� �� ��� ���������, ���������� �� ��� � �������. ������� ������� �� ����������
�� ������������ �� ��������� �����������,��� ��� ����� ���� ��������� �������� � ��������� ���������� O(n log n  + k log n), ��� ������*/

#include <iostream>
#include <stdlib.h>
#include "head.h"

using namespace std;

int main()
{
	int length1 = 0;
	int length2 = 0;

	cout << "Enter n, 1 <= n <= 5000" << endl;
	cin >> length1;
	cout << "Enter k, 1 <= k <=300000" << endl;
	cin >> length2;

	int *mass1 = new int[length1];

	for (int i = 0; i < length1; i++)
		mass1[i] = rand() % (1000000001);

	int *mass2 = new int[length2];

	for (int i = 0; i < length2; i++)
		mass2[i] = rand() % (1000000001); 

	bool *res = new bool[length2];

	for (int i = 0; i < length2; i++)
		res[i] = false;

	qSort(mass1, 0, length1 - 1);

	for (int ind = 0; ind < length2; ind++)  
	{
		int begin = 0;
		int end = length1 - 1;

		while (begin < end)
		{
			int mid = (end + begin) / 2;
			if (mass2[ind] == mass1[mid])
			{
				res[ind] = true;
				break;
			}
			if (mass2[ind] > mass1[mid])
				begin = mid + 1;
			else
				end = mid;
		}
	}

	cout << "The array contains:" << endl;

	for (int i = 0; i < length2; i++)
		if (res[i] > 0)
			cout << mass2[i] << " ";
	cout << endl;

	delete[] res;
	delete[] mass1;
	delete[] mass2;
	return 0;
}