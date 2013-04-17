package rest;

import barri.CjtEdificis;
import projecte.Restriccio;

public class RManteniment extends Restriccio {
	
	int costBarri;
	CjtEdificis ce;
	private int id;

	public RManteniment(int ID, int cb , CjtEdificis ce) {
		super(ID);
		id = ID;
		costBarri = cb;
		this.ce = ce;
	}

	
	public boolean CompleixRes() {
		return new RImpostos(id, costBarri, ce).CompleixRes();
		
	}

}
