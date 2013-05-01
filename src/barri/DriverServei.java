package barri;

import barri.Edifici.Classes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import barri.Edifici.TipusEd;
import barri.Servei.TipusServei;

public class DriverServei{
    
	public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, cost, mant, tip, c, err, ai;
                TipusServei t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Servei.");
                System.out.println("###########################");
                System.out.println("");
                System.out.println("Crea un SERVEI:");
                System.out.println("");
                System.out.println("Selecciona el tipus de servei:");
                System.out.println("");
                System.out.println("1. Bombers");
                System.out.println("2. Centre cultural");
                System.out.println("3. Escola");
                System.out.println("4. Hospital");
                System.out.println("5. Parc");
                System.out.println("6. Policia");
                System.out.println("7. Preso");
                
                opcio = true;
                while(opcio){
                    System.out.print("> ");
                    in = br.readLine();
                    try{
                        tip = Integer.parseInt(in);

                        opcio = false;
                        if(tip == 1) t = TipusServei.Bombers;
                            else if(tip == 2) t = TipusServei.Centre_Cultural;
                            else if(tip == 3) t = TipusServei.Escola;
                            else if(tip == 4) t = TipusServei.Hospital;
                            else if(tip == 5) t = TipusServei.Parc;
                            else if(tip == 6) t = TipusServei.Policia;
                            else if(tip == 7) t = TipusServei.Preso;
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
                
                System.out.println("Introdueix el cost de construccio: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                cost = err;
                
                System.out.println("Introdueix el cost de manteniment: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                mant = err;
                
                System.out.println("Introdueix l'area d'influencia: ");
                err = -1000;
                while (err == -1000){
                    System.out.print("> ");
                    in = br.readLine();
                    err = LlegirEnter(in);
                }
                ai = err;
                
                Servei ser = new Servei(cost,mant, ai,nom, codi, h, cap, t);
                
                System.out.println("");
                
                int opt = 0;
                
                System.out.println("Opcions:");
                System.out.println("1. Consultar nom.");
                System.out.println("2. Consultar identificador.");
                System.out.println("3. Consultar alçada.");
                System.out.println("4. Consultar capacitat.");
                System.out.println("5. Consultar clases.");
                System.out.println("6. Consultar cost.");
                System.out.println("7. Consultar cost de manteniment.");
                System.out.println("8. Consultar area d'influencia.");
                System.out.println("9. Consultar tipus de servei.");
                System.out.println("10. Pertany a la classe...");
                System.out.println("11. Consultar subclase.");
                System.out.println("12. Modificar nom.");
                System.out.println("13. Modificar identificador.");
                System.out.println("14. Modificar alçada.");
                System.out.println("15. Modificar capacitat.");
                System.out.println("16. Afegir clase.");
                System.out.println("17. Eliminar clase.");
                System.out.println("18. Modificar cost. ");
                System.out.println("19. Modificar cost de manteniment.");
                System.out.println("20. Modificar area d'influencia.");
                System.out.println("21. Modificar tipus de servei.");
                System.out.println("22. Mostrar opcions.");
                System.out.println("23. Sortir");
                
                while(opt != 23){
                    System.out.print("Opció: ");
                    in = br.readLine();
                    opt = LlegirEnter(in);
                    switch(opt){
                        case 1:
                            System.out.println("Nom: " + ser.ConsultarNom());
                            break;
                        case 2:
                            System.out.println("Codi: " + ser.ConsultarCodi());
                            break;
                        case 3:
                            System.out.println("Alçada: " + ser.ConsultarH());
                            break;
                        case 4:
                            System.out.println("Capacitat: " + ser.ConsultarCapacitat());
                            break;
                        case 5:
                            ArrayList<Classes> cl;
                            cl = ser.ConsultarClases();
                            if (cl != null){
                                System.out.println("Aquest Servei pertany a la/les clase/es:");
                                System.out.println("");
                                for(Classes clase: cl){
                                    if(clase == Classes.Alta){System.out.println("Alta");}
                                    if(clase == Classes.Mitja){System.out.println("Mitja");}
                                    if(clase == Classes.Baixa){System.out.println("Baixa");}
                                }
                            }
                            else{
                                System.out.println("Aquest servei no pertany a cap classe.");
                            }
                            break;
                        case 6:
                            System.out.println("Impostos: " + ser.ConsultarCost());
                            break;
                        case 7:
                            System.out.println("Aparcament: " + ser.ConsultarManteniment());
                            break;
                        case 8:
                            System.out.println("area d'influencia: " + ser.ConsultarAreaInfluencia());
                            break;
                        case 9:
                            if(ser.consultarTipus() == TipusServei.Bombers) System.out.println("Bombers");
                            else if(ser.consultarTipus() == TipusServei.Centre_Cultural) System.out.println("Centre cultural");
                            else if(ser.consultarTipus() == TipusServei.Escola) System.out.println("Escola");
                            else if(ser.consultarTipus() == TipusServei.Hospital) System.out.println("Hospital");
                            else if(ser.consultarTipus() == TipusServei.Parc) System.out.println("Parc");
                            else if(ser.consultarTipus() == TipusServei.Policia) System.out.println("Policia");
                            else if(ser.consultarTipus() == TipusServei.Preso) System.out.println("Presó");
                            break;
                        case 10:
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
                                    if(err == 1) ets = ser.EtsClase(Classes.Alta);
                                    else if(err == 2) ets = ser.EtsClase(Classes.Mitja);
                                    else if(err == 3) ets = ser.EtsClase(Classes.Baixa);
                                    if(ets) System.out.println("SI que pertany a la classe " + in);
                                    else System.out.println("NO que pertany a la classe " + in);
                                }
                            }
                            break;
                        case 11:
                            TipusEd te;
                            te = ser.consultarSubclasse();
                            if(te == TipusEd.HAB) System.out.println("Habitatge");
                            else if(te == TipusEd.SER) System.out.println("Servei");
                            else if(te == TipusEd.NEG) System.out.println("Negoci");
                            break;
                        case 12:
                            System.out.println("Introdueix el nou nom:");
                            System.out.print("> ");
                            nom = br.readLine();
                            ser.ModificarNom(nom);
                            System.out.println("Nou nom: " + nom);
                            break;
                        case 13:
                            System.out.println("Introdueix el nou identificador:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            codi = err;
                            ser.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 14:
                            System.out.println("Introdueix la nova alçada:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            h = err;
                            ser.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                            break;
                        case 15:
                            System.out.println("Introdueix la nova capacitat:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            cap = err;
                            ser.ModificarCapacitat(cap);
                            System.out.println("Nova capacitat: " + cap);
                            break;
                        case 16:
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
                            if(err == 1) ser.AfegirClase(Classes.Alta);
                            else if(err == 2) ser.AfegirClase(Classes.Mitja);
                            else if(err == 3) ser.AfegirClase(Classes.Baixa);
                            break;
                        case 17:
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
                                if(ser.EtsClase(Classes.Alta)){
                                    ser.EliminarClase(Classes.Alta);
                                    System.out.println("El servei ja no pertany a la classe alta.");
                                }
                                else System.out.println("No es pot eliminar la classe alta perque el servei no hi pertany.");
                            }
                            else if(err == 2){
                                if(ser.EtsClase(Classes.Mitja)){
                                    ser.EliminarClase(Classes.Mitja);
                                    System.out.println("El servei ja no pertany a la classe mitja.");
                                }
                                else System.out.println("No es pot eliminar la classe mitja perque el servei no hi pertany.");
                            }
                            else if(err == 3){
                                if(ser.EtsClase(Classes.Baixa)){
                                    ser.EliminarClase(Classes.Baixa);
                                    System.out.println("El servei ja no pertany a la classe baixa.");
                                }
                                else{
                                    System.out.println("No es pot eliminar la classe baixa perque servei no hi pertany.");
                                }
                                
                            }
                            break;
                        case 18:
                            System.out.println("Introdueix el nou cost de construccio:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            cost = err;
                            ser.ModificarCost(cost);
                            System.out.println("Nou cost de construcció: " + cost);
                            break;
                        case 19:
                            System.out.println("Introdueix el nou cost de manteniment:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            mant = err;
                            ser.ModificarManteniment(mant);
                            System.out.println("Nou cost de manteniment: " + mant);
                            break;
                        case 20:
                            System.out.println("Introdueix el nou cost de manteniment:");
                            err = -1000;
                            while(err == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                err = LlegirEnter(in);
                                if(err == -1000)System.out.println("Torna-ho a provar...");
                            }
                            ai = err;
                            ser.ModificarManteniment(ai);
                            System.out.println("Nou cost de manteniment: " + ai);
                            break;
                        case 21:
                            System.out.println("Selecciona el nou tipus de negoci:");
                            System.out.println("");
                            System.out.println("1. Bombers");
                            System.out.println("2. Centre cultural");
                            System.out.println("3. Escola");
                            System.out.println("4. Hospital");
                            System.out.println("5. Parc");
                            System.out.println("6. Policia");
                            System.out.println("7. Preso");

                            opcio = true;
                            while(opcio){
                                System.out.print("> ");
                                in = br.readLine();
                                try{
                                    tip = Integer.parseInt(in);

                                    opcio = false;
                                    if(tip == 1) t = TipusServei.Bombers;
                                    else if(tip == 2) t = TipusServei.Centre_Cultural;
                                    else if(tip == 3) t = TipusServei.Escola;
                                    else if(tip == 4) t = TipusServei.Hospital;
                                    else if(tip == 5) t = TipusServei.Parc;
                                    else if(tip == 6) t = TipusServei.Policia;
                                    else if(tip == 7) t = TipusServei.Preso;
                                    else {
                                        System.out.println("Opció incorrecte. Torna-ho a provar...");
                                        opcio = true;
                                    }
                                }
                                catch(NumberFormatException e){
                                    System.out.println("ERROR: " + in + " no és una opció vàlida");
                                }
                            }
                            ser.modificarTipus(t);
                            break;
                        case 22:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar nom.");
                            System.out.println("2. Consultar identificador.");
                            System.out.println("3. Consultar alçada.");
                            System.out.println("4. Consultar capacitat.");
                            System.out.println("5. Consultar clases.");
                            System.out.println("6. Consultar impostos.");
                            System.out.println("7. Consultar aparcament.");
                            System.out.println("8. Consultar tipus de servei.");
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
                            System.out.println("19. Modificar tipus de servei.");
                            System.out.println("20. Mostrar opcions.");
                            System.out.println("21. Sortir");
                            break;
                        case 23:
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