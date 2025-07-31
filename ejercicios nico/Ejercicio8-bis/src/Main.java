
/*
* juego de tirar dados craps*/
import java.util.Random;
import java.util.Scanner;
public class Main {
    private static int dado1;
    private static int dado2;
    private static int tirada;

    public static void setDado1(int dado1){
        Main.dado1=dado1;
    }

    public static void setDado2(int dado2){
        Main.dado2=dado2;
    }

    public static void settirada(int tirada){
        Main.tirada=tirada;
    }

    public static int getDado1(){

        return dado1;
    }

    public static int getDado2(){

        return dado2;
    }

    public static int gettirada(){

        return tirada;
    }

    public static void tirar() {

        int juego = 0;
        int seguir_jugando = 0;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        while (seguir_jugando == 0) {
            int resultado = 0;
            int resultado2 = 0;
            while (juego == 0) {

                System.out.println("Jugador 1: " + resultado + "puntos");
                System.out.println("Jugador computadora : " + resultado2 + "puntos");
                System.out.println("desea tirar el dado?");
                System.out.println("1-si ");
                System.out.println("2-Rendirse");
                tirada = sc.nextInt();
                if (tirada == 1) {
                    dado1 = rand.nextInt(6) + 1;
                    dado2 = rand.nextInt(6) + 1;
                    resultado = dado1 + dado2;
                    dado1 = rand.nextInt(6) + 1;
                    dado2 = rand.nextInt(6) + 1;
                    resultado2 = dado1 + dado2;
                    System.out.println("resultado del jugador 1 : " + resultado);
                    System.out.println("resultado del jugador 2 : " + resultado2);
                    if (resultado == 7 || resultado == 11) {
                        System.out.println("el jugador 1 gana la computadora pierde");
                        juego = 1;
                        break;

                    } else if (resultado == 2 || resultado == 3 || resultado == 12) {
                        System.out.println("el jugador 1 pierde,la computadora gana");
                        juego = 1;
                        break;

                    } else if (resultado2 == 7 || resultado2 == 11) {
                        System.out.println("El jugador computadora gana");
                        juego = 1;
                        break;

                    } else if (resultado2 == 2 || resultado2 == 3 || resultado2 == 12) {
                        System.out.println("El jugador computadora pierde,el jugador 1 gana");
                        juego = 1;
                        break;

                    } else {
                        System.out.println("El jugador 1 consigue una tirada");
                        System.out.println("El jugador 2 consigue una tirada");
                    }
                } else if (tirada == 2) {
                    System.out.println("el jugador 1 se rindio y ha perdido");
                    juego = 1;
                    break;


                } else {
                    System.out.println("error");
                    juego = 1;
                    break;

                }
            }
            System.out.println("volver a jugar? ");
            System.out.println("1-si ");
            System.out.println("2-no ");
            tirada = sc.nextInt();
            if (tirada == 1){
                seguir_jugando = 0;
                juego = 0;
            }
            else{
                seguir_jugando = 1;
                break;
            }
        }
    }
    public static void main(String[] args) {
        tirar();


    }
}