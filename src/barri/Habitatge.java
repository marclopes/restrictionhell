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
	
	public Habitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, List<String> c){
		super(nom, codi, h, capacitat, c);
		super.tipusEd = TipusEd.HAB;
		if(impost < 0) 
		if(aparcament < 0) 
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
