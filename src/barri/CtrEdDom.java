/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;

/**
 *
 * @author Edu
 */
public class CtrEdDom {
    
  private static CtrEdDom ctrEd= null;
  private CjtEdificis cjtEd;
  
  private CtrEdDom () {
  }
  
  public CtrEdDom GetInstancia() {
    if ( ctrEd== null ) ctrEd = new CtrEdDom();
    return ctrEd;
  }
  
  public void CreaHabitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, tipusHab tipus) {
    Habitatge hab = new Habitatge(impost,aparcament,nom,codi,h,capacitat,tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  public void CreaNegoci(int impost, int aparcament, String nom, int codi, int h, int capacitat, tipusNegoci tipus) {
    Negoci hab = new Negoci(impost,aparcament,nom,codi,h,capacitat,tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  public void CreaServei(int cost, int manteniment, int area, String nom, int codi, int h, int capacitat, tipusServei tipus) {
    Servei hab = new Servei(cost, manteniment, area, nom, codi, h, capacitat, tipus);
    cjtEd.AfegirEdifici(hab);   
  }
  
  public void EliminarEdifici(String n) {
    cjtEd.EliminarEdifici(n);
  }
  
  public void EliminarEdifici(Edifici e) {
    cjtEd.EliminarEdifici(e);
  }
  
  public Edifici GetEdifici(String n) {
    return cjtEd.ObtenirEdifici(n);
  }
  public boolean ExisteixEdifici(String nom){
      cjtEd.ExisteixEdifici(nom);
  }
  public void GuardarEdifici(String n) {
    //crida controlador persistencia
  }
  
}
