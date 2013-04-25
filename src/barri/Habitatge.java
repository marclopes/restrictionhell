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
	
	public Habitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, List<String> c, String t){
		super(nom, codi, h, capacitat, c, t);
		super.tipusEd = TipusEd.HAB;
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
	
	public void ModificarAparcament(int aparcament){
		this.aparcament = aparcament;
	}
}
