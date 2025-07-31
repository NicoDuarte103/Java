import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Inscripcion {
    protected JTextField Nombre;
    protected JTextField Apellido;
    protected JTextField Dni;
    private JButton inscribirseButton;
    protected JComboBox comboBoxCursos;
    private JPanel Panel1;
    private JLabel Datos;
    private JTextField Fecha_nacimiento;
    private JTextField Domicilio;
    private JTextField Telefono;
    private JTextField Email;
    private JTextField Localidad;
    private JTextField Nacionalidad;
    private JComboBox Institucion;
    private JComboBox cicloLectivo;
    private JLabel año;
    private Connection con;
    private Statement statement;
    private DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel comboinst = new DefaultComboBoxModel();
    private DefaultComboBoxModel combociclo = new DefaultComboBoxModel();
    private String Item;
    private int indexciclo;

    private String seleccioncursos;
    private int seleccionciclo;
    private String seleccioninstitucion;
    private String user1;
    private String pass1;
    private String url1;

    public Inscripcion(String url,String user,String pass){
        url1 = url;
        user1 = user;
        pass1 = pass;
        Conexion();
        selectciclo();
        selectinsti();
        select();


        select_insert_institucion();
        DefaultTableModel dtm = new DefaultTableModel();
        JFrame frame = new JFrame("Inscripcion a Materias");
        frame.setContentPane(Panel1);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        inscribirseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Tamanio_nombre = Nombre.getText().length();
                int Tamanio_apellido = Apellido.getText().length();
                int Tamanio_Dni = Dni.getText().length();

                if((Tamanio_nombre > 1 && Tamanio_apellido > 1) && Tamanio_Dni == 8){
                JOptionPane.showMessageDialog(null,"inscripcion exitosa");
                Datos.setForeground(Color.GREEN);
                Datos.setText("Inscripcion Exitosa");
                }
                else {
                    Datos.setForeground(Color.RED);
                    Datos.setText("Error");
                    JOptionPane.showMessageDialog(null,"datos invalidos");

                }

                insert();



            }
        });
        Institucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectinsertciclo();
                select_insert_institucion();
                select_insert_cursos();

            }
        });
        comboBoxCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectinsti();


            }
        });
        cicloLectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectciclo();
                select();
                selectinsti();


                System.out.println("e------------------------------------------------");
            }
        });
    }
    public void Conexion() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = url1;
        String user = user1;
        String pass = pass1;
        //Connection con;
        //Statement statement;

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if(!con.isClosed()){
                System.out.println("conexion exitosa");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void select(){
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

    public void selectinsertciclo(){
        seleccionciclo = cicloLectivo.getSelectedIndex()+1; //where id ciclo sea igual a esto
        System.out.println("ciclo lectivo select: "+seleccionciclo);
    }
    public void select_insert_institucion(){
        String seleccioninstitucion_proto = (String)Institucion.getSelectedItem();

        //seleccionciclo = cicloLectivo.getSelectedIndex(); //where id ciclo sea igual a esto
        //seleccioninstitucion = "select id_institucion where Nombre = 'CFP 403'"; //getselecteditem
        //seleccioncursos = "select id_cursos from cursos where id_institucion = 3 && id_ciclo = 1 && Nombre = 'Programacion'; " //parametros y getselecteditem
        //String sqlprod= "select id_curso from cursos where id_ciclo = && id_institucion = " //getselectedindex,
        String sqlprod = "select id_institucion from institucion where Nombre = '"+ seleccioninstitucion_proto +"'";

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try {
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                seleccioninstitucion = rs.getString(1);
            }
            System.out.println("seleccion insti: " +seleccioninstitucion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void select_insert_cursos (){
        //seleccioncursos = "select id_cursos from cursos where id_institucion = 3 && id_ciclo = 1 && Nombre = 'Programacion'; " //parametros y getselecteditem
        String seleccion_nombre_curso = (String) comboBoxCursos.getSelectedItem();
        String sqlprod = "select id_cursos from cursos where id_institucion = "+seleccioninstitucion+ "  && id_ciclo =" + seleccionciclo + " && Nombre = '"+seleccion_nombre_curso+"'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while(rs.next()){
                seleccioncursos = rs.getString(1);

            }
            System.out.println("seleccion cursos: "+seleccioncursos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void insert(){
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into estudiantes(Nombre,Apellido,DNI,Fecha_nacimiento,Domicilio,Telefono,Email,Localidad,Nacionalidad,id_curso,id_institucion,Visible)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");

            ps.setString(1,Nombre.getText());
            ps.setString(2,Apellido.getText());
            ps.setString(3,Dni.getText());
            ps.setString(4,Fecha_nacimiento.getText());
            ps.setString(5,Domicilio.getText());
            ps.setString(6,Telefono.getText());
            ps.setString(7,Email.getText());
            ps.setString(8,Localidad.getText());
            ps.setString(9,Nacionalidad.getText());
            ps.setString(10,seleccioncursos);  //que sean numeros
            ps.setString(11,seleccioninstitucion);//que sean numeros
            ps.setString(12,"1");//que sean numeros

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    }






