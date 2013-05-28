package barri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import barri.CtrDomRestriccio.Atribut;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class DriverCtrDomRestriccio {
	CtrDomRestriccio cr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int id = 1;
	
	DriverCtrDomRestriccio driv;

	public DriverCtrDomRestriccio() {
		cr = CtrDomRestriccio.ObteInstancia();
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		new DriverCtrDomRestriccio().comensa();
		

	}
	
	
	
	public void comensa() throws NumberFormatException, IOException {
		
		pr("Opcions: ");
		pr("1: Crea Rest");
		pr("2: Modifica Rest");
		pr("3: Llista Restriccions");
		pr("4: Borra Restriccions");
		pr("5: Assigna Edifici");
		pr("6: Assigna Conjunt Edifici");
		pr("7: Comprova existeix i obte info");
		
		
		int op = Integer.parseInt(br.readLine());
		pr();
		switch (op) {
		case 1:
			CreaRest();
			break;
			
		case 2:
			ModificaRest();
			break;

		case 3:
			LlistaRest();
			break;
			
		case 4:
			AssignaEd();
			break;
			
		case 5:
			AssignaEd();
			break;
			
		case 6:
			AssignaCjt();
			break;
			
		case 7:
			ComprovaIobteInfo();
			break;
			
		default:
			pr();
			pr("Sortir");
			break;
		}
		pr();
		pr();
		comensa();
		
		
		
	}
	
	/**
	 * Crea una restriccio
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void CreaRest() throws NumberFormatException, IOException {
		boolean b;
		pr("Escull Tipus:");
		for (int i = 0; i < TipusRest.values().length; i++) {
			pr(i + ": " + TipusRest.values()[i].toString());
		}
		
		int op = Integer.parseInt(br.readLine());
		
		switch (TipusRest.values()[op]) {
		case ALSADA:
			p("Alsada maxima:");
			op = Integer.parseInt(br.readLine());
			pr();
			cr.CreaRestAlsada(id, op);
			break;
			
		case APARCAMENT:
			p("Aparcament minim:");
			op = Integer.parseInt(br.readLine());
			pr();
			cr.CreaRestAparcaments(id, op);
			break;
					
		case COST:
			p("Cost:");
			op = Integer.parseInt(br.readLine());
			pr();
			p("Max: 1, min 0:");
			b = Boolean.parseBoolean(br.readLine());
			pr();
			cr.CreaRestCost(id, op, b);
			break;
			
		case DISTTIPUS:
			p("Distancia:");
			op = Integer.parseInt(br.readLine());
			pr();
			p("Max: 1, min 0:");
			b = Boolean.parseBoolean(br.readLine());
			pr();
			cr.CreaDistTipus(id, op, b, null, null);
			break;
			
		case IMPOSTOS:
			pr("Impostos minims:");
			op = Integer.parseInt(br.readLine());
			pr();
			cr.CreaRestImpostos(id, op);
			break;
			
			
		case MANTENIMENT:
			p("Cost Barri:");
			op = Integer.parseInt(br.readLine());
			pr();
			cr.CreaRestManteniment(id, op);
			break;
			
		case QUANTITAT:
			p("Quantitat");
			op = Integer.parseInt(br.readLine());
			pr();
			p("Max: 1, min 0:");
			b = Boolean.parseBoolean(br.readLine());
			pr();
			cr.CreaRestQuantitat(id, op, b, null);
			break;

		default:
			break;
		}
		
		id++;
	}
	
	public void LlistaRest() {
		int ind = 0;
		for (int i = 0; i < cr.NRest();) {
			if(cr.ExisteixRestriccio(ind)) {
				pr(cr.ObtenirRest(ind).ObtenirId() + ": " + cr.InfoRes(ind));
				i++;
			}
			ind++;
		}
	}
	
	public void ModificaRest() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		LlistaRest();
		int op = Integer.parseInt(br.readLine());
		
		int id = op;
		
		pr("Escull Atribut:");
		for (int i = 0; i < CtrDomRestriccio.Atribut.values().length; i++) {
			pr(i + ": " + CtrDomRestriccio.Atribut.values()[i].toString());
		}
		op = Integer.parseInt(br.readLine());
		CtrDomRestriccio.Atribut a = Atribut.values()[op];
		
		pr("Valor: ");
		int res;
		res = cr.ModificarRestriccio(id, a, br.readLine());
		
		if(res == -1) pr("Error");
		else pr("OK!");
		
	}
	
	public void BorraRest() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		LlistaRest();
		int op = Integer.parseInt(br.readLine());
		
		cr.EliminarRestriccio(op);
		//id--;
	}
	
	
	public void AssignaEd() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		LlistaRest();
		int op = Integer.parseInt(br.readLine());
		
		cr.AssignaHab(op, 1, TipusHab.Casa);
		cr.AssignaSer(op, 1, TipusServei.Bombers);
		cr.AssignaNeg(op, 1, TipusNegoci.Banc);
	}
	
	public void AssignaEspai() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		LlistaRest();
		int op = Integer.parseInt(br.readLine());
		
		cr.AssignaEspai(op, new Espai(10, 10));
	}
	
	public void AssignaCjt() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		LlistaRest();
		int op = Integer.parseInt(br.readLine());
		
		cr.AssignaCjtEd(op, new CjtEdificis());
	}
	
	public void ComprovaIobteInfo() throws NumberFormatException, IOException {
		pr("Escull Rest: ");
		int op = Integer.parseInt(br.readLine());
		
		if (cr.ExisteixRestriccio(op)) pr("Existeix!! --> " + cr.ObtenirRest(op).Info());
		else pr("NO Existeix");
	}
	
	
	private static void pr(String s) {
		System.out.println(s);
	}
	private static void pr() {
		System.out.println();
	}
	private static void p(String s) {
		System.out.print(s);
	}
	
	

}
