import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Cursos {
    private JTextField NombreCursos;
    private JTextArea DescripcionCusos;
    private JButton aceptarButton;
    private JLabel InscripcionLabel;
    private JPanel Panel1;
    private JComboBox Institucion;
    private JComboBox Anio_lectivo;
    private Connection con;
    private Statement statement;
    private DefaultComboBoxModel comboinstitucion = new DefaultComboBoxModel();
    private DefaultComboBoxModel comboanio = new DefaultComboBoxModel();


    public Cursos() {


        Conexion();
        selectinstitucion();
        selectanio();
        JFrame frame = new JFrame();
        frame.setContentPane(Panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int TamanioCursos = NombreCursos.getText().length();
                if (TamanioCursos> 2){
                    InscripcionLabel.setForeground(Color.GREEN);
                    InscripcionLabel.setText("inscripcion Exitosa");

                }
                else {
                    InscripcionLabel.setForeground(Color.RED);
                    InscripcionLabel.setText("Error");

                }
                insert();
            }


        });
        Institucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void Conexion() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "root";
        String pass = "";
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

    public  void selectinstitucion(){
        String sqlprod = "select Nombre from institucion where Visible = 1";

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;
        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while (rs.next()){
                comboinstitucion.addElement(rs.getString(1));


            }
            Institucion.setModel(comboinstitucion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void selectanio(){
        String sqlprod = "select Anio from ciclo_lectivo";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData resul = null;

        try{
            ps = con.prepareStatement(sqlprod);
            rs = ps.executeQuery();
            resul = rs.getMetaData();
            while (rs.next()){
                comboanio.addElement(rs.getString(1));



            }
            Anio_lectivo.setModel(comboanio);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void insert(){
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into cursos(Nombre,Descripcion,id_institucion,id_ciclo,Visible)VALUES(?,?,?,?,?);");

            ps.setString(1,NombreCursos.getText());
            ps.setString(2,DescripcionCusos.getText());
            ps.setString(3, String.valueOf(Institucion.getSelectedIndex()+1));
            ps.setString(4,String.valueOf(Anio_lectivo.getSelectedIndex()+1));
            ps.setString(5,"1");

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
//hacer select a los combo
//hacer el setmodel
//pasar el index del combo como parametro en un insert