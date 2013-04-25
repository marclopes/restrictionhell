package rest;

import barri.CjtEdificis;
import projecte.Restriccio;

public class RManteniment extends RestriccioBarris {
	
	int costBarri;
	CjtEdificis ce;
	private int id;

	public RManteniment(int ID, int cb , CjtEdificis ce) {
		super(ID);
		id = ID;
		costBarri = cb;
		this.ce = ce;
		super.tr = TipusRest.MANTENIMENT;
	}

	
	public boolean CompleixRes() {
		return new RImpostos(id, costBarri, ce).CompleixRes();
		
	}

}
