/* Example: bubble sort values in array */

/* The bubble sort works by comparing values in adjacent
array positions. If the value in the "lower" position is 
greater than that in the "higher" position, the two are 
swapped. Thus the largest value "bubbles up" to the "top" 
of the array. When there are no more values to be swapped, 
sorting is complete. */

#include <stdio.h>
#include <math.h>
#define VALS 25 /* The number of values to be sorted */

int main()
{
  int i, sorted;
  float x[VALS];
  float temp, median, mean, stdev;

  printf("Please enter %d numbers to find the mean, the median, and the standard deviation.\n",VALS);
  for(i = 0; i < VALS; i++)
  {
     printf("Enter number %d:  ",i+1);
     scanf("%f",&x[i]);
  }
  
  /* Bubble sort: */
  
  do {
       for (i = 1, sorted = 1; i < VALS; i++)
       {
         if (x[i-1] > x[i])
         {
           sorted = 0;
           temp = x[i-1];
           x[i-1] = x[i];
           x[i] = temp;
         }
       }
     } while (!sorted);

  for(i = 0, mean = 0; i < VALS; i++)
  {
     mean += x[i];
  }
  mean = mean/VALS;

  /* Output mean value: */

  printf("The mean value is %f.\n",mean);

  printf("The median value is ");
  if(VALS % 2 == 0)
  {
     median = (x[((VALS)/2)-1] + x[VALS/2])/2;
  }
  else if(VALS % 2 != 0)
  {
     median = x[(VALS)/2];
  }

  /* Output median value: */

  printf("%f.\n",median);

  for(i = 0, stdev = 0; i < VALS; i++)
  {
     stdev += pow((x[i]-mean),2);
  }
  stdev = sqrt(stdev/(VALS - 1));

 /* Output standard deviation: */

  printf("The standard deviation is %f.\n",stdev);
  
  return 0;
}
