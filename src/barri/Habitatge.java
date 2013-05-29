package barri;

/**
 *
 * @author Eduard Ricou
 * La classe Habitatge permet crear instancies d'habitatge, consultar els seus atributs i modificar-los.
 * @version 3.0
 */

public class Habitatge extends Edifici{

        /**
         * Enumeració dels tipus d'habitatge que existeixen.
         */
	public enum TipusHab {
		Casa,
		Pis,
		Mansio,
		Xalet
	};
	
	private TipusHab tipus;
	private int impost;
	private int aparcament;
	
	/**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
	
	public Habitatge(){
		
	}
	
        /** 
        * Crea una instancia de la classe Habitatge.
        * @param impost Impostos que paga l'habitatge.
        * @param aparcament Places d'aparcament que té l'habitatge.
        * @param nom Nom descriptiu de l'habitatge.
        * @param codi Codi numèric de l'habitatge.
        * @param h Alçada de l'habitatge.
        * @param capacitat Capacitat de l'habitatge
        * @param t Tipus d'habitatge.
        */
        
	public Habitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, TipusHab t){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.HAB;
		this.impost = impost;
		this.aparcament = aparcament;
                this.tipus = t;
	}
	
        /**
         * Consultora dels impostos que paga l'habitatge.
         * @return Impostos que paga l'habitatge.
         */
        
	public int ConsultarImpost(){
		return this.impost;
	}
	
        /**
         * Consultora de les places d'aparcament que té l'habitatge.
         * @return Nombre de places d'aparcament de l'habitatge.
         */
        
	public int ConsultarAparcament(){
		return this.aparcament;
	}
	
        /** 
        * Consultora de la subclase de l'edifici.
        * @return Subclasse de l'edifici
        */
        
	public TipusHab consultarTipus() {
		return this.tipus;
	}
        
        /**
         * Modifica els impostos que paga l'habitatge.
         * @param impost Nou impost que pagarà l'habitatge.
         */
        
	public void ModificarImpost(int impost){
		this.impost = impost;
	}
	
        /**
         * Modifica el nombre de places d'aparcament de l'habitatge.
         * @param aparcament Nou nombre de places d'aparcament de l'habitatge.
         */
        
	public void ModificarAparcament(int aparcament){
		this.aparcament = aparcament;
	}
	
         /** 
        * Modificadora del tipus de l'habitatge.
        * @param t Nou tipus de l'habitatge.
        */
        
	public void modificarTipus(TipusHab t) {
		tipus = t;
	}
        
}
