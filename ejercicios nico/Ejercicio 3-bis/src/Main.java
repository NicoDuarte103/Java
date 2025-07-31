/*
Haz una aplicacion qeu calcule el area de un circulo (pi*R2)

*/
 */
 */
 */
 java.util.Scanner;
public class Main {
    private static double R2;

    public static void setR2(double R2){
        Main.R2 = R2;
    }
    public static double getR2(){
        return R2;
    }

    public static void Circulo(double R2){
        Double Resultado = 3.14*R2;
        System.out.println("el area del ciruclo es: "+ Resultado);


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el radio del circulo:");
        R2 = sc.nextDouble();
        Circulo(R2);



        System.out.printf("Hello and welcome!");


    }
}