/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Habitatge.TipusHab;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author eDU
 */
public class DriverMiniPersistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        CtrDomGeneral dm;
        ArrayList<String> l = new ArrayList<String>();
        dm = CtrDomGeneral.ObtenirInstancia();
        dm.CreaCatalegEdificis("Default");
        dm.CreaCatalegEdificis("Tunned");
        dm.CreaHabitatge(1222, 2, "edu", 1, 2, "Casa");
        dm.CreaHabitatge(1222, 2, "mar", 1, 2, "Casa");
        dm.CreaHabitatge(1222, 2, "TTTTTT", 1, 2, "Casa");
        dm.CreaHabitatge(1222, 2, "XXXXXX", 1, 2, "Casa");
        dm.GuardaEdificiDiscText(dm.ObteEdifici("edu") , "Default", true);
        dm.GuardaEdificiDiscText(dm.ObteEdifici("mar") , "Default", true);
        dm.GuardaEdificiDiscText(dm.ObteEdifici("TTTTTT") , "Tunned", true);
        dm.GuardaEdificiDiscText(dm.ObteEdifici("XXXXXX") , "Tunned", true);
        dm.EliminarEdifici("edu");
        dm.EliminarEdifici("mar");
        dm.CarregaCatalegEdifici("Default");
        l = dm.LlistaCatalegEdificisDisc();
        for(String n: l){
            System.out.println(n);
        }
    }
}
