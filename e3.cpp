
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
FILE *fp;
FILE *fp1;
char al[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
 int search(char ch)
 {  int i;
    for(i=0;i<26;i++)
     {
	if(ch==al[i])
	return i;
     }
 }


void main()
{
 clrscr();

 char ch,q;
 int k,i,j,a[20],c,b,cho;
 int n=0;
 char cipher[20],deciper[20];
 fp=fopen("cat.txt","r");
 printf("\nPlain Text:");
 while((ch=fgetc(fp))!=EOF)
 {
   n++;
   printf("%c",ch);
 }
  fclose(fp);
   printf("\nENTER KEY\n");
   scanf("%d",&k);
   printf("\nENTER YOUR CHOICE\n");
   printf("1.ENCRYPT\t2.DECRYPT\t3.EXIT\n");
   scanf("%d",&cho);

       switch(cho)
   {
   case 1:
	      fp=fopen("cat.txt","r");
	       fp1=fopen("cat1.txt","w");
	       printf("\nEncrypted Text:");
		 while((ch=fgetc(fp))!=EOF)
		    {
			b=(search(ch)+k)%26;

		      printf(" %c ",al[b]);




		     fputc(al[b],fp1);
		     }
		     fclose(fp);
		     fclose(fp1);
	   break;
   case 2:

		fp1=fopen("cat1.txt","r");
			 printf("\nDecrypted Text:");
			 while((ch=fgetc(fp1))!=EOF)
				{
					c=(search(ch)+26-k)%26;
				   printf(" %c ",al[c]);
				  }


	   break;
   case 3: exit(0);
   default:
   printf("invalid choice");

   }

 getch();
 }