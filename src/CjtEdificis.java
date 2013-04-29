import java.util.ArrayList;

/**
 *
 * @author Edu
 */

public class CjtEdificis{

	private ArrayList<Edifici> conEd = new ArrayList<Edifici>();
	
	CjtEdificis(){	
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
        
        public int obtenirPosicio(String nom) {
                for(Edifici e: conEd){
			if(e.ConsultarNom().equals(nom)) return this.conEd.indexOf(e);
		}
                return -1;
	}
	
        public int obtenirPosicio(Edifici e) {
		return conEd.indexOf(e);
	}
        
	public Edifici obtenirEdifici(int pos) {
		return conEd.get(pos);
	}
	
	public int tamany() {
		return conEd.size();
	}
}