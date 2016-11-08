package fuzzy.modelo;

import java.util.ArrayList;
import java.util.List;

public class Fuzzy {

	private List<VariavelLinguistica> conjuntoDeEntradas = new ArrayList<VariavelLinguistica>();
	private VariavelLinguistica conjuntoDeSaida;
	private List<Regra> regras = new ArrayList<Regra>();
	private List<Double> entradas = new ArrayList<Double>();

	public Fuzzy() {
		this.conjuntoDeEntradas = new ArrayList<VariavelLinguistica>();
		this.regras = new ArrayList<Regra>();
		this.entradas = new ArrayList<Double>();
	}

	public Fuzzy(List<VariavelLinguistica> conjuntoDeEntradas,
			VariavelLinguistica conjuntoDeSaida, List<Regra> regras,
			List<Double> entradas) {
		this.conjuntoDeEntradas = conjuntoDeEntradas;
		this.conjuntoDeSaida = conjuntoDeSaida;
		this.regras = regras;
		this.entradas = entradas;
	}

	public List<VariavelLinguistica> getConjuntoDeEntradas() {
		return conjuntoDeEntradas;
	}

	public void setConjuntoDeEntradas(List<VariavelLinguistica> conjuntoDeEntradas) {
		this.conjuntoDeEntradas = conjuntoDeEntradas;
	}

	public VariavelLinguistica getConjuntoDeSaida() {
		return conjuntoDeSaida;
	}

	public void setConjuntoDeSaida(VariavelLinguistica conjuntoDeSaida) {
		this.conjuntoDeSaida = conjuntoDeSaida;
	}

