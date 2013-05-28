/**

Nomes un barri, retorn barri actual

**/
package barri;

import java.util.ArrayList;
import java.util.Stack;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class CtrBarriDom {

    private static CtrBarriDom ctrBarri = null;
    private CjtBarris cjtBarris;
    public static Barri barri; 
    private boolean trobat = false;
    
    ArrayList<Integer> estat[][];
    
    //ArrayList<Assignacions> va;
    ArrayList<Assignacio> sol_def;
    
//    private Stack<ArrayList<Assignacions>> va_antic = new Stack<ArrayList<Assignacions>>();
//    private Stack<ArrayList<Assignacio>> sol_antic = new Stack<ArrayList<Assignacio>>();
    

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
        barri = new Barri(n, cl, xx, yy);
    }
    
    public void CreaBarri(Barri b) {
        barri = b;
    }
    /**
     * Elimina un barri amb nom n
     *
     * @param n Nom del barri a eliminar
     */
    public void EliminarBarri() {
        barri = null;
    }

    /**
     * Retorna una instancia del barri
     *
     * @param n Nom del barri
     * @return Barri, instancia del barri amb nom n
     */
    public Barri ObtenirBarri() {
        return barri;
    }

    /**
     * Afegeix la restriccio r al barri amb nom nomBarri
     *
     * @param nomBarri Nom del barri al que se li afegeix la restriccio
     * @param r Restriccio a afegir al barri
     */
    public int AfegeixRestriccions(RestriccioBarris r) {
        if (barri == null) {
            return -1;
        }
        return barri.AfegeixRestriccio(r);
    }

    /**
     * Afegeix edifici e al barri amb nomBarri
     *
     * @param e Edifici a afegir al barri
     * @param nomBarri Nom del barri al que se li afegeix l'edifici
     */
    public int AfegirEdifici(Edifici e) {
        if (barri != null) {

            if (barri.ExisteixEdifici(e.ConsultarNom())) {
                return -1;
            }
            return barri.CarregaEdifici(e);

        }
        return -1;
    }

    public void AfegirEdificis(ArrayList<Edifici> e) {
        if (barri != null) {
            barri.CarregaEdificis(e);

        }
    }
    /**
     * Genera una possible distribucio dels edificis del barri amb les
     * restriccions donades
     *
     * @param n Nom del barri a generar
     */

    /**
     * Elimina l'edicifi amb nomEdifici del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici que es vol eliminar
     */
    public int TreureEdifici(String nomEdifici) {
        if (barri == null) {
            return -1;
        }
        return barri.BorraEdifici(nomEdifici);
    }

    /**
     * Elimina la restriccio amb idRest del barri amb nomBarri
     *
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRest Identificador de la restriccio que es vol eliminar
     */
    public int TreureRestriccio(int idRest) {
        if (barri == null) {
            return -1;
        }
        return barri.EliminarRestriccio(idRest);
    }

    /**
     * Modifica el atribut atribut del barri nomBarri amb el valor valor
     *
     * @param nomBarri Nom del barri que es modifica
     * @param atribut Nom del atribut a modificar
     * @param valor valor que se li dona al atribut modificat
     */
    public int ModificarBarri(String atribut, String valor) {
        if (barri == null) {
            return -1;
        }
        if (atribut.equals("Nom")) {
            barri.ModificarNom(valor);

            return 0;
            //  } else if (atribut.equals("Pressupost")) {
            //    aux.ModificarPressupost(Integer.parseInt(valor));
            // } else if (atribut.equals("Poblacio")) {
            //    aux.ModificarPoblacio(Integer.parseInt(valor));
        } else if (atribut.equals("Classe")) {
            barri.ModificarClasse(StringToClase(valor));
            return 0;
            //} else if (atribut.equals("Aparcament")) {
            //    aux.ModificarAparcament(Integer.parseInt(valor));
        } else if (atribut.equals("MidaX")) {
            barri.ModificarX(Integer.parseInt(valor));
            return 0;
        } else if (atribut.equals("MidaY")) {
            barri.ModificarY(Integer.parseInt(valor));
            return 0;

        }
        return -1;
    }

    
    /**
     * Converteix una Classe social en format String a enum
     * @param c La classe social en String
     * @return la Classe social en format enum
     */
    private Classes StringToClase(String c) {
        if (c.equals("Alta")) {
            return Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Classes.Mitja;
        } else {
            return Classes.Baixa;
        }
    }
  
    
    public void fc(int na, ArrayList<Assignacions> va, ArrayList<Assignacio> sol) {
    	
    	
    	System.out.println("__________________________________________");
    	System.out.println("FC: n_sol = " + sol.size() + "  i va.pos = " + na);
    	
    	if (na < va.size()) {
    		// pillem var
    		//for (int i = 0; i < va.size(); i++) {
    			Assignacions aux = va.get(na);
    			
				if (true /** no colocat**/) {
					
//					for (int j = 0; j < aux.va.size(); j++) {
//						System.out.println(aux.va.get(j) + " ... " + j + " de " + aux.va.size());
//					}
					
					
//					va_antic.push((ArrayList<Assignacions>) va.clone());
//					sol_antic.push((ArrayList<Assignacio>) sol.clone());
					
					
					//ArrayList<Assignacio> sol_antic = copias(sol);
					
//					ArrayList<Assignacions> va_antic = (ArrayList<Assignacions>) va.clone();
//					ArrayList<Assignacio> sol_antic = (ArrayList<Assignacio>) sol.clone();
					
//					ArrayList<Assignacions> va_antic = va;
//					ArrayList<Assignacio> sol_antic = sol;
					
//					// i intentem ficarli un val
					for (int j = 0; j < aux.va.size(); j++) {
						ArrayList<Assignacions> va_antic = copiav(va);
						Assignacio a = aux.va.get(j);
						if (a.val) {
							System.out.println("Var num: " + sol.size() + " valor " + j + " de " + aux.va.size() + " pro " + va_antic.get(0).va.size() + ": " + aux.va.get(j).e.ConsultarNom() + " " + aux.va.get(j).x + "," + aux.va.get(j).y);
							
							va.get(na).asAct = new Assignacio(a.x, a.y, a.e);
							
							sol.add(a);
							
	//						for (int k = 0; k < va_antic.get(0).va.size(); k++) {
	//							System.out.println(va_antic.get(0).va.get(k) + " ... " + k + " de " + va_antic.get(0).va.size());
	//						}
							
							
//							System.out.println(" - asAct es: " + aux.asAct);
							System.out.println(" - asAct es: " + va.get(na).asAct);
	//						for (int k = 0; k < va_antic.get(0).va.size(); k++) {
	//							System.out.println(va_antic.get(0).va.get(k) + " ... " + k + " de " + va_antic.get(0).va.size());
	//						}
							System.out.print("va.get(" + na + ").val era = " + va.get(na).val);
							va.get(na).val = false;
							System.out.println(" i ara  = " + va.get(na).val);
							//System.exit(0);
							borra(va, a.x, a.y);
	//						System.out.println("INFO ABANS:");
	//						int size = 0;
	//						for (int i = 0; i < va.size(); i++) {
	//							size += va.get(i).va.size();
	//							Assignacions as = va.get(i);
	////							System.out.println(as.va.get(0).e.ConsultarNom());
	//							for (int k = 0; k < as.va.size(); k++) {
	//								if (!as.va.isEmpty()) {
	//									System.out.println(as.va.get(k).e.ConsultarNom());
	//									break;
	//								}
	//							}
	//						}
	//						
//							System.out.println(" - asAct es: " + va.get(na).asAct);
//							for (int z = 0; z < va.size(); z++) {
//				       			Assignacions auxi = va.get(z);
//				       			System.out.println("Var " + z + " ja ta: " + auxi.asAct);
//				       		}
							boolean boo = propaga(va, va.get(na).asAct);
							
	//						System.out.println(size);
	//						System.out.println("DESPRES: ");
	//						size = 0;
	//						for (int i = 0; i < va.size(); i++) {
	//							size += va.get(i).va.size();
	//							Assignacions as = va.get(i);
	////							System.out.println(as.va.get(0).e.ConsultarNom());
	//							for (int k = 0; k < as.va.size(); k++) {
	//								if (!as.va.isEmpty()) {
	//									System.out.println(as.va.get(k).e.ConsultarNom());
	//									break;
	//								} else System.out.println("em");
	//							}
	//						}
	//						System.out.println(size);
							
							
							
							System.out.println("boo = " + boo);
							if (boo) {
								System.out.println("Sizeee-eh: " + va.size() + " buidilluuu-uh: " + dominiBuit(na+1, va));
								if (dominiBuit(na+1, va) == -1) {
									System.out.println(" * ELECCIO: " + a);
									int m, n;
									fc(na+1, va, sol);
									
									if (va.isEmpty() || va.size() == 0 || trobat) {
										System.out.println(sol.size() + " vs " + va.size());
										//trobat = true;
										return;
										
									} else {
										System.out.println("PUTAAAA");
										// seguent valor, RESTABLIC ESTAT I SOL!!
//										sol = sol_antic;
										sol.remove(sol.size()-1);
										va = va_antic;
										
	//									va = va_antic.pop();
	//									sol = sol_antic.pop();
									}
									
									
								} else {
	
									System.out.println(" - Domini buit: " + dominiBuit(na+1, va) + " --> " + va.get(dominiBuit(na+1, va)).toString() );
									// seguent valor
//									sol = sol_antic;
									sol.remove(sol.size()-1);
									va = va_antic;
	//								va = va_antic.pop();
	//								sol = sol_antic.pop();
								}
								
								
							} else if (!trobat){
								System.out.println(" ! Error al propagar! --- > va: " + va.get(0) + " antic: " + va_antic.get(0));
								System.out.println(" ! Error al propagar! --- > va: " + va.get(0).va.size() + " antic: " + va_antic.get(0).va.size());
//								sol = (ArrayList<Assignacio>) sol_antic.clone();
								sol.remove(sol.size()-1);
								va = (ArrayList<Assignacions>) va_antic.clone();
	//							va = va_antic.pop();
	//							sol = sol_antic.pop();
								System.out.println(" ! Error al propagar! --- > va: " + va.size() + " antic: " + va_antic.size());
								System.out.println(" ! Error al propagar! --- > va: " + va.get(0).va.size() + " antic: " + va_antic.get(0).va.size());
								
							}
						}
					}
				}
				
				
			} else {
				System.out.println("Finutiiiiii");
				trobat = true;
				sol_def = (ArrayList<Assignacio>) sol.clone();
			}
    		
    		return;
    		
    	}

    
    private boolean propaga(ArrayList<Assignacions> va, Assignacio a) {
    	for (int i = 0; i < barri.TamRest(); i++) {
           if (barri.ObteRest(i).afecta(a)) {
        	   System.out.println(" - Rest " + barri.ObteRest(i).ObtenirId() + " afecta a " + a.e.ConsultarNom());
        	   
        	   boolean boo = barri.ObteRest(i).prop(va, a);
        	   if (!boo) return false;
           }
			
		}
    	return true;
    }

    
    private int dominiBuit(int na, ArrayList<Assignacions> va) {
    	for (int i = na; i < va.size(); i++) {
    		boolean mal = true;
			for (int j = 0; j < va.get(i).va.size() && mal; j++) {
				if (va.get(i).va.get(j).val == true) mal = false;
			}
			if (mal) return i;
		}
    	
    	return -1;

    }
    
    public void iniciVA() {
    	for (int i = 0; i < barri.ConsultarX(); i++) {
			for (int j = 0; j < barri.ConsultarY(); j++) {
				for (int ne = 0; ne < barri.TamEd(); ne++) {
					
				}
			}
		}
    }
    
    private void borra(ArrayList<Assignacions> va, int x, int y) {
    	System.out.println(" - Borrat el " + x +"," +y);
    	for (int i = 0; i < va.size(); i++) {
    		Assignacions aux = va.get(i);
    		
    		if (aux.val) {				
				for (int j = 0; j < aux.va.size(); j++) {
					
					if (aux.va.get(j).x == x && aux.va.get(j).y == y) aux.va.get(j).val = false;
				}
    		}
    	}

    } 


    /**
     * Elimina la restriccio identificada amb id.
     *
     * @param id Id de la restriccio a eliminar
     */
    void NetejarRestriccions(int id) {
        barri.NetejarRestricions(id);
    }

    /**
     * Elimina tots els edificis amb aquest nom dels barris
     *
     * @param nom Nom del edifici a eliminar
     */
    void NetejarEdificis(String nom) {
        barri.NetejarEdificis(nom);
    }
    
    
    public ArrayList<Assignacio> ObteSol() {
    	return sol_def;
    }
    
    private  ArrayList<Assignacions> copiav(ArrayList<Assignacions> src) {
    	ArrayList<Assignacions> au = new ArrayList<Assignacions> ();
		for (int i = 0; i < src.size(); i++) {
			au.add((Assignacions) src.get(i).clone());
			
		}
		return au;
    }
    
    private  ArrayList<Assignacio> copias(ArrayList<Assignacio> src) {
    	ArrayList<Assignacio> au = new ArrayList<Assignacio> ();
		for (int i = 0; i < src.size(); i++) {
			au.add((Assignacio) src.get(i).clone());
			
		}
		return au;
    }
}

