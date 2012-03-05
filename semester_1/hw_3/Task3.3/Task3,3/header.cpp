#include "header.h"

void swap(int *a, int i, int j)
{
	int k = a[i];
	a[i] = a[j];
	a[j] = k;
}

void pastSort(int * mass, int begin, int end)
{
	for (; begin <= end; begin++)
		for (int j = begin; j > 0; j--)
			if (mass[j - 1] > mass[j])
				swap(mass, j - 1, j);
}

void qSort(int *mass, int begin, int end) 
 {
	 int i = begin;
	 int j = end;
	 int x = mass[(begin + (end - begin) / 2)];
     
	 while (i <= j)
	 {
		 while (mass[i] < x)
			 ++i;
		 while (x < mass[j])
			 --j;
		 if (i <= j)
		 {
			 swap(mass, i, j);
			 ++i;
			 --j;
		 }
	 }

	 if ((j - begin) < 10)
		 pastSort(mass, begin, j); 
	 else
		 if (begin < j)
			 qSort(mass, begin, j);

	 if ((end - i) < 10)
		 pastSort(mass, i, end);
	 else
		 if (i < end)
			 qSort(mass, i, end);
 }
