#include<stdio.h>

int main(){

    float notes[6];
    notes[0]=100.00;
    notes[1]=50.00;
    notes[2]=20.00;
    notes[3]=10.00;
    notes[4]=5.00;
    notes[5]=2.00;

    float coin[6];
    coin[0]=1.00;
    coin[1]=0.50;
    coin[2]=0.25;
    coin[3]=0.10;
    coin[4]=0.05;
    coin[5]=0.01;

    float total_amount;
    int i=0;
    scanf("%f",&total_amount);

    if(total_amount>=0 && total_amount<=1000000.00){
        printf("NOTAS:\n");
        for(i=0;i<6;i++){
            int check=total_amount/notes[i];
            if(check > 0){
                printf("%d nota(s) de R$ %.2f\n",check,notes[i]);
                total_amount -= notes[i]*check;
            }else{
                printf("%d nota(s) de R$ %.2f\n",check,notes[i]);
            }
        }
        printf("MOEDAS:\n");
        for(i=0;i<6;i++){
            int checkCoin=total_amount/coin[i];
            if(checkCoin>0){
                    printf("%.0f moeda(s) de R$ %.2f\n",(total_amount/coin[i]),coin[i]);
                    total_amount -= coin[i]*checkCoin;
            }else{
                printf("%d moeda(s) de R$ %.2f\n",checkCoin,coin[i]);
            }
        }

    }
    return 0;
}
