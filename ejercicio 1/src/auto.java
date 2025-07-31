public class auto extends Vehiculo{

    public int ruedas;

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void palabra(){
        System.out.println("la marca del auto es"+ getMarca());
        System.out.println("la modelo del auto es"+ getModelo());
        System.out.println("la ao del auto es"+ getAno());
        System.out.println("la cantidad de ruedas del auto es"+ruedas);


    }
}
