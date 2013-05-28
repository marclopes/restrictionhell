package barri;

import java.util.ArrayList;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;



public class Main2 {
	Habitatge h1 = new Habitatge(100, 0, "h1", 1, 1, 100, TipusHab.Pis);
	Habitatge h2 = new Habitatge(200, 0, "h2", 2, 2, 200, TipusHab.Pis);
	Habitatge h3 = new Habitatge(300, 0, "h3", 5, 3, 300, TipusHab.Casa);
	//Habitatge h1 = new Habitatge(impost, aparcament, nom, codi, h, capacitat, t);
	
	
	Negoci n1 = new Negoci(100, 5, "n1", 4, 1, 100, TipusNegoci.Bar);
	Negoci n2 = new Negoci(200, 10, "n2", 5, 1, 100, TipusNegoci.Bar);
	Negoci n3 = new Negoci(300, 15, "n3", 6, 1, 100, TipusNegoci.Clinica);
	//Negoci n = new Negoci(impost, aparcament, nom, codi, h, capacitat, t);
	
	Servei s1 = new Servei(100, 100, 5, "s1", 7, 1, 100, TipusServei.Escola);
	Servei s2 = new Servei(200, 200, 8, "s2", 8, 1, 200, TipusServei.Escola);
	Servei s3 = new Servei(300, 300, 10, "s3", 9, 4, 300, TipusServei.Preso);
	//Servei s = new Servei(cost, manteniment, area, nom, codi, h, capacitat, t);

	RDistCodi rcodi = new RDistCodi(1, 3, false, 4, 4, null);
	
	RDistTipus rtip = new RDistTipus(2, 2, true, "h3", "SER", null);
	RDistTipus rtip2 = new RDistTipus(5, 15, false, "Casa", "Casa", null);
	RDistTipus rtip3 = new RDistTipus(6, 2, true, "SER", "h3", null);
	RDistTipus rtip4 = new RDistTipus(7, 2, true, "h1", "h3", null);
	RGlobal rg = new RGlobal(12, "APARCAMENT", 35);
	
	RQuantitat rq1 = new RQuantitat(3, 20, s1, true);
	RQuantitat rq2 = new RQuantitat(3, 10, s1, false);
	RInfluencia rinf = new RInfluencia(4, null);
//	RImpostos rimp = new RImpostos(10, 1800, null);
	
	RAlsada ralsada = new RAlsada(8, 3, null);
//	RCost rc = new RCost(6, 19000, true, null);
	
