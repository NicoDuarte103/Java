import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

    ConexionDB(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/supermercado?&useSSL=false&serverTimezone=UTC";
        String use ="root";
        String pass = "root";
        Connection con;
        Statement stmt;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, use, pass);
            if (!con.isClosed()) {
                System.out.println("conexion exitosa");
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
        }



    }
