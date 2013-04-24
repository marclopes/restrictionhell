package barri;

/**
 *
 *
 @author Edu
 */

public class Habitatge extends Edifici{

	public enum tipusHab {
		Casa,
		Pis,
		Mansio,
		Xalet
	};
	
	private tipusHab tipusHabitage;
	private int impost;
	private int aparcament;
	
	/**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
	
	public Habitatge(){
		
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
        
	public Habitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.HAB;
		this.impost = impost;
		this.aparcament = aparcament;
	}
	
        /**
         * Consultora dels impostos que paga l'habitatge.
         * @return els impostos que paga l'habitatge.
         */
        
	public int ConsultarImpost(){
		return this.impost;
	}
	
        /**
         * Consultora de les places d'aparcament que té l'habitatge.
         * @return el nombre de places d'aparcament de l'habitatge.
         */
        
	public int ConsultarAparcament(){
		return this.aparcament;
	}
	
        /**
         * Modifica els impostos que paga l'habitatge.
         * @param impost els nous impostos que pagarà l'habitatge.
         */
        
	public void ModificarImpost(int impost){
		this.impost = impost;
	}
	
        /**
         * Modifica el nombre de places d'aparcament de l'habitatge.
         * @param aparcament el nou nombre de places d'aparcament de l'habitatge.
         */
        
	public void ModificarAparcament(int aparcament){
		this.aparcament = aparcament;
	}
	
}
