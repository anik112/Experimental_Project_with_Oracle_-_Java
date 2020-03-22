#include<stdio.h>
#include<math.h>


int main(){

    int a,b,c,maiorAb=0;

    scanf("%d",&a);
    scanf("%d",&b);
    scanf("%d",&c);

    maiorAb=(a+b+abs(a-b))/2;
    if(maiorAb>c){
        if(maiorAb>b){
            printf("%d eh o maior\n",maiorAb);
        }else{
            printf("%d eh o maior\n",b);
        }
    }else{
        if(c>b){
            printf("%d eh o maior\n",c);
        }else{
            printf("%d eh o maior\n",b);
        }
    }

return 0;
}
