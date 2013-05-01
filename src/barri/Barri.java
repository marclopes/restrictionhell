package barri;

/**
 *
 * @author Marc Lopez
 */

import java.io.Serializable;
import java.util.ArrayList;

import barri.Edifici.Classes;

public class Barri implements Serializable {

	private String nom;
	private int x, y, poblacio, pressupost, cost_m, aparcament;
        private Classes classe;
	
	private Espai espai;
	private ArrayList<RestriccioBarris> lRestriccions;
	private CjtEdificis lEdificis;
	
        /**
         * Crea una instancia de la classe Barri
         * @param n Nom del Barri
         * @param po Població del barri
         * @param pr 
         * @param c
         * @param mitja
         * @param a
         * @param xx
         * @param yy 
         */
	public Barri(String n, Classes mitja, int xx, int yy) {
		this.nom = n;
		this.poblacio = 0;
		this.pressupost = 0;
		this.cost_m = 0;
		this.classe = mitja;
		this.aparcament = 0;
		x = xx;
		y = yy;
		espai = new Espai(x, y);
		lRestriccions = new ArrayList<RestriccioBarris>();
		lEdificis = new CjtEdificis();
		
		
		
		
	}
	
	public void CarregaEdifici(Edifici e) {
		lEdificis.AfegirEdifici(e);
	}
	
	public void BorraEdifici(Edifici e) {
		lEdificis.EliminarEdifici(e);
	}
        public void BorraEdifici(String e) {
		lEdificis.EliminarEdifici(e);
	}
	
	public void CarregaLlista(ArrayList<Edifici> l) {
		for(Edifici e: l) {
			CarregaEdifici(e);
		}
	}
	
	public void AfegirAlBarri(Edifici e, int id ,int a,int b) {
		espai.InsertarElement(new Illa(e), id, a, b);
	}
	    
	public void AfegeixRestriccio(RestriccioBarris r){
	    if (r instanceof REspai) ((REspai)r).assignaEspai(espai);
	    if (r instanceof RCjtEd) ((RCjtEd)r).assignaCe(lEdificis);
	    
	    lRestriccions.add(r);
	}
        public void EliminarRestriccio(int id) {
	    for(int i=0;i<lRestriccions.size();++i) {
		if(lRestriccions.get(i).ObtenirId()==id) {
		    lRestriccions.remove(i);
		    break;
		}
	    }
        
        }
	public boolean ComprovarRestriccions() {
		return true;
		
	}
	
	// Consultores i modificadores
	
	public String ConsultarNom() {
		return nom;
	}

	public void ModificarNom(String nom) {
		this.nom = nom;
	}

	public int ConstultarPressupost() {
		return pressupost;
	}

	public void ModificarPressupost(int pressupost) {
		this.pressupost = pressupost;
	}

	public int ConsultarPoblacio() {
		return poblacio;
	}

	public void ModificarPoblacio(int poblacio) {
		this.poblacio = poblacio;
	}

	public Classes ConsultarClasse() {
		return classe;
	}

	public void ModificarClasse(Classes classe) {
		this.classe = classe;
	}

	public int ConsultarCost_m() {
		return cost_m;
	}

	public void ModificarCost_m(int cost_m) {
		this.cost_m = cost_m;
	}

	public int ConsultarAparcament() {
		return aparcament;
	}

	public void ModificarAparcament(int aparcament) {
		this.aparcament = aparcament;
	}

	public int ConsultarX() {
		return x;
	}

	public void ModificarX(int x) {
		this.x = x;
                espai = new Espai(x,this.y);
	}
 
	public int ConsultarY() {
		return y;
	}

	public void ModificarY(int y) {
		this.y = y;
                espai = new Espai(this.x,y);
	}
	
	public Edifici ConsultarEdifici(int x, int y) {
		if (espai.ExisteixElementxy(x, y) == false) return null;
		return (((Illa)(espai.ConsultarElementxy(x, y))).ConsultaEdifici());
	}
	
	
	public void BorraIlla(int x, int y) {
		espai.InsertarElement(null, x + y*this.x, x, y);
		espai.EliminarElementxy(x, y);
	}
	

	
	public int TamRest() {
		return lRestriccions.size();
	}
	
	public RestriccioBarris ObteRest(int i) {
		return lRestriccions.get(i);
	}
	
	public int TamEd() {
		return lEdificis.Tamany();
	}
	
	public Edifici ObteEd(int i) {
		return lEdificis.ObtenirEdifici(i);
	}

}

