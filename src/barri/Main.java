package barri;

import barri.Edifici.Classes;
import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;



public class Main {
	Habitatge h1 = new Habitatge(100, 5, "h1", 1, 1, 100, tipusHab.Pis);
	Habitatge h2 = new Habitatge(200, 10, "h2", 2, 2, 200, tipusHab.Pis);
	Habitatge h3 = new Habitatge(300, 15, "h3", 5, 3, 300, tipusHab.Casa);
	//Habitatge h1 = new Habitatge(impost, aparcament, nom, codi, h, capacitat, t);
	
	
	Negoci n1 = new Negoci(100, 5, "n1", 4, 1, 100, tipusNegoci.Bar);
	Negoci n2 = new Negoci(200, 10, "n2", 5, 1, 100, tipusNegoci.Bar);
	Negoci n3 = new Negoci(300, 15, "n3", 6, 1, 100, tipusNegoci.Clinica);
	//Negoci n = new Negoci(impost, aparcament, nom, codi, h, capacitat, t);
	
	Servei s1 = new Servei(100, 100, 5, "s1", 7, 1, 100, tipusServei.Escola);
	Servei s2 = new Servei(200, 200, 8, "s2", 8, 1, 200, tipusServei.Escola);
	Servei s3 = new Servei(300, 300, 10, "s3", 9, 4, 300, tipusServei.Preso);
	//Servei s = new Servei(cost, manteniment, area, nom, codi, h, capacitat, t);

	RDistCodi rcodi = new RDistCodi(1, 3, false, 4, 4, null);
	RDistTipus rtip = new RDistTipus(2, 4, false, s1, s1, null);
	RDistTipus rtip2 = new RDistTipus(5, 5, true, n3, n3, null);
	RQuantitat rq1 = new RQuantitat(3, 20, s1, true);
	RQuantitat rq2 = new RQuantitat(3, 10, s1, false);
	RInfluencia rinf = new RInfluencia(4, null);
	RImpostos rimp = new RImpostos(10, 1800, null);
	
	RAlsada ralsada = new RAlsada(8, 3, null);
	RCost rc = new RCost(6, 19000, true, null);
	
	Barri b;
	
	
	public Main() {
		b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
		//b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
		//b = new Barri(n, po, pr, c, cl, a, xx, yy)
		b.carregaEdifici(s1);
		//b.carregaEdifici(s3);
		
		//b.carregaEdifici(h2);
		//b.carregaEdifici(h3);
		//b.carregaEdifici(n1);
		//b.carregaEdifici(n2);
		//b.carregaEdifici(n3);
		
		//b.carregaEdifici(s2);
		
		//b.carregaEdifici(h3);
		b.carregaEdifici(h1);
		//b.carregaEdifici(h2);

		
		//b.AfegeixRestriccio(rcodi);
		//b.AfegeixRestriccio(rtip);
		//b.AfegeixRestriccio(rtip2);
		//b.AfegeixRestriccio(rq1);
		//b.AfegeixRestriccio(rq2);
		b.AfegeixRestriccio(rinf);
		//b.AfegeixRestriccio(ralsada);
		//b.AfegeixRestriccio(rc);
		//b.AfegeixRestriccio(rimp);
		
		
		
		if (b.preparaBack()) {
			b.back(0, 0, 0);
			imprimeix();
		}
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
	
	



	public static void main(String[] args) {
		new Main();

	}

}
