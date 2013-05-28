package barri;

import barri.Edifici.TipusEd;

public class RAparcament extends RestriccioBarris implements RCjtEd { 
		
		private int ap, apact;
		private CjtEdificis ce;
		
<<<<<<< HEAD
		
		//int aMin;

		public RAparcament(int ID, int a, CjtEdificis ce) {
=======
		int ap, apact;
		private Espai e;		
		int aMin;

                /**
                 * Crea una instancia de la restricció d'aparcament.
                 * @param ID Identificador de la restricció.
                 * @param a Aparcament assignat.
                 * @param e Espai on s'aplica la restricció.
                 */
		public RAparcament(int ID, int a, Espai e) {
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
			super(ID);
			ap = a;
			this.ce = ce;
			super.tr = TipusRest.APARCAMENT;
			apact = 0;
			//aMin = 0;
			
		}
<<<<<<< HEAD


=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		
                /**
                 * Consulta l'aparcament assignat a la restricció.
                 * @return L'aparcament assignat a la restricció.
                 */
		public int ConsultarAp() {
			return ap;
		}
		
                /**
                 * Modifica l'aparcament assignat a la restricció.
                 * @param a Nou aparcament assignat a la restricció.
                 */
		public void ModificarImp(int a) {
			ap = a;
		}
		
		/**
                 * Assigna l'aparcament actual de la restricció.
                 * @param a 
                 */
		public void AssignaApAct(int a) {
			apact = a;
		}
		
		/**
<<<<<<< HEAD
		public boolean CompleixRes2() {
=======
                 * Comprova que es compleix la restricció.
                 * @return Cert si es comleix la restricció.
                 */
		public boolean CompleixRes() {
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
			if (e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return CompleixFi();
			
			if (apact == -1) return true;
			return (apact >= aMin);
			
		}
		
                /**
                 * Comprova que es compleixi la restricció.
                 * @return cert si es compleix la restricció.
                 */
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
<<<<<<< HEAD
			
=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
			if (n >= ap) return true;
			else return false;
			
		}
		
		
		private int CalcMin() {
			int s = e.ObteX() * e.ObteY();
			s = 4*s/5;
			s = ap / s;
			return s;
		}	
		**/
		
		public String Info() {
			return ("Aparcament minim "+ ap);
		}



		@Override
		public void AssignaCe(CjtEdificis ce) {
			this.ce = ce;
			
		}



		@Override
		public boolean CompleixRes() {
			apact = 0;
			//boolean comp = true;
			for (int i = 0; i < ce.Tamany(); i++) {
				if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.HAB)
					apact = apact + ((Habitatge)ce.ObtenirEdifici(i)).ConsultarAparcament();
				
				if (ce.ObtenirEdifici(i).consultarSubclasse() == TipusEd.NEG)
					apact = apact + ((Negoci)ce.ObtenirEdifici(i)).ConsultarAparcament();
			}
			
			if (apact < ap) return false;
			else return true;
		}
		
	}
		