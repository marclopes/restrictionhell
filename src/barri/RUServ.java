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
public class RUServ  extends RestriccioBarris implements RCjtEd {

    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private boolean max;
    
    public RUServ (int id,String atribut,int valor,boolean max,CjtEdificis ce) {
        super(id);
        this.atribut = atribut;
        this.valor = valor;
        this.ce=ce;
        this.max=max;
    }
    @Override
    public String Info() {
        return "Restriccio Servi " + atribut + " " + valor;
    }

//    @Override
    public boolean CompleixRes(Edifici e) {
            if (e instanceof Servei && max ) {
                if (atribut.equals("altura")){
                    if (e.ConsultarH() > valor) return false;
                } else if(atribut.equals("area")){
                    if (( (Servei)e).ConsultarAreaInfluencia()> valor) return false;
                } else if (atribut.equals("cost")) {
                     if (( (Servei)e).ConsultarCost()> valor) return false;
                }
                else if (atribut.equals("manteniment")) {
                     if (( (Servei)e).ConsultarManteniment()> valor) return false;
                }
                
            } else if(e instanceof Servei) {
                if (atribut.equals("altura")){
                    if (e.ConsultarH() < valor) return false;
                } else if(atribut.equals("area")){
                    if (( (Servei)e).ConsultarAreaInfluencia()< valor) return false;
                } else if (atribut.equals("cost")) {
                     if (( (Servei)e).ConsultarCost()< valor) return false;
                }
                else if (atribut.equals("manteniment")) {
                     if (( (Servei)e).ConsultarManteniment()< valor) return false;
                }
        }
        return true;
    }

    @Override
    public void AssignaCe(CjtEdificis ce) {
        this.ce=ce;
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
}


