import javax.swing.*;

public class Principal{
    public static void pagina1(){
        System.out.println("tito");
        JFrame frame = new JFrame("titulo"); //definis que es un frrame
        frame.setContentPane(new Ventana1().Panel1);//rellena la ventana
        frame.setLocationRelativeTo(null); // centrra la pantalla
        frame.pack(); //muestra el contenido del panel
        frame.setVisible(true); // hace la ventana visible
        frame.getContentPane().removeAll();
        frame.setContentPane(new Ventana1().Panel1);


    }


    public static void main (String[] args){

        pagina1();






    }


}