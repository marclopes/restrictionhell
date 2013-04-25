package rest;
import barri.Illa;
import barri.Espai;


public class RDistCodi extends RDistancia {
	
	private int el1, el2;
	Espai e;

	public RDistCodi(int ID, int d, boolean m, int el1, int el2, Espai e) {
		super(ID, d, m, e);
		this.el1 = el1;
		this.el2 = el2;
		this.e = e;
	}

	
	public boolean CompleixRes() {
		boolean b = false;
		int x1, y1, x2, y2;
		
		try {
			x1 = e.ConsultarPosx(el1);
			y1 = e.ConsultarPosy(el1);
			x2 = e.ConsultarPosx(el2);
			y2 = e.ConsultarPosy(el2);
			/**
			int x, y;
			x = x1 - x2;
			if (x < 0) x = x*(-1);
			y = y1 - y2;
			if (y < 0) y = y*(-1);
			**/
			int d = dist(x1, y1, x2, y2);
			
			if (max && d <= dist) b = true;
			if (!max && d >= dist) b = true;
			
			
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
			e1.printStackTrace();	
		}
		
		return b;
		
		
	}

	
	

}
