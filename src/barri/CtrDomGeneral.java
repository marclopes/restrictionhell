package barri;
/**
 * @autor albert 
 */
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
    /**
     * Crea una instancia del Controlador general de domini
     */
    private CtrDomGeneral() {
        ctrBarri = CtrBarriDom.ObteInstancia();
        ctrEdificis = CtrEdDom.ObteInstancia();
        ctrRestric = CtrDomRestriccio.ObteInstancia();
    }
    /**
     * Retorna la instancia del controlador general de domini i si no existeix la crea
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
   * @param n Nom del barri
   * @param po Poblacio minima del barri
   * @param pr Presopost maxim del barri
   * @param c Cost de manteniment maxim
   * @param cl Classe social del barri
   * @param a Aparcaments minims del barri
   * @param xx Dimensio X del barri
   * @param yy Dimensio Y del barri
   */
    public void CreaBarri(String n, int po, int pr, int c, String cl, int a, int xx, int yy) {
        Classes tipClas;
        tipClas = StringToClase(cl);
        ctrBarri.CreaBarri(n, po, pr, c, tipClas, a, xx, yy);
    }
    /**
     * Crea una restriccio de tipus alçada 
     * @param alsada Es l'alçada maxima que defineix la restriccio
     */
    public void CrearRestriccioAlsada(int alsada) { // esperar nova clase restriccio
        ctrRestric.creaRestAlsada(alsada, null);
    }
    /**
     * Crea una restriccio de tipus cost
     * @param cost Es el cost maxim/minim del barri
     * @param max Indica si el cost es maxim o el cost es minim
     */
    public void CrearRestriccioCost(int cost, boolean max) {
        ctrRestric.creaRestCost(cost, max, null);
    }

  /* public void CrearRestriccioDistanciaCodi() {
    }*/
    /**
     * Crea una restriccio de distancia sobre 2 tipus d'edificis
     * @param dist Distancia maxima/minima entre els tipus d'edifici
     * @param max Indica si la distancia es maxima o minima
     * @param el1 
     * @param el2 
     */
    public void CrearRestriccioDistanciaTipus(int dist, boolean max, String el1, String el2) {
        Edifici e1 = ctrEdificis.ObtenirEdifici(el1);
        Edifici e2 = ctrEdificis.ObtenirEdifici(el2);
        if (e1 != null && e2 != null) {
            ctrRestric.creaDistTipus(dist, max, e1, e2, null);
        }
    }

    public void CreaRestriccioArea() {
    }
    /**
     * Crea una restriccio d'impostos
     * @param imp Impostos minims que cal recaptar
     */
    public void CreaRestriccioImpostos(int imp) {
        ctrRestric.creaRestImpostos(imp, null);
    }
    /**
     * Crea una restriccio sobre el cost de manteniment
     * @param cost Qost maxim de manteniment de serveis publics
     */
    public void CreaRestriccioManteniment(int cost) {
        ctrRestric.creaRestManteniment(cost, null);
    }
    /**
     * Crea una restriccio de quantitat maxima/minima sobre un edifici
     * @param quantitat Quantitat maxima/minima d'edificis
     * @param max Indica si es maxim o minim d'edificis
     * @param edifici Edifici sobre el que s'aplica la restriccio
     */
    public void CreaRestriccioQuantitat(int quantitat, boolean max, String edifici) {
        Edifici e = ctrEdificis.ObtenirEdifici(edifici);
        if (e != null) {
            ctrRestric.creaQuantitat(quantitat, max, e);
        }
    }
    /**
     * Crea un habitatge amb les dades donades
     * @param impost impostos generats per l'habitatge
     * @param aparcament aparcament disponible del habitatge
     * @param nom nom del habitatge
     * @param h altura del habitatge
     * @param capacitat capacitat del habitatge
     * @param tipus tipus d'habitatge
     */
    public void CreaHabitatge(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error
        tipusHab k = StringHabtoEnum(tipus);
        ctrEdificis.CreaHabitatge(impost, aparcament, nom, 0, h, capacitat, k);

    }
    /**
     * Crea un negoci amb les dades donades
     * @param impost impostos generats per el negoci
     * @param aparcament aparcament disponible del negoci
     * @param nom nom del negoci
     * @param h altura del negoci
     * @param capacitat capacitat del negoci
     * @param tipus tipus de negoci
     */

    public void CreaNegoci(int impost, int aparcament, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error;
        tipusNegoci k = StringNegtoEnum(tipus);
        ctrEdificis.CreaNegoci(impost, aparcament, nom, 0, h, capacitat, k);
    }
    /**
     * Crea un servei amb les dades donades
     * @param cost cost de construccio del servei
     * @param manteniment cost de manteniment del servei
     * @param area area d'influencia del servei
     * @param nom nom del servei
     * @param h altura del edifici
     * @param capacitat capacitat del servei
     * @param tipus tipus de servei
     */
    public void CreaServei(int cost, int manteniment, int area, String nom, int h, int capacitat, String tipus) {
        if (ctrEdificis.ExisteixEdifici(nom)) ;//error;
        tipusServei k = StringSertoEnum(tipus);
        ctrEdificis.CreaServei(cost, manteniment, area, nom, 0, h, capacitat, k);
    }
    /**
     * Modifica el atribut del barri donat amb el valor donat
     * @param nomBarri nom del barri a modificar
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     */
    public void ModificarBarri(String nomBarri, String atribut, String valor) {
            ctrBarri.ModificarBarri(nomBarri, atribut, valor);
    }
    /**
     * Modifica l'atribut del edifici donat amb el valor donat
     * @param nomEdifici nom del edifici a modificar
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     */
    public void ModificarEdifici(String nomEdifici, String atribut, String valor) {
        ctrEdificis.ModificarEdifici(nomEdifici, atribut, valor);
    }
    /**
     * Modifica l'atribut de la restriccio donada amb el valor donat
     * @param idRest identificador de la restriccio
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     */
    public void ModificarRestriccio(int idRest, String atribut, String valor) {
        ctrRestric.ModificarRestriccio(idRest, StringToAtribut(atribut), valor);
    }
    /**
     * Elimina l'edifici donat
     * @param nomEdifici nom de l'edifici a eliminar
     */
    public void EliminarEdifici(String nomEdifici) {
        if (ctrEdificis.ObtenirEdifici(nomEdifici) == null);//error
        else {
            ctrEdificis.EliminarEdifici(nomEdifici);
        }
    }
    /**
     * Elimina el barri donat
     * @param nomBarri nom del barri a eliminar
     */
    public void EliminarBarri(String nomBarri) {
        ctrBarri.EliminarBarri(nomBarri);
    }
    /**
     * Elimina la restriccio donada
     * @param id Identificador de la restriccio a eliminar
     */
    public void EliminarRestriccio(int id) {
        ctrRestric.EliminarRestriccio(id);
    }
    /**
     * Crea edificis a partir d'un cataleg de edificis
     * @param nomCataleg Nom del fitxer on esta el cataleg d'edificis
     */
    public void CarregarCatalegEdifici(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
        
    }
    /**
     * Crea restriccions a patir d'un cataleg de restriccions
     * @param nomCataleg Nom del fitxer on esta el cataleg de restriccions
     */
    public void CarregarCatalegRestriccio(String nomCataleg) {// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
    }
    /**
     * Carrega barris guardas
     * @param nomBarri Nom del arxiu .o que correspon al barri
     */
    public void CarregarBarri(String nomBarri) { //binari barri.
    }
    /**
     * Afegeix un edifici al barri donat
     * @param nomBarri Nom del barri al que se li afegeix
     * @param nomEdifici Nom del edifici a afegir
     */
    public void AfegirEdifici(String nomBarri, String nomEdifici) {//al barri FALTA FER UNA COPIA DEL EDIFICI
        Edifici e = ctrEdificis.ObtenirEdifici(nomEdifici);//faig una copia
        //Barri b = ctrBarri.GetBarri(nomBarri);
        ctrBarri.AfegirEdifici(e, nomBarri);

    }
    /**
     * Imposa una restriccio sobre un barri
     * @param nomBarri Nom del barri sobre la que s'imposa la restrccio
     * @param idRestriccio Identificador de la restriccio
     */
    public void ImposarRestriccio(String nomBarri, int idRestriccio) {
        RestriccioBarris r = ctrRestric.obtRest(idRestriccio);//crida al ctrRestric
        ctrBarri.AfegeixRestriccions(nomBarri, r);

    }
    /**
     * Elimina l'edifici del barri donat
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici a eliminar
     */
    public void TreuEdifici(String nomBarri, String nomEdifici) {
        ctrBarri.TreureEdifici(nomBarri, nomEdifici);
    }
    /**
     * Elimina la restriccio del barri donat
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRestriccio Identificador de la restriccio a eliminar
     */
    public void TreuRestriccio(String nomBarri, int idRestriccio) {
        ctrBarri.TreureRestriccio(nomBarri, idRestriccio);
    }
    /**
     * Genera un barri a partir de les restriccions
     * @param nomBarri Nom del barri que es vol generar
     */
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
