package barri;

import java.util.ArrayList;

import barri.Edifici.TipusEd;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class RQuantitat extends RestriccioBarris {
	
	
	int quant, qa;
	String e1;
//	boolean max;
	Espai e;
	
        /**
         * Crea una instancia de la restricció de quantitat.
         * @param ID Identificador dde la restricció.
         * @param q Quantitat que volem definir.
         * @param e Edifici sobre el que volem definir la quantitat.
         * @param m Cert -> Quantitat màxima. Fals -> Quantitat mínima.
         */
	public RQuantitat(int ID, int q, String e) {
		super(ID);
		quant = q;
		e1 = e;
		super.tr = TipusRest.QUANTITAT;
		qa = 0;
	}

	/**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció, fals en cas contrari.
         */
	
	/**
	public boolean CompleixRes() {
		int q = 0;
		for (int i = 0; i < e.ObteX(); i++) {
			for (int j = 0; j < e.ObteY() && e.ExisteixElementxy(i, j); j++) {
				Edifici aux = ((Illa)e.ConsultarElementxy(i, j)).ConsultaEdifici();
				if (aux.consultarSubclasse() == ed.consultarSubclasse()) {
					if (aux.tipusEd == TipusEd.HAB) {
						if (((Habitatge)aux).consultarTipus() ==  ((Habitatge)ed).consultarTipus()) q++;
						
					} else if (aux.tipusEd == TipusEd.NEG) {
						if (((Negoci)aux).consultarTipus() ==  ((Negoci)ed).consultarTipus()) q++;
						
					} else {
						if (((Servei)aux).consultarTipus() ==  ((Servei)ed).consultarTipus()) q++;
						
					}
					
					
				}
				
			}
		}
		
		
		if (max && q > quant) return false;
		if (!max && q < quant && e.ExisteixElementxy(e.ObteX()-1, e.ObteY()-1)) return false;
		return true;
	}
	**/

	/**
         * Cromprova si l'edifici esta afectat per la restricció.
         * @param e Edifici que volem comprovar.
         * @return Cert si l'edifici està afectat per la restricció, fals en cas contrari.
         */
	
	
	
	/**
         * Consulta la quantitat assignada a la restricció.
         * @return La quantitat assignada a la restricció.
         */
	public int ConsultarQuant() {
		return quant;
	}
	
        /**
         * Modifica la quantitat assignada a la restricció.
         * @param q Nova quantitat que volem assignar.
         */
	public void ModificarQuant(int q) {
		quant = q;
	}
	
        /**
         * Consulta si la quantitat es màxima o mínima.
         * @return Cert -> màxim. Fals -> mínim.
         */
	
        /**
         * Consulta l'edifici afectat per la restricció.
         * @return L'edifici afectat per la restricció.
         */
	public String QuinEdifici() {
		return e1;
	}
	
        /**
         * Modifica l'edifici afectat per la restricció.
         * @param e L'edifici afectat per la restricció.
         */
	public void AssignaEdifici(String e) {
		e1 = e;
	}

  
        /**
         * Mostra informació sobre la restricció.
         * @return La informació de la restricció.
         */
	public String Info() {
		
		return ("Quantitat maxima de " + e1 + " = " + quant);
	}
	
        /**
         * Converteix el tipus d'edifici en un string.
         * @param e Edifici que volem convertir el seu tipus.
         * @return El tipus de l'edifici.
         */
	private String StrTipus(Edifici e) {
		
		if (e == null) return null;
		
			if (e.consultarSubclasse() == TipusEd.HAB) {
				return ((Habitatge)e).consultarTipus().toString();
				
			} else if (e.consultarSubclasse() == TipusEd.NEG) {
				return ((Negoci)e).consultarTipus().toString();
				
			} else {
				return ((Servei)e).consultarTipus().toString();
				
			}
	}

		@Override
		public boolean prop(ArrayList<Assignacions> va, Assignacio a) {
			qa++;
			if (qa == quant) {
				for (int i = 0; i < va.size(); i++) {
					Assignacions aux = va.get(i);
					if (aux.val) {
						for (int j = 0; j < aux.va.size(); j++) {
							Assignacio aa = aux.va.get(j);
							
							if (afecta(aa)) aa.val = false;
						}
					}
				}
			}
			return true;
		}

		@Override
		public boolean afecta(Assignacio a) {
			Edifici ed = a.e;
			int val1 = 0;
			
			if (ed.ConsultarNom().equals(e1)) {
				val1 = 1;
				
			} else if (ed.consultarSubclasse() == StringTedToEnum(e1)) {
				val1 = 1;
				
			} else if (ed instanceof Habitatge) {
				if (((Habitatge)ed).consultarTipus() == StringHabtoEnum(e1)) {
					val1 = 1;
				}
				
			} else if (ed instanceof Negoci) {
				if (((Negoci)ed).consultarTipus() == StringNegtoEnum(e1)) {
					val1 = 1;
				}
				
			} else if (ed instanceof Servei) {
				if (((Servei)ed).consultarTipus() == StringSertoEnum(e1)) {
					val1 = 1;
				}
			}
			
			
			
			return (val1==1);
		}

		@Override
		public boolean CompleixRes() {
			// TODO Auto-generated method stub
			return false;
		}
	
		

		
		private TipusEd StringTedToEnum(String n) {
			try {
				TipusEd et = TipusEd.valueOf(n);
				return et;
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
		
		 private TipusHab StringHabtoEnum(String n) {
		        if (n.equals("Casa")) {
		            return TipusHab.Casa;
		        } else if (n.equals("Pis")) {
		            return TipusHab.Pis;
		        } else if (n.equals("Mansio")) {
		            return TipusHab.Mansio;
		        } else if (n.equals("Xalet")) {
		            return TipusHab.Xalet;
		        }
		        return null;
		    }

		    private TipusServei StringSertoEnum(String n) {
		        if (n.equals("Hospital")) {
		            return TipusServei.Hospital;
		        } else if (n.equals("Escola")) {
		            return TipusServei.Escola;
		        } else if (n.equals("Policia")) {
		            return TipusServei.Policia;
		        } else if (n.equals("Preso")) {
		            return TipusServei.Preso;
		        } else if (n.equals("Bombers")) {
		            return TipusServei.Bombers;
		        } else if (n.equals("Parc")) {
		            return TipusServei.Parc;
		        } else if (n.equals("Centre Cultural")) {
		            return TipusServei.Centre_Cultural;
		        }
		        return null;
		    }

		    private TipusNegoci StringNegtoEnum(String n) {
		        if (n.equals("Discoteca")) {
		            return TipusNegoci.Discoteca;
		        } else if (n.equals("Banc")) {
		            return TipusNegoci.Banc;
		        } else if (n.equals("Bar")) {
		            return TipusNegoci.Bar;
		        } else if (n.equals("Restaurant")) {
		            return TipusNegoci.Restaurant;
		        } else if (n.equals("Botiga alimentacio")) {
		            return TipusNegoci.Botiga_alimentacio;
		        } else if (n.equals("Botiga roba")) {
		            return TipusNegoci.Botiga_roba;
		        } else if (n.equals("Escola privada")) {
		            return TipusNegoci.Escola_privada;
		        } else if (n.equals("Clinica")) {
		            return TipusNegoci.Clinica;
		        }
		        return null;
		    }

}
