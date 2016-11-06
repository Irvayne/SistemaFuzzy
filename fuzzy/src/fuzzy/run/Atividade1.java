package fuzzy.run;

import java.util.ArrayList;

import fuzzy.modelo.*;

public class Atividade1 {

	public static void main(String[] args) {
		
		Fuzzy fuzzy = new Fuzzy(new ArrayList<VariavelLinguistica>(),new VariavelLinguistica("",new ArrayList<Conjunto>()), new ArrayList<Regra>(), new ArrayList<Double> ());
		
		
		Conjunto mb = new Conjunto ("Muito Baixa", new ArrayList<Ponto>(), 0);
		mb.getPontos().add(new Ponto(1,0));
		mb.getPontos().add(new Ponto(1,5));
		mb.getPontos().add(new Ponto(0,15));
		Conjunto b = new Conjunto ("Baixa", new ArrayList<Ponto>(), 0);
		b.getPontos().add(new Ponto(0,5));
		b.getPontos().add(new Ponto(1,15));
		b.getPontos().add(new Ponto(0,25));
		Conjunto m= new Conjunto ("Medio", new ArrayList<Ponto>(), 0);
		m.getPontos().add(new Ponto(0,15));
		m.getPontos().add(new Ponto(1,25));
		m.getPontos().add(new Ponto(0,35));
		Conjunto a= new Conjunto ("Alto", new ArrayList<Ponto>(), 0);
		a.getPontos().add(new Ponto(0,25));
		a.getPontos().add(new Ponto(1,35));
		a.getPontos().add(new Ponto(0,45));
		Conjunto ma= new Conjunto ("Muito Alto", new ArrayList<Ponto>(), 0);
		ma.getPontos().add(new Ponto(0,35));
		ma.getPontos().add(new Ponto(1,45));
		ma.getPontos().add(new Ponto(1,50));
		
		ArrayList<Conjunto> conjuntosEntrada = new ArrayList<>();
		conjuntosEntrada.add(mb);
		conjuntosEntrada.add(b);
		conjuntosEntrada.add(m);
		conjuntosEntrada.add(a);
		conjuntosEntrada.add(ma);
		
		VariavelLinguistica variavelEntrada = new VariavelLinguistica("Temperatura",conjuntosEntrada );
		fuzzy.getConjuntoDeEntradas().add(variavelEntrada);
		
		fuzzy.getEntradas().add(36.0);
		
		fuzzy.fuzzyficacao();
		
		for(VariavelLinguistica v: fuzzy.getConjuntoDeEntradas())
			for(Conjunto c:v.getConjuntos())
				System.out.println(c.getNome() +" "+c.getPertinencia());
		
//		System.out.println(fuzzy.getConjuntoDeEntradas().get(0).getNome());
//		for(Conjunto c: fuzzy.getConjuntoDeEntradas().get(0).getConjuntos()){
//			System.out.println(" -> "+c.getNome());
//			for(Ponto p: c.getPontos()){
//				System.out.println("   "+p.getPertinencia()+"/"+p.getValor());
//			}
//		}
		
		fuzzy.getConjuntoDeSaida().setNome("Pressao");
		
		Conjunto mbs = new Conjunto ("Muito Pequena", new ArrayList<Ponto>(), 0);
		mbs.getPontos().add(new Ponto(1,0));
		mbs.getPontos().add(new Ponto(1,1));
		mbs.getPontos().add(new Ponto(0,3));
		Conjunto bs = new Conjunto ("Pequena", new ArrayList<Ponto>(), 0);
		bs.getPontos().add(new Ponto(0,1));
		bs.getPontos().add(new Ponto(1,3));
		bs.getPontos().add(new Ponto(0,5));
		Conjunto ms= new Conjunto ("Media", new ArrayList<Ponto>(), 0);
		ms.getPontos().add(new Ponto(0,3));
		ms.getPontos().add(new Ponto(1,5));
		ms.getPontos().add(new Ponto(0,7));
		Conjunto as= new Conjunto ("Grande", new ArrayList<Ponto>(), 0);
		as.getPontos().add(new Ponto(0,5));
		as.getPontos().add(new Ponto(1,7));
		as.getPontos().add(new Ponto(0,9));
		Conjunto mas= new Conjunto ("Muito Grande", new ArrayList<Ponto>(), 0);
		mas.getPontos().add(new Ponto(0,7));
		mas.getPontos().add(new Ponto(1,9));
		mas.getPontos().add(new Ponto(1,10));
		
		fuzzy.getConjuntoDeSaida().getConjuntos().add(mbs);
		fuzzy.getConjuntoDeSaida().getConjuntos().add(bs);
		fuzzy.getConjuntoDeSaida().getConjuntos().add(ms);
		fuzzy.getConjuntoDeSaida().getConjuntos().add(as);
		fuzzy.getConjuntoDeSaida().getConjuntos().add(mas);
		
		Regra r1 = new Regra(new ArrayList<Conjunto>(),new Conjunto("Pressao-Media"));
		r1.getAntecedentes().add(new Conjunto("Temperatura-Muito Baixa"));
		
		Regra r2 = new Regra(new ArrayList<Conjunto>(),new Conjunto("Pressao-Muito Pequena"));
		r2.getAntecedentes().add(new Conjunto("Temperatura-Baixa"));
		
		Regra r3 = new Regra(new ArrayList<Conjunto>(),new Conjunto("Pressao-Grande"));
		r3.getAntecedentes().add(new Conjunto("Temperatura-Medio"));
		
		Regra r4 = new Regra(new ArrayList<Conjunto>(),new Conjunto("Pressao-Muito Grande"));
		r4.getAntecedentes().add(new Conjunto("Temperatura-Alto"));
		
		Regra r5 = new Regra(new ArrayList<Conjunto>(),new Conjunto("Pressao-Pequena"));
		r5.getAntecedentes().add(new Conjunto("Temperatura-Muito Alto"));
		
		fuzzy.getRegras().add(r1);
		fuzzy.getRegras().add(r2);
		fuzzy.getRegras().add(r3);
		fuzzy.getRegras().add(r4);
		fuzzy.getRegras().add(r5);
		
		
		
		fuzzy.ativarRegras();
		
		
		
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
//	fuzzy.defuzzyficacaoTipoMaximo();
		//fuzzy.defuzzyTipoCentroide();
	}

}
