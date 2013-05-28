/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

/**
 *
 * @author albert
 */
public class RUHab  extends RestriccioBarris implements RCjtEd {
    private CjtEdificis ce;
    private String atribut;
    private int valor;
    private boolean max;
    
    public RUHab (int id,String atribut,int valor,boolean max,CjtEdificis ce) {
        super(id);
        this.atribut = atribut;
        this.valor = valor;
        this.ce=ce;
        this.max=max;
    }
    @Override
    public String Info() {
        return "Restriccio Habitatges " + atribut + " " + valor;
    }

    //@Override
    public boolean CompleixRes(Edifici e) {
            if (e instanceof Habitatge && max) {
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
                
            }
            else if (e instanceof Habitatge) {
                 if (atribut.equals("altura")){
                    if (e.ConsultarH() < valor) return false;
                } else if(atribut.equals("aparcament")){
                    if (( (Habitatge)e).ConsultarAparcament() < valor) return false;
                } else if (atribut.equals("impostos")) {
                     if (( (Habitatge)e).ConsultarImpost()< valor) return false;
                }
                else if (atribut.equals("capacitat")) {
                     if (( (Habitatge)e).ConsultarCapacitat()< valor) return false;
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
