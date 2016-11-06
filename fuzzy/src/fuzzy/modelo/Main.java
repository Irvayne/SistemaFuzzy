package fuzzy.modelo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<VariavelLinguistica> conjuntosDeEntradas = new ArrayList<VariavelLinguistica>();
		VariavelLinguistica conjuntoDeSaida = null;
		List<Regra> regras = new ArrayList<Regra>();
		List<Double> entradas = new ArrayList<Double>();

		List<Ponto> pontos = new ArrayList<Ponto>();

		pontos.add(new Ponto(0, 3));
		pontos.add(new Ponto(1, 4));
		pontos.add(new Ponto(1, 7));

		Conjunto conjuntoMedio = new Conjunto("Medio", pontos, 0);

		List<Ponto> pontosBaixo = new ArrayList<Ponto>();

		pontosBaixo.add(new Ponto(1, 0));
		pontosBaixo.add(new Ponto(1, 3));
		pontosBaixo.add(new Ponto(0, 4));

		Conjunto conjunto = new Conjunto("Baixo", pontosBaixo, 0);
		List<Conjunto> conjuntos = new ArrayList<Conjunto>();

		conjuntos.add(conjunto);
		conjuntos.add(conjuntoMedio);

		VariavelLinguistica linguistica = new VariavelLinguistica("Temperatura", conjuntos);
		conjuntosDeEntradas.add(linguistica);

		List<Ponto> pontosSaida = new ArrayList<Ponto>();

		pontosSaida.add(new Ponto(0, 1));
		pontosSaida.add(new Ponto(1, 2));
		pontosSaida.add(new Ponto(0, 3));

		Conjunto conjuntoMedioSaida = new Conjunto("Baixo", pontosSaida, 0);
		List<Conjunto> conjuntosMedios = new ArrayList<Conjunto>();
		
		conjuntosMedios.add(conjuntoMedioSaida);
 		conjuntoDeSaida = new VariavelLinguistica("Pressao", conjuntosMedios);

 		entradas.add(3.5);

		Fuzzy fuzzy = new Fuzzy(conjuntosDeEntradas, conjuntoDeSaida, regras, entradas);
		
		fuzzy.fuzzyficacao();
		
		for(Conjunto c: fuzzy.getConjuntoDeEntradas().get(0).getConjuntos()){
			System.out.println(c.getNome()+" - "+c.getPertinencia());
		}
		
		
		Conjunto c1 = new Conjunto("Temperatura-Baixo");
		Conjunto c2 = new Conjunto("Temperatura-Medio");
		
		
		Regra r = new Regra(new ArrayList<Conjunto>(), new Conjunto("Pressao-Baixo"));
		r.getAntecedentes().add(c1);
		
		fuzzy.getRegras().add(r);
		
		Regra r1 = new Regra(new ArrayList<Conjunto>(), new Conjunto("Pressao-Baixo"));
		r1.getAntecedentes().add(c2);
		fuzzy.getRegras().add(r1);
		
		fuzzy.ativarRegras();
		
		//for(Conjunto c:r.getAntecedentes())
			//System.out.print(" se "+c.getNome()+" - "+c.getPertinencia() +" e");
		//System.out.print("ntao "+ fuzzy.getRegras().get(0).getConsequente().getNome() +" "+ fuzzy.getRegras().get(0).getConsequente().getPertinencia());
		
		for(Regra re: fuzzy.getRegras()){
			for(Conjunto con:re.getAntecedentes() )
				System.out.print(" se "+con.getNome()+" - "+con.getPertinencia() +" e");
			System.out.println(re.getConsequente().getNome() + " - "+re.getConsequente().getPertinencia());
		}
	
		fuzzy.agregarConjuntos();
		for(Regra re: fuzzy.getRegras()){
			System.out.println(re.getConsequente().getNome() + " - "+re.getConsequente().getPertinencia());
		}
		
		fuzzy.novoConjunto();
		for(Regra re: fuzzy.getRegras()){
		for(Ponto p:re.getConsequente().getPontos()){
			System.out.print(p.getPertinencia()+" / "+p.getValor()+" + ");
		}
		
		}
		//fuzzy.defuzzyficacaoTipoMaximo();
		fuzzy.defuzzyTipoCentroide();
	}
}
