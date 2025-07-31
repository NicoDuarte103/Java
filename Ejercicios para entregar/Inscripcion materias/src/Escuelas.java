import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Escuelas {
    private JTextField NombreEscuela;
    private JButton AceptarEscuela;
    private JTextField DireccionEscuela;
    private JPanel panel1;
    private Connection con;
    private Statement statement;

    public Escuelas(){


        conexion();
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        AceptarEscuela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexion();
                insert();
            }
        });
    }

    public void conexion(){
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "root";
        String pass = "";

        try {
            Class.forName(Driver);
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
    public void insert(){

        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("insert into institucion (Nombre,Direccion,Visible) values (?,?,?) ");

            ps.setString(1,NombreEscuela.getText());
            ps.setString(2,DireccionEscuela.getText());
            ps.setString(3,"1");


            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

