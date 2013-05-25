/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Servei.TipusServei;
import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class RUSubServ extends RestriccioBarris implements RCjtEd {

    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private TipusServei tipus;
    private boolean max;

    public RUSubServ(int id, TipusServei tipus, String atribut, int valor, boolean max, CjtEdificis ce) {
        super(id);
        this.tipus = tipus;
        this.atribut = atribut;
        this.valor = valor;
        this.ce = ce;
        this.max = max;
    }

    @Override
    public String Info() {
        return "Restriccio subtipus Servei " + atribut + " " + valor;
    }

    @Override
    public boolean CompleixRes() {
        for (int i = 0; i < ce.Tamany(); ++i) {
            if ((ce.ObtenirEdifici(i) instanceof Servei) && ((Servei) ce.ObtenirEdifici(i)).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")) {
                    if (ce.ObtenirEdifici(i).ConsultarH() > valor) {
                        return false;
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarAreaInfluencia() > valor) {
                        return false;
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarCost() > valor) {
                        return false;
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarManteniment() > valor) {
                        return false;
                    }
                }

            } else if ((ce.ObtenirEdifici(i) instanceof Servei) && ((Servei) ce.ObtenirEdifici(i)).consultarTipus() == tipus) {
                if (atribut.equals("altura")) {
                    if (ce.ObtenirEdifici(i).ConsultarH() < valor) {
                        return false;
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarAreaInfluencia() < valor) {
                        return false;
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarCost() < valor) {
                        return false;
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) ce.ObtenirEdifici(i)).ConsultarManteniment() < valor) {
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
    
    public TipusServei ConsultaTipus(){
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
}