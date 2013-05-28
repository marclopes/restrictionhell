package barri;

import java.util.ArrayList;

public class Assignacions implements Cloneable{
		
	public Assignacio asAct = null;
	public ArrayList<Assignacio> va;
	public boolean val = true;
	public boolean colocat;

	public Assignacions() {
		
		va = new ArrayList<Assignacio>();
		//va = new ArrayList<Assignacio>();
		colocat = false;
		
	}
	
	public Object clone() {
		Assignacions au = new Assignacions();
		if (asAct != null) au.asAct = (Assignacio) asAct.clone();
		else au.asAct = null;
		
		au.va = new ArrayList<Assignacio> ();
		for (int i = 0; i < va.size(); i++) {
			au.va.add((Assignacio) va.get(i).clone());
			
		}
		
		au.val = val;
		
		au.colocat = colocat;
		
		return au;
	}
	
	public String toString() {
		if (!va.isEmpty())
			return va.get(0).e.ConsultarNom();
		else return null;
	}
	
	

}


