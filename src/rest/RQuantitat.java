package rest;

import barri.CjtEdificis;
import barri.Edifici;
import projecte.Restriccio;

public class RQuantitat extends Restriccio{
	
	int quant;
	String tipusEdifici;
	boolean max;
	CjtEdificis ce;

	public RQuantitat(int ID, int q, Edifici e, boolean m, CjtEdificis ce) {
		super(ID);
		quant = q;
		tipusEdifici = e.consultarTipus();
		max = m;
		this.ce = ce;
	}

	
	public boolean CompleixRes() {
		int cont = 0;
		for (int i = 0; i < ce.tamany(); i++) {
			if (ce.obtenirEdifici(i).consultarTipus().equals(tipusEdifici)) cont++;
		}
		
		if (max && cont <= quant) return true;
		if (!max && cont >= quant) return true;
		
		return false;
	}

}
