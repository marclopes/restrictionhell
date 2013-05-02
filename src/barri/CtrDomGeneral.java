package barri;

/**
 * @autor albert
 */
import barri.CtrDomRestriccio.Atribut;
import barri.Edifici.Classes;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;
import java.util.ArrayList;

public class CtrDomGeneral {

    private static CtrDomGeneral ctrDomini = null;
    private CtrBarriDom ctrBarri;
    private CtrEdDom ctrEdificis;
    private CtrDomRestriccio ctrRestric;

    /**
     * Crea una instancia del Controlador general de domini
     */
    private CtrDomGeneral() {
        ctrBarri = CtrBarriDom.ObteInstancia();
        ctrEdificis = CtrEdDom.ObteInstancia();
        ctrRestric = CtrDomRestriccio.ObteInstancia();
    }

    /**
     * Retorna la instancia del controlador general de domini i si no existeix
     * la crea
     *
     * @return CtrDomGeneral instancia del controlador general de domini
     */
    public static CtrDomGeneral ObtenirInstancia() {
        if (ctrDomini == null) {
            ctrDomini = new CtrDomGeneral();
        }
        return ctrDomini;
    }

    /**
     * Crea un barri amb els parametres donats
     *
     * @param n Nom del barri
     * @param po Poblacio minima del barri
     * @param pr Presopost maxim del barri
     * @param c Cost de manteniment maxim
     * @param cl Classe social del barri
     * @param a Aparcaments minims del barri
     * @param xx Dimensio X del barri
     * @param yy Dimensio Y del barri
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaBarri(String n, String cl, int xx, int yy) {
        Classes tipClas;
        tipClas = StringToClase(cl);
        return ctrBarri.CreaBarri(n, tipClas, xx, yy);

    }

    /**
     * Crea una restriccio de tipus alçada
     *
     * @param alsada Es l'alçada maxima que defineix la restriccio
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CrearRestriccioAlsada(int id, int alsada) { // esperar nova clase restriccio
        return ctrRestric.CreaRestAlsada(id, alsada);
    }

    /**
     * Crea una restriccio de tipus cost
     *
     * @param cost Es el cost maxim/minim del barri
     * @param max Indica si el cost es maxim o el cost es minim
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CrearRestriccioCost(int id, int cost, boolean max) {
        return ctrRestric.CreaRestCost(id, cost, max);
    }

    /* public void CrearRestriccioDistanciaCodi() {
     }*/
    /**
     * Crea una restriccio de distancia sobre 2 tipus d'edificis
     *
     * @param dist Distancia maxima/minima entre els tipus d'edifici
     * @param max Indica si la distancia es maxima o minima
     * @param el1
     * @param el2
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CrearRestriccioDistanciaTipus(int id, int dist, boolean max, String el1, String el2) {
        Edifici e1 = ctrEdificis.ObtenirEdifici(el1);
        Edifici e2 = ctrEdificis.ObtenirEdifici(el2);
        if (e1 != null && e2 != null) {
            return ctrRestric.CreaDistTipus(id, dist, max, e1, e2);
        }
        return -1;
    }

    /**
     * Crea una restriccio d'impostos
     *
     * @param imp Impostos minims que cal recaptar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaRestriccioImpostos(int id, int imp) {
        return ctrRestric.CreaRestImpostos(id, imp);
    }

    /**
     * Crea una restriccio sobre el cost de manteniment
     * @
     * @param cost Qost maxim de manteniment de serveis publics
     */
    public int CreaRestriccioManteniment(int id, int cost) {
        return ctrRestric.CreaRestManteniment(id, cost);
    }

    /**
     * Crea una restriccio de quantitat maxima/minima sobre un edifici
     * @param id Identificador de la restriccio
     * @param quantitat Quantitat maxima/minima d'edificis
     * @param max Indica si es maxim o minim d'edificis
     * @param edifici Edifici sobre el que s'aplica la restriccio
     * @return Retorna un codi d'error (0 si s'ha fet be, -1 si s'ha fet
     * malament)
     */
    public int CreaRestriccioQuantitat(int id, int quantitat, boolean max, String edifici) {
        Edifici e = ctrEdificis.ObtenirEdifici(edifici);
        if (e != null) {
            return ctrRestric.CreaRestQuantitat(id, quantitat, max, e);

        }
        return -1;
    }

