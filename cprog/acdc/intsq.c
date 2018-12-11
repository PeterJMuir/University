
#include<math.h>
#include<stdio.h>

int main()
{
   float x;
   printf("Enter number to be squared/square rooted\n");
   scanf("%f\n",&x);
   double sqrt(double x);

   printf("The sq of %f = %f\n",x,pow(x,2));
   printf("The Square root of %f = %f",x, sqrt(x));

   return 0;
}
