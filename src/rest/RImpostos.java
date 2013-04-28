package rest;

import barri.CjtEdificis;
import barri.Edifici;
import barri.Habitatge;
import barri.Negoci;
import barri.Edifici.TipusEd;
import projecte.Restriccio;

public class RImpostos extends RestriccioBarris implements RCjtEd{
	
	int imp;
	CjtEdificis ce;

	public RImpostos(int ID, int i, CjtEdificis ce) {
		super(ID);
		imp = i;
		this.ce = ce;
		super.tr = TipusRest.IMPOSTOS;
		
	}

	
	public boolean CompleixRes() {
		int c = 0;
		
		for (int i = 0; i < ce.tamany(); i++) {
			Edifici aux = ce.obtenirEdifici(i);
			TipusEd t = aux.consultarSubclasse();
			
			if (t == TipusEd.HAB) c = c + ((Habitatge) aux).ConsultarImpost();
			else if (t == TipusEd.NEG) c = c + ((Negoci) aux).ConsultarImpost();
		}
		
		if (c >= imp) return true;
		else return false;
	}
	
	
	public int consultarImp() {
		return imp;
	}
	
	public void modificarImp(int i) {
		imp = i;
	}
	
	
	public void assignaCe(CjtEdificis ce) {
		this.ce = ce;
	}

}
