package barri;

import java.util.*;

public class TipusEdifici{
		
		private List<String> tipus;
		
		TipusEdifici(){}
		
		public void AfegirTipus(String t){
			this.tipus.add(t);
		}
		
		public void EliminarTipus(String t){
			for(String tip: tipus){
				if(t == tip) this.tipus.remove(tip);
			}
		}
		
		public boolean Existeix(String t){
			for(String tip: tipus){
				if(t == tip) return true;
			}
			return false;
		}
}