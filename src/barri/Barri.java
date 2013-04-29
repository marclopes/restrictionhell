package barri;


import java.io.Serializable;
import java.util.ArrayList;

import barri.Edifici.Classes;;

public class Barri implements Serializable {

	private String nom;
	private int x, y, poblacio, pressupost, cost_m, aparcament;
    private Classes classe;
	
	private Espai espai;
	private ArrayList<RestriccioBarris> lRestriccions;
	private CjtEdificis lEdificis;
	
	
	public Barri(String n, int po, int pr, int c, Classes mitja, int a, int xx, int yy) {
		this.nom = n;
		this.poblacio = po;
		this.pressupost = pr;
		this.cost_m = c;
		this.classe = mitja;
		this.aparcament = a;
		x = xx;
		y = yy;
		espai = new Espai(x, y);
		lRestriccions = new ArrayList<RestriccioBarris>();
		lEdificis = new CjtEdificis();
		
		
		
	}
	
	public void carregaEdifici(Edifici e) {
		lEdificis.AfegirEdifici(e);
	}
	
	public void borraEdifici(Edifici e) {
		lEdificis.EliminarEdifici(e);
	}
	
	public void carregaLlista(ArrayList<Edifici> l) {
		for(Edifici e: l) {
			carregaEdifici(e);
		}
	}
	
	public void afegirAlBarri(Edifici e, int id ,int a,int b) {
		espai.InsertarElement(new Illa(e), id, a, b);
	}
	    
	public void AfegeixRestriccio(RestriccioBarris r){
	    if (r instanceof REspai) ((REspai)r).assignaEspai(espai);
	    else if (r instanceof RCjtEd) ((RCjtEd)r).assignaCe(lEdificis);
	    
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
	public boolean comprovarRestriccions() {
		return true;
		
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

	/*public void modificarX(int x) {
		this.x = x;
	}*/
 
	public int consultarY() {
		return y;
	}

	/*public void modificarY(int y) {
		this.y = y;
	}*/
	public void ModificarXY(int x,int y) {
	    this.x=x;
	    this.y=y;
	    espai = new Espai(x,y);
	}
	public Edifici consultarEdifici(int x, int y) {
		if (espai.ExisteixElementxy(x, y) == false) return null;
		return (((Illa)(espai.ConsultarElementxy(x, y))).ConsultaEdifici());
	}
	
	
	
	void preparaBack() {
		
	}
	
	
	
	
	void back(int id, int x, int y) {	
		if (id < (this.x * this.y)) {
			System.out.println("BAAAACK "+ id  + " "+ x + ", " + y);
			
			for (int i = 0; i < lEdificis.tamany(); i++) {
				//espai.InsertarElement(lEdificis.obtenirEdifici(i), id, x, y);
				lEdificis.obtenirEdifici(i).ModificarId(id);
				this.afegirAlBarri(lEdificis.obtenirEdifici(i), id, x, y);
			
				System.out.println("afegir: " + lEdificis.obtenirEdifici(i).nom + " a " + x + ", " + y);
			
				//if (x == 14 && y == 14) continue;
				if (legal(lEdificis.obtenirEdifici(i))) {
					
					
					if (x == (this.x)-1) back(id+1, 0, y+1);
					else back(id+1, x+1, y);
				}
			
			
			
			}
		}
		
	}
	
	boolean legal(Edifici ed) {
		boolean comp = true;
		for (int i = 0; i < lRestriccions.size(); i++) {
			TipusRest tr = lRestriccions.get(i).obteTipus();
			if (tr == TipusRest.DISTCODI || tr == TipusRest.DISTTIPUS || tr == TipusRest.INFUENCIA) {
				comp = (comp && lRestriccions.get(i).CompleixRes());
				
				if (!comp) return false;
			}
			
			if (tr == TipusRest.QUANTITAT) {
				RQuantitat raux = ((RQuantitat) lRestriccions.get(i));
				if (raux.esAquest(ed)) {
					raux.incrementa();
				}
				
			}
		}
		
		System.out.println(ed.nom + " " + comp);
		return comp;
		
		
	}
	
	
	
	
	
	

}

