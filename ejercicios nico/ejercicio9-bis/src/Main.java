import java.util.Scanner;
public class Main {
    private static int Num1;

    public static void setNum1(int num1){
        Main.Num1=num1;
    }
    public static int getNum1(){
        return Num1;
    }

    public static void par_impar(){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int i = 0;
        for (i = 0;i<10;i++){
            Num1 = sc.nextInt();
            array[i] = Num1;
        }

        for (i = 0;i<10;i++){

            if (array[i]%2 == 0){
                System.out.println("el numero " + array[i] + " es par");
            }
            else {
                System.out.println("el numero " + array[i] + " es impar");
            }
        }

    }

    public static void entero_perfecto(int valor){
        int i = 1;
        int j = valor;
        int sumatoria = 0;
           for (i = 1;i<j;i++){

               if (j%i == 0){
                   sumatoria = sumatoria+i;
                   //System.out.println(sumatoria);

               }

               }
             if (sumatoria == valor){
                //System.out.println(i);

                    System.out.println("el numero " + j + "es entero perfecto");}



       }

    public static void Resultado_entero_perfecto(){
        int i = 1;
        for (i = 1;i<100;i++){
            entero_perfecto(i);}


    }


    public static void inversion(){
        Scanner sc = new Scanner(System.in);
        Num1 = sc.nextInt();
        int digito1 = Num1%10;
        int digito2 = ((Num1%100)-digito1)/10;
        int digito3 = ((Num1%1000)-Num1%100)/100;
        int digito4 = ((Num1%10000)-Num1%1000)/1000;
        System.out.println(digito1+""+digito2+""+digito3+""+digito4);

    }

    public static void Menu(){

        Scanner sc = new Scanner(System.in);
        int bucle = 0;
        while (bucle == 0) {
            System.out.println("seleccione lo que desea hacer: ");
            System.out.println("1-introducir manualmente 10 enteros y determinar pares e impares ");
            System.out.println("2-Buscador de enteros perfectos entre 0 y 100: ");
            System.out.println("3-inversor de numeros: ");
            System.out.println("4-Salir: ");
            Num1 = sc.nextInt();
            int selector = Num1;
            switch (selector) {
                case 1:
                    par_impar();
                    break;

                case 2:
                    Resultado_entero_perfecto();
                    break;

                case 3:
                    inversion();
                    break;
                case 4:
                    bucle = 1;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }


    }

    public static void main(String[] args) {

    Menu();

    }
}