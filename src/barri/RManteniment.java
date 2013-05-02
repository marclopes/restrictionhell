package barri;

public class RManteniment extends RestriccioBarris implements REspai {


    int costBarri;
    Espai e;
    int ia, im;
    RImpostos rint;

	
	public boolean CompleixRes() {
		return rint.CompleixRes();
		
	}
	
	public int ConsultarCostBarri() {
		return costBarri;
	}
	
	public void ModificarCostBArri(int cb) {
		costBarri = cb;
	}


    public RManteniment(int ID, int cb, Espai e) {
        super(ID);
        costBarri = cb;
        this.e = e;
        super.tr = TipusRest.MANTENIMENT;
        rint = new RImpostos(super.ObtenirId()/*id*/, costBarri, e);
    }


	public void AssignaEspai(Espai e) {
		this.e = e;
		rint.AssignaEspai(e);
	}
	
	
	public void AssignaImpAct(int i) {
		ia = i;
		rint.AssignaImpAct(ia);
	}
	

}
