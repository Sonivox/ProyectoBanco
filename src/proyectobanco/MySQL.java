package proyectobanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQL {

    private static Connection Conexion;
    private String servidor = "jdbc:mysql://localhost:3306/banco";
    private String usuario = "root";
    private String contra = "";
    
    public void MySQLConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", usuario, contra);
            JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarConnection(){
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertData(String table, String nombre, String apellido, String DUI, String correo, String telefono) {
        try {
            String Query = "INSERT INTO " + table + " VALUES("
                    + "\"" + nombre + "\", "
                    + "\"" + apellido + "\", "
                    + "\"" + DUI + "\", "
                    + "\"" + correo + "\", "
                    + "\"" + telefono + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    

    
    /*public static void connect(){
        String url = "jdbc:mysql://localhost:3306/banco?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "";
        System.out.println("Conectando...");
        try(Connection connection = DriverManager.getConnection(url, user,pass)){
            System.out.println("Conectado!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }*/
    
    /*Connection conexion = null;
    Statement comando = null;
    ResultSet registro;
    
    public Connection MySQLConnect() {
 
        try {
            //Driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            String servidor = "jdbc:mysql://localhost:3306/banco?zeroDateTimeBehavior=convertToNull";
            //El root es el nombre de usuario por default. No hay contraseña
            String usuario = "root";
            String pass = "";
            //Se inicia la conexión
            conexion = DriverManager.getConnection(servidor, usuario, pass);
 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return conexion;
        }
    }*/
    }
}
