#include <stdio.h>

int decimal_binary(int n);

int main()
{
   int n;

   printf("Enter a decimal number: ");
   scanf("%d",&n);
   printf("%d in decimal = %d in binary\n", n, decimal_binary(n));
   return 0;
}


int decimal_binary(int n)  /* Function to convert decimal to binary.*/
{
   int rem, i=1, binary=0;
   while (n!=0)
   {
      rem=n%2;
      n/=2;
      binary+=rem*i;
      i*=10;
   }
   return binary;
}
