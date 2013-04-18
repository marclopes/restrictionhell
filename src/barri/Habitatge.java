package barri;
import java.util.*;

public class Habitatge extends Edifici{

	private int impost;
	private int aparcament;
	
	public enum TipusHab {
		PIS, APARELLADES, UNIFAMILIAR, MANSIO, BARRACA
	};
	
	
	
	Habitatge(){
		
	}
	
	public Habitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, List<String> c)throws Exception{
		super(nom, codi, h, capacitat, c);
		super.tipusEd = TipusEd.HAB;
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
