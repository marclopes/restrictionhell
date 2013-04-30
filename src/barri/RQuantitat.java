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
		for (int i = 0; i < e.obteX(); i++) {
			for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
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
		if (!max && q < quant) return false;
		return true;
	}
	
	
	public boolean esAquest(Edifici e) {
		if (e.ConsultarNom().equals(ed.ConsultarNom())) return true;
		else return false;
	}
	
	public int consultarQuant() {
		return quant;
	}
	
	public void modificarQuant(int q) {
		quant = q;
	}
	
	public boolean esMax() {
		return max;
	}
	
	public void canviaMax(boolean m) {
		max = m;
	}
	
	public Edifici quinEdifici() {
		return ed;
	}
	
	public void assignaEdifici(Edifici e) {
		ed = e;
	}


	
	public void assignaEspai(Espai e) {
		this.e = e;
		
	}
	

}
