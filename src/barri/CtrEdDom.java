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
    public void ModificarEdifici(String nomEdifici,String atribut ,String valor ){
	 Edifici tmpEdifici = cjtEd.ObtenirEdifici(nomEdifici);
	 if (atribut.equals("altura")){
	    tmpEdifici.ModificarH(Integer.parseInt(valor));
	 }
	 else if(atribut.equals("capacitat")){
	    tmpEdifici.ModificarCapacitat(Integer.parseInt(valor))
	 }
	 else if(atribut.equals("clase")){
	    
	 }
	 else {
	    if (tmpEdifici instanceof Habitage) {
		if(atribut.equals("impost")) {
		
		}
		else if(atribut.equals("aparcament")){
		
		}
	    }
	    else if (tmpEdifici instanceof Negoci) {
		if(atribut.equals("impost")) {
		
		}
		else if(atribut.equals("aparcament")){
		
		}
	    }
	    else if (tmpEdifici instanceof Servei) {
		if(atribut.equals("cost")){
		}
		else if(atribut.equals("manteniment"){
		}
		else if(atribut.equals("area influencia")){
		}
	    }
	 }
	 
	 
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
  private clase StringToClase(String c) {
      if(c.equals("Alta
  }
}
