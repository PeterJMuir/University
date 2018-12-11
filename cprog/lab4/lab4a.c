#include<stdio.h>

int main() {

  int numInts;
  int i;
  int intArray[1000];
  
  printf("Please enter the number of integers you want to generate (min is 3 and max is 1000)\n");
  scanf("%d", &numInts);

  if ((numInts >= 3) && (numInts <= 1000))  {

    /* generate numInts numbers */
    for (i = 0; i < numInts; i++) {
      intArray[i] = i;
    }
    printf("The second element of the array is %d\n",intArray[1]);

    printf("\n");
    for(i = 0; i < numInts; i++){
      printf("Element %d of the array is %d\n",i,intArray[i]);
    }
    printf("\n");
    for(i = 0; i < 3; i++){
      printf("Element %d of the array is %d\n",i,intArray[i]);
    }
    printf("\n");
    for(i = 0; i < numInts; i = i+2){  
      printf("Element %d of the array is %d\n",i,intArray[i]);
    }
    printf("\n");
    for(i = 2; i < numInts; i++){
      printf("Element %d of the array is %d\n",i,intArray[i]);
    }
    /* Write a statement that prints the 2nd element of the numInts array here. */

    /* Write code to print out all the generated numbers here. */

    /* Write code to print out the first three generated numbers here. */

     /* Write code to print out every second generated number here. */

     /* Write code that prints all generated numbers starting from the 3rd number here. */

  }
  else {

    printf("Can not generate that many integers!!\n");
  }
  
  return 0;

}
