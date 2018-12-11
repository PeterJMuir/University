#include <stdio.h>
int main() {

  char input;
  char q;
  printf("Please type a character:");
  input = getchar();
  getchar();
  printf("You typed the following character: %c\n",input);

  printf("\nWould you like to type another character? y/n\n");
  q = getchar();
  getchar();
  if(q == 'y')
  {
     printf("Please type a character:\n");
     input = getchar();
     getchar();
     printf("You typed the following character: %c\n",input);
  }

  return 0;
}


