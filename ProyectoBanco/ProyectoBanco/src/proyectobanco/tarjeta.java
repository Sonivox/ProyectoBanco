package proyectobanco;
public class tarjeta extends cuenta{
    private int numTar;
    private String fechaEx;
    
    public void setTarjeta(int tarjeta){
        this.numTar = tarjeta;
    }
    public int getTarjeta(){
        return this.numTar;
    }
    public void setFecha(String fecha){
        this.fechaEx = fecha;
    }
    public String getFecha(){
        return this.fechaEx;
    }
}
