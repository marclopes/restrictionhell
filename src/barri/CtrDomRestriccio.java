package barri;

import java.util.ArrayList;

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
    private ArrayList<RestriccioBarris> lRest;

    /**
     * Crea una instancia del controlador de restriccions del domini
     */
    private CtrDomRestriccio() {
        lRest = new ArrayList<RestriccioBarris>();
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
            lRest.add(new RAlsada(id, alsada, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestCost(int id, int cost, boolean max) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RCost(id, cost, max, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestDistCodi(int id, int dist, boolean max, int el1, int el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RDistCodi(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }

    public int CreaDistTipus(int id, int dist, boolean max, Edifici el1, Edifici el2) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RDistTipus(id, dist, max, el1, el2, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestImpostos(int id, int imp) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RImpostos(id, imp, null));
            return 0;
        }
        return -1;
    }

    private void CreaRestInfluencia() {
        lRest.add(new RInfluencia(0, null));
    }

    public int CreaRestManteniment(int id, int costBarri) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RManteniment(id, costBarri, null));
            return 0;
        }
        return -1;
    }

    public int CreaRestQuantitat(int id, int quantitat, boolean max, Edifici e) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RQuantitat(id, quantitat, e, max));
            return 0;
        }
        return -1;
    }

    public int CreaRestAparcaments(int id, int aparcaments) {
        if (!ctrRestriccio.ExisteixRestriccio(id)) {
            lRest.add(new RAparcament(id, aparcaments, null));
            return 0;
        }
        return -1;
    }

    public TipusRest ConstultarTipus(int id) {
        for (int i = 0; i < lRest.size(); ++i) {
            if (lRest.get(i).ObtenirId() == id) {
                return lRest.get(i).obteTipus();
            }
        }
        return null;
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

    public void assignaEd(int id, int nEd, Edifici ed) {
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

    public void assignaCjtEd(int id, CjtEdificis ce) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof RCjtEd) {
            ((RCjtEd) aux).AssignaCe(ce);
        }
    }

    public void assignaEspai(int id, Espai e) {
        RestriccioBarris aux = ObtenirRest(id);
        if (aux instanceof REspai) {
            ((REspai) aux).AssignaEspai(e);
        }
    }

    public int EliminarRestriccio(int id) {
        for (int i = 0; i < lRest.size(); ++i) {
            if (lRest.get(i).ObtenirId() == id) {
                lRest.remove(i);
                return 0;
            }
        }
        return -1;
    }

    public RestriccioBarris ObtenirRest(int id) {
        for (int i = 0; i < lRest.size(); ++i) {
            if (lRest.get(i).ObtenirId() == id) {
                return lRest.get(i);
            }

        }
        return null;

    }

    public boolean ExisteixRestriccio(int id) {
        for (int i = 0; i < lRest.size(); ++i) {
            if (lRest.get(i).ObtenirId() == id) {
                return true;
            }
        }
        return false;

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
