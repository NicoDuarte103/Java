/*
* Un triangulo rectangulo puede tener lados que sean todos enteros.El conjunto de tres valores
* enteros para los lados de un triangulo rectangulo se conoce
* como una terna pitagorica.Estos tres lados deben satisfacer la relacion de que la suma
* de los cuadrados de dos lados es igual al cuadrado de la hipotenusa
* Encuentre todfas las ternas de pitagoras para el cateto opuesto,cateto adyacente e hipoteniusa
* todos ellos no mayores de 500
*
* */


import java.util.Scanner;
public class Main {

    private static double Cateto1;
    private static double Cateto2;
    private static double Hipotenusa;
    private static int Seleccionador;

    public static void setCateto1(double cateto1){
        Main.Cateto1=cateto1;

    }

    public static void setCateto2(double cateto2){
        Main.Cateto2=cateto2;

    }

    public static void setHipotenusa(double hipotenusa){
        Main.Hipotenusa=hipotenusa;

    }

    public static void setSeleccionador(int seleccionador){
        Main.Seleccionador=seleccionador;

    }

    public static double getCateto1(){
        return Cateto1;
    }

    public static double getCateto2(){
        return Cateto2;
    }

    public static double getHipotenusa(){
        return Hipotenusa;
    }

    public static int getSeleccionador(){
        return Seleccionador;
    }

    public static double pitagoras(double cateto1,double cateto2,double hipotenusa){
        double i = 0;
        double Resultado_Hipotenusa_cuadrado = Math.pow(cateto1,2) + Math.pow(cateto2,2);
        double resultado_cateto1_cuadrado = Math.pow(hipotenusa,2) - Math.pow(cateto2,2);
        double resultado_cateto2_cuadrado = Math.pow(hipotenusa,2) - Math.pow(cateto1,2);
        if ((resultado_cateto1_cuadrado + resultado_cateto2_cuadrado) == Resultado_Hipotenusa_cuadrado ){
            System.out.println("cateto 1: "+ cateto1 + "cateto 2: " + cateto2 + "Hipotenusa: " + hipotenusa);
            i = 1;
        }
        return i;
    }
    public static void Buscador_ternas(){
        double resultado = 0;
        double aumentador =0;
        System.out.println("1-buscar una terna especifica \n");
        System.out.println("2-Mostrar todas las ternas\n");
        Scanner sc = new Scanner(System.in);
        Seleccionador = sc.nextInt();


        if (Seleccionador == 1){
            System.out.println("Ingrese el cateto 1 \n");
            Cateto1 = sc.nextDouble();
            System.out.println("Ingrese el cateto 2 \n");
            Cateto2 = sc.nextDouble();
            System.out.println("Ingrese la hipotenusa \n");
            Hipotenusa=sc.nextDouble();
            pitagoras(Cateto1,Cateto2,Hipotenusa);
            resultado = pitagoras(Cateto1,Cateto2,Hipotenusa);
            if(resultado == 1){

                aumentador = aumentador+1;
            }
        }else if(Seleccionador==2){
            for (int i = 1;i<=500;i++){
                for (int j = 1;j<=500;j++){
                    for (int k = 1;k<=500;k++){
                        pitagoras(i,j,k);
                        resultado = pitagoras(i,j,k);
                        if(resultado == 1){

                            aumentador = aumentador+1;
                        }
                    }
                }

            }

        }else {
            System.out.println("error");
        }



        System.out.println("la cantidad de ternas pitagoricas encontradas son: "+ aumentador);





    }
    public static void main(String[] args) {


        Buscador_ternas();

    }
}