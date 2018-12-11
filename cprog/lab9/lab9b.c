#include<stdio.h>
int sum(int);

int main()
{
   int n;
   printf("Enter a positive integer: ");
   scanf("%d", &n);
   int x = sum(n);
   if(x != -1)
   {
   printf("The sum of %d is: %d\n", n, x);
   return 0;
   }
   else
   {
      printf("Invalid input.\n");
      return 0;
   }
}

int sum(int N)
{
   if(N <= 0)
      return -1;
   if(N == 1)
      return 1;
   else
      return N+sum(N-1);
}
