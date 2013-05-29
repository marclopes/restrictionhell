package barri;

/**
 * @autor albert
 */
import Persistencia.CtrArxius;
import Persistencia.CtrObjectes;
import barri.CtrDomRestriccio.Atribut;
import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;
import java.util.ArrayList;

public class CtrDomGeneral {

    private static CtrDomGeneral ctrDomini = null;
    private CtrBarriDom ctrBarri;
    private CtrEdDom ctrEdificis;
    private CtrDomRestriccio ctrRestric;
    private CtrArxius disc = new CtrArxius();
    private CtrObjectes obj = new CtrObjectes();
    private static int idRes = 0;

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
    public void CreaBarri(String n, String cl, int xx, int yy) {
        Classes tipClas;
        tipClas = StringToClase(cl);
        ctrBarri.CreaBarri(n, tipClas, xx, yy);
    }

    
    public int CrearRestriccioGlobal(String s, int valor){
        ctrRestric.CreaRestriccioGlobal(++idRes, s, valor);
        return 0;
    }

    /* public void CrearRestriccioDistanciaCodi() {
    }*/
    /**
     * Crea una restriccio de distancia sobre 2 tipus d'edificis
     *
     * @param dist Distancia maxima/minima entre els tipus d'edifici
     * @param max Indica si la distancia es maxima o minima
     * @param el1 Tipus d'edifici sobre el que s'imposa la restriccio
     * @param el2 Tipus d'edifici sobre el que s'imposa la restriccio
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int CrearRestriccioDistanciaTipus(int dist, boolean max, String el1, String el2) {
        return ctrRestric.CreaDistTipus(++idRes, dist, max, el1, el2);
    }

    /**
     * Crea una restriccio de quantitat maxima/minima sobre un edifici
     *
     * @param id Identificador de la restriccio
     * @param quantitat Quantitat maxima/minima d'edificis
     * @param max Indica si es maxim o minim d'edificis
     * @param edifici Edifici sobre el que s'aplica la restriccio
     * @return Retorna un codi d'error (0 si s'ha fet be, -1 si s'ha fet
     * malament)
     */
    public int CreaRestriccioQuantitat(int quantitat, boolean max, String edifici) {
            return ctrRestric.CreaRestQuantitat(++idRes, quantitat, max, edifici);
    }
    
    public int CreaRestriccioRUHab(String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUHab(++idRes, s, valor, max);
    }
    
    public int CreaRestriccioRUNeg(String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUNeg(++idRes, s, valor, max);
    }
    
    public int CreaRestriccioRUServ(String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUServ(++idRes, s, valor, max);
    }
    
    public int CreaRestriccioRUSubHab(String tipus, String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUSubHab(++idRes, StringHabtoEnum(tipus), s, valor, max);
    }
    
    public int CreaRestriccioRUSubNeg(String tipus, String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUSubNeg(++idRes, StringNegtoEnum(tipus), s, valor, max);
    }
    
