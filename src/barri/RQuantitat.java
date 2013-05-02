package barri;

import barri.Edifici.TipusEd;

public class RQuantitat extends RestriccioBarris implements RMax, REspai{
	
	
	int quant;
	Edifici ed;
	boolean max;
	Espai e;
	
        /**
         * Crea una instancia de la restricció de quantitat.
         * @param ID Identificador dde la restricció.
         * @param q Quantitat que volem definir.
         * @param e Edifici sobre el que volem definir la quantitat.
         * @param m Cert -> Quantitat màxima. Fals -> Quantitat mínima.
         */
	public RQuantitat(int ID, int q, Edifici e, boolean m) {
		super(ID);
		quant = q;
		ed = e;
		max = m;
		super.tr = TipusRest.QUANTITAT;
	}

	/**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció, fals en cas contrari.
         */
	public boolean CompleixRes() {
		int q = 0;
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici aux = ((Illa)e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (aux.consultarSubclasse() == ed.consultarSubclasse()) {
					if (aux.tipusEd == TipusEd.HAB) {
						if (((Habitatge)aux).consultarTipus() ==  ((Habitatge)ed).consultarTipus()) q++;
						
					} else if (aux.tipusEd == TipusEd.NEG) {
						if (((Negoci)aux).consultarTipus() ==  ((Negoci)ed).consultarTipus()) q++;
						
					} else {
						if (((Servei)aux).consultarTipus() ==  ((Servei)ed).consultarTipus()) q++;
						
					}
					
					
				}
				
			}
		}
		
		
		if (max && q > quant) return false;
		if (!max && q < quant && e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return false;
		return true;
	}
	
	/**
         * Cromprova si l'edifici esta afectat per la restricció.
         * @param e Edifici que volem comprovar.
         * @return Cert si l'edifici està afectat per la restricció, fals en cas contrari.
         */
	public boolean EsAquest(Edifici e) {
		
		if (e.consultarSubclasse() == ed.consultarSubclasse()) {
			if (e.consultarSubclasse() == TipusEd.HAB) {
				if (((Habitatge)e).consultarTipus() ==  ((Habitatge)ed).consultarTipus()) return true;
				
			} else if (e.consultarSubclasse() == TipusEd.NEG) {
				if (((Negoci)e).consultarTipus() ==  ((Negoci)ed).consultarTipus()) return true;
				
			} else {
				if (((Servei)e).consultarTipus() ==  ((Servei)ed).consultarTipus()) return true;
				
			}
			
			
		}
		return false;
		
	}
	
	/**
         * Consulta la quantitat assignada a la restricció.
         * @return La quantitat assignada a la restricció.
         */
	public int ConsultarQuant() {
		return quant;
	}
	
        /**
         * Modifica la quantitat assignada a la restricció.
         * @param q Nova quantitat que volem assignar.
         */
	public void ModificarQuant(int q) {
		quant = q;
	}
	
        /**
         * Consulta si la quantitat es màxima o mínima.
         * @return Cert -> màxim. Fals -> mínim.
         */
	public boolean EsMax() {
		return max;
	}
	
        /**
         * Modifica si la restricció serà de quantitat mínima o màxima.
         * @param m Indica amb cert que la quantitat serà màxima.
         */
	public void CanviaMax(boolean m) {
		max = m;
	}
	
        /**
         * Consulta l'edifici afectat per la restricció.
         * @return L'edifici afectat per la restricció.
         */
	public Edifici QuinEdifici() {
		return ed;
	}
	
        /**
         * Modifica l'edifici afectat per la restricció.
         * @param e L'edifici afectat per la restricció.
         */
	public void AssignaEdifici(Edifici e) {
		ed = e;
	}

        /**
         * Assigna l'espai on es comprovarà la restricció.
         * @param e L'espai on es comprovarà la restricció.
         */
	public void AssignaEspai(Espai e) {
		this.e = e;
		
	}
	
        /**
         * Mostra informació sobre la restricció.
         * @return La informació de la restricció.
         */
	public String Info() {
		String s;
		if (max) s = "maxima";
		else s = "minima";
		
		return ("Quantitat " + s + " de " + StrTipus(ed) + " = " + quant);
	}
	
        /**
         * Converteix el tipus d'edifici en un string.
         * @param e Edifici que volem convertir el seu tipus.
         * @return El tipus de l'edifici.
         */
	private String StrTipus(Edifici e) {
		
			if (e.consultarSubclasse() == TipusEd.HAB) {
				return ((Habitatge)e).consultarTipus().toString();
				
			} else if (e.consultarSubclasse() == TipusEd.NEG) {
				return ((Negoci)e).consultarTipus().toString();
				
			} else {
				return ((Servei)e).consultarTipus().toString();
				
			}
	}
	

}
