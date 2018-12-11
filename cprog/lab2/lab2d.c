
#include <stdio.h>

int main()
{
   char c;
   printf("Please type a character\n");
   scanf("%c",&c);
   if (c >='A' && c <='Z')
   {
      printf("Great: the input is a capital letter.\n");
   }
   else
   {
      printf("The input is not a capital letter.\n");
   }
   return 0;
}
