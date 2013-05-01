package barri;

import java.util.ArrayList;

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
			((RAlsada)aux).ModificarAlsada(val);
			
		} else if (atribut == Atribut.COST && aux.obteTipus() == TipusRest.COST) {
			((RCost)aux).ModificarCost(val);
			
		} else if (atribut == Atribut.DISTANCIA && (aux.obteTipus() == TipusRest.DISTCODI || aux.obteTipus() == TipusRest.DISTTIPUS)) {
			((RDistancia)aux).ModificarDist(val);
			
		} else if (atribut == Atribut.IMPOSTOS && aux.obteTipus() == TipusRest.IMPOSTOS) {
			((RImpostos)aux).ModificarImp(val);

		} else if (atribut == Atribut.QUANTITAT && aux.obteTipus() == TipusRest.QUANTITAT) {
			((RQuantitat)aux).ModificarQuant(val);
						
		} else if (atribut == Atribut.CODI1 && aux.obteTipus() == TipusRest.DISTCODI) {
			((RDistCodi)aux).modificarCodi1(val);
			
		} else if (atribut == Atribut.CODI2 && aux.obteTipus() == TipusRest.DISTCODI) {
			((RDistCodi)aux).modificarCodi2(val);
			
		/**	
		} else if (atribut == Atribut.ESPAI && aux instanceof REspai) {
		**/	
			
		} else if (atribut == Atribut.MAXIM && aux instanceof RMax) {
			if (val != 0) ((RMax)aux).CanviaMax(true);
			else ((RMax)aux).CanviaMax(false);

			
		} 
		
	}
	
	public void assignaEd(int id, int nEd, Edifici ed) {
		RestriccioBarris aux = obtRest(id);
		if (nEd == 2 && aux instanceof RDistTipus) {
			((RDistTipus) aux).ModificarEd2(ed);
			
		} else if (nEd == 1) {
			if ( aux instanceof RDistTipus) {
				((RDistTipus) aux).ModificarEd1(ed);
			} else if (aux instanceof RQuantitat) {
				((RQuantitat) aux).AssignaEdifici(ed);
			}
		}
	}
	
	public void assignaCjtEd(int id, CjtEdificis ce) {
		RestriccioBarris aux = obtRest(id);
		if (aux instanceof RCjtEd) {
			((RCjtEd)aux).AssignaCe(ce);
		}
	}
	
	public void assignaEspai(int id, Espai e) {
		RestriccioBarris aux = obtRest(id);
		if (aux instanceof REspai) {
			((REspai)aux).AssignaEspai(e);
		}
	}
	

	public void EliminarRestriccio(int id) {
		lRest.remove(id);
	}
	
	
	
	public RestriccioBarris obtRest(int id) {
		return lRest.get(id);
		
	}
	/**
	public String toString(int id) {
		RestriccioBarris aux = obtRest(id);
		String s = aux.obteTipus() + ": ";
		
		if (aux instanceof RMax) {
			if (((RMax)aux).esMax()) s = s + "Maxim ";
			else s = s + "Minim";
			
			if (aux instanceof RDistCodi) {
				s = s + ((RDistCodi)aux).consultarDist() + " entre " + ((RDistCodi)aux).consultarCodi1() + " i " + ((RDistCodi)aux).consultarCodi2();
			} else if (aux instanceof RDistTipus) {
				s = s + ((RDistTipus)aux).consultarDist() + " entre " + ((RDistTipus)aux).consultarEd1().ConsultarNom() + " i " + ((RDistTipus)aux).consultarEd2().ConsultarNom();
			} else if (aux instanceof RQuantitat) {
				s = s + ((RQuantitat)aux).consultarQuant() +  "de " + ((RQuantitat)aux).quinEdifici().ConsultarNom();
			} else {
				s = s;
		}
		
		return s;
		
		
		}

	}**/

}
