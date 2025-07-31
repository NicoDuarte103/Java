public class Main {



    public static void main (String[] args){
        auto autito = new auto();
        moto motito = new moto();
        autito.setRuedas(10);
        autito.setMarca("toyota");
        autito.setAno(2011);
        autito.setModelo("pelotudin");
        autito.palabra();

        motito.setRuedas(2);
        motito.setMarca("yamaha");
        motito.setAno(2012);
        motito.setModelo("pelotud");
        motito.palabra();
        autito.palabra();


    }
}
