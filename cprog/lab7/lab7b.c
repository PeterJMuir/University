#include <stdio.h>

#define NSTUDENTS 5
#define NSUBJECTS 4

int main()
{
	float marks[NSTUDENTS][NSUBJECTS];
	int i,j;
   int inputMark;
	
	for(i=0; i < NSTUDENTS; i++)
	{
		printf("type the marks (%d integers between 1 and 100) obtained by Student %d: ", NSUBJECTS, i);
		for(j=0; j < NSUBJECTS; j++){
			scanf("%d", &inputMark);
         marks[i][j] = inputMark;
      }
	}
	
	// Insert your code here

   printf("\n\n");
   for(i=0; i < NSTUDENTS; i++)
   {
		for(j=0; j < NSUBJECTS; j++) printf(" %8.2f", marks[i][j]);
      printf("\n");
   }

   return 0;   
}
