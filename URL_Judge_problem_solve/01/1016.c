#include<stdio.h>

int main(){

    double user_dist,dis_between_two_car_hour=(90-60);
    scanf("%lf",&user_dist);
    printf("%.0lf minutos\n",((user_dist/dis_between_two_car_hour)*60));
    return 0;
}
