/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package domini;
package barri;
/**
 *
 * @author alejandro.martinez.romero
 */
public abstract class Restriccio {
    
        //Atributs
        private int id;
        
        //Constructora
	
	/**
        * Crea una instancia de la classe Restriccio.
        * @param ID Es l'identificador associat a la restriccoi que acabem de crear. 
        */
	public Restriccio(int ID){
		id = ID;
	}
        //Metodes
        
        /**
        * Retorna l'identificador de la restriccio
        */
        public int ObtenirId(){
            return id;
        }
        
        /**
        * S'assigna un identificador a una restriccio.
        * @param ID Es l'identificador que volem assignar a la restriccio
        */
        public void AssignarId(int ID){
            id = ID;
        }
        
        /**
         * Funcio amb la que cada restriccio treu la seva informació principal
         */
        public abstract void InfoRes();
        
        /**
        * Funcio que cada restriccio especifica implementa per a saber si es compleix.
        */
        public abstract boolean CompleixRes();

}
