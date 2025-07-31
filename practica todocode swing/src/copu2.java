import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class copu2 {
    private JTextField textField1;
    private JButton button1;
    public JPanel Panel1;
    private JButton siguienteButton;

    public copu2() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = "putita";
                textField1.setText(texto);
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
