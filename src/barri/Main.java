package barri;



public class Main {
	Habitatge h1 = new Habitatge(100, 5, "h1", 1, 1, 100, tipusHab.Pis);
	Habitatge h2 = new Habitatge(200, 10, "h2", 2, 2, 200, tipusHab.Pis);
	Habitatge h3 = new Habitatge(300, 15, "h3", 5, 3, 300, tipusHab.Casa);
	//Habitatge h1 = new Habitatge(impost, aparcament, nom, codi, h, capacitat, t);
	
	
	Negoci n1 = new Negoci(100, 5, "n1", 4, 1, 100, tipusNegoci.Bar);
	Negoci n2 = new Negoci(200, 10, "n2", 5, 1, 100, tipusNegoci.Bar);
	Negoci n3 = new Negoci(300, 15, "n3", 6, 1, 100, tipusNegoci.Clinica);
	//Negoci n = new Negoci(impost, aparcament, nom, codi, h, capacitat, t);
	
	Servei s1 = new Servei(100, 100, 4, "s1", 7, 1, 100, tipusServei.Escola);
	Servei s2 = new Servei(200, 200, 4, "s2", 8, 1, 200, tipusServei.Escola);
	Servei s3 = new Servei(300, 300, 6, "s3", 9, 4, 300, tipusServei.Preso);
	//Servei s = new Servei(cost, manteniment, area, nom, codi, h, capacitat, t);

	RDistCodi rcodi = new RDistCodi(1, 3, false, 4, 4, null);
<<<<<<< HEAD
	RDistTipus rtip = new RDistTipus(2, 3, false, s3, s3, null);
	RDistTipus rtip2 = new RDistTipus(5, 3, false, h3, h3, null);
	RQuantitat rq1 = new RQuantitat(3, 4, s3, true);
=======
	RDistTipus rtip = new RDistTipus(2, 4, false, s1, h1, null);
	RDistTipus rtip2 = new RDistTipus(5, 5, true, n3, n3, null);
	RQuantitat rq1 = new RQuantitat(3, 20, s1, true);
	RQuantitat rq2 = new RQuantitat(3, 10, s1, false);
>>>>>>> 55245f900a5dedb2d6f6a23f78bd8fb3fd012f21
	RInfluencia rinf = new RInfluencia(4, null);
	
	RAlsada ralsada = new RAlsada(8, 3, null);
	
	Barri b;
	
	
	
	
	public Main() {
<<<<<<< HEAD
		b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
=======
		
		CtrBarriDom cb = CtrBarriDom.ObteInstancia();
		
		b = new Barri("BonBarri",  Classes.Mitja, 15, 15);
>>>>>>> 55245f900a5dedb2d6f6a23f78bd8fb3fd012f21
		//b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
		//b = new Barri(n, po, pr, c, cl, a, xx, yy)
		b.CarregaEdifici(s1);
		b.CarregaEdifici(s3);
		/**
		b.carregaEdifici(h2);
		b.carregaEdifici(h3);
		b.carregaEdifici(n1);
		b.carregaEdifici(n2);
		b.carregaEdifici(n3);
		
		b.carregaEdifici(s2);
		**/
		b.CarregaEdifici(h3);
		b.CarregaEdifici(h1);

		
		//b.AfegeixRestriccio(rcodi);
		//b.AfegeixRestriccio(rtip);
		b.AfegeixRestriccio(rtip2);
		//b.AfegeixRestriccio(rq1);
		b.AfegeixRestriccio(rinf);
		//b.AfegeixRestriccio(ralsada);
		
		
		cb.CreaBarri("Bon", Classes.Mitja, 15, 15);
		
		
		s1.AfegirClase(Classes.Mitja);
		h1.AfegirClase(Classes.Mitja);
		h3.AfegirClase(Classes.Mitja);
		
		System.out.print(cb.AfegirEdifici(s1, "Bon"));
		System.out.print(cb.AfegirEdifici(h1, "Bon"));
		System.out.print(cb.AfegirEdifici(h3, "Bon"));
		System.out.print(cb.AfegeixRestriccions("Bon", rtip));
		

		
		b = cb.ObtenirBarri("Bon");
		System.out.println();
		System.out.println(b.ConsultarNom());
		System.out.println(b.ObteEd(0).ConsultarNom() + "  " + b.ObteRest(0));
		
		if (cb.ObtenirBarri("Bon") != null) {
			cb.Back(0, 0, 0, cb.ObtenirBarri("Bon"));
			
		} else System.out.println("NUUUUUULL");
		
		cb.Imprimeix(cb.ObtenirBarri("Bon"));
		
<<<<<<< HEAD
		//if (b.reparaBack()) {
			b.back2(0, 0, 0);
			imprimeix();
		//}
=======
		
		
		
		
		
		
		
		
		/**
		if (b.preparaBack()) {
			b.back(0, 0, 0);
			imprimeix();
		}
		
		**/
>>>>>>> 55245f900a5dedb2d6f6a23f78bd8fb3fd012f21
		/**
		if (b.preparaBack()) {
			boolean[][] taula = new boolean[b.ConsultarX()][b.ConsultarY()];
			for (int i = 0; i < b.ConsultarX(); i++) {
				for (int j = 0; j < b.ConsultarY(); j++) {
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
		for (int i = 0; i < b.ConsultarX(); i++) {
			for (int j = 0; j < b.ConsultarY(); j++) {
				String n;
				if (b.ConsultarEdifici(i, j) != null) n = b.ConsultarEdifici(i, j).ConsultarNom();
				else n = "nn";
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	**/
	



	public static void main(String[] args) {
		new Main();

	}

}
