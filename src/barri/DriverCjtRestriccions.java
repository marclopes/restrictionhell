package barri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class DriverCjtRestriccions {
	
	CjtRestriccions cr;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<RestriccioBarris> vec;
	
	public DriverCjtRestriccions() {
		cr = new CjtRestriccions();
		vec = new ArrayList<RestriccioBarris>();
		
		Servei s1 = new Servei(100, 100, 5, "s1", 7, 1, 100, TipusServei.Escola);
		Negoci n1 = new Negoci(100, 5, "n1", 4, 1, 100, TipusNegoci.Bar);
		
		RDistTipus rtip = new RDistTipus(2, 4, false, s1, s1, null);
		RDistTipus rtip2 = new RDistTipus(5, 5, true, n1, n1, null);
		RQuantitat rq1 = new RQuantitat(3, 20, s1, true);
		RQuantitat rq2 = new RQuantitat(3, 10, s1, false);
		RInfluencia rinf = new RInfluencia(4, null);
		RImpostos rimp = new RImpostos(10, 1800, null);		
		RAlsada ralsada = new RAlsada(8, 3, null);
		
		vec.add(rtip);
		vec.add(rtip2);
		vec.add(rq1);
		vec.add(rq2);
		vec.add(rinf);
		vec.add(rimp);
		vec.add(ralsada);
		
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		pr("Driver del CjtRestriccions");
		new DriverCjtRestriccions().comensa();
		

	}
	
	public void comensa() throws NumberFormatException, IOException {
		
		pr("Opcions: ");
		
		pr("1: Afegir Restricció R");
		pr("2: Borrar Restricció R");
		pr("3: Afegir Restricció ID");
		pr("4: Comprovar Restriccions");
		pr("5: Consultar Conjunt");
		pr("6: Consultar Restriccio ID");
		
		int o = Integer.parseInt(br.readLine());
		
		switch (o) {
		case 1:
			pr("Quina Restriccio vols afegir:");
			ImpRestDefecte();
			o = Integer.parseInt(br.readLine());
			
			if (o >= vec.size()) pr("No hi és!");
			else cr.AfegirRes(vec.get(o));
			
			
			break;
			
		case 2:
			pr("Quina Restriccio vols borrar:");
			
			for (int i = 0; i < cr.ConsultarCjt().size(); i++) {
				pr(i+ ": " + ((RestriccioBarris)cr.ConsultarCjt().get(i)).Info());
			}
			o = Integer.parseInt(br.readLine());
			
			if (o >= cr.ConsultarCjt().size()) pr("No hi és!");
			else cr.BorrarRes(cr.ConsultarCjt().get(o));
			
			break;
					
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 6:
			
			break;

		default:
			System.exit(0);
			break;
		}
		
		comensa();
	
	}
	/**
	public void p() {
		cr.AfegirRes(R);
		cr.BorrarRes(R);
		cr.BorrarResID(id);
		cr.ComprovarRes();
		cr.ConsultarCjt();
		cr.ConsultarRes(id);
	}
**/
	private void ImpRestDefecte() {
		pr("Restriccions creades per defecte: ");
		for (int i = 0; i < vec.size(); i++) {
			pr(i + ": " +vec.get(i).Info());
		}
	}
	
	private static void pr(String s) {
		System.out.println(s);
	}
}
