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

    private ArrayList< Pair<Edifici,Integer>> ce;
    private String atribut;
    private int valor;
    private boolean max;

    public RUNeg(int id, String atribut, int valor, boolean max, ArrayList< Pair<Edifici,Integer>> ce) {
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
        for (int i = 0; i < ce.size(); ++i) {
            if (ce.get(i).primer instanceof Negoci && max) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Negoci) ce.get(i).primer).ConsultarAparcament() > valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Negoci) ce.get(i).primer).ConsultarImpost() > valor) {
                        ce.remove(i);
                    }
                }

            } else if (ce.get(i).primer instanceof Negoci) {
                if (atribut.equals("altura")) {
                    if (ce.get(i).primer.ConsultarH() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("aparcament")) {
                    if (((Negoci) ce.get(i).primer).ConsultarAparcament() < valor) {
                        ce.remove(i);
                    }
                } else if (atribut.equals("impostos")) {
                    if (((Negoci) ce.get(i).primer).ConsultarImpost() < valor) {
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
