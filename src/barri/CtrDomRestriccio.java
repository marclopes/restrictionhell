package barri;

import java.util.ArrayList;

import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class CtrDomRestriccio {

    public enum Atribut {

        ALSADA,
        COST,
        DISTANCIA,
        CODI1,
        CODI2,
        EDIFICI1,
        EDIFICI2,
        IMPOSTOS,
        INFLUENCIA,
        QUANTITAT,
        MAXIM,
        ESPAI,
        CJTEDIFICIS
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
     *
     * @return
     */
    public static CtrDomRestriccio ObteInstancia() {
        if (ctrRestriccio == null) {
            ctrRestriccio = new CtrDomRestriccio();
            ctrRestriccio.CreaRestInfluencia();
        }
        return ctrRestriccio;
    }

    public int CreaRestAlsada(int id, int alsada) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
        	lRest.AfegirRes(new RAlsada(id, alsada, null));
           // lRest.add(new RAlsada(id, alsada, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestCost(int id, int cost, boolean max) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RCost(id, cost, max, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestDistCodi(int id, int dist, boolean max, int el1, int el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RDistCodi(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }

    public int CreaDistTipus(int id, int dist, boolean max, Edifici el1, Edifici el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RDistTipus(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestImpostos(int id, int imp) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RImpostos(id, imp, null));
            return 0;
        }
        return -1;
    }

    private void CreaRestInfluencia() {
        lRest.AfegirRes(new RInfluencia(0, null));
    }

    public int CreaRestManteniment(int id, int costBarri) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RManteniment(id, costBarri, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestQuantitat(int id, int quantitat, boolean max, Edifici e) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RQuantitat(id, quantitat, e, max));
            return 0;
        }
        return -1;
    }

    public int CreaRestAparcaments(int id, int aparcaments) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.AfegirRes(new RAparcament(id, aparcaments, null));
            return 0;
        }
        return -1;
    }

    public TipusRest ConstultarTipus(int id) { 
        return ((RestriccioBarris) lRest.ConsultarRes(id)).obteTipus();
        
    }

    public int ModificarRestriccio(int id, Atribut atribut, String valor) {
        RestriccioBarris aux = ObtenirRest(id);
        int val = Integer.parseInt(valor);

        if (atribut == Atribut.ALSADA && aux.obteTipus() == TipusRest.ALSADA) {
            ((RAlsada) aux).ModificarAlsada(val);
            return 0;

        } else if (atribut == Atribut.COST && aux.obteTipus() == TipusRest.COST) {
            ((RCost) aux).ModificarCost(val);
            return 0;
        } else if (atribut == Atribut.DISTANCIA && (aux.obteTipus() == TipusRest.DISTCODI || aux.obteTipus() == TipusRest.DISTTIPUS)) {
            ((RDistancia) aux).ModificarDist(val);
            return 0;
        } else if (atribut == Atribut.IMPOSTOS && aux.obteTipus() == TipusRest.IMPOSTOS) {
            ((RImpostos) aux).ModificarImp(val);
            return 0;
        } else if (atribut == Atribut.QUANTITAT && aux.obteTipus() == TipusRest.QUANTITAT) {
            ((RQuantitat) aux).ModificarQuant(val);
            return 0;
        } else if (atribut == Atribut.CODI1 && aux.obteTipus() == TipusRest.DISTCODI) {
            //((RDistCodi) aux).ModificarCodi1(val);
            return 0;
        } else if (atribut == Atribut.CODI2 && aux.obteTipus() == TipusRest.DISTCODI) {
            //((RDistCodi) aux).ModificarCodi2(val);
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

   
    public void AssignaHab(int id, int nEd, TipusHab th) {
    	Habitatge ed = new Habitatge(0, 0, "aux", 0, 0, 0, th);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    public void AssignaNeg(int id, int nEd, TipusNegoci tn) {
    	Negoci ed = new Negoci(0, 0, "aux", 0, 0, 0, tn);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    public void AssignaSer(int id, int nEd, TipusServei ts) {
    	Servei ed = new Servei(0, 0, 0, "aux", 0, 0, 0, ts);
    	AssignaEdPriv(id, nEd, ed);
    }
    
    
    
    
    
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

    public void AssignaCjtEd(int id, CjtEdificis ce) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof RCjtEd) {
            ((RCjtEd) aux).AssignaCe(ce);
        }
    }

    public void AssignaEspai(int id, Espai e) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof REspai) {
            ((REspai) aux).AssignaEspai(e);
        }
    }

    public int EliminarRestriccio(int id) {
        if (lRest.ConsultarRes(id) == null) return -1;
        else {
        	lRest.BorrarResID(id);
        	return 0;
        }
    }

    public RestriccioBarris ObtenirRest(int id) {
        return (RestriccioBarris)lRest.ConsultarRes(id);

    }

    public boolean ExisteixRestriccio(int id) {
        return (lRest.ConsultarRes(id) != null);

    }
    
    
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
