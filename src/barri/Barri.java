package barri;
import barri.Edifici.Classes;
import java.io.Serializable;
import java.util.List;

import projecte.CjtRestriccions;
import projecte.Restriccio;

public class Barri implements Serializable {

	private String nom;
	private int x, y, poblacio, pressupost, cost_m, aparcament;
        Classes classe;
	
	private Espai espai;
	private CjtRestriccions lRestriccions;
	private CjtEdificis lEdificis;
	
	public Barri(String n, int po, int pr, int c, Classes cl, int a, int xx, int yy) {
		this.nom = n;
		this.poblacio = po;
		this.pressupost = pr;
		this.cost_m = c;
		this.classe = cl;
		this.aparcament = a;
		x = xx;
		y = yy;
		
		espai = new Espai(x, y);
		lRestriccions = new CjtRestriccions();
		lEdificis = new CjtEdificis();
		
		
		
	}
	
	public void carregaEdifici(Edifici e) {
		lEdificis.AfegirEdifici(e);
	}
	
	public void borraEdifici(Edifici e) {
		lEdificis.EliminarEdifici(e);
	}
	
	public void carregaLlista(List<Edifici> l) {
		for(Edifici e: l) {
			carregaEdifici(e);
		}
	}
	
	public void afegirAlBarri(Edifici e, int id ,int a,int b) {
			espai.InsertarElement(new Illa(e), id, a, b);
	}
	
        public void AfegeixRestriccio(Restriccio r){
            lRestriccions.AfegirRes(r);
        }
        
	public boolean comprovarRestriccions() {
		return lRestriccions.ComprovarRes();
		
	}
	
	// Consultores i modificadores
	
	public String consultarNom() {
		return nom;
	}

	public void modificarNom(String nom) {
		this.nom = nom;
	}

	public int constultarPressupost() {
		return pressupost;
	}

	public void modificarPressupost(int pressupost) {
		this.pressupost = pressupost;
	}

	public int consultarPoblacio() {
		return poblacio;
	}

	public void modificarPoblacio(int poblacio) {
		this.poblacio = poblacio;
	}

	public Classes consultarClasse() {
		return classe;
	}

	public void modificarClasse(Classes classe) {
		this.classe = classe;
	}

	public int consultarCost_m() {
		return cost_m;
	}

	public void modificarCost_m(int cost_m) {
		this.cost_m = cost_m;
	}

	public int consultarAparcament() {
		return aparcament;
	}

	public void modificarAparcament(int aparcament) {
		this.aparcament = aparcament;
	}

	public int consultarX() {
		return x;
	}

	public void modificarX(int x) {
		this.x = x;
	}

	public int consultarY() {
		return y;
	}

	public void modificarY(int y) {
		this.y = y;
	}

}

