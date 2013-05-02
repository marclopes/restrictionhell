package barri;

public class RManteniment extends RestriccioBarris implements REspai {


        int costBarri;
        Espai e;
        int ia, im;
        RImpostos rint;

	/**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció, fals en cas contrari.
         */
	public boolean CompleixRes() {
		return rint.CompleixRes();
		
	}
	
        /**
         * Consulta el cost de manteniment del barri assignat a la restricció.
         * @return  el cost de manteniment del barri assignat a la restricció.
         */
	public int ConsultarCostBarri() {
		return costBarri;
	}
	
        /**
         * Modifica el cost de manteniment del barri assignat a la restricció.
         * @param cb Nou cost de manteniment del barri assignat a la restricció.
         */
	public void ModificarCostBArri(int cb) {
		costBarri = cb;
	}

        /**
         * Crea una instancia de la restricció de manteniment.
         * @param ID Identificador de la restricció.
         * @param cb Cost de manteniment del barri.
         * @param e Espai on s'aplicarà la restricció.
         */
        public RManteniment(int ID, int cb, Espai e) {
            super(ID);
            costBarri = cb;
            this.e = e;
            super.tr = TipusRest.MANTENIMENT;
            rint = new RImpostos(super.ObtenirId()/*id*/, costBarri, e);
        }

        /**
         * Assigna l'espai on es comprovarà la restricció.
         * @param e Espai on s'aplicarà la restricció.
         */
	public void AssignaEspai(Espai e) {
		this.e = e;
		rint.AssignaEspai(e);
	}
	
        /**
         * Assigna els impostos que es recapten a la restricció.
         * @param i Impostos que es recapten a la restricció.
         */
	public void AssignaImpAct(int i) {
		ia = i;
		rint.AssignaImpAct(ia);
	}
	
        /**
         * Obté informació sobre la restricció sobre la restricció.
         * @return Informació sobre si el barri es autosuficient.
         */
	public String Info() {
		return ("Barri autosuficient en el seu manteniment");
	}
	

}
