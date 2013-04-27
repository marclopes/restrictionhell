package barri;

import java.util.ArrayList;

import rest.RAlsada;
import rest.RCjtEd;
import rest.RCost;
import rest.RDistCodi;
import rest.RDistTipus;
import rest.RDistancia;
import rest.REspai;
import rest.RImpostos;
import rest.RInfluencia;
import rest.RManteniment;
import rest.RMax;
import rest.RQuantitat;
import rest.RestriccioBarris;
import rest.TipusRest;

public class CtrRestriccio {
	
	public enum Atribut {
		ALSADA,
		COST,
		DISTANCIA,
		CODI1,
		CODI2,
		EDIFICI1,
		EDIFICI2,
		IMPOSTOS,
		INFLUENCIA,
		QUANTITAT,
		MAXIM,
		ESPAI,
		CJTEDIFICIS
		
	};
	
	private static CtrRestriccio ctrRestriccio = new CtrRestriccio();
	private ArrayList<RestriccioBarris> lRest = new ArrayList<RestriccioBarris>();
	private int idAct = 0;
	
	private CtrRestriccio() {}
	
	public static CtrRestriccio GetInstancia() {
		return ctrRestriccio;
	}
	
	public void creaRestAlsada(int alsada, CjtEdificis cjtEd) {
		lRest.add(new RAlsada(idAct, alsada, cjtEd));
		
	}
	
	public void creaRestCost(int cost, boolean max, CjtEdificis cjtEd) {
		lRest.add(new RCost(idAct, cost, max, cjtEd));
	}
	
	public void creaRestDistCodi(int dist, boolean max, int el1, int el2, Espai e) {
		lRest.add(new RDistCodi(idAct, dist, max, el1, el2, e));
	}
	
	public void creaDistTipus(int dist, boolean max, Edifici el1, Edifici el2, Espai e) {
		lRest.add(new RDistTipus(idAct, dist, max, el1, el2, e));
	}
	
	public void creaRestImpostos(int imp, CjtEdificis cjtEd) {
		lRest.add(new RImpostos(idAct, imp, cjtEd));
	}
	
	public void creaRestInfluencia(Espai e) {
		lRest.add(new RInfluencia(idAct, e));
	}
	
	public void creaRestManteniment(int costBarri, CjtEdificis cjtEd) {
		lRest.add(new RManteniment(idAct, costBarri, cjtEd));
	}
	
	public void creaQuantitat(int quantitat, boolean max, Edifici e) {
		lRest.add(new RQuantitat(idAct, quantitat, e, max));
	}
	
	
	public TipusRest constultarTipus(int id) {
		return lRest.get(id).obteTipus();
	}
	
	
	
	public void ModificarRestriccio(int id ,Atribut atribut, String valor) {
		RestriccioBarris aux = obtRest(id);
		int val = Integer.parseInt(valor);
		
		if (atribut == Atribut.ALSADA && aux.obteTipus() == TipusRest.ALSADA) {
			((RAlsada)aux).modificarAlsada(val);
			
		} else if (atribut == Atribut.COST && aux.obteTipus() == TipusRest.COST) {
			((RCost)aux).modificarCost(val);
			
		} else if (atribut == Atribut.DISTANCIA && (aux.obteTipus() == TipusRest.DISTCODI || aux.obteTipus() == TipusRest.DISTTIPUS)) {
			((RDistancia)aux).modificarDist(val);
			
		} else if (atribut == Atribut.IMPOSTOS && aux.obteTipus() == TipusRest.IMPOSTOS) {
			((RImpostos)aux).modificarImp(val);

		} else if (atribut == Atribut.QUANTITAT && aux.obteTipus() == TipusRest.QUANTITAT) {
			((RQuantitat)aux).modificarQuant(val);
						
		} else if (atribut == Atribut.CODI1 && aux.obteTipus() == TipusRest.DISTCODI) {
			((RDistCodi)aux).modificarCodi1(val);
			
		} else if (atribut == Atribut.CODI2 && aux.obteTipus() == TipusRest.DISTCODI) {
			((RDistCodi)aux).modificarCodi2(val);
			
		/**	
		} else if (atribut == Atribut.ESPAI && aux instanceof REspai) {
		**/	
			
		} else if (atribut == Atribut.MAXIM && aux instanceof RMax) {
			if (val != 0) ((RMax)aux).canviaMax(true);
			else ((RMax)aux).canviaMax(false);

			
		} 
		
	}
	
	public void assignaEd(int id, int nEd, Edifici ed) {
		RestriccioBarris aux = obtRest(id);
		if (nEd == 2 && aux instanceof RDistTipus) {
			((RDistTipus) aux).modificarEd2(ed);
			
		} else if (nEd == 1) {
			if ( aux instanceof RDistTipus) {
				((RDistTipus) aux).modificarEd1(ed);
			} else if (aux instanceof RQuantitat) {
				((RQuantitat) aux).assignaEdifici(ed);
			}
		}
	}
	
	public void assignaCjtEd(int id, CjtEdificis ce) {
		RestriccioBarris aux = obtRest(id);
		if (aux instanceof RCjtEd) {
			((RCjtEd)aux).assignaCe(ce);
		}
	}
	
	public void assignaEspai(int id, Espai e) {
		RestriccioBarris aux = obtRest(id);
		if (aux instanceof REspai) {
			((REspai)aux).assignaEspai(e);
		}
	}
	

	public void EliminarRestriccio(int id) {
		lRest.remove(id);
	}
	
	
	
	public RestriccioBarris obtRest(int id) {
		return lRest.get(id);
		
	}



}
