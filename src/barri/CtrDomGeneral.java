package barri;

import barri.CtrDomRestriccio.Atribut;
import barri.Edifici.Classes;
import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;

public class CtrDomGeneral {

    private static CtrDomGeneral ctrDomini = null;
    private CtrBarriDom ctrBarri;
    private CtrEdDom ctrEdificis;
    private CtrDomRestriccio ctrRestric;
    
    private CtrDomGeneral() {
        ctrBarri = CtrBarriDom.GetInstancia();
        ctrEdificis = CtrEdDom.GetInstancia();
        ctrRestric = CtrDomRestriccio.GetInstancia();
    }

    public static CtrDomGeneral GetInstancia() {
        if (ctrDomini == null) {
            ctrDomini = new CtrDomGeneral();
        }
        return ctrDomini;
    }

    public void CreaBarri(String n, int po, int pr, int c, String cl, int a, int xx, int yy) {
        Classes tipClas;
        if (cl.equals("Alta")) {
            tipClas = Classes.Alta;
        } else if (cl.equals("Mitja")) {
            tipClas = Classes.Mitja;
        } else {
            tipClas = Classes.Baixa;
        }
        ctrBarri.CreaBarri(n, po, pr, c, tipClas, a, xx, yy);
    }

    public void CrearRestriccioAlsada(int alsada) { // esperar nova clase restriccio
        ctrRestric.creaRestAlsada(alsada, null);
    }

    public void CrearRestriccioCost(int cost, boolean max) {
        ctrRestric.creaRestCost(cost, max, null);
    }

    public void CrearRestriccioDistanciaCodi() {
    }

    public void CrearRestriccioDistanciaTipus(int dist, boolean max, String el1, String el2) {
        Edifici e1 = ctrEdificis.GetEdifici(el1);
        Edifici e2 = ctrEdificis.GetEdifici(el2);
        if (e1 != null && e2 != null) {
            ctrRestric.creaDistTipus(dist, max, e1, e2, null);
        }
    }

    public void CreaRestriccioArea() {
    }

    public void CreaRestriccioImpostos(int imp) {
        ctrRestric.creaRestImpostos(imp, null);
    }

    public void CreaRestriccioManteniment(int cost) {
        ctrRestric.creaRestManteniment(cost, null);
    }

    public void CreaRestriccioQuantitat(int quantitat, boolean max, String edifici) {
        Edifici e = ctrEdificis.GetEdifici(edifici);
        if (e != null) {
            ctrRestric.creaQuantitat(quantitat, max, e);
        }
    }

    public void CreaHabitatge(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error
        tipusHab k = StringHabtoEnum(tipus);
        ctrEdificis.CreaHabitatge(impost, aparcament, nom, 0, h, capacitat, k);

    }

    public void CreaNegoci(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error;
        tipusNegoci k = StringNegtoEnum(tipus);
        ctrEdificis.CreaNegoci(impost, aparcament, nom, 0, h, capacitat, k);
    }

    public void CreaServei(int cost, int manteniment, int area, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error;
        tipusServei k = StringSertoEnum(tipus);
        ctrEdificis.CreaServei(cost, manteniment, area, nom, 0, h, capacitat, k);
    }

    public void ModificarBarri(String nomBarri, String atribut, String valor) {
        Barri aux = ctrBarri.GetBarri(nomBarri);
        if (atribut.equals("Nom")) {
            aux.modificarNom(valor);
        } else if (atribut.equals("Pressupost")) {
            aux.modificarPressupost(Integer.parseInt(valor));
        } else if (atribut.equals("Poblacio")) {
            aux.modificarPoblacio(Integer.parseInt(valor));
        } else if (atribut.equals("Classe")) {
            aux.modificarClasse(StringToClase(valor));
        } else if (atribut.equals("Aparcament")) {
            aux.modificarAparcament(Integer.parseInt(valor));
        } else if (atribut.equals("MidaX")) {
            aux.modificarX(Integer.parseInt(valor));
        } else if (atribut.equals("MidaY")) {
            aux.modificarY(Integer.parseInt(valor));
        }
    }

    public void ModificarEdifici(String nomEdifici, String atribut, String valor) {
        ctrEdificis.ModificarEdifici(nomEdifici, atribut, valor);
    }

    public void ModificarRestriccio(int idRest, String atribut, String valor) {
        ctrRestric.ModificarRestriccio(idRest, StringToAtribut(atribut), valor);
    }

    public void EliminarEdifici(String nomEdifici) {
        if (ctrEdificis.GetEdifici(nomEdifici) == null);//error
        else {
            ctrEdificis.EliminarEdifici(nomEdifici);
        }
    }

