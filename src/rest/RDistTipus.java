package rest;
import java.util.ArrayList;

import barri.Edifici;
import barri.Espai;


public class RDistTipus extends RDistancia{
	private Edifici e1, e2;
	
	public class Pos {
		public int x, y;
		
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pos () {
			
		}
	}
	

	public RDistTipus(int ID, int d, boolean m, Edifici e1, Edifici e2, Espai e) {
		super(ID, d, m, e);
		this.e1 = e1;
		this.e2 = e2;
		
	}

	public boolean CompleixRes() {
		int dist_act;
		int x,y;
		x = y = 0;
		
		ArrayList<Pos> l1, l2;
		l1 = new ArrayList<RDistTipus.Pos>();
		l2 = new ArrayList<RDistTipus.Pos>();
		
		while (x < 10 && y < 10 /**&& e.ExisteixElementxy(x, y)**/) {
			Edifici ed = (Edifici) e.ConsultarElementxy(x, y);
			
			
			if (ed.consultarTipus().equals(e1.consultarTipus())) {
				l1.add(new Pos(x, y));
				
			} if (ed.consultarTipus().equals(e2.consultarTipus())) {
				l2.add(new Pos(x, y));
			}
			x++;
			if (x == 10) {
				x = 0;
				y++;
			}
		}
		
		
		Pos p1, p2;
		for (int i = 0; i < l1.size(); i++) {
			p1 = l1.get(i);
			for (int j = 0; j < l2.size(); j++) {
				p2 = l2.get(j);
				//System.err.println("RDistTipus: Distancia: " + dist(p1.x, p1.y, p2.x, p2.y));
				if (max && (dist(p1.x, p1.y, p2.x, p2.y) > dist) && dist(p1.x, p1.y, p2.x, p2.y) != 0) return false;
				else if (!max && (dist(p1.x, p1.y, p2.x, p2.y) < dist) && dist(p1.x, p1.y, p2.x, p2.y) != 0) return false;
				
			}
		}
		return true;
		
	}
	
	

}


