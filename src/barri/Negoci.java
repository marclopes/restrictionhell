package barri;
import java.util.*;

import barri.Edifici.TipusEd;

/**
 *
 *
 @author Edu
 */

public class Negoci extends Edifici{

	private int impost;
	private int aparcament;
	
        /**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
        
	Negoci(){
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
        
	public Negoci(int impost, int aparcament, String nom, int codi, int h, int capacitat){
		super(nom, codi, h, capacitat);
		super.tipusEd = TipusEd.NEG;
		this.impost = impost;
		this.aparcament = aparcament;
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
}