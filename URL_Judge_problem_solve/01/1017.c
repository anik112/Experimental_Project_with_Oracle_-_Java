#include<stdio.h>

int main(){

    float spend_hour,total_km,car_km_l=12;
    scanf("%f",&spend_hour);
    scanf("%f",&total_km);

    printf("%.3f\n",((total_km/car_km_l)*spend_hour));
    return 0;
}
