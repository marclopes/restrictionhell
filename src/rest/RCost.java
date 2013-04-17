package rest;

import barri.CjtEdificis;
import barri.Edifici;
import barri.Servei;
import barri.Edifici.TipusEd;
import projecte.Restriccio;


public class RCost extends Restriccio {
	
	int cost;
	boolean max;
	CjtEdificis ce;

	public RCost(int ID, int co, boolean m, CjtEdificis ce) {
		super(ID);
		cost = co;
		max = m;
		this.ce = ce;
	}

	
	public boolean CompleixRes() {
		int c = 0;
		
		for (int i = 0; i < ce.tamany(); i++) {
			Edifici aux = ce.obtenirEdifici(i);
			TipusEd t = aux.consultarSubclasse();
			
			if (t == TipusEd.SER) c = c + ((Servei) aux).ConsultarCost();
		}
		
		if (max && c <= cost) return true;
		if (!max && c >= cost) return true;
		
		return false;
	}

}
