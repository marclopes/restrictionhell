package barri;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import barri.Habitatge.tipusHab;
import java.util.ArrayList;


public class DriverHabitatge{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip, c;
                tipusHab t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Habitatge. ");
                System.out.println("Crea un Habitatge.");
                
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
                
                Habitatge hab = new Habitatge(imp,apc, nom, codi, h, cap, t);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar nom.");
                System.out.println("2. Consultar identificador.");
                System.out.println("3. Consultar alçada.");
                System.out.println("4. Consultar capacitat.");
                System.out.println("5. Consultar clases.");
                System.out.println("6. Consultar impostos.");
                System.out.println("7. Consultar aparcament.");
                System.out.println("8. Consultar tipus d'habitatge.");
                System.out.println("9. Pertany a la classe...");
                System.out.println("10. Consultar subclase.");
                System.out.println("11. Modificar nom.");
                System.out.println("12. Modificar identificador.");
                System.out.println("13. Modificar alçada.");
                System.out.println("14. Modificar capacitat.");
                System.out.println("15. Afegir clase.");
                System.out.println("16. Eliminar clase.");
                System.out.println("17. Modificar impostos.");
                System.out.println("18. Modificar aparcament. ");
                System.out.println("19. Modificar tipus d'habitatge.");
                System.out.println("20. Mostrar opcions.");
                System.out.println("21. Sortir");
                
                while(opt != 21){
                    System.out.print("> ");
                    in = br.readLine();
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Nom: " + hab.ConsultarNom());
                            break;
                        case 2:
                            System.out.println("Codi: " + hab.ConsultarCodi());
                            break;
                        case 3:
                            System.out.println("Alçada: " + hab.ConsultarH());
                            break;
                        case 4:
                            System.out.println("Capacitat: " + hab.ConsultarCapacitat());
                            break;
                        case 5:
                            ArrayList<Classes> cl;
                            cl = hab.ConsultarClases();
                            System.out.println("Aquest habitatge pertany a la/les clase/es:");
                            System.out.println("");
                            for(Classes clase: cl){
                                if(clase == Classes.Alta){System.out.println("Alta");}
                                if(clase == Classes.Mitja){System.out.println("Mitja");}
                                if(clase == Classes.Baixa){System.out.println("Baixa");}
                            }
                            break;
                        case 6:
                            System.out.println("Impostos: " + hab.ConsultarImpost());
                            break;
                        case 7:
                            System.out.println("Aparcament: " + hab.ConsultarAparcament());
                            break;
                        case 8:
                            if(hab.consultarTipus() == tipusHab.Casa) System.out.println("Casa");
                            else if(hab.consultarTipus() == tipusHab.Pis) System.out.println("Pis");
                            else if(hab.consultarTipus() == tipusHab.Mansio) System.out.println("Mansio");
                            else if(hab.consultarTipus() == tipusHab.Xalet) System.out.println("Xalet");
                            break;
                        case 9:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            boolean ets = false;
                            if(c == 1) ets = hab.EtsClase(Classes.Alta);
                            else if(c == 2) ets = hab.EtsClase(Classes.Mitja);
                            else if(c == 3) ets = hab.EtsClase(Classes.Baixa);
                            if(ets) System.out.println("SI que pertany a la classe " + in);
                            else System.out.println("NO que pertany a la classe " + in);
                            break;
                        case 10:
                            TipusEd te;
                            te = hab.consultarSubclasse();
                            if(te == TipusEd.HAB) System.out.println("Habitatge");
                            else if(te == TipusEd.SER) System.out.println("Servei");
                            else if(te == TipusEd.NEG) System.out.println("Negoci");
                            break;
                        case 11:
                            System.out.println("Introdueix el nou nom:");
                            System.out.print("> ");
                            nom = br.readLine();
                            hab.ModificarNom(nom);
                            System.out.println("Nou nom: " + nom);
                            break;
                        case 12:
                            System.out.println("Introdueix el nou identificador:");
                            System.out.print("> ");
                            in = br.readLine();
                            codi = Integer.parseInt(in);
                            hab.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 13:
                            System.out.println("Introdueix la nova alçada:");
                            System.out.print("> ");
                            in = br.readLine();
                            h = Integer.parseInt(in);
                            hab.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                        case 14:
                            System.out.println("Introdueix la nova capacitat:");
                            System.out.print("> ");
                            in = br.readLine();
                            cap = Integer.parseInt(in);
                            hab.ModificarCapacitat(cap);
                            System.out.println("Nou capacitat: " + cap);
                            break;
                        case 15:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            if(c == 1) hab.AfegirClase(Classes.Alta);
                            else if(c == 2) hab.AfegirClase(Classes.Mitja);
                            else if(c == 3) hab.AfegirClase(Classes.Baixa);
                            break;
                        case 16:
                            System.out.println("Eliminar classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            if(c == 1) hab.EliminarClase(Classes.Alta);
                            else if(c == 2) hab.EliminarClase(Classes.Mitja);
                            else if(c == 3) hab.EliminarClase(Classes.Baixa);
                            break;
                        case 17:
                            System.out.println("Introdueix el nou impost:");
                            System.out.print("> ");
                            in = br.readLine();
                            imp = Integer.parseInt(in);
                            hab.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 18:
                            System.out.println("Introdueix el nou aparcament:");
                            System.out.print("> ");
                            in = br.readLine();
                            apc = Integer.parseInt(in);
                            hab.ModificarAparcament(apc);
                            System.out.println("Nou aparcament: " + apc);
                            break;
                        case 19:
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
                        case 20:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar nom.");
                            System.out.println("2. Consultar identificador.");
                            System.out.println("3. Consultar alçada.");
                            System.out.println("4. Consultar capacitat.");
                            System.out.println("5. Consultar clases.");
                            System.out.println("6. Consultar impostos.");
                            System.out.println("7. Consultar aparcament.");
                            System.out.println("8. Consultar tipus d'habitatge.");
                            System.out.println("9. Pertany a la classe...");
                            System.out.println("10. Consultar subclase.");
                            System.out.println("11. Modificar nom.");
                            System.out.println("12. Modificar identificador.");
                            System.out.println("13. Modificar alçada.");
                            System.out.println("14. Modificar capacitat.");
                            System.out.println("15. Afegir clase.");
                            System.out.println("16. Eliminar clase.");
                            System.out.println("17. Modificar impostos.");
                            System.out.println("18. Modificar aparcament. ");
                            System.out.println("19. Modificar tipus d'habitatge.");
                            System.out.println("20. Mostrar opcions.");
                            System.out.println("21. Sortir");
                            break;
                        case 21:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}