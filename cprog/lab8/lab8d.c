#include <stdio.h>

float medianVal(int a[], int);

int main()
{
   int index, n;
   int values[100];
   float median;

   printf("Enter the number of integers to be input (maximum = 100): ");
   scanf("%d",&n);

   for (index = 0; index < n; index++)
   {
      printf("Input no. %d:  ", (index+1));
      scanf("%d", &values[index]);
   }

   median = medianVal(values, n);

   printf("\nMedian value is: %.1f\n", median);

   return 0;
}


float medianVal(int a[], int n)
{
   int i, temp, sorted;
   do
   {
      for (i = 1, sorted = 1; i < n; i++)
      {
         if (a[i-1] > a[i])
         {
            sorted = 0;
            temp = a[i-1];
            a[i-1] = a[i];
            a[i] = temp;
         }
      }
   } while(!sorted);

   float mval;
   if (n % 2 == 0)
   {
      mval = (float)(a[(n/2)-1] + a[n/2])/2;
   }
   else if (n % 2 == 1)
   {
      mval = a[n/2];
   }
   return mval;
}
