import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class tabla {
    private JButton button1;
    private JTextField textField1;
    private JPanel panel1;
    private JTable table1;
    private JButton button2;
    private JButton filtrarButton;
    private JTabbedPane tabbedPane1;
    private JRadioButton radioButton1;
    private JComboBox comboBox1;
    private JTable table2;
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();
    private String[] titulo = new String[]{"nombre","edad","apodo_o_alias","dni","ejemplar","nro_tramite_dni","sexo_dni","genero_dni","vencimiento_dni","lugar_nacimiento_dni","direccion_dni","direccion_actual","edad","fecha_nacimiento","contacto","nacionalidad","estado_civil","bando","vivo_o_muerto","grado_peligrosidad"};
    private String[] titulo2 = new String[]{"grupo_social","psicologia","adicciones","mascotas","fecha_ultima_vez_visto","hora_ultima_vez_visto","lugar_ultima_vez_visto","colectivos_que_toma","informacion_varia"};
    public tabla() {

        dtm.setColumnIdentifiers(titulo);
        dtm1.setColumnIdentifiers(titulo2);

        getters geta = new getters();
        geta.setC("12");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = "13";
            dtm.addRow(new Object[]{textField1.getText(),resultado});
            dtm1.addRow(new Object[]{resultado});
            table1.setModel(dtm);
            table2.setModel(dtm1);
            }

        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dtm.removeRow(0);

            }
        });

        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = geta.getC();
                int valores = Integer.parseInt(resultado);

                for (int i = 0; i< table1.getRowCount(); i++){ //recorre
                    String valor = (String) table1.getValueAt(i,valores); //obtiene el valor de las filas y columnas dsignadas,usar metodo burbuja para ampliar a columnas
                    if (valor.contains(textField1.getText())){

                        System.out.println("encontrado"+ valor);
                        int columnas = table1.getColumnCount();
                        System.out.println(columnas);
                    }
                    else{
                        System.out.println("no encontrado");
                    }


                }
            }
        });



        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String)comboBox1.getSelectedItem();
                if (seleccion.equals("nombre")){
                    System.out.println("seleccionaste nombre");
                    geta.setC("0");
                } else if (seleccion.equals("edad")) {
                    System.out.println("seleccionaste edad");
                    geta.setC("1");

                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("ingreso");
        frame.setContentPane(new tabla().panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}




