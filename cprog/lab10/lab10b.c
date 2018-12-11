#include <stdio.h>
#include <string.h>

int lowerToUpper(char []);

int main(void)
{
   char inputWord[40];

   printf("Type a word in the lower case: ");
   scanf("%s", inputWord);
   if(lowerToUpper(inputWord) == 1){
      printf("The word in the upper case: %s\n", inputWord);
   }
   return 0;
}

int lowerToUpper(char a[])
{
   char *cptr;

   cptr = a;
   while(*cptr != '\0')
   {
      if(*cptr >='a' && *cptr <= 'z')
      {
         *cptr = *cptr + 'A' - 'a';
         cptr++;
      }
      else
      {
         return 0;
      }
   }
   return 1;
}
