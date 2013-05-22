package barri;
import java.util.ArrayList;

/**
 *
 * @author Albert Navarro
 */

public class CjtBarris {
    private ArrayList<Barri> cjtBarris;
    
         /**
         * Crea una instancia de conjunt de barris buida.
         */
    public CjtBarris(){
      cjtBarris = new ArrayList<Barri>();
    }
    
    	/**
         * Afegeix un barri al conjunt.
         * @param barri és el barri que volem afegir.
         */
    public void AfegirBarri(Barri barri) {
      cjtBarris.add(barri);
    }
    
         /**
         * Elimina un barri del conjunt.
         * @param nom és el nom del barri que volem eliminar.
         */
    public void EliminarBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	    if (cjtBarris.get(i).ConsultarNom().equals(nom)) {
		cjtBarris.remove(i);
		break;
	    }
      }
    }
    
         /**
         * Comprova si existeix el barri identificat per nom al conjunt.
         * @param nom és el nom del barri que volem comprovar.
         * @return cert si el barri identificat per nom és al conjunt.
         */
    public boolean ExisteixBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).ConsultarNom().equals(nom)) return true;
      }
      return false;
    }
    
         /**
         * Consultora per obtenir un barri a partir del seu nom.
         * @param nom es el nom al conjunt de barris que volem obtenir.
         * @return el barri del nom @param nom.
         */
    public Barri ObtenirBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).ConsultarNom().equals(nom)) return cjtBarris.get(i);
      }
      return null;
    }
    
         /**
         * Esborra una restricció apartir de la seva id al conjunt.
         * @param id es la identificació de la restriccio que volem esborrar.
         */
    public void NetejarRestricions(int id){
        for (Barri b : cjtBarris) {
            b.EliminarRestriccio(id);
        }
    }
    
         /**
         * Esborra un edifici apartir del seu nom al conjunt.
         * @param e és el nom del edifici que volem esborrar.
         */
    public void NetejarEdificis(String e){
        for (Barri b : cjtBarris) {
            b.BorraEdifici(e,-1);
        }
    }
    

}