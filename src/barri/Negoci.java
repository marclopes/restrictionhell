package barri;
import java.util.*;

import barri.Edifici.TipusEd;

public class Negoci extends Edifici{

	private int impost;
	private int aparcament;
	
	Negoci(){
	}
	
	public Negoci(int impost, int aparcament){
		super();
		super.tipusEd = TipusEd.NEG;
		this.impost = impost;
		this.aparcament = aparcament;
	}
	
	public int ConsultarImpost(){
		return this.impost;
	}
	
	public int ConsultarAparcament(){
		return this.aparcament;
	}
	
	public void ModificarImpost(int impost){
		this.impost = impost;
	}
	
	public void ModificarAparcament(int aparcament)throws Exception{
		this.aparcament = aparcament;
	}
}