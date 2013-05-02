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
	
	public int ConsultarAlsada() {
		return alsada;
	}
	
	public void ModificarAlsada(int a) {
		alsada = a;
	}
	
	
	public void AssignaCe(CjtEdificis ce) {
		this.ce = ce;
	}
	
	public String Info() {
		return ("Alsada maxima "+ alsada);
	}

}
