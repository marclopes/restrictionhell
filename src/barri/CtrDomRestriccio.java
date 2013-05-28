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
        MANTENIMENT
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
    }

    /**
     * Obte la instancia del singleton
     * @return La instancia de CtrDomRestriccio
     */
    public static CtrDomRestriccio ObteInstancia() {
        if (ctrRestriccio == null) {
            ctrRestriccio = new CtrDomRestriccio();
            ctrRestriccio.CreaRestInfluencia();
        }
        return ctrRestriccio;
    }

    /**
     * Crea una Restriccio d'alsada
     * @param id La id de la rest
     * @param alsada La alsada de la rest
     * @return torna 0 si ha anar be i 1 si no
     */
    public int CreaRestAlsada(int id, int alsada) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
        	lRest.AfegirRes(new RAlsada(id, alsada, null));
           // lRest.add(new RAlsada(id, alsada, null));
            return 0;
        }
        return -1;
    }
    
    /**
     * Crea una Restriccio de cost
     * @param id La id de la rest
     * @param cost El cost de la rest
     * @return torna 0 si ha anat be i 1 si no
     */
    public int CreaRestCost(int id, int cost, boolean max) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RCost(id, cost, max, null));
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
    public int CreaDistTipus(int id, int dist, boolean max, Edifici el1, Edifici el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RDistTipus(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }

    
    /**
     * Crea restriccio de impostos
     * @param id la id de la rest
     * @param imp la quantitat d'impostos
     * @return 0 si tot ha anat be, -1 si no
     */
    public int CreaRestImpostos(int id, int imp) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RImpostos(id, imp, null));
            return 0;
        }
        return -1;
    }

    /**
     * Crea una Restriccio de influencia
     */
    private void CreaRestInfluencia() {
        lRest.AfegirRes(new RInfluencia(0, null));
    }

    
    
    /**
     * crea una restriccio de manteniment
     * @param id la id de la rest
     * @param costBarri el cost del barri
     * @return 0 si ha anat be, -1 si no
     */
    public int CreaRestManteniment(int id, int costBarri) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RManteniment(id, costBarri, null));
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
    public int CreaRestQuantitat(int id, int quantitat, boolean max, Edifici e) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RQuantitat(id, quantitat, e, max));
            return 0;
        }
        return -1;
    }

    
    
    /**
     * crea una restriccio d' aparcaments
     * @param id la id de la rest
     * @param aparcaments numero d'aparcaments
     * @return
     */
    public int CreaRestAparcaments(int id, int aparcaments) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RAparcament(id, aparcaments, null));
            return 0;
        }
        return -1;
    }

       
    public int CreaRestriccioRUHab(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUHab(id,s,valor,max,null));
        }
        return -1;
    }
    public int CreaRestriccioRUNeg(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUNeg(id,s,valor,max,null));
        }
        return -1;
    }
    public int CreaRestriccioRUServ(int id, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUServ(id,s,valor,max,null));
        }
        return -1;
    }
    public int CreaRestriccioRUSubHab(int id, TipusHab t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubHab(id,t,s,valor,max,null));
        }
        return -1;
    }
    public int CreaRestriccioRUSubNeg(int id, TipusNegoci t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubNeg(id,t,s,valor,max,null));
        }
        return -1;
    }
    public int CreaRestriccioRUSubServ(int id,TipusServei t, String s, int valor, boolean max){
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RUSubServ(id,t,s,valor,max,null));
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

        if (atribut == Atribut.ALSADA && aux.obteTipus() == TipusRest.ALSADA) {
            ((RAlsada) aux).ModificarAlsada(val);
            return 0;

        } else if (atribut == Atribut.COST && aux.obteTipus() == TipusRest.COST) {
            ((RCost) aux).ModificarCost(val);
            return 0;

        } else if (atribut == Atribut.IMPOSTOS && aux.obteTipus() == TipusRest.IMPOSTOS) {
            ((RImpostos) aux).ModificarImp(val);
            return 0;
        } else if (atribut == Atribut.QUANTITAT && aux.obteTipus() == TipusRest.QUANTITAT) {
            ((RQuantitat) aux).ModificarQuant(val);
            return 0;

            /**
             * } else if (atribut == Atribut.ESPAI && aux instanceof REspai) {
             *
             */
        } else if (atribut == Atribut.MAXIM && aux instanceof RMax) {
            if (val != 0) {
                ((RMax) aux).CanviaMax(true);
            } else {
                ((RMax) aux).CanviaMax(false);
            }
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
    public void AssignaHab(int id, int nEd, TipusHab th) {
    	Habitatge ed = new Habitatge(0, 0, "aux", 0, 0, 0, th);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    /**
     * Assigna un negoci a la restriccio
     * @param id id de la rest
     * @param nEd numero d'edifici (1r o 2n)
     * @param tn tipus de negoci
     */
    public void AssignaNeg(int id, int nEd, TipusNegoci tn) {
    	Negoci ed = new Negoci(0, 0, "aux", 0, 0, 0, tn);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    
    /**
     * Assigna un servei a la restriccio
     * @param id id de la rest
     * @param nEd numero d'edicifi
     * @param ts tipus de servei
     */
    public void AssignaSer(int id, int nEd, TipusServei ts) {
    	Servei ed = new Servei(0, 0, 0, "aux", 0, 0, 0, ts);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    
    
    
    
    /**
     * Assigna Edifici
     * @param id id de la rest
     * @param nEd numero d'edifici
     * @param ed edifici a afegir el seu tipus
     */
    private void AssignaEdPriv(int id, int nEd, Edifici ed) {
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
