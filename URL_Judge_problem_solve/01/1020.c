#include<stdio.h>

int main(){
    int days_of_year=365;
    int days_of_month=30;
    int year=0,month=0,days=0,age=0;

    scanf("%d",&age);

    year=age/days_of_year;
    age -= (days_of_year*year);
    month=age/days_of_month;
    age -= (days_of_month*month);
    days=age;

    printf("%d ano(s)\n",year);
    printf("%d mes(es)\n",month);
    printf("%d dia(s)\n",days);


    return 0;
}
