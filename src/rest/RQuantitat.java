package rest;

import barri.CjtEdificis;
import barri.Edifici;
import barri.Habitatge;
import barri.Negoci;
import projecte.Restriccio;

public class RQuantitat extends RestriccioBarris {
	
	
	int quant;
	Edifici ed;
	boolean max;
	CjtEdificis ce;
	
	int q_act;

	public RQuantitat(int ID, int q, Edifici e, boolean m) {
		super(ID);
		quant = q;
		ed = e;
		max = m;
		this.ce = ce;
		q_act = 0;
	}

	
	public boolean CompleixRes() {
		if (max && quant < q_act) return false;
		else if (!max && quant > q_act) return false;
		
		return true;
		
	}
	
	public void incrementa() {
		q_act++;
	}
	
	public boolean esAquest(Edifici e) {
		if (e.ConsultarNom().equals(ed.ConsultarNom())) return true;
		else return false;
	}

}
