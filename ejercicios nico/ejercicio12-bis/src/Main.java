/*
* programar un algoritmo que permita hacer  multiplicaciones usando al suma
*
* */
import java.util.Scanner;
public class Main {
    private static int Num1;
    private static int Num2;

    public static void setNum1(int Num1){
        Main.Num1 = Num1;
    }
    public static void setNum2(int Num2){
        Main.Num2 = Num2;
    }
    public static int getNum1(){

        return Num1;
    }

    public static int getNum2(){

        return Num2;
    }

    public static void Multiplicar(){
        Scanner sc = new Scanner(System.in);
        Num1 = sc.nextInt();
        Num2 = sc.nextInt();
        int resultado = 0;

        for (int i = Num1;i<= Num1*Num2;i+=Num1){

            resultado = i;
            System.out.println(resultado);


        }





    }
    public static void main(String[] args) {
        Multiplicar();


    }
}