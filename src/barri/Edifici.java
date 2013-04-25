package barri;
import java.util.*;

import projecte.Objecte;

/**
 *
 * @author Edu
 */

public class Edifici extends Objecte {
	
	public enum TipusEd {
		HAB,
		SER,
		NEG
	};

	//private String nom;
	//private int codi;
	private int h;
	private int capacitat;
	private List<String> clases;
	
	protected String tipus;
	protected TipusEd tipusEd;
	
	static private int cont = 0; //per assignar codis molt a saco de aleatoris
	
	/* CREADORES */
	
	Edifici(){
		super(1, 1);
	}
	

	public Edifici(String nom, int codi, int h, int capacitat, List<String> c, String t){
		super(1, 1);
		super.nom = nom;
		super.id = codi;		//Realment és necessari el codi? 
		this.h = h;
		this.capacitat = capacitat;
		this.clases = c;
		tipus = t;
		
	}
	
	public Edifici copia (Edifici e) {
		int c = cont++;
		return new Edifici(e.ConsultarNom(), c, e.ConsultarH(), e.ConsultarCapacitat(), e.ConsultarClases(), e.consultarTipus());
	}
	
	
	/* CONSULTORES */
	
	public String ConsultarNom(){
		return this.nom;
	}
	
	public int ConsultarCodi(){
		return super.id;
	}
	
	public int ConsultarH(){
		return this.h;
	}
	
	public int ConsultarCapacitat(){
		return this.capacitat;
	}
	
	public List ConsultarClases(){
		return this.clases;
	}
	
	public boolean EtsClase(String c){
		for(String clase: clases){
			if(c == clase) return true;
		}
		return false;
	}
	
	
	public String consultarTipus() {
		return tipus;
	}
	
	public TipusEd consultarSubclasse() {
		return this.tipusEd;
	}
	
	
	
	/* MODIFICADORES */
	
	public void ModificarH(int h){
		this.h = h;
	}
	
	
	
	public void ModificarCapacitat(int capacitat){
		this.capacitat = capacitat;
	}
	
	public void modificarTipus(String t) {
		tipus = t;
	}
	
}