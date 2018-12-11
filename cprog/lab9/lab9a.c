#include<stdio.h>
int factorial(int);

int main()
{
   int n;
   printf("Enter a positive integer: ");
   scanf("%d",&n);
   if(n >= 0)
      printf("Factorial of %d = %d\n", n, factorial(n));
      else
         printf("Invalid input\n");
      return 0;
}

int factorial(int N)
{
   if(N < 0)
      return -1; // -1 indicated invalid argument;
   else if(N==0) // Base case
      return 1;
   else          // N > 0, use recursion.
      return N*factorial(N-1);
}
