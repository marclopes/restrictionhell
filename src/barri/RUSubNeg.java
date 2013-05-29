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
    private String atribut;
    private int valor;
    private TipusNegoci tipus;
    private boolean max;
    
    public RUSubNeg (int id,TipusNegoci tipus,String atribut,int valor,boolean max){
        super(id);
        this.tipus = tipus;
        this.atribut=atribut;
        this.valor = valor;
        this.max=max;
    }
    @Override
    public String Info() {
          return "Restriccio subtipus Negoci " + tipus.toString() + atribut + " " + valor;
    }

//    @Override
    public boolean CompleixRes(Edifici e) {
            if ((e instanceof Negoci) && ((Negoci)e).consultarTipus() == tipus && max) {
                if (atribut.equals("altura")){
                    if (e.ConsultarH() > valor) return false;
                } else if(atribut.equals("aparcament")){
                    if (( (Habitatge)e).ConsultarAparcament()> valor) return false;
                } else if (atribut.equals("impostos")) {
                     if (( (Habitatge)e).ConsultarImpost()> valor) return false;
                }
                else if (atribut.equals("capacitat")) {
                     if (( (Habitatge)e).ConsultarCapacitat()> valor) return false;
                }
                
            } else if ((e instanceof Negoci) && ((Negoci)e).consultarTipus() == tipus) {
                if (atribut.equals("altura")){
                    if (e.ConsultarH() < valor) return false;
                } else if(atribut.equals("aparcament")){
                    if (( (Habitatge)e).ConsultarAparcament()< valor) return false;
                } else if (atribut.equals("impostos")) {
                     if (( (Habitatge)e).ConsultarImpost()< valor) return false;
                }
                else if (atribut.equals("capacitat")) {
                     if (( (Habitatge)e).ConsultarCapacitat()< valor) return false;
                }
            }
        return true;
    }

    
    public TipusNegoci ConsultaTipus(){
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

    @Override
    public void AssignaCe(CjtEdificis ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
