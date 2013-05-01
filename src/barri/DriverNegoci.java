package barri;

import barri.Edifici.Classes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import barri.Edifici.TipusEd;
import barri.Negoci.TipusNegoci;

public class DriverNegoci{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, imp, apc, tip, c, err;
                TipusNegoci t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Negoci.");
                System.out.println("###########################");
                System.out.println("");
                System.out.println("Crea un NEGOCI:");
                System.out.println("");
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
                    try{
                        tip = Integer.parseInt(in);

                        opcio = false;
                        if(tip == 1) t = Negoci.TipusNegoci.Banc;
                        else if(tip == 2) t = Negoci.TipusNegoci.Bar;
                        else if(tip == 3) t = Negoci.TipusNegoci.Botiga_alimentacio;
                        else if(tip == 4) t = Negoci.TipusNegoci.Botiga_roba;
                        else if(tip == 5) t = Negoci.TipusNegoci.Clinica;
                        else if(tip == 6) t = Negoci.TipusNegoci.Discoteca;
                        else if(tip == 7) t = Negoci.TipusNegoci.Escola_privada;
                        else if(tip == 8) t = Negoci.TipusNegoci.Restaurant;
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
                    opt = LlegirEnter(in);
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
                            System.out.println("Impostos: " + neg.ConsultarImpost());
                            break;
                        case 7:
                            System.out.println("Aparcament: " + neg.ConsultarAparcament());
                            break;
                        case 8:
                            if(neg.consultarTipus() == TipusNegoci.Banc) System.out.println("Banc");
                            else if(neg.consultarTipus() == TipusNegoci.Bar) System.out.println("Bar");
                            else if(neg.consultarTipus() == TipusNegoci.Botiga_alimentacio) System.out.println("Botiga d'alimentació");
                            else if(neg.consultarTipus() == TipusNegoci.Botiga_roba) System.out.println("Botiga de roba");
                            else if(neg.consultarTipus() == TipusNegoci.Clinica) System.out.println("Clinica");
                            else if(neg.consultarTipus() == TipusNegoci.Discoteca) System.out.println("Discoteca");
                            else if(neg.consultarTipus() == TipusNegoci.Escola_privada) System.out.println("Escola privada");
                            else if(neg.consultarTipus() == TipusNegoci.Restaurant) System.out.println("Restaurant");
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
                                err = LlegirEnter(in);
                                
                                if(err < 1 || err > 3) System.out.println("Opció incorrecte. Torna-ho a provar...");
                                else{
                                    boolean ets = false;
                                    if(err == 1) ets = neg.EtsClase(Classes.Alta);
                                    else if(err == 2) ets = neg.EtsClase(Classes.Mitja);
                                    else if(err == 3) ets = neg.EtsClase(Classes.Baixa);
                                    if(ets) System.out.println("SI que pertany a la classe " + in);
                                    else System.out.println("NO que pertany a la classe " + in);
                                }
                            }
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
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            codi = err;
                            neg.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 13:
                            System.out.println("Introdueix la nova alçada:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            h = err;
                            neg.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                            break;
                        case 14:
                            System.out.println("Introdueix la nova capacitat:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            cap = err;
                            neg.ModificarCapacitat(cap);
                            System.out.println("Nova capacitat: " + cap);
                            break;
                        case 15:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err < 1 || err > 3) System.out.println("Torna-ho a provar...");
                            }
                            if(err == 1) neg.AfegirClase(Classes.Alta);
                            else if(err == 2) neg.AfegirClase(Classes.Mitja);
                            else if(err == 3) neg.AfegirClase(Classes.Baixa);
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
                                err = LlegirEnter(in);
                                if(err < 1 || err > 3) System.out.println("Torna-ho a provar...");
                            }
                            if(err == 1){
                                if(neg.EtsClase(Classes.Alta)){
                                    neg.EliminarClase(Classes.Alta);
                                    System.out.println("El negoci ja no pertany a la classe alta.");
                                }
                                else System.out.println("No es pot eliminar la classe alta perque el negoci no hi pertany.");
                            }
                            else if(err == 2){
                                if(neg.EtsClase(Classes.Mitja)){
                                    neg.EliminarClase(Classes.Mitja);
                                    System.out.println("El negoci ja no pertany a la classe mitja.");
                                }
                                else System.out.println("No es pot eliminar la classe mitja perque el negoci no hi pertany.");
                            }
                            else if(err == 3){
                                if(neg.EtsClase(Classes.Baixa)){
                                    neg.EliminarClase(Classes.Baixa);
                                    System.out.println("El negoci ja no pertany a la classe baixa.");
                                }
                                else{
                                    System.out.println("No es pot eliminar la classe baixa perque negoci no hi pertany.");
                                }
                                
                            }
                            break;
                        case 17:
                            System.out.println("Introdueix el nou impost:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            imp = err;
                            neg.ModificarImpost(imp);
                            System.out.println("Nou impost: " + imp);
                            break;
                        case 18:
                            System.out.println("Introdueix el nou aparcament:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            apc = err;
                            neg.ModificarAparcament(apc);
                            System.out.println("Nou aparcament: " + apc);
                            break;
                        case 19:
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
                                try{
                                    tip = Integer.parseInt(in);

                                    opcio = false;
                                    if(tip == 1) t = Negoci.TipusNegoci.Banc;
                                    else if(tip == 2) t = Negoci.TipusNegoci.Bar;
                                    else if(tip == 3) t = Negoci.TipusNegoci.Botiga_alimentacio;
                                    else if(tip == 4) t = Negoci.TipusNegoci.Botiga_roba;
                                    else if(tip == 5) t = Negoci.TipusNegoci.Clinica;
                                    else if(tip == 6) t = Negoci.TipusNegoci.Discoteca;
                                    else if(tip == 7) t = Negoci.TipusNegoci.Escola_privada;
                                    else if(tip == 8) t = Negoci.TipusNegoci.Restaurant;
                                    else {
                                        System.out.println("Opció incorrecte. Torna-ho a provar...");
                                        opcio = true;
                                    }
                                }
                                catch(NumberFormatException e){
                                    System.out.println("ERROR: " + in + " no és una opció vàlida");
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