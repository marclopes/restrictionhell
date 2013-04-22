import java.util.*;

public class CjtBarris {
    private ArrayList<Barri> cjtBarris;
    
    cjtBarris(){
      cjtBarris = new ArrayList<Barri>;
    }
    
    public void AfegirBarri(Barri barri) {
      cjtBarris.add(barri);
    }
    public void EliminarBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	    if (cjtBarris.get(i).consultarNom()==nom) {
		cjtBarris.remove(i);
		break;
	    }
      }
    }
    
    public Boolean ExisteixBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).consultarNom()==nom) return true;
      }
      return false;
    }
    
    public Barri GetBarri(String nom){
      for (int i=0;i<cjtBarris.size();++i) {
	  if (cjtBarris.get(i).consultarNom()==nom) return cjtBarris.get(i);
      }
    }

}