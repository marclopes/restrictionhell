package rest;
import barri.Edifici;
import projecte.Espai;


public class RDistTipus extends RDistancia{
	private Edifici e1, e2;
	

	public RDistTipus(int ID, int d, boolean m, Edifici e1, Edifici e2, Espai e) {
		super(ID, d, m, e);
		this.e1 = e1;
		this.e2 = e2;
		
	}

	public boolean CompleixRes() {
		int dist_act;
		
		for (int i = 0; i < e.tamX(); i++) {
			for (int j = 0; j < e.tamY(); j++) {
				
			}
		}
		
		
	}
	
	

}
