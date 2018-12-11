#include <stdio.h>
#include <unistd.h>

int main()
{
   int x;
   for (x=0; x<10; x++) {
   printf("%d      ",x);
   printf("Hello World!\n");
   usleep(100000);
   }
   for (x=10; x<20; x++) {
   printf("%d     ",x);
   printf("Hello World!\n");
   usleep(100000);
   }
   for (x=20; x<40; x++) {   
   printf("%d     ",x);
   printf("Woof!\n");
   usleep(100000);
   }
   for (x=40; x<60; x++) {   
   printf("%d     ",x);
   printf("Meow!\n");
   usleep(100000);
   }
   for (x=60; x<80; x++) {   
   printf("%d     ",x);
   printf("Moo!\n");
   usleep(100000);
   }
   for (x=80; x<100; x++) {   
   printf("%d     ",x);
   printf("Yay!\n");
   usleep(100000);
   }
   for (x=100; x<101; x++) {
   printf("%d    ",x);
   printf("Hello World!\n");
   usleep(100000);
   }

   return 0;
}
