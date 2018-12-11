#include <stdio.h>

int main(void)
{
   int i1 = 67;
   long l1 = 34;
   long l2 = 123456789L;
   float f1 = 3.1416;
   double d1 = 3.1416;

   printf("sizeof(i1) has the value %d\n", sizeof(i1));
   printf("sizeof(int) has the value %d\n", sizeof(int));
   printf("sizeof(314) has the value %d\n", sizeof(314));
   printf("sizeof(l1) has the value %d\n", sizeof(l1));
   printf("sizeof(l2) has the value %d\n", sizeof(l2));
   printf("sizeof(f1) has the value %d\n", sizeof(f1));
   printf("sizeof(d1) has the value %d\n", sizeof(d1));
   printf("sizeof(i1+314) has the value %d\n", sizeof(i1+314));
   printf("sizeof i1 has the value %d\n", sizeof i1);
   printf("sizeof 314  has the value %d\n", sizeof 314);
   printf("sizeof i1+314  has the value %d\n", sizeof i1+314);
   // The following statement will not complle:
   // printf("sizeof int has the value %d\n", sizeof int);
   return (0);
}
