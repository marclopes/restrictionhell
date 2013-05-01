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
            b.CarregaEdifici(e);
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
            aux.BorraEdifici(nomEdifici);
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
            aux.ModificarNom(valor);
        } else if (atribut.equals("Pressupost")) {
            aux.ModificarPressupost(Integer.parseInt(valor));
        } else if (atribut.equals("Poblacio")) {
            aux.ModificarPoblacio(Integer.parseInt(valor));
        } else if (atribut.equals("Classe")) {
            aux.ModificarClasse(StringToClase(valor));
        } else if (atribut.equals("Aparcament")) {
            aux.ModificarAparcament(Integer.parseInt(valor));
        } else if (atribut.equals("MidaX")) {
            aux.ModificarX(Integer.parseInt(valor));
        } else if (atribut.equals("MidaY")) {
            aux.ModificarY(Integer.parseInt(valor));
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
		for (int i = 0; i < aux.TamRest(); i++) {
			if (aux.ObteRest(i) instanceof RAlsada) {
				RestriccioBarris raux = aux.ObteRest(i);
				
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
		for (int i = 0; i < aux.TamRest(); i++) {
			if (aux.ObteRest(i) instanceof RQuantitat && !((RQuantitat)aux.ObteRest(i)).EsMax()) {
				RQuantitat raux = (RQuantitat) aux.ObteRest(i);
				if (raux.EsMax() == false) {
					b = b && raux.CompleixRes();
				}
			}
		}
		return b;
	}
	
	
	
	
	void back(int id, int x, int y, Barri aux) {
		if (id < aux.ConsultarX() * aux.ConsultarY()) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			for (int i = 0; i < aux.TamEd() && !trobat; i++) {
				
				
				aux.ObteEd(i).ModificarId(id);
				aux.AfegirAlBarri(aux.ObteEd(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + aux.ObteEd(i).nom + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(aux.ObteEd(i), x, y, aux)) {
					
					if (x == (aux.ConsultarX())-1) back(id+1, 0, y+1, aux);
					else back(id+1, x+1, y, aux);			
					
				}
				

			}
			if (!trobat) aux.BorraIlla(x, y);
				
		} else {
			trobat = true;

		}
	}
	
	boolean legal(Edifici ed, int x, int y, Barri aux) {
		boolean comp = true;
		for (int i = 0; i < aux.TamRest(); i++) {
			TipusRest tr = aux.ObteRest(i).obteTipus();
			
			if (tr == TipusRest.QUANTITAT) {
				RQuantitat raux = ((RQuantitat) aux.ObteRest(i));
				if (raux.EsMax()) comp = comp && raux.CompleixRes();
				
			}
			
			if (tr == TipusRest.DISTTIPUS) {
				comp = (comp && aux.ObteRest(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + aux.ObteRest(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			
			if (tr == TipusRest.INFUENCIA) {
				((RInfluencia)aux.ObteRest(i)).RecorreCjt();
				((RInfluencia)aux.ObteRest(i)).AssignaPos(x, y);
				comp = (comp && aux.ObteRest(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + aux.ObteRest(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			if (tr == TipusRest.COST) {
				if (ed.consultarSubclasse() == TipusEd.SER) {
					if( ((RCost)aux.ObteRest(i)).EsMax()) {
						int c = ((Servei)ed).ConsultarCost();
						((RCost)aux.ObteRest(i)).AugmentaCost(c);
						boolean b = ((RCost)aux.ObteRest(i)).CompleixRes();
						comp = comp && b;
						if (!b) ((RCost)aux.ObteRest(i)).RedueixCost(c);
					}
				}
			}
			
			
			if (tr == TipusRest.IMPOSTOS) {
				RImpostos raux = ((RImpostos)aux.ObteRest(i));
				int c;
				if (ed.consultarSubclasse() == TipusEd.HAB) {
					c = ((Habitatge)ed).ConsultarImpost();
					
				} else if (ed.consultarSubclasse() == TipusEd.NEG) {
					c = ((Negoci)ed).ConsultarImpost();
					
				} else c = -1; 
				
				raux.AssignaImpAct(c);
				
				boolean b = raux.CompleixRes();
				comp = comp && b;
				
			}
			
			
		}
		
		System.out.println( " --> " + comp);
		System.out.println();
		return comp;
		
		
	}
	
	
	public void imprimeix(Barri aux) {
		for (int i = 0; i < aux.ConsultarX(); i++) {
			for (int j = 0; j < aux.ConsultarY(); j++) {
				String n;
				if (aux.ConsultarEdifici(i, j) != null) n = aux.ConsultarEdifici(i, j).ConsultarNom();
				else n = "nn";		
				System.out.print(n + " ");
			}
			System.out.println();
		}
		
	}
	
	
	void back2(int id, int x, int y, Barri aux) {
		if (id < aux.ConsultarX() * aux.ConsultarY()) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			int index = (int) (Math.random()* aux.TamEd());
			
			for (int j = 0; j < aux.TamEd() && !trobat; j++) {
				
				int i = (index+j)%aux.TamEd();
				
				aux.ObteEd(i).ModificarId(id);
				aux.AfegirAlBarri(aux.ObteEd(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + aux.ObteEd(i) + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(aux.ObteEd(i), x, y, aux)) {
					
					if (x == (aux.ConsultarX())-1) back2(id+1, 0, y+1, aux);
					else back2(id+1, x+1, y, aux);			
					
				}
				System.out.println( " --> " + b);
				System.out.println();

			}
			if (!trobat) aux.BorraIlla(x, y);
			
		} else {
			trobat = true;

		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}