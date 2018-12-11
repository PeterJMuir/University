#include <stdio.h>

#define NSTUDENTS 5
#define NSUBJECTS 4

int main()
{
   float temp;
	float marks[NSTUDENTS][NSUBJECTS+1];
	int i,j,sum, sorted;
   int inputMark;
   float average;
	
	for(i=0; i < NSTUDENTS; i++)
	{
		printf("type the marks (%d integers between 1 and 100) obtained by Student %d: ", NSUBJECTS, i);
		for(j=0; j < NSUBJECTS; j++){
			scanf("%d", &inputMark);
         marks[i][j] = inputMark;
      }
	}
	
	for (i=0; i < NSTUDENTS; i++)
   {
      sum = 0;
      for (j=0; j < NSUBJECTS; j++)
      {
         sum += marks[i][j];
         average = (float)sum/NSUBJECTS;
      }
      marks[i][NSUBJECTS] = average;
      //printf("average = %d",average);
   }

   /* Bubble sort: */

   do
   {
      for (i = 1, sorted = 1; i < NSTUDENTS; i++)
      {
         if (marks[i-1][NSUBJECTS] < marks[i][NSUBJECTS])
         {
            sorted = 0;
            for(j = 0; j <= NSUBJECTS; j++)
            {
               temp = marks[i-1][j];
               marks[i-1][j] = marks[i][j];
               marks[i][j] = temp;
            }
         }
      }
   } while (!sorted);
   
   printf("\n\n");
   for(i=0; i < NSTUDENTS; i++)
   {
		for(j=0; j < (NSUBJECTS+1); j++) printf(" %8.2f", marks[i][j]);
      printf("\n");
   }

   return 0;   
}
