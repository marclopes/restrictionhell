package barri;
import java.util.*;

import barri.Edifici.TipusEd;

public class Negoci extends Edifici{

	private int impost;
	private int aparcament;
	
	Negoci(){
	}
	
	public Negoci(int impost, int aparcament)throws Exception{
		super();
		super.tipusEd = TipusEd.NEG;
		if(impost < 0) throw new Exception("Impost no pot ser negatiu.");
		if(aparcament < 0) throw new Exception("Aparcament no pot ser negatiu.");
		this.impost = impost;
		this.aparcament = aparcament;
	}
	
	public int ConsultarImpost(){
		return this.impost;
	}
	
	public int ConsultarAparcament(){
		return this.aparcament;
	}
	
	public void ModificarImpost(int impost)throws Exception{
		if(impost < 0) throw new Exception("Impost no pot ser negatiu.");
		this.impost = impost;
	}
	
	public void ModificarAparcament(int aparcament)throws Exception{
		if(aparcament < 0) throw new Exception("Aparcament no pot ser negatiu.");
		this.aparcament = aparcament;
	}
}