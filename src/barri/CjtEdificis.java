package barri;
import java.util.*;

/**
 *
 * @author Edu
 */

public class CjtEdificis{

	private ArrayList<Edifici> conEd;
	
	public CjtEdificis(){	
		conEd = new ArrayList<Edifici>();
	}
	
	//MILLORA: AFEGIR EN ORDRE  DE NOM
	public void AfegirEdifici(Edifici e){
		this.conEd.add(e);
	}
	
	public void EliminarEdifici(Edifici e){
		this.conEd.remove(e);
	}
	
	//MILLORA: CERCA DICOTOMICA (DEPEN D'AFEGIR EN ORDRE)
	public Edifici ObtenirEdifici(String nom)throws Exception{
		for(Edifici e: conEd){
			if(e.ConsultarNom() == nom) return e;
		}
		throw new Exception("Edifici no existeix.");
	}
	
	public Edifici obtenirEdifici(int pos) {
		return conEd.get(pos);
	}
	
	
	public int tamany() {
		return conEd.size();
	}
}