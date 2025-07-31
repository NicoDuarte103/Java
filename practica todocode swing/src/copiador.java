import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// crea un copiador de textos
public class copiador{
    private JTextField textField1;
    private JTextField textField2;
    private JButton copiarButton;
    public JPanel Panel1;
    private JButton cambiasButton;
    public copiador() {
        textField2.setEditable(false);
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new copu2().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        copiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                textField2.setText(texto);


                frame.setVisible(true);

            }
        });
        cambiasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }


}

