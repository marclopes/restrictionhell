package rest;

import projecte.Restriccio;
import barri.CjtEdificis;

public class RAlsada extends Restriccio {
	
	CjtEdificis ce;
	int alsada;

	public RAlsada(int ID, int al, CjtEdificis ce) {
		super(ID);
		this.ce = ce;
		alsada = al;
		
	}

	
	public boolean CompleixRes() {
		//boolean comp = true;
		for (int i = 0; i < ce.tamany(); i++) {
			if (ce.obtenirEdifici(i).ConsultarH() > alsada) return false;
		}
		
		return true;
	}

}
