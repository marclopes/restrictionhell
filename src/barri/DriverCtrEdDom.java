package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import barri.Edifici.TipusEd;
import barri.Habitatge.TipusHab;
import barri.Negoci.TipusNegoci;
import barri.Servei.TipusServei;

public class DriverCtrEdDom {
    private static Edifici.Classes StringToClase(String c) {
        
        if (c.equals("Alta")) {
            return Edifici.Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Edifici.Classes.Mitja;
        } else {
            return Edifici.Classes.Baixa;
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
         
    public static void main(String[] args) throws java.io.IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;

        System.out.println("Driver del controlador d'Edificis. ");
        System.out.println("Crea un controlador d'Edificis.");

        CtrEdDom ctrEd = CtrEdDom.ObteInstancia();

                    int opt = -1000;
                    String nom;
                    int codi;
                    int h = -1000;
                    int cap = -1000;
                    int imp = -1000;
                    int apc = -1000;
                    int tip = -1000;
                    int cost;
                    int mant;
                    int ai;
                    
                    TipusHab t = null;
                    boolean opcio;
                    
        while (opt != 9) {
            
                    opt = -1000;                  
                    h = -1000;
                    cap = -1000;
                    imp = -1000;
                    apc = -1000;
                    tip = -1000;
                    cost = -1000;
                    mant = -1000;
                    ai = -1000;
                    
        System.out.println("Opcions:");
        System.out.println("1. Crear habitatge.");
        System.out.println("2. Crear negoci.");
        System.out.println("3. Crear servei.");
        System.out.println("4. Modificar edifici.");
        System.out.println("5. Eliminar edifici. ");
        System.out.println("6. Obtenir edifici.");
        System.out.println("7. Comprovar exist�ncia d'edifici.");
        System.out.println("8. Guardar edifici.");
        System.out.println("9. Sortir");
        
            System.out.print("Opció: ");
            opt = -1000;
            while(opt == -1000) {
                
                 System.out.print("> ");
                 in = br.readLine();
                 opt = LlegirEnter(in);
                 if(opt == -1000)System.out.println("Opció incorrecte. Torna-ho a provar...");
                 
                 }
                            
            switch(opt){
                case 1:

                    System.out.println("Introdueix el nom: ");
                    System.out.print("> ");
                    nom = br.readLine();

                    System.out.println("Introdueix l'alçada: ");
                    
                    while(h == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                h = LlegirEnter(in);
                                if(h == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix la capacitat: ");
                    while(cap == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                cap = LlegirEnter(in);
                                if(cap == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix els impostos:");
                    while(imp == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                imp = LlegirEnter(in);
                                if(imp == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix l'aparcament:");
                    while(apc == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                apc = LlegirEnter(in);
                                if(apc == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Selecciona el tipus d'habitatge:");
                    System.out.println("1. Casa");
                    System.out.println("2. Pis");
                    System.out.println("3. Mansio");
                    System.out.println("4. Xalet");


                    opcio = true;
                    while (opcio) {
                    while(tip == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                tip = LlegirEnter(in);
                                if(tip == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }
                        opcio = false;
                        if (tip == 1) {
                            t = TipusHab.Casa;
                        } else if (tip == 2) {
                            t = TipusHab.Pis;
                        } else if (tip == 3) {
                            t = TipusHab.Mansio;
                        } else if (tip == 4) {
                            t = TipusHab.Xalet;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    ctrEd.CreaHabitatge(imp, apc, nom, 0 , h, cap, t);

                    if (ctrEd.ExisteixEdifici(nom)) {

                        System.out.println("S'ha creat l'edifici correctament");

                    } else {

                        System.out.println("Ha hagut un error !");

                    }

                    break;

                case 2:

                    TipusNegoci t2 = null;

                    System.out.println("Driver de la classe Negoci. ");
                    System.out.println("Crea un Negoci.");

                    System.out.println("Introdueix el nom: ");
                    System.out.print("> ");
                    nom = br.readLine();

                    System.out.println("Introdueix l'alçada: ");
                    while(h == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                h = LlegirEnter(in);
                                if(h == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix la capacitat: ");
                    while(cap == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                cap = LlegirEnter(in);
                                if(cap == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix els impostos:");
                    while(cap == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                cap = LlegirEnter(in);
                                if(cap == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix l'aparcament:");
                    while(apc == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                apc = LlegirEnter(in);
                                if(apc == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

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
                    while (opcio) {
                    while(tip == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                tip = LlegirEnter(in);
                                if(tip == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }
                        opcio = false;
                        if (tip == 1) {
                            t2 = TipusNegoci.Banc;
                        } else if (tip == 2) {
                            t2 = TipusNegoci.Bar;
                        } else if (tip == 3) {
                            t2 = TipusNegoci.Botiga_alimentacio;
                        } else if (tip == 4) {
                            t2 = TipusNegoci.Botiga_roba;
                        } else if (tip == 5) {
                            t2 = TipusNegoci.Clinica;
                        } else if (tip == 6) {
                            t2 = TipusNegoci.Discoteca;
                        } else if (tip == 7) {
                            t2 = TipusNegoci.Escola_privada;
                        } else if (tip == 8) {
                            t2 = TipusNegoci.Restaurant;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    ctrEd.CreaNegoci(imp, apc, nom, 0, h, cap, t2);

                    if (ctrEd.ExisteixEdifici(nom)) {

                        System.out.println("S'ha creat el negoci correctament");

                    } else {

                        System.out.println("Ha hagut un error !");

                    }


                    break;

                case 3:

                    //                	 String  nom;
                    //int cost,mant;
                    TipusServei t3 = null;
                    //  boolean opcio;

                    System.out.println("Crea un Servei.");

                    System.out.println("Introdueix el nom: ");
                    System.out.print("> ");
                    nom = br.readLine();

                    System.out.println("Introdueix l'alçada: ");
                    while(h == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                h = LlegirEnter(in);
                                if(h == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix la capacitat: ");
                    while(cap == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                cap = LlegirEnter(in);
                                if(cap == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix el cost de construcció:");
                    while(cost == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                cost = LlegirEnter(in);
                                if(cost == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix el cost de manteniment:");
                    while(mant == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                mant = LlegirEnter(in);
                                if(mant == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }

                    System.out.println("Introdueix l'area d'influencia:");
                    while(ai == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                ai = LlegirEnter(in);
                                if(ai == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }


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
                    while (opcio) {
                    while(tip == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                tip = LlegirEnter(in);
                                if(tip == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }
                        opcio = false;
                        if (tip == 1) {
                            t3 = TipusServei.Bombers;
                        } else if (tip == 2) {
                            t3 = TipusServei.Centre_Cultural;
                        } else if (tip == 3) {
                            t3 = TipusServei.Escola;
                        } else if (tip == 4) {
                            t3 = TipusServei.Hospital;
                        } else if (tip == 5) {
                            t3 = TipusServei.Parc;
                        } else if (tip == 6) {
                            t3 = TipusServei.Policia;
                        } else if (tip == 7) {
                            t3 = TipusServei.Preso;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    ctrEd.CreaServei(cost, mant, ai, nom, 0, h, cap, t3);

                    if (ctrEd.ExisteixEdifici(nom)) {

                        System.out.println("S'ha creat el servei correctament");

                    } else {

                        System.out.println("Ha hagut un error !");

                    }


                    break;

                case 4:

                    String nomed;
                    System.out.println("Introdueix el nom de l'edifici a modificar.");
                    System.out.print("> ");
                    nomed = br.readLine();

                    String nomatr;
                    System.out.println("Introdueix l'atribut que vols modificar.");
                    System.out.print("> ");
                    nomatr = br.readLine();

                    String nomval;
                    System.out.println("Introdueix el nou valor.");
                    System.out.print("> ");
                    nomval = br.readLine();

                    Edifici edif = ctrEd.ObtenirEdifici(nomed);

                    ctrEd.ModificarEdifici(nomed, nomatr, nomval);

                    Edifici edif2 = ctrEd.ObtenirEdifici(nomed);
                    TipusEd tipus = edif.consultarSubclasse();
                    if ((edif.ConsultarH() == edif2.ConsultarH()) && (edif.ConsultarCapacitat() == edif2.ConsultarCapacitat()) && (edif.ConsultarNom().equals(edif2.ConsultarNom()))) {



                        if (tipus == TipusEd.HAB) {

                            if (((Habitatge) edif).ConsultarAparcament() == ((Habitatge) edif2).ConsultarAparcament() && ((Habitatge) edif).ConsultarImpost() == ((Habitatge) edif2).ConsultarImpost() && (edif.ConsultarNom().equals(edif2.ConsultarNom()))) {

                                System.out.println("No s'ha modificat res.");

                            }

                        }

                        if (tipus == TipusEd.NEG) {

                            if (((Negoci) edif).ConsultarAparcament() == ((Negoci) edif2).ConsultarAparcament() && ((Negoci) edif).ConsultarImpost() == ((Negoci) edif2).ConsultarImpost() && (edif.ConsultarNom().equals(edif2.ConsultarNom()))) {

                                System.out.println("No s'ha modificat res.");

                            }
                        }

                        System.out.println("No s'ha modificat res.");

                    }



                    if (tipus == TipusEd.SER) {

                        if (((Servei) edif).ConsultarCost() == ((Servei) edif2).ConsultarCost() && ((Servei) edif).ConsultarManteniment() == ((Servei) edif2).ConsultarManteniment() && (edif.ConsultarNom().equals(edif2.ConsultarNom())) && ((Servei) edif).ConsultarAreaInfluencia() == ((Servei) edif2).ConsultarAreaInfluencia()) {

                            System.out.println("No s'ha modificat res.");

                        }

                    } else {
                        System.out.println("S'ha canviat el valor.");
                    }
                    
                    break;
                case 5: //Eliminar edifici per nom

                    String nomed2;

                    System.out.println("Introdueix el nom de l'edifici a esborrar.");
                    System.out.print("> ");
                    nomed2 = br.readLine();

                    if (ctrEd.ExisteixEdifici(nomed2)) {

                        ctrEd.EliminarEdifici(ctrEd.ObtenirEdifici(nomed2));

                        if (ctrEd.ExisteixEdifici(nomed2)) {

                            System.out.println("No s'ha eliminat correctament");

                        } else {
                            System.out.println("S'ha eliminat correctament");
                        }

                    } else {
                        System.out.println("No existeix l'edifici a esborrar.");
                    }

                   break;
                case 6: //Portar edifici

                    String nomed3;

                    System.out.println("Introdueix el nom de l'edifici a portar.");
                    System.out.print( "> ");
                    nomed3 = br.readLine();
                    Edifici edif3 = ctrEd.ObtenirEdifici(nomed3);

                    if (edif3 != null) {
                    System.out.println("L'edifici s'ha portat correctament.");
                    }
                    else { System.out.println("ERROR: L'edifici no s'ha portat correctament.");}

                    break;
                case 7:

                    String nomed4;

                    System.out.println("Introdueix el nom de l'edifici a buscar.");
                    System.out.print("> ");
                    nomed4 = br.readLine();

                    if (ctrEd.ExisteixEdifici(nomed4)) {

                        System.out.println("L'edifici existeix.");

                    }

                    System.out.println("L'edifici no existeix.");

                    break;
                case 8:

                    System.out.println("Encara no disponible.");

                case 9:
                    break;
                default:
                    System.out.println(
                            "Opcio incorrecte. Torna-ho a provar.");

            }
        }
    }
}