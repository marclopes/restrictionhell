package barri;
public class RQuantitat extends RestriccioBarris implements RMax{
	
	
	int quant;
	Edifici ed;
	boolean max;
	//CjtEdificis ce;
	
	int q_act;

	public RQuantitat(int ID, int q, Edifici e, boolean m) {
		super(ID);
		quant = q;
		ed = e;
		max = m;
		//this.ce = ce;
		q_act = 0;
	}

	
	public boolean CompleixRes() {
		if (max && quant < q_act) return false;
		else if (!max && quant > q_act) return false;
		
		return true;
		
	}
	
	public void incrementa() {
		q_act++;
	}
	
	public boolean esAquest(Edifici e) {
		if (e.ConsultarNom().equals(ed.ConsultarNom())) return true;
		else return false;
	}
	
	public int consultarQuant() {
		return quant;
	}
	
	public void modificarQuant(int q) {
		quant = q;
	}
	
	public boolean esMax() {
		return max;
	}
	
	public void canviaMax(boolean m) {
		max = m;
	}
	
	public Edifici quinEdifici() {
		return ed;
	}
	
	public void assignaEdifici(Edifici e) {
		ed = e;
	}
	

}
