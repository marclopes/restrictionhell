package barri;

public class RAlsada extends RestriccioBarris implements RCjtEd{
	
	CjtEdificis ce;
	int alsada;
	

	public RAlsada(int ID, int al, CjtEdificis ce) {
		super(ID);
		this.ce = ce;
		alsada = al;
		super.tr = TipusRest.ALSADA;
		
	}

	
	public boolean CompleixRes() {
		//boolean comp = true;
		for (int i = 0; i < ce.Tamany(); i++) {
			if (ce.ObtenirEdifici(i).ConsultarH() > alsada) return false;
		}
		
		return true;
	}
	
	public int consultarAlsada() {
		return alsada;
	}
	
	public void modificarAlsada(int a) {
		alsada = a;
	}
	
	
	public void assignaCe(CjtEdificis ce) {
		this.ce = ce;
	}

}
