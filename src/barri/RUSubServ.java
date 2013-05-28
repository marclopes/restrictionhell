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
public class RUSubServ extends RestriccioBarris{

    private String atribut;
    private int valor;
    private TipusServei tipus;
    private boolean max;

    public RUSubServ(int id, TipusServei tipus, String atribut, int valor, boolean max) {
        super(id);
        this.tipus = tipus;
        this.atribut = atribut;
        this.valor = valor;
        this.max = max;
    }

    @Override
    public String Info() {
        return "Restriccio subtipus Servei " + atribut + " " + valor;
    }

    public boolean CompleixRes(Edifici e) {

            if ((e instanceof Servei) && ((Servei) e).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")) {
                    if (e.ConsultarH() > valor) {
                        return false;
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) e).ConsultarAreaInfluencia() > valor) {
                        return false;
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) e).ConsultarCost() > valor) {
                        return false;
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) e).ConsultarManteniment() > valor) {
                        return false;
                    }
                }

            } else if ((e instanceof Servei) && ((Servei) e).consultarTipus() == tipus) {
                if (atribut.equals("altura")) {
                    if (e.ConsultarH() < valor) {
                        return false;
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) e).ConsultarAreaInfluencia() < valor) {
                        return false;
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) e).ConsultarCost() < valor) {
                        return false;
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) e).ConsultarManteniment() < valor) {
                        return false;
                    }
                }
            }
        return true;
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

    @Override
    public boolean CompleixRes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}