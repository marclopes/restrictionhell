package barri;


/**
 *
 * @author Eduard Ricou
 * La classe Negoci permet crear instancies de negoci, consultar els seus atributs i modificar-los.
 * @version 3.0
 */

public class Negoci extends Edifici{
    
        /**
         * Enumeració dels tipus de servei que existeixen.
         */
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
        * @param impost Ompostos que paga el negoci.
        * @param aparcament Places d'aparcament que té el negoci.
        * @param nom Nom descriptiu i identificador del negoci.
        * @param codi Codi numeric del negoci.
        * @param h Alçada del negoci.
        * @param capacitat Aforament del negoci.
        * @param t Tipus de Negoci que volem crear.
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
         * @return Impostos que paga el negoci.
         */
	
	public int ConsultarImpost(){
		return this.impost;
	}
        
        /**
         * Consultora de les places d'aparcament del negoci.
         * @return Places d'aparcament del negoci.
         */
	
	public int ConsultarAparcament(){
		return this.aparcament;
	}
        
       /** 
        * Consultora de la subclase de Negoci.
        * @return Tipus de negoci
        */
        
	public TipusNegoci consultarTipus() {
		return this.tipus;
	}
	
        /**
         * Modificadora dels impostos que paga el negoci.
         * @param impost Nou impost que pagarà el negoci.
         */
        
	public void ModificarImpost(int impost){
		this.impost = impost;
	}
	
        /**
         * Modificadora del nombre de places d'aparcament del negoci.
         * @param aparcament Nou nombre de places d'aparcament del negoci.
         */
        
	public void ModificarAparcament(int aparcament){
		this.aparcament = aparcament;
	}
        
         /** 
        * Modificadora del tipus de negoci.
        * @param t Nou tipus de negoci.
        */
        
	public void modificarTipus(TipusNegoci t) {
		tipus = t;
	}
}