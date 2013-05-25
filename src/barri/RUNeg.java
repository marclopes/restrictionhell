/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class RUNeg extends RestriccioBarris implements RCjtEd {

    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private boolean max;

    public RUNeg(int id, String atribut, int valor, boolean max, CjtEdificis ce) {
        super(id);
        this.atribut = atribut;
        this.valor = valor;
        this.ce = ce;
        this.max = max;

    }

    @Override
    public String Info() {
        return "Restriccio Negoci " + atribut + " " + valor;
    }

    @Override
    public boolean CompleixRes() {
        for (int i = 0; i < ce.Tamany(); ++i) {
            if (ce.ObtenirEdifici(i) instanceof Negoci && max) {
                if (atribut.equals("altura")) {
                    if (ce.ObtenirEdifici(i).ConsultarH() > valor) {
                        return false;
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Negoci) ce.ObtenirEdifici(i)).ConsultarAparcament() > valor) {
                        return false;
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Negoci) ce.ObtenirEdifici(i)).ConsultarImpost() > valor) {
                        return false;
                    }
                }

            } else if (ce.ObtenirEdifici(i) instanceof Negoci) {
                if (atribut.equals("altura")) {
                    if (ce.ObtenirEdifici(i).ConsultarH() < valor) {
                        return false;
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Negoci) ce.ObtenirEdifici(i)).ConsultarAparcament() < valor) {
                        return false;
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Negoci) ce.ObtenirEdifici(i)).ConsultarImpost() < valor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void AssignaCe(CjtEdificis ce) {
        this.ce = ce;
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
}
