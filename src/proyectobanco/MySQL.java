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
    private String usuario = "root";
    private String contra = "";
    
    //METODO PARA LA CONEXION CON LA BASE DE DATOS
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
    
    //CERRAR LA CONEXION CON LA BASE DE DATOS
    public void cerrarConnection(){
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //INSERTAR DATOS EN LA TABLA DE DATOS
    public void insertData(String nombre, String apellido, String DUI, String correo, String telefono) {
        try {
            String Query = "INSERT INTO clientes" + " VALUES("
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
    }
    
    //METODO PARA LAS CONSULTAS DE TODOS LOS CLIENTES 
    public void getValues (){
        try {
            String Query = "SELECT * FROM clientes";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("DUI: " + resultSet.getString("DUI_cli")
                        + "\n Nombre: " + resultSet.getString("nombre_cliente") + resultSet.getString("apellido_cliente")
                        + "\n Correo: " + resultSet.getString("correo_cliente")
                        + "\n Telefono: " + resultSet.getString("telefono_cliente"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    
    //METODO PARA CONSULTAR UN SOLO CLIENTE
    public void validarUsuario(){
    }
}
