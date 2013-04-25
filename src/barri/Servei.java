package barri;
import java.util.*;

import barri.Edifici.TipusEd;

public class Servei extends Edifici{

	private int cost;
	private int manteniment;
	private int areaInfluencia;
	
	Servei(){
	}
	
	public Servei(String nom, int codi, int h, int capacitat, List<String> c, String t, int cost, int manteniment, int area){
		super(nom, codi, h, capacitat, c, t);
		super.tipusEd = TipusEd.SER;
		this.cost = cost;
		this.manteniment = manteniment;
		this.areaInfluencia = area;
	}
	
	public int ConsultarCost(){
		return this.cost;
	}
	
	public int ConsultarManteniment(){
		return this.manteniment;
	}

	public int ConsultarAreaInfluencia(){
		return this.areaInfluencia;
	}
	
	public void ModificarCost(int cost){
		this.cost = cost;
	}
	
	public void ModificarManteniment(int manteniment){
		this.manteniment = manteniment;
	}
	
	public void ModificarAreaInfluencia(int area){
		this.manteniment = area;
	}
}