    /**
     * Crea una restriccio de quantitat minim d'aparcaments
     * @param id Identificador de la restriccio
     * @param aparcaments nombre minim d'aparcaments
     * @@return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaRestriccioAparcament(int id, int aparcaments) {

        return ctrRestric.CreaRestAparcaments(id, aparcaments);

    }

    /**
     * Crea un habitatge amb les dades donades
     *
     * @param impost impostos generats per l'habitatge
     * @param aparcament aparcament disponible del habitatge
     * @param nom nom del habitatge
     * @param h altura del habitatge
     * @param capacitat capacitat del habitatge
     * @param tipus tipus d'habitatge
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaHabitatge(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        TipusHab k = StringHabtoEnum(tipus);
        return ctrEdificis.CreaHabitatge(impost, aparcament, nom, 0, h, capacitat, k);

    }

    /**
     * Crea un negoci amb les dades donades
     *
     * @param impost impostos generats per el negoci
     * @param aparcament aparcament disponible del negoci
     * @param nom nom del negoci
     * @param h altura del negoci
     * @param capacitat capacitat del negoci
     * @param tipus tipus de negoci
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaNegoci(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        TipusNegoci k = StringNegtoEnum(tipus);
        return ctrEdificis.CreaNegoci(impost, aparcament, nom, 0, h, capacitat, k);
    }

    /**
     * Crea un servei amb les dades donades
     *
     * @param cost cost de construccio del servei
     * @param manteniment cost de manteniment del servei
     * @param area area d'influencia del servei
     * @param nom nom del servei
     * @param h altura del edifici
     * @param capacitat capacitat del servei
     * @param tipus tipus de servei
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CreaServei(int cost, int manteniment, int area, String nom, int h, int capacitat, String tipus) {
        TipusServei k = StringSertoEnum(tipus);
        return ctrEdificis.CreaServei(cost, manteniment, area, nom, 0, h, capacitat, k);
    }

    /**
     * Modifica el atribut del barri donat amb el valor donat
     *
     * @param nomBarri nom del barri a modificar
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ModificarBarri(String nomBarri, String atribut, String valor) {
        return ctrBarri.ModificarBarri(nomBarri, atribut, valor);
    }

    /**
     * Modifica l'atribut del edifici donat amb el valor donat
     *
     * @param nomEdifici nom del edifici a modificar
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ModificarEdifici(String nomEdifici, String atribut, String valor) {
        return ctrEdificis.ModificarEdifici(nomEdifici, atribut, valor);
    }

    /**
     * Modifica l'atribut de la restriccio donada amb el valor donat
     *
     * @param idRest identificador de la restriccio
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ModificarRestriccio(int idRest, String atribut, String valor) {
        return ctrRestric.ModificarRestriccio(idRest, StringToAtribut(atribut), valor);
    }

    /**
     * Elimina l'edifici donat
     *
     * @param nomEdifici nom de l'edifici a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int EliminarEdifici(String nomEdifici) {
        int r= ctrEdificis.EliminarEdifici(nomEdifici);
        if (r==0) ctrBarri.NetejarEdificis(nomEdifici);
        return r;
    }

    /**
     * Elimina el barri donat
     *
     * @param nomBarri nom del barri a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int EliminarBarri(String nomBarri) {
        return ctrBarri.EliminarBarri(nomBarri);
    }

    /**
     * Elimina la restriccio donada
     *
     * @param id Identificador de la restriccio a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int EliminarRestriccio(int id) {
        
        int r = ctrRestric.EliminarRestriccio(id);
        if (r==0) ctrBarri.NetejarRestriccions(id);
        return r;

    }

    /**
     * Crea edificis a partir d'un cataleg de edificis
     *
     * @param nomCataleg Nom del fitxer on esta el cataleg d'edificis
     */
    public void CarregarCatalegEdifici(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
    }

    /**
     * Crea restriccions a patir d'un cataleg de restriccions
     *
     * @param nomCataleg Nom del fitxer on esta el cataleg de restriccions
     */
    public void CarregarCatalegRestriccio(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
    }

