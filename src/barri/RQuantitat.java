package barri;

import barri.Edifici.TipusEd;

public class RQuantitat extends RestriccioBarris implements RMax, REspai{
	
	
	int quant;
	Edifici ed;
	boolean max;
	//CjtEdificis ce;
	Espai e;
	
	//int q_act;

	public RQuantitat(int ID, int q, Edifici e, boolean m) {
		super(ID);
		quant = q;
		ed = e;
		max = m;
		//this.ce = ce;
		//q_act = 0;
		super.tr = TipusRest.QUANTITAT;
	}

	
	public boolean CompleixRes() {
		int q = 0;
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici aux = ((Illa)e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (aux.consultarSubclasse() == ed.consultarSubclasse()) {
					if (aux.tipusEd == TipusEd.HAB) {
						if (((Habitatge)aux).consultarTipus() ==  ((Habitatge)ed).consultarTipus()) q++;
						
					} else if (aux.tipusEd == TipusEd.NEG) {
						if (((Negoci)aux).consultarTipus() ==  ((Negoci)ed).consultarTipus()) q++;
						
					} else {
						if (((Servei)aux).consultarTipus() ==  ((Servei)ed).consultarTipus()) q++;
						
					}
					
					
				}
				
			}
		}
		
		
		if (max && q > quant) return false;
		if (!max && q < quant && e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return false;
		return true;
	}
	
	
	public boolean EsAquest(Edifici e) {
		
		if (e.consultarSubclasse() == ed.consultarSubclasse()) {
			if (e.consultarSubclasse() == TipusEd.HAB) {
				if (((Habitatge)e).consultarTipus() ==  ((Habitatge)ed).consultarTipus()) return true;
				
			} else if (e.consultarSubclasse() == TipusEd.NEG) {
				if (((Negoci)e).consultarTipus() ==  ((Negoci)ed).consultarTipus()) return true;
				
			} else {
				if (((Servei)e).consultarTipus() ==  ((Servei)ed).consultarTipus()) return true;
				
			}
			
			
		}
		return false;
		
	}
	
	
	public int ConsultarQuant() {
		return quant;
	}
	
	public void ModificarQuant(int q) {
		quant = q;
	}
	
	public boolean EsMax() {
		return max;
	}
	
	public void CanviaMax(boolean m) {
		max = m;
	}
	
	public Edifici QuinEdifici() {
		return ed;
	}
	
	public void AssignaEdifici(Edifici e) {
		ed = e;
	}


	
	public void AssignaEspai(Espai e) {
		this.e = e;
		
	}
	
	public String Info() {
		String s;
		if (max) s = "maxima";
		else s = "minima";
		
		return ("Quantitat " + s + " de " + StrTipus(ed) + " = " + quant);
	}
	
	private String StrTipus(Edifici e) {
		
			if (e.consultarSubclasse() == TipusEd.HAB) {
				return ((Habitatge)e).consultarTipus().toString();
				
			} else if (e.consultarSubclasse() == TipusEd.NEG) {
				return ((Negoci)e).consultarTipus().toString();
				
			} else {
				return ((Servei)e).consultarTipus().toString();
				
			}
	}
	

}
