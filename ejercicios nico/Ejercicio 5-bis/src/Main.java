/*
* Diseñe un algoritmo que,dado un numero real que entra como dato,nos indique si esta contenido dentro
* de los limites predeterminados.El limite inferior es de 100 y el superior de 200
* */

import java.util.Scanner;
public class Main {

    private static double Num;

    public static void setNum(double Num){
        Main.Num=Num;

    }
    public static double getNum(){

        return Num;
    }

    public static void Limites(double Num){

        if (Num>100 && Num <200){

            System.out.println("el numero esta dentro de los limites");
        }
        else {
            System.out.println("el numero esta fuera de los limites");
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Pone un numero: ");
        Num = sc.nextDouble();
        Limites(Num);


        
    }
}