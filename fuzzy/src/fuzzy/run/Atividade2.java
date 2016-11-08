package fuzzy.run;

import fuzzy.modelo.Conjunto;
import fuzzy.modelo.Fuzzy;
import fuzzy.modelo.Ponto;
import fuzzy.modelo.Regra;
import fuzzy.modelo.VariavelLinguistica;

public class Atividade2 {

	public static void main(String[] args) {

		Fuzzy fuzzy = new Fuzzy();

		//3 variaveis 
		VariavelLinguistica tem = new VariavelLinguistica();
		tem.setNome("Temperatura");
		Conjunto c1 = new Conjunto("baixa");
		c1.getPontos().add(new Ponto(1,800));
		c1.getPontos().add(new Ponto(1,900));
		c1.getPontos().add(new Ponto(0,1000));

		Conjunto c2 = new Conjunto("media");
		c2.getPontos().add(new Ponto(0,900));
		c2.getPontos().add(new Ponto(1,1000));
		c2.getPontos().add(new Ponto(0,1100));

		Conjunto c3 = new Conjunto("alta");
		c3.getPontos().add(new Ponto(0,1000));
		c3.getPontos().add(new Ponto(1,1100));
		c3.getPontos().add(new Ponto(1,1200));

		tem.getConjuntos().add(c1);
		tem.getConjuntos().add(c2);
		tem.getConjuntos().add(c3);

		VariavelLinguistica vol = new VariavelLinguistica();
		vol.setNome("Volume");
		Conjunto c11 = new Conjunto("pequeno");
		c11.getPontos().add(new Ponto(1,2.0));
		c11.getPontos().add(new Ponto(1,4.5));
		c11.getPontos().add(new Ponto(0,7.0));

		Conjunto c22 = new Conjunto("medio");
		c22.getPontos().add(new Ponto(0,4.5));
		c22.getPontos().add(new Ponto(1,7.0));
		c22.getPontos().add(new Ponto(0,9.5));

		Conjunto c33 = new Conjunto("grande");
		c33.getPontos().add(new Ponto(0,7.0));
		c33.getPontos().add(new Ponto(1,9.5));
		c33.getPontos().add(new Ponto(1,12.0));

		vol.getConjuntos().add(c11);
		vol.getConjuntos().add(c22);
		vol.getConjuntos().add(c33);

		VariavelLinguistica pre = new VariavelLinguistica();
		pre.setNome("Pressao");
		Conjunto c111 = new Conjunto("baixa");
		c111.getPontos().add(new Ponto(1,4));
		c111.getPontos().add(new Ponto(1,5));
		c111.getPontos().add(new Ponto(0,8));

		Conjunto c222 = new Conjunto("media");
		c222.getPontos().add(new Ponto(0,6));
		c222.getPontos().add(new Ponto(1,8));
		c222.getPontos().add(new Ponto(0,10));

		Conjunto c333 = new Conjunto("alta");
		c333.getPontos().add(new Ponto(0,8));
		c333.getPontos().add(new Ponto(1,11));
		c333.getPontos().add(new Ponto(1,12));

		pre.getConjuntos().add(c111);
		pre.getConjuntos().add(c222);
		pre.getConjuntos().add(c333);

		//regras
		Regra r1 = new Regra();
		Conjunto ca11 = new Conjunto("Temperatura-baixa");
		Conjunto ca21 = new Conjunto("Volume-pequeno");
		Conjunto cc1 = new Conjunto("Pressao-baixa");
		r1.getAntecedentes().add(ca11);
		r1.getAntecedentes().add(ca21);
		r1.setConsequente(cc1);

		Regra r2 = new Regra();
		Conjunto ca12 = new Conjunto("Temperatura-media");
		Conjunto ca22 = new Conjunto("Volume-pequeno");
		Conjunto cc2 = new Conjunto("Pressao-baixa");
		r2.getAntecedentes().add(ca12);
		r2.getAntecedentes().add(ca22);
		r2.setConsequente(cc2);

		Regra r3 = new Regra();
		Conjunto ca13 = new Conjunto("Temperatura-alta");
		Conjunto ca23 = new Conjunto("Volume-pequeno");
		Conjunto cc3 = new Conjunto("Pressao-media");
		r3.getAntecedentes().add(ca13);
		r3.getAntecedentes().add(ca23);
		r3.setConsequente(cc3);

		Regra r4 = new Regra();
		Conjunto ca14 = new Conjunto("Temperatura-baixa");
		Conjunto ca24 = new Conjunto("Volume-medio");
		Conjunto cc4 = new Conjunto("Pressao-baixa");
		r4.getAntecedentes().add(ca14);
		r4.getAntecedentes().add(ca24);
		r4.setConsequente(cc4);

		Regra r5 = new Regra();
		Conjunto ca15 = new Conjunto("Temperatura-media");
		Conjunto ca25 = new Conjunto("Volume-medio");
		Conjunto cc5 = new Conjunto("Pressao-media");
		r5.getAntecedentes().add(ca15);
		r5.getAntecedentes().add(ca25);
		r5.setConsequente(cc5);

		Regra r6 = new Regra();
		Conjunto ca16 = new Conjunto("Temperatura-alta");
		Conjunto ca26 = new Conjunto("Volume-medio");
		Conjunto cc6 = new Conjunto("Pressao-alta");
		r6.getAntecedentes().add(ca16);
		r6.getAntecedentes().add(ca26);
		r6.setConsequente(cc6);

		Regra r7 = new Regra();
		Conjunto ca17 = new Conjunto("Temperatura-baixa");
		Conjunto ca27 = new Conjunto("Volume-grande");
		Conjunto cc7 = new Conjunto("Pressao-media");
		r7.getAntecedentes().add(ca17);
		r7.getAntecedentes().add(ca27);
		r7.setConsequente(cc7);

		Regra r8 = new Regra();
		Conjunto ca18 = new Conjunto("Temperatura-media");
		Conjunto ca28 = new Conjunto("Volume-grande");
		Conjunto cc8 = new Conjunto("Pressao-alta");
		r8.getAntecedentes().add(ca18);
		r8.getAntecedentes().add(ca28);
		r8.setConsequente(cc8);

		Regra r9 = new Regra();
		Conjunto ca19 = new Conjunto("Temperatura-alta");
		Conjunto ca29 = new Conjunto("Volume-grande");
		Conjunto cc9 = new Conjunto("Pressao-alta");
		r9.getAntecedentes().add(ca19);
		r9.getAntecedentes().add(ca29);
		r9.setConsequente(cc9);

		//adiciona as variaveis de entrada no conjunto de entrada 
		fuzzy.getConjuntoDeEntradas().add(tem);
		fuzzy.getConjuntoDeEntradas().add(vol);
		//adiciona as variaveis de saida nos conjuntos de saida
		fuzzy.setConjuntoDeSaida(pre);
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
		fuzzy.getEntradas().add(965.0);
		fuzzy.getEntradas().add(11.0);

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
