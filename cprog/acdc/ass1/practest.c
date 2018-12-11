#include<stdio.h>

int main()
{
   int num1,num2,x,y,rmdr;
   printf("Enter 'x,y' (such that x and y are non-negative integers and x > y)");
   printf(" to find GCD(x,y).\n");
   scanf("%d , %d", &num1, &num2);
   if(num1 > 0 && num2 >0 && num1 < 99999999 && num2 < 99999999)
   {
      if( num1 < num2)
      {
         x = num1;
         num1 = num2;
         num2 = x;
      }
      x = num1;
      y = num2;
      while(rmdr > 0)
      {
         rmdr = x % y;
         x = y;
         y = rmdr;
      }
      printf("GCD(%d,%d) is %d\n",num1,num2,x);
   }
   else
   {
      if (num1 == 0 || num2 == 0)
      {
         if(num1 == 0 && num2 > 0)
         {
            printf("GCD(%d,%d) is %d\n",num1,num2,num2);
         }
         if(num1 > 0 && num2 == 0)
         {
            printf("GCD(%d,%d) is %d\n",num1,num2,num1);
         }
         if(num1 == 0 && num2 == 0)
         {
            printf("GCD(0,0) is 0\n");
         }
      }
      else
      {
      printf("Invalid input. Terminating program.\n");
      }
   }
   return(0);
}
