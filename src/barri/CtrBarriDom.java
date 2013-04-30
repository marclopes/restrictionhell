package barri;

import barri.Edifici.Classes;

public class CtrBarriDom {

    
 
  private static CtrBarriDom ctrBarri= null;

  private CjtBarris cjtBarris;
  /**
   * Crea una instancia del controlador de Barris
   */
  private CtrBarriDom () {
  }
  /**
   * Retorna la instancia del controlador de barris i si no existeix la crea
   * @return CtrBarriDom , instancia del controlador de barris
   */
  public static CtrBarriDom GetInstancia() {
    if ( ctrBarri== null ) ctrBarri = new CtrBarriDom();
    return ctrBarri;
  }
  /**
   * Crea un barri amb els parametres donats
   * @param n Nom del barri
   * @param po Poblacio minima del barri
   * @param pr Presopost maxim del barri
   * @param c Cost de manteniment maxim
   * @param cl Classe social del barri
   * @param a Aparcaments minims del barri
   * @param xx Dimensio X del barri
   * @param yy Dimensio Y del barri
   */
  public void CreaBarri(String n, int po, int pr, int c, Classes cl, int a, int xx, int yy) {
    Barri barri = new Barri(n,po,pr,c,cl,a,xx,yy);
    cjtBarris.AfegirBarri(barri);
  }
  /**
   * Elimina un barri amb nom n
   * @param n Nom del barri a eliminar
   */
  public void EliminarBarri(String n) {
    cjtBarris.EliminarBarri(n);
  }
  /**
   * Retorna una instancia del barri
   * @param n Nom del barri
   * @return Barri, instancia del barri amb nom n
   */
  public Barri ObtenirBarri(String n) {
    return cjtBarris.GetBarri(n);
  }
  /**
   * Afegeix la restriccio r al barri amb nom nomBarri
   * @param nomBarri Nom del barri al que se li afegeix la restriccio
   * @param r Restriccio a afegir al barri
   */
  public void AfegeixRestriccions(String nomBarri,RestriccioBarris r) {
      Barri b = ctrBarri.ObtenirBarri(nomBarri);
      b.AfegeixRestriccio(r);    
  }
  /**
   * Guarda el Barri en format .o
   * @param n Nom del barri que es guarda
   */
  public void GuardarBarri(String n) {
    //crida controlador persistencia
    
  }
  /**
   * Afegeix edifici e al barri amb nomBarri
   * @param e Edifici a afegir al barri
   * @param nomBarri Nom del barri al que se li afegeix l'edifici
   */
  public void AfegirEdifici(Edifici e,String nomBarri) {
      Barri b = ctrBarri.ObtenirBarri(nomBarri);
      if (b!=null) {
	  b.carregaEdifici(e);
      }
  }
  /**
   * Genera una possible distribucio dels edificis del barri amb les restriccions donades
   * @param n Nom del barri a generar
   */
  public void GenerarBarri(String n){
      Barri barri = cjtBarris.GetBarri(n);
  }
  /**
   * Elimina l'edicifi amb nomEdifici del barri amb nomBarri
   * @param nomBarri Nom del barri al que se li elimina l'edifici
   * @param nomEdifici Nom del edifici que es vol eliminar
   */
  public void TreureEdifici(String nomBarri,String nomEdifici) {
      Barri aux = ctrBarri.ObtenirBarri(nomBarri);
      if (aux!=null) {
	  aux.borraEdifici(nomEdifici);
      }
  }
  /**
   * Elimina la restriccio amb idRest del barri amb nomBarri
   * @param nomBarri Nom del barri al que se li elimina la restriccio
   * @param idRest Identificador de la restriccio que es vol eliminar
   */
  public void TreureRestriccio(String nomBarri,int idRest) {
      Barri aux = ctrBarri.ObtenirBarri(nomBarri);
      if (aux!=null) {
	  aux.EliminarRestriccio(idRest);
      }
  }  
}