	public List<Regra> getRegras() {
		return regras;
	}

	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}

	public List<Double> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Double> entradas) {
		this.entradas = entradas;
	}

	public void defuzzyTipoCentroide(){

		List<Conjunto> aux = new ArrayList<Conjunto>();

		//removendo os conjunto com pertinencia igual a zero
		for (int i = 0; i < conjuntoDeSaida.getConjuntos().size(); i++) {
			if (conjuntoDeSaida.getConjuntos().get(i).getPertinencia() != 0) {
				aux.add(conjuntoDeSaida.getConjuntos().get(i));
			}
		}		

		List<Ponto> pontosParaCalculo = new ArrayList<>();
		for(int c1 = 0; c1 < aux.size();c1++){									
			for(int p1 =0; p1 < aux.get(c1).getPontos().size();p1++){
				Ponto verificado = aux.get(c1).getPontos().get(p1);
				if(verificado.getPertinencia() > 0){
					if(aux.size()==1){
						pontosParaCalculo.add(verificado);
					}else{
						for(int c2 = 0;c2 < aux.size();c2++){
							if(c1!=c2){
								forDeDentro: for(int p2 =0; p2 < aux.get(c2).getPontos().size() - 1;p2++){
									Ponto intervalo1 = aux.get(c2).getPontos().get(p2);
									if(intervalo1.getPertinencia() > 0){
										Ponto intervalo2 = aux.get(c2).getPontos().get(p2+1);										
										if(verificado.getValor() >= intervalo1.getValor() && verificado.getValor() <= intervalo2.getValor()){
											if(verificado.getPertinencia() > intervalo1.getPertinencia()){
												pontosParaCalculo.add(verificado);
												break forDeDentro;
											}
										}else{
											pontosParaCalculo.add(verificado);
											break forDeDentro;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		double valorMaisPertinecia = 0;
		double pertinencia = 0;
		for(Ponto p :pontosParaCalculo){
			valorMaisPertinecia = valorMaisPertinecia + (p.getPertinencia()*p.getValor());
			pertinencia = pertinencia + p.getPertinencia(); 
		}
		System.out.println("\n Valor Centroide = "+(valorMaisPertinecia/pertinencia));
	}

	public void defuzzyficacaoTipoMaximo(){
		double valorMaior = 0;
		double pertinenciaMaior = 0;
		for(Regra r: regras){
			for(Ponto p: r.getConsequente().getPontos()){
				if(p.getPertinencia() > pertinenciaMaior && p.getValor() < valorMaior){
					pertinenciaMaior = p.getPertinencia();
					valorMaior = p.getValor();
				}
			}
		}
		System.out.println("\nValor Maior "+valorMaior);
	}

	public void novoConjunto(){
		for(Regra r : regras){
			for(Conjunto c : conjuntoDeSaida.getConjuntos()){
				String[] teste = r.getConsequente().getNome().split("-");
				if(teste[1].equals(c.getNome()) && r.getGrauDeAtivacao() > 0){
					//distribuindo os pontos normalmente
					r.getConsequente().setPontos(c.getPontos());
					c.setPertinencia(r.getGrauDeAtivacao());

					//dois pontos
					if(r.getConsequente().getPontos().size() == 2){
						if(r.getConsequente().getPontos().get(0).getPertinencia()==1){
							r.getConsequente().getPontos().get(0).setPertinencia(r.getGrauDeAtivacao());
							Ponto p = new Ponto(r.getConsequente().getPontos().get(1).getPertinencia(),r.getConsequente().getPontos().get(1).getValor());
							r.getConsequente().getPontos().add(p);
							r.getConsequente().getPontos().get(1).setPertinencia(r.getGrauDeAtivacao());
							double x = r.getConsequente().getPontos().get(2).getValor() - r.getConsequente().getPontos().get(2).getValor() * r.getGrauDeAtivacao() ;
							r.getConsequente().getPontos().get(1).setValor(x);
						}else if(r.getConsequente().getPontos().get(1).getPertinencia()==1){

							r.getConsequente().getPontos().get(1).setPertinencia(r.getGrauDeAtivacao());
							Ponto p = new Ponto(r.getConsequente().getPontos().get(1).getPertinencia(),r.getConsequente().getPontos().get(1).getValor());
							r.getConsequente().getPontos().add(p);
							r.getConsequente().getPontos().get(1).setPertinencia(r.getGrauDeAtivacao());
							double x = (r.getConsequente().getPontos().get(2).getValor() - r.getConsequente().getPontos().get(0).getValor()) * r.getGrauDeAtivacao() +  r.getConsequente().getPontos().get(0).getValor();
							r.getConsequente().getPontos().get(1).setValor(x);
						}
						//tres pontos
					}else if(r.getConsequente().getPontos().size() == 3){
						// os dois primeiros pontos tem valor 1
						if(r.getConsequente().getPontos().get(0).getPertinencia()==1 && r.getConsequente().getPontos().get(1).getPertinencia()==1){
							r.getConsequente().getPontos().get(0).setPertinencia(r.getGrauDeAtivacao());

							double x2 = r.getConsequente().getPontos().get(2).getValor() - (r.getConsequente().getPontos().get(2).getValor() - r.getConsequente().getPontos().get(1).getValor()) * r.getGrauDeAtivacao();	
							Ponto p2 = new Ponto(r.getGrauDeAtivacao(), x2);

							r.getConsequente().getPontos().get(1).setPertinencia(p2.getPertinencia());
							r.getConsequente().getPontos().get(1).setValor(p2.getValor());
							//os 2 ultmos tem valor 1
						}else if(r.getConsequente().getPontos().get(1).getPertinencia()==1 && r.getConsequente().getPontos().get(2).getPertinencia()==1){

							double x1 = (r.getConsequente().getPontos().get(1).getValor() - r.getConsequente().getPontos().get(0).getValor()) * r.getGrauDeAtivacao() + r.getConsequente().getPontos().get(0).getValor();
							Ponto p1 = new Ponto(r.getGrauDeAtivacao(), x1);

							r.getConsequente().getPontos().get(1).setPertinencia(p1.getPertinencia());
							r.getConsequente().getPontos().get(1).setValor(p1.getValor());

							r.getConsequente().getPontos().get(2).setPertinencia(r.getGrauDeAtivacao());
							r.getConsequente().getPontos().get(2).setValor(r.getConsequente().getPontos().get(2).getValor());

						}else{
							//so o do meio tem valor 1
							double x1 = (r.getConsequente().getPontos().get(1).getValor() - r.getConsequente().getPontos().get(0).getValor()) * r.getGrauDeAtivacao() + r.getConsequente().getPontos().get(0).getValor();
							Ponto p1 = new Ponto(r.getGrauDeAtivacao(), x1);
							double x2 = r.getConsequente().getPontos().get(2).getValor() - (r.getConsequente().getPontos().get(2).getValor() - r.getConsequente().getPontos().get(1).getValor()) * r.getGrauDeAtivacao();	
							Ponto p2 = new Ponto(r.getGrauDeAtivacao(), x2);

							r.getConsequente().getPontos().get(1).setPertinencia(p1.getPertinencia());
							r.getConsequente().getPontos().get(1).setValor(p1.getValor());

							Ponto aux = new Ponto(r.getConsequente().getPontos().get(2).getPertinencia(), r.getConsequente().getPontos().get(2).getValor());
							r.getConsequente().getPontos().add(aux);
							r.getConsequente().getPontos().get(2).setPertinencia(p2.getPertinencia());
							r.getConsequente().getPontos().get(2).setValor(p2.getValor());
							//quatro pontos
						}}else if(r.getConsequente().getPontos().size() == 4){
							double x1 = (r.getConsequente().getPontos().get(1).getValor() - r.getConsequente().getPontos().get(0).getValor()) * r.getGrauDeAtivacao() + r.getConsequente().getPontos().get(0).getValor();
							r.getConsequente().getPontos().get(1).setPertinencia(x1);
							double x2 = r.getConsequente().getPontos().get(3).getValor() - (r.getConsequente().getPontos().get(3).getValor() - r.getConsequente().getPontos().get(2).getValor()) * r.getGrauDeAtivacao();	
							r.getConsequente().getPontos().get(2).setPertinencia(x2);
						}
				}

			}
		}

	}
	/**
	 * Caso mais de uma regra com o mesmo consequente seja ativada, 
	 * eh eliminada aquela regra que possui o menor grau de ativacao
	 */
	public void agregarConjuntos(){
		List<Regra> regrasRemover = new ArrayList<Regra>();		
		for(int i =0; i< regras.size();i++){
			for(int j = 0; j<regras.size(); j++){
				if(i!=j){
					if(regras.get(i).getConsequente().getNome().equals(regras.get(j).getConsequente().getNome())){
						if(regras.get(i).getGrauDeAtivacao() >= regras.get(j).getGrauDeAtivacao()){
							regrasRemover.add(regras.get(j));							
						}
					}
				}
			}
		}
		for(Regra r : regrasRemover){
			regras.remove(r);
		}

	}
	/**
	 * Percorre todas as regras para configurar seu grau de ativacao
	 */
	public void ativarRegras(){
		for(Regra r: regras){
			for(int i = 0; i < r.getAntecedentes().size(); i++){

				//temperatura-baixa
				String[] aux = r.getAntecedentes().get(i).getNome().split("-");
				for(int j =0;j< conjuntoDeEntradas.size(); j++){
					if(aux[0].equals(conjuntoDeEntradas.get(j).getNome())){
						for(Conjunto c: conjuntoDeEntradas.get(j).getConjuntos()){
							if(aux[1].equals(c.getNome())){
								r.getAntecedentes().get(i).setPertinencia(c.getPertinencia());

							}
						}
					}
				}


			}
			double menor = 10.0;
			for(Conjunto c:r.getAntecedentes()){
				if(c.getPertinencia() < menor){
					menor = c.getPertinencia();
					r.setGrauDeAtivacao(menor);
				}
			}

		}
	}

	public void fuzzyficacao(){
		//encontra a pertinencia de cada entrada para cada conjunto de cada variavel de entrada fuzzy
		for(int i = 0; i < entradas.size(); i++){
			for(Conjunto c : conjuntoDeEntradas.get(i).getConjuntos()){
				if(c.getPontos().get(0).getValor() <= entradas.get(i) && c.getPontos().get(c.getPontos().size() - 1).getValor() >= entradas.get(i) ){
					for(int j = 0; j < c.getPontos().size(); j++){
						//caso o valor seja igual ao valor definido no conjunto
						if(c.getPontos().get(j).getValor()==entradas.get(i)){
							//seta o valor da pertinencia desse elemento no conjunto com valor do ponto
							c.setPertinencia(c.getPontos().get(j).getPertinencia());
							break;
						}else if(c.getPontos().get(j).getValor() > entradas.get(i)){
							if(c.getPontos().get(j).getPertinencia() == 1 && c.getPontos().get(j-1).getPertinencia() == 1){
								c.setPertinencia(1);
								break;
							}else{
								if(j-1>=0){
									if(c.getPontos().get(j).getPertinencia() < c.getPontos().get(j-1).getPertinencia()){
										double modB = Math.abs(entradas.get(i) - c.getPontos().get(j).getValor());
										double modb = Math.abs(c.getPontos().get(j).getValor() - c.getPontos().get(j-1).getValor());
										c.setPertinencia((modB)/(modb));
										break;
									}else{

										double modB = Math.abs(entradas.get(i) - c.getPontos().get(j-1).getValor());
										double modb = Math.abs(c.getPontos().get(j).getValor() - c.getPontos().get(j-1).getValor());
										c.setPertinencia((modB)/(modb));
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}
}