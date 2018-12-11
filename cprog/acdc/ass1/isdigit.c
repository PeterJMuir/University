#include<stdio.h>
#include<ctype.h>

int main()
{
   char x;
   scanf("%c", &x);
   if( isdigit(x) )
   {
      printf("it worked! %c\n",x);
   }
   else{
      printf("nope!%c\n",x);
   }
   return(0);
}
