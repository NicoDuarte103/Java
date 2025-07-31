import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana1 {
    public JTextField textField1;
    private JButton borrarButton;
    private JTextField textField2;
    private JButton copiarButton;
    public JPanel Panel1;
    private int variable;

    public Ventana1() {

        copiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                textField2.setText(texto);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("0");
                textField1.setText("0");



            }
        });
    }


}
