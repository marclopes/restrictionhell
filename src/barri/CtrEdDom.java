package barri;
import barri.Edifici.Classes;
import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;

/**
 *
 * @authors Albert Navarro i Eduard Ricou
 */
public class CtrEdDom {
    
  private static CtrEdDom ctrEd= null;
  private CjtEdificis cjtEd;
  
  /**
   * Crea una instancia buida del controlador d'edificis.
   */
  private CtrEdDom () {
    cjtEd= new CjtEdificis();
  }
  
  /**
   * Crea una instancia del controlador d'edificis en cas de que no estigui creada.
   * @return una instancia del controlador d'edificis.
   */
  public static CtrEdDom ObteInstancia() {
    if ( ctrEd== null ) ctrEd = new CtrEdDom();
    return ctrEd;
  }
  
  /**
   * Crea un habitatge i l'afegeix al conjunt d'edificis del controlador.
   * @param impost Impostos que pagarà aquest habitatge.
   * @param aparcament Places d'aparcament del habitatge.
   * @param nom Nom de l'habitatge.
   * @param codi Codi de l'habitatge.
   * @param h Alçada de l'edifici.
   * @param capacitat Nombre de persones que poden viure a l'habitatge.
   * @param tipus Tipus d'habitatge.
   */
  public void CreaHabitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, tipusHab tipus) {
    Habitatge hab = new Habitatge(impost,aparcament,nom,codi,h,capacitat,tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  /**
   * Crea un negoci i l'afegeix al conjunt d'edificis del controlador.
   * @param impost Impostos que pagarà aquest negoci.
   * @param aparcament Places d'aparcament del negoci.
   * @param nom Nom del negoci.
   * @param codi Codi del negoci.
   * @param h Alçada de l'edifici.
   * @param capacitat Aforament del negoci.
   * @param tipus Tipus de negoci.
   */
  public void CreaNegoci(int impost, int aparcament, String nom, int codi, int h, int capacitat, tipusNegoci tipus) {
    Negoci hab = new Negoci(impost,aparcament,nom,codi,h,capacitat,tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  /**
   * Crea un servei i l'afegeix al conjunt d'edificis del controlador.
   * @param cost Cost de contrucció del servei.
   * @param manteniment Cost de manteniment del servei.
   * @param area Àrea d'influència del servei.
   * @param nom Nom del servei
   * @param codi Codi del servei.
   * @param h Alçada de l'edifici.
   * @param capacitat Aforament del servei.
   * @param tipus Tipus de servei.
   */
  public void CreaServei(int cost, int manteniment, int area, String nom, int codi, int h, int capacitat, tipusServei tipus) {
    Servei hab = new Servei(cost, manteniment, area, nom, codi, h, capacitat, tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  /**
   * Permet modificar un atribut d'un edifici.
   * @param nomEdifici Nom de l'edifici que volem modificar.
   * @param atribut Nom de l'atribut que volem modificar.
   * @param valor Nou valor de l'atribut.
   */
    public void ModificarEdifici(String nomEdifici,String atribut ,String valor ){
	 Edifici tmpEdifici = cjtEd.ObtenirEdifici(nomEdifici);
	 if (atribut.equals("altura")){
	    tmpEdifici.ModificarH(Integer.parseInt(valor));
	 }
	 else if(atribut.equals("capacitat")){
	    tmpEdifici.ModificarCapacitat(Integer.parseInt(valor));
	 }
	 else if(atribut.equals("clase")){
	    Classes k = StringToClase(valor);
	    tmpEdifici.AfegirClase(k);
	    
	 }
	 else {
	    if (tmpEdifici instanceof Habitatge) {
		if(atribut.equals("impost")) {
		    ((Habitatge) tmpEdifici).ModificarImpost(Integer.parseInt(valor));
		}
		else if(atribut.equals("aparcament")){
		    ((Habitatge) tmpEdifici).ModificarAparcament(Integer.parseInt(valor));
		}
	    }
	    else if (tmpEdifici instanceof Negoci) {
		if(atribut.equals("impost")) {
		    ((Negoci)tmpEdifici).ModificarImpost(Integer.parseInt(valor));
		}
		else if(atribut.equals("aparcament")){
		     ((Negoci)tmpEdifici).ModificarAparcament(Integer.parseInt(valor));
		}
	    }
	    else if (tmpEdifici instanceof Servei) {
		if(atribut.equals("cost")){
		    ((Servei)tmpEdifici).ModificarCost(Integer.parseInt(valor));
		}
		else if(atribut.equals("manteniment")){
		    ((Servei)tmpEdifici).ModificarManteniment(Integer.parseInt(valor));
		}
		else if(atribut.equals("area influencia")){
		    ((Servei)tmpEdifici).ModificarAreaInfluencia(Integer.parseInt(valor));
		}
	    }
	 }
	 
	 
  }
    
  /**
   * Elimina un edifici identificat per el seu nom del conjunt d'edificis del controlador.
   * @param n Nom de l'edifici que volem eliminar.
   */
  public void EliminarEdifici(String n) {
    cjtEd.EliminarEdifici(n);
  }
  
  /**
   * Elimina un edifici del conjunt d'edificis del controlador.
   * @param e Edifici que volem eliminar.
   */
  public void EliminarEdifici(Edifici e) {
    cjtEd.EliminarEdifici(e);
  }
  
  /**
   * Consultora per obtenir un edifici identificat per el seu nom.
   * @param n Nom de l'edifici.
   * @return L'edifici identificat per nom.
   */
  public Edifici ObtenirEdifici(String n) {
    return cjtEd.ObtenirEdifici(n);
  }
  
  /**
   * Comprova que l'edifici identificat per nom existeix.
   * @param nom Nom de l'edifici que volem consultar.
   * @return Cert si l'edifici existeix.
   */
  public boolean ExisteixEdifici(String nom){
      return cjtEd.ExisteixEdifici(nom);
  }
  
  /**
   * Guarda l'edifici identificat per nom en un fitxer.
   * @param n Nom de l'edifici que volem guardar.
   */
  public void GuardarEdifici(String n) {
    //crida controlador persistencia
  }
  
  /**
   * Converteix un String en la classe social corresponent.
   * @param c String que volem convetir.
   * @return La classe social associada al String.
   */
  private Classes StringToClase(String c) {
      if(c.equals("Alta")) return Classes.Alta;
      else if(c.equals("Mitja")) return Classes.Mitja;
      else return Classes.Baixa;
  }
}
