package rest;

import java.util.ArrayList;

import barri.Edifici;
import barri.Edifici.TipusEd;
import barri.Espai;
import barri.Espai.Pos;
import barri.Habitatge.tipusHab;
import barri.Servei;
import barri.Servei.tipusServei;
import projecte.Restriccio;

public class RInfluencia extends RDistancia implements REspai{

	
	//Espai e;
	ArrayList<ArrayList<PosArea> > v;
	

	public RInfluencia(int ID, Espai e) {
		super(ID, 0, false, e);
		//this.e = e;
		v = new ArrayList<ArrayList<PosArea>>(tipusServei.values().length);
	}

	public boolean CompleixRes() {
		int x, y;
		x = y = 0;
		while (x < 10 && y < 10 /**&& e.ExisteixElementxy(x, y)**/) {
			Edifici ed = (Edifici) e.ConsultarElementxy(x, y);
			if (ed.consultarSubclasse() == TipusEd.SER) {
				Servei se = (Servei)ed;
				
				int i = 0;
				switch (se.consultarTipus()) {
				case Bombers:
					i = 0;
					break;
					
				case Centre_Cultural:
					i = 1;
					break;
					
				case Escola:
					i = 2;
					break;

				case Hospital:
					i = 3;
					break;

				case Parc:
					i = 4;
					break;

				case Policia:
					i = 5;
					break;
					
				case Preso:
					i = 6;
					break;

				default:
					break;
					
				
				}
				v.get(i).add(new PosArea(x, y, se.ConsultarAreaInfluencia()));
			}
			
			
		}
		
		for (int i = 0; i < v.size(); i++) {
			ArrayList<PosArea> vaux = v.get(i);
				comprovaArees(vaux);
			
		}
			
		
		return false;
	}
	
	
	private boolean comprovaArees(ArrayList<PosArea> v) {
		boolean b = true;
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < v.size(); j++) {
				if (i != j) {
					PosArea p1 = v.get(i);
					PosArea p2 = v.get(j);
					
					int inf = p1.area + p2.area;
					int d = dist(p1.x, p1.y, p2.x, p2.y);
					if (inf < d) return false;
				}
			}
		}
		
		return true;
	}
	
	
	
	public void assignaEspai(Espai e) {
		this.e = e;
	}
	

}
