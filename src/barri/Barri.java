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
         * Crea una instancia de la classe Barri.
         * @param n Nom del Barri.
         * @param mitja Classe a la que pertany el barri.
         * @param xx Amplada del barri.
         * @param yy Longitud del barri.
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
	
        /**
         * Carrega un edifici al conjunt d'edificis del barri.
         * @param e Edifici que volem afegir al conjunt d'edificis del barri.
         * @return Cert si s'ha pogut afegir l'edifici al barri. False si la classe de l'edifici no es la mateixa que la del barri.
         */
	public int CarregaEdifici(Edifici e) {
                if(e.EtsClase(this.classe)){
                    lEdificis.AfegirEdifici(e);
                    return 0;
                }
                return -1;
	}
	
        /**
         * Esborra un edifici del conjunt d'edificis del barri.
         * @param e Edifici que volem eliminar.
         */
	public void BorraEdifici(Edifici e) {
		lEdificis.EliminarEdifici(e);
	}
        
        /**
         * Esborra un edifici del conjunt d'edificis del barri.
         * @param nom Nom de l'edifici que volem eliminar.
         */
        public int BorraEdifici(String nom) {
		
                if (!lEdificis.ExisteixEdifici(nom)) return -1;
                lEdificis.EliminarEdifici(nom);
                return 0;
	}
	
	/**
         * Afegeix un edifici a una illa del espai del barri.
         * @param e Edifici que volem afegir.
         * @param id Identificador de la illa on afegim l'edifici.
         * @param a Posicio X de la illa dins l'espai.
         * @param b Posicio Y de la illa dins l'espai.
         */
	public void AfegirAlBarri(Edifici e, int id ,int a,int b) {
		espai.InsertarElement(new Illa(e), id, a, b);
	}
	
        /**
         * Afegeix una restriccio al conjunt de restriccions del barri.
         * @param r Restriccio que volem afegir.
         */
	public int AfegeixRestriccio(RestriccioBarris r){
	    if (r instanceof REspai) ((REspai)r).AssignaEspai(espai);
	    if (r instanceof RCjtEd) ((RCjtEd)r).AssignaCe(lEdificis);
	    for (int i=0;i<lRestriccions.size() ;++i){
                if(lRestriccions.get(i).ObtenirId()==r.ObtenirId()) return -1;
            }
	    lRestriccions.add(r);
            return 0;
	}
        
        /**
         * Elimina una restriccio del conjunt de restriccions del barri.
         * @param id Identificador de la restriccio.
         */
        public int EliminarRestriccio(int id) {
	    for(int i=0;i<lRestriccions.size();++i) {
		if(lRestriccions.get(i).ObtenirId()==id) {
		    lRestriccions.remove(i);
		    return 0;
		}
	    }
            return -1;
        }
        
	
	// Consultores i modificadores
	
        /**
         * Consulta el nom del barri.
         * @return El nom del barri.
         */
	public String ConsultarNom() {
		return nom;
	}
        
        /**
         * Modifica el nom del barri
         * @param nom Nou nom que volem per al barri
         */
	public void ModificarNom(String nom) {
		this.nom = nom;
	}
        
        /**
         * Consulta el pressupost del barri.
         * @return El pressupost del barri.
         */
	public int ConstultarPressupost() {
		return pressupost;
	}

        /**
         * Modifica el pressupost del barri.
         * @param pressupost Nou pressupost del barri.
         */
	public void ModificarPressupost(int pressupost) {
		this.pressupost = pressupost;
	}

        /**
         * Consulta la poblacio del barri.
         * @return La poblacio del barri.
         */
	public int ConsultarPoblacio() {
		return poblacio;
	}

        /**
         * Modifica la poblacio del barri.
         * @param poblacio Nova poblacio del barri.
         */
	public void ModificarPoblacio(int poblacio) {
		this.poblacio = poblacio;
	}

        /**
         * Consulta la classe social del barri.
         * @return La classe social del barri.
         */
	public Classes ConsultarClasse() {
		return classe;
	}

        /**
         * Modifica la classe social del barri.
         * @param classe Nova classe social del barri.
         */
	public void ModificarClasse(Classes cl) {
                Edifici e;
                for(int i = 0; i < lEdificis.Tamany(); i++){
                    e = lEdificis.ObtenirEdifici(i);
                    if(!e.EtsClase(cl)) lEdificis.EliminarEdifici(e);
                }
	}
        
        /**
         * Consulta el cost de manteniment del barri.
         * @return El cost de manteniment del barri.
         */
	public int ConsultarCost_m() {
		return cost_m;
	}

        /**
         * Modifica el cost de manteniment del barri.
         * @param cost_m Nou cost de manteniment del barri.
         */
	public void ModificarCost_m(int cost_m) {
		this.cost_m = cost_m;
	}

        /**
         * Consulta el nombre de places d'aparcament del barri.
         * @return El nombre de places d'aparcament del barri.
         */
	public int ConsultarAparcament() {
		return aparcament;
	}

        /**
         * Modifica el nombre de places d'aparcament del barri.
         * @param aparcament Nou nombre de places d'aparcament del barri.
         */
	public void ModificarAparcament(int aparcament) {
		this.aparcament = aparcament;
	}

        /**
         * Consulta l'amplada del barri.
         * @return L'amplada del barri.
         */
	public int ConsultarX() {
		return x;
	}

        /**
         * Modifica l'amplada del barri.
         * @param x Nova amplada del barri.
         */
	public void ModificarX(int x) {
		this.x = x;
                espai = new Espai(x,this.y);
	}
        
        /**
         * Consulta la longitud del barri.
         * @return La longitud del barri.
         */
	public int ConsultarY() {
		return y;
	}

        /**
         * Modifica la longitud del barri.
         * @param y La nova longitud del barri.
         */
	public void ModificarY(int y) {
		this.y = y;
                espai = new Espai(this.x,y);
	}
	
        /**
         * Consulta un edifici a partir de les seves coordenades al barri.
         * @param x Posició X al barri.
         * @param y Posició Y al barri.
         * @return L'edifici ubicat a la posicio X i Y del barri.
         */
	public Edifici ConsultarEdifici(int x, int y) {
		if (espai.ExisteixElementxy(x, y) == false) return null;
		return (((Illa)(espai.ConsultarElementxy(x, y))).ConsultaEdifici());
	}
	
	/**
         * Esborra una illa del barri.
         * @param x Posicio X de la illa.
         * @param y Posicio Y de la illa.
         */
	public void BorraIlla(int x, int y) {
		espai.InsertarElement(null, x + y*this.x, x, y);
		espai.EliminarElementxy(x, y);
	}
	
        /**
         * Consulta quantes restriccions te assignades el barri.
         * @return El nombre de restriccions que te assignades el barri.
         */
	public int TamRest() {
		return lRestriccions.size();
	}
	
        /**
         * Consulta la restricció i-essima del conjunt de restriccions que te el barri. 
         * @param i Posicio de la restriccio que volem consultar.
         * @return La restriccio i-essima del conjunt de restriccions.
         */
	public RestriccioBarris ObteRest(int i) {
		return lRestriccions.get(i);
	}
	
        /**
         * Consulta el tamany del conjunt d'edificis del barri.
         * @return El tamany del conjunt d'edificis del barri.
         */
	public int TamEd() {
		return lEdificis.Tamany();
	}
	
        /**
         * Consulta l'edifici i-essim del conjunt d'edificis del barri.
         * @param i Posicio de l'edifici que volem consultar.
         * @return L'edifixi i-essim del conjunt d'edificis.
         */
	public Edifici ObteEd(int i) {
		return lEdificis.ObtenirEdifici(i);
	}
        /**
         * Comprova que l'edifici estigui afegit al barri 
         * @param nom Nom del edifici a buscar
         * @return retorna true si esta al barri, sino torna false
         */
        public boolean ExisteixEdifici(String nom) {
            return lEdificis.ExisteixEdifici(nom);
        }
        /**
         * Comprova que la restriccio estigui imposada al barri
         * @param id identificador de la restriccio a buscar
         * @return retorna true si la restriccio esta imposada al barri, sino torna false
         */
        public boolean ExisteixRest(int id){
            for (int i=0; i<lRestriccions.size();++i){
                if (lRestriccions.get(i).ObtenirId()==id) return true;
            }
            return false;
        }
}

