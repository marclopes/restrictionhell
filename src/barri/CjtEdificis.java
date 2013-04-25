package barri;
import java.util.*;

/**
 *
 * @author Edu
 */

public class CjtEdificis{

	private List<Edifici> conEd;
	
	public CjtEdificis(){	
		
	}
	
	//MILLORA: AFEGIR EN ORDRE  DE NOM
	public void AfegirEdifici(Edifici e){
		this.conEd.add(e);
	}
	
	public void EliminarEdifici(Edifici e){
		this.conEd.remove(e);
	}
        
        public void EliminarEdifici(String nom){
		for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) this.conEd.remove(e);
		}
	}
	
	//MILLORA: CERCA DICOTOMICA (DEPEN D'AFEGIR EN ORDRE)
	public Edifici ObtenirEdifici(String nom){
		for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return e;
		}
                return null;
	}
        
        public boolean ExisteixEdifici(String nom){
                for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return true;
		}
                return false;
        }
	
	public Edifici obtenirEdifici(int pos) {
		return conEd.get(pos);
	}
	
	
	public int tamany() {
		return conEd.size();
	}

}