#include <stdio.h>

#define NSTUDENTS 5
#define NSUBJECTS 4

int main()
{
	float marks[NSTUDENTS][NSUBJECTS+1];
	int i,j,sum;
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
   
   printf("\n\n");
   for(i=0; i < NSTUDENTS; i++)
   {
		for(j=0; j < (NSUBJECTS+1); j++) printf(" %8.2f", marks[i][j]);
      printf("\n");
   }

   return 0;   
}
