#include <stdio.h>

int main() {
  int x, y, sum;

  printf("Enter two integers to be added\n");
  scanf("%d %d",&x,&y);
  sum = x + y;
  printf("sum of x and y equals %d\n", sum);

  return 0;
}
