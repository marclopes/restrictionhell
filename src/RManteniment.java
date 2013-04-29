
public class RManteniment extends RestriccioBarris implements RCjtEd{
	
	int costBarri;
	CjtEdificis ce;
	private int id;

	public RManteniment(int ID, int cb , CjtEdificis ce) {
		super(ID);
		id = ID;
		costBarri = cb;
		this.ce = ce;
		super.tr = TipusRest.MANTENIMENT;
	}

	
	public boolean CompleixRes() {
		return new RImpostos(id, costBarri, ce).CompleixRes();
		
	}
	
	public int consultarCostBarri() {
		return costBarri;
	}
	
	public void modificarCostBArri(int cb) {
		costBarri = cb;
	}
	
	
	public void assignaCe(CjtEdificis ce) {
		this.ce = ce;
	}

}
