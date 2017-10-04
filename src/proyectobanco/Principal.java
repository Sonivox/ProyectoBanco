package proyectobanco;
import java.sql.SQLException;

/*AUTORES:
Roberto Herberth Maltez Guardado
Ronald Remberto Rivas Rodirigues */

public class Principal {
    public static void main(String[] args) throws SQLException {
        new Thread(new splash()).start();
    }
}
