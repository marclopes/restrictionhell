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

    private ArrayList< Pair<Edifici,Integer>> ce;
    private String atribut;
    private int valor;
    private TipusServei tipus;
    private boolean max;

    public RUSubServ(int id, TipusServei tipus, String atribut, int valor, boolean max, ArrayList< Pair<Edifici,Integer>> ce) {
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
        for (int i = 0; i < ce.size(); ++i) {
            if ((ce.get(i).primer instanceof Servei) && ((Servei) ce.get(i).primer).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) ce.get(i).primer).ConsultarAreaInfluencia() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) ce.get(i).primer).ConsultarCost() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) ce.get(i).primer).ConsultarManteniment() > valor) {
                        ce.remove(i);
                    }
                }

            } else if ((ce.get(i).primer instanceof Servei) && ((Servei) ce.get(i).primer).consultarTipus() == tipus) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("area")) {
                    if (((Servei) ce.get(i).primer).ConsultarAreaInfluencia() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("cost")) {
                    if (((Servei) ce.get(i).primer).ConsultarCost() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("manteniment")) {
                    if (((Servei) ce.get(i).primer).ConsultarManteniment() < valor) {
                        ce.remove(i);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void AssignaCe(ArrayList<Pair<Edifici,Integer>> ce) {
        this.ce = ce;
    }
}
