/*
* Declara un String que contenga tu nombre,despues muestra un mensaje de bienvenida por consola*/

import java.util.Scanner;
public class Main {

    private static String Nombre;

    public static void setNombre(String Nombre){
        Main.Nombre = Nombre;

    }
    public static String getNombre(){
        return Nombre;

    }

    public static void Bienvenida(String Nombre){
        System.out.println("bienvenido "+ Nombre);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nombre = sc.nextLine();
        Bienvenida(Nombre);

        System.out.printf("Hello and welcome!");

    }
}