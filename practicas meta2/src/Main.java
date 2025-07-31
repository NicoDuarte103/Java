
//Escribir un programa para convertir una medida dada en pies a sus equivalentes en: Yardas,
// Pulgadas, Centímetros, Metros.
// 1 pie = 12 pulgadas, 1 yarda = 3 pies, 1 pulgada = 2,54 Cm
// Leer el número de pies e imprimir el número de yardas, pulgadas, centímetros y metros.
import java.util.Scanner;

public class Main{


    public static void main(String[] args){

        double pie = 0;
        double yarda = 0;
        double pulgada = 0;
        double centrimetros = 0;
        double metros = 0;

        Scanner sc = new Scanner(System.in);
        pie = sc.nextDouble();
        yarda = pie/3;
        pulgada= pie*12;
        centrimetros = pulgada*2.54;
        metros = centrimetros/100;
        System.out.println("pie: "+pie);
        System.out.println("yar: "+yarda);
        System.out.println("pul: "+pulgada);
        System.out.println("cm: "+centrimetros);
        System.out.println("metros: "+metros);





    }
        }