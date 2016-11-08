package fuzzy.run;

import fuzzy.modelo.Conjunto;
import fuzzy.modelo.Fuzzy;
import fuzzy.modelo.Ponto;
import fuzzy.modelo.Regra;
import fuzzy.modelo.VariavelLinguistica;

public class Atividade3 {

	public static void main(String[] args) {

		Fuzzy fuzzy = new Fuzzy();

		//3 variaveis 
		VariavelLinguistica te = new VariavelLinguistica();
		te.setNome("Teor");
		Conjunto c1 = new Conjunto("baixo");
		c1.getPontos().add(new Ponto(1,0));
		c1.getPontos().add(new Ponto(1,2.5));
		c1.getPontos().add(new Ponto(0,10));

		Conjunto c2 = new Conjunto("medio");
		c2.getPontos().add(new Ponto(0,2.5));
		c2.getPontos().add(new Ponto(1,10));
		c2.getPontos().add(new Ponto(0,17.5));

		Conjunto c3 = new Conjunto("alto");
		c3.getPontos().add(new Ponto(0,10));
		c3.getPontos().add(new Ponto(1,17.5));
		c3.getPontos().add(new Ponto(1,20));

		te.getConjuntos().add(c1);
		te.getConjuntos().add(c2);
		te.getConjuntos().add(c3);

		VariavelLinguistica aci = new VariavelLinguistica();
		aci.setNome("Acidez");
		Conjunto c11 = new Conjunto("pequeno");
		c11.getPontos().add(new Ponto(1,0));
		c11.getPontos().add(new Ponto(1,1.5));
		c11.getPontos().add(new Ponto(0,6.0));

		Conjunto c22 = new Conjunto("medio");
		c22.getPontos().add(new Ponto(0,0));
		c22.getPontos().add(new Ponto(1,4.5));
		c22.getPontos().add(new Ponto(1,7.5));
		c22.getPontos().add(new Ponto(0,12));

		Conjunto c33 = new Conjunto("grande");
		c33.getPontos().add(new Ponto(0,6.0));
		c33.getPontos().add(new Ponto(1,10.5));
		c33.getPontos().add(new Ponto(1,12.0));

		aci.getConjuntos().add(c11);
		aci.getConjuntos().add(c22);
		aci.getConjuntos().add(c33);

		VariavelLinguistica cla = new VariavelLinguistica();
		cla.setNome("Classe");
		Conjunto c111 = new Conjunto("a");
		c111.getPontos().add(new Ponto(1,0));
		c111.getPontos().add(new Ponto(1,0.15));
		c111.getPontos().add(new Ponto(0,0.5));

		Conjunto c222 = new Conjunto("b");
		c222.getPontos().add(new Ponto(0,0));
		c222.getPontos().add(new Ponto(1,0.5));
		c222.getPontos().add(new Ponto(0,1));

		Conjunto c333 = new Conjunto("c");
		c333.getPontos().add(new Ponto(0,0.5));
		c333.getPontos().add(new Ponto(1,0.85));
		c333.getPontos().add(new Ponto(1,1));

		cla.getConjuntos().add(c111);
		cla.getConjuntos().add(c222);
		cla.getConjuntos().add(c333);

		//regras
		Regra r1 = new Regra();
		Conjunto ca11 = new Conjunto("Teor-baixo");
		Conjunto ca21 = new Conjunto("Acidez-pequeno");
		Conjunto cc1 = new Conjunto("Classe-a");
		r1.getAntecedentes().add(ca11);
		r1.getAntecedentes().add(ca21);
		r1.setConsequente(cc1);

		Regra r2 = new Regra();
		Conjunto ca12 = new Conjunto("Teor-medio");
		Conjunto ca22 = new Conjunto("Acidez-pequeno");
		Conjunto cc2 = new Conjunto("Classe-a");
		r2.getAntecedentes().add(ca12);
		r2.getAntecedentes().add(ca22);
		r2.setConsequente(cc2);

		Regra r3 = new Regra();
		Conjunto ca13 = new Conjunto("Teor-alto");
		Conjunto ca23 = new Conjunto("Acidez-pequeno");
		Conjunto cc3 = new Conjunto("Classe-b");
		r3.getAntecedentes().add(ca13);
		r3.getAntecedentes().add(ca23);
		r3.setConsequente(cc3);

		Regra r4 = new Regra();
		Conjunto ca14 = new Conjunto("Teor-baixo");
		Conjunto ca24 = new Conjunto("Acidez-medio");
		Conjunto cc4 = new Conjunto("Classe-a");
		r4.getAntecedentes().add(ca14);
		r4.getAntecedentes().add(ca24);
		r4.setConsequente(cc4);

		Regra r5 = new Regra();
		Conjunto ca15 = new Conjunto("Teor-medio");
		Conjunto ca25 = new Conjunto("Acidez-medio");
		Conjunto cc5 = new Conjunto("Classe-b");
		r5.getAntecedentes().add(ca15);
		r5.getAntecedentes().add(ca25);
		r5.setConsequente(cc5);

		Regra r6 = new Regra();
		Conjunto ca16 = new Conjunto("Teor-alto");
		Conjunto ca26 = new Conjunto("Acidez-medio");
		Conjunto cc6 = new Conjunto("Classe-c");
		r6.getAntecedentes().add(ca16);
		r6.getAntecedentes().add(ca26);
		r6.setConsequente(cc6);

		Regra r7 = new Regra();
		Conjunto ca17 = new Conjunto("Teor-baixo");
		Conjunto ca27 = new Conjunto("Acidez-grande");
		Conjunto cc7 = new Conjunto("Classe-b");
		r7.getAntecedentes().add(ca17);
		r7.getAntecedentes().add(ca27);
		r7.setConsequente(cc7);

		Regra r8 = new Regra();
		Conjunto ca18 = new Conjunto("Teor-medio");
		Conjunto ca28 = new Conjunto("Acidez-grande");
		Conjunto cc8 = new Conjunto("Classe-c");
		r8.getAntecedentes().add(ca18);
		r8.getAntecedentes().add(ca28);
		r8.setConsequente(cc8);

		Regra r9 = new Regra();
		Conjunto ca19 = new Conjunto("Teor-alto");
		Conjunto ca29 = new Conjunto("Acidez-grande");
		Conjunto cc9 = new Conjunto("Classe-c");
		r9.getAntecedentes().add(ca19);
		r9.getAntecedentes().add(ca29);
		r9.setConsequente(cc9);

		//adiciona as variaveis de entrada no conjunto de entrada 
		fuzzy.getConjuntoDeEntradas().add(te);
		fuzzy.getConjuntoDeEntradas().add(aci);
		//adiciona as variaveis de saida nos conjuntos de saida
		fuzzy.setConjuntoDeSaida(cla);
		//adiciona as regras
		fuzzy.getRegras().add(r1);
		fuzzy.getRegras().add(r2);
		fuzzy.getRegras().add(r3);
		fuzzy.getRegras().add(r4);
		fuzzy.getRegras().add(r5);
		fuzzy.getRegras().add(r6);
		fuzzy.getRegras().add(r7);
		fuzzy.getRegras().add(r8);
		fuzzy.getRegras().add(r9);

		//adiciona as entradas exmplo
		fuzzy.getEntradas().add(1.93);
		fuzzy.getEntradas().add(0.27);

		fuzzy.fuzzyficacao();

		for(VariavelLinguistica v: fuzzy.getConjuntoDeEntradas()){
			System.out.println(v.getNome());
			for(Conjunto c:v.getConjuntos())
				System.out.println("  "+c.getNome() +" "+c.getPertinencia());
		}

		fuzzy.ativarRegras();


		System.out.println("Regras");
		for(Regra re: fuzzy.getRegras()){
			for(Conjunto con:re.getAntecedentes() )
				System.out.print(" se "+con.getNome()+" / "+con.getPertinencia() +" e");
			System.out.println("ntao "+re.getConsequente().getNome() + " - "+re.getGrauDeAtivacao());
		}

		fuzzy.agregarConjuntos();


		fuzzy.novoConjunto();
		for(Regra re: fuzzy.getRegras()){
			for(Ponto p:re.getConsequente().getPontos()){
				System.out.print(p.getPertinencia()+"/"+p.getValor()+" + ");
			}

		}
		
		fuzzy.defuzzyTipoCentroide();

	}

}
