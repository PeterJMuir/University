//Get an integer from console
//Output Even or Odd on the terminal

#include <stdio.h>

int main()
{
   int number;

   printf("Enter an integer: ");
   scanf("%d", &number);

   if (number % 2 == 0)
   {
      printf("The number is even, and is ");
      
      if(number % 5 == 0)
         printf("divisible by 5.\n");
      else
         printf("not divisible by 5.\n");   
   }
   else
   {
      printf("The number is odd, and is ");

      if(number % 5 == 0)
         printf("divisible by 5.\n");
      else
         printf("not divisible by 5.\n");
   }

   return 0;
}
