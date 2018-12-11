#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
        FILE *ptr_infile;
        FILE *ptr_outfile;
        char currentWord[80+1];
        
        if(argc != 4)
        {
            printf("Incorrect number of command line arguments!\n");
            return 0;
        }
        else
        {
            ptr_infile =fopen(argv[1], "r");
            if(ptr_infile == NULL)
            {   
                printf("Failed to open the input file\n");
                return 0;
            }
            else
            {
               ptr_outfile = fopen(argv[2], "w+");
                while(fscanf(ptr_infile, "%s", currentWord) > 0)
                    if(strcmp(currentWord, argv[3]) < 0)
                        fprintf(ptr_outfile, "%s\n", currentWord);
                return 0;
            }
        }
}

