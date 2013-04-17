package barri;
import java.util.*;

import barri.Edifici.TipusEd;

public class Servei extends Edifici{

	private int cost;
	private int manteniment;
	private int areaInfluencia;
	
	Servei(){
	}
	
	public Servei(int cost, int manteniment, int area)throws Exception{
		super();
		super.tipusEd = TipusEd.SER;
		if(cost < 0) throw new Exception("Cost no pot ser negatiu.");
		if(manteniment < 0) throw new Exception("Manteniment no pot ser negatiu.");
		if(areaInfluencia < 0) throw new Exception("Area Influencia no pot ser negatiu.");
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
	
	public void ModificarCost(int cost)throws Exception{
		if(cost < 0) throw new Exception("Cost no pot ser negatiu.");
		this.cost = cost;
	}
	
	public void ModificarManteniment(int manteniment)throws Exception{
		if(manteniment < 0) throw new Exception("Manteniment no pot ser negatiu.");
		this.manteniment = manteniment;
	}
	
	public void ModificarAreaInfluencia(int area)throws Exception{
		if(area < 0) throw new Exception("Manteniment no pot ser negatiu.");
		this.manteniment = area;
	}
}