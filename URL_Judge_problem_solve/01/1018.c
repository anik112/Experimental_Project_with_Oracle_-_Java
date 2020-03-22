#include<stdio.h>

int main(){

    int notes[7];
    notes[0]=100;
    notes[1]=50;
    notes[2]=20;
    notes[3]=10;
    notes[4]=5;
    notes[5]=2;
    notes[6]=1;

    int total_amount,i=0;
    scanf("%d",&total_amount);

    if(total_amount>0 && total_amount<1000000){
        for(i=0;i<7;i++){
            int check=total_amount/notes[i];
            if(check > 0){
                printf("%d nota(s) de R$ %d,00\n",check,notes[i]);
                total_amount -= notes[i]*check;
            }else{
                printf("%d nota(s) de R$ %d,00\n",check,notes[i]);
            }
        }
    }


    return 0;
}
