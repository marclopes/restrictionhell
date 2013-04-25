package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DriverNegoci{
    
	public static void main() throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Negoci. ");
                System.out.println("Crea un Negoci.");
                
                System.out.println("Introdueix el nom: ");
                nom = br.readLine();
                
                System.out.println("Introdueix l'identificador: ");
                in = br.readLine();
                codi = Integer.parseInt(in);
                
                System.out.println("Introdueix l'alçada: ");
                in = br.readLine();
                h = Integer.parseInt(in);
                
                System.out.println("Introdueix la capacitat: ");
                in = br.readLine();
                cap = Integer.parseInt(in);
                
                System.out.println("Introdueix els impostos:");
                in = br.readLine();
                imp = Integer.parseInt(in);
                
                System.out.println("Introdueix l'aparcament:");
                in = br.readLine();
                apc = Integer.parseInt(in);
                
                Negoci neg = new Negoci(imp,apc, nom, codi, h, cap);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar impostos.");
                System.out.println("2. Consultar aparcament.");
                System.out.println("3. Modificar impostos.");
                System.out.println("4. Modificar aparcament. ");
                System.out.println("5. Mostrar opcions.");
                System.out.println("6. Sortir");
                
                while(opt != 6){
                    in = br.readLine();
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Impostos: " + neg.ConsultarImpost());
                            break;
                        case 2:
                            System.out.println("Aparcament: " + neg.ConsultarAparcament());
                            break;
                        case 3:
                            in = br.readLine();
                            imp = Integer.parseInt(in);
                            neg.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 4:
                            in = br.readLine();
                            apc = Integer.parseInt(in);
                            neg.ModificarAparcament(apc);
                            System.out.println("Nou aparcament: " + apc);
                            break;
                        case 5:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar impostos.");
                            System.out.println("2. Consultar aparcament.");
                            System.out.println("3. Modificar impostos.");
                            System.out.println("4. Modificar aparcament. ");
                            System.out.println("5. Mostrar opcions.");
                            System.out.println("6. Sortir");
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}