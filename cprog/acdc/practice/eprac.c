#include <string.h>
#include <stdio.h>

void func(int * x, int * y){
   *x = *y;
}


int main() {
   int a = 4;
   int * b = &a;
   func(&a, &b);
   return 0;
}
