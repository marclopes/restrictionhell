package barri;

import java.util.ArrayList;

import barri.Edifici.TipusEd;



public class RImpostos extends RestriccioBarris {
	
	int imp, ia;
<<<<<<< HEAD
	CjtEdificis ce;
	//Espai e;
	
	//int iMin;

	public RImpostos(int ID, int i, CjtEdificis ce) {
=======
	Espai e;
	int iMin;

        /**
         * Crea una instancia de la restricció d'impostos.
         * @param ID Identificador de la restricció.
         * @param i Impostos que es volen recaptar. 
         * @param e Espai on es volen recaptar els impostos.
         */
	public RImpostos(int ID, int i, Espai e) {
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		super(ID);
		imp = i;
		this.ce = ce;
		super.tr = TipusRest.IMPOSTOS;
		ia = 0;
		//iMin = 0;
		
	}
	
        /**
         * Consultora dels impostos assignats a la restricció.
         * @return impostos assignats a la restricció.
         */
	public int ConsultarImp() {
		return imp;
	}
	
        /**
         * Modifica els impostos assignats a la restricció.
         * @param i Nous impostos assignats a la restricció.
         */
	public void ModificarImp(int i) {
		imp = i;
	}
	
	/**
         * Modifica els impostos actuals del barri.
         * @param i Nous impostos actuals del barri.
         */
	public void AssignaImpAct(int i) {
		ia = i;
	}
	
	/**
<<<<<<< HEAD
=======
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
	public boolean CompleixRes() {
		if (e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return CompleixFi();
		
		if (ia == -1) return true;
		return (ia >= iMin);
		
	}
	
        /**
         * Comprova que es compleix la restricció un cop generat el barri.
         * @return Cert si es compleix la restricció.
         */
	public boolean CompleixFi() {
		int n = 0;
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
				switch (ed.consultarSubclasse()) {
				case HAB:
					n = n + ((Habitatge) ed).ConsultarImpost();
					
					break;

				case NEG:
					n = n + ((Negoci) ed).ConsultarImpost();
					break;
					
				default:
					break;
				}
			}
		}
<<<<<<< HEAD
		/**

=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		if (n >= imp) return true;
		else return false;
		
	}

	private int CalcMin() {
		int s = e.ObteX() * e.ObteY();
		s = 4*s/5;
		s = imp / s;
		return s;
	}
    **/
	@Override

	
	public String Info() {
		return ("Impostos maxims "+ imp);
	}



	@Override
	public boolean CompleixRes() {
		ia = 0;
		//boolean comp = true;
		for (int i = 0; i < ce.Tamany(); i++) {
			if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.HAB)
				ia = ia + ((Habitatge)ce.ObtenirEdifici(i)).ConsultarImpost();
			
			if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.NEG)
				ia = ia + ((Negoci)ce.ObtenirEdifici(i)).ConsultarImpost();
		}
	
		if (ia < imp) return false;
		else return true;
		
	}

	@Override
	public boolean prop(ArrayList<Assignacions> va, Assignacio a) {
		if (va.size() >= 2 && va.get(1).val == true) ia = 0;
		
		TipusEd t = a.e.consultarSubclasse();
		if (t == TipusEd.HAB) ia = ia + ((Habitatge)a.e).ConsultarImpost();
		else if (t == TipusEd.NEG) ia = ia + ((Negoci)a.e).ConsultarImpost();
		
		int sum = 0;	
		
		for (int i = 0; i < va.size(); i++) {
			Assignacions aux = va.get(i);
			if (aux.val) {
				int imax = 0;
				int iac = 0;
				for (int j = 0; j < aux.va.size(); j++) {
					Assignacio aa = aux.va.get(j);
					
					if (aa.val) {
						t = aa.e.consultarSubclasse();
						if (t == TipusEd.HAB) iac = ((Habitatge)aa.e).ConsultarImpost();
						else if (t == TipusEd.NEG) iac = ((Negoci)aa.e).ConsultarImpost();
					}
					
					if (iac > imax) imax = iac;
					
				}
				
				sum = sum + imax;
				
			}
		}
		
		
		if (ia + sum >= imp) return true;
		else return false;
		
	}

	
	public boolean afecta(Assignacio a) {
		TipusEd t = a.e.consultarSubclasse();
		if (t == TipusEd.HAB || t == TipusEd.NEG) return true;
		return false;
	}
	
	

}
