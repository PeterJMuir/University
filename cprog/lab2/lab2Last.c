
#include <stdio.h>

int main()
{
   char c;
   do {
   printf("Please type a character\n");
   c = getchar();
   getchar();
   if (c >='A' && c <='Z')
   {
      printf("Great: the input is a capital letter.\n");
   }
   else
   {
      printf("The input is not a capital letter.\n");
   }
   }
   while (c >= 'a' && c <= 'z');
   return 0;
}
