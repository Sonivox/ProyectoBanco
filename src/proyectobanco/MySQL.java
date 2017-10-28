package proyectobanco;
import static java.lang.Integer.parseInt;
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
    
    //VARIABLES PARA CONEXION Y CONSULTAS A LA BASE DE DATOS "CAJERO"
    private static Connection Conexion;
    String Query;
    
    /*VARIABLES PUBLICAS PARA GUARDAR LA INFORMACION DEL USUARIO DE
      DE LA BASE DE DATOS "CAJERO" Y LAS TABLAS CUENTAS Y TARJETA */
    public static String saldo = "";
    public static String cuenta = "";
    public static String ID = "";
    public static String nombre = "";
    public static String apellido = "";
    public static String tarjeta = "";
    public static String expira = "";
    public static String operacion= "";
    public static String cantidad = "";
    
    /*METODO PARA LA CONEXION CON LA BASE DE DATOS:
    se usa el driver de java para concetarce y se le pasan los
    datos del servidor, usuario y contraseña luego tira 
    un MessagDialog para confimar la conexion o sino se
    resulta algun error se redirecionar al catch*/
    public void MySQLConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cajero", "root", "");
            JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión",
            "INICIO DE LA CONEXION CON EL CAJERO",JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión",
            "FIN DE LA CONEXION CON EL CAJERO", JOptionPane.INFORMATION_MESSAGE);
            saldo = "";
            cuenta = "";
            ID = "";
            nombre = "";
            apellido = "";
            tarjeta = "";
            expira = "";
        }
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex  );
        }
    }
    
    /*INSERTAR DATOS EN LA BASE DE DATOS
    public void insertCliente(String nombre, String apellido, String DUI, String correo, String telefono) {
        try {
            Query = "INSERT INTO clientes" + " VALUES("
                    + "\"" + nombre + "\", "
                    + "\"" + apellido + "\", "
                    + "\"" + DUI + "\", "
                    + "\"" + correo + "\", "
                    + "\"" + telefono + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } */
    
    /* METODO PARA LAS CONSULTAS DE TODOS LOS CLIENTES
    public void getValores(){
        try {
            Query = "SELECT * FROM clientes, cuentas , tajeta";
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
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } */
    
    /*METODO PARA VALIDAR CLIENTE:
    busca el numero de tarjeta del cliente y si es igual al numero de tarjeta
    y sin PIN coincide le deja pasar al menu*/
    public void validarUsuario(String num, int pin){
        try{
            Query = "SELECT * FROM tajeta where numeroTar='"+ num +"'"+" and PINTar='"+ pin+"';";
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery(Query);
            if( rs.first() ){
                ID = rs.getString("IDCli");
                cuenta = rs.getString("numeroCu");
                tarjeta = rs.getString("numeroTar");
                expira = rs.getString("expiraTar");
                nombre = rs.getString("nombreCli");
                apellido = rs.getString("apellidoCli");
                
                JOptionPane.showMessageDialog(null, "BIENVENIDO: " + nombre + " " +apellido,
                        "MENSAJE DE EXITO", JOptionPane.INFORMATION_MESSAGE);
                
                menu m = new menu();
                m.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA NO VALIDOS");
                JOptionPane.showMessageDialog(null, "VUELVA HA ABRIR EL PROGRAMA");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRROR EN EL PROCEDIMIENTO", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*METODO PARA SACAR DINERO DE LA CUENTA:
    lo que hace el metodo es a traves de la conexion a la base de datos restarle
    a la cantidad que tiene en el SALDO DE LA CUENTA lo que desea retirar mediante
    un procedimiento almacenado en MySQL*/
    public void retiroDinerio(int monto){
        try{
            CallableStatement proc = Conexion.prepareCall(" CALL retirar_dinero(?,?) ");
            proc.setInt("cantidad",monto);
            proc.setString("idcu", cuenta);
            proc.execute();
            JOptionPane.showMessageDialog(null, "RETIRO EFECTUADO CON EXITO DE: $"+ monto,
            "MENSAJE DE APROVACION", JOptionPane.INFORMATION_MESSAGE);
            operacion = "RETIRO DE EFECTIVO";
            cantidad = Integer.toString(monto);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSACCION", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        //PARA GUARDAR LA TRASACCION
        try{
            fecha f = new fecha();
            f.fecha();
            CallableStatement proc1 = Conexion.prepareCall("CALL insertar_tran(?,?,?,?,?,?) ");
            proc1.setString("tipo", operacion);
            proc1.setString("monto", cantidad);
            proc1.setString("fecha", f.fecha);
            proc1.setString("cuenta", cuenta);
            proc1.setString("nombre", nombre);
            proc1.setString("apellido", apellido);
            proc1.execute();
            JOptionPane.showMessageDialog(null, "SE HA GUARDADO LA TRANSACCION" ,
            "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSSACION", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    /*METODO PARA DEPOSITAR DINERO: 
    lo que hace es lo inverso de retirar dinero solo que en esta ves lo suma
    a la cantidad que tiene en el SALDO DE LA CUENTA*/
    public void depositarDinero(int monto){
        //PARA DEPOSITAR EL DINERO SE LLAMA AL PROCEDIMIENTO ALMACENADO
        try{
            CallableStatement proc = Conexion.prepareCall("CALL depositar_dinero(?,?)");
            proc.setInt("cantidad", monto);
            proc.setString("idcu", cuenta);
            proc.execute();
            JOptionPane.showMessageDialog(null, "DEPOSITO EFECTUADO CON EXITO DE: $"+ monto,
            "MENSAJE APROVACION", JOptionPane.INFORMATION_MESSAGE);
            operacion = "DEPOSITO DE EFECTIVO";
            cantidad = Integer.toString(monto);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSSACION", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
        //PARA GUARDAR LA TRASACCION
        try{
            fecha f = new fecha();
            f.fecha();
            CallableStatement proc1 = Conexion.prepareCall("CALL insertar_tran(?,?,?,?,?,?) ");
            proc1.setString("tipo", operacion);
            proc1.setString("monto", cantidad);
            proc1.setString("fecha", f.fecha);
            proc1.setString("cuenta", cuenta);
            proc1.setString("nombre", nombre);
            proc1.setString("apellido", apellido);
            proc1.execute();
            JOptionPane.showMessageDialog(null, "SE HA GUARDADO LA TRANSACCION" ,
            "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA TRANSSACION", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    /*METODO PARA VER EL SALDO: 
    hace la consulta a la base de datos para obtener
    el saldo de la cuenta segun el cliente que venga*/
    public void  consultarSaldo(){
        try{
            Query = "SELECT saldoCu FROM cuentas WHERE numeroCu =" + cuenta;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            resultSet.first();
            saldo = resultSet.getString("saldoCu");
            
            JOptionPane.showMessageDialog(null, "CONSULTA EXITOSA", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultarTran(){
        try{
            Query = "SELECT * FROM transaccion WHERE numeroCu = '" + cuenta+"'";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet rs;
            rs = st.executeQuery(Query);
            
            while(rs.next()){
            menu.lista.add(" NUMERO DE TRANSACCION: " + rs.getString("numeroTran")+
                   "\n FECHA Y HORA: " + rs.getString("fechaTran")+
                   "\n TIPO DE TRANSSACION: " + rs.getString("tipoTran")+
                   "\n MONTO DE LA TRANSACCION: $"+ rs.getString("montoTran") + "\n\n");
            }
            for(int i = 0; i<menu.lista.size(); i++){
                menu.lista.get(i);
            }
            JOptionPane.showMessageDialog(null, "CONSULTA EXITOSA", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
    
    /*METODO PARA GENERAR EL RECIBO SEGUN LO QUE EL USARIO EN EL CAJERO:
    por si el cliente lo desea se generar un recibo con los datos de la transsacion que hizo*/
    public void recibo(){
        int opcion;
        opcion = JOptionPane.showConfirmDialog(null, "DESEA RECIBO ?", "RECIBO DE TRANSSACION", JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE);
        
        switch(opcion){
            case 0:
                recibo r = new recibo();
                r.setVisible(true);
                break;
            case 1:
                break;
        }
    }
}