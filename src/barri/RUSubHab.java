/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Habitatge.TipusHab;
import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class RUSubHab extends RestriccioBarris {

    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private TipusHab tipus;
    private boolean max;

    public RUSubHab(int id, TipusHab tipus, String atribut, int valor, boolean max) {
        super(id);
        this.tipus = tipus;
        this.atribut = atribut;
        this.valor = valor;
        this.ce = ce;
        this.max = max;
    }

    @Override
    public String Info() {
        return "Restriccio subtipus Habitatge " + atribut + " " + valor;
    }

    //@Override
    public boolean CompleixRes(Edifici e) {
        for (int i = 0; i < ce.Tamany(); ++i) {
            if ((e instanceof Habitatge) && ((Habitatge) e).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")) {
                    if (e.ConsultarH() > valor) {
                        return false;
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Habitatge) e).ConsultarAparcament() > valor) {
                        return false;
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Habitatge) e).ConsultarImpost() > valor) {
                        return false;
                    }
                } else if (atribut.equals("capacitat")) {
                    if (((Habitatge) e).ConsultarCapacitat() > valor) {
                        return false;
                    }
                }

            } else if ((e instanceof Habitatge) && ((Habitatge) e).consultarTipus() == tipus) {
                if (atribut.equals("altura")) {
                    if (e.ConsultarH() > valor) {
                        return false;
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Habitatge) e).ConsultarAparcament() < valor) {
                        return false;
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Habitatge) e).ConsultarImpost() < valor) {
                        return false;
                    }
                } else if (atribut.equals("capacitat")) {
                    if (((Habitatge) e).ConsultarCapacitat() < valor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    
    public TipusHab ConsultaTipus(){
        return tipus;
    }
    
    public String ConsultaAtribut(){
        return atribut;
    }
    
    public int ConsultaValor(){
        return valor;
    }
    
    public boolean EsMax(){
        return max;
    }

    @Override
    public boolean CompleixRes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void AssignarMax(String max) {
        if (max.equals("Maxim"))this.max =true;
        else if(max.equals("Minim")) this.max = false;
    }
    
    public void AssignaValor(int valor){
        this.valor = valor;
    }

    @Override
    public boolean prop(ArrayList<Assignacions> va, Assignacio a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean afecta(Assignacio a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
