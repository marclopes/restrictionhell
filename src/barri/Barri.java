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
	
	
	public boolean preparaBack() {
		boolean b = true;
		for (int i = 0; i < lRestriccions.size(); i++) {
			if (lRestriccions.get(i) instanceof RAlsada) {
				RestriccioBarris raux = lRestriccions.get(i);
				
				if (!raux.CompleixRes()) {
					System.out.println("No compleix: " + raux.tr);
					b = false;
				}
			}
		}
		return b;
	}
	
	
	public boolean postBack() {
		boolean b = true;
		for (int i = 0; i < lRestriccions.size(); i++) {
			if (lRestriccions.get(i) instanceof RQuantitat && !((RQuantitat)lRestriccions.get(i)).esMax()) {
				RQuantitat raux = (RQuantitat) lRestriccions.get(i);
				if (raux.esMax() == false) {
					b = b && raux.CompleixRes();
				}
			}
		}
		return b;
	}
	
	
	
	
	void back(int id, int x, int y) {
		if (id < this.x * this.y) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			for (int i = 0; i < lEdificis.tamany() && !trobat; i++) {
				
				
				lEdificis.obtenirEdifici(i).ModificarId(id);
				this.afegirAlBarri(lEdificis.obtenirEdifici(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + lEdificis.obtenirEdifici(i).nom + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(lEdificis.obtenirEdifici(i), x, y)) {
					
					if (x == (this.x)-1) back(id+1, 0, y+1);
					else back(id+1, x+1, y);			
					
				}
				

			}
			if (!trobat) borraIlla(x, y);
				
		} else {
			trobat = true;

		}
	}
	
	boolean legal(Edifici ed, int x, int y) {
		boolean comp = true;
		for (int i = 0; i < lRestriccions.size(); i++) {
			TipusRest tr = lRestriccions.get(i).obteTipus();
			
			if (tr == TipusRest.QUANTITAT) {
				RQuantitat raux = ((RQuantitat) lRestriccions.get(i));
				if (raux.esMax()) comp = comp && raux.CompleixRes();
				
			}
			
			if (tr == TipusRest.DISTTIPUS) {
				comp = (comp && lRestriccions.get(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + lRestriccions.get(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			
			if (tr == TipusRest.INFUENCIA) {
				((RInfluencia)lRestriccions.get(i)).recorreCjt();
				((RInfluencia)lRestriccions.get(i)).assignaPos(x, y);
				comp = (comp && lRestriccions.get(i).CompleixRes());
				
				if (!comp) {
					System.out.println( " --> " + false + "  " + lRestriccions.get(i).obteTipus());
					System.out.println();
					//comp = false;
				}
			}
			
			if (tr == TipusRest.COST) {
				if (ed.consultarSubclasse() == TipusEd.SER) {
					if( ((RCost)lRestriccions.get(i)).esMax()) {
						int c = ((Servei)ed).ConsultarCost();
						((RCost)lRestriccions.get(i)).augmentaCost(c);
						boolean b = ((RCost)lRestriccions.get(i)).CompleixRes();
						comp = comp && b;
						if (!b) ((RCost)lRestriccions.get(i)).redueixCost(c);
					}
				}
			}
			
			
			if (tr == TipusRest.IMPOSTOS) {
				RImpostos raux = ((RImpostos)lRestriccions.get(i));
				int c;
				if (ed.consultarSubclasse() == TipusEd.HAB) {
					c = ((Habitatge)ed).ConsultarImpost();
					
				} else if (ed.consultarSubclasse() == TipusEd.NEG) {
					c = ((Negoci)ed).ConsultarImpost();
					
				} else c = -1; 
				
				raux.assignaImpAct(c);
				
				boolean b = raux.CompleixRes();
				comp = comp && b;
				
			}
			
			
		}
		
		System.out.println( " --> " + comp);
		System.out.println();
		return comp;
		
		
	}
	
	
	public void imprimeix() {
		for (int i = 0; i < this.consultarX(); i++) {
			for (int j = 0; j < this.consultarY(); j++) {
				String n;
				if (this.consultarEdifici(i, j) != null) n = this.consultarEdifici(i, j).ConsultarNom();
				else n = "nn";		
				System.out.print(n + " ");
			}
			System.out.println();
		}
		
	}
	
	
	void back2(int id, int x, int y) {
		if (id < this.x * this.y) {
		//if (id < (10)) {
			System.out.println("BAAAACK id:"+ id  + " pos: "+ x + ", " + y);
			
			int index = (int) (Math.random()*lEdificis.tamany());
			
			for (int j = 0; j < lEdificis.tamany() && !trobat; j++) {
				
				int i = (index+j)%lEdificis.tamany();
				
				lEdificis.obtenirEdifici(i).ModificarId(id);
				this.afegirAlBarri(lEdificis.obtenirEdifici(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				System.out.println("Intento afegir: " + id + " " + i + " " + lEdificis.obtenirEdifici(i).nom + " a " + x + ", " + y);
				boolean b;
				if ( b = legal(lEdificis.obtenirEdifici(i), x, y)) {
					
					if (x == (this.x)-1) back2(id+1, 0, y+1);
					else back2(id+1, x+1, y);			
					
				}
				System.out.println( " --> " + b);
				System.out.println();

			}
			if (!trobat) borraIlla(x, y);
			
		} else {
			trobat = true;

		}
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
		
			for (int i = 0; i < lEdificis.tamany() && !trobat; i++) {
				
				//espai.InsertarElement(lEdificis.obtenirEdifici(i), id, x, y);
				lEdificis.obtenirEdifici(i).ModificarId(id);
				this.afegirAlBarri(lEdificis.obtenirEdifici(i), id, x, y);
			
			
				//if (x == 14 && y == 14) continue;
				if (legal(lEdificis.obtenirEdifici(i))) {
					System.out.println("wea");
					//System.out.println("afegir: " + id + " " + i + " " + lEdificis.obtenirEdifici(i).nom + " a " + x + ", " + y);
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

