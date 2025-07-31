import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        List<empleado> emple = new ArrayList<empleado>();
        int salariominimo= 300;
        emple.add(new empleado("ricardo",800));
        emple.add(new empleado("diego",900));
        emple.add(new empleado("juan",200));
        emple.add(new empleado("pablo",100));
        emple.add(new empleado("roberto",300));


        for(empleado empleo:emple){
            if (empleo.getSalario()>200){
                System.out.println(empleo.getSalario()+empleo.getNombre());
            }

        }
    }
}