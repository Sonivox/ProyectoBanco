package proyectobanco;
import java.sql.CallableStatement;
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
    public String saldo = "";
    String Query;
    /*METODO PARA LA CONEXION CON LA BASE DE DATOS:
    se usa el driver de java para concetarce y se le pasan los
    datos del servidor, usuario y contraseña luego tira 
    un MessagDialog para confimar la conexion o sino se
    resulta algun error se redirecionar al catch*/
    public void MySQLConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cajero", "root", "");
            JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*CERRAR LA CONEXION CON LA BASE DE DATOS:
    cierra la conexion cuando el usuario termine*/
    public void cerrarConnection(){
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión");
            saldo = "";
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*INSERTAR DATOS EN LA TABLA DE DATOS */
    public void insertCliente(String nombre, String apellido, String DUI, String correo, String telefono) {
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
    public void getValores(){
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
    
    /*METODO PARA VALIDAR CLIENTE:
    busca el numero de tarjeta del cliente y si es igual al numero de tarjeta
    y sin PIN coincide le deja pasar al menu*/
    public void validarUsuario(String tarjeta, int pin){
        try{
            String Query = "SELECT * FROM tajeta where numeroTar='"+ tarjeta +"'"+" and PINTar='"+ pin+"';";
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery(Query);
            if( rs.first() ){
                JOptionPane.showMessageDialog(null, "BIENBENIDO");
                /*menu m = new menu();
                cajero c = new cajero();
                m.setVisible(true);
                c.setVisible(false); */
            }
            else{
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO VALIDOS");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRROR EN EL PROCEDIMIENTO");
        }
    }
    /*METODO PARA SACAR DINERO DE LA CUENTA:
    lo que hace el metodo es a traves de la conexion a la base de datos restarle
    a la cantidad que tiene en el SALDO DE LA CUENTA lo que desea retirar mediante
    un procedimiento almacenado en MySQL*/
    public void retiroDinerio(int cantidad, int cuenta){
        try{
            CallableStatement proc = Conexion.prepareCall(" CALL retirar_dinero(?,?) ");
            proc.setInt("cantidad",cantidad);
            proc.setInt("idcu", cuenta);
            proc.execute();
            JOptionPane.showMessageDialog(null, "RETIRO EFECTUADO CON EXITO DE: $"+ cantidad);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSACCION");
        }
    }
    
    /*METODO PARA DEPOSITAR DINERO: 
    lo que hace es lo inverso de retirar dinero solo que en esta ves lo suma
    a la cantidad que tiene en el SALDO DE LA CUENTA*/
    public void depositarDinero(int cantidad, int cuenta){
        try{
            CallableStatement proc = Conexion.prepareCall("CALL depositar_dinero(?,?)");
            proc.setInt("cantidad", cantidad);
            proc.setInt("idcu", cuenta);
            proc.execute();
            JOptionPane.showMessageDialog(null, "DEPOSITO EFECTUADO CON EXITO DE: $"+ cantidad);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSSACION");
        }
    }
    
    /*METODO PARA VER EL SALDO: */
    public void  consultarSaldo(int numero){
        try{
            String Query = "SELECT saldoCu FROM cuentas WHERE numeroCu =" + numero;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            resultSet.first();
            saldo = resultSet.getString("saldoCu");
            
            JOptionPane.showMessageDialog(null, "CONSULTA EXITOSA ");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA");
        }
    }
}