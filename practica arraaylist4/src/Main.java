
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        List<estudiant> alumno=new ArrayList<estudiant>();


        alumno.add(new estudiant("tito",1));
        alumno.add(new estudiant("aldana",10));
        alumno.add(new estudiant("cristin",10));
        alumno.add(new estudiant("mei",7));
        alumno.add(new estudiant("jaz",5));

        for (int i =0; i<5;i++){
            System.out.println(alumno.get(i).getNota());

        }
        alumno.sort(Comparator.comparing(estudiant::getNota).reversed());

        for (int i =0; i<5;i++){
            System.out.println(alumno.get(i).getNota());

        }


    }
}