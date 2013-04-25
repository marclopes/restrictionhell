package barri;

import java.util.*;

/**
 *
 * @author Edu
 */

public class Edifici extends Objecte {
	
	public enum TipusEd {
		HAB,
		SER,
		NEG
	};
	public enum Classes {
		Alta,
		Mitja,
		Baixa
	};
	
	private int h;
	private int capacitat;
	private List<Classes> clases;
	
	protected TipusEd tipusEd;
	
        /**
        * Crea una instancia de la clase sense inicialitzar 
        */ 
        
	public Edifici(){
		super(1, 1);
	}
	
        /** 
        * Crea una instancia de la classe Edifici.
        * @param nom és El nom descriptiu de l'edifici.
        * @param id és l'identificador de l'edifici
        * @param h és l'alçada de l'edifici.
        * @param capacitat ens diu quantes persones caben a l'edifici.
        */
        
	public Edifici(String nom, int id, int h, int capacitat){
		super(1, 1);
		super.nom = nom;
		super.id = id;
		this.h = h;
		this.capacitat = capacitat;	
	}
	
        /** 
        * Crea una copia de l'edifici que es passa per paràmetre.
        * @param e és l'edifici que volem copiar.
        */
        
	public Edifici Copia (Edifici e) {
		return new Edifici(this.nom, this.id, this.h, this.capacitat);
	}
	
	/** 
        * Consultora del nom de l'edifici.
        * @return El nom de l'edifici
        */
        
        @Override
	public String ConsultarNom(){
		return super.nom;
	}
	
        /** 
        * Consultora de l'identificador de l'edifici.
        * @return El l'identificador de l'edifici
        */
        
	public int ConsultarCodi(){
		return super.id;
	}
	
        /** 
        * Consultora de l'alçada de l'edifici.
        * @return L'alçada de l'edifici
        */
        
	public int ConsultarH(){
		return this.h;
	}
	
        /** 
        * Consultora de la capacitat de l'edifici.
        * @return La capacitat de l'edifici
        */
        
	public int ConsultarCapacitat(){
		return this.capacitat;
	}
	
        /** 
        * Consultora de les classes a les que pertany l'edifici.
        * @return La llista de classes a les que pertany l'edifici.
        */
        
	public List ConsultarClases(){
		return this.clases;
	}
	
        /** 
        * Consultora per saber si l'edifici pertany a una classe.
        * @param c és la clases que volem consultar.
        * @return true si l'edifici pertany a la classe.
        */
        
	public boolean EtsClase(Classes c){
		for(Classes clase: clases){
			if(c.equals(clase)) return true;
		}
		return false;
	}
	
        /** 
        * Consultora del tipus de l'edifici.
        * @return El tipus de l'edifici
        */
        //Podriem retornar un String del tipus????
	public TipusEd consultarSubclasse() {
		return this.tipusEd;
	}
	
	
	
	/* MODIFICADORES */
	
        /** 
        * Modificadora de l'alçada de l'edifici.
        * @param h La nova alçada de l'edifici.
        */
        
	public void ModificarH(int h){
		this.h = h;
	}
	
        /** 
        * Modificadora de la capacitat de l'edifici.
        * @param capacitat La nova capacitat de l'edifici.
        */
        
	public void ModificarCapacitat(int capacitat){
		this.capacitat = capacitat;
	}
	       
        /** 
        * Afegeix la una classe social a l'edifici.
        * @param c La classe que volem afegir.
        */
        
        public void AfegirClase(Classes c){
	    
            this.clases.add(c);
        }
        
        /** 
        * Elimina una classe social a l'edifici.
        * @param c La classe social que volem eliminar.
        */
        
        public void EliminarClase(Classes c){
            for(Classes clase : clases){
			if(c==clase){
                            int i;
                            i = this.clases.indexOf(clase);
                            this.clases.remove(i);
                        }
            }
        }
	
}