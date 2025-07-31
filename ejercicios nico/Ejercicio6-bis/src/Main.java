/*
* Programe un algoritmo que,dados dos numeros enteros que entran como datos,indique si uno es divisor
* del otro
*
*
* */

import java.util.Scanner;

public class Main {

    private static double Num1;
    private static double Num2;
    public static void setNum1(Double Num1){
        Main.Num1=Num1;

    }
    public static void setNum2(Double Num2){
        Main.Num2=Num2;

    }
    public static double getNum1(){
        return Num1;

    }

    public static double getNum2(){
        return Num2;

    }

    public static void divisores(double Num1,double Num2){
        double resultado1 = Num1%Num2;
        double resultado2 = Num2%Num1;

        if (resultado1 == resultado2){
            System.out.println ("ambos numeros son divisores entre si");

        } else{
            System.out.println ("ambos numeros NO son divisores entre si");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese numero 1: ");
        Num1 = sc.nextDouble();
        System.out.printf("Ingrese numero 2: ");
        Num2 = sc.nextDouble();
        divisores(Num1,Num2);


        System.out.printf("Hello and welcome!");


        }
    }