    /**
     * Carrega barris guardas
     *
     * @param nomBarri Nom del arxiu .o que correspon al barri
     */
    public void CarregarBarri(String nomBarri) { //binari barri.
    }

    /**
     * Afegeix un edifici al barri donat
     *
     * @param nomBarri Nom del barri al que se li afegeix
     * @param nomEdifici Nom del edifici a afegir
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int AfegirEdifici(String nomBarri, String nomEdifici) {
        Edifici e = ctrEdificis.ObtenirEdifici(nomEdifici);
        if (e == null) {
            return -1;
        }
        return ctrBarri.AfegirEdifici(e, nomBarri);

    }

    /**
     * Imposa una restriccio sobre un barri
     *
     * @param nomBarri Nom del barri sobre la que s'imposa la restrccio
     * @param idRestriccio Identificador de la restriccio
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ImposarRestriccio(String nomBarri, int idRestriccio) {
        RestriccioBarris r = ctrRestric.ObtenirRest(idRestriccio);//crida al ctrRestric
        if (r == null) {
            return -1;
        }
        return ctrBarri.AfegeixRestriccions(nomBarri, r);

    }

    /**
     * Elimina l'edifici del barri donat
     *
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int TreuEdifici(String nomBarri, String nomEdifici) {
        return ctrBarri.TreureEdifici(nomBarri, nomEdifici);
    }

    /**
     * Elimina la restriccio del barri donat
     *
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRestriccio Identificador de la restriccio a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int TreuRestriccio(String nomBarri, int idRestriccio) {
        return ctrBarri.TreureRestriccio(nomBarri, idRestriccio);
    }

    /**
     * Genera un barri a partir de les restriccions
     *
     * @param nomBarri Nom del barri que es vol generar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int GeneraBarri(String nomBarri) {//crida a backtraking
        return ctrBarri.GenerarBarri(nomBarri);
    }

    private TipusHab StringHabtoEnum(String n) {
        if (n.equals("Casa")) {
            return TipusHab.Casa;
        } else if (n.equals("Pis")) {
            return TipusHab.Pis;
        } else if (n.equals("Mansio")) {
            return TipusHab.Mansio;
        } else if (n.equals("Xalet")) {
            return TipusHab.Xalet;
        }
        return null;
    }

    private TipusServei StringSertoEnum(String n) {
        if (n.equals("Hospital")) {
            return TipusServei.Hospital;
        } else if (n.equals("Escola")) {
            return TipusServei.Escola;
        } else if (n.equals("Policia")) {
            return TipusServei.Policia;
        } else if (n.equals("Preso")) {
            return TipusServei.Preso;
        } else if (n.equals("Bombers")) {
            return TipusServei.Bombers;
        } else if (n.equals("Parc")) {
            return TipusServei.Parc;
        } else if (n.equals("Centre Cultural")) {
            return TipusServei.Centre_Cultural;
        }
        return null;
    }

    private TipusNegoci StringNegtoEnum(String n) {
        if (n.equals("Discoteca")) {
            return TipusNegoci.Discoteca;
        } else if (n.equals("Banc")) {
            return TipusNegoci.Banc;
        } else if (n.equals("Bar")) {
            return TipusNegoci.Bar;
        } else if (n.equals("Restaurant")) {
            return TipusNegoci.Restaurant;
        } else if (n.equals("Botiga alimentacio")) {
            return TipusNegoci.Botiga_alimentacio;
        } else if (n.equals("Botiga roba")) {
            return TipusNegoci.Botiga_roba;
        } else if (n.equals("Escola privada")) {
            return TipusNegoci.Escola_privada;
        } else if (n.equals("Clinica")) {
            return TipusNegoci.Clinica;
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
        if (c.equals("Altura")) {
            return Atribut.ALSADA;
        } else if (c.equals("Cost")) {
            return Atribut.COST;
        } else if (c.equals("Distancia")) {
            return Atribut.DISTANCIA;
            // } else if (c.equals("Codi1")) {
            //    return Atribut.CODI1;
            //} else if (c.equals("Codi2")) {
            //     return Atribut.CODI2;
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

    public ArrayList<String> LlistatEdificis() {
        return ctrEdificis.LlistatEdificis();
    }
}
