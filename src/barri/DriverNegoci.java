package barri;

import barri.Negoci.tipusNegoci;
import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DriverNegoci{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip, c;
                tipusNegoci t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Negoci. ");
                System.out.println("Crea un Negoci.");
                
                System.out.println("Selecciona el tipus de negoci:");
                System.out.println("1. Banc");
                System.out.println("2. Bar");
                System.out.println("3. Botiga alimentació");
                System.out.println("4. Botiga roba");
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
                
                Negoci neg = new Negoci(imp,apc, nom, codi, h, cap, t);
                
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
                System.out.println("8. Consultar tipus de negoci.");
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
                System.out.println("19. Modificar tipus de negoci.");
                System.out.println("20. Mostrar opcions.");
                System.out.println("21. Sortir");
                
                while(opt != 21){
                    System.out.print("Opció: ");
                    in = br.readLine();
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Nom: " + neg.ConsultarNom());
                            break;
                        case 2:
                            System.out.println("Codi: " + neg.ConsultarCodi());
                            break;
                        case 3:
                            System.out.println("Alçada: " + neg.ConsultarH());
                            break;
                        case 4:
                            System.out.println("Capacitat: " + neg.ConsultarCapacitat());
                            break;
                        case 5:
                            ArrayList<Classes> cl;
                            cl = neg.ConsultarClases();
                            if (cl != null){
                                System.out.println("Aquest Negoci pertany a la/les clase/es:");
                                System.out.println("");
                                for(Classes clase: cl){
                                    if(clase == Classes.Alta){System.out.println("Alta");}
                                    if(clase == Classes.Mitja){System.out.println("Mitja");}
                                    if(clase == Classes.Baixa){System.out.println("Baixa");}
                                }
                            }
                            else{
                                System.out.println("Aquest negoci no pertany a cap classe.");
                            }
                            break;
                        case 6:
                            System.out.println("Impostos: " + neg.ConsultarImpost());
                            break;
                        case 7:
                            System.out.println("Aparcament: " + neg.ConsultarAparcament());
                            break;
                        case 8:
                            if(neg.consultarTipus() == tipusNegoci.Banc) System.out.println("Banc");
                            else if(neg.consultarTipus() == tipusNegoci.Bar) System.out.println("Bar");
                            else if(neg.consultarTipus() == tipusNegoci.Botiga_alimentacio) System.out.println("Botiga d'alimentació");
                            else if(neg.consultarTipus() == tipusNegoci.Botiga_roba) System.out.println("Botiga de roba");
                            else if(neg.consultarTipus() == tipusNegoci.Clinica) System.out.println("Clinica");
                            else if(neg.consultarTipus() == tipusNegoci.Discoteca) System.out.println("Discoteca");
                            else if(neg.consultarTipus() == tipusNegoci.Escola_privada) System.out.println("Escola privada");
                            else if(neg.consultarTipus() == tipusNegoci.Restaurant) System.out.println("Restaurant");
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
                            if(c == 1) ets = neg.EtsClase(Classes.Alta);
                            else if(c == 2) ets = neg.EtsClase(Classes.Mitja);
                            else if(c == 3) ets = neg.EtsClase(Classes.Baixa);
                            if(ets) System.out.println("SI que pertany a la classe ");
                            else System.out.println("NO que pertany a la classe ");
                            break;
                        case 10:
                            TipusEd te;
                            te = neg.consultarSubclasse();
                            if(te == TipusEd.HAB) System.out.println("Habitatge");
                            else if(te == TipusEd.SER) System.out.println("Servei");
                            else if(te == TipusEd.NEG) System.out.println("Negoci");
                            break;
                        case 11:
                            System.out.println("Introdueix el nou nom:");
                            System.out.print("> ");
                            nom = br.readLine();
                            neg.ModificarNom(nom);
                            System.out.println("Nou nom: " + nom);
                            break;
                        case 12:
                            System.out.println("Introdueix el nou identificador:");
                            System.out.print("> ");
                            in = br.readLine();
                            codi = Integer.parseInt(in);
                            neg.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 13:
                            System.out.println("Introdueix la nova alçada:");
                            System.out.print("> ");
                            in = br.readLine();
                            h = Integer.parseInt(in);
                            neg.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                            break;
                        case 14:
                            System.out.println("Introdueix la nova capacitat:");
                            System.out.print("> ");
                            in = br.readLine();
                            cap = Integer.parseInt(in);
                            neg.ModificarCapacitat(cap);
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
                            if(c == 1) neg.AfegirClase(Classes.Alta);
                            else if(c == 2) neg.AfegirClase(Classes.Mitja);
                            else if(c == 3) neg.AfegirClase(Classes.Baixa);
                            break;
                        case 16:
                            System.out.println("Eliminar classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            if(c == 1) neg.EliminarClase(Classes.Alta);
                            else if(c == 2) neg.EliminarClase(Classes.Mitja);
                            else if(c == 3) neg.EliminarClase(Classes.Baixa);
                            break;
                        case 17:
                            System.out.println("Introdueix el nou impost:");
                            System.out.print("> ");
                            in = br.readLine();
                            imp = Integer.parseInt(in);
                            neg.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 18:
                            System.out.println("Introdueix el nou aparcament:");
                            System.out.print("> ");
                            in = br.readLine();
                            apc = Integer.parseInt(in);
                            neg.ModificarAparcament(apc);
                            System.out.println("Nou aparcament: " + apc);
                            break;
                        case 19:
                            System.out.println("Selecciona el tipus d'habitatge:");
                            System.out.println("1. Banc");
                            System.out.println("2. Bar");
                            System.out.println("3. Botiga alimentació");
                            System.out.println("4. Botiga roba");
                            System.out.println("5. Clinica");
                            System.out.println("6. Discoteca");
                            System.out.println("7. Escola privada");
                            System.out.println("8. Restaurant");
                            
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
                            neg.modificarTipus(t);
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