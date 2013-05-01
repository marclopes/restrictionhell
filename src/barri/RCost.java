package barri;

import barri.Edifici.TipusEd;




public class RCost extends RestriccioBarris implements RMax, REspai {
	
	int cost, cAct;
	boolean max;
	Espai e;

	public RCost(int ID, int co, boolean m, Espai e) {
		super(ID);
		cost = co;
		max = m;
		//this.e = e;
		super.tr = TipusRest.COST;
		cAct = 0; 
	}

	
	public void augmentaCost(int c) {
		cAct = cAct+c;
	}
	
	public void redueixCost(int c) {
		cAct = cAct - c;
	}
	
	public boolean CompleixRes() {
		if (e.ExisteixElementxy(e.obteX()-1, e.obteY()-1)) return CompleixFi();
		
		if (max && cAct <= cost) return true;
		if (!max && cAct >= cost) return true;
		return false;
	}
	
	
	public boolean CompleixFi() {
		int n = 0;
		for (int i = 0; i < e.obteX(); i++) {
			for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (ed.consultarSubclasse() == TipusEd.SER) {
					n = n + ((Servei)ed).ConsultarCost();
				}
			}
		}

		if (!max && n >= cost) return true;
		if (max && n <= cost) return true;
		else return false;
		
	}
	
	/**
	
	public boolean CompleixRes2() {
		int c = 0;
		boolean b1, b2, b3;
		//System.out.println((e.obteY()-1)/3 + " " );
		b1 = ( (e.ExisteixElementxy(0, (e.obteY()-1)/3) && !e.ExisteixElementxy(1, (e.obteY()-1)/3)));
		b2 = (e.ExisteixElementxy(0, 2*(e.obteY()-1)/3) && !e.ExisteixElementxy(1, 2*(e.obteY()-1)/3)); 
		b3 = (e.ExisteixElementxy(e.obteX()-1, e.obteY()-1));
		
		if (true) {
			for (int i = 0; i < e.obteX(); i++) {
				for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
					Edifici aux = ((Illa)e.ConsultarElementxy(i, j)).ConsultaEdifici();
					if (aux.consultarSubclasse() == TipusEd.SER) {
						c = c + ((Servei) aux).ConsultarCost();
					}
				}
			}
			
			//if (b1) {
				if (max && c <= cost) return true;
				if (!max && c >= cost) return true;
				
			//} else if (b2 || b3) {
			//	if (max && c <= cost) return true;
			//	if (!max && c >= cost) return true;
				
			//}
			System.out.println("c = " + c + ", cost = " + cost);
			return false;
			
		} 
		return true;
	}
	
	**/
	
	public int consultarCost() {
		return cost;
	}
	
	public void modificarCost(int c) {
		cost = c;
	}
	


	
	public boolean esMax() {
		return max;
	}


	
	public void canviaMax(boolean m) {
		max = m;
		
	}


	@Override
	public void assignaEspai(Espai e) {
		this.e = e;
		
	}



}
