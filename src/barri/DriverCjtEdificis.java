package barri;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

/**
 *
 * @author Eduard Ricou
 */
public class DriverCjtEdificis {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException{
        
        int opt = 0, tip, imp, apc, codi, h, cap, cost, mant, ai, pos, tam, err;
        String in, nom;
        boolean opcio, opcio2, afegit;
        TipusHab t = null;
        TipusNegoci n = null;
        TipusServei s = null;
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
            opt = LlegirEnter(in);
            switch(opt){
                case 1:
                    System.out.println("Selecciona el tipus d'Edifici:");
                    System.out.println("1. Habitatge");
                    System.out.println("2. Servei");
                    System.out.println("3. Negoci");
                    opcio2 = true;
                    while(opcio2){
                        System.out.print("Opció: ");
                        in = br.readLine();
                        tip = Integer.parseInt(in);
                        opcio2 = false;
                        if(tip == 1){
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
                                    if(tip == 1) t = TipusHab.Casa;
                                    else if(tip == 2) t = TipusHab.Pis;
                                    else if(tip == 3) t = TipusHab.Mansio;
                                    else if(tip == 4) t = TipusHab.Xalet;
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

                            afegit = ce.AfegirEdifici(hab);
                            if(afegit) System.out.println("Habitatge afegit al conjunt.");
                            else System.out.println("Ja existeix un edifici amb aquest nom.");
                        }
                        else if(tip == 2) {
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
                                    if(tip == 1) s = TipusServei.Bombers;
                                    else if(tip == 2) s = TipusServei.Centre_Cultural;
                                    else if(tip == 3) s = TipusServei.Escola;
                                    else if(tip == 4) s = TipusServei.Hospital;
                                    else if(tip == 5) s = TipusServei.Parc;
                                    else if(tip == 6) s = TipusServei.Policia;
                                    else if(tip == 7) s = TipusServei.Preso;
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

                            Servei ser = new Servei(cost,mant, ai,nom, codi, h, cap, s);
                            
                            afegit = ce.AfegirEdifici(ser);
                            if(afegit) System.out.println("Servei afegit al conjunt.");
                            else System.out.println("Ja existeix un edifici amb aquest nom.");
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
                                try{
                                    tip = Integer.parseInt(in);

                                    opcio = false;
                                    if(tip == 1) n = Negoci.TipusNegoci.Banc;
                                    else if(tip == 2) n = Negoci.TipusNegoci.Bar;
                                    else if(tip == 3) n = Negoci.TipusNegoci.Botiga_alimentacio;
                                    else if(tip == 4) n = Negoci.TipusNegoci.Botiga_roba;
                                    else if(tip == 5) n = Negoci.TipusNegoci.Clinica;
                                    else if(tip == 6) n = Negoci.TipusNegoci.Discoteca;
                                    else if(tip == 7) n = Negoci.TipusNegoci.Escola_privada;
                                    else if(tip == 8) n = Negoci.TipusNegoci.Restaurant;
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

                            Negoci neg = new Negoci(imp,apc, nom, codi, h, cap, n);
                            
                            afegit = ce.AfegirEdifici(neg);
                            if(afegit) System.out.println("Negoci afegit al conjunt.");
                            else System.out.println("Ja existeix un edifici amb aquest nom.");
                        }
                        else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio2 = true;
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
                        System.out.println("Nom: " + ed.ConsultarNom());
                        System.out.println("Codi: " + ed.ConsultarCodi());
                        System.out.println("Alçada: " + ed.ConsultarH());
                        System.out.println("Capacitat: " + ed.ConsultarCapacitat());
                        System.out.println("");
                    }
                    else{
                        System.out.println("L'edifici " + nom + " no està al conjunt.");
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
                        pos = ce.ObtenirPosicio(nom);
                        System.out.println("L'edifici està a la posició: " + pos);
                    }
                    else System.out.println("L'edifici no està al conjunt.");
                    break;
                case 6:
                    System.out.println("Introdueix la posicio del edifici que vols consultar:");
                    
                    
                    boolean trall = true;
                    while(trall){
                        System.out.print("> ");
                        in = br.readLine();
                        try{
                        pos = Integer.parseInt(in);
                        trall = false;
                        if(pos >= 0 && pos < ce.Tamany()){
                            ed = ce.ObtenirEdifici(pos);
                            System.out.println("Nom: " + ed.ConsultarNom());
                            System.out.println("Codi: " + ed.ConsultarCodi());
                            System.out.println("Alçada: " + ed.ConsultarH());
                            System.out.println("Capacitat: " + ed.ConsultarCapacitat());
                        }
                        else{
                            System.out.println("La posició introduida no és vàlida.");
                        }
                        }catch(NumberFormatException e){
                            System.out.println("ERROR: " + in + " no és una entrada vàlida");
                        }
                    }
                    
                    break;
                case 7:
                    tam = ce.Tamany();
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
