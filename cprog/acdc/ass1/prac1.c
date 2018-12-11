#include<stdio.h>
#include<ctype.h>

int main()
{
   char x, y, a;
   printf("Enter 'x,y' (such that x and y are non-negative integers where x > y)");
   printf(" to find the GCD(x,y)\n");
   scanf("%c,%c", &x, &y);
   if( isdigit(x) && isdigit(y))
   {
      if(x < y)
      {
         a = x;
         x = y;
         y = a;
      }
      printf("x = %c, y = %c\n",x,y);
   }
   else
   {
      printf("Invalid input. Terminating program.\n");
   }
   return(0);
}
