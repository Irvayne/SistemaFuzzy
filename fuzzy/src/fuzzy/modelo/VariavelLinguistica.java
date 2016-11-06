package fuzzy.modelo;

import java.util.ArrayList;
import java.util.List;

public class VariavelLinguistica {

	private String nome;
	private List<Conjunto> conjuntos = new ArrayList<Conjunto>();
	
	public VariavelLinguistica() {
		
	}

	public VariavelLinguistica(String nome, List<Conjunto> conjuntos) {
		this.nome = nome;
		this.conjuntos = conjuntos;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Conjunto> getConjuntos() {
		return conjuntos;
	}
	
	public void setConjuntos(List<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}
}