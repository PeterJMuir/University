#include <stdio.h>

void min_max(int x[], int n, int* min, int* max);

int main()
{
   int n, i, min, max;
   printf("Finding the min and max of an array.\n");
   printf("Enter the amount of values in your array: ");
   scanf("%d", &n);
   int a[n];
   if(n <= 0)
   {
      printf("Invalid Input.\n");
      return -1;
   }
   for (i = 0; i < n; i++)
   {
      printf("Enter the value for position %d of your array: ",i+1);
      scanf("%d",&a[i]);
   }
   min_max(a, n, &min, &max);
   printf("The minimum is %d and the maximum is %d.\n", min, max);
   return 0;
}

void min_max(int x[], int n, int* min, int* max)
{
   int p;
   for(p = 0; p < n; p++)
   {
      if(x[p] > *max)
         *max = x[p];
      if(x[p] < *min)
         *min = x[p];
   }
}
