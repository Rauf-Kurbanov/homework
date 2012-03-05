//qsort

#include <iostream>
#include <stdlib.h>

using namespace std;

void swap(int *a, int i, int j)
	{
		int k = a[i];
	    a[i] = a[j];
		a[j] = k;
	}

 void qSort(int *mass, int begin, int end) 
	 {
            int i = begin;
            int j = end;
            int x = mass[(begin + (end - begin) / 2)];
            
              while (mass[i] < x)
                ++i;
              while (x < mass[j])
                --j;
              if (i <= j) 
			  {
                int t = mass[i];
                mass[i] = mass[j];
                mass[j] = t;
                ++i;
                --j;
              }
            
            if (begin < j)
              qSort(mass, begin, j);
            if (i < end)
              qSort(mass, i, end);
          }

int main()
{
	
	srand(1);
	int length = 0;

	cout << "Enter length" << endl;
	cin >> length;

	int *mass = new int[length];

	for (int i = 0; i < length; i++)
	{
		mass[i] = rand () % (101);
		cout << mass[i] << " ";
	}

	cout << endl;

	qSort(mass, 0, length - 1);

	for (int i = 0; i < length; i++)
		cout << mass[i] << " ";

	cout << endl;

	delete[] mass;

	 return 0;
}