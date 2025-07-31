/*
* crear una resta reiterada
*
* */


import java.util.Scanner;
public class Main {
    private static int Num1;
    private static int Num2;

    public static void setNum1(int Num1){
        Main.Num1=Num1;
    }
    public static void setNum2(int Num2){
        Main.Num2=Num2;
    }
    public static int getNum1(){
        return Num1;
    }
    public static int getNum2(){
        return Num2;
    }

    public static void division(){
        Scanner sc = new Scanner(System.in);
        Num1 = sc.nextInt();
        Num2 = sc.nextInt();
        int i = 0;
        int resultado = 0;
        int restanum2 = 0;
        /*for (i = Num1;i>=1;i++){


            if (resultado%i == 0){
                resultado = i-Num2;
                System.out.println(resultado);
                if (resultado <=0){
                    i=-10;
                }
            }

        }*/



        for (i = Num1;i>=0;i-=Num2){

            System.out.println(i);

        }

        int resultado_fin = 0;




    }
    public static void main(String[] args) {
    division();

    }
}