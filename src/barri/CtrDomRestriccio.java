package barri;

import java.util.ArrayList;

import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class CtrDomRestriccio {

    public enum Atribut {

        ALSADA,
        APARCAMENT,
        COST,
        DISTANCIA,
        //CODI1,
        //CODI2,
        //EDIFICI1,
        //EDIFICI2,
        IMPOSTOS,
        INFLUENCIA,
        QUANTITAT,
        MAXIM,
        MANTENIMENT,
        VALOR
        //ESPAI,
        //CJTEDIFICIS
    };
    private static CtrDomRestriccio ctrRestriccio = null;
    private CjtRestriccions lRest;

    /**
     * Crea una instancia del controlador de restriccions del domini
     */
    private CtrDomRestriccio() {
        lRest = new CjtRestriccions();
        //ctrRestriccio.CreaRestInfluencia();
    }

    /**
     * Obte la instancia del singleton
     * @return La instancia de CtrDomRestriccio
     */
    public static CtrDomRestriccio ObteInstancia() {
        if (ctrRestriccio == null) {
            ctrRestriccio = new CtrDomRestriccio();
        }
        return ctrRestriccio;
    }

    
    public int CreaRestriccioGlobal(int id, String atribut, int valor) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
        	lRest.AfegirRes(new RGlobal(id,atribut,valor));
           // lRest.add(new RAlsada(id, alsada, null));
            return 0;
        }
        return -1;
    }
    
    
    /**
     * Crea una restriccio de Distancia entre tipus
     * @param id la id de la rest
     * @param dist la distancia entre edificis
     * @param max true si la distancia es maxima
     * @param el1 el edifici1
     * @param el2 el edifici2
     * @return
     */
    public int CreaDistTipus(int id, int dist, boolean max, String el1, String el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RDistTipus(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }
   
    /**
     * crea una restriccio de quantitat
     * @param id la id de la rest
     * @param quantitat la quantitat a indicar
     * @param max true si maxim
     * @param e el edifici al qual s'aplica la restricci�
     * @param e el edifici al qual s'aplica la restriccio
     * @return 0 si ha anat be, -1 si no
     */
    public int CreaRestQuantitat(int id, int quantitat, boolean max, String e) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RQuantitat(id, quantitat, e));
            return 0;
        }
        return -1;
    }

    public int CreaRestriccioRUHab(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUHab(id,s,valor,max));
        }
        return -1;
    }
    public int CreaRestriccioRUNeg(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUNeg(id,s,valor,max));
        }
        return -1;
    }
    public int CreaRestriccioRUServ(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUServ(id,s,valor,max));
        }
        return -1;
    }
    public int CreaRestriccioRUSubHab(int id, TipusHab t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubHab(id,t,s,valor,max));
        }
        return -1;
    }
    public int CreaRestriccioRUSubNeg(int id, TipusNegoci t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubNeg(id,t,s,valor,max));
        }
        return -1;
    }
    public int CreaRestriccioRUSubServ(int id,TipusServei t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubServ(id,t,s,valor,max));
        }
        return -1;
    }
    
    /**
     * Tipus de restriccio
     * @param id id de la restriccio
     * @return TipusRest de la rest
     */
    public TipusRest ConstultarTipus(int id) { 
        return ((RestriccioBarris) lRest.ConsultarRes(id)).obteTipus();
        
    }
    
    

    /**
     * Modifica una restriccio
     * @param id id de la rest
     * @param atribut atribut  a modificat
     * @param valor valor que s'afegeix
     * @return
     */
    public int ModificarRestriccio(int id, Atribut atribut, String valor) {
        RestriccioBarris aux = ObtenirRest(id);
        int val = Integer.parseInt(valor);
        if (aux instanceof RGlobal) {
            ((RGlobal)aux).AssignaVal(val);
            return 0;
        }
        if (aux instanceof RUHab) {
            if (atribut == Atribut.MAXIM)
                ((RUHab)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUHab)aux).AssignaValor(val);
            return 0;
        }
        if (aux instanceof RUNeg) {
            if (atribut == Atribut.MAXIM)
                ((RUNeg)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUNeg)aux).AssignaValor(val);
            return 0;
        }
        if (aux instanceof RUServ) {
            if (atribut == Atribut.MAXIM)
                ((RUServ)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUServ)aux).AssignaValor(val);
            return 0;
        }
        if (aux instanceof RUSubHab) {
            if (atribut == Atribut.MAXIM)
                ((RUSubHab)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUSubHab)aux).AssignaValor(val);
            return 0;
        }
        if (aux instanceof RUSubNeg) {
            if (atribut == Atribut.MAXIM)
                ((RUSubNeg)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUSubNeg)aux).AssignaValor(val);
            return 0;
        }
        if (aux instanceof RUSubServ) {
            if (atribut == Atribut.MAXIM)
                ((RUSubServ)aux).AssignarMax(valor);
            if (atribut == Atribut.VALOR)
                ((RUSubServ)aux).AssignaValor(val);
            return 0;
        }
        return -1;
    }

   
    /**
     * Assigna un habitatge a la restricio
     * @param id id de la rest
     * @param nEd numero d'edifici (1r o 2n)
     * @param th tipus d'habitatge
     */
    /*public void AssignaHab(int id, int nEd, TipusHab th) {
    	Habitatge ed = new Habitatge(0, 0, "aux", 0, 0, 0, th);
    	AssignaEdPriv(id, nEd, ed);
    }*/
    
    /**
     * Assigna un negoci a la restriccio
     * @param id id de la rest
     * @param nEd numero d'edifici (1r o 2n)
     * @param tn tipus de negoci
     */
    /*public void AssignaNeg(int id, int nEd, TipusNegoci tn) {
    	Negoci ed = new Negoci(0, 0, "aux", 0, 0, 0, tn);
    	AssignaEdPriv(id, nEd, ed);
    }*/
    
    
    /**
     * Assigna un servei a la restriccio
     * @param id id de la rest
     * @param nEd numero d'edicifi
     * @param ts tipus de servei
     */
   /* public void AssignaSer(int id, int nEd, TipusServei ts) {
    	Servei ed = new Servei(0, 0, 0, "aux", 0, 0, 0, ts);
    	AssignaEdPriv(id, nEd, ed);
    }*/
    
    
    
    
    
    /**
     * Assigna Edifici
     * @param id id de la rest
     * @param nEd numero d'edifici
     * @param ed edifici a afegir el seu tipus
     */
    private void AssignaEdPriv(int id, int nEd, String ed) {
        RestriccioBarris aux = ObtenirRest(id);
        if (nEd == 2 && aux instanceof RDistTipus) {
            ((RDistTipus) aux).ModificarEd2(ed);

        } else if (nEd == 1) {
            if (aux instanceof RDistTipus) {
                ((RDistTipus) aux).ModificarEd1(ed);
            } else if (aux instanceof RQuantitat) {
                ((RQuantitat) aux).AssignaEdifici(ed);
            }
        }
    }

    /**
     * Assigna conjunt d'edificis
     * @param id id de la rest
     * @param ce conjunt a assignar
     */
    public void AssignaCjtEd(int id, CjtEdificis ce) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof RCjtEd) {
            ((RCjtEd) aux).AssignaCe(ce);
        }
    }

    
    
    /**
     * Assigna espai
     * @param id id de la rest
     * @param e l'espai a assignar
     */
    public void AssignaEspai(int id, Espai e) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof REspai) {
            ((REspai) aux).AssignaEspai(e);
        }
    }

    
    /**
     * Elimina una restriccio
     * @param id id de la rest
     * @return 0 si ha anat be, -1 si no;
     */
    public int EliminarRestriccio(int id) {
        if (lRest.ConsultarRes(id) == null) return -1;
        else {
        	lRest.BorrarResID(id);
        	return 0;
        }
    }

    
    /**
     * Obte la restriccio indicada
     * @param id id de la rest
     * @return La restriccio demanada
     */
    public RestriccioBarris ObtenirRest(int id) {
        return (RestriccioBarris)lRest.ConsultarRes(id);

    }

    
    /**
     * Indica si existeix la restriccio
     * @param id id de la rest
     * @return true si existeix la rest
     */
    public boolean ExisteixRestriccio(int id) {
        return (lRest.ConsultarRes(id) != null);

    }
    
    
    /**
     * Numero de restriccions del conjunt
     * @return un int indicant el numero de restricions
     */
    public int NRest() {
    	return lRest.ConsultarCjt().size();
    }
    
    
    /**
     * Info de la restriccio
     * @param id id de la rest
     * @return Una string amb tota la info de la rest
     */
    public String InfoRes(int id) {
    	return ((RestriccioBarris)lRest.ConsultarRes(id)).Info();
    }
    
    public ArrayList<String> ObteInfoRestriccionsConjunt(){
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<Restriccio> l = lRest.ConsultarCjt();
        for(int i = 0; i < l.size(); i++){
            s.add(((RestriccioBarris) l.get(i)).Info());
        }
        return s;
    }
    /**
     * public String toString(int id) { RestriccioBarris aux = obtRest(id);
     * String s = aux.obteTipus() + ": ";
     *
     * if (aux instanceof RMax) { if (((RMax)aux).esMax()) s = s + "Maxim ";
     * else s = s + "Minim";
     *
     * if (aux instanceof RDistCodi) { s = s + ((RDistCodi)aux).consultarDist()
     * + " entre " + ((RDistCodi)aux).consultarCodi1() + " i " +
     * ((RDistCodi)aux).consultarCodi2(); } else if (aux instanceof RDistTipus)
     * { s = s + ((RDistTipus)aux).consultarDist() + " entre " +
     * ((RDistTipus)aux).consultarEd1().ConsultarNom() + " i " +
     * ((RDistTipus)aux).consultarEd2().ConsultarNom(); } else if (aux
     * instanceof RQuantitat) { s = s + ((RQuantitat)aux).consultarQuant() + "de
     * " + ((RQuantitat)aux).quinEdifici().ConsultarNom(); } else { s = s; }
     *
     * return s;
     *
     *
     * }
     *
     * }*
     */
}
