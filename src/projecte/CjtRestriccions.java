/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.List;


/**
 *
 * @author alex
 */
public class CjtRestriccions {
    
    //Atributs
    List<Restriccio> cjtRes;
    
    //Constructora
    public CjtRestriccions(){
    }
    
    //Metodes
    
    /**
    * S'afegeix la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem afegir
    */
    public void AfegirRes(Restriccio R){
        cjtRes.add(R);
    }
    
    /**
    * S'esborra la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem eliminar
    */
    public void BorrarRes(Restriccio R){
        cjtRes.remove(R);
    }
    
    /**
    * Es comprova si totes les restriccions especificades per a l'habitació es compleixen.
    */
    public boolean ComprovarRes(){
        for(Restriccio R: cjtRes){
            R.CompleixRes();
            if(!R.Compleix()) return false;
        }
        return true;
    }
}
