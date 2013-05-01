package barri;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;

/**
 *
 * @author albert
 */
public class CtrBarriDom {

    private static CtrBarriDom ctrBarri = null;
    private CjtBarris cjtBarris;
    
    private boolean trobat = false;

    /**
     * Crea una instancia del controlador de Barris
     */
    private CtrBarriDom() {
    }

    /**
     * Retorna la instancia del controlador de barris i si no existeix la crea
     *
     * @return CtrBarriDom , instancia del controlador de barris
     */
    public static CtrBarriDom ObteInstancia() {
        if (ctrBarri == null) {
            ctrBarri = new CtrBarriDom();
        }
        return ctrBarri;
    }

    /**
     * Crea un barri amb els parametres donats
     *
     * @param n Nom del barri
     * @param po Poblacio minima del barri
     * @param pr Presopost maxim del barri
     * @param c Cost de manteniment maxim
     * @param cl Classe social del barri
     * @param a Aparcaments minims del barri
     * @param xx Dimensio X del barri
     * @param yy Dimensio Y del barri
     */
    public void CreaBarri(String n, Classes cl, int xx, int yy) {
        Barri barri = new Barri(n, cl, xx, yy);
        cjtBarris.AfegirBarri(barri);
    }

    /**
     * Elimina un barri amb nom n
     *
     * @param n Nom del barri a eliminar
     */
    public void EliminarBarri(String n) {
        cjtBarris.EliminarBarri(n);
    }

    /**
     * Retorna una instancia del barri
     *
     * @param n Nom del barri
     * @return Barri, instancia del barri amb nom n
     */
    public Barri ObtenirBarri(String n) {
        return cjtBarris.GetBarri(n);
    }

    /**
     * Afegeix la restriccio r al barri amb nom nomBarri
     *
     * @param nomBarri Nom del barri al que se li afegeix la restriccio
     * @param r Restriccio a afegir al barri
     */
    public void AfegeixRestriccions(String nomBarri, RestriccioBarris r) {
        Barri b = ctrBarri.ObtenirBarri(nomBarri);
        b.AfegeixRestriccio(r);
    }

    /**
     * Guarda el Barri en format .o
     *
     * @param n Nom del barri que es guarda
     */
    public void GuardarBarri(String n) {
        //crida controlador persistencia
    }

    /**
     * Afegeix edifici e al barri amb nomBarri
     *
     * @param e Edifici a afegir al barri
     * @param nomBarri Nom del barri al que se li afegeix l'edifici
     */
    public void AfegirEdifici(Edifici e, String nomBarri) {
        Barri b = ctrBarri.ObtenirBarri(nomBarri);
        if (b != null) {
            b.carregaEdifici(e);
        }
    }

    /**
     * Genera una possible distribucio dels edificis del barri amb les
     * restriccions donades
     *
     * @param n Nom del barri a generar
     */
    public void GenerarBarri(String n) {
        Barri barri = cjtBarris.GetBarri(n);
    }

