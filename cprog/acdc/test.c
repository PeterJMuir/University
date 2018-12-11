#include <stdio.h>
#include <math.h>

int main()
{
   double x;
   printf("Enter a number to be square rooted.\n");
   scanf("%lf", &x);
   printf("Square root of %lf is %lf \n", x,sqrt( x ));

   return(0);
}
