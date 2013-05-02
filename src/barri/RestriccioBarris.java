package barri;
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
        @Override
        public void InfoRes(){
            
        }


}
