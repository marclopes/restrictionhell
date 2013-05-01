package barri;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import barri.Edifici.TipusEd;
import barri.Servei.TipusServei;
import barri.Servei.TipusServei;

public class RInfluencia extends RDistancia implements REspai, RCjtEd{

	
	Espai e;
	ArrayList<ArrayList<PosArea>> v;
	CjtEdificis ce;
	HashSet<TipusServei> vt;
	int x, y;
	

	public RInfluencia(int ID, Espai e) {
		super(ID, 0, false, e);
		//this.e = e;
		v = new ArrayList<ArrayList<PosArea>>(); 
		super.tr = TipusRest.INFUENCIA;
		//vt = new ArrayList<Servei.TipusServei>();
	}
	
	public void AssignaPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void RecorreCjt () {
		vt = new HashSet<TipusServei>();
		for (int i = 0; i < ce.Tamany(); i++) {
			if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.SER)
			vt.add(((Servei)ce.ObtenirEdifici(i)).consultarTipus());
		}
	}
	
	private boolean bfs (int x, int y) {
		int tam = e.obteX()*e.obteY();
		//int p = y*15+x;
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		boolean[][] b = new boolean[e.obteX()][e.obteY()];
		int[][] d = new int[e.obteX()][e.obteY()];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = false;
				d[i][j] = 0;
			}
				
		}
		
		//for (int i = 0; i < tam; i++) {
			
		if (!b[x][y]) {
			q.add(y*15+x);
			b[x][y] = true;
			
			while (!q.isEmpty()) {
				int v = q.poll();
				int i,j;
				i = v%e.obteX();
				j = v/e.obteX();
				
				if (e.ExisteixElementxy(i, j )) {
					Edifici aux = ((Illa)e.ConsultarElementxy(i, j )).ConsultaEdifici();
					int dis = d[i][j];
					
					if (aux.consultarSubclasse() == TipusEd.SER) {
						TipusServei t = ((Servei)aux).consultarTipus();
						
						if (vt.contains(t)) {
							if (((Servei)aux).ConsultarAreaInfluencia() < d[i][j]) return false;
						}
						
						if (vt.isEmpty()) return true;
						
					}
				}
				
				
				
				if (i+1 >= 0 && i+1 <= e.obteX()-1 && e.ExisteixElementxy(i+1, j) && !b[i+1][j] ) {
					q.add(v+1);
					b[i+1][j] = true;
					d[i+1][j] = d[i][j]+1;
					
				}
				
				if (i-1 >= 0 && i-1 <= e.obteX()-1 && e.ExisteixElementxy(i-1, j) && !b[i-1][j] ) {
					q.add(v+1);
					b[i-1][j] = true;
					d[i-1][j] = d[i][j]+1;
					
				}
				
				if (j+1 >= 0 && j+1 <= e.obteY()-1 && e.ExisteixElementxy(i, j+1) && !b[i][j+1]) {
					q.add(v+e.obteX());
					b[i][j+1] = true;
					d[i][j+1] = d[i][j]+1;
					
				}
				if (j-1 >= 0 && j-1 <= e.obteY()-1 && e.ExisteixElementxy(i, j-1) && !b[i][j-1] ) {
					q.add(v-e.obteX());
					b[i][j-1] = true;
					d[i][j-1] = d[i][j]+1;
					
				}
				
				
				
					
				//cosaaa
				
								
			}
			return true;
			
			
		}
		return true;
			
		//}
	}
	
	public boolean CompleixRes2() {
		return bfs(x, y);
		
	}
	


	public boolean CompleixRes() {
		
		//System.out.println("M'HAN CRIDAT!!!");
		
		for (int i = 0; i < TipusServei.values().length; i++) {
			v.add(new ArrayList<PosArea>());
			v.get(i).clear();
		}
		
		
		for (int i = 0; i < e.obteX(); i++) {
			//System.out.print("it: " + i + ",");
			for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
				//System.out.println(j);
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (ed.consultarSubclasse() == TipusEd.SER) {
					Servei se = (Servei)ed;
					
					//System.out.println("Detectat servei: " + se.ConsultarCodi() + " " + se.ConsultarNom());
					
					for (int x = 0; x < TipusServei.values().length; x++) {
						if (se.consultarTipus() == TipusServei.values()[x]) {
							//System.out.println("afegit " + se.ConsultarNom() + " a: " + i + "," +j + " --> " + se.consultarTipus());
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
		//System.out.println("fora bucle ueee");
		
		//boolean bool = true;
		for (int i = 0; i < v.size(); i++) {
			ArrayList<PosArea> vaux = v.get(i);
			if (!ComprovaArees(vaux)) return false;	
			
		}
		return true;
	}
	
	
	private boolean ComprovaArees(ArrayList<PosArea> v) {
		//boolean b = true;
		int Md, md;
		for (int i = 0; i < v.size()-1; i++) {
			//for (int j = 0; j < v.size(); j++) {
			//if (i != j) {
			PosArea p1 = v.get(i);
			PosArea p2 = v.get(i+1);
				
			int inf = p1.area + p2.area;
			int d = dist(p1.x, p1.y, p2.x, p2.y);
				
			//System.out.println(i + " vs " + i+1 + "   " + p1.x + "," + p1.y + " vs. " + p2.x + "," + p2.y + " ---- " + inf + "  " + d);
				
			if (inf < d || inf/2 > d) return false;
			//}
			//}
		}
		
		return true;
	}
	
	
	
	public void AssignaEspai(Espai e) {
		this.e = e;
	}

	
	public void AssignaCe(CjtEdificis ce) {
		this.ce = ce;
		
	}

	@Override
	public boolean EsMax() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void CanviaMax(boolean m) {
		// TODO Auto-generated method stub
		
	}
	

}
