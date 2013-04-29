package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import barri.Habitatge.tipusHab;


public class DriverHabitatge{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip;
                tipusHab t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Habitatge. ");
                System.out.println("Crea un Habitatge.");
                
                System.out.println("Introdueix el nom: ");
                System.out.print("> ");
                nom = br.readLine();
                
                System.out.println("Introdueix l'identificador: ");
                System.out.print("> ");
                in = br.readLine();
                codi = Integer.parseInt(in);
                
                System.out.println("Introdueix l'alçada: ");
                System.out.print("> ");
                in = br.readLine();
                h = Integer.parseInt(in);
                
                System.out.println("Introdueix la capacitat: ");
                System.out.print("> ");
                in = br.readLine();
                cap = Integer.parseInt(in);
                
                System.out.println("Introdueix els impostos:");
                System.out.print("> ");
                in = br.readLine();
                imp = Integer.parseInt(in);
                
                System.out.println("Introdueix l'aparcament:");
                System.out.print("> ");
                in = br.readLine();
                apc = Integer.parseInt(in);
                
                System.out.println("Selecciona el tipus d'habitatge:");
                System.out.println("1. Casa");
                System.out.println("2. Pis");
                System.out.println("3. Mansio");
                System.out.println("4. Xalet");
                
                opcio = true;
                while(opcio){
                    System.out.print("> ");
                    in = br.readLine();
                    tip = Integer.parseInt(in);
                    opcio = false;
                    if(tip == 1) t = tipusHab.Casa;
                    else if(tip == 2) t = tipusHab.Pis;
                    else if(tip == 3) t = tipusHab.Mansio;
                    else if(tip == 4) t = tipusHab.Xalet;
                    else {
                        System.out.println("Opció incorrecte. Torna-ho a provar...");
                        opcio = true;
                    }
                }
                Habitatge hab = new Habitatge(imp,apc, nom, codi, h, cap, t);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar impostos.");
                System.out.println("2. Consultar aparcament.");
                System.out.println("3. Consultar tipus d'habitatge.");
                System.out.println("4. Modificar impostos.");
                System.out.println("5. Modificar aparcament. ");
                System.out.println("6. Modificar tipus d'habitatge.");
                System.out.println("7. Mostrar opcions.");
                System.out.println("8. Sortir");
                
                while(opt != 8){
                    System.out.print("> ");
                    in = br.readLine();
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Impostos: " + hab.ConsultarImpost());
                            break;
                        case 2:
                            System.out.println("Aparcament: " + hab.ConsultarAparcament());
                            break;
                        case 3:
                            if(hab.consultarTipus() == tipusHab.Casa) System.out.println("Casa");
                            else if(hab.consultarTipus() == tipusHab.Pis) System.out.println("Pis");
                            else if(hab.consultarTipus() == tipusHab.Mansio) System.out.println("Mansio");
                            else if(hab.consultarTipus() == tipusHab.Xalet) System.out.println("Xalet");
                            break;
                        case 4:
                            System.out.println("Introdueix el nou impost:");
                            System.out.print("> ");
                            in = br.readLine();
                            imp = Integer.parseInt(in);
                            hab.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 5:
                            System.out.println("Introdueix el nou aparcament:");
                            System.out.print("> ");
                            in = br.readLine();
                            apc = Integer.parseInt(in);
                            hab.ModificarAparcament(apc);
                            System.out.println("Nou aparcament: " + apc);
                            break;
                        case 6:
                            System.out.println("Selecciona el tipus d'habitatge:");
                            System.out.println("1. Casa");
                            System.out.println("2. Pis");
                            System.out.println("3. Mansio");
                            System.out.println("4. Xalet");
                            
                            t = null;
                            opcio = true;
                            while(opcio){
                                System.out.print("> ");
                                in = br.readLine();
                                tip = Integer.parseInt(in);
                                
                                opcio = false;
                                if(tip == 1) t = tipusHab.Casa;
                                else if(tip == 2) t = tipusHab.Pis;
                                else if(tip == 3) t = tipusHab.Mansio;
                                else if(tip == 4) t = tipusHab.Xalet;
                                else {
                                    System.out.println("Opció incorrecte. Torna-ho a provar...");
                                    opcio = true;
                                }
                            }
                            hab.modificarTipus(t);
                            break;
                        case 7:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar impostos.");
                            System.out.println("2. Consultar aparcament.");
                            System.out.println("3. Consultar tipus d'habitatge.");
                            System.out.println("4. Modificar impostos.");
                            System.out.println("5. Modificar aparcament. ");
                            System.out.println("6. Modificar tipus d'habitatge.");
                            System.out.println("7. Mostrar opcions.");
                            System.out.println("8. Sortir");
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}