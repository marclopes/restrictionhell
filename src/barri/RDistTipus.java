package barri;
import java.util.ArrayList;

import barri.Edifici.TipusEd;
<<<<<<< HEAD
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;
=======
import static barri.Edifici.TipusEd.HAB;
import static barri.Edifici.TipusEd.NEG;
import static barri.Edifici.TipusEd.SER;
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c

public class RDistTipus extends RDistancia implements RCjtEd{
	private String e1, e2;
	private CjtEdificis ce;

<<<<<<< HEAD
	public RDistTipus(int ID, int d, boolean m, String e1, String e2, Espai e) {
=======
        /**
         * Crea una instancia de la Restricció de distancia segons el tipus dels edificis.
         * @param ID Identificador de la restricció.
         * @param d Distancia que aplicara la restricció.
         * @param m Indica si la distancia es mínima o màxima.
         * @param e1 Primer edifici del qual es comprovarà el tipus.
         * @param e2 Segon edifici del qual es comprovarà el tipus.
         * @param e Espai on es comprovarà la restricció.
         */
	public RDistTipus(int ID, int d, boolean m, Edifici e1, Edifici e2, Espai e) {
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		super(ID, d, m, e);
		this.e1 = e1;
		this.e2 = e2;
		super.tr = TipusRest.DISTTIPUS;

	}
<<<<<<< HEAD
/**
=======

        /**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
	public boolean CompleixRes() {
		int dist_act;
		int x, y;
		x = y = 0;

		ArrayList<Pos> l1, l2;
		l1 = new ArrayList<Pos>();
		l2 = new ArrayList<Pos>();

		while (x < e.ObteX() && y < e.ObteY() && e.ExisteixElementxy(x, y)) {

			if (e.ExisteixElementxy(x, y)) {
				Object o = e.ConsultarElementxy(x, y);
				Edifici ed = ((Illa) e.ConsultarElementxy(x, y)).ConsultaEdifici();

				if (ed.consultarSubclasse() == e1.consultarSubclasse()) {
					switch (ed.consultarSubclasse()) {
					case HAB:
						if (((Habitatge) ed).consultarTipus() == ((Habitatge) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}

						break;

					case NEG:
						if (((Negoci) ed).consultarTipus() == ((Negoci) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
				
						break;

					case SER:
						if (((Servei) ed).consultarTipus() == ((Servei) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						break;

					default:
						break;
					}
					
				}
					if (ed.consultarSubclasse() == e2.consultarSubclasse()) {
						switch (ed.consultarSubclasse()) {
						case HAB:

							if (((Habitatge) ed).consultarTipus() == ((Habitatge) e2).consultarTipus()) {
								l2.add(new Pos(x, y));
							}
							break;

						case NEG:

							if (((Negoci) ed).consultarTipus() == ((Negoci) e2).consultarTipus()) {
								l2.add(new Pos(x, y));
							}
							break;

						case SER:

							if (((Servei) ed).consultarTipus() == ((Servei) e2).consultarTipus()) {
								l2.add(new Pos(x, y));
							}
							break;

						default:
							break;
						}
				}

			}
			x++;
			if (x == e.ObteX()) {
				x = 0;
				y++;
			}
		}

		Pos p1;
		Pos p2;
<<<<<<< HEAD
		
		//boolean b = true;
=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
		int di = 999999999;
		for (int i = 0; i < l1.size(); i++) {
			p1 = l1.get(i);
			for (int j = 0; j < l2.size(); j++) {
				p2 = l2.get(j);
				
				if (dist(p1.x, p1.y, p2.x, p2.y) < di && dist(p1.x, p1.y, p2.x, p2.y) != 0) di = dist(p1.x, p1.y, p2.x, p2.y);

			}	
			
			
		}
		if(max && di > dist) return false;
		if (!max && di < dist) return false;
		return true;

	}
**/

<<<<<<< HEAD
	public String ConsultarEd1() {
		return e1;
	}

	public void ModificarEd1(String e) {
		e1 = e;
	}

	public String ConsultarEd2() {
		return e2;
	}

	public void ModificarEd2(String e) {
		e2 = e;
	}
	
	
	

	
	public boolean prop(ArrayList<Assignacions> va, Assignacio a) {
		int na = afectat(a.e);
		System.out.println(" - " + a.e.ConsultarNom() + " es el " + na);
		
		if (na == 1) na = 2;
		else if (na == 2) na = 1;
		else if (na == 3) na = 3;
//		
//		int size = 0;
//		for (int i = 0; i < va.size(); i++) {
//			size += va.get(i).va.size();
//			Assignacions as = va.get(i);
//			for (int k = 0; k < as.va.size(); k++) {
//				System.out.println(as.va.get(k));
//			}
//		}
//		System.out.println("ABANS: " + size);
		
		if (max) {
			if (na == 2 || na == 3) {	
//				boolean t = false;
				int pot_ser = -1;
				int p = 0;
				for (int i = 0; i < va.size() && pot_ser == -1; i++) {
					
					Assignacions aux = va.get(i);
					
					if (aux.val == false) {
						p++;
						Assignacio aa = aux.asAct;
						//System.out.println("La var " + i + " ja ta: " +aux.asAct);
						if (afectat(aa.e) == na) {
							//if(i+1 < va.size() && !va.get(i+1).val == false) {
								if (dist(a.x, a.y, aa.x, aa.y) <= dist) {
									pot_ser = i;
									System.out.println("pot ser: " + pot_ser);
									return true;
								}
								
							//}
						}
					} else {
					
						for (int j = 0; j < aux.va.size(); j++) {
							Assignacio aa = aux.va.get(j);
							if(aa.val && afectat(aa.e) == na) {
								if (dist(a.x, a.y, aa.x, aa.y) <= dist) {
									pot_ser = i;
									System.out.println("pot ser: " + pot_ser);
									break;
									
								}
							}
						}
						
					}
				}
				
				if (pot_ser != -1) {
					Assignacions aux = va.get(pot_ser);
					for (int j = 0; j < aux.va.size(); j++) {
						Assignacio aa = aux.va.get(j);
						
						if(afectat(aa.e) == na) {
//							t = true;
							if (dist(a.x, a.y, aa.x, aa.y) > dist) {
								
								aux.va.get(j).val = false;
								//j--;
								
							} else {
								
							}
							
						}
					}
				}
					
				if (pot_ser != -1) {
//					Assignacions sw = va.get(p);
//					va.set(p, va.get(pot_ser));
//					va.set(pot_ser, sw);
					return true;
					
					
				} else {
					return false;
				}
			
				
			} else System.out.println("Pero no fai res!");
			
			
			
			
		} else {
			// dist minima
			int n1 = -1;
			int c = -1;
			for (int i = 0; i < va.size(); i++) {
				Assignacions aux = va.get(i);
				if (aux.val == true) {					
					//System.out.println();
					//System.out.println(" + POS VA: " + i + " SIZE: " + aux.va.size());
					for (int j = 0; j < aux.va.size(); j++) {
						Assignacio aa = aux.va.get(j);
						//System.out.println(" + TROIKKKKKK " + aa.e.ConsultarNom() + " de " + aa.x + "," + aa.y + " --> " + c + " i j = " + j);
						
						if (afectat(aa.e) == na) {
							if (dist(a.x, a.y, aa.x, aa.y) < dist) {
								//System.out.println(" + PROHIBIT " + aa.e.ConsultarNom() + " de " + aa.x + "," + aa.y);
								aux.va.get(j).val = false;
								//j--;
								
							} else {
								c = i;
							}
						} else {
							//System.out.println(" + NP " + aa.e.ConsultarNom() + " de " + aa.x + "," + aa.y);
						}
					}
					
			} else {
				n1 = i;
			}
				
				
			}
			
			if (n1 != -1 && c != -1 && n1+1 < va.size()) {
				System.out.println(n1+1 + " " + c);
				Assignacions sw = va.get(n1+1);
				va.set(n1+1, va.get(c));
				va.set(c, sw);
			}
			
			return true;
		}
		return true;
		
		
	}
	
	public boolean afecta(Assignacio a) {
		if (afectat(a.e) != 0) return true;
		else return false;
	}
	

	public int afectat(Edifici ed) {
		int val1 = 0;
		int val2 = 0;
		
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
		
		
		
		
		if (ed.ConsultarNom().equals(e2)) {
			val2 = 2;
			
		} else if (ed.consultarSubclasse() == StringTedToEnum(e2)) {
			val2 = 2;
			
		} else if (ed instanceof Habitatge) {
			if (((Habitatge)ed).consultarTipus() == StringHabtoEnum(e2)) {
				val2 = 2;
			}
			
		} else if (ed instanceof Negoci) {
			if (((Negoci)ed).consultarTipus() == StringNegtoEnum(e2)) {
				val2 = 2;
			}
			
		} else if (ed instanceof Servei) {
			if (((Servei)ed).consultarTipus() == StringSertoEnum(e2)) {
				val2 = 2;
			}
		}
		
		
		
		
		
		
		
		return val1 + val2;
	}
	
=======
        /**
         * Consulta el primer edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public Edifici ConsultarEd1() {
		return e1;
	}

        /**
         * Modifica el primer edifici de la restricció.
         * @return Nou edifici de la restricció.
         */
	public void ModificarEd1(Edifici e) {
		e1 = e;
	}

        /**
         * Consulta el segon edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public Edifici ConsultarEd2() {
		return e2;
	}

        /**
         * Modifica el segon edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public void ModificarEd2(Edifici e) {
		e2 = e;
	}
	
        /**
         * Consulta informació sobre la restricció.
         * @return Informació sobre la restricció.
         */
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
	public String Info() {
		String s;
		if (max) s = "maxima";
		else s = "minima";
		String s2, s3;
		s2 = "null";
		s3 = "null";
		/**
		if (e1 != null) {
			if (e1.consultarSubclasse() == TipusEd.NEG) s2 = ((Negoci)e1).consultarTipus().toString();
			else if (e1.consultarSubclasse() == TipusEd.HAB) s2 = ((Habitatge)e1).consultarTipus().toString();
			else if (e1.consultarSubclasse() == TipusEd.SER) s2 = ((Servei)e1).consultarTipus().toString();
		}
		if (e2 != null) {
			if (e2.consultarSubclasse() == TipusEd.NEG) s3 = ((Negoci)e2).consultarTipus().toString();
			else if (e2.consultarSubclasse() == TipusEd.HAB) s3 = ((Habitatge)e2).consultarTipus().toString();
			else if (e2.consultarSubclasse() == TipusEd.SER) s3 = ((Servei)e2).consultarTipus().toString();
		}
		**/
		return ("Distancia " + s + " " + dist + " entre "+ e1 + " i " + e2);
	}

	public void AssignaCe(CjtEdificis ce) {
		this.ce = ce;
		
	}
<<<<<<< HEAD
	
	
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
		@Override
		public boolean CompleixRes() {
			// TODO Auto-generated method stub
			return true;
		}


=======
>>>>>>> e4c5f07292b716dd9aa4f259b244c09e9543232c
}
