


#include<stdio.h>

int main()
{
   int x, y, c;
   x = 10;
   y = 3;
   float h;
   h = x / y;
   c = x * y;
   printf("c=%d\n",c);
   printf("h=%f\n",h);
   h = x / (float)y;
   printf("h= %f\n",h);
   return 0;
}
