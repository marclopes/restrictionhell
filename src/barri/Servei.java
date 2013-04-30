package barri;
/**
 *
 *
 @author Eduard Ricou
 */

public class Servei extends Edifici{ // canviar nom per ServeiPublic
	
	public enum tipusServei {
		Hospital,
		Escola,
		Policia,
		Preso,
		Bombers,
		Parc,
		Centre_Cultural
	}
	private tipusServei tipus;
	private int cost;
	private int manteniment;
	private int areaInfluencia;
	
        /**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
        
	public Servei(){
	}
	
        /** 
        * Crea una instancia de la classe Servei.
        * @param cost és el cost de posar en marxa el servei.
        * @param manteniment és el cost de manteniment del servei.
        * @param area és l'area d'influencia del servei.
        * @param nom és El nom descriptiu del servei.
        * @param id és l'identificador del servei.
        * @param h és l'alçada del servei.
        * @param capacitat ens diu quantes persones caben al servei.
        */
        
	public Servei(int cost, int manteniment, int area, String nom, int codi, int h, int capacitat, tipusServei t){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.SER;
		this.cost = cost;
		this.manteniment = manteniment;
		this.areaInfluencia = area;
                this.tipus = t;
	}
	
        /**
         * Consultora del cost de construcció del servei.
         * @return el cost de construcció del servei
         */
        
	public int ConsultarCost(){
		return this.cost;
	}
	
        /**
         * Consultora del cost de manteniment del servei.
         * @return el cost de manteniment del servei.
         */
        
	public int ConsultarManteniment(){
		return this.manteniment;
	}

        /**
         * Consultora de l'àrea d'influencia del servei.
         * @return l'àrea d'influència del servei.
         */
        
	public int ConsultarAreaInfluencia(){
		return this.areaInfluencia;
	}
        
        	/** 
        * Consultora de la subclase del servei.
        * @return la subclasse de l'edifici
        */
        
	public tipusServei consultarTipus() {
		return this.tipus;
	}
	
        /**
         * Modifica el cost de construcció del servei.
         * @param cost el nou cost de construcció del servei.
         */
        
	public void ModificarCost(int cost){
		this.cost = cost;
	}
        
        /**
         * Modifica el cost de manteniment del servei.
         * @param manteniment el nou cost de manteniment del servei.
         */
	
	public void ModificarManteniment(int manteniment){
		this.manteniment = manteniment;
	}
	
        /**
         * Modifica l'àrea d'influencia del servei.
         * @param area la nova àrea d'influencia del servei.
         */
        
	public void ModificarAreaInfluencia(int area){
		this.areaInfluencia = area;
	}
        
        /** 
        * Modificadora del tipus del servei.
        * @param t El nou tipus del servei.
        */
        
	public void modificarTipus(tipusServei t) {
		tipus = t;
	}
        
}