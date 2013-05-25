/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Negoci.TipusNegoci;
import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class RUSubNeg extends RestriccioBarris implements RCjtEd{
    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private TipusNegoci tipus;
    private boolean max;
    
    public RUSubNeg (int id,TipusNegoci tipus,String atribut,int valor,boolean max,CjtEdificis ce){
        super(id);
        this.tipus = tipus;
        this.atribut=atribut;
        this.valor = valor;
        this.ce=ce;
        this.max=max;
    }
    @Override
    public String Info() {
          return "Restriccio subtipus Negoci " + atribut + " " + valor;
    }

    @Override
    public boolean CompleixRes() {
        for (int i =0 ; i< ce.Tamany() ; ++i ) {
            if ((ce.ObtenirEdifici(i) instanceof Negoci) && ((Negoci)ce.ObtenirEdifici(i)).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")){
                    if (ce.ObtenirEdifici(i).ConsultarH() > valor) return false;
                } else if(atribut.equals("aparcament")){
                    if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarAparcament()> valor) return false;
                } else if (atribut.equals("impostos")) {
                     if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarImpost()> valor) return false;
                }
                else if (atribut.equals("capacitat")) {
                     if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarCapacitat()> valor) return false;
                }
                
            } else if ((ce.ObtenirEdifici(i) instanceof Negoci) && ((Negoci)ce.ObtenirEdifici(i)).consultarTipus() == tipus) {
                if (atribut.equals("altura")){
                    if (ce.ObtenirEdifici(i).ConsultarH() < valor) return false;
                } else if(atribut.equals("aparcament")){
                    if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarAparcament()< valor) return false;
                } else if (atribut.equals("impostos")) {
                     if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarImpost()< valor) return false;
                }
                else if (atribut.equals("capacitat")) {
                     if (( (Habitatge)ce.ObtenirEdifici(i)).ConsultarCapacitat()< valor) return false;
                }
            }
        }
        return true;
    }

    @Override
    public void AssignaCe(CjtEdificis ce) {
        this.ce = ce;
    }
    
}
