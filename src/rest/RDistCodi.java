package rest;
import barri.Illa;
import projecte.Espai;


public class RDistCodi extends RDistancia {
	
	private int el1, el2;
	Espai<Illa> e;

	public RDistCodi(int ID, int d, boolean m, int el1, int el2, Espai<Illa> e) {
		super(ID, d, m);
		this.el1 = el1;
		this.el2 = el2;
		this.e = e;
	}

	
	public boolean CompleixRes() {
		boolean b = false;
		int x1, y1, x2, y2;
		
		try {
			x1 = e.consultarPosx(el1);
			y1 = e.consultarPosy(el1);
			x2 = e.consultarPosx(el2);
			y2 = e.consultarPosy(el2);
			
			int x, y;
			x = x1 - x2;
			if (x < 0) x = x*(-1);
			y = y1 - y2;
			if (y < 0) y = y*(-1);
			
			int d = x + y;
			
			if (max && d <= dist) b = true;
			if (!max && d >= dist) b = true;
			
			
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
			e1.printStackTrace();	
		}
		
		return b;
		
		
	}

	
	

}
