package barri;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import barri.Edifici.TipusEd;
import barri.Servei.TipusServei;

public class RInfluencia extends RDistancia implements REspai, RCjtEd{

	
	Espai e;
	ArrayList<ArrayList<PosArea>> v;
	CjtEdificis ce;
	int x, y;
	
        /**
         * Crea una instancia de la restricció d'influencia.
         * @param ID Identificador de la restricció.
         * @param e Espai sobre el que es comprovarà la restricció.
         */
	public RInfluencia(int ID, Espai e) {
		super(ID, 0, false, e);
		v = new ArrayList<ArrayList<PosArea>>(); 
		super.tr = TipusRest.INFUENCIA;
	}
	
      
        /**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
	public boolean CompleixRes() {
		for (int i = 0; i < TipusServei.values().length; i++) {
			v.add(new ArrayList<PosArea>());
			v.get(i).clear();
		}
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (ed.consultarSubclasse() == TipusEd.SER) {
					Servei se = (Servei)ed;
					for (int x = 0; x < TipusServei.values().length; x++) {
						if (se.consultarTipus() == TipusServei.values()[x]) {
							v.get(x).add(new PosArea(i, j, se.ConsultarAreaInfluencia()));
							break;
						}
					} 
				}
			}
		}
		for (int i = 0; i < v.size(); i++) {
			ArrayList<PosArea> vaux = v.get(i);
			if (!ComprovaArees(vaux)) return false;		
		}
		return true;
	}
	
	/**
         * Comprova que les arees ocupin tot el barri.
         * @param v Posicions de tots els serveis d'un sol tipus.
         * @return cert si es cobreixen l'àrea d0influència.
         */
	private boolean ComprovaArees(ArrayList<PosArea> v) {
		int Md, md;
		for (int i = 0; i < v.size()-1; i++) {
			PosArea p1 = v.get(i);
			PosArea p2 = v.get(i+1);
				
			int inf = p1.area + p2.area;
			int d = dist(p1.x, p1.y, p2.x, p2.y);
			if (inf < d || inf/2 > d) return false;
		}
		return true;
	}
	
	
	/**
         * Assigna l'espai on es comprovarà la restricció.
         * @param e Espai on s'aplicarà la restricció.
         */
	public void AssignaEspai(Espai e) {
		this.e = e;
	}

	/**
         * Assigna un conjunt d'edificis a la restricció.
         * @param e Espai on s'aplicarà la restricció.
         */
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
	
	public String Info() {
		return ("Compliment de les arees d'influencia");
	}
	

}
