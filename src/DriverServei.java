/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import barri.Servei.tipusServei;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author eDU
 */
public class DriverServei {
    
    public static void main(String[] args) throws java.io.IOException{
		
                String in, nom;
                int codi, h, cap, cost, mant, ai, tip;
                tipusServei t = null;
                boolean opcio;
            
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                
                System.out.println("Driver de la classe Servei. ");
                System.out.println("Crea un Servei.");
                
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
                
                Servei ser = new Servei(cost,mant, ai,nom, codi, h, cap, t);
                
                System.out.println("");
                
                int opt = 0;
                
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
                
                while(opt != 10){
                    System.out.print("> ");
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
                            if(ser.consultarTipus() == tipusServei.Bombers) System.out.println("Bombers");
                            else if(ser.consultarTipus() == tipusServei.Centre_Cultural) System.out.println("Centre cultural");
                            else if(ser.consultarTipus() == tipusServei.Escola) System.out.println("Escola");
                            else if(ser.consultarTipus() == tipusServei.Hospital) System.out.println("Hospital");
                            else if(ser.consultarTipus() == tipusServei.Parc) System.out.println("Parc");
                            else if(ser.consultarTipus() == tipusServei.Policia) System.out.println("Policia");
                            else if(ser.consultarTipus() == tipusServei.Preso) System.out.println("Presó");
                            break;
                        case 5:
                            System.out.println("Introdueix el nou cost de construccio");
                            System.out.print("> ");
                            in = br.readLine();
                            cost = Integer.parseInt(in);
                            ser.ModificarCost(cost);
                            System.out.println("Nou cost de construccio: " + cost);
                            break;
                        case 6:
                            System.out.println("Introdueix el nou cost de manteniment");
                            System.out.print("> ");
                            in = br.readLine();
                            mant = Integer.parseInt(in);
                            ser.ModificarManteniment(mant);
                            System.out.println("Nou cost de manteniment: " + mant);
                            break;
                        case 7:
                            System.out.println("Introdueix la nova area d'influencia.");
                            System.out.print("> ");
                            in = br.readLine();
                            ai = Integer.parseInt(in);
                            ser.ModificarAreaInfluencia(ai);
                            System.out.println("Nova area d'influencia: " + ai);
                            break;
                        case 8:
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
                        case 9:
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
                        case 10:
                            break;
                        default:
                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                            
                    }    
                }
	}
}
