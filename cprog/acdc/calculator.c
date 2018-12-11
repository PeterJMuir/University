
#include <stdio.h>

/* displays 4 main operator results */

int main()
{
   int x,y,add,subtract,multiply;
   float divide;
   printf("Enter two variables\n");
   scanf("%d%d", &x, &y);

   add = x + y;
   subtract = x - y;
   multiply = x * y;
   divide = x / (float)y;

   printf("\n%d + %d =  %d\n",x,y,add);
   printf("%d - %d = %d\n",x,y,subtract);
   printf("%d multiplied by %d = %d\n",x,y,multiply);
   printf("%d divided by %d = %f\n",x,y,divide);

   return 0;
}
