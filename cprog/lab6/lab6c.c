/* Counts the number of upper case letters */

#include <stdio.h>

int main(void)
{
  char ch;
  int count = 0;

  printf("\nEnter a message: ");
  ch = getchar();
  while (ch != '\n') {
    if( ch == ' ') count++;
    ch = getchar();
  }
  printf("Your message has %d space(s).\n\n", count);

  return 0;
}
