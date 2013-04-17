package barri;
import java.util.*;

public class Illa{

	private Edifici edifici;
	
	Illa(){
	}
	
	public Illa(Edifici e){
		this.edifici = e;
	}
	
	public void AssignaEdifici(Edifici e){
		this.edifici = e;
	}
	
	public void EliminaEdifici(Edifici e){
		this.edifici = null;
	}
	
	public Edifici ConsultaEdifici(){
		return this.edifici;
	}

}