package barri;

public class RManteniment extends RestriccioBarris implements REspai {

    int costBarri;
    Espai e;
    int ia, im;
    RImpostos rint;

    public RManteniment(int ID, int cb, Espai e) {
        super(ID);
        costBarri = cb;
        this.e = e;
        super.tr = TipusRest.MANTENIMENT;
        rint = new RImpostos(super.ObtenirId()/*id*/, costBarri, e);

    }

    public boolean CompleixRes() {
        return rint.CompleixRes();

    }

    public int consultarCostBarri() {
        return costBarri;
    }

    public void modificarCostBArri(int cb) {
        costBarri = cb;
    }

    @Override
    public void assignaEspai(Espai e) {
        this.e = e;
        rint.assignaEspai(e);
    }

    public void assignaImpAct(int i) {
        ia = i;
        rint.assignaImpAct(ia);
    }
}
