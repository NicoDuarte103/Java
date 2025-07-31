import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class alumnosgui {
    private JButton presente;
    private JButton ausente;
    private JTextField textField1;
    private JTable table1;
    private JPanel panel1;
    private JLabel estudiante;
    private JButton Agregar;
    private JButton eliminar;
    private JButton modificarpresente;
    private JButton modificarausente;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JButton png;
    private String [] titulo = new String[]{"nombre","asistencia","dni","curso","docente","fecha"};


    public alumnosgui() {


        JFrame frame = new JFrame();
        frame.setSize(1360,768);
        frame.setResizable(false);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(titulo);
        frame.setDefaultCl oseOperation(WindowConstants.EXIT_ON_CLOSE);
        // cosas del combobox
        DefaultComboBoxModel profes= new DefaultComboBoxModel<>();
        profes.addElement("nico 1");
        profes.addElement("nico 2");
        comboBox1.setModel(profes);
        DefaultComboBoxModel cursos= new DefaultComboBoxModel<>();
        cursos.addElement("programacion movil");
        cursos.addElement("programacion basica");
        comboBox2.setModel(cursos);
        //fechas
        Date dt = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat();
        String fechaformateada =formatofecha.format(dt);





        //valores por defecto de tabla
        alumnos alum = new alumnos();
        alum.setRow_asistencia(0);
        alum.setRow_nombre(0);

        List<String> preso = new ArrayList<String>();
        List<String> asist = new ArrayList<String>();
        preso.add(0,"Homero Simpson");
        preso.add(1,"Bart Simpson");
        preso.add(2,"Apu");
        //poner fecha por defecto
        for (int i = 0; i<preso.size();i++){
            dtm.addRow(new Object[]{preso.get(i),"","","","",fechaformateada});
            }








        presente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dtm.addRow(new Object[]{textField1.getText(),textField2.getText()});
                int valor = alum.getRow_asistencia();


                System.out.println(alum.getRow_asistencia());
                estudiante.setText((String) dtm.getValueAt(valor,0));
                table1.setValueAt("presente",valor,1);//insertar valro a columna y fila especifcas
                alum.setRow_asistencia(alum.getRow_asistencia()+1); //incrementador de rows






            }
        });
        table1.setModel(dtm);

        ausente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dtm.addRow(new Object[]{preso.get(1),"ausente"});
                int valor = alum.getRow_asistencia();


                System.out.println(alum.getRow_asistencia());
                estudiante.setText((String) dtm.getValueAt(valor,0));//label
                table1.setValueAt("ausente",valor,1);
                alum.setRow_asistencia(alum.getRow_asistencia()+1);


            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //nose
                int fila = table1.rowAtPoint(e.getPoint());//obtener algo
                System.out.println("seleccionado");
                int row_selecionada = table1.getSelectedRow();//obtiene posicion de rowselecionada
                Object valor_mouse = table1.getValueAt(row_selecionada,0); //obtiene el valor de la rowseleccionada
                String reemplazo = (String)valor_mouse;
                textField1.setText((String) valor_mouse);//rellena textfield
                estudiante.setText("<html>"+reemplazo.replace(" ","<br>")+"</html>");//va con html para salto de linea

                System.out.println(valor_mouse);
            }
        });
        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_cantidad = table1.getRowCount();

                dtm.addRow(new Object[]{textField1.getText(),"",textField2.getText(),"","",fechaformateada});


            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_selecionada = table1.getSelectedRow();
                dtm.removeRow(row_selecionada);
                Object valor_mouse = table1.getValueAt(row_selecionada,0); //modificarpresente acorde a estudiante


            }
        });
        modificarpresente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_selecionada = table1.getSelectedRow();
                table1.setValueAt("presente",row_selecionada,1);
            }
        });
        modificarausente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_selecionada = table1.getSelectedRow();
                table1.setValueAt("ausente",row_selecionada,1);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_cantidad = table1.getRowCount();
                Object seleccion = comboBox1.getSelectedItem();
                for (int i =0;i<row_cantidad;i++){
                table1.setValueAt(seleccion,i,4);}
                System.out.println(seleccion);

            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row_cantidad = table1.getRowCount();

                Object seleccion = comboBox2.getSelectedItem();
                for (int i =0;i<row_cantidad;i++){
                    table1.setValueAt(seleccion,i,3);}
                System.out.println(seleccion);

            }
        });
        png.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    impresion imp = new impresion(table1,"tabla.png");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
