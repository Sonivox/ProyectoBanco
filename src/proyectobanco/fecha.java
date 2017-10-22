package proyectobanco;
import java.util.Calendar;

public class fecha {
    private Calendar ahora = Calendar.getInstance();
    private int hora = ahora.get(Calendar.HOUR_OF_DAY);
    private int minuto = ahora.get(Calendar.MINUTE);
    private int mes = ahora.get(Calendar.MONTH) + 1;
    private int dia = ahora.get(Calendar.DAY_OF_MONTH);
    private int año = ahora.get(Calendar.YEAR);
    public String fecha, nombre = null;
    
    public void fecha(){
        switch(mes){
            case 1:
                nombre = "Enero";
                break;
            case 2:
                nombre = "Febrero";
                break;
            case 3:
                nombre = "Marzo";
                break;
            case 4:
                nombre = "Abril";
                break;
            case 5:
                nombre = "Mayo";
                break;
            case 6:
                nombre = "Junio";
                break;
            case 7:
                nombre = "Julio";
                break;
            case 8:
                nombre = "Agosto";
                break;
            case 9:
                nombre = "Septiembre";
                break;
            case 10:
                nombre = "Octubre";
                break;
            case 11:
                nombre = "Noviembre";
                break;
            case 12:
                nombre = "Diciembre";
                break;
        }
        fecha = (hora + " : " + minuto + " P.M." + " del " +  dia + " de " + nombre +" / " + año );
    }
}
