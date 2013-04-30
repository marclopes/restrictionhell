package barri;

import barri.Edifici.Classes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import barri.Edifici.TipusEd;
import barri.Habitatge.tipusHab;





public class DriverHabitatge{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip, c, err;
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
                    try{
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
                    catch(NumberFormatException e){
                        System.out.println("ERROR: " + in + " no és una opció vàlida");
                    }
                }
                
                System.out.println("Introdueix el nom: ");
                System.out.print("> ");
                nom = br.readLine();
                
                System.out.println("Introdueix l'identificador: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                codi = err;
                
                System.out.println("Introdueix l'alçada: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                h = err;
                
                System.out.println("Introdueix la capacitat: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                cap = err;
                
                System.out.println("Introdueix els impostos: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                imp = err;
                
                System.out.println("Introdueix l'aparcament: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                apc = err;
                
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
                    opt = LlegirEnter(in);
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
                            if (cl != null){
                                System.out.println("Aquest habitatge pertany a la/les clase/es:");
                                System.out.println("");
                                for(Classes clase: cl){
                                    if(clase == Classes.Alta){System.out.println("Alta");}
                                    if(clase == Classes.Mitja){System.out.println("Mitja");}
                                    if(clase == Classes.Baixa){System.out.println("Baixa");}
                                }
                            }
                            else{
                                System.out.println("Aquest habitatge no pertany a cap classe.");
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
                            System.out.println("Pertany a la classe... ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                c = LlegirEnter(in);
                                if(c < 1 || c > 3) System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            c = err;
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
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = Integer.parseInt(in);
                                if(err == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            codi = err;
                            hab.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 13:
                            System.out.println("Introdueix la nova alçada:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = Integer.parseInt(in);
                                if(err == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            h = err;
                            hab.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                            break;
                        case 14:
                            System.out.println("Introdueix la nova capacitat:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = Integer.parseInt(in);
                                if(err == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            cap = err;
                            hab.ModificarCapacitat(cap);
                            System.out.println("Nou capacitat: " + cap);
                            break;
                        case 15:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                c = LlegirEnter(in);
                                if(c < 1 || c > 3) System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            c = err;
                            if(c == 1) hab.AfegirClase(Classes.Alta);
                            else if(c == 2) hab.AfegirClase(Classes.Mitja);
                            else if(c == 3) hab.AfegirClase(Classes.Baixa);
                            break;
                        case 16:
                            System.out.println("Eliminar classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                c = LlegirEnter(in);
                                if(c < 1 || c > 3) System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            c = err;
                            if(c == 1) hab.EliminarClase(Classes.Alta);
                            else if(c == 2) hab.EliminarClase(Classes.Mitja);
                            else if(c == 3) hab.EliminarClase(Classes.Baixa);
                            break;
                        case 17:
                            System.out.println("Introdueix el nou impost:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = Integer.parseInt(in);
                                if(err == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            imp = err;
                            hab.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 18:
                            System.out.println("Introdueix el nou aparcament:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = Integer.parseInt(in);
                                if(err == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                            }
                            apc = err;
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
                                try{
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
                                catch(NumberFormatException e){
                                    System.out.println("ERROR: " + in + " no és una opció vàlida");
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
        
        private static int LlegirEnter(String s){
            int res;
            try{
                res = Integer.parseInt(s);
                return res;
            }
            catch(NumberFormatException e){
                System.out.println("ERROR: " + s + " no és una entrada vàlida");
                return -1000;
            }
        }
}