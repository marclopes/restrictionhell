package barri;

public class RAparcament extends RestriccioBarris implements REspai { 
		
		int ap, apact;
		//CjtEdificis ce;
		private Espai e;
		
		int aMin;

		public RAparcament(int ID, int a, Espai e) {
			super(ID);
			ap = a;
			this.e = e;
			super.tr = TipusRest.APARCAMENT;
			apact = 0;
			aMin = 0;
			
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
		
		public int ConsultarAp() {
			return ap;
		}
		
		public void ModificarImp(int a) {
			ap = a;
		}
		
		
		public void AssignaApAct(int a) {
			apact = a;
		}
		
		
		public boolean CompleixRes() {
			if (e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return CompleixFi();
			
			if (apact == -1) return true;
			return (apact >= aMin);
			
		}
		
		public boolean CompleixFi() {
			int n = 0;
			for (int i = 0; i < e.ObteX(); i++) {
				for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
					Edifici ed = ((Illa) e.ConsultarElementxy(i, j)).ConsultaEdifici();
					switch (ed.consultarSubclasse()) {
					case HAB:
						n = n + ((Habitatge) ed).ConsultarAparcament();
						
						break;

					case NEG:
						n = n + ((Negoci) ed).ConsultarAparcament();
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
			if (n >= ap) return true;
			else return false;
			
		}

		

		private int CalcMin() {
			int s = e.ObteX() * e.ObteY();
			s = 4*s/5;
			s = ap / s;
			return s;
		}

		@Override
		public void AssignaEspai(Espai e) {
			this.e = e;
			aMin = CalcMin();
			
		}
		
	}
		
