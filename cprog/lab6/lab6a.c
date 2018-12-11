#include <stdio.h>
int main()
{
   // Int_Max = 2147483647. See /usr/include/limits.h
   
   unsigned int a =  2147483647U;
   
   a = a + 0;

   printf("Various format for integer printing\n");
   printf("-------------------------------------\n");
   printf("%d\n", a);
   printf("%i\n", a); //i same as d in printf()
   printf("%u\n", a);
   printf("%x\n", a);
   printf("%X\n", a);
   printf("%o\n", a); //%o (lower case), not %O
   return 0;
}
