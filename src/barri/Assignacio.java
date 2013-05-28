package barri;



public class Assignacio implements Cloneable {
	public int x, y;
	public Edifici e;
	public boolean val = true;
	
	
	public Assignacio(int x, int y, Edifici e) {
		this.x = x;
		this.y = y;
		this.e = e;
	}
	
	public String toString() {
		return (e.ConsultarNom() + " de " + x + "," + y);
	}
	
	public Object clone() {
		Assignacio as =  new Assignacio(x, y, e);
		as.val = val;
		return as;
	}
}
