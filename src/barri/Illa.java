package barri;
import java.util.*;

public class Illa{

	private Edifici edifici;
	
	public Illa(){
	}
	
	public Illa(Edifici e){
		this.edifici = e;
	}
	
	public void AssignaEdifici(Edifici e){
		this.edifici = e;
	}
	
	public void EliminaEdifici(){
		this.edifici = null;
	}
	
	public Edifici ConsultaEdifici(){
		return this.edifici;
	}

}