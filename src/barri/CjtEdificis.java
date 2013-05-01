package barri;
import java.util.ArrayList;

/**
 *
 * @author Eduard Ricou
 */

public class CjtEdificis{

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
}