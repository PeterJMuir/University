#include <stdio.h>
#include <string.h>

int monthname( int n, char* b);


int main(void)
{
   int m;
   char a[10];

   printf("Type the numeric code (1-12) of the month: ");
   scanf("%d", &m);
   if(monthname(m, a)==1);
   {
   printf("The name of the month is : %s\n", a);
   }
      return 0;
}

int monthname( int n, char* b)
{
   char* monthNames[12];
   monthNames[0] = "January";
   monthNames[1] = "February";
   monthNames[2] = "March";
   monthNames[3] = "April";
   monthNames[4] = "May";
   monthNames[5] = "June";
   monthNames[6] = "July";
   monthNames[7] = "August";
   monthNames[8] = "September";
   monthNames[9] = "October";
   monthNames[10] = "November";
   monthNames[11] = "December";

   if( n < 1 || n > 12 )
   {
      printf("Invalid input.\n");
      return -1;
   }
      else
      {
         n = n-1; //Adjustment for c index
         //b = monthNames[n];i
         int i = 0;
         for(i=0;monthNames[n][i]!='\0';i++)
         {
            *b=monthNames[n][i];
            b++;
         }
         *b='\0';

         return 1;
      }
}
