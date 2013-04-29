


public class RCost extends RestriccioBarris implements RMax, RCjtEd{
	
	int cost;
	boolean max;
	CjtEdificis ce;

	public RCost(int ID, int co, boolean m, CjtEdificis ce) {
		super(ID);
		cost = co;
		max = m;
		this.ce = ce;
		super.tr = TipusRest.COST;
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
	
	
	public int consultarCost() {
		return cost;
	}
	
	public void modificarCost(int c) {
		cost = c;
	}
	
	
	public void assignaCe(CjtEdificis ce) {
		this.ce = ce;
	}


	
	public boolean esMax() {
		return max;
	}


	
	public void canviaMax(boolean m) {
		max = m;
		
	}

}
