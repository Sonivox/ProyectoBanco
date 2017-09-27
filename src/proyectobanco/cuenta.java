package proyectobanco;
public class cuenta extends clientes{
    private int numCu;
    private String tipoCu;
    private double saldoCu;
    
    public void setNumeroCuenta(int cuenta){
        this.numCu = cuenta;
    }
    public int getNumeroCuenta(){
        return this.numCu;
    }
    public void setTipoCuenta(String tipo){
        this.tipoCu = tipo;
    }
    public String getTipoCuenta(){
        return this.tipoCu;
    }
    public void setSaldo(double saldo){
        this.saldoCu = saldo;
    }
    public double getSaldo(){
        return this.saldoCu;
    }
    
}
