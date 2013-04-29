package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import barri.Negoci.tipusNegoci;


public class DriverNegoci{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip;
                tipusNegoci t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Negoci. ");
                System.out.println("Crea un Negoci.");
                
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
                
                System.out.println("Selecciona el tipus de negoci:");
                System.out.println("1. Banc");
                System.out.println("2. Bar");
                System.out.println("3. Botiga d'alimentació");
                System.out.println("4. Botiga de roba");
                System.out.println("5. Clinica");
                System.out.println("6. Discoteca");
                System.out.println("7. Escola privada");
                System.out.println("8. Restaurant");
                
                opcio = true;
                while(opcio){
                    System.out.print("> ");
                    in = br.readLine();
                    tip = Integer.parseInt(in);
                    opcio = false;
                    if(tip == 1) t = tipusNegoci.Banc;
                    else if(tip == 2) t = tipusNegoci.Bar;
                    else if(tip == 3) t = tipusNegoci.Botiga_alimentacio;
                    else if(tip == 4) t = tipusNegoci.Botiga_roba;
                    else if(tip == 5) t = tipusNegoci.Clinica;
                    else if(tip == 6) t = tipusNegoci.Discoteca;
                    else if(tip == 7) t = tipusNegoci.Escola_privada;
                    else if(tip == 8) t = tipusNegoci.Restaurant;
                    else {
                        System.out.println("Opció incorrecte. Torna-ho a provar...");
                        opcio = true;
                    }
                }
                Negoci hab = new Negoci(imp,apc, nom, codi, h, cap, t);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar impostos.");
                System.out.println("2. Consultar aparcament.");
                System.out.println("3. Consultar tipus de negoci.");
                System.out.println("4. Modificar impostos.");
                System.out.println("5. Modificar aparcament. ");
                System.out.println("6. Modificar tipus de negoci.");
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
                            if(hab.consultarTipus() == tipusNegoci.Banc) System.out.println("Banc");
                            else if(hab.consultarTipus() == tipusNegoci.Bar) System.out.println("Bar");
                            else if(hab.consultarTipus() == tipusNegoci.Botiga_alimentacio) System.out.println("Botiga d'alimentació");
                            else if(hab.consultarTipus() == tipusNegoci.Botiga_roba) System.out.println("Botiga de roba");
                            else if(hab.consultarTipus() == tipusNegoci.Clinica) System.out.println("Clínica");
                            else if(hab.consultarTipus() == tipusNegoci.Discoteca) System.out.println("Discoteca");
                            else if(hab.consultarTipus() == tipusNegoci.Escola_privada) System.out.println("Escola privada");
                            else if(hab.consultarTipus() == tipusNegoci.Restaurant) System.out.println("Restaurant");
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
                            System.out.println("Selecciona el tipus de negoci:");
                            System.out.println("1. Consultar impostos.");
                            System.out.println("2. Consultar aparcament.");
                            System.out.println("3. Consultar tipus de negoci.");
                            System.out.println("4. Modificar impostos.");
                            System.out.println("5. Modificar aparcament. ");
                            System.out.println("6. Modificar tipus de negoci.");
                            System.out.println("7. Mostrar opcions.");
                            System.out.println("8. Sortir");
                            
                            t = null;
                            opcio = true;
                            while(opcio){
                                System.out.print("> ");
                                in = br.readLine();
                                tip = Integer.parseInt(in);
                                
                                opcio = false;
                                if(tip == 1) t = tipusNegoci.Banc;
                                else if(tip == 2) t = tipusNegoci.Bar;
                                else if(tip == 3) t = tipusNegoci.Botiga_alimentacio;
                                else if(tip == 4) t = tipusNegoci.Botiga_roba;
                                else if(tip == 5) t = tipusNegoci.Clinica;
                                else if(tip == 6) t = tipusNegoci.Discoteca;
                                else if(tip == 7) t = tipusNegoci.Escola_privada;
                                else if(tip == 8) t = tipusNegoci.Restaurant;
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