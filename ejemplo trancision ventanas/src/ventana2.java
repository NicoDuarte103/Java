import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana2 {
    private JButton ventana2;
    public JPanel Panel2;
    private JLabel bienvenida;

    public ventana2() {
        geters gt = new geters();

        ventana1 ven1 = new ventana1();
        ventana2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gt.setC(2);
                String usuario =ven1.textField1.getText();
                String pass = ven1.passwordField1.getText();
                bienvenida.setText("titania");
                System.out.println(usuario);


            }
        });
    }
}
