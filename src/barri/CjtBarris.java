package barri;
import java.util.ArrayList;


public class CjtBarris {
    private ArrayList<Barri> cjtBarris;
    
    public CjtBarris(){
      cjtBarris = new ArrayList<Barri>();
    }
    
    public void AfegirBarri(Barri barri) {
      cjtBarris.add(barri);
    }
    public void EliminarBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	    if (cjtBarris.get(i).consultarNom().equals(nom)) {
		cjtBarris.remove(i);
		break;
	    }
      }
    }
    
    public boolean ExisteixBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).consultarNom().equals(nom)) return true;
      }
      return false;
    }
    
    public Barri GetBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).consultarNom().equals(nom)) return cjtBarris.get(i);
      }
      return null;
    }

}