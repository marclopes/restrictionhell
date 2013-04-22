/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author eDU
 */
public class DriverServei {
    
    public static void main() throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, cost, mant, ai;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Servei. ");
                System.out.println("Crea un Servei.");
                
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
                
                System.out.println("Introdueix el cost:");
                in = br.readLine();
                cost = Integer.parseInt(in);
                
                System.out.println("Introdueix el cost de manteniment:");
                in = br.readLine();
                mant = Integer.parseInt(in);
                
                System.out.println("Introdueix l'area d'influencia:");
                in = br.readLine();
                ai = Integer.parseInt(in);
                
                Servei ser = new Servei(cost,mant, ai,nom, codi, h, cap);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar cost.");
                System.out.println("2. Consultar cost de manteniment.");
                System.out.println("3. Consultar area d'influencia.");
                System.out.println("4. Modificar cost. ");
                System.out.println("5. Modificar cost de manteniment.");
                System.out.println("6. Modificar area d'influencia.");
                System.out.println("7. Mostrar opcions.");
                System.out.println("8. Sortir");
                
                while(opt != 8){
                    in = br.readLine();
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Cost: " + ser.ConsultarCost());
                            break;
                        case 2:
                            System.out.println("Cost de manteniment: " + ser.ConsultarManteniment());
                            break;
                        case 3:
                            System.out.println("Area d'influencia: " + ser.ConsultarAreaInfluencia());
                            break;
                        case 4:
                            in = br.readLine();
                            cost = Integer.parseInt(in);
                            ser.ModificarCost(cost);
                            System.out.println("Nou impost: " + cost);
                            break;
                        case 5:
                            in = br.readLine();
                            mant = Integer.parseInt(in);
                            ser.ModificarManteniment(mant);
                            System.out.println("Nou cost de manteniment: " + mant);
                            break;
                        case 6:
                            in = br.readLine();
                            ai = Integer.parseInt(in);
                            ser.ModificarAreaInfluencia(ai);
                            System.out.println("Nova area d'influencia: " + ai);
                            break;
                        case 7:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar impostos.");
                            System.out.println("2. Consultar aparcament.");
                            System.out.println("3. Modificar impostos.");
                            System.out.println("4. Modificar aparcament. ");
                            System.out.println("5. Mostrar opcions.");
                            System.out.println("6. Sortir");
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}
