package barri;

/**
 *
 * @author Eduard Ricou
 * La classe Illa es un contenidor d'un sol edifici.
 * @version 3.0
 */
public class Illa{

	private Edifici edifici;
	
        /**
        * Crea una instancia de la clase Illa sense inicialitzar 
        */ 
	public Illa(){
	}
        
	/** 
        * Crea una instancia de la classe Illa inicialitzada.
        * @param e Edifici amb que s'inicialitza l'illa 
	*/
	public Illa(Edifici e){
		this.edifici = e;
	}
        
	/** 
        * Assignar un edifici a la illa 
        * @param e Edifici que s'assigna a l'Illa 
	*/
	public void AssignaEdifici(Edifici e){
		this.edifici = e;
	}
        
	/** 
        * Elimina l'edifici de l'Illa 
	*/
	public void EliminaEdifici(){
		this.edifici = null;
	}
        
	/** 
        * Consulta l'edifici de l'Illa 
        * @return Edifici de l'illa
	*/
	public Edifici ConsultaEdifici(){
		return this.edifici;
	}

        /** 
        * Consulta si l'illa es buida 
        * @return <code>true</code> si l'illa conté un edifici
        *         <code>false</code> si l'illa no conté cap edifici.
	*/
        public boolean EsBuida(){
		return (this.edifici == null);
	}
}