	Barri b;
	
	
	
	
	public Main2() {
		
		CtrBarriDom cb = CtrBarriDom.ObteInstancia();
		
		b = new Barri("BonBarri",  Classes.Mitja, 30, 30);
		//b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
		//b = new Barri(n, po, pr, c, cl, a, xx, yy)
		b.CarregaEdifici(s1);
		//b.carregaEdifici(s3);
		
		//b.carregaEdifici(h2);
		//b.carregaEdifici(h3);
		//b.carregaEdifici(n1);
		//b.carregaEdifici(n2);
		//b.carregaEdifici(n3);
		
		//b.carregaEdifici(s2);
		
		//b.carregaEdifici(h3);
		b.CarregaEdifici(h1);
		//b.carregaEdifici(h2);

		
		//b.AfegeixRestriccio(rcodi);
		b.AfegeixRestriccio(rtip);
		//b.AfegeixRestriccio(rtip2);
		//b.AfegeixRestriccio(rq1);
		//b.AfegeixRestriccio(rq2);
		//b.AfegeixRestriccio(rinf);
		//b.AfegeixRestriccio(ralsada);
		//b.AfegeixRestriccio(rc);
		//b.AfegeixRestriccio(rimp);
		
		
		cb.CreaBarri("Bon", Classes.Mitja, 30, 30);
		
		
		s1.AfegirClase(Classes.Mitja);
		h1.AfegirClase(Classes.Mitja);
		h3.AfegirClase(Classes.Mitja);
		

		System.out.print(cb.AfegeixRestriccions(rtip));
		System.out.print(cb.AfegeixRestriccions(rtip2));
		System.out.print(cb.AfegeixRestriccions(rtip3));
		System.out.print(cb.AfegeixRestriccions(rtip4));
		cb.AfegeixRestriccions(rg);
		

		
		b = cb.ObtenirBarri();
		//cb.b = b;
		System.out.println();
		System.out.println(b.ConsultarNom());
		System.out.println(b.ObteEd(0).ConsultarNom() + "  " + b.ObteRest(0));
		
		
		ArrayList<Assignacions> va = new ArrayList<Assignacions>();
		ArrayList<Assignacio> sol = new ArrayList<Assignacio>();
		prepVA(va, 5, h3);
		prepVA(va, 5, h1);
		prepVA(va, 5, s1);
		prepVA(va, 5, n1);
		
		
		
		
		if (cb.ObtenirBarri() != null) {
			//cb.Back2(0, 0, 0, cb.ObtenirBarri("Bon"));
			cb.fc(0, va, sol);
			
		} else System.out.println("NUUUUUULL");
		
		sol = cb.ObteSol();
		
		System.out.println();
		System.out.println(sol.size());
		for (int i = 0; i < sol.size(); i++) {
			System.out.println(sol.get(i).e.ConsultarNom() + "  " + sol.get(i).x + ", " + sol.get(i).y);
		}
		System.out.println();
		esc(sol);
		
		//cb.Imprimeix(cb.ObtenirBarri("Bon"), sol);
		
		
		
		
		
		
		
		
		
		/**
		if (b.preparaBack()) {
			b.back(0, 0, 0);
			imprimeix();
		}
		
		**/
		/**
		if (b.preparaBack()) {
			boolean[][] taula = new boolean[b.consultarX()][b.consultarY()];
			for (int i = 0; i < b.consultarX(); i++) {
				for (int j = 0; j < b.consultarY(); j++) {
					taula[i][j] = true;
				}
			}
			
			b.randomtrack(0, taula);
			imprimeix();
		}
		**/
	}
	/**
	public void imprimeix() {
		for (int i = 0; i < b.consultarX(); i++) {
			for (int j = 0; j < b.consultarY(); j++) {
				String n;
				if (b.consultarEdifici(i, j) != null) n = b.consultarEdifici(i, j).ConsultarNom();
				else n = "nn";
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	**/
	

	private void prepVA(ArrayList<Assignacions> va) {
		for (int n = 0; n < 3; n++) {
			Assignacions as = new Assignacions();
		
			for (int ne = 0; ne < b.TamEd(); ne++) {
				for (int i = 0; i < b.ConsultarX(); i++) {
					for (int j = 0; j < b.ConsultarY(); j++) {
					
						as.va.add(new Assignacio(i, j, b.ObteEd(ne)));
					
					}
				}
			}
			va.add(as);
		}
	}
	
	
	private void prepVA(ArrayList<Assignacions> va, int nn, Edifici e) {
		for (int n = 0; n < nn; n++) {
			Assignacions as = new Assignacions();
		
			//for (int ne = 0; ne < b.TamEd(); ne++) {
				for (int i = 0; i < b.ConsultarX(); i++) {
					for (int j = 0; j < b.ConsultarY(); j++) {
					
						as.va.add(new Assignacio(i, j, e));
						if (e.ConsultarNom().equals("n1")) as.va.add(new Assignacio(i, j, n2));
					}
				}
			//}
			va.add(as);
		}
	}
	
	private void prepVTED(ArrayList<Assignacions> va, int nn, TipusEd te) {
		for (int n = 0; n < nn; n++) {
			Assignacions as = new Assignacions();
		
			//for (int ne = 0; ne < b.TamEd(); ne++) {
				for (int i = 0; i < b.ConsultarX(); i++) {
					for (int j = 0; j < b.ConsultarY(); j++) {
					
						//as.va.add(new Assignacio(i, j, e));
					
					}
				}
			//}
			va.add(as);
		}
	}
	
	

	public static void main(String[] args) {
		new Main();

	}
	
	private void esc(ArrayList<Assignacio> sol) {
		String e[][] = new String[b.ConsultarX()][b.ConsultarY()];
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				e[i][j] = "()";
			}
		}
		
		for (int i = 0; i < sol.size(); i++) {
			Assignacio as = sol.get(i);
			e[as.x][as.y] = as.e.ConsultarNom();
		}
		
		
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				System.out.print(e[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
