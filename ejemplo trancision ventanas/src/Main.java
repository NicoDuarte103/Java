import javax.swing.*;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int ag = 0;
        JFrame frame = new JFrame("tito");
        frame.setContentPane(new ventana1().panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        JFrame frame2 = new JFrame("tita");
        frame2.setContentPane(new ventana2().Panel2);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.pack();

        geters gt = new geters();
        gt.setC(4);
        while (ag == 0){

        int c2 = gt.getC();


        if (c2 == 1){
            frame.setVisible(false);
            frame2.setVisible(true);

        }
        else{

            frame2.setVisible(false);
            frame.setVisible(true);

        }
      }







        }
    }
