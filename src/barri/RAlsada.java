package barri;

public class RAlsada extends RestriccioBarris implements RCjtEd{
	
	CjtEdificis ce;
	int alsada;
	
        /**
         * Crea una instancia de la restricció de Alçada.
         * @param ID Identificador de la restricció.
         * @param al Alçada màxima del barri
         * @param ce Conjunt d'edificis sobre el que es comprovarà la restricció.
         */
	public RAlsada(int ID, int al, CjtEdificis ce) {
		super(ID);
		this.ce = ce;
		alsada = al;
		super.tr = TipusRest.ALSADA;
		
	}

	/**
        * Comprova que es compleixi la restricció.
        * @return cert si es compleix la restricció.
        */
	public boolean CompleixRes() {
		for (int i = 0; i < ce.Tamany(); i++) {
			if (ce.ObtenirEdifici(i).ConsultarH() > alsada) return false;
		}
		
		return true;
	}
	
        /**
         * Consultora de l'alçada màxima del barri.
         * @return L'alçada màxima del barri.
         */
	public int ConsultarAlsada() {
		return alsada;
	}
	
        /**
         * Modifica l'alçada màxima del barri.
         * @param a Nova alçada màxima del barri.
         */
	public void ModificarAlsada(int a) {
		alsada = a;
	}
	
	/**
         * Assigna un conjunt d'edificis a la restricció.
         * @param ce Nou conjunt d'edificis.
         */
	public void AssignaCe(CjtEdificis ce) {
		this.ce = ce;
	}
	
	public String Info() {
		return ("Alsada maxima "+ alsada);
	}

}
