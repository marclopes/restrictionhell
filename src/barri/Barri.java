package barri;


import java.io.Serializable;
import java.util.ArrayList;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;

public class Barri implements Serializable {

	private String nom;
	private int x, y, poblacio, pressupost, cost_m, aparcament;
    private Classes classe;
	
	private Espai espai;
	private ArrayList<RestriccioBarris> lRestriccions;
	private CjtEdificis lEdificis;
	boolean trobat = false;
	
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
        public void borraEdifici(String e) {
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

	public void modificarX(int x) {
		this.x = x;
                espai = new Espai(x,this.y);
	}
 
	public int consultarY() {
		return y;
	}

	public void modificarY(int y) {
		this.y = y;
                espai = new Espai(this.x,y);
	}
	/*public void ModificarXY(int x,int y) {
	    this.x=x;
	    this.y=y;
	    espai = new Espai(x,y);
	}*/
	public Edifici consultarEdifici(int x, int y) {
		if (espai.ExisteixElementxy(x, y) == false) return null;
		return (((Illa)(espai.ConsultarElementxy(x, y))).ConsultaEdifici());
	}
	
	
	public void borraIlla(int x, int y) {
		espai.InsertarElement(null, x + y*this.x, x, y);
		espai.EliminarElementxy(x, y);
	}
	

	
	public int tamRest() {
		return lRestriccions.size();
	}
	
	public RestriccioBarris obteRest(int i) {
		return lRestriccions.get(i);
	}
	
	public int tamEd() {
		return lEdificis.Tamany();
	}
	
	public Edifici obteEd(int i) {
		return lEdificis.ObtenirEdifici(i);
	}
	
	
	
	/**	
	void randomtrack(int id, boolean[][] t) {
		if (id < this.x * this.y) {	
			
			int x = (int) (Math.random()*this.x);
			int y = (int) (Math.random()*this.y);
			
			while (!t[x][y]) {
				//System.out.println(t[x][y]);
				x = (int) (Math.random()*this.x);
				y = (int) (Math.random()*this.y);
			}
		
			for (int i = 0; i < lEdificis.Tamany() && !trobat; i++) {
				
				//espai.InsertarElement(lEdificis.ObtenirEdifici(i), id, x, y);
				lEdificis.ObtenirEdifici(i).ModificarId(id);
				this.afegirAlBarri(lEdificis.ObtenirEdifici(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				if (legal(lEdificis.ObtenirEdifici(i))) {
					System.out.println("wea");
					//System.out.println("afegir: " + id + " " + i + " " + lEdificis.ObtenirEdifici(i).nom + " a " + x + ", " + y);
					t[x][y] = false;
					
					if (x == (this.x)-1) randomtrack(id+1, t);
					else randomtrack(id+1, t);			
					
				}
			}
		} else {
			trobat = true;

		}
	}	
	**/
	
	

}

