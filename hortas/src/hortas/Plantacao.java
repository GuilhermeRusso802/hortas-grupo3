package hortas;

import java.time.LocalDate;

class Plantacao {
    private LocalDate dataSementeira;
    private String tipoCultura;
    
    public Plantacao(LocalDate dataSementeira, String tipoCultura) {
        this.dataSementeira = dataSementeira;
        this.tipoCultura = tipoCultura;
    }
    
    public LocalDate getDataSementeira() { return dataSementeira; }
    public String getTipoCultura() { return tipoCultura; }
    
    @Override
    public String toString() {
        return "Plantação{" + "dataSementeira=" + dataSementeira + 
               ", tipoCultura='" + tipoCultura + '\'' + '}';
    }
}