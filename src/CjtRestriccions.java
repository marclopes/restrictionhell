/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author alejandro.martinez.romero
 */
public class CjtRestriccions {
    
    //Atributs
    private ArrayList<Restriccio> cjtRes;
    
    //Constructora
    
    /**
     * Crea una instancia de la classe CjtRestriccions
     */
    public CjtRestriccions(){
        cjtRes = new ArrayList<Restriccio>();
    }
    
    //Metodes
    
    public ArrayList<Restriccio> ConsultarCjt(){
        return cjtRes;
    }
    
    /**
    * S'afegeix la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem afegir
    */
    public void AfegirRes(Restriccio R){
        cjtRes.add(R);
    }
    
    /**
     * Consultem una restriccio del conjunt de restriccions mitjançant el seu identificador.
     * @param id es l'identificador de la restriccio que volem consultar
     * @return Es retorna la restriccio amb identificador id
     */
    public Restriccio ConsultarRes(int id){
        for(Restriccio R: cjtRes) {
            if(R.ObtenirId() == id) return R;
        }
        return null;
    }
    
    /**
    * S'esborra la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem eliminar
    */
    public void BorrarRes(Restriccio R){
            cjtRes.remove(R);
    }
    
    /**
    * S'esborra la restricció R amb identificador id del conjunt de restriccions.
    * @param id es l'indentifiacador de la restriccio que volem eliminar
    */
    public void BorrarResID(int id){
        for(Restriccio R: cjtRes) {
            if(R.ObtenirId() == id){
                cjtRes.remove(R);
                break;
            }
        }
    }
    
    
    /**
     * Es treu la llista amb la informació de cada restriccio
     */
    public void LlistarRes(){
        for(Restriccio R: cjtRes){
            R.InfoRes();
        }
    }
    
    /**
    * Es comprova si totes les restriccions especificades per a l'habitació es compleixen.
    */
    public boolean ComprovarRes(){
        try{
            for(Restriccio R: cjtRes){
                if(!R.CompleixRes()) return false;
            }
            return true;
        }
        catch(NullPointerException ex){
            ex.getMessage();
        }
        return false;
    }
}