    public void EliminarBarri(String nomBarri) {
        ctrBarri.EliminarBarri(nomBarri);
    }

    public void EliminarRestriccio(int id) {
        ctrRestric.EliminarRestriccio(id);
    }

    public void CarregarCatalegEdifici(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
        
    }

    public void CarregarCatalegRestriccio(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
    }

    public void CarregarBarri(String nomBarri) { //binari barri.
    }

    public void AfegirEdifici(String nomBarri, String nomEdifici) {//al barri FALTA FER UNA COPIA DEL EDIFICI
        Edifici e = ctrEdificis.GetEdifici(nomEdifici);//faig una copia
        //Barri b = ctrBarri.GetBarri(nomBarri);
        ctrBarri.AfegirEdifici(e, nomBarri);

    }

    public void ImposarRestriccio(String nomBarri, int idRestriccio) {
        RestriccioBarris r = ctrRestric.obtRest(idRestriccio);//crida al ctrRestric
        ctrBarri.AfegeixRestriccions(nomBarri, r);

    }

    public void TreuEdifici(String nomBarri, String nomEdifici) {
        ctrBarri.TreureEdifici(nomBarri, nomEdifici);
    }

    public void TreuRestriccio(String nomBarri, int idRestriccio) {
        ctrBarri.TreureRestriccio(nomBarri, idRestriccio);
    }

    public void GeneraBarri(String nomBarri) {//crida a backtraking
    }

    private tipusHab StringHabtoEnum(String n) {
        if (n.equals("Casa")) {
            return tipusHab.Casa;
        } else if (n.equals("Pis")) {
            return tipusHab.Pis;
        } else if (n.equals("Mansio")) {
            return tipusHab.Mansio;
        } else if (n.equals("Xalet")) {
            return tipusHab.Xalet;
        }
        return null;
    }

    private tipusServei StringSertoEnum(String n) {
        if (n.equals("Hospital")) {
            return tipusServei.Hospital;
        } else if (n.equals("Escola")) {
            return tipusServei.Escola;
        } else if (n.equals("Policia")) {
            return tipusServei.Policia;
        } else if (n.equals("Preso")) {
            return tipusServei.Preso;
        } else if (n.equals("Bombers")) {
            return tipusServei.Bombers;
        } else if (n.equals("Parc")) {
            return tipusServei.Parc;
        } else if (n.equals("Centre Cultural")) {
            return tipusServei.Centre_Cultural;
        }
        return null;
    }

    private tipusNegoci StringNegtoEnum(String n) {
        if (n.equals("Discoteca")) {
            return tipusNegoci.Discoteca;
        } else if (n.equals("Banc")) {
            return tipusNegoci.Banc;
        } else if (n.equals("Bar")) {
            return tipusNegoci.Bar;
        } else if (n.equals("Restaurant")) {
            return tipusNegoci.Restaurant;
        } else if (n.equals("Botiga alimentacio")) {
            return tipusNegoci.Botiga_alimentacio;
        } else if (n.equals("Botiga roba")) {
            return tipusNegoci.Botiga_roba;
        } else if (n.equals("Escola privada")) {
            return tipusNegoci.Escola_privada;
        } else if (n.equals("Clinica")) {
            return tipusNegoci.Clinica;
        }
        return null;
    }

    private Classes StringToClase(String c) {
        if (c.equals("Alta")) {
            return Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Classes.Mitja;
        } else {
            return Classes.Baixa;
        }
    }

    private Atribut StringToAtribut(String c) {
        if (c.equals("Alçada")); else if (c.equals("Cost")) {
            return Atribut.COST;
        } else if (c.equals("Distancia")) {
            return Atribut.DISTANCIA;
        } else if (c.equals("Codi1")) {
            return Atribut.CODI1;
        } else if (c.equals("Codi2")) {
            return Atribut.CODI2;
        } else if (c.equals("Edifici1")) {
            return Atribut.EDIFICI1;
        } else if (c.equals("Edifici2")) {
            return Atribut.EDIFICI2;
        } else if (c.equals("Impostos")) {
            return Atribut.IMPOSTOS;
        } else if (c.equals("Influencia")) {
            return Atribut.INFLUENCIA;
        } else if (c.equals("Quantitat")) {
            return Atribut.QUANTITAT;
        } else if (c.equals("Maxim")) {
            return Atribut.MAXIM;
        } else if (c.equals("Espai")) {
            return Atribut.ESPAI;
        } else if (c.equals("Cjt Edificis")) {
            return Atribut.CJTEDIFICIS;
        }
        return null;
    }
}
