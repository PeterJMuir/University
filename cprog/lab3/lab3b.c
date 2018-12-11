//Get an integer from console
//Output Even or Odd on the terminal

#include <stdio.h>

int main()
{
   int number;

   printf("Enter an integer: ");
   scanf("%d", &number);

   if (number % 2)     /* remainder of evens is 0 so when you type an even integer,
                          the condition is false (0). Therefore it goes to 'else',
                          determining even numbers to be 'odd'.                     */
      printf("Even\n");
   else
      printf("Odd\n");

   return 0;
}
