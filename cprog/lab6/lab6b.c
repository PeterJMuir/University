 #include <stdio.h>

int main()
{
       int  a, b, c, d, e, f;

       printf("Reading integers from standard input\n");
       printf("------------------------------------\n\n");

       printf("Enter six integers separated by space: ");
       scanf("%d%i%i%i%o%x", &a, &b, &c, &d, &e, &f);

       printf("The input displayed as decimal integers is: \n");
       printf("%d %d %d %d %d %d\n", a, b, c, d, e, f);

       return 0;

}