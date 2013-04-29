
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Edu
 */
public class DriverIlla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException{
        
        String in, nom;
        Edifici e;
        int opt = 0;
        Habitatge hab = new Habitatge(1000,3, "Casa", 180, 2, 8, tipusHab.Casa);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Driver de la classe Illa. ");
        System.out.println("");
        System.out.println("Creant una illa...");
        
        Illa illa = new Illa();
        
        System.out.println("S'ha creat una illa buida.");
        System.out.println("");
        System.out.println("Selecciona una opció:");
        System.out.println("1. Assignar edifici");
        System.out.println("2. Eliminar edifici");
        System.out.println("3. Consultar edifici");
        System.out.println("4. Consultar si es buida");
        System.out.println("5. Consultar opcions");
        System.out.println("6. Sortir");
        
        while(opt != 6){
            System.out.print("Opció: ");
            in = br.readLine();
            opt = Integer.parseInt(in);
            switch(opt){
                case 1:
                    if(illa.Empty()){
                        illa.AssignaEdifici(hab);
                        System.out.println("Edifici assignat correctament.");
                    }
                    else{System.out.println("L'illa ja conté un edifici.");}
                    break;
                case 2:
                    if(!illa.Empty()){
                        illa.EliminaEdifici();
                        System.out.println("Edifici eliminat correctament.");
                    }
                    else{System.out.println("L'illa no conté cap edifici.");}
                    break;
                case 3:
                    if(!illa.Empty()){
                        e = illa.ConsultaEdifici();
                        nom = e.ConsultarNom();
                        System.out.println("El nom de l'edifici es:" + nom);
                    }
                    else{System.out.println("L'illa no conté cap edifici.");}
                    break;
                case 4:
                    if(illa.Empty())System.out.println("L'illa té assignat un edifici.");
                    else System.out.println("L'illa no conté cap edifici.");
                    break;
                case 5:
                    System.out.println("1. Assignar edifici");
                    System.out.println("2. Eliminar edifici");
                    System.out.println("3. Consultar edifici");
                    System.out.println("4. Consultar si es buida");
                    System.out.println("5. Consultar opcions");
                    System.out.println("6. Sortir");
                    break;
                case 6:
                    break;
                default:
            }
        }   
    }
}
