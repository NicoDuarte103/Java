import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        List<persona> personita = new ArrayList<persona>();

        personita.add(new persona("pollo",26));
        personita.add(new persona("ricardo",18));
        personita.add(new persona("clara",38));
        personita.add(new persona("paseador",21));
        personita.add(new persona("chcho",24));


        for(persona perso:personita){
            System.out.println(perso.getNombre() + perso.getEdad());

        }
    }
}