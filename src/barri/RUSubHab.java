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
public class RUSubHab extends RestriccioBarris implements RCjtEd {

    private ArrayList< Pair<Edifici,Integer>> ce;
    private String atribut;
    private int valor;
    private TipusHab tipus;
    private boolean max;

    public RUSubHab(int id, TipusHab tipus, String atribut, int valor, boolean max, ArrayList< Pair<Edifici,Integer>> ce) {
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

    @Override
    public boolean CompleixRes() {
        for (int i = 0; i < ce.size(); ++i) {
            if ((ce.get(i).primer instanceof Habitatge) && ((Habitatge) ce.get(i).primer).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarAparcament() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarImpost() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("capacitat")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarCapacitat() > valor) {
                        ce.remove(i);
                    }
                }

            } else if ((ce.get(i).primer instanceof Habitatge) && ((Habitatge) ce.get(i).primer).consultarTipus() == tipus) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarAparcament() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarImpost() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("capacitat")) {
                    if (((Habitatge) ce.get(i).primer).ConsultarCapacitat() < valor) {
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
