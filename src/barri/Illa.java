package barri;

/**
 *
 * @author Eduard Ricou
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
        * @param e És l'edifici amb que s'inicialitza l'illa 
	*/
	public Illa(Edifici e){
		this.edifici = e;
	}
        
	/** 
        * Assignar un edifici a la illa 
        * @param e És l'edifici que s'assigna a l'Illa 
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
        * @return edifici de l'illa
	*/
	public Edifici ConsultaEdifici(){
		return this.edifici;
	}

        /** 
        * Consulta si l'illa es buida 
        * @return cert si l'illa conté un edifici
	*/
        public boolean EsBuida(){
		return (this.edifici == null);
	}
}