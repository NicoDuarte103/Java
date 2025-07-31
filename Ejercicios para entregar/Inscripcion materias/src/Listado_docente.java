import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Listado_docente {
    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton cerrarButton;
    private DefaultTableModel dtm = new DefaultTableModel();
    private String [] Rellenado_tabla = new String[]{"Nombre","Apellido","Dni","Fecha Nacimiento","Domicilio","telefono","email","Localidad","Nacionalidad","Curso","Dias","Hora_inicio","Hora_fin","institucion"};
    private DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
    private Connection con;
    private Statement statement;
    private int numerorow;
    private int numerocolum;
    private String SelectNombre;
    private String SelectApellido;
    private String SelectDni;
    private String SelectNacimiento;
    private String SelectDomicilio;
    private String SelectTelefono;
    private String SelectEmail;
    private String SelectLocalidad;
    private String SelectNacionalidad;
    private String iddocente;


    public Listado_docente(){



        Conexion();
        selectcombo();
        select();

        comboBox1.setModel(combo);
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        dtm.setColumnIdentifiers(Rellenado_tabla);
        table1.setModel(dtm);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numerorow = table1.getSelectedRow();
                numerocolum = table1.getSelectedColumn();
                int cantidad = table1.getRowCount();
                System.out.println("seleccionaste "+dtm.getValueAt(numerorow,numerocolum));
                SelectNombre = (String) dtm.getValueAt(numerorow,0);
                SelectApellido =(String) dtm.getValueAt(numerorow,1);
                SelectDni = (String) dtm.getValueAt(numerorow,2);
                SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                SelectEmail = (String) dtm.getValueAt(numerorow,6);
                SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                //hh.out.println("row nombre" +selectorrows.get(0));
                update();



            }
        });
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {



                if(e.getType() == TableModelEvent.UPDATE ){
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();
                    System.out.println("row: "+numerorow+"colum: "+numerocolum);
                    if(fila>=0&&columna>=0){
                        Object valor = dtm.getValueAt(fila,columna);
                        System.out.println("se actualizo el valor de la fila "+fila+"columna"+":"+valor);
                        SelectNombre = (String) dtm.getValueAt(numerorow,0);
                        SelectApellido =(String) dtm.getValueAt(numerorow,1);
                        SelectDni = (String) dtm.getValueAt(numerorow,2);
                        SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                        SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                        SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                        SelectEmail = (String) dtm.getValueAt(numerorow,6);
                        SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                        SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);

                        update();

                    }
                }


            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rows = dtm.getRowCount();

                dtm.setRowCount(0);


                select();
                numerorow = table1.getSelectedRow();

            }
        });
        table1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                e.consume();// evita el salto de linea al consumir evento predeterminado
                char c = e.getKeyChar();
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("presionaste enter");

                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                }
                else if(e.getKeyCode() == KeyEvent.VK_TAB){
                    System.out.println("presionaste tab");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna<table1.getColumnCount()-1){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna+1,columna+1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    System.out.println("presionaste left");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna>0){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna-1,columna-1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    System.out.println("presionaste right");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if (columna<table1.getColumnCount()-1){
                        table1.setRowSelectionInterval(fila,fila);
                        table1.setColumnSelectionInterval(columna+1,columna+1);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("presionaste up");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    System.out.println("la fila es"+fila);
                    if (fila>0){
                        table1.setRowSelectionInterval(fila-1,fila-1);
                        table1.setColumnSelectionInterval(columna,columna);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    int fila= table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    System.out.println("presionaste down");
                    SelectNombre = (String) dtm.getValueAt(numerorow,0);
                    SelectApellido =(String) dtm.getValueAt(numerorow,1);
                    SelectDni = (String) dtm.getValueAt(numerorow,2);
                    SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                    SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                    SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                    SelectEmail = (String) dtm.getValueAt(numerorow,6);
                    SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                    SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                    update();
                    fila= table1.getSelectedRow();
                    columna = table1.getSelectedColumn();
                    if (fila<table1.getRowCount()-1){
                        table1.setRowSelectionInterval(fila+1,fila+1);
                        table1.setColumnSelectionInterval(columna,columna);
                    }

                }
                else if(e.getKeyCode() == KeyEvent.VK_DELETE){
                    e.consume();
                    int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que deseas eliminar la fila");

                    if(respuesta == JOptionPane.OK_OPTION){
                        System.out.println("presionaste suprimir");
                        int fila= table1.getSelectedRow();
                        int columna = table1.getSelectedColumn();
                        if (fila>0){
                            if (dtm.getRowCount()>1){
                                table1.setRowSelectionInterval(fila-1,fila-1);
                                table1.setColumnSelectionInterval(columna,columna);}

                        }
                        else if(fila == dtm.getRowCount()){
                            System.out.println("iguales");
                        }


                        SelectNombre = (String) dtm.getValueAt(numerorow,0);
                        SelectApellido =(String) dtm.getValueAt(numerorow,1);
                        SelectDni = (String) dtm.getValueAt(numerorow,2);
                        SelectNacimiento = (String) dtm.getValueAt(numerorow,3);
                        SelectDomicilio = (String) dtm.getValueAt(numerorow,4);
                        SelectTelefono = (String) dtm.getValueAt(numerorow,5);
                        SelectEmail = (String) dtm.getValueAt(numerorow,6);
                        SelectLocalidad = (String) dtm.getValueAt(numerorow,7);
                        SelectNacionalidad =(String) dtm.getValueAt(numerorow,8);
                        update();
                        update_delete();

                        numerorow--;
                        dtm.removeRow(fila);
                        fila= table1.getSelectedRow();
                        columna = table1.getSelectedColumn();
                    }
                    else{
                        System.out.println("contiamos");
                    }




                }

            }

        });
        table1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c= e.getKeyChar();
                if(Character.isLetterOrDigit(c)){
                    int fila =table1.getSelectedRow();
                    int columna = table1.getSelectedColumn();
                    if(fila>=0 && columna >=0){
                        table1.editCellAt(fila,columna);
                        SwingUtilities.invokeLater(()-> {
                            Component editor = table1.getEditorComponent();
                            if(editor instanceof JTextComponent){
                                ((JTextComponent)editor).setText("");
                                ((JTextComponent)editor).requestFocus();
                                ((JTextComponent)editor).setCaretPosition(0);
                                ((JTextComponent)editor).setText(String.valueOf(c));
                                ((JTextComponent)editor).setCaretPosition(1);
                            }
                        });
                    }
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }


    public void Conexion(){
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "root";
        String pass = "";

        try{
            Class.forName(Driver);
            con = DriverManager.getConnection(url,user,pass);
            if(!con.isClosed()){
                System.out.println("exito");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void select (){
        int index = comboBox1.getSelectedIndex()+1;
        String indexS= String.valueOf(index);
        String sqlprod = "select a.Nombre,a.Apellido,a.DNI,a.Fecha_nacimiento,a.Domicilio,a.Telefono,a.Email,a.Localidad,a.Nacionalidad,b.Nombre,a.Dias,a.Horario_inicio,a.Horario_fin,c.Nombre from docentes a inner join cursos b on a.id_curso=b.id_cursos inner join institucion c on a.id_institucion = c.id_institucion where a.id_curso =" +
                indexS + "&& a.Visible = 1";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            int cantidadcolumnas = resul.getColumnCount();
            dtm.setColumnIdentifiers(Rellenado_tabla);
            while(rs.next()){
                Object[] filas = new Object[cantidadcolumnas];
                for (int i = 0; i<cantidadcolumnas;i++){
                    filas[i]= rs.getObject(i+1);

                }
                dtm.addRow(filas);


            }
            table1.setModel(dtm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void selectcombo(){
        String sqlprod = "select * from cursos";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            while(rs.next()){
                combo.addElement(rs.getString("Nombre"));


            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select_updatte() {
        String sqlprod = "select id_docente from docentes where Nombre = '" + SelectNombre + "'&& Apellido = '" + SelectApellido + "'&& DNI = '" + SelectDni + "'&& Fecha_nacimiento ='" + SelectNacimiento + "' && Domicilio ='" + SelectDomicilio + "' && Telefono = '" + SelectTelefono + "'&& Email ='" + SelectEmail + "' && Localidad = '" + SelectLocalidad + "' && Nacionalidad = '" + SelectNacionalidad + "'";

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            while (rs.next()) {
                iddocente = rs.getString(1);
                // System.out.println("select: " + idestudiante);
                // }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void update(){
        select_updatte();

        try{
            PreparedStatement ps = null;

            ps = con.prepareStatement("UPDATE docentes SET Nombre = ?,Apellido = ?,DNI= ?,Fecha_nacimiento = ?,Domicilio = ?,Telefono = ?,Email = ?,Localidad = ?,Nacionalidad = ? where id_docente ='"+iddocente+"'");
            String valor = (String) dtm.getValueAt(numerorow,numerocolum);

            System.out.println("updaterow: "+numerorow+"updtcolum"+numerocolum);
            ps.setString(1,SelectNombre);
            ps.setString(2,SelectApellido);
            ps.setString(3,SelectDni);
            ps.setString(4,SelectNacimiento);
            ps.setString(5,SelectDomicilio);
            ps.setString(6,SelectTelefono);
            ps.setString(7,SelectEmail);
            ps.setString(8,SelectLocalidad);
            ps.setString(9,SelectNacionalidad);

            ps.executeUpdate();
            update_delete(); //preuba

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void update_delete(){

        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE docentes SET Visible = ? where id_docente ='"+iddocente+"'");
            ps.setInt(1,0);
            ps.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}