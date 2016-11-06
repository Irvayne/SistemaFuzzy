package fuzzy.modelo;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {

	private String nome;
	private List<Ponto> pontos = new ArrayList<Ponto>();
	private double pertinencia;
	
	public Conjunto(String nome){
		this.nome = nome;
		pertinencia = 0.0;
	}
	
	public Conjunto(String nome, List<Ponto> pontos, double pertinencia) {
		this.nome = nome;
		this.pontos = pontos;
		this.pertinencia = pertinencia;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Ponto> getPontos() {
		return pontos;
	}
	
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	public double getPertinencia() {
		return pertinencia;
	}
	
	public void setPertinencia(double pertinencia) {
		this.pertinencia = pertinencia;
	}
}