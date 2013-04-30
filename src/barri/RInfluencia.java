package barri;
import java.util.ArrayList;

import barri.Edifici.TipusEd;
import barri.Servei.tipusServei;

public class RInfluencia extends RDistancia implements REspai{

	
	//Espai e;
	ArrayList<ArrayList<PosArea>> v;
	

	public RInfluencia(int ID, Espai e) {
		super(ID, 0, false, e);
		//this.e = e;
		v = new ArrayList<ArrayList<PosArea>>(); 
		super.tr = TipusRest.INFUENCIA;
	}
	


	public boolean CompleixRes() {
		
		System.out.println("M'HAN CRIDAT!!!");
		
		for (int i = 0; i < tipusServei.values().length; i++) {
			v.add(new ArrayList<PosArea>());
			v.get(i).clear();
		}
		
		
		for (int i = 0; i < e.obteX(); i++) {
			System.out.print("it: " + i + ",");
			for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
				System.out.println(j);
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (ed.consultarSubclasse() == TipusEd.SER) {
					Servei se = (Servei)ed;
					
					System.out.println("Detectat servei: " + se.ConsultarCodi() + " " + se.ConsultarNom());
					
					for (int x = 0; x < tipusServei.values().length; x++) {
						if (se.consultarTipus() == tipusServei.values()[x]) {
							System.out.println("afegit " + se.ConsultarNom() + " a: " + i + "," +j + " --> " + se.consultarTipus());
							v.get(x).add(new PosArea(i, j, se.ConsultarAreaInfluencia()));
							break;
						}
					} 
					
					/**
					int x = 0;
					switch (se.consultarTipus()) {
					case Bombers:
						x = 0;
						break;
						
					case Centre_Cultural:
						x = 1;
						break;
						
					case Escola:
						x = 2;
						break;
	
					case Hospital:
						x = 3;
						break;
	
					case Parc:
						x = 4;
						break;
	
					case Policia:
						x = 5;
						break;
						
					case Preso:
						x = 6;
						break;
	
					default:
						break;
						
					}
					**/
					
				}
			}

		}
		System.out.println("fora bucle ueee");
		
		//boolean bool = true;
		for (int i = 0; i < v.size(); i++) {
			ArrayList<PosArea> vaux = v.get(i);
			if (!comprovaArees(vaux)) return false;	
			
		}
		return true;
	}
	
	
	private boolean comprovaArees(ArrayList<PosArea> v) {
		//boolean b = true;
		int Md, md;
		for (int i = 0; i < v.size()-1; i++) {
			//for (int j = 0; j < v.size(); j++) {
			//if (i != j) {
			PosArea p1 = v.get(i);
			PosArea p2 = v.get(i+1);
				
			int inf = p1.area + p2.area;
			int d = dist(p1.x, p1.y, p2.x, p2.y);
				
			System.out.println(i + " vs " + i+1 + "   " + p1.x + "," + p1.y + " vs. " + p2.x + "," + p2.y + " ---- " + inf + "  " + d);
				
			if (inf < d || inf/2 > d) return false;
			//}
			//}
		}
		
		return true;
	}
	
	
	
	public void assignaEspai(Espai e) {
		this.e = e;
	}
	

}
