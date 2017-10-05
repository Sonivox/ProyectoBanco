package proyectobanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MySQL {

    private Connection conexion;
    
    public Connection getConexion()
    {
        return conexion;
    }
    
    public boolean crearConexion()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
            System.out.println(conexion);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean ejecutarSQL(String sql){
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ResultSet ejecutarSQLSelect(String sql){
        ResultSet resultado;
        try {
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return resultado;
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

    void ejecutarSQL(JTextField jTextField1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void ejecutarSQLSelect(JTextField jTextField1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
