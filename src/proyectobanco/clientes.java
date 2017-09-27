package proyectobanco;
public class clientes {
    private String nomUsu;
    private String apeUsu;
    private int DUIU;
    private String corrUsu;
    private int telUsu;
    
    public void setNomUsu(String nomUsu){
        this.nomUsu = nomUsu;
    }
    public String getNomUsu(){
        return this.nomUsu;
    }
    public void setApeUsu(String apeUsu){
        this.apeUsu = apeUsu;
    }
    public String getApeUsu(){
        return this.apeUsu;
    }
    public void setDUI(int DUI){
        this.DUIU = DUI;
    }
    public int getDUI(){
        return this.DUIU;
    }
    public void setCorreo(String correo){
        this.corrUsu = correo;
    }
    public String getCorreo(){
        return this.corrUsu;
    }
    public void setTelefono(int telefono){
        this.telUsu = telefono;
    }
    public int getTelefono(){
        return this.telUsu;
    }
    
    
}
