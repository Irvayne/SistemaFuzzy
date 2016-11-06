package fuzzy.modelo;

public class Ponto {

	private double pertinencia;
	private double valor;	
	
	public Ponto(double pertinencia, double valor) {
		this.pertinencia = pertinencia;
		this.valor = valor;
	}

	public double getPertinencia() {
		return pertinencia;
	}
	
	public void setPertinencia(double pertinencia) {
		this.pertinencia = pertinencia;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}