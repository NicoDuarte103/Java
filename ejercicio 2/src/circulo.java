public class circulo extends figura{

    private double radio;
    private double resultado;

    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double getRadio(){
        return radio;
    }

    public void setResultado(double resultado){
        this.resultado = (getRadio()*getRadio())*3.14;
    }

    public double getResultado() {
        return resultado;
    }


    public void palabra(){
        System.out.println("el resultado del area del ciruclo es "+ getResultado());


    }
}
