package rest;
import projecte.Espai;
import projecte.Restriccio;


public abstract class RDistancia extends Restriccio {
	
	private Espai e;
	
	public RDistancia(int ID, int d, boolean m) {
		super(ID);
		dist = d;
		max = m;
		
		
	}
	int dist;
	boolean max;
		

}
