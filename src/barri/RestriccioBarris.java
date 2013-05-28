package barri;

import java.util.ArrayList;

public abstract class RestriccioBarris extends Restriccio {
	public class Pos {
		public int x, y;
		
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pos () {
			
		}
	}	
	
	public class PosArea {
		public int x, y, area;
		
		public PosArea (int x, int y, int area) {
			this.x = x;
			this.y = y;
			this.area = area;
		}
		public PosArea () {
			
		}
	}
	
	
	TipusRest tr;
	
	public RestriccioBarris(int ID) {
		super(ID);
		
	}
	
	public TipusRest obteTipus() {
		return tr;
	}
	
    
    public void InfoRes(){
        
    }
    
    public abstract String Info();
    
    public abstract boolean prop(ArrayList<Assignacions> va, Assignacio a);

	public abstract boolean afecta(Assignacio a);
    	


}
