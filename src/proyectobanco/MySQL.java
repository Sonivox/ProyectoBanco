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
    
    /*METODO PARA LA CONEXION CON LA BASE DE DATOS:
    se usa el driver de java para concetarce y se le pasan los
    datos del servidor, usuario y contraseña luego tira 
    un MessagDialog para confimar la conexion o sino se
    resulta algun error se redirecionar al catch*/
    public void MySQLConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cajero", "root", "");
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
    
    /*INSERTAR DATOS EN LA TABLA DE DATOS */
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
    
    /* METODO PARA LAS CONSULTAS DE TODOS LOS CLIENTES */
    public void getValues (){
        try {
            String Query = "SELECT * FROM clientes, cuentas , tajeta";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println(" ID: " + resultSet.getString("IDCli")
                        + "\n DUI: " + resultSet.getString("DUICli")
                        + "\n Nombre: " + resultSet.getString("nombreCli") + " " + resultSet.getString("apellidoCli")
                        + "\n Correo: " + resultSet.getString("correoCli")
                        + "\n Telefono: " + resultSet.getString("telefonoCli")
                        + "\n Numero de cuenta: " + resultSet.getString("numeroCu")
                        + "\n Tipo de cuuenta: " +  resultSet.getString("tipoCu")
                        + "\n Saldo de la cuenta: " + resultSet.getString("saldoCu")
                        + "\n Numero de tarjeta: " + resultSet.getString("numeroTar")
                        + "\n Fecha de expiracion de la tarjeta: " + resultSet.getString("expiraTar"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    
    /*METODO PARA CONSULTAR UN SOLO CLIENTE */
    public void validarUsuario(int tarjeta, int pin){
        try{

            String Query = "SELECT * FROM tajeta where numeroTar='"+ tarjeta+"'"+" and PINTar='"+ pin+"';";
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery(Query);
            if( rs.first() ){
                JOptionPane.showMessageDialog(null, "BIENBENIDO");
            }
            else{
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO VALIDOS");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
