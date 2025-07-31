import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tabla {
    private JTable table1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    DefaultTableModel dtm = new DefaultTableModel(); //crea 

    private String[] titulo = new String[]{"id","nombre","cantidad","precio"}; //define cuantas columnas y sus nombres

    public tabla() { //constuctor

        dtm.setColumnIdentifiers(titulo);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dtm.addRow(new Object[]{ // crea un objeto columna
                        textField1.getText(),textField2.getText(),textField4.getText(),textField3.getText()
                });// agrega a columnas lo que quieras,en este caso textos de textfield
                table1.setModel(dtm); // orden final que estructura daots de tabla
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame ("INGRESO");
        frame.setContentPane(new tabla().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


}
