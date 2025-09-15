package hortas;

public class Plantacao {
	public String dataSementeira;
	public String tipoCultura;

	public Plantacao(String dataSementeira, String tipoCultura) {
		this.dataSementeira = dataSementeira;
		this.tipoCultura = tipoCultura;
	}

	public String getDataSementeira() {
		return dataSementeira;
	}

	public void setDataSementeira(String dataSementeira) {
		this.dataSementeira = dataSementeira;
	}

	public String getTipoCultura() {
		return tipoCultura;
	}

	public void setTipoCultura(String tipoCultura) {
		this.tipoCultura = tipoCultura;
	}

	@Override
	public String toString() {
		return "Plantacao [dataSementeira=" + dataSementeira + ", tipoCultura=" + tipoCultura + "]";
	}
	
	
}
