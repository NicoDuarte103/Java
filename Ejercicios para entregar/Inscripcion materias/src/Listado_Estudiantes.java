import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Listado_Estudiantes {
    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBoxCursos;
    private JButton cerrarButton;
    private JComboBox cicloLectivo;
    private JComboBox Institucion;
    private JButton buscarButton;
    private DefaultTableModel dtm = new DefaultTableModel();
    private String [] Rellenado_tabla = new String[]{"Nombre","Apellido","Dni","Fecha Nacimiento","Domicilio","telefono","email","Localidad","Nacionalidad","Curso","Instructor","institucion","ciclo lectivo"};
    private DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
    private Connection con;
    private Statement statement;
    private ArrayList <String> Instructores = new ArrayList<>();
    private String indexS;

    private ArrayList <Object> Listado = new ArrayList <>();
    private ArrayList <Object> ListadoString = new ArrayList <>();
    //private DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel comboinst = new DefaultComboBoxModel();
    private DefaultComboBoxModel combociclo = new DefaultComboBoxModel();
    private String Item;
    private int indexciclo;
    private String Iteminsti;

    private String seleccioncursos;
    private int seleccionciclo;
    private String seleccioninstitucion;

    private String SelectNombre;
    private String SelectApellido;
    private String SelectDni;
    private String SelectNacimiento;
    private String SelectDomicilio;
    private String SelectTelefono;
    private String SelectEmail;
    private String SelectLocalidad;
    private String SelectNacionalidad;

    private String idestudiante;
    private int numerorow;
    private int numerocolum;

    private String user;



    public Listado_Estudiantes(){


        Conexion();
        selectciclo();
        selectinsti();
        select_curso();
        SelectInstructor();
        //selectcombo();
        //SelectInstructor();


        //comboBoxCursos.setModel(combo);
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //dtm.setColumnIdentifiers(Rellenado_tabla);
        //table1.setModel(dtm);

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

        cicloLectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectciclo();
                select_curso();
                selectinsti();


            }
        });
        comboBoxCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectinsti();
            }
        });
        Institucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = table1.getRowCount();
                dtm.setRowCount(0);
                SelectInstructor();
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
    }

    public void Conexion(){

    String Driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/escuela";
    //String user = "root";
    String pass = "";
    //String url = conex.getUrl();
    String user = "root";
    //String pass = conex.getPass();

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

    public void select_curso(){
        if (combo.getSize() > 0){
            combo.removeAllElements();
        }
        //indexciclo = cicloLectivo.getSelectedIndex()+1;
        System.out.print("indexciclo "+ indexciclo);
        String sqlprod = "select a.Nombre from cursos a inner join ciclo_lectivo b on a.id_ciclo = b.id_ciclo where a.id_ciclo = "+indexciclo;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            if (combo.getSize() < 1){
                while (rs.next()){
                    System.out.println("tito");
                    combo.addElement(rs.getString("Nombre"));
                    System.out.println(rs.getString("Nombre"));
                }
                comboBoxCursos.setModel(combo);}

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void selectinsti(){
        if (comboinst.getSize() > 0){
            comboinst.removeAllElements();
        }
        Item = (String) comboBoxCursos.getSelectedItem();
        indexciclo = cicloLectivo.getSelectedIndex()+1;

        String sqlprod = "select a.Nombre from institucion a inner join cursos b on a.id_institucion = b.id_institucion  where (b.Nombre = '" +
                Item +"' && b.id_ciclo = "+indexciclo+")";



        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                comboinst.addElement(rs.getString(1));

            }
            Institucion.setModel(comboinst);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void selectciclo(){

        String sqlprod = "select anio from ciclo_lectivo";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            if (combociclo.getSize() < 1){

                while(rs.next()){

                    combociclo.addElement(rs.getString(1));


                }
                cicloLectivo.setModel(combociclo);}


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select(){
        //Item = (String) comboBoxCursos.getSelectedItem();
        //indexciclo = cicloLectivo.getSelectedIndex()+1;

        String sqlprod = "select a.Nombre,a.Apellido,a.DNI,a.Fecha_nacimiento,a.Domicilio,a.Telefono,a.Email,a.Localidad,a.Nacionalidad,b.Nombre,'',c.Nombre ,d.Anio from estudiantes a inner join cursos b on a.id_curso=b.id_cursos INNER JOIN institucion c ON a.id_institucion=c.id_institucion INNER join ciclo_lectivo d on b.id_ciclo =d.id_ciclo where b.Nombre = '"+Item+"' && c.Nombre = '"+Iteminsti +"'&& d.id_ciclo = '"+indexciclo+"' && a.Visible = 1" ;
        ResultSet rs = null;
        PreparedStatement ps = null;
        System.out.println("insittuto;"+Iteminsti);
        try{

            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            ResultSetMetaData resul = rs.getMetaData();
            int cantidadcolumnas = resul.getColumnCount();
            dtm.setColumnIdentifiers(Rellenado_tabla);
            while(rs.next()){
                Object[] filas = new Object[cantidadcolumnas];

                for (int i = 0; i<cantidadcolumnas;i++){
                    if(i == 10){
                        filas[i]= Instructores;
                    }
                    else {
                    filas[i]= rs.getObject(i+1);}

                }
                System.out.println("cantidad select");
                dtm.addRow(filas);


            }
            table1.setModel(dtm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void SelectInstructor(){

        if (Instructores.size()>0){
            Instructores.clear();

        }
        Iteminsti = (String)Institucion.getSelectedItem();
        String sqlprod = "select  * FROM docentes a inner JOIN institucion b on a.id_institucion = b.id_institucion INNER JOIN cursos c on a.id_curso = c.id_cursos where c.Nombre = '"+Item+"'&& b.Nombre = '"+Iteminsti+"'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while (rs.next()){
                //System.out.println("en instructor");
                Instructores.add (rs.getString(2) +" "+ rs.getString(3));

            }
            System.out.println(Instructores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


   public void select_updatte() {
       String sqlprod = "select id_estudiantes from estudiantes where Nombre = '" + SelectNombre + "'&& Apellido = '" + SelectApellido + "'&& DNI = '" + SelectDni + "'&& Fecha_nacimiento ='" + SelectNacimiento + "' && Domicilio ='" + SelectDomicilio + "' && Telefono = '" + SelectTelefono + "'&& Email ='" + SelectEmail + "' && Localidad = '" + SelectLocalidad + "' && Nacionalidad = '" + SelectNacionalidad + "'";

       PreparedStatement ps = null;
       ResultSet rs = null;
       ResultSetMetaData resul = null;

       try {
           ps = con.prepareStatement(sqlprod);
           rs = ps.executeQuery();
           while (rs.next()) {
               idestudiante = rs.getString(1);
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

        ps = con.prepareStatement("UPDATE estudiantes SET Nombre = ?,Apellido = ?,DNI= ?,Fecha_nacimiento = ?,Domicilio = ?,Telefono = ?,Email = ?,Localidad = ?,Nacionalidad = ? where id_estudiantes ='"+idestudiante+"'");
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
        ps = con.prepareStatement("UPDATE estudiantes SET Visible = ? where id_estudiantes ='"+idestudiante+"'");
        ps.setInt(1,0);
        ps.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



}
