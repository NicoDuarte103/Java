import sql
public class Main {
    public static void main(String[] args) {
        Connection con;// creo una variable de tipo conexión para luego realizarla
        public void conectar() throws SQLException {
            String driver = "com.mysql.cj.jdbc.Driver";// guardo el driver de la conexión en una
            variable
            String url =
                    "jdbc:mysql://localhost:3306/comercial?useSSL=false&serverTimezone=UTC&allowPub
            licKeyRetrieval=true"; //guardo en una variable la ruta de la base de datos “localhost” y
            el puerto 3306, luego agrego el nombre de la base de datos “negocio”
            String user = "root"; //guardo en una variable el usuario para acceder a la base de
            datos
            String password = "root"; //guardo en una variable el contraseña para acceder a la
            base de datos
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password); //ejecuto la conexión y
                la guardo en la variable con
                if (!con.isClosed()) {// sin la conexión no esta cerrada muestra “conexión
                    exitosa”
                    System.out.println("Conexión exitosa");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}