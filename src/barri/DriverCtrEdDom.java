package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import barri.CtrEdDom;
import barri.Edifici;
import barri.Edifici.TipusEd;
import barri.Habitatge.tipusHab;
import barri.Negoci.tipusNegoci;
import barri.Servei.tipusServei;

public class DriverCtrEdDom {

    public static void main(String[] args) throws java.io.IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;

        System.out.println("Driver del controlador d'Edificis. ");
        System.out.println("Crea un controlador d'Edificis.");

        CtrEdDom ctrEd = CtrEdDom.ObteInstancia();

        int opt = 0;

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

        while (opt != 9) {
            System.out.print("> ");
            in = br.readLine();
            opt = Integer.parseInt(in);
            switch (opt) {
                case 1:

                    String nom;
                    int codi,
                     h,
                     cap,
                     imp,
                     apc,
                     tip;
                    tipusHab t = null;
                    boolean opcio;

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

                    System.out.println("Selecciona el tipus d'habitatge:");
                    System.out.println("1. Casa");
                    System.out.println("2. Pis");
                    System.out.println("3. Mansio");
                    System.out.println("4. Xalet");


                    opcio = true;
                    while (opcio) {
                        System.out.print("> ");
                        in = br.readLine();
                        tip = Integer.parseInt(in);
                        opcio = false;
                        if (tip == 1) {
                            t = tipusHab.Casa;
                        } else if (tip == 2) {
                            t = tipusHab.Pis;
                        } else if (tip == 3) {
                            t = tipusHab.Mansio;
                        } else if (tip == 4) {
                            t = tipusHab.Xalet;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    CtrEdDom.CreaHabitatge(imp, apc, nom, codi, h, cap, t);

                    if (ctrEd.ExisteixEdifici(nom)) {

                        System.out.println("S'ha creat l'edifici correctament");

                    } else {

                        System.out.println("Ha hagut un error !");

                    }

                    break;

                case 2:

                    tipusNegoci t2 = null;

                    System.out.println("Driver de la classe Negoci. ");
                    System.out.println("Crea un Negoci.");

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
                        System.out.print("> ");
                        in = br.readLine();
                        tip = Integer.parseInt(in);
                        opcio = false;
                        if (tip == 1) {
                            t2 = tipusNegoci.Banc;
                        } else if (tip == 2) {
                            t2 = tipusNegoci.Bar;
                        } else if (tip == 3) {
                            t2 = tipusNegoci.Botiga_alimentacio;
                        } else if (tip == 4) {
                            t2 = tipusNegoci.Botiga_roba;
                        } else if (tip == 5) {
                            t2 = tipusNegoci.Clinica;
                        } else if (tip == 6) {
                            t2 = tipusNegoci.Discoteca;
                        } else if (tip == 7) {
                            t2 = tipusNegoci.Escola_privada;
                        } else if (tip == 8) {
                            t2 = tipusNegoci.Restaurant;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    CtrEdDom.CreaNegoci(imp, apc, nom, codi, h, cap, t2);

                    if (ctrEd.ExisteixEdifici(nom)) {

                        System.out.println("S'ha creat el negoci correctament");

                    } else {

                        System.out.println("Ha hagut un error !");

                    }


                    break;

                case 3:

                    //                	 String  nom;
                    int cost,
                     mant,
                     ai;
                    //int cost,mant;
                    tipusServei t3 = null;
                    //  boolean opcio;

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
                    while (opcio) {
                        System.out.print("> ");
                        in = br.readLine();
                        tip = Integer.parseInt(in);
                        opcio = false;
                        if (tip == 1) {
                            t3 = tipusServei.Bombers;
                        } else if (tip == 2) {
                            t3 = tipusServei.Centre_Cultural;
                        } else if (tip == 3) {
                            t3 = tipusServei.Escola;
                        } else if (tip == 4) {
                            t3 = tipusServei.Hospital;
                        } else if (tip == 5) {
                            t3 = tipusServei.Parc;
                        } else if (tip == 6) {
                            t3 = tipusServei.Policia;
                        } else if (tip == 7) {
                            t3 = tipusServei.Preso;
                        } else {
                            System.out.println("Opció incorrecte. Torna-ho a provar...");
                            opcio = true;
                        }
                    }

                    CtrEdDom.CreaServei(cost, mant, ai, nom, codi, h, cap, t3);

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

                    Edifici edif = CtrEd.GetEdifici(nomed);

                    CtrEd.ModificarEdifici(nomed, nomatr, nomval);

                    Edifici edif2 = CtrEd.GetEdifici(nomed);
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

                case 6: //Portar edifici

                    String nomed3;

                    System.out.println(
                            "Introdueix el nom de l'edifici a portar.");
                    System.out.print(
                            "> ");
                    nomed3 = br.readLine();
                    Edifici edif3 = ctrEd.ObtenirEdifici(nomed3);

                    System.out.println(
                            "L'edifici s'ha portat correctament.");

                case 7:

                    String nomed4;

                    System.out.println("Introdueix el nom de l'edifici a buscar.");
                    System.out.print("> ");
                    nomed4 = br.readLine();

                    if (ctrEd.ExisteixEdifici(nomed4)) {

                        System.out.println("L'edifici existeix.");

                    }

                    System.out.println("L'edifici no existeix.");


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