package barri;

import barri.Edifici.TipusEd;
import barri.RestriccioBarris.Pos;



public class RImpostos extends RestriccioBarris implements REspai{
	
	int imp, ia;
	//CjtEdificis ce;
	Espai e;
	
	int iMin;

	public RImpostos(int ID, int i, Espai e) {
		super(ID);
		imp = i;
		this.e = e;
		super.tr = TipusRest.IMPOSTOS;
		ia = 0;
		iMin = 0;
		
	}

	/**
	public boolean CompleixRes() {
		int c = 0;
		
		for (int i = 0; i < ce.tamany(); i++) {
			Edifici aux = ce.obtenirEdifici(i);
			TipusEd t = aux.consultarSubclasse();
			
			if (t == TipusEd.HAB) c = c + ((Habitatge) aux).ConsultarImpost();
			else if (t == TipusEd.NEG) c = c + ((Negoci) aux).ConsultarImpost();
		}
		
		if (c >= imp) return true;
		else return false;
	}
	**/
	
	public int ConsultarImp() {
		return imp;
	}
	
	public void ModificarImp(int i) {
		imp = i;
	}
	
	
	public void AssignaImpAct(int i) {
		ia = i;
	}
	
	
	public boolean CompleixRes() {
		if (e.ExisteixElementxy(e.obteX()-1, e.obteY()-1)) return CompleixFi();
		
		if (ia == -1) return true;
		return (ia >= iMin);
		
	}
	
	public boolean CompleixFi() {
		int n = 0;
		for (int i = 0; i < e.obteX(); i++) {
			for (int j = 0; j < e.obteY() && e.ExisteixElementxy(i, j); j++) {
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
		/**
		if (n < imp) {
			System.out.println("iTotal = " + n  + " Semblava que si pero noooooo!!!");
			System.exit(1);
		}
		**/
		if (n >= imp) return true;
		else return false;
		
	}

	
	private int CalcMin() {
		int s = e.obteX() * e.obteY();
		s = 4*s/5;
		s = imp / s;
		return s;
	}

	@Override
	public void AssignaEspai(Espai e) {
		this.e = e;
		iMin = CalcMin();
		
	}
	
	

}
