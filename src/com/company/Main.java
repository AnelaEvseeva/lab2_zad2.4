import java.util.Scanner;

public class Main{
    static double eps=0.0000001;
    public static double fx(double x){
        return(Math.pow(x,3)-4.5*Math.pow(x,2)+6.5*x-3);
    }

    public static double dfx(double x){ return(3*x*x-9*x+6.5); }

    public static double r(double x0) {
        double x1 = x0 - fx(x0) / dfx(x0);
        while (Math.abs(x1 - x0) > eps) {
            x0 = x1;
            x1 = x0 -fx(x0) / dfx(x0);
        }
        return x1;
    }
    public static void rRec(double x0, double x1) {
        System.out.println(x1);
        if(Math.abs(x1 - x0) > eps){
            x0 = x1;
            x1 = x0 - fx(x0) / dfx(x0);
            rRec(x0, x1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите x0:");
        double x0 = sc.nextDouble();

        System.out.println("Нахождение корня через цикл");
        System.out.println(r(x0));

        System.out.println("Нахождение корня через рекурсию");
        double x1 = x0 - fx(x0) / dfx(x0);

        rRec(x0, x1);
    }

}