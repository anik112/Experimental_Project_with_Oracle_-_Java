#include<stdio.h>

int main(){

    int hours=0,min=0,sec=0,inputSec=0,i=0,j=0,k=0;

    scanf("%d",&inputSec);

    min=inputSec/60; // find out temp minutes
    sec=inputSec-(min*60); // find the original second
    hours=min/60; // find the original hours
    min=min-(hours*60); // find the original minutes

    printf("%d:%d:%d\n",hours,min,sec);

    return 0;
}
