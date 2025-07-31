
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       List<producto> prod = new ArrayList <producto>();

       prod.add(new producto("tomate",100.2));
        prod.add(new producto("leche",150.3));
        prod.add(new producto("fideo",10.4));
        prod.add(new producto("queeso",1000.5));
        prod.add(new producto("peras",200.6));
        Scanner sc = new Scanner(System.in);
        String resultado = sc.next();

        for (producto produ:prod){
            if (produ.getNombre().equals(resultado)){
                System.out.println("encontrado"+produ.getNombre()+produ.getPrecio());
            }



        }



    }
    }
