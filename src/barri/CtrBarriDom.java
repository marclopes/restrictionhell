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
        cjtBarris = new CjtBarris();
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
    public int CreaBarri(String n, Classes cl, int xx, int yy) {
        Barri barri = new Barri(n, cl, xx, yy);
        if (cjtBarris.ExisteixBarri(n)) {
            return -1;
        }
        cjtBarris.AfegirBarri(barri);
        return 0;
    }

    /**
     * Elimina un barri amb nom n
     *
     * @param n Nom del barri a eliminar
     */
    public int EliminarBarri(String n) {
        if (!cjtBarris.ExisteixBarri(n)) {
            return -1;
        }
        cjtBarris.EliminarBarri(n);
        return 0;
    }

    /**
     * Retorna una instancia del barri
     *
     * @param n Nom del barri
     * @return Barri, instancia del barri amb nom n
     */
    public Barri ObtenirBarri(String n) {
        return cjtBarris.ObtenirBarri(n);
    }

    /**
     * Afegeix la restriccio r al barri amb nom nomBarri
     *
     * @param nomBarri Nom del barri al que se li afegeix la restriccio
     * @param r Restriccio a afegir al barri
     */
    public int AfegeixRestriccions(String nomBarri, RestriccioBarris r) {
        Barri b = ctrBarri.ObtenirBarri(nomBarri);
        if (b == null) {
            return -1;
        }
        return b.AfegeixRestriccio(r);
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
    public int AfegirEdifici(Edifici e, String nomBarri) {
        Barri b = ctrBarri.ObtenirBarri(nomBarri);
        if (b != null) {
            if (b.ExisteixEdifici(e.ConsultarNom())) {
                return -1;
            }
            return b.CarregaEdifici(e);
        }
        return -1;
    }

    /**
     * Genera una possible distribucio dels edificis del barri amb les
     * restriccions donades
     *
     * @param n Nom del barri a generar
     */
    public int GenerarBarri(String n) {
        Barri aux = ObtenirBarri(n);
        if (ObtenirBarri(n) != null) {
            if (PreparaBack(n)) {
                Back2(0, 0, 0, aux);
                PostBack(n);
                Imprimeix(aux);
                return 0;
            }

        }
        return -1;
    }

    /**
     * Elimina l'edicifi amb nomEdifici del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici que es vol eliminar
     */
    public int TreureEdifici(String nomBarri, String nomEdifici) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (aux == null) {
            return -1;
        }
        return aux.BorraEdifici(nomEdifici);

    }

    /**
     * Elimina la restriccio amb idRest del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRest Identificador de la restriccio que es vol eliminar
     */
    public int TreureRestriccio(String nomBarri, int idRest) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (aux == null) {
            return -1;
        }
        return aux.EliminarRestriccio(idRest);

    }

    /**
     * Modifica el atribut atribut del barri nomBarri amb el valor valor
     *
     * @param nomBarri Nom del barri que es modifica
     * @param atribut Nom del atribut a modificar
     * @param valor valor que se li dona al atribut modificat
     */
    public int ModificarBarri(String nomBarri, String atribut, String valor) {
        Barri aux = ctrBarri.ObtenirBarri(nomBarri);
        if (aux == null) {
            return -1;
        }
        if (atribut.equals("Nom")) {
            aux.ModificarNom(valor);
            return 0;
            //  } else if (atribut.equals("Pressupost")) {
            //    aux.ModificarPressupost(Integer.parseInt(valor));
            // } else if (atribut.equals("Poblacio")) {
            //    aux.ModificarPoblacio(Integer.parseInt(valor));
        } else if (atribut.equals("Classe")) {
            aux.ModificarClasse(StringToClase(valor));
            return 0;
            //} else if (atribut.equals("Aparcament")) {
            //    aux.ModificarAparcament(Integer.parseInt(valor));
        } else if (atribut.equals("MidaX")) {
            aux.ModificarX(Integer.parseInt(valor));
            return 0;
        } else if (atribut.equals("MidaY")) {
            aux.ModificarY(Integer.parseInt(valor));
            return 0;
        }
        return -1;
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
    
    
    
    
    
    
    
	
	public boolean PreparaBack(String n) {
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
	
	
	public boolean PostBack(String n) {
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
	
	
	
	
	void Back(int id, int x, int y, Barri aux) {
		if (id < aux.ConsultarX() * aux.ConsultarY()) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			for (int i = 0; i < aux.TamEd() && !trobat; i++) {
				
				
				aux.ObteEd(i).ModificarId(id);
				aux.AfegirAlBarri(aux.ObteEd(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + aux.ObteEd(i).nom + " a " + x + ", " + y);
				boolean b;
				if ( b = Legal(aux.ObteEd(i), x, y, aux)) {
					
					if (x == (aux.ConsultarX())-1) Back(id+1, 0, y+1, aux);
					else Back(id+1, x+1, y, aux);			
					
				}
				

			}
			if (!trobat) aux.BorraIlla(x, y);
				
		} else {
			trobat = true;

		}
	}
	
	boolean Legal(Edifici ed, int x, int y, Barri aux) {
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
	
	
	public void Imprimeix(Barri aux) {
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
	
	
	/*void Back2(int id, int x, int y, Barri aux) {
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

    private void Back(int id, int x, int y, Barri aux) {
        if (id < aux.ConsultarX() * aux.ConsultarY()) {
            //if (id < (10)) {
            System.out.println("BAAAACK id:" + id + " pos: " + x + ", " + y);

            for (int i = 0; i < aux.TamEd() && !trobat; i++) {


                aux.ObteEd(i).ModificarId(id);
                aux.AfegirAlBarri(aux.ObteEd(i), id, x, y);


                //if (x == 14 && y == 14) continue;
                System.out.println("Intento afegir: " + id + " " + i + " " + aux.ObteEd(i).nom + " a " + x + ", " + y);
                boolean b;
                if (b = Legal(aux.ObteEd(i), x, y, aux)) {

                    if (x == (aux.ConsultarX()) - 1) {
                        Back(id + 1, 0, y + 1, aux);
                    } else {
                        Back(id + 1, x + 1, y, aux);
                    }

                }


            }
            if (!trobat) {
                aux.BorraIlla(x, y);
            }

        } else {
            trobat = true;

        }
    }

    boolean Legal(Edifici ed, int x, int y, Barri aux) {
        boolean comp = true;
        for (int i = 0; i < aux.TamRest(); i++) {
            TipusRest tr = aux.ObteRest(i).obteTipus();

            if (tr == TipusRest.QUANTITAT) {
                RQuantitat raux = ((RQuantitat) aux.ObteRest(i));
                if (raux.EsMax()) {
                    comp = comp && raux.CompleixRes();
                }

            }

            if (tr == TipusRest.DISTTIPUS) {
                comp = (comp && aux.ObteRest(i).CompleixRes());

                if (!comp) {
                    System.out.println(" --> " + false + "  " + aux.ObteRest(i).obteTipus());
                    System.out.println();
                    //comp = false;
                }
            }


            if (tr == TipusRest.INFUENCIA) {
                ((RInfluencia) aux.ObteRest(i)).RecorreCjt();
                ((RInfluencia) aux.ObteRest(i)).AssignaPos(x, y);
                comp = (comp && aux.ObteRest(i).CompleixRes());

                if (!comp) {
                    System.out.println(" --> " + false + "  " + aux.ObteRest(i).obteTipus());
                    System.out.println();
                    //comp = false;
                }
            }

            if (tr == TipusRest.COST) {
                if (ed.consultarSubclasse() == TipusEd.SER) {
                    if (((RCost) aux.ObteRest(i)).EsMax()) {
                        int c = ((Servei) ed).ConsultarCost();
                        ((RCost) aux.ObteRest(i)).AugmentaCost(c);
                        boolean b = ((RCost) aux.ObteRest(i)).CompleixRes();
                        comp = comp && b;
                        if (!b) {
                            ((RCost) aux.ObteRest(i)).RedueixCost(c);
                        }
                    }
                }
            }


            if (tr == TipusRest.IMPOSTOS) {
                RImpostos raux = ((RImpostos) aux.ObteRest(i));
                int c;
                if (ed.consultarSubclasse() == TipusEd.HAB) {
                    c = ((Habitatge) ed).ConsultarImpost();

                } else if (ed.consultarSubclasse() == TipusEd.NEG) {
                    c = ((Negoci) ed).ConsultarImpost();

                } else {
                    c = -1;
                }

                raux.AssignaImpAct(c);

                boolean b = raux.CompleixRes();
                comp = comp && b;

            }


        }

        System.out.println(" --> " + comp);
        System.out.println();
        return comp;


    }

    public void Imprimeix(Barri aux) {
        for (int i = 0; i < aux.ConsultarX(); i++) {
            for (int j = 0; j < aux.ConsultarY(); j++) {
                String n;
                if (aux.ConsultarEdifici(i, j) != null) {
                    n = aux.ConsultarEdifici(i, j).ConsultarNom();
                } else {
                    n = "nn";
                }
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    void Back2(int id, int x, int y, Barri aux) {
        if (id < aux.ConsultarX() * aux.ConsultarY()) {
            //if (id < (10)) {
            System.out.println("BAAAACK id:" + id + " pos: " + x + ", " + y);

            int index = (int) (Math.random() * aux.TamEd());

            for (int j = 0; j < aux.TamEd() && !trobat; j++) {

                int i = (index + j) % aux.TamEd();

                aux.ObteEd(i).ModificarId(id);
                aux.AfegirAlBarri(aux.ObteEd(i), id, x, y);


                //if (x == 14 && y == 14) continue;
                System.out.println("Intento afegir: " + id + " " + i + " " + aux.ObteEd(i) + " a " + x + ", " + y);
                boolean b;
                if (b = Legal(aux.ObteEd(i), x, y, aux)) {

                    if (x == (aux.ConsultarX()) - 1) {
                        Back2(id + 1, 0, y + 1, aux);
                    } else {
                        Back2(id + 1, x + 1, y, aux);
                    }

                }
                System.out.println(" --> " + b);
                System.out.println();

            }
            if (!trobat) {
                aux.BorraIlla(x, y);
            }

        } else {
            trobat = true;

        }
    }*/
    /**
     * Elimina totes les restriccions amb aquest id de tots els barris
     * @param id Id de la restriccio a eliminar
     */
    void NetejarRestriccions(int id) {
        cjtBarris.NetejarRestricions(id);
    }
    /**
     * Elimina tots els edificis amb aquest nom dels barris
     * @param nom Nom del edifici a eliminar
     */
    void NetejarEdificis(String nom){
        cjtBarris.NetejarEdificis(nom);
    }
}
