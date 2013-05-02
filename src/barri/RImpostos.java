package barri;



public class RImpostos extends RestriccioBarris implements REspai{
	
	int imp, ia;
	Espai e;
	int iMin;

        /**
         * Crea una instancia de la restricció d'impostos.
         * @param ID Identificador de la restricció.
         * @param i Impostos que es volen recaptar. 
         * @param e Espai on es volen recaptar els impostos.
         */
	public RImpostos(int ID, int i, Espai e) {
		super(ID);
		imp = i;
		this.e = e;
		super.tr = TipusRest.IMPOSTOS;
		ia = 0;
		iMin = 0;
		
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
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
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
		if (n >= imp) return true;
		else return false;
		
	}

	private int CalcMin() {
		int s = e.ObteX() * e.ObteY();
		s = 4*s/5;
		s = imp / s;
		return s;
	}

	@Override
	public void AssignaEspai(Espai e) {
		this.e = e;
		iMin = CalcMin();
		
	}
	
	public String Info() {
		return ("Impostos maxims "+ imp);
	}
	
	

}
