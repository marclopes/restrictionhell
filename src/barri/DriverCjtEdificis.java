package barri;

import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Edu
 */
public class DriverCjtEdificis {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException{
        
        int opt = 0, tip, imp, apc, codi, h, cap, cost,mant, ai, pos, tam;
        String in, nom;
        boolean opcio;
        tipusHab t = null;
        tipusNegoci n = null;
        tipusServei s = null;
        Edifici ed;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Driver de la classe CjtEdificis. ");
        System.out.println("");
        System.out.println("Creant un conjunt d'edificis...");
        
        CjtEdificis ce = new CjtEdificis();
        
        System.out.println("S'ha creat un conjunt d'edificis buit.");
        System.out.println("");
        
        System.out.println("Selecciona una opció:");
        System.out.println("1. Afegir edifici");
        System.out.println("2. Eliminar edifici");
        System.out.println("3. Obtenir edifici");
        System.out.println("4. Consultar si existeix edifici");
        System.out.println("5. Obtenir posició al conjunt");
        System.out.println("6. Obtenir edifici per posició al conjunt");
        System.out.println("7. Obtenir tamany del conjunt");
        System.out.println("8. Opcions");
        System.out.println("9. Sortir");
        
        
        while(opt != 9){
            System.out.print("Opció: ");
            in = br.readLine();
            opt = Integer.parseInt(in);
            switch(opt){
                case 1:
                    System.out.println("Selecciona el tipus d'Edifici:");
                    System.out.println("1. Habitatge");
                    System.out.println("2. Servei");
                    System.out.println("3. Negoci");

                    opcio = true;
                    while(opcio){
                        System.out.print("Opció: ");
                        in = br.readLine();
                        tip = Integer.parseInt(in);
                        opcio = false;
                        if(tip == 1){
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
                                if(tip == 1) t = Habitatge.tipusHab.Casa;
                                else if(tip == 2) t = Habitatge.tipusHab.Pis;
                                else if(tip == 3) t = Habitatge.tipusHab.Mansio;
                                else if(tip == 4) t = Habitatge.tipusHab.Xalet;
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
                            
                            ce.AfegirEdifici(hab);
                            System.out.println("Habitatge afegit al conjunt.");
                        }
                        else if(tip == 2) {
                            System.out.println("Driver de la classe Servei. ");
                            System.out.println("Crea un Servei.");

                            System.out.println("Selecciona el tipus de servei:");
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
                                if(tip == 1) s = tipusServei.Bombers;
                                else if(tip == 2) s = tipusServei.Centre_Cultural;
                                else if(tip == 3) s = tipusServei.Escola;
                                else if(tip == 4) s = tipusServei.Hospital;
                                else if(tip == 5) s = tipusServei.Parc;
                                else if(tip == 6) s = tipusServei.Policia;
                                else if(tip == 7) s = tipusServei.Preso;
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

                            Servei ser = new Servei(cost,mant, ai,nom, codi, h, cap, s);
                            
                            ce.AfegirEdifici(ser);
                            System.out.println("Servei afegit al conjunt.");
                        }
                        else if(tip == 3) {
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
                                if(tip == 1) n = tipusNegoci.Banc;
                                else if(tip == 2) n = tipusNegoci.Bar;
                                else if(tip == 3) n = tipusNegoci.Botiga_alimentacio;
                                else if(tip == 4) n = tipusNegoci.Botiga_roba;
                                else if(tip == 5) n = tipusNegoci.Clinica;
                                else if(tip == 6) n = tipusNegoci.Discoteca;
                                else if(tip == 7) n = tipusNegoci.Escola_privada;
                                else if(tip == 8) n = tipusNegoci.Restaurant;
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

                            Negoci neg = new Negoci(imp,apc, nom, codi, h, cap, n);
                            
                            ce.AfegirEdifici(neg);
                            System.out.println("Negoci afegit al conjunt.");
                        }
                        else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introdueix el nom de l'edifici que vols eliminar:");
                    System.out.print("> ");
                    nom = br.readLine();
                    if(ce.ExisteixEdifici(nom)) {
                        ce.EliminarEdifici(nom);
                        System.out.print("L'edifici " + nom + " s'ha eliminat del conjunt.");
                    }
                    else{
                        System.out.print("L'edifici " + nom + " no està al conjunt.");
                    }
                    break;
                case 3:
                    System.out.println("Introdueix el nom de l'edifici que vols consultar:");
                    System.out.print("> ");
                    nom = br.readLine();
                    if(ce.ExisteixEdifici(nom)) {
                        ed = ce.ObtenirEdifici(nom);
                        System.out.print("Nom: " + ed.ConsultarNom());
                        System.out.print("Codi: " + ed.ConsultarCodi());
                        System.out.print("Alçada: " + ed.ConsultarH());
                        System.out.print("Capacitat" + ed.ConsultarCapacitat());                           
                    }
                    else{
                        System.out.print("L'edifici " + nom + " no està al conjunt.");
                    }
                    break;
                case 4:
                    System.out.println("Introdueix el nom de l'edifici que vols saber si existeix:");
                    System.out.print("> ");
                    nom = br.readLine();
                    if(ce.ExisteixEdifici(nom))System.out.println("L'edifici està al conjunt.");
                    else System.out.println("L'edifici no està al conjunt.");
                    break;
                case 5:
                    System.out.println("Introdueix el nom de l'edifici del qual vols saber la posicio:");
                    System.out.print("> ");
                    nom = br.readLine();
                    if(ce.ExisteixEdifici(nom)){
                        pos = ce.obtenirPosicio(nom);
                        System.out.println("L'edifici està a la posició: " + pos);
                    }
                    else System.out.println("L'edifici no està al conjunt.");
                    break;
                case 6:
                    System.out.println("Introdueix la posicio del edifici que vols consultar:");
                    System.out.print("> ");
                    in = br.readLine();
                    pos = Integer.parseInt(in);
                    if(pos >= 0 && pos < ce.tamany()){
                        ed = ce.obtenirEdifici(pos);
                        System.out.print("Nom: " + ed.ConsultarNom());
                        System.out.print("Codi: " + ed.ConsultarCodi());
                        System.out.print("Alçada: " + ed.ConsultarH());
                        System.out.print("Capacitat" + ed.ConsultarCapacitat());
                    }
                    else{
                        System.out.println("La posició introduida no és vàlida.");
                    }
                    break;
                case 7:
                    tam = ce.tamany();
                    System.out.println("Hi ha " + tam + " edificis al conjunt.");
                    break;
                case 8:
                    System.out.println("1. Afegir edifici");
                    System.out.println("2. Eliminar edifici");
                    System.out.println("3. Obtenir edifici");
                    System.out.println("4. Consultar si existeix edifici");
                    System.out.println("5. Obtenir posició al conjunt");
                    System.out.println("6. Obtenir edifici per posició al conjunt");
                    System.out.println("7. Obtenir tamany del conjunt");
                    System.out.println("8. Opcions");
                    System.out.println("9. Sortir");
                    break;
                case 9:
                    break;
                default:
            }
        }
    }
}
