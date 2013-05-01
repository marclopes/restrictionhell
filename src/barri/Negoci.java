package barri;


/**
 *
 *
 @author Eduard Ricou
 */

public class Negoci extends Edifici{
	public enum TipusNegoci {
		Discoteca,
		Banc,
		Bar,
		Restaurant,
		Botiga_alimentacio,
		Botiga_roba,
		Escola_privada,
		Clinica
	};
	private int impost;
	private int aparcament;
	private TipusNegoci tipus;
        /**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
        
	public Negoci(){
	}
	
        /** 
        * Crea una instancia de la classe Negoci.
        * @param impost són els impostos que paga el negoci.
        * @param aparcament són les places d'aparcament que té el negoci.
        * @param nom és El nom descriptiu del negoci.
        * @param id és l'identificador del negoci.
        * @param h és l'alçada del negoci.
        * @param capacitat ens diu quantes persones caben al negoci.
        */
        
	public Negoci(int impost, int aparcament, String nom, int codi, int h, int capacitat, TipusNegoci t){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.NEG;
		this.impost = impost;
		this.aparcament = aparcament;
                this.tipus = t;
	}
        
        /**
         * Consultora dels impostos que paga el negoci.
         * @return els impostos que paga el negoci.
         */
	
	public int ConsultarImpost(){
		return this.impost;
	}
        
        /**
         * Consultora de les places d'aparcament del negoci.
         * @return Les places d'aparcament del negoci.
         */
	
	public int ConsultarAparcament(){
		return this.aparcament;
	}
        
        	/** 
        * Consultora de la subclase de Negoci.
        * @return El tipus de negoci
        */
        
	public TipusNegoci consultarTipus() {
		return this.tipus;
	}
	
        /**
         * Modificadora dels impostos que paga el negoci.
         * @param impost és el nou impost que pagarà el negoci.
         */
        
	public void ModificarImpost(int impost){
		this.impost = impost;
	}
	
        /**
         * Modificadora del nombre de places d'aparcament del negoci.
         * @param aparcament El nou nombre de places d'aparcament del negoci.
         */
        
	public void ModificarAparcament(int aparcament){
		this.aparcament = aparcament;
	}
        
         /** 
        * Modificadora del tipus de negoci.
        * @param t El nou tipus de negoci.
        */
        
	public void modificarTipus(TipusNegoci t) {
		tipus = t;
	}
}