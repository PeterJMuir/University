#include <stdio.h>

int maxVal(int a[], int);

int main()
{
   int index, n;
   int values[100];
   int maxInputValue;

   printf("Enter the number of integers to be input (maximum = 100): ");
   scanf("%d", &n);
   
   for (index = 0; index < n; index++)
   {
	   printf("Input No. %d:  ", index+1);
	   scanf("%d", &values[index]);
   }
   
   maxInputValue = maxVal(values, n);
   
   printf("\nMaximum value inputted: %d\n", maxInputValue);
   
   return 0;
}


int maxVal(int a[], int n)
{
    int i, maxSoFar;
	
	maxSoFar= a[0];
	
    for (i = 0; i < n; i++)
    {
        if(a[i] > maxSoFar) maxSoFar = a[i];
    }
    return maxSoFar;
}
