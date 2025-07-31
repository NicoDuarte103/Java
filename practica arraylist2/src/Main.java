import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <libros> libritos = new ArrayList<libros>();
        libritos.add(new libros("el hombre ilustrado","bradbury"));
        libritos.add(new libros("bovedas de acero","asimov"));
        libritos.add(new libros("harry potter","conchuda"));


        for(libros libra:libritos){

            System.out.println(libra.getTitulo() + " " + libra.getAutor());

        }
        //borrado por indice
        libritos.remove(2);

        for(libros libra:libritos){

            System.out.println(libra.getTitulo() + " " + libra.getAutor());

        }
        libritos.add(new libros("manifiesto comunista","marx"));

        for(libros libra:libritos){

            System.out.println(libra.getTitulo() + " " + libra.getAutor());

        }
        //print por indice
        System.out.println(libritos.get(1).getTitulo());




    }
}