package barri;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eduard Ricou
 * Classe abstracta que defineix atributs genercis dels edificis i permet consultar-los i modificar-los.
 * @version 3.0
 */

public abstract class Edifici extends Objecte implements Serializable {

        /**
         * Enumera els tipus d'edificis que poden existir.
         */
	public enum TipusEd {
		HAB,
		SER,
		NEG
	};
        
        /**
         * Enumeració de les classes socials a les que pot pertanyer un edifici.
         */
	public enum Classes {
		Alta,
		Mitja,
		Baixa
	};
	
	private int h;
	private int capacitat;
	private ArrayList<Classes> clases = new ArrayList<Classes>();
	protected TipusEd tipusEd;
	
        /**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
        
	public Edifici(){
		super(1, 1);
	}
	
        /** 
        * Crea una instancia de la classe Edifici.
        * @param nom Nom descriptiu i identificador de l'edifici.
        * @param id Codi numèric de l'edifici
        * @param h Alçada de l'edifici.
        * @param capacitat Nombre de persones que caben a l'edifici.
        */
        
	public Edifici(String nom, int id, int h, int capacitat){
		super(1, 1);
		super.nom = nom;
		super.id = id;
		this.h = h;
		this.capacitat = capacitat;	
        }
	
        /** 
        * Consultora de l'identificador de l'edifici.
        * @return Identificador de l'edifici
        */
        
	public int ConsultarCodi(){
		return super.id;
	}
	
        /** 
        * Consultora de l'alçada de l'edifici.
        * @return alçada de l'edifici
        */
        
	public int ConsultarH(){
		return this.h;
	}
	
        /** 
        * Consultora de la capacitat de l'edifici.
        * @return Capacitat de l'edifici
        */
        
	public int ConsultarCapacitat(){
		return this.capacitat;
	}
	
        /** 
        * Consultora de les classes a les que pertany l'edifici.
        * @return Llista de classes a les que pertany l'edifici.
        */
        
	public ArrayList ConsultarClases(){
		return this.clases;
	}
	
        /** 
        * Consultora per saber si l'edifici pertany a una classe.
        * @param c és la clases que volem consultar.
        * @return <code>true</code> si l'edifici pertany a la classe.
        *         <code>false</code> si l'edifici no pertany a la classe.
        */
        
	public boolean EtsClase(Classes c){
                if(this.clases != null){
                    for(Classes clase: clases){
                            if(c == clase) return true;
                    }
                }
		return false;
	}
	
        /** 
        * Consultora del tipus de l'edifici.
        * @return Tipus d'edifici.
        */
	public TipusEd consultarSubclasse() {
		return this.tipusEd;
        }
	
        /** 
        * Modificadora de l'alçada de l'edifici.
        * @param h Nova alçada de l'edifici.
        */
        
	public void ModificarH(int h){
		this.h = h;
	}
	
        /** 
        * Modificadora de la capacitat de l'edifici.
        * @param capacitat Nova capacitat de l'edifici.
        */
        
	public void ModificarCapacitat(int capacitat){
		this.capacitat = capacitat;
	}
	       
        /** 
        * Afegeix la una classe social a l'edifici.
        * @param c Classe que volem afegir.
        */
        
        public void AfegirClase(Classes c){
	    if (!this.EtsClase(c)){
                this.clases.add(c);
            }
        }
        
        /** 
        * Elimina una classe social a l'edifici.
        * @param c Classe social que volem eliminar.
        */
        
        public void EliminarClase(Classes c){
            if(this.EtsClase(c)){
                int i;
                i = this.clases.indexOf(c);
                this.clases.remove(i);
            }
        }
	
}