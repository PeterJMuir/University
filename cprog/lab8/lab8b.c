#include <stdio.h>

int binary_decimal(int n);
int check(int n);

int main()
{
   int n;

   printf("Enter a binary number: ");
   scanf("%d", &n);
   if (check(n) == -1) return -1;
   else
   {
      printf("%d in binary = %d in decimal\n", n, binary_decimal(n));
      return 0;
   }
}


int check(int n)
{
   int k = n, rem;
   while(k != 0)
   {
      rem = k%10;
      k/=10;
      if (rem >1) return -1;
   }
   return 0;
}

int binary_decimal(int n)
{
  int decimal =0, i=1, rem;
  while (n!=0)
  {
     rem = n%10;
     n/=10;
     decimal += rem*i;
     i*=2;
  }
  return decimal;
}
