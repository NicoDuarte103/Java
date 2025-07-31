public class Elementos_get_set {
    protected String nombre;
    protected String marca;
    protected double cantidad;
    protected double precio_unitario;
    protected double precio_total;
    protected double descuento;

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public double getDescuento() {
        return descuento;
    }
    public Elementos_get_set(String nombre,String marca,double cantidad,double precio_unitario,double precio_total,double descuento){
        this.nombre=nombre;
        this.marca=marca;
        this.cantidad=cantidad;
        this.precio_unitario = precio_unitario;
        this.precio_total=precio_total;
        this.descuento=descuento;

    }
}