package barri;

public class DriverCtrDomRestriccio {
	CtrDomRestriccio cr;

	public DriverCtrDomRestriccio() {
		cr = CtrDomRestriccio.ObteInstancia();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DriverCtrDomRestriccio driv = new DriverCtrDomRestriccio();
		
		pr("Op");
		driver.

	}
	
	public void creaRest() {
		for (int i = 0; i < TipusRest.values().length; i++) {
			pr(TipusRest.values()[i].toString());
		}
	}
	
	
	private static void pr(String s) {
		System.out.println(s);
	}
	
/**	
	public void hey() {
		cr.CreaDistTipus(id, dist, max, el1, el2);
		cr.CreaRestAlsada(id, alsada)
		cr.CreaRestAparcaments(id, aparcaments)
		cr.CreaRestCost(id, cost, max);
		cr.CreaRestImpostos(id, imp);
		cr.CreaRestManteniment(id, costBarri);
		cr.CreaRestQuantitat(id, quantitat, max, e);
		
		cr.ConstultarTipus(id);
		cr.ModificarRestriccio(id, atribut, valor)
		
		cr.AssignaHab(id, nEd, th)
		cr.AssignaNeg(id, nEd, tn)
		cr.AssignaSer(id, nEd, ts)
		
		cr.AssignaEspai(id, e)
		cr.AssignaCjtEd(id, ce)
		
		cr.EliminarRestriccio(id)
		cr.ObtenirRest(id);
		cr.ExisteixRestriccio(id)
		
		
		cr.InfoRes(id)
		
		
		
		
		
		
		
	}
	**/

}
