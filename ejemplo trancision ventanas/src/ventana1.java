import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana1 {
    private JButton ventana2;
    public JPanel panel1;
    public JPasswordField passwordField1;
    public JTextField textField1;

    public ventana1() {
        geters gt = new geters();
        ventana2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gt.setC(1);
                String texto =textField1.getText();
                textField1.setText(texto);


            }
        });
    }
}
