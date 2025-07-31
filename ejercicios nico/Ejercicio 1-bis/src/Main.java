/*
* Declara 2 variables numericas(con el valor que desees) he indica cual es
* mayor de los dos.Si son iguales indicarlo tambien,ir cambiando valores para
* comporbar que funciona
* */

import java.util.Scanner;
public class Main {
    private static int Num1;
    private static int Num2;

    public static void setNum1(int Num1){
        Main.Num1=Num1;
    }
    public static void setNum2(int Num2){
        Main.Num2 = Num2;
    }
    public int getNum1(){
        return Num1;
    }
    public int getNum2(){
        return Num2;
    }

    public static void diferenciador (int Num1,int Num2){
        if (Num1 > Num2){
            System.out.println("el numero Num1 "+ Num1 + "es mayor");
        } else if(Num1 < Num2){
            System.out.println("el numero Num2 "+ Num2 + "es mayor");
        } else {
            System.out.println("los numeros son iguales");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Num1=sc.nextInt();
        Num2=sc.nextInt();
        System.out.println("numero 1 "+Num1);
        System.out.println("numero 2"+ Num2);
        diferenciador(Num1,Num2);
        System.out.printf("Hello and welcome!");

    }
}