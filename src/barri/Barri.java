package barri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projecte.CjtRestriccions;
import projecte.Espai;
import projecte.Restriccio;
import rest.TipusRest;

public class Barri implements Serializable {

	private String nom;
	private int x, y, poblacio, pressupost, cost_m, classe, aparcament;
	
	private Espai espai;
	private ArrayList<Restriccio> lRestriccions;
	private CjtEdificis lEdificis;
	
	Barri(String n, int po, int pr, int c, int cl, int a, int xx, int yy) {
		modificarNom(n);
		modificarPoblacio(po);
		modificarPressupost(pr);
		modificarCost_m(c);
		modificarClasse(cl);
		modificarAparcament(a);
		x = xx;
		y = yy;
		
		espai = new Espai(x, y);
		lRestriccions = new ArrayList<Restriccio>();
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

	public int consultarClasse() {
		return classe;
	}

	public void modificarClasse(int classe) {
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
	
	
	
	void back(int n, int x, int y) {		
		
		for (int i = n; i < lEdificis.tamany(); i++) {
			espai.InsertarElement(lEdificis.obtenirEdifici(i), id, x, y);
			
			if (legal()) {
				if (x == this.x) {
					x = -1;
					y++;
				}
				
				back(n+1, x+1, y);
			}
			
			
			
		}
		
		
	}
	
	boolean legal() {
		boolean comp = true;
		for (int i = 0; i < lRestriccions.size(); i++) {
			TipusRest tr = lRestriccions.get(i).tipus();
			if (tr == TipusRest.DISTCODI || tr == TipusRest.DISTTIPUS || tr == TipusRest.INFUENCIA) {
				comp = (comp && lRestriccions.get(i).CompleixRes());
			}
		}
	}
	
	
	
	
	
	

}

