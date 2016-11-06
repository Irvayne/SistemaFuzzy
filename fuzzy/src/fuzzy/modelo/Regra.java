package fuzzy.modelo;

import java.util.ArrayList;
import java.util.List;

public class Regra {
	
	private List<Conjunto> antecedentes = new ArrayList<Conjunto>();
	private Conjunto consequente;
	
	public Regra(List<Conjunto> antecedentes, Conjunto consequente) {
		this.antecedentes = antecedentes;
		this.consequente = consequente;
	}

	public List<Conjunto> getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(List<Conjunto> antecedentes) {
		this.antecedentes = antecedentes;
	}

	public Conjunto getConsequente() {
		return consequente;
	}

	public void setConsequente(Conjunto consequente) {
		this.consequente = consequente;
	}
}