    /**
     * Elimina l'edicifi amb nomEdifici del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici que es vol eliminar
     */
    public void TreureEdifici(String nomBarri, String nomEdifici) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (aux != null) {
            aux.borraEdifici(nomEdifici);
        }
    }

    /**
     * Elimina la restriccio amb idRest del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRest Identificador de la restriccio que es vol eliminar
     */
    public void TreureRestriccio(String nomBarri, int idRest) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (aux != null) {
            aux.EliminarRestriccio(idRest);
        }
    }

    /**
     * Modifica el atribut atribut del barri nomBarri amb el valor valor
     *
     * @param nomBarri Nom del barri que es modifica
     * @param atribut Nom del atribut a modificar
     * @param valor valor que se li dona al atribut modificat
     */
    public void ModificarBarri(String nomBarri, String atribut, String valor) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (atribut.equals("Nom")) {
            aux.modificarNom(valor);
        } else if (atribut.equals("Pressupost")) {
            aux.modificarPressupost(Integer.parseInt(valor));
        } else if (atribut.equals("Poblacio")) {
            aux.modificarPoblacio(Integer.parseInt(valor));
        } else if (atribut.equals("Classe")) {
            aux.modificarClasse(StringToClase(valor));
        } else if (atribut.equals("Aparcament")) {
            aux.modificarAparcament(Integer.parseInt(valor));
        } else if (atribut.equals("MidaX")) {
            aux.modificarX(Integer.parseInt(valor));
        } else if (atribut.equals("MidaY")) {
            aux.modificarY(Integer.parseInt(valor));
        }
    }

    private Classes StringToClase(String c) {
        if (c.equals("Alta")) {
            return Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Classes.Mitja;
        } else {
            return Classes.Baixa;
        }
    }
    
    
    
    
    
    
    
	
	public boolean preparaBack(String n) {
		trobat = false;
		Barri aux = ObtenirBarri(n);
		boolean b = true;
		for (int i = 0; i < aux.tamRest(); i++) {
			if (aux.obteRest(i) instanceof RAlsada) {
				RestriccioBarris raux = aux.obteRest(i);
				
				if (!raux.CompleixRes()) {
					System.out.println("No compleix: " + raux.tr);
					b = false;
				}
			}
		}
		return b;
	}
	
	
	public boolean postBack(String n) {
		Barri aux = ObtenirBarri(n);
		boolean b = true;
		for (int i = 0; i < aux.tamRest(); i++) {
			if (aux.obteRest(i) instanceof RQuantitat && !((RQuantitat)aux.obteRest(i)).esMax()) {
				RQuantitat raux = (RQuantitat) aux.obteRest(i);
				if (raux.esMax() == false) {
					b = b && raux.CompleixRes();
				}
			}
		}
		return b;
	}
	
	
	
	
	void back(int id, int x, int y, Barri aux) {
		if (id < aux.consultarX() * aux.consultarY()) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			for (int i = 0; i < aux.tamEd() && !trobat; i++) {
				
				
				aux.obteEd(i).ModificarId(id);
				aux.afegirAlBarri(aux.obteEd(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + aux.obteEd(i).nom + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(aux.obteEd(i), x, y, aux)) {
					
					if (x == (aux.consultarX())-1) back(id+1, 0, y+1, aux);
					else back(id+1, x+1, y, aux);			
					
				}
				

			}
			if (!trobat) aux.borraIlla(x, y);
				
		} else {
			trobat = true;

		}
	}
	
	boolean legal(Edifici ed, int x, int y, Barri aux) {
		boolean comp = true;
		for (int i = 0; i < aux.tamRest(); i++) {
			TipusRest tr = aux.obteRest(i).obteTipus();
			
			if (tr == TipusRest.QUANTITAT) {
				RQuantitat raux = ((RQuantitat) aux.obteRest(i));
				if (raux.esMax()) comp = comp && raux.CompleixRes();
				
			}
			
			if (tr == TipusRest.DISTTIPUS) {
				comp = (comp && aux.obteRest(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + aux.obteRest(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			
			if (tr == TipusRest.INFUENCIA) {
				((RInfluencia)aux.obteRest(i)).recorreCjt();
				((RInfluencia)aux.obteRest(i)).assignaPos(x, y);
				comp = (comp && aux.obteRest(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + aux.obteRest(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			if (tr == TipusRest.COST) {
				if (ed.consultarSubclasse() == TipusEd.SER) {
					if( ((RCost)aux.obteRest(i)).esMax()) {
						int c = ((Servei)ed).ConsultarCost();
						((RCost)aux.obteRest(i)).augmentaCost(c);
						boolean b = ((RCost)aux.obteRest(i)).CompleixRes();
						comp = comp && b;
						if (!b) ((RCost)aux.obteRest(i)).redueixCost(c);
					}
				}
			}
			
			
			if (tr == TipusRest.IMPOSTOS) {
				RImpostos raux = ((RImpostos)aux.obteRest(i));
				int c;
				if (ed.consultarSubclasse() == TipusEd.HAB) {
					c = ((Habitatge)ed).ConsultarImpost();
					
				} else if (ed.consultarSubclasse() == TipusEd.NEG) {
					c = ((Negoci)ed).ConsultarImpost();
					
				} else c = -1; 
				
				raux.assignaImpAct(c);
				
				boolean b = raux.CompleixRes();
				comp = comp && b;
				
			}
			
			
		}
		
		System.out.println( " --> " + comp);
		System.out.println();
		return comp;
		
		
	}
	
	
	public void imprimeix(Barri aux) {
		for (int i = 0; i < aux.consultarX(); i++) {
			for (int j = 0; j < aux.consultarY(); j++) {
				String n;
				if (aux.consultarEdifici(i, j) != null) n = aux.consultarEdifici(i, j).ConsultarNom();
				else n = "nn";		
				System.out.print(n + " ");
			}
			System.out.println();
		}
		
	}
	
	
	void back2(int id, int x, int y, Barri aux) {
		if (id < aux.consultarX() * aux.consultarY()) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			int index = (int) (Math.random()* aux.tamEd());
			
			for (int j = 0; j < aux.tamEd() && !trobat; j++) {
				
				int i = (index+j)%aux.tamEd();
				
				aux.obteEd(i).ModificarId(id);
				aux.afegirAlBarri(aux.obteEd(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + aux.obteEd(i) + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(aux.obteEd(i), x, y, aux)) {
					
					if (x == (aux.consultarX())-1) back2(id+1, 0, y+1, aux);
					else back2(id+1, x+1, y, aux);			
					
				}
				System.out.println( " --> " + b);
				System.out.println();

			}
			if (!trobat) aux.borraIlla(x, y);
			
		} else {
			trobat = true;

		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}