package barri;

import barri.Edifici.Classes;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;
import java.util.ArrayList;

/**
 *
 * @author Eduard Ricou
 */
public class CtrEdDom {

    private static CtrEdDom ctrEd = null;
    private CjtEdificis cjtEd = new CjtEdificis();

    /**
     * Crea una instancia buida del controlador d'edificis.
     */
    private CtrEdDom() {
        cjtEd = new CjtEdificis();
    }

    /**
     * Crea una instancia del controlador d'edificis en cas de que no estigui
     * creada.
     *
     * @return una instancia del controlador d'edificis.
     */
    public static CtrEdDom ObteInstancia() {
        if (ctrEd == null) {
            ctrEd = new CtrEdDom();
        }
        return ctrEd;
    }

    /**
     * Crea un habitatge i l'afegeix al conjunt d'edificis del controlador.
     *
     * @param impost Impostos que pagarà aquest habitatge.
     * @param aparcament Places d'aparcament del habitatge.
     * @param nom Nom de l'habitatge.
     * @param codi Codi de l'habitatge.
     * @param h Alçada de l'edifici.
     * @param capacitat Nombre de persones que poden viure a l'habitatge.
     * @param tipus Tipus d'habitatge.
     */
    public int CreaHabitatge(int impost, int aparcament, String nom, int codi, int h, int capacitat, TipusHab tipus) {
        Habitatge hab = new Habitatge(impost, aparcament, nom, codi, h, capacitat, tipus);
        if (ExisteixEdifici(nom)) {
            return -1;
        }
        cjtEd.AfegirEdifici(hab);
        return 0;
    }

    /**
     * Crea un negoci i l'afegeix al conjunt d'edificis del controlador.
     *
     * @param impost Impostos que pagarà aquest negoci.
     * @param aparcament Places d'aparcament del negoci.
     * @param nom Nom del negoci.
     * @param codi Codi del negoci.
     * @param h Alçada de l'edifici.
     * @param capacitat Aforament del negoci.
     * @param tipus Tipus de negoci.
     */
    public int CreaNegoci(int impost, int aparcament, String nom, int codi, int h, int capacitat, TipusNegoci tipus) {
        Negoci hab = new Negoci(impost, aparcament, nom, codi, h, capacitat, tipus);
        if (ExisteixEdifici(nom)) {
            return -1;
        }
        cjtEd.AfegirEdifici(hab);
        return 0;
    }

    /**
     * Crea un servei i l'afegeix al conjunt d'edificis del controlador.
     *
     * @param cost Cost de contrucció del servei.
     * @param manteniment Cost de manteniment del servei.
     * @param area Àrea d'influència del servei.
     * @param nom Nom del servei
     * @param codi Codi del servei.
     * @param h Alçada de l'edifici.
     * @param capacitat Aforament del servei.
     * @param tipus Tipus de servei.
     */
    public int CreaServei(int cost, int manteniment, int area, String nom, int codi, int h, int capacitat, TipusServei tipus) {
        Servei hab = new Servei(cost, manteniment, area, nom, codi, h, capacitat, tipus);
        if (ExisteixEdifici(nom)) {
            return -1;
        }
        cjtEd.AfegirEdifici(hab);
        return 0;
    }

