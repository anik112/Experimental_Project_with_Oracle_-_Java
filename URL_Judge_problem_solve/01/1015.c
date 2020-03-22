#include<stdio.h>
#include<math.h>

int main(){

    double x1,x2,y1,y2;

    scanf("%lf",&x1);
    scanf("%lf",&y1);
    scanf("%lf",&x2);
    scanf("%lf",&y2);

    double x2x1=(x2-x1);
    double y2y1=(y2-y1);

    printf("%.4lf\n",(sqrt((x2x1*x2x1)+(y2y1*y2y1))));

    return 0;
}
