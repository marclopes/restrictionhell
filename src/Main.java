import Habitatge.tipusHab;

public class Main {
	Habitatge h1 = new Habitatge(100, 5, "hp", 1, 1, 100, tipusHab.Pis);
	Habitatge h2 = new Habitatge(200, 10, "hm", 2, 2, 200, tipusHab.Pis);
	Habitatge h3 = new Habitatge(300, 15, "hg", 3, 3, 300, tipusHab.Pis);
	//Habitatge h1 = new Habitatge(impost, aparcament, nom, codi, h, capacitat, t);
	
	
	Negoci n1 = new Negoci(100, 5, "np", 4, 1, 100, tipusNegoci.Bar);
	Negoci n2 = new Negoci(200, 10, "nm", 5, 1, 100, tipusNegoci.Bar);
	Negoci n3 = new Negoci(300, 15, "ng", 6, 1, 100, tipusNegoci.Clinica);
	//Negoci n = new Negoci(impost, aparcament, nom, codi, h, capacitat, t);
	
	Servei s1 = new Servei(100, 100, 4, "sp", 7, 1, 100, tipusServei.Escola);
	Servei s2 = new Servei(200, 200, 4, "sm", 8, 1, 200, tipusServei.Escola);
	Servei s3 = new Servei(300, 300, 6, "sg", 9, 2, 300, tipusServei.Preso);
	//Servei s = new Servei(cost, manteniment, area, nom, codi, h, capacitat, t);

	RDistCodi rcodi = new RDistCodi(1, 3, false, 4, 4, null);
	RDistTipus rtip = new RDistTipus(2, 3, true, s3, h1, null);
	RQuantitat rq1 = new RQuantitat(3, 1, s3, true);
	//RInfluencia rinf = new RInfluencia(4, null);
	
	Barri b;
	
	
	public Main() {
		b = new Barri("BonBarri", 10000, 5000, 5000, Classes.Mitja, 5000, 15, 15);
		//b = new Barri(n, po, pr, c, cl, a, xx, yy)
		
		b.carregaEdifici(h1);
		b.carregaEdifici(h2);
		b.carregaEdifici(h3);
		b.carregaEdifici(n1);
		b.carregaEdifici(n2);
		b.carregaEdifici(n3);
		b.carregaEdifici(s1);
		b.carregaEdifici(s2);
		b.carregaEdifici(s3);
		
		b.AfegeixRestriccio(rcodi);
		b.AfegeixRestriccio(rtip);
		b.AfegeixRestriccio(rq1);
		//b.AfegeixRestriccio(rinf);
		
		
		b.back(0, 0, 0);
		imprimeix();
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
		
	}
	
	



	public static void main(String[] args) {
		new Main();

	}

}
