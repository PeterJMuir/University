#include<stdio.h>

int main()
{
   int num1, num2, x, y, rmdr;
   printf("Enter 'x,y' (such that x and y are non-negative integers where x > y)");
   printf(" to find the GCD(x,y)\n");
   scanf("%d , %d", &num1, &num2);
   if( num1 >= 0 && num2 >= 0)
   {
      if(num1 < num2)
      {
         rmdr = num1;
         num1 = num2;
         num2 = rmdr;
      }
      x = num1;
      y = num2;
      while( rmdr > 0)
      {
         rmdr = x % y;
         x = y;
         y = rmdr;
      }
      printf("The GCD(%d,%d) is %d\n",num1,num2,x);
   }
   else
   {
      printf("Invalid input. Terminating program.\n");
   }
   return(0);
}
