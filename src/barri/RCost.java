package barri;

import barri.Edifici.TipusEd;




public class RCost extends RestriccioBarris implements RMax, RCjtEd {
	
	int cost, cAct;
	boolean max;
	CjtEdificis ce;

<<<<<<< HEAD
	public RCost(int ID, int co, boolean m, CjtEdificis ce) {
		super(ID);
		cost = co;
		max = m;
		this.ce = ce;
=======
        /**
         * Crea una instancia de la restricció de cost.
         * @param ID Identificador de la restrició.
         * @param co Cost que s'assigna a la restricció. 
         * @param m Indica si el cost és m´nim o màxim.
         * @param e Espai on s'aplicarà la restricció.
         */
	public RCost(int ID, int co, boolean m, Espai e) {
		super(ID);
		cost = co;
		max = m;
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		super.tr = TipusRest.COST;
		cAct = 0; 
	}

	/**
<<<<<<< HEAD
=======
         * Incrementa el cost actual de la restricció.
         * @param c L'increment del cost.
         */
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
	public void AugmentaCost(int c) {
		cAct = cAct+c;
	}
	
        /**
         * Decrementa el cost actual de la restricció.
         * @param c El decrement del cost.
         */
	public void RedueixCost(int c) {
		cAct = cAct - c;
	}
	
        /**
         * Comprova si es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
	public boolean CompleixRes() {
		if (e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return CompleixFi();
		
		if (max && cAct <= cost) return true;
		if (!max && cAct >= cost) return true;
		return false;
	}
	
	/**
         * Comprova que es compleixi la restricció un cop generat el barri.
         * @return Cert si es compleix la restricció.
         */
	public boolean CompleixFi() {
		int n = 0;
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (ed.consultarSubclasse() == TipusEd.SER) {
					n = n + ((Servei)ed).ConsultarCost();
				}
			}
		}

		if (!max && n >= cost) return true;
		if (max && n <= cost) return true;
		else return false;
		
	}
	
        /**
         * Consultora del cost assignat al barri.
         * @return El cost assignat al barri.
         */
	public int ConsultarCost() {
		return cost;
	}
        
	/**
         * Modificadora del cost assignat al barri.
         * @param c Nou cost assignat al barri.
         */
	public void ModificarCost(int c) {
		cost = c;
	}
	
        /**
         * Consulta si el cost es màxim o mínim.
         * @return Cert si el cost és màxim.
         */
	public boolean EsMax() {
		return max;
	}

        /**
         * Modifica si el cost es màxim o mínim.
         * @param m Nou indicador de si el cost es màxim o mínim.
         */
	public void CanviaMax(boolean m) {
		max = m;
		
	}

<<<<<<< HEAD
	
=======
	@Override
	public void AssignaEspai(Espai e) {
		this.e = e;
		
	}
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
	
	public String Info() {
		String s;
		if (max) s = "maxim";
		else s = "minim";
		
		return ("Cost " + s + " " + cost);
	}

<<<<<<< HEAD
	@Override
	public void AssignaCe(CjtEdificis ce) {
		this.ce = ce;
		
	}


	@Override
	public boolean CompleixRes() {
		cAct = 0;
		//boolean comp = true;
		for (int i = 0; i < ce.Tamany(); i++) {
			if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.SER)
				cAct = cAct + ((Servei)ce.ObtenirEdifici(i)).ConsultarCost();
		}
		
	
		if (cAct < cost && !max) return false;
		else if (cAct > cost && max) return false;
		else return true;
		
	}


=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
}
