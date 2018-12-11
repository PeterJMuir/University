#include <stdio.h>

void decompose(float, int*, float*);

int main(void)
{
   float number, d;
   int i;

   printf("Type a real number: ");
   scanf("%f", &number);
   decompose(number, &i, &d);
   printf("Integer part: %d\n", i);
   printf("Fraction part: %f\n", d);
   return 0;
}

void decompose(float x, int* int_part, float* frac_part)
{
   *int_part = (int) x;
   *frac_part = x - *int_part;
}
