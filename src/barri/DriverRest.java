package barri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class DriverRest {
	
	//CjtEdificis ce;
	//Espai e;
	InputStreamReader r;
	BufferedReader br;
	
	
	
	
	public static void main(String[] args) {
		
		InputStreamReader rm = new InputStreamReader(System.in);
		BufferedReader brm = new BufferedReader(rm);
		System.out.println("Num rest:");
		int n = 0;
		
		try {
			n = Integer.parseInt(brm.readLine());
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println("Ok: " + n);
		
		DriverRest dr = new DriverRest();
		
		dr.comprova(n);
		
		/**
		switch (n) {
		case 1:
			dr.comprova(TipusRest.ALSADA);
			break;

		default:
			break;
		}
		**/
		
		
		
		
		

	}
	

	public DriverRest() {
		//e = new Espai(10, 10);
		r = new InputStreamReader(System.in);
		br = new BufferedReader(r);

	}
	
	
	public void comprova(int t) {
		int n = 0;
		switch (t) {
		case 1:
			System.out.println("Alçada:");
			
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			alsada(n);
			break;
			
			
		case 2:
			cost();
			break;
			
			
		case 3:
			System.out.println("Distancia:");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			distcodi(n);
			break;
			
	
		case 4:
			System.out.println("Distancia:");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			distipus(n);
			break;
	
			
		case 5:
			System.out.println("Impostos minims (milor entre 1 i 100):");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			impostos(n);
			break;
			
			
		case 6:
			infuencia();
			break;
			
	
		case 7:
			System.out.println("Cost barri (milor entre 1 i 100):");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		
			manteniment(n);
			break;
			
	
		case 8:
			System.out.println("Quantitat:");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			quantitat(n);
			break;
	
		default:
			System.out.println("Sortir.");
			break;
		}
		
		
	}

	
	

	public void alsada(int al) {
		Habitatge hbaix = new Habitatge(1, 1, "hbaix", 1, al, 1, null);
		Habitatge hbaix2 = new Habitatge(1, 1, "hbaix2", 2, al-1, 1, null);
		
		Habitatge halt = new Habitatge(1, 1, "halt", 3, al+1, 1, null);
		Habitatge halt2 = new Habitatge(1, 1, "halt2", 4, al+2, 1, null);
		
		//Habitatge hab = new Habitatge(impost, aparcament, nom, codi, h, capacitat, t);
		
		
		System.out.println("Afegint edificis amb h: " + hbaix.ConsultarH() + " i " + hbaix2.ConsultarH());
		
		CjtEdificis ce = new CjtEdificis();
		for (int i = 0; i < 10; i++) {
			if (i%2 == 0) ce.AfegirEdifici(hbaix);
			else ce.AfegirEdifici(hbaix2);
		}
		
		// hauria de complir!
		RAlsada ra = new RAlsada(1, al, ce);
		boolean compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");
		
		
		System.out.println("Afegint edificis amb h: " + hbaix.ConsultarH() + ", " + hbaix2.ConsultarH()+ ", " + halt.ConsultarH()+ " i " + halt2.ConsultarH());
		
		ce = new CjtEdificis();
		for (int i = 0; i < 10; i++) {
			if (i%2 == 0) ce.AfegirEdifici(hbaix);
			else if (i == 9) ce.AfegirEdifici(halt);
			else ce.AfegirEdifici(hbaix2);
		}
		
		ra = new RAlsada(1, al, ce);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");
		
		
		
		/**
		
		Locuraaaaaaah
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				switch (j%2) {
				case 0:
					e.InsertarElement(hbaix, i*10 + j, i, j);
					break;
					
				case 1:
					e.InsertarElement(hbaix2, i*10 + j, i, j);
					break;

				default:
					break;
				}
			}
			
		}
		**/
		
	}
	
	
	
	private void quantitat(int q) {
		Habitatge hab = new Habitatge(1, 1, "h", 1, 1, 1, Habitatge.tipusHab.Casa);
		Negoci neg = new Negoci(1, 1, "n", 2, 1, 1, Negoci.tipusNegoci.Bar);
		
		//Negoci n = new Negoci(impost, aparcament, nom, codi, h, capacitat, t)
		
		
		// PROVANT QUANTITAT MAXIMA
		// PROVANT COMPLEIX...
		
		System.out.println("Provant restricció de quantitat maxima:");
		System.out.println("Afegint " + (q) + " edificis:");
		
		CjtEdificis ce = new CjtEdificis();
		for (int i = 0; i < q+10; i++) {
			if (i < q) ce.AfegirEdifici(hab);
			else ce.AfegirEdifici(neg);
		}
		
		RQuantitat ra = new RQuantitat(1, q, hab, true);
		boolean compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");
		
		//PROVANT NO COMPLEIX...
		System.out.println("Ara afegint " + (q+1) + " edificis:");
		
		ce = new CjtEdificis();
		for (int i = 0; i < q+10; i++) {
			if (i < q+1) ce.AfegirEdifici(hab);
			else ce.AfegirEdifici(neg);
		}
		
		ra = new RQuantitat(1, q, hab, true);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");
		
		// PROVANT QUANTITAT MINIMA
		// PROVANT COMPLEIX...
		System.out.println();
		System.out.println("Provant restricció de quantitat minima:");
		System.out.println("Afegint " + (q) + " edificis:");
		
		ce = new CjtEdificis();
		for (int i = 0; i < q+10; i++) {
			if (i < q) ce.AfegirEdifici(hab);
			else ce.AfegirEdifici(neg);
		}
		
		ra = new RQuantitat(1, q, hab, false);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");
		
		//PROVANT NO COMPLEIX...
		System.out.println("Ara afegint " + (q-1) + " edificis:");
		
		ce = new CjtEdificis();
		for (int i = 0; i < q+10; i++) {
			if (i < q-1) ce.AfegirEdifici(hab);
			else ce.AfegirEdifici(neg);
		}
		
		ra = new RQuantitat(1, q, hab, false);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");		
		
		
		
		
		
	}


	private void manteniment(int cb) {
		Habitatge h = new Habitatge(1, 1, "h", 1, 1, 1, Habitatge.tipusHab.Casa);
		Negoci n = new Negoci(2, 1, "n", 2, 1, 1, Negoci.tipusNegoci.Bar);

		
		// PROVANT COMPLEIX...
		
		CjtEdificis ce = new CjtEdificis();
		int i;
		for (i = 0; i < cb; i++) {
			if (i%2 == 0) ce.AfegirEdifici(h);
			else ce.AfegirEdifici(n);
		}
		System.out.println("Afegint edificis amb impostos totals: " + i);
		
		// hauria de complir!
		RManteniment ra = new RManteniment(1, cb, ce);
		boolean compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");		
		
		
		// PROVANT NO COMPLEIX...
		
		ce = new CjtEdificis();
		for (i = 0; i < cb-2; i++) {
			if (i%2 == 0) ce.AfegirEdifici(h);
			else ce.AfegirEdifici(n);
		}
		System.out.println("Afegint edificis amb impostos totals: " + i);
		
		// hauria de complir!
		ra = new RManteniment(1, cb, ce);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");		
		
	}


	private void infuencia() {
		
		
	}


	private void impostos(int im) {
		Habitatge h = new Habitatge(1, 1, "h", 1, 1, 1, Habitatge.tipusHab.Casa);
		Negoci n = new Negoci(2, 1, "n", 2, 1, 1, Negoci.tipusNegoci.Bar);
		
		// PROVANT COMPLEIX...
		
		CjtEdificis ce = new CjtEdificis();
		int i;
		for (i = 0; i < im; i++) {
			if (i%2 == 0) ce.AfegirEdifici(h);
			else ce.AfegirEdifici(n);
		}
		System.out.println("Afegint edificis amb impostos totals: " + i);
		
		// hauria de complir!
		RManteniment ra = new RManteniment(1, im, ce);
		boolean compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");		
		
		
		// PROVANT NO COMPLEIX...
		
		ce = new CjtEdificis();
		for (i = 0; i < im-2; i++) {
			if (i%2 == 0) ce.AfegirEdifici(h);
			else ce.AfegirEdifici(n);
		}
		System.out.println("Afegint edificis amb impostos totals: " + i);
		
		// hauria de complir!
		ra = new RManteniment(1, im, ce);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");	
		
	}


	private void distipus(int dist) {
		Habitatge h = new Habitatge(1, 1, "h", 1, 1, 1, Habitatge.tipusHab.Casa);
		Negoci n1= new Negoci(2, 1, "n", 2, 1, 1, Negoci.tipusNegoci.Bar);
		Negoci n2 = new Negoci(2, 1, "n2", 3, 1, 1, Negoci.tipusNegoci.Banc);
		
		Espai e = new Espai(10, 10);
		// COMPROVEM QUE ES COMPLEIXEN...
		System.out.println("Comprovem que es compleixen...");
		for (int i = 0; i < 100; i++) {
			int x = i/10;
			int y = i%10;
			//MAX
			if (x == 0 && y == 0) {
				System.out.println("Posant edifici " + n1.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n1, 1, x, y);
				
			} else if (x == dist/2 && y == dist/2+dist%2-1) {
				System.out.println("Posant edifici " + n1.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n1, 2, x, y);
			//MIN	
			} else if (x == 9 && y == 9) {
				System.out.println("Posant edifici " + n2.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n2, 3, x, y);
				
			} else if (x == 9-(dist)/2 && y == 9-(dist)/2-dist%2-1) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 4, x, y);
				
			} else {
				e.InsertarElement(h, 4, x, y);
			}
			
		}
		
		RDistTipus rdtM = new RDistTipus(1, dist, true, n1, n1, e);
		RDistTipus rdtm = new RDistTipus(1, dist, false, n2, n2, e);
		
		if (rdtM.CompleixRes() && rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");	
		
		//-------------------------------
		
		e = new Espai(10, 10);
		// COMPROVEM QUE NO ES COMPLEIXEN...
		System.out.println("Comprovem que NO es compleixen...");
		for (int i = 0; i < 100; i++) {
			int x = i/10;
			int y = i%10;
			//MAX
			if (x == 0 && y == 0) {
				System.out.println("Posant edifici " + n1.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n1, 1, x, y);
				
			} else if (x == dist/2 && y == dist/2+dist%2+1) {
				System.out.println("Posant edifici " + n1.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n1, 2, x, y);
			//MIN	
			} else if (x == 9 && y == 9) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 3, x, y);
				
			} else if (x == 9-(dist)/2 && y == 9-(dist)/2-dist%2+1) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 4, x, y);
				
			} else {
				e.InsertarElement(h, 4, x, y);
			}
			
		}
		
		rdtM = new RDistTipus(1, dist, true, n1, n1, e);
		rdtm = new RDistTipus(2, dist, false, n2, n2, e);
		
		/**
		if (rdtM.CompleixRes() || rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");	
		**/
		
		if (rdtM.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");
		if (rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");
		
	}


	private void distcodi(int dist) {
		Habitatge h = new Habitatge(1, 1, "h", 1, 1, 1, Habitatge.tipusHab.Casa);
		Negoci n1= new Negoci(2, 1, "n", 2, 1, 1, Negoci.tipusNegoci.Bar);
		Negoci n2 = new Negoci(2, 1, "n2", 3, 1, 1, Negoci.tipusNegoci.Banc);
		
		Espai e = new Espai(10, 10);
		// COMPROVEM QUE ES COMPLEIXEN...
		System.out.println("Comprovem que es compleixen...");
		for (int i = 0; i < 100; i++) {
			int x = i/10;
			int y = i%10;
			//MAX
			if (x == 0 && y == 0) {
				System.out.println("Posant edifici " + n1.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n1, 1, x, y);
				
			} else if (x == dist/2 && y == dist/2+dist%2-1) {
				System.out.println("Posant edifici " + n1.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n1, 2, x, y);
			//MIN	
			} else if (x == 9 && y == 9) {
				System.out.println("Posant edifici " + n2.ConsultarNom() + " Pos: " + x + ", " + y);
				e.InsertarElement(n2, 3, x, y);
				
			} else if (x == 9-(dist)/2 && y == 9-(dist)/2-dist%2-1) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 4, x, y);
				
			} else {
				e.InsertarElement(h, 4, x, y);
			}
			
		}
		
		RDistCodi rdtM = new RDistCodi(1, dist, true, n1.ConsultarCodi(), n1.ConsultarCodi(), e);
		RDistCodi rdtm = new RDistCodi(1, dist, false, n2.ConsultarCodi(), n2.ConsultarCodi(), e);
		
		if (rdtM.CompleixRes() && rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");	
		
		//-------------------------------
		
		e = new Espai(10, 10);
		// COMPROVEM QUE NO ES COMPLEIXEN...
		System.out.println("Comprovem que NO es compleixen...");
		for (int i = 0; i < 100; i++) {
			int x = i/10;
			int y = i%10;
			//MAX
			if (x == 0 && y == 0) {
				System.out.println("Posant edifici " + n1.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n1, 1, x, y);
				
			} else if (x == dist/2 && y == dist/2+dist%2+1) {
				System.out.println("Posant edifici " + n1.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n1, 2, x, y);
			//MIN	
			} else if (x == 9 && y == 9) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 3, x, y);
				
			} else if (x == 9-(dist)/2 && y == 9-(dist)/2-dist%2+1) {
				System.out.println("Posant edifici " + n2.consultarTipus() + "Pos: " + x + ", " + y);
				e.InsertarElement(n2, 4, x, y);
				
			} else {
				e.InsertarElement(h, 4, x, y);
			}
			
		}
		

		rdtM = new RDistCodi(1, dist, true, n1.ConsultarCodi(), n1.ConsultarCodi(), e);
		rdtm = new RDistCodi(1, dist, false, n2.ConsultarCodi(), n2.ConsultarCodi(), e);
		
		/**
		if (rdtM.CompleixRes() || rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");	
		**/
		
		if (rdtM.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");
		if (rdtm.CompleixRes()) System.out.println("Yeah");
		else System.out.println("Naaah");
		
	
		
	}


	private void cost(int co) {
		Servei s = new Servei(co/5, 0, 0, "ser", 1, 1, 1, tipusServei.Bombers);
		// PROVANT COMPLEIX...
		int acum = 0;
		CjtEdificis ce = new CjtEdificis();
		int i;
		for (i = 0; i < 5; i++) {
			acum = acum + s.ConsultarCost();
			ce.AfegirEdifici(s);
		}
		System.out.println("Afegint edificis amb cost totals: " + acum);
		
		// hauria de complir!
		RCost ra = new RCost(1, co, true, ce);
		boolean compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");		
		
		
		// PROVANT NO COMPLEIX...
		
		ce = new CjtEdificis();
		for (i = 0; i < im-2; i++) {
			if (i%2 == 0) ce.AfegirEdifici(h);
			else ce.AfegirEdifici(n);
		}
		System.out.println("Afegint edificis amb impostos totals: " + i);
		
		// hauria de complir!
		ra = new RManteniment(1, im, ce);
		compleix = ra.CompleixRes();
		
		if (compleix) System.out.println("Yeah");
		else System.out.println("Naaah");	
		
	}

}
