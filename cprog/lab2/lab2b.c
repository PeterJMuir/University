#include <stdio.h>
int main() {

  char input;
  char q;
  do {
  printf("Please type a character:");
  input = getchar();
  getchar();
  printf("You typed the following character: %c\n",input);
  printf("\nWould you like to type another character? y/n\n");
  q = getchar();
  getchar();
  }
  while (q == 'y');

  return 0;
}


