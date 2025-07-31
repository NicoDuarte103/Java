import javax.swing.*;
public class Principal {


    public static void main (String[] args){

        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new copiador().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
