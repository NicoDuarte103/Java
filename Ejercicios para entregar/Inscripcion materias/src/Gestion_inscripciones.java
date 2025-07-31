import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Gestion_inscripciones {
    private JPanel panel1;
    private JTable table1;
    private JButton nuevoEstudianteButton;
    private JButton nuevoDocenteButton;
    private JButton nuevoCursoButton;
    private JButton listadoDocenteButton;
    private JButton listadoEstudiantesButton;
    private JButton listadoCursosButton;
    private JButton nuevaEscuelaButton;
    private JButton listadoEscuelasButton;
    private JButton servidorButton;
    private Connection con;
    private Statement statement;
    private  DefaultTableModel dtm = new DefaultTableModel();
    private String [] Rellenado_tabla = new String[]{"Nombre","Apellido","Dni","Fecha Nacimiento","Domicilio","telefono","Localidad","Nacionalidad","Curso"};
    private String user1;
    private String pass1;
    private String url1;
    public Gestion_inscripciones(String url,String usuario,String pass){

        url1 = url;
        user1 = usuario;
        pass1 = pass;
        //dtm.setColumnIdentifiers(Rellenado_tabla);


        //dtm.addRow(new Object[]{"tito","rrodrigeez","1234","progrramacion","12","13","mili"});
        //table1.setModel(dtm);
        JFrame frame= new JFrame("gestion inscripciones");
        frame.setSize(1360, 768);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        Conexion();
        select();


        nuevoEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inscripcion inscripcion = new Inscripcion(url1,user1,pass1); //repetir la conexion en los demas clases
            }
        });
        nuevoDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Docentes docentes = new Docentes();
            }
        });
        nuevoCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cursos cursos = new Cursos();
            }
        });
        listadoDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Listado_docente ListaD = new Listado_docente();


            }
        });

        listadoEstudiantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Listado_Estudiantes listaE = new Listado_Estudiantes();
            }
        });
        listadoCursosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Listado_cursos listaC = new Listado_cursos();
            }
        });
        nuevaEscuelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Escuelas escuelas = new Escuelas();
            }
        });
        listadoEscuelasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListadoEscuelas listaEscu = new ListadoEscuelas();
            }
        });
        servidorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio_sesion inicioSesion = new Inicio_sesion();
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
    public void select (){
        String sqlprod = "SELECT a.Nombre,a.Apellido,a.Dni,b.Nombre,b.Descripcion from estudiantes a inner join cursos b on a.id_curso = b.id_cursos order by a.Apellido";

        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement (sqlprod);
            rs = ps.executeQuery();

            ResultSetMetaData resul = rs.getMetaData();
            int CantidadColumnas = resul.getColumnCount();
            dtm.setColumnIdentifiers(Rellenado_tabla);
            while(rs.next()){
                Object[] filas= new Object[CantidadColumnas];

                for (int i = 0; i<CantidadColumnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                dtm.addRow(filas);
            }
            table1.setModel(dtm);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

//corregir cancelar de inscripciones
//habilitar botones de cierrte
//quitar verificacion dni
//llenar la base de datos 
//implementar modificacion y eliminaciones
//implementar formato pdf

