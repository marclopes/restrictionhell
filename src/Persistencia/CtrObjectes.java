/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miquel.masriera
 *
 * TOTES ELS CLASSES QUE ES RELACIONIN AMB AQUESTA HAN DE SER SERIALITZABLES
 */
public class CtrObjectes<Classe> extends CtrDisc implements Serializable {

    /**
     * creadora per defecte
     */
    public CtrObjectes() {
    }

    /**
     *
     * @param nomArxiu nom de l arxiu a buscar, sense el format
     *
     * @return retorna un boleÃ  que es cert si hi ha un arxiu amb aquell nom
     */
    public boolean existeix(String nomArxiu) {
        return new File("./Data/" + nomArxiu + ".o").canRead();
    }
    /**
     *
     * @param nom nom de l'arxiu a crear, no sobreescriu
     * @param elem instancia de la classe a guardar
     * @return retorna cert si pot guardar el binar ide la classe i fals tant si
     * hi ha problemes com si ja existeixen objectes amb aquell nom
     */
    public boolean creaObjecte(String nom, Classe elem) {
        ObjectOutputStream sortida = null;
        try {
            if (!existeix(nom)) {
                sortida = new ObjectOutputStream(new FileOutputStream("./Data/" + nom + ".o"));
                sortida.writeObject(elem);
                sortida.close();
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     *
     * @param nomArxiu nom de l arxiu a esborrar
     * @return un bolea que indica que no s ha pogut esborrar l arxiu indicat
     */
    public boolean esborra(String nomArxiu) {
        if (existeix(nomArxiu)) {
            return new File("./Data/" + nomArxiu + ".o").delete();
        } else {
            return false;
        }
    }

    /**
     *
     * @param nom nom de la classe a llegir
     * @return retorna una instància de la classe que té per nom el que reb per
     * paramete LA CLASSE QUE LA CRIDI TINDRÀ QUE FER EL CAST
     */
    public Classe llegirObjecte(String nom) {
        Classe aux = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("./Data/" + nom + ".o"));
            aux = (Classe) entrada.readObject();
            entrada.close();
            return aux;
        } catch (IOException ex) {
            Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
}
