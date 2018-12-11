#include<stdio.h>

int createres(FILE *, FILE *);
int viewraw(FILE *);
int viewout(FILE *);

int main(void)
{
   FILE *fpraw;
   FILE *fpres;
   char examine;
   char choice;
   fpres = fopen("results.txt", "w+");
   fpraw = fopen("rawmarks.txt", "r");
   createres(fpraw,fpres);
   printf("Calculations complete. Would you like to examine the results?(y/n)  ");
   scanf(" %c", &examine);
   while(examine == 'y')
   {
   printf("Would you like to:\nView a student's raw marks? (a)\nView students' final marks? (f)\n or quit (q) ?  ");
   scanf(" %c", &choice);
   if((choice == 'a'))
   {
      viewraw(fpraw);
   }
   if(choice == 'f')
   {
   //   viewout(fpres);
   break;
   }
   printf("Would you like to examine more results? (y/n)");
   scanf(" %c", &examine);
   }
      printf("Program terminating...");
      fclose(fpraw);
      fclose(fpres);
      printf("\n");
      return 0;
   }
 /*  int stnum;
   int exam;
   int ass1;
   int ass2;
   int lab;
   int quiz;
   float final;
   FILE *fpres;
   FILE *fpraw;
   fpres = fopen("results.txt", "w+"); //creates the results file
   fprintf(fpres,"%s %16s\n","Student Number","Final Mark(%)");
   fpraw = fopen("rawmarks.txt", "r");
   while(stnum != 30)
   {
   fscanf(fpraw,"%d %d %d %d %d %d",&stnum,&exam,&ass1,&ass2,&lab,&quiz);
   final =(((float)exam/180)*50) + (((float)ass1/100)*10) + (((float)ass2/100)*20) + (((float)lab/10)*10) + (((float)quiz/10)*10);
   fprintf(fpres, "%5d %19.2f\n", stnum, final);
  // printf("%2d %3d %3d %3d %2d %2d %6.2f\n",stnum,exam,ass1,ass2,lab,quiz,final);
   } 
   return (0);
} */

int createres(FILE *source, FILE *out)
{
   int stnum;
   int exam;
   int ass1;
   int ass2;
   int lab;
   int quiz;
   float final;
 //  FILE *fpres;
 //  FILE *fpraw;
 //  fpres = fopen("results.txt", "w+"); //creates the results file
   fprintf(out,"%s %16s\n","Student Number","Final Mark(%)");
 //  fpraw = fopen("rawmarks.txt", "r");
   while(stnum != 30)
   {
   fscanf(source,"%d %d %d %d %d %d",&stnum,&exam,&ass1,&ass2,&lab,&quiz);
   final =(((float)exam/180)*50) + (((float)ass1/100)*10) + (((float)ass2/100)*20) + (((float)lab/10)*10) + (((float)quiz/10)*10);
   fprintf(out, "%5d %19.2f\n", stnum, final);
  // printf("%2d %3d %3d %3d %2d %2d %6.2f\n",stnum,exam,ass1,ass2,lab,quiz,final);
   }
   return 0;
}

int viewraw(FILE *ffpraw)
{
   int num;
   int stnum;
   int exam;
   int ass1;
   int ass2;
   int lab;
   int quiz;
   float emark;
   float lmark;
   float qmark;
   char marks;
   char choice;
   printf("For which student number do you wish to see the marks (1-30))?\n");
   scanf(" %d",&num);
   printf("working...");
   do{
   do{
      fscanf(ffpraw,"%d %d %d %d %d %d",&stnum,&exam,&ass1,&ass2,&lab,&quiz);
   }while(stnum !=num);
   emark = (((float)exam/180)*100);
   lmark = ((float)lab*10);
   qmark = ((float)quiz*10);
   printf("What marks do you wish to see (a = all, e = exam, b = assignment 1, c = assignment 2, l = lab, q = quiz)?  ");
   scanf(" %c",&marks);
   switch(marks)
   {
      case 'a':
         printf("Exam: %10.2f%%\nAssignment 1: %2d%%\nAssignment 2: %2d%%\nLabs: %10.2f%%\nQuiz: %10.2f%%\n",emark,ass1,ass2,lmark,qmark);
         break;
      case 'e':
         printf("Exam: %.2f%%\n",emark);
         break;
      case 'b':
         printf("Assignment 1: %2d%%\n",ass1);
         break;
      case 'c':
         printf("Assignment 2: %2d%%\n",ass2);
         break;
      case 'l':
         printf("Labs: %.2f%%\n",lmark);
         break;
      case 'q':
         printf("Quiz: %.2f%%\n",qmark);
         break;
   }
   printf("Would you like to see another mark (y/n)?  ");
   scanf(" %c", &choice);
   }while(choice == 'y');
   return 0;
}

int viewout(FILE *ffpout)
{
   int num;
   int stnum;
   float final;
   char choice;
   char ch;
   char junk[20],junk1[20],junk2[20],junk3[20];
   rewind(ffpout);
   fscanf(ffpout,"%s%s%s%s",junk,junk1,junk2,junk3);
   printf("Would you like to view a student's final mark (f) or the students (and their marks) that achieved a high mark (h)?  ");
   scanf(" %c", &choice);
   if(choice == 'f')
   {
      do{
   printf("For which student number do you wish to see the marks (1-30)?   ");
   scanf(" %d", &num);
   do{
      fscanf(ffpout,"%d %f",&stnum,&final);
   }while(stnum != num);
   printf("Student number %d obtained a final score of %f%%.\n",num,final);
   printf("Would you like to find another student's final mark (y/n)?  ");
   scanf(" %c",&ch);
   rewind(ffpout);
   fscanf(ffpout,"%s%s%s%s",junk,junk1,junk2,junk3);
      }while(ch == 'y');
   }
}
