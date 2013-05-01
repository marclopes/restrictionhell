package barri;
public class RManteniment extends RestriccioBarris implements REspai{
	
	int costBarri;
	Espai e;
	int ia, im;
	
	RImpostos rint;

	public RManteniment(int ID, int cb , Espai e) {
		super(ID);
		costBarri = cb;
		this.e = e;
		super.tr = TipusRest.MANTENIMENT;
		rint = new RImpostos(id, costBarri, e);
		
	}

	
	public boolean CompleixRes() {
		return rint.CompleixRes();
		
	}
	
	public int ConsultarCostBarri() {
		return costBarri;
	}
	
	public void ModificarCostBArri(int cb) {
		costBarri = cb;
	}


	@Override
	public void AssignaEspai(Espai e) {
		this.e = e;
		rint.AssignaEspai(e);
	}
	
	
	public void AssignaImpAct(int i) {
		ia = i;
		rint.AssignaImpAct(ia);
	}
	
	
	
	


}
