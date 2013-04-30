package barri;

import barri.Edifici.Classes;
import barri.Edifici.TipusEd;
import barri.Servei.tipusServei;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Edu
 */
public class DriverServei {
    
    public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, cost, mant, ai, tip, c;
                tipusServei t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                System.out.println("Driver de la classe Servei. ");
                System.out.println("Crea un Servei.");
                
                System.out.println("Selecciona el tipus de negoci:");
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
                    tip = Integer.parseInt(in);
                    opcio = false;
                    if(tip == 1) t = tipusServei.Bombers;
                    else if(tip == 2) t = tipusServei.Centre_Cultural;
                    else if(tip == 3) t = tipusServei.Escola;
                    else if(tip == 4) t = tipusServei.Hospital;
                    else if(tip == 5) t = tipusServei.Parc;
                    else if(tip == 6) t = tipusServei.Policia;
                    else if(tip == 7) t = tipusServei.Preso;
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
                
                System.out.println("Introdueix el cost de construcció:");
                System.out.print("> ");
                in = br.readLine();
                cost = Integer.parseInt(in);
                
                System.out.println("Introdueix el cost de manteniment:");
                System.out.print("> ");
                in = br.readLine();
                mant = Integer.parseInt(in);
                
                System.out.println("Introdueix l'area d'influencia:");
                System.out.print("> ");
                in = br.readLine();
                ai = Integer.parseInt(in);
                
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
                    opt = Integer.parseInt(in);
                    switch(opt){
                        case 1:
                            System.out.println("Cost: " + ser.ConsultarNom());
                            break;
                        case 2:
                            System.out.println("Cost: " + ser.ConsultarCodi());
                            break;
                        case 3:
                            System.out.println("Cost: " + ser.ConsultarH());
                            break;
                        case 4:
                            System.out.println("Cost: " + ser.ConsultarCapacitat());
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
                            System.out.println("Cost: " + ser.ConsultarCost());
                            break;
                        case 7:
                            System.out.println("Cost de manteniment: " + ser.ConsultarManteniment());
                            break;
                        case 8:
                            System.out.println("Area d'influencia: " + ser.ConsultarAreaInfluencia());
                            break;
                        case 9:
                            if(ser.consultarTipus() == tipusServei.Bombers) System.out.println("Bombers");
                            else if(ser.consultarTipus() == tipusServei.Centre_Cultural) System.out.println("Centre cultural");
                            else if(ser.consultarTipus() == tipusServei.Escola) System.out.println("Escola");
                            else if(ser.consultarTipus() == tipusServei.Hospital) System.out.println("Hospital");
                            else if(ser.consultarTipus() == tipusServei.Parc) System.out.println("Parc");
                            else if(ser.consultarTipus() == tipusServei.Policia) System.out.println("Policia");
                            else if(ser.consultarTipus() == tipusServei.Preso) System.out.println("Presó");
                            break;
                        case 10:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            boolean ets = false;
                            if(c == 1) ets = ser.EtsClase(Classes.Alta);
                            else if(c == 2) ets = ser.EtsClase(Classes.Mitja);
                            else if(c == 3) ets = ser.EtsClase(Classes.Baixa);
                            if(ets) System.out.println("SI que pertany a la classe ");
                            else System.out.println("NO que pertany a la classe ");
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
                            System.out.print("> ");
                            in = br.readLine();
                            codi = Integer.parseInt(in);
                            ser.ModificarId(codi);
                            System.out.println("Nou identificador: " + codi);
                            break;
                        case 14:
                            System.out.println("Introdueix la nova alçada:");
                            System.out.print("> ");
                            in = br.readLine();
                            h = Integer.parseInt(in);
                            ser.ModificarH(h);
                            System.out.println("Nova alçada: " + h);
                            break;
                        case 15:
                            System.out.println("Introdueix la nova capacitat:");
                            System.out.print("> ");
                            in = br.readLine();
                            cap = Integer.parseInt(in);
                            ser.ModificarCapacitat(cap);
                            System.out.println("Nou capacitat: " + cap);
                            break;
                        case 16:
                            System.out.println("Afegir classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            if(c == 1) ser.AfegirClase(Classes.Alta);
                            else if(c == 2) ser.AfegirClase(Classes.Mitja);
                            else if(c == 3) ser.AfegirClase(Classes.Baixa);
                            break;
                        case 17:
                            System.out.println("Eliminar classe: ");
                            System.out.println("1. Alta");
                            System.out.println("2. Mitja");
                            System.out.println("3. Baixa");
                            System.out.print("> ");
                            in = br.readLine();
                            c = Integer.parseInt(in);
                            if(c == 1) ser.EliminarClase(Classes.Alta);
                            else if(c == 2) ser.EliminarClase(Classes.Mitja);
                            else if(c == 3) ser.EliminarClase(Classes.Baixa);
                            break;
                        case 18:
                            System.out.println("Introdueix el nou cost de construccio");
                            System.out.print("> ");
                            in = br.readLine();
                            cost = Integer.parseInt(in);
                            ser.ModificarCost(cost);
                            System.out.println("Nou cost de construccio: " + cost);
                            break;
                        case 19:
                            System.out.println("Introdueix el nou cost de manteniment");
                            System.out.print("> ");
                            in = br.readLine();
                            mant = Integer.parseInt(in);
                            ser.ModificarManteniment(mant);
                            System.out.println("Nou cost de manteniment: " + mant);
                            break;
                        case 20:
                            System.out.println("Introdueix la nova area d'influencia.");
                            System.out.print("> ");
                            in = br.readLine();
                            ai = Integer.parseInt(in);
                            ser.ModificarAreaInfluencia(ai);
                            System.out.println("Nova area d'influencia: " + ai);
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
                                tip = Integer.parseInt(in);
                                opcio = false;
                                if(tip == 1) t = tipusServei.Bombers;
                                else if(tip == 2) t = tipusServei.Centre_Cultural;
                                else if(tip == 3) t = tipusServei.Escola;
                                else if(tip == 4) t = tipusServei.Hospital;
                                else if(tip == 5) t = tipusServei.Parc;
                                else if(tip == 6) t = tipusServei.Policia;
                                else if(tip == 7) t = tipusServei.Preso;
                                else {
                                    System.out.println("Opció incorrecte. Torna-ho a provar...");
                                    opcio = true;
                                }
                            }
                            ser.modificarTipus(t);
                            break;
                        case 22:
                            System.out.println("Opcions:");
                            System.out.println("1. Consultar cost.");
                            System.out.println("2. Consultar cost de manteniment.");
                            System.out.println("3. Consultar area d'influencia.");
                            System.out.println("4. Consultar tipus de servei.");
                            System.out.println("5. Modificar cost. ");
                            System.out.println("6. Modificar cost de manteniment.");
                            System.out.println("7. Modificar area d'influencia.");
                            System.out.println("8. Modificar tipus de servei.");
                            System.out.println("9. Mostrar opcions.");
                            System.out.println("10. Sortir");
                            break;
                        case 23:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}
