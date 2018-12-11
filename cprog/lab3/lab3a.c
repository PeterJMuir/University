//Get an integer from console
//Output Even or Odd on the terminal

#include <stdio.h>

int main()
{
   int number;

   printf("Enter an integer: ");
   scanf("%d", &number);

   if (number % 2 == 0)
      printf("Even\n");
   else
      printf("Odd\n");

   return 0;
}