    /**
     * Permet modificar un atribut d'un edifici.
     *
     * @param nomEdifici Nom de l'edifici que volem modificar.
     * @param atribut Nom de l'atribut que volem modificar.
     * @param valor Nou valor de l'atribut.
     */
    public int ModificarEdifici(String nomEdifici, String atribut, String valor) {
        Edifici tmpEdifici = cjtEd.ObtenirEdifici(nomEdifici);
        if (atribut.equals("altura")) {
            tmpEdifici.ModificarH(Integer.parseInt(valor));
            return 0;
        } else if (atribut.equals("capacitat")) {
            tmpEdifici.ModificarCapacitat(Integer.parseInt(valor));
            return 0;
        } else if (atribut.equals("classe")) {
            tmpEdifici.EliminarClase(Classes.Alta);
            tmpEdifici.EliminarClase(Classes.Mitja);
            tmpEdifici.EliminarClase(Classes.Baixa);
            if (valor.contains("Alta")) tmpEdifici.AfegirClase(Classes.Alta);
            if (valor.contains("Mitja")) tmpEdifici.AfegirClase(Classes.Mitja);
            if (valor.contains("Baixa")) tmpEdifici.AfegirClase(Classes.Baixa);
            return 0;
        } else {
            if (tmpEdifici instanceof Habitatge) {
                if (atribut.equals("impost")) {
                    ((Habitatge) tmpEdifici).ModificarImpost(Integer.parseInt(valor));
                    return 0;
                } else if (atribut.equals("aparcament")) {
                    ((Habitatge) tmpEdifici).ModificarAparcament(Integer.parseInt(valor));
                }
            } else if (tmpEdifici instanceof Negoci) {
                if (atribut.equals("impost")) {
                    ((Negoci) tmpEdifici).ModificarImpost(Integer.parseInt(valor));
                    return 0;
                } else if (atribut.equals("aparcament")) {
                    ((Negoci) tmpEdifici).ModificarAparcament(Integer.parseInt(valor));
                    return 0;
                }
            } else if (tmpEdifici instanceof Servei) {
                if (atribut.equals("cost")) {
                    ((Servei) tmpEdifici).ModificarCost(Integer.parseInt(valor));
                    return 0;
                } else if (atribut.equals("manteniment")) {
                    ((Servei) tmpEdifici).ModificarManteniment(Integer.parseInt(valor));
                    return 0;
                } else if (atribut.equals("area influencia")) {
                    ((Servei) tmpEdifici).ModificarAreaInfluencia(Integer.parseInt(valor));
                    return 0;
                }
            }
        }
        return -1;


    }

    /**
     * Elimina un edifici identificat per el seu nom del conjunt d'edificis del
     * controlador.
     *
     * @param n Nom de l'edifici que volem eliminar.
     */
    public int EliminarEdifici(String n) {
       if (!ExisteixEdifici(n)) return -1;
        cjtEd.EliminarEdifici(n);
        if (ExisteixEdifici(n)) return -1;
        return 0;
    }
    
    /**
     * Elimina tots els edificis del conjunt d'edificis del controlador.
     */
    public void EliminarTotsEdificis(){
        for (int i=0; i< cjtEd.Tamany();++i){
            cjtEd.EliminarEdifici(cjtEd.ObtenirEdifici(i));
	}
    }

    /**
     * Elimina un edifici del conjunt d'edificis del controlador.
     *
     * @param e Edifici que volem eliminar.
     */
    public int EliminarEdifici(Edifici e) {
        cjtEd.EliminarEdifici(e);
        return 0;
    }

    /**
     * Consultora per obtenir un edifici identificat per el seu nom.
     *
     * @param n Nom de l'edifici.
     * @return L'edifici identificat per nom o null en cas de que no existeixi
     */
    public Edifici ObtenirEdifici(String n) {
        return cjtEd.ObtenirEdifici(n);
    }
    
    public Edifici ObtenirEdifici(int i) {
        return cjtEd.ObtenirEdifici(i);
    }

    public int Tamany() {
        return cjtEd.Tamany();
    }
    
    /**
     * Comprova que l'edifici identificat per nom existeix.
     *
     * @param nom Nom de l'edifici que volem consultar.
     * @return Cert si l'edifici existeix.
     */
    public boolean ExisteixEdifici(String nom) {
        return cjtEd.ExisteixEdifici(nom);
    }

    /**
     * Guarda l'edifici identificat per nom en un fitxer.
     *
     * @param n Nom de l'edifici que volem guardar.
     */
    public void GuardarEdifici(String n) {
        //crida controlador persistencia
    }

    /**
     * Converteix un String en la classe social corresponent.
     *
     * @param c String que volem convetir.
     * @return La classe social associada al String.
     */
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

    public ArrayList<String> LlistatEdificis() {
        ArrayList<String> aux = new ArrayList<String>();
        for (int i=0; i< cjtEd.Tamany();++i){
            aux.add(cjtEd.ObtenirEdifici(i).ConsultarNom());
	}
        return aux;
        
    }
    
    public ArrayList<String> LlistatEdificis(String tipus){
        ArrayList<String> aux = new ArrayList<String>();
        ArrayList<Edifici> edi = ObtenirEdificisTipus(tipus);
        for(int i = 0 ; i<edi.size();++i){
            aux.add(edi.get(i).ConsultarNom());
        }
        return aux;
    }
    
    public ArrayList<Edifici> ObtenirEdificisTipus(String tipus) {
        return cjtEd.ObtenirEdificisTipus(tipus);
    }
     
}
