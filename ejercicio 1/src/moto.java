public class moto extends Vehiculo{

    public int ruedas;

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void palabra(){
        System.out.println("la marca dela moto es"+ getMarca());
        System.out.println("la modelo de la moto es"+ getModelo());
        System.out.println("la ao de la moto es"+ getAno());
        System.out.println("la cantidad de ruedas de la moto es"+ruedas);


    }
}
