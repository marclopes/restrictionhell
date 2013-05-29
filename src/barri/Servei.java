package barri;
/**
 *
 * @author Eduard Ricou
 * La classe Servei permet crear instancies de servei, consultar els seus atributs i modificar-los.
 * @version 3.0
 */

public class Servei extends Edifici{
	
    /**
     * Enumeració dels tipus de servei que existeixen.
     */
	public enum TipusServei {
            Hospital,
            Escola,
            Policia,
            Preso,
            Bombers,
            Parc,
            Centre_Cultural
	}
        
	private TipusServei tipus;
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
        * @param cost Cost de construir el servei.
        * @param manteniment Cost de manteniment del servei.
        * @param area Area d'influencia del servei.
        * @param nom Nom descriptiu i identificador del servei.
        * @param codi Codi numeric del servei.
        * @param h Alçada del servei.
        * @param capacitat Persones que caben al servei.
        * @param t Tipus de servei que volem crear.
        */
        
	public Servei(int cost, int manteniment, int area, String nom, int codi, int h, int capacitat, TipusServei t){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.SER;
		this.cost = cost;
		this.manteniment = manteniment;
		this.areaInfluencia = area;
                this.tipus = t;
	}
	
        /**
         * Consultora del cost de construcció del servei.
         * @return Cost de construcció del servei
         */
        
	public int ConsultarCost(){
		return this.cost;
	}
	
        /**
         * Consultora del cost de manteniment del servei.
         * @return Cost de manteniment del servei.
         */
        
	public int ConsultarManteniment(){
		return this.manteniment;
	}

        /**
         * Consultora de l'àrea d'influencia del servei.
         * @return Àrea d'influència del servei.
         */
        
	public int ConsultarAreaInfluencia(){
		return this.areaInfluencia;
	}
        
        	/** 
        * Consultora de la subclase del servei.
        * @return Subclasse de l'edifici
        */
        
	public TipusServei consultarTipus() {
		return this.tipus;
	}
	
        /**
         * Modifica el cost de construcció del servei.
         * @param cost Nou cost de construcció del servei.
         */
        
	public void ModificarCost(int cost){
		this.cost = cost;
	}
        
        /**
         * Modifica el cost de manteniment del servei.
         * @param manteniment Nou cost de manteniment del servei.
         */
	
	public void ModificarManteniment(int manteniment){
		this.manteniment = manteniment;
	}
	
        /**
         * Modifica l'àrea d'influencia del servei.
         * @param area Nova àrea d'influencia del servei.
         */
        
	public void ModificarAreaInfluencia(int area){
		this.areaInfluencia = area;
	}
        
        /** 
        * Modificadora del tipus del servei.
        * @param t Nou tipus del servei.
        */
        
	public void modificarTipus(TipusServei t) {
		tipus = t;
	}
        
}