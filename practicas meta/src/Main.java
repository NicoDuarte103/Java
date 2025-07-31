import java.util.Scanner;
//Escribir un programa que convierta un número dado en segundos en su equivalente en Horas,
// Minutos y Segundos.
// Ejemplo: Segundos=4000, el programa muestra 1H: 6M: 40S.

public class Main {

    public static void main(String[] args){
        int segundos =0;
        int minutos=0;
        int horas=0;
        Scanner sc = new Scanner(System.in);
        segundos = sc.nextInt();

        minutos = segundos/60;
        horas=minutos/60;
        System.out.println("segundos: "+segundos);
        System.out.println("minutos: "+minutos);
        System.out.println("horas: "+horas);



    }
}