    public int CreaRestriccioRUSubServ(String tipus, String s, int valor, boolean max){
        return ctrRestric.CreaRestriccioRUSubServ(++idRes, StringSertoEnum(tipus), s, valor, max);
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
    public int CreaServei(int cost, int manteniment, String nom, int h, int capacitat, String tipus) {
        TipusServei k = StringSertoEnum(tipus);
        return ctrEdificis.CreaServei(cost, manteniment, 0, nom, 0, h, capacitat, k);
    }

    /**
     * Modifica el atribut del barri donat amb el valor donat
     *
     * @param nomBarri nom del barri a modificar
     * @param atribut nom del atribut a modificar
     * @param valor valor que se li dona al atribut a modificar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ModificarBarri(String atribut, String valor) {
        return ctrBarri.ModificarBarri(atribut, valor);
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
        int r = ctrEdificis.EliminarEdifici(nomEdifici);
        if (r == 0) {
            ctrBarri.NetejarEdificis(nomEdifici);
        }
        return r;
    }

    /**
     * Elimina el barri donat
     *
     * @param nomBarri nom del barri a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public void EliminarBarri() {
        ctrBarri.EliminarBarri();
    }

    /**
     * Elimina la restriccio donada
     *
     * @param id Identificador de la restriccio a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int EliminarRestriccio(int id) {

        int r = ctrRestric.EliminarRestriccio(id);
        if (r == 0) {
            ctrBarri.NetejarRestriccions(id);
        }
        return r;

    }

    /**
     * Afegeix un edifici al barri donat
     *
     * @param nomBarri Nom del barri al que se li afegeix
     * @param nomEdifici Nom del edifici a afegir
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int AfegirEdifici(String nomEdifici, int quantitat) {
        ArrayList<Edifici> aux;
        if (nomEdifici.equals("Habitatge") || nomEdifici.equals("Negoci") || nomEdifici.equals("Servei") || StringHabtoEnum(nomEdifici) != null || StringNegtoEnum(nomEdifici) != null || StringSertoEnum(nomEdifici) != null) {
            aux = ctrEdificis.ObtenirEdificisTipus(nomEdifici);
            for (Edifici e : aux) {
                ctrBarri.AfegirEdifici(e);
            }
            return 0;
        } else {
            Edifici e = ctrEdificis.ObtenirEdifici(nomEdifici);
            if (e == null) {
                return -1;
            }
            return ctrBarri.AfegirEdifici(e);

        }
    }

    /**
     * Imposa una restriccio sobre un barri
     *
     * @param nomBarri Nom del barri sobre la que s'imposa la restrccio
     * @param idRestriccio Identificador de la restriccio
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int ImposarRestriccio(int idRestriccio) {
        RestriccioBarris r = ctrRestric.ObtenirRest(idRestriccio);//crida al ctrRestric
        if (r == null) {
            return -1;
        }
        return ctrBarri.AfegeixRestriccions(r);

    }

    /**
     * Elimina l'edifici del barri donat
     *
     * @param nomBarri Nom del barri al que se li elimina l'edifici
     * @param nomEdifici Nom del edifici a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int TreuEdifici(String nomEdifici) {
        return ctrBarri.TreureEdifici(nomEdifici);
    }

    /**
     * Elimina la restriccio del barri donat
     *
     * @param nomBarri Nom del barri al que se li elimina la restriccio
     * @param idRestriccio Identificador de la restriccio a eliminar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int TreuRestriccio(String nomBarri, int idRestriccio) {
        return ctrBarri.TreureRestriccio(idRestriccio);
    }

    /**
     * Genera un barri a partir de les restriccions
     *
     * @param nomBarri Nom del barri que es vol generar
     * @return retorna 0 si tot ha anat be i -1 si hi ha hagut problemes
     */
    public int GeneraBarri() {//crida a backtraking
        return ctrBarri.GenerarBarri();
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

    private String EnumHabtoString(TipusHab n) {
        if (n.equals(TipusHab.Casa)) {
            return "Casa";
        } else if (n.equals(TipusHab.Pis)) {
            return "Pis";
        } else if (n.equals(TipusHab.Mansio)) {
            return "Mansio";
        } else if (n.equals(TipusHab.Xalet)) {
            return "Xalet";
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

    private String EnumSertoString(TipusServei n) {
        if (n.equals(TipusServei.Hospital)) {
            return "Hospital";
        } else if (n.equals(TipusServei.Escola)) {
            return "Escola";
        } else if (n.equals(TipusServei.Policia)) {
            return "Policia";
        } else if (n.equals(TipusServei.Preso)) {
            return "Preso";
        } else if (n.equals(TipusServei.Bombers)) {
            return "Bombers";
        } else if (n.equals(TipusServei.Parc)) {
            return "Parc";
        } else if (n.equals(TipusServei.Centre_Cultural)) {
            return "Centre Cultural";
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

    private String EnumNegtoString(TipusNegoci n) {
        if (n.equals(TipusNegoci.Discoteca)) {
            return "Discoteca";
        } else if (n.equals(TipusNegoci.Banc)) {
            return "Banc";
        } else if (n.equals(TipusNegoci.Bar)) {
            return "Bar";
        } else if (n.equals(TipusNegoci.Restaurant)) {
            return "Restaurant";
        } else if (n.equals(TipusNegoci.Botiga_alimentacio)) {
            return "Botiga alimentacio";
        } else if (n.equals(TipusNegoci.Botiga_roba)) {
            return "Botiga roba";
        } else if (n.equals(TipusNegoci.Escola_privada)) {
            return "Escola privada";
        } else if (n.equals(TipusNegoci.Clinica)) {
            return "Clinica";
        }
        return null;
    }

    private Classes StringToClase(String c) {
        if (c.equals("Alta")) {
            return Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Classes.Mitja;
        } else if (c.equals("Baixa")) {
            return Classes.Baixa;
        }
        return null;

    }

    private Atribut StringToAtribut(String c) {
        if (c.equals("Altura")) {
            return Atribut.ALSADA;
        } else if (c.equals("Cost")) {
            return Atribut.COST;
        } else if (c.equals("Distancia")) {
            return Atribut.DISTANCIA;
        } else if (c.equals("Impostos")) {
            return Atribut.IMPOSTOS;
        } else if (c.equals("Influencia")) {
            return Atribut.INFLUENCIA;
        } else if (c.equals("Quantitat")) {
            return Atribut.QUANTITAT;
/*        } else if (c.equals("Maxim")) {
            return Atribut.RUHAB;
        } else if (c.equals("Maxim")) {
            return Atribut.RUNEG;
        } else if (c.equals("Maxim")) {
            return Atribut.RUSER;
        } else if (c.equals("Maxim")) {
            return Atribut.RUSUBHAB;
        } else if (c.equals("Maxim")) {
            return Atribut.RUSUBNEG;
        } else if (c.equals("Maxim")) {
            return Atribut.RUSUBSER;*/
        }
        return null;
    }

    /**
     * Llista tots els edificis carregats
     * @return 
     */
    public ArrayList<String> LlistatEdificis() {
        return ctrEdificis.LlistatEdificis();
    }

    /**
     * Crea un cataleg d'edificis buit.
     * @param s Nom del catàleg que volem crear
     * @return Cert si es pot crear el cataleg. Fals si no es pot crear.
     */
    public boolean CreaCatalegEdificis(String s) {
        if (!disc.existeix("ed_" + s)) {
            ArrayList<String> l = new ArrayList<String>();
            disc.creaArxiu("ed_" + s, l);
            return true;
        }
        return false;
    }

    /**
     * Consulta tots els edificis que hi ha al directori.
     * @return Una llista amb el nom dels barris.
     */
    public ArrayList<String> LlistaCatalegEdificisDisc() {
        ArrayList<String> l = new ArrayList<String>();
        l = disc.llistaDirectori("ed_");
        for (int i = 0; i < l.size(); i++) {
            l.set(i, l.get(i).replaceAll("ed_", ""));
            l.set(i, l.get(i).replaceAll(".txt", ""));
        }
        return l;
    }

    /**
     * Crea un fitxer editable amb extensió txt dins del directori ./data on el 
     * nom es la concatenació de ed_ i el nom de l'edifici que volem guardar.
     * @param e Edifici que volem guardar en un fitxet editable.
     */
    public int GuardaEdificiDiscText(Edifici e, String cataleg, boolean sobreescriure) {
        ArrayList<String> linies = new ArrayList();
        linies = disc.llegir("ed_" + cataleg);
        String nom = e.ConsultarNom();
        int index = -100;
        if (linies.contains(nom) && !sobreescriure) {
            return -1;
        } //L'edifici ja existeix
        else if (linies.contains(nom) && sobreescriure) {
            index = linies.indexOf(nom);
            int codi = e.ConsultarCodi();
            int h = e.ConsultarH();
            int capacitat = e.ConsultarCapacitat();
            int impost, aparcament, cost, manteniment, area;
            if (e.tipusEd == TipusEd.HAB) {
                impost = ((Habitatge) e).ConsultarImpost();
                aparcament = ((Habitatge) e).ConsultarAparcament();
                linies.set(index - 2, "Habitatge");
                linies.set(index - 1, EnumHabtoString(((Habitatge) e).consultarTipus()));
                linies.set(index, String.valueOf(nom));
                linies.set(index + 1, String.valueOf(codi));
                linies.set(index + 2, String.valueOf(h));
                linies.set(index + 3, String.valueOf(capacitat));
                linies.set(index + 4, String.valueOf(impost));
                linies.set(index + 5, String.valueOf(aparcament));
            } else if (e.tipusEd == TipusEd.NEG) {
                impost = ((Negoci) e).ConsultarImpost();
                aparcament = ((Negoci) e).ConsultarAparcament();
                linies.set(index - 2, "Negoci");
                linies.set(index - 1, EnumNegtoString(((Negoci) e).consultarTipus()));
                linies.set(index, String.valueOf(nom));
                linies.set(index + 1, String.valueOf(codi));
                linies.set(index + 2, String.valueOf(h));
                linies.set(index + 3, String.valueOf(capacitat));
                linies.set(index + 4, String.valueOf(impost));
                linies.set(index + 5, String.valueOf(aparcament));
            } else if (e.tipusEd == TipusEd.SER) {
                cost = ((Servei) e).ConsultarCost();
                manteniment = ((Servei) e).ConsultarManteniment();
                area = ((Servei) e).ConsultarAreaInfluencia();
                linies.set(index - 2, "Servei");
                linies.set(index - 1, EnumHabtoString(((Habitatge) e).consultarTipus()));
                linies.set(index, String.valueOf(nom));
                linies.set(index + 1, String.valueOf(codi));
                linies.set(index + 2, String.valueOf(h));
                linies.set(index + 3, String.valueOf(capacitat));
                linies.set(index + 4, String.valueOf(cost));
                linies.set(index + 5, String.valueOf(manteniment));
                linies.set(index + 6, String.valueOf(area));
            }
        } else {
            int codi = e.ConsultarCodi();
            int h = e.ConsultarH();
            int capacitat = e.ConsultarCapacitat();
            int impost, aparcament, cost, manteniment, area;
            linies.add("");
            if (e.tipusEd == TipusEd.HAB) {
                impost = ((Habitatge) e).ConsultarImpost();
                aparcament = ((Habitatge) e).ConsultarAparcament();
                linies.add("Habitatge");
                linies.add(EnumHabtoString(((Habitatge) e).consultarTipus()));
                linies.add(String.valueOf(nom));
                linies.add(String.valueOf(codi));
                linies.add(String.valueOf(h));
                linies.add(String.valueOf(capacitat));
                linies.add(String.valueOf(impost));
                linies.add(String.valueOf(aparcament));
            } else if (e.tipusEd == TipusEd.NEG) {
                impost = ((Negoci) e).ConsultarImpost();
                aparcament = ((Negoci) e).ConsultarAparcament();
                linies.add("Negoci");
                linies.add(EnumNegtoString(((Negoci) e).consultarTipus()));
                linies.add(String.valueOf(nom));
                linies.add(String.valueOf(codi));
                linies.add(String.valueOf(h));
                linies.add(String.valueOf(capacitat));
                linies.add(String.valueOf(impost));
                linies.add(String.valueOf(aparcament));
            } else if (e.tipusEd == TipusEd.SER) {
                cost = ((Servei) e).ConsultarCost();
                manteniment = ((Servei) e).ConsultarManteniment();
                area = ((Servei) e).ConsultarAreaInfluencia();
                linies.add("Servei");
                linies.add(EnumHabtoString(((Habitatge) e).consultarTipus()));
                linies.add(String.valueOf(nom));
                linies.add(String.valueOf(codi));
                linies.add(String.valueOf(h));
                linies.add(String.valueOf(capacitat));
                linies.add(String.valueOf(cost));
                linies.add(String.valueOf(manteniment));
                linies.add(String.valueOf(area));
            }
        }
        disc.creaArxiu("ed_" + cataleg, linies);
        return index;
    }

    /**
     * Llegeix els fitxers amb extensió txt del directori ./data i que comencen 
     * amb el nom "ed_", i carrèga tots els edificis definits a dintre, ignora els
     * edificis que estiguin mal declarats.  
     */
    public int CarregaCatalegEdifici(String s) {
        ArrayList<String> arxiu;
        int i = 0;
        String nom;
        int codi, h, capacitat, impost, aparcament, cost, manteniment, area;
        TipusHab t;
        TipusNegoci n;
        TipusServei se;
        arxiu = disc.llegir("ed_"+s);
        while (i < arxiu.size()){
            if(arxiu.get(i).equals("Habitatge")){
                if(i+7<arxiu.size()){
                    t = StringHabtoEnum(arxiu.get(i+1));
                    if(t == null) return -1;
                    nom = arxiu.get(i+2);
                    if(!ctrEdificis.ExisteixEdifici(nom)){
                        try{
                            codi = Integer.parseInt(arxiu.get(i+3));
                            h = Integer.parseInt(arxiu.get(i+4));
                            capacitat = Integer.parseInt(arxiu.get(i+5));
                            impost = Integer.parseInt(arxiu.get(i+6));
                            aparcament = Integer.parseInt(arxiu.get(i+7));
                        } catch (NumberFormatException e){return 11;}
                        ctrEdificis.CreaHabitatge(impost, aparcament, nom, codi, h, capacitat, t);
                    }
                    i = i+7;
                }else return 1;
            }
            else if(arxiu.get(i).equals("Servei")){
                if(i+8<arxiu.size()){
                    se = StringSertoEnum(arxiu.get(i+1));
                    if(se == null) return -1;
                    nom = arxiu.get(i+2);
                    if(!ctrEdificis.ExisteixEdifici(nom)){
                        try{
                            codi = Integer.parseInt(arxiu.get(i+3));
                            h = Integer.parseInt(arxiu.get(i+4));
                            capacitat = Integer.parseInt(arxiu.get(i+5));
                            cost = Integer.parseInt(arxiu.get(i+6));
                            manteniment = Integer.parseInt(arxiu.get(i+7));
                            area = Integer.parseInt(arxiu.get(i+8));
                            ctrEdificis.CreaServei(cost, manteniment, area, nom, codi, h, capacitat, se);
                        } catch (NumberFormatException e){return 12;}
                        i = i+8;
                    }
                }else return 2;
            }
            else if(arxiu.get(i).equals("Negoci")){
                if(i+7<arxiu.size()){
                    n = StringNegtoEnum(arxiu.get(i+1));
                    if(n == null) return -1;
                    nom = arxiu.get(i+2);
                    if(!ctrEdificis.ExisteixEdifici(nom)){
                        try{
                            codi = Integer.parseInt(arxiu.get(i+3));
                            h = Integer.parseInt(arxiu.get(i+4));
                            capacitat = Integer.parseInt(arxiu.get(i+5));
                            impost = Integer.parseInt(arxiu.get(i+6));
                            aparcament = Integer.parseInt(arxiu.get(i+7));
                            ctrEdificis.CreaNegoci(impost, aparcament, nom, codi, h, capacitat, n);
                        } catch (NumberFormatException e){return 13;}
                        i = i+7;
                    }
                }else return 3;
            }
            i++;
        }
        return 0;
    }

    /**
     * Consulta tots els barris que hi ha al directori.
     * @return Una llista amb el nom dels barris.
     */
    public ArrayList<String> LlistaBarrisDisc() {
        ArrayList<String> l = disc.llistaDirectori("bar_");
        for (int i = 0; i < l.size(); i++) {
            l.set(i, l.get(i).replaceAll("bar_", ""));
            l.set(i, l.get(i).replaceAll(".o", ""));
        }
        return l;
    }

    /**
     * Llegeix de disc una instancia de barri.
     * @param f El nom del barri que volem carregar.
     * @return La instancia del barri.
     */
    public boolean CarregaBarri(String f) {
        if (obj.existeix("bar_" + f)) {
            Object o = obj.llegirObjecte("bar_" + f);
            Barri b = (Barri) o;
            ctrBarri.CreaBarri(b);
            return true;
        }
        return false;
    }

    /**
     * Guarda al disc una instancia de barri.
     * @param b El barri que volem guardar.
     * @return retorna Cert si pot guardar el barri .Fals tant si hi ha problemes com si ja existeixen objectes amb aquell nom
     */
    public boolean GuardaBarri() {
        return obj.creaObjecte("bar_" + ctrBarri.ObtenirBarri().ConsultarNom(), ctrBarri.ObtenirBarri());
    }

    //Aquesta funciona es per proves
    public Edifici ObteEdifici(String s) {
        return ctrEdificis.ObtenirEdifici(s);
    }

    //Aquesta funciona es per proves
    public RestriccioBarris ObteRestriccio(int id) {
        return ctrRestric.ObtenirRest(id);
    }

    /**
     * Consulta tot els catàlegs de restriccions que hi ha guardats.
     * @return Una llista amb el nom de tots els catalegs guardats a la carpeta Data.
     */

    public ArrayList<String> LlistaCatalegRestriccionsDisc(){
        CtrArxius arxiu = new CtrArxius();
        ArrayList<String> l = arxiu.llistaDirectori("res_");
        for (int i = 0;i<l.size();i++){

            l.set(i, l.get(i).replaceAll("res_", ""));
            l.set(i, l.get(i).replaceAll(".txt", ""));
        }
        return l;
    }

    
    public int CreaCatalegRestriccions(String s){
        CtrArxius c = new CtrArxius();
        if(!c.existeix("res_"+s)){
            ArrayList<String> l = new ArrayList<String>();
            c.creaArxiu("res_"+s, l);
            return 0;
        }
        return -1;
    }

    
    public boolean GuardaRestriccioCataleg(RestriccioBarris r, String cataleg){
        String s;
        int valor;
        boolean b;
        ArrayList<String> linies = new ArrayList();
        linies = disc.llegir("res_" + cataleg);
        TipusRest t = r.obteTipus();
        if(r instanceof RGlobal ) {
            linies.add(((RGlobal) r).ObteAtrib());
            linies.add(String.valueOf(((RGlobal) r).ObteVal()));
        }
        else if (t == TipusRest.DISTTIPUS) {
            linies.add("Distancia");
            int d = ((RDistTipus) r).ConsultarDist();
            linies.add(String.valueOf(d));
            boolean maxd = ((RDistTipus) r).EsMax();
            if (maxd) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
            String e1 = ((RDistTipus) r).ConsultarEd1();
            String e2 = ((RDistTipus) r).ConsultarEd2();
            linies.add(e1);
            linies.add(e2);
        } else if (t == TipusRest.RUHAB) {
            linies.add("Atribut habitatge");
            s = ((RUHab) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUHab) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUHab) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        } else if (t == TipusRest.RUNEG) {
            linies.add("Atribut negoci");
            s = ((RUNeg) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUNeg) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUNeg) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        } else if (t == TipusRest.RUSERV) {
            linies.add("Atribut servei");
            s = ((RUServ) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUServ) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUServ) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        } else if (t == TipusRest.RUSUBHAB) {
            linies.add("Atribut tipus habitatge");
            linies.add(EnumHabtoString(((RUSubHab) r).ConsultaTipus()));
            s = ((RUSubHab) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUSubHab) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUSubHab) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        } else if (t == TipusRest.RUSUBNEG) {
            linies.add("Atribut tipus negoci");
            linies.add(EnumNegtoString(((RUSubNeg) r).ConsultaTipus()));
            s = ((RUSubNeg) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUSubNeg) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUSubNeg) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        } else if (t == TipusRest.RUSUBSERV) {
            linies.add("Atribut tipus servei");
            linies.add(EnumSertoString(((RUSubServ) r).ConsultaTipus()));
            s = ((RUSubServ) r).ConsultaAtribut();
            linies.add(s);
            valor = ((RUSubServ) r).ConsultaValor();
            linies.add(String.valueOf(valor));
            if (((RUSubServ) r).EsMax()) {
                linies.add("Maxim");
            } else {
                linies.add("Minim");
            }
        }
        linies.add("");
        disc.creaArxiu("res_" + cataleg, linies);
        return true;
    }


    
     public boolean CarregaCatalegRestriccions(String cataleg){
        ArrayList<String> l = disc.llegir("res_"+cataleg);
        ctrRestric = CtrDomRestriccio.ObteInstancia();
        int i = 0, enter, x;
        String s, f, s1, s2;
        Edifici e1 = null, e2 = null;
        boolean max;
        while(i < l.size()){
            s = l.get(i);
            if(s.equals("APARCAMENT") || s.equals("COST") || s.equals("IMPOSTOS") || s.equals("MANTENIMENT")){
                try{
                    enter = Integer.parseInt(l.get(i+1));
                }catch(NumberFormatException e){return false;}
                ctrRestric.CreaRestriccioGlobal(++idRes, cataleg, enter);
                i = i + 1;
            }
            else if(l.get(i).equals("Distancia")){
                try{
                    enter = Integer.parseInt(l.get(i+1));
                }catch(NumberFormatException e){return false;}
                s = l.get(i+2);
                if(s.equals("Maxim")) max = true;
                else max = false;
                s1 = l.get(i+3);
                s2 = l.get(i+4);
                ctrRestric.CreaDistTipus(++idRes, enter, max, s1, s2);
                i = i + 4;
            }
            else if(l.get(i).equals("Atribut habitatge")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+2));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+3);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUHab(++idRes,s,enter,max);
                i = i + 3;
            }
            else if(l.get(i).equals("Atribut negoci")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+2));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+3);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUNeg(++idRes,s,enter,max);
                i = i + 3;
            }
            else if(l.get(i).equals("Atribut servei")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+2));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+3);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUServ(++idRes,s,enter,max);
                i = i + 3;
            }
            else if(l.get(i).equals("Atribut tipus habitatge")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+3));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+4);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUSubHab(++idRes,StringHabtoEnum(l.get(i+2)),s,enter,max);
                i = i + 4;
            }
            else if(l.get(i).equals("Atribut tipus negoci")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+3));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+4);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUSubNeg(++idRes,StringNegtoEnum(l.get(i+2)),s,enter,max);
                i = i + 4;
            }
            else if(l.get(i).equals("Atribut tipus servei")){
                s = l.get(i+1);
                try{
                    enter = Integer.parseInt(l.get(i+3));
                }catch(NumberFormatException e){return false;}
                f = l.get(i+4);
                if(f.equals("Maxim")) max = true;
                else max = false;
                ctrRestric.CreaRestriccioRUSubServ(++idRes,StringSertoEnum(l.get(i+2)),s,enter,max);
                i = i + 4;
            }
            i++;
        }
        return true;
    
    }

    public boolean BarriCarregat() {
        return ctrBarri.BarriCarregat();
    }

    public ArrayList<String> LlistaFitxes(String prefix) {
        //Barris comencen per bar_ ,catalegs edificis per ed_ i catalegs restriccions per res_
        return disc.llistaDirectori(prefix);
    }

    public ArrayList<String> LlistaEdificis() {
        return ctrEdificis.LlistatEdificis();
    }

    public ArrayList<String> LlistaEdificis(String tipus) {
        return ctrEdificis.LlistatEdificis(tipus);
    }
    
    public void SeleccionaEdificis(String tipus, int quant) {
        ArrayList<Edifici> ve = ctrEdificis.ObtenirEdificisTipus(tipus);
        ctrBarri.AfegirEdificis(ve, quant);
    }
    
    public int ObteNRestriccionsBarri(){
        return ctrBarri.ObteNRestriccions();
    }
    
    public ArrayList<String> ObteInfoRestriccionsBarri(){
        return ctrBarri.ObteInfoRestriccionsBarri();
    }
    
    public String ConsultaNomBarri(){
        return ctrBarri.ObteNomBarri();
    }
    
    public ArrayList<String> ObteInfoRestriccionsConjunt(){
        return ctrRestric.ObteInfoRestriccionsConjunt();
    }
    /*public ArrayList<String> LlistaRestriccions(String s){
        
    }*/
}
