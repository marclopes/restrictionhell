/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Habitatge.tipusHab;

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
  
  public void CreaHabitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, tipusHab Tipus) {
    Barri barri = new Barri(impost,aparcament,nom,codi,h,capacitat,t);
    cjtBarris.AfegirBarri(barri);
  }
  
}
