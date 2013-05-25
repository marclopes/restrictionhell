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
        dm = CtrDomGeneral.ObtenirInstancia();
        ArrayList<String> l = new ArrayList<String>();
        ArrayList<String> ed = new ArrayList<String>();
        int err = dm.CarregaCatalegEdifici("Default");
        dm.CreaCatalegRestriccions("Default");
        if(err == 0){
            
            dm.CrearRestriccioAlsada(1, 11);
            dm.CreaRestriccioAparcament(2, 200);
            dm.CrearRestriccioCost(3, 200000, true);
            dm.CreaRestriccioImpostos(4, 50000);
            dm.CreaRestriccioManteniment(5, 40000);
            
            dm.CrearRestriccioDistanciaTipus(6, 4, true, "Casa", "Casa");
            
            
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(1), "Default");
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(2), "Default");
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(3), "Default");
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(4), "Default");
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(5), "Default");
            dm.GuardaRestriccioCataleg(dm.ObteRestriccio(6), "Default");
        }
        else{
            System.out.println("Error al carregar edificis");
        }

        
        
        
        
        
        
        
        /*dm.CreaBarri("Can Tunis", "Baixa", 10, 10);
        System.out.println("Barri creat");
        dm.GuardaBarri();
        System.out.println("Barri guardat");
        l = dm.LlistaBarrisDisc();
        for(String n: l){
            System.out.println(n);
        }
        dm.CreaBarri("La Mina", "Baixa", 10, 10);
        System.out.println("Barri creat");
        dm.GuardaBarri();
        System.out.println("Barri guardat");
        dm.CarregaBarri("La Mina");
        System.out.println("Barri carregat");
        dm.CarregaCatalegEdifici("Default");
        System.out.println("Edificis carregats al barri");
        l = dm.LlistatEdificis();
        for(String n: l){
            System.out.println(n);
        }*/
        
        /*dm.CreaCatalegEdificis("Default");
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
        }*/
    }
}
