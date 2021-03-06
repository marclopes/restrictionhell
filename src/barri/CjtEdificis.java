package barri;
import barri.Edifici.TipusEd;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eduard Ricou
 */

public class CjtEdificis implements Serializable{

	private ArrayList<Edifici> conEd = new ArrayList<Edifici>();
	
        /**
         * Crea una instancia de conjunt d'edificis buida.
         */
	CjtEdificis(){	
            
	}
	
	/**
         * Afegeix un edifici al conjunt.
         * @param e és l'edifici que volem afegir.
         */
	public boolean AfegirEdifici(Edifici e){
		
            if(!this.ExisteixEdifici(e.ConsultarNom())){
                this.conEd.add(e);
                return true;
            }
            this.conEd.add(e);
            return false;
	}
	
        /**
         * Elimina un edifici del conjunt.
         * @param e és l'edifici que volem eliminar.
         */
        public void EliminarEdifici(Edifici e){
		this.conEd.remove(e);
	}
        
        /**
         * Elimina un edifici identificat per el seu nom del conjunt.
         * @param nom és el nom de l'edifici que volem eliminar.
         */
        public void EliminarEdifici(String nom){
		for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) {
                            this.conEd.remove(e); 
                            break;
                        }
		}
	}
        
        public void EliminarTotsEdificis(){
            conEd.clear();
        }
	
	/**
         * Consultora per obtenir un edifici identificat per nom del conjunt.
         * @param nom és el nom de l'edifici que volem obtenir.
         * @return L'edifici identificat per nom.
         */
	public Edifici ObtenirEdifici(String nom){
		for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return e;
		}
                return null;
	}
        
        /**
         * Comprova si existeix l'edifici identificat per nom al conjunt.
         * @param nom és el nom de l'edifici que volem comprovar.
         * @return cert si l'edifici identificat per nom és al conjunt.
         */
        public boolean ExisteixEdifici(String nom){
                for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return true;
		}
                return false;
        }
        
        /**
         * Consultora per saber la posició del edifici identificat per nom dins del conjunt.
         * @param nom és el nom de l'edifici que volem consultar-ne la posició.
         * @return la posició de l'edifici dins del conjunt.
         */
        public int ObtenirPosicio(String nom) {
                for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return this.conEd.indexOf(e);
		}
                return -1;
	}
	
        /**
         * Consultora per saber la posició del edifici dins del conjunt.
         * @param e és l'edifici que volem consultar-ne la posició.
         * @return la posició de l'edifici dins del conjunt.
         */
        public int ObtenirPosicio(Edifici e) {
		return conEd.indexOf(e);
	}
        
        /**
         * Consultora per obtenir un edifici a partir de la seva posició al conjunt.
         * @param pos és la posició al conjunt de l'edifici que volem obtenir.
         * @return l'edifici de la posició pos.
         */
	public Edifici ObtenirEdifici(int pos) {
		return conEd.get(pos);
	}
	
        /**
         * Consultora del tamany del conjunt.
         * @return el tamany del conjunt.
         */
	public int Tamany() {
		return conEd.size();
	}
        
        public ArrayList<Edifici> ObtenirEdificisTipus(String tipus) {
            ArrayList<Edifici> aux = new ArrayList<Edifici>();
            if (tipus.equals("Habitatge")) {
                Edifici.TipusEd t = Edifici.TipusEd.HAB;
                for (int i = 0 ; i<conEd.size();++i) {
                    if (conEd.get(i) instanceof Habitatge) {
                        aux.add(conEd.get(i));
                    }
                }
            }
            else if (tipus.equals("Negoci")) {
                TipusEd t = TipusEd.NEG;
                for (int i = 0 ; i<conEd.size();++i) {
                    if (conEd.get(i) instanceof Negoci) {
                        aux.add(conEd.get(i));
                    }
                }
            }
            else if (tipus.equals("Servei")) {
                Edifici.TipusEd t = Edifici.TipusEd.SER;
               for (int i = 0 ; i<conEd.size();++i) {
                    if (conEd.get(i) instanceof Servei) {
                        aux.add(conEd.get(i));
                    }
                }
            } else if(StringHabtoEnum(tipus)!=null) {
                TipusHab t = StringHabtoEnum(tipus);
                for (int i = 0 ; i<conEd.size();++i) {
                    if (((Habitatge)conEd.get(i)).consultarTipus()==t) {
                        aux.add(conEd.get(i));
                    }
                }
                
            } else if (StringNegtoEnum(tipus)!= null){
                TipusNegoci t = StringNegtoEnum(tipus);
                for (int i = 0 ; i<conEd.size();++i) {
                    if (((Negoci)conEd.get(i)).consultarTipus()==t) {
                        aux.add(conEd.get(i));
                    }
                }
            } else if (StringSertoEnum(tipus)!=null){
            TipusServei t = StringSertoEnum(tipus);
                for (int i = 0 ; i<conEd.size();++i) {
                    if (((Servei)conEd.get(i)).consultarTipus()==t) {
                        aux.add(conEd.get(i));
                    }
                }
            }
            return aux;
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