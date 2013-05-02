/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class GenBarris {

    private static CtrDomGeneral controlador = CtrDomGeneral.ObtenirInstancia();

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcio = 0;
        String in;
        while (opcio != 15) {

            switch (opcio) {
                case 1:
                    CreaBarri();
                    break;
                case 2:
                    ModificaBarri();
                    break;
                case 3:
                    EliminaBarri();
                    break;
                case 4:
                    AfegirEdifici();
                    break;
                case 5:
                    ImposarRestriccio();
                    break;
                case 6:
                    GeneraBarri();
                    break;
                case 7:
                    CreaEdifici();
                    break;
                case 8:
                    ModificaEdifici();
                    break;
                case 9:
                    EliminarEdifici();
                    break;
                case 10:
                    CreaRestriccio();
                    break;
                case 11:
                    ModificaRestrccio();
                    break;
                case 12:
                    EliminaRestriccio();
                    break;
                case 13:
                    TreureEdifici();
                    break;
                case 14:
                    TreureRestriccio();
                    break;
            }
            System.out.println("Seleccioni una opcio");
            System.out.println("1. Crear barri");
            System.out.println("2. Modificar un barri");
            System.out.println("3. Eliminar un barri");
            System.out.println("4. Escollir elements del barri");
            System.out.println("5. Imposar restriccions sobre un barri");
            System.out.println("6. Generar un barri");
            System.out.println("7. Crea Edifici");
            System.out.println("8. Modificiar Edifici");
            System.out.println("9. Eliminar Edifici");
            System.out.println("10. Crea restriccio");
            System.out.println("11. Modificar restriccio");
            System.out.println("12. Elimina restriccio");
            System.out.println("13. Treure edifici d'un barri");
            System.out.println("14. Treure restriccio d'un barri");
            System.out.println("15. Sortir");
            boolean esvalid = false;
            while (!esvalid) {
                try {
                    in = br.readLine();
                    opcio = Integer.parseInt(in);
                    if (opcio < 1) {
                        throw new Exception();
                    }
                    esvalid = true;
                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
        }
    }

    private static void ImprimirTipus(String n) {
        if (n.equals("Habitatge")) {
            System.out.println("1. Casa");
            System.out.println("2. Pis");
            System.out.println("3. Mansio");
            System.out.println("4. Xalet");
        } else if (n.equals("Negoci")) {
            System.out.println("1. Discoteca");
            System.out.println("2. Banc");
            System.out.println("3. Bar");
            System.out.println("4. Restaurant");
            System.out.println("5. Botiga alimentacio");
            System.out.println("6. Botiga roba");
            System.out.println("7. Escola privada");
            System.out.println("8. Clinica");
        } else if (n.equals("Servei")) {
            System.out.println("1. Hospital");
            System.out.println("2. Escola");
            System.out.println("3. Policia");
            System.out.println("4. Preso");
            System.out.println("5. Bombers");
            System.out.println("6. Parc");
            System.out.println("7. Centre Cultural");

        } else if (n.equals("Restriccions")) {
            System.out.println("1. Restriccio de Distancia entre Tipus d'edificis");
            System.out.println("2. Restriccio d'alçada");
            System.out.println("3. Restriccio de cost de construccio");
            System.out.println("4. Restriccio de cost de manteniment");
            System.out.println("5. Restriccio sobre impostos minims a recaptar");
            System.out.println("6. Restriccio sobre quantitat d'edificis");
            System.out.println("7. Restriccio sobre quantitat d'aparcaments minima en un barri");

        } else if (n.equals("TipEdRestr")) {

            System.out.println("1. Casa");
            System.out.println("2. Pis");
            System.out.println("3. Mansio");
            System.out.println("4. Xalet");
            System.out.println("5. Discoteca");
            System.out.println("6. Banc");
            System.out.println("7. Bar");
            System.out.println("8. Restaurant");
            System.out.println("9. Botiga alimentacio");
            System.out.println("10. Botiga roba");
            System.out.println("11. Escola privada");
            System.out.println("12. Clinica");
            System.out.println("13. Hospital");
            System.out.println("14. Escola");
            System.out.println("15. Policia");
            System.out.println("16. Preso");
            System.out.println("17. Bombers");
            System.out.println("18. Parc");
            System.out.println("19. Centre Cultural");
        }
    }

    private static String NumTipAString(int tipus, String tipusO) {
        if (tipusO.equals("Habitatge")) {
            switch (tipus) {
                case 1:
                    return "Casa";
                case 2:
                    return "Pis";
                case 3:
                    return "Mansio";
                case 4:
                    return "Xalet";
            }
        } else if (tipusO.equals("Negoci")) {
            switch (tipus) {
                case 1:
                    return "Discoteca";
                case 2:
                    return "Banc";
                case 3:
                    return "Bar";
                case 4:
                    return "Restaurant";
                case 5:
                    return "Botiga alimentacio";
                case 6:
                    return "Botiga roba";
                case 7:
                    return "Escola privada";
                case 8:
                    return "Clinica";
            }
        } else if (tipusO.equals("Servei")) {
            switch (tipus) {
                case 1:
                    return "Hospital";
                case 2:
                    return "Escola";
                case 3:
                    return "Policia";
                case 4:
                    return "Preso";
                case 5:
                    return "Bombers";
                case 6:
                    return "Parc";
                case 7:
                    return "Centre Cultural";
            }
        } else if (tipusO.equals("TipEdRestr")) {
            switch (tipus) {
                case 1:
                    return "Casa";
                case 2:
                    return "Pis";
                case 3:
                    return "Mansio";
                case 4:
                    return "Xalet";
                case 5:
                    return "Discoteca";
                case 6:
                    return "Banc";
                case 7:
                    return "Bar";
                case 8:
                    return "Restaurant";
                case 9:
                    return "Botiga alimentacio";
                case 10:
                    return "Botiga roba";
                case 11:
                    return "Escola privada";
                case 12:
                    return "Clinica";
                case 13:
                    return "Hospital";
                case 14:
                    return "Escola";
                case 15:
                    return "Policia";
                case 16:
                    return "Preso";
                case 17:
                    return "Bombers";
                case 18:
                    return "Parc";
                case 19:
                    return "Centre Cultural";
            }
        }

        return null;
    }

    private static void ImprimirLlistat(ArrayList<String> llistatEdificis) {
        for (int i = 0; i < llistatEdificis.size(); ++i) {
            System.out.println(i + ". " + llistatEdificis.get(i));
        }
    }

    private static String ModiOpcions(int tipus, String tipusA) {
        if (tipusA.equals("Barri")) {
            switch (tipus) {
                case 1:
                    return "Nom";
                case 2:
                    return "Classe";
                case 3:
                    return "MidaX";
                case 4:
                    return "MidaY";
            }
        } else if (tipusA.equals("Edifici")) {
            switch (tipus) {
                case 1:
                    return "altura";
                case 2:
                    return "capacitat";
                case 3:
                    return "classe";
                case 4:
                    return "impost";
                case 5:
                    return "aparcament";
                case 6:
                    return "cost";
                case 7:
                    return "manteniment";
                case 8:
                    return "area influencia";
            }
        } else if (tipusA.equals("Restriccio")) {
            switch (tipus) {
                case 1:
                    return "Altura";
                case 2:
                    return "Cost";
                case 3:
                    return "Distancia";
                case 4:
                    return "Edifici1";
                case 5:
                    return "Edifici2";
                case 6:
                    return "Impostos";
                case 7:
                    return "Influencia";
                case 8:
                    return "Quantitat";
                case 9:
                    return "Maxim";
                case 10:
                    return "Espai";
                case 11:
                    return "Cjt Edificis";


            }
        }
        return null;

    }

    private static void ImprimirModOp(String n) {
        if (n.equals("Barri")) {
            System.out.println("1. Nom");
            System.out.println("2. Classe");
            System.out.println("1. MidaX");
            System.out.println("1. MidaY");

        } else if (n.equals("Edifici")) {

            System.out.println("1. Altura");
            System.out.println("2. Capacitat");
            System.out.println("3. Classe");
            System.out.println("4. Impost");
            System.out.println("5. Aparcament");
            System.out.println("6. Cost");
            System.out.println("7. Manteniment");
            System.out.println("8. Area influencia");

        } else if (n.equals("Restriccio")) {
            System.out.println("1. Altura");
            System.out.println("2. Cost");
            System.out.println("3. Distancia");
            System.out.println("4. Edifici1");
            System.out.println("5. Edifici2");
            System.out.println("6. Impostos");
            System.out.println("7. Influencia");
            System.out.println("8. Quantitat");
            System.out.println("9. Maxim");
            System.out.println("10. Espai");
            System.out.println("11. Cjt Edificis");
        }
    }

    private static void CreaBarri() {
        System.out.println("Introdueix nom del barri");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nom, classe;
        nom = classe = " ";
        int x, y;
        x = y = 0;
        boolean esvalid;
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix la classe social del barri");
            System.out.println("1.Alta");
            System.out.println("2.Mitja");
            System.out.println("3.Baixa");
            try {
                int aux = Integer.parseInt(br.readLine());
                esvalid = true;
                switch (aux) {
                    case 1:
                        classe = "Alta";
                        break;
                    case 2:
                        classe = "Mitja";
                        break;
                    case 3:
                        classe = "Baixa";
                        break;
                    default:
                        esvalid = false;
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix les mides del barri");
            try {
                x = Integer.parseInt(br.readLine());
                y = Integer.parseInt(br.readLine());
                if (x < 1 || y < 1) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }

        int result = controlador.CreaBarri(nom, classe, x, y);
        if (result == 0) {
            System.out.println("S'ha creat correctament el barri " + nom
                    + " de classe " + classe + " i mides " + x + " " + y);
        } else {
            System.out.println("Error al crear el barri");
        }
    }

    private static void ModificaBarri() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nom, atribut, valor;
        nom = atribut = valor = " ";
        int tipus = 0;
        boolean esvalid = false;
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix atribut a modificar");
            ImprimirModOp("Barri");
            try {
                tipus = Integer.parseInt(br.readLine());
                if (tipus < 1) {
                    throw new Exception();
                }
                atribut = ModiOpcions(tipus, "Barri");
                if (atribut == null) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        System.out.println("Introdueix valor del atribut");
        esvalid = false;
        while (!esvalid) {
            try {
                valor = br.readLine();
                if (tipus == 3 || tipus == 4) {
                    if (Integer.parseInt(valor) < 1) {
                        throw new Exception();
                    }
                }
                esvalid = true;
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        int result = controlador.ModificarBarri(nom, atribut, valor);
        if (result == 0) {
            System.out.println("S'ha modificat el barri correctament");
        } else {
            System.out.println("Error al modificar el barri");
        }
    }

    private static void EliminaBarri() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nom;
        nom = " ";
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.EliminarBarri(nom);
        if (result == 0) {
            System.out.println("S'ha eliminat el barri correctament");
        } else {
            System.out.println("Error al eliminar el barri");
        }
    }

    private static void AfegirEdifici() {
        String nom, valor;
        nom = valor = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        System.out.println("Introdueix nom del edifici");
        try {
            valor = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.AfegirEdifici(nom, valor);
        if (result == 0) {
            System.out.println("S'ha afegit l'edifici al barri correctament");
        } else {
            System.out.println("Error al afegir l'edifici al barri");
        }
    }

    private static void ImposarRestriccio() {
        String nom = " ";
        int id = 0;
        int select = 0;
        int result = 0;
        boolean esvalid;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Vols imposar una restriccio de d'area d'influencia?");
            System.out.println("1. Si");
            System.out.println("2. No");
            try {
                select = Integer.parseInt(br.readLine());

                if (select != 1 && select != 2) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        switch (select) {
            case 1:
                result = controlador.ImposarRestriccio(nom, 0);
                if (result == 0) {
                    System.out.println("S'ha imposat la restriccio al barri correctament");
                } else {
                    System.out.println("Error al imposar la restriccio");
                }
                break;
            case 2:
                esvalid = false;
                while (!esvalid) {
                    System.out.println("Introdueix id de la restriccio");
                    try {
                        id = Integer.parseInt(br.readLine());
                        esvalid = true;

                    } catch (Exception e) {
                        System.out.println("Parametre errorni, reintrodueix");
                    }
                }
                result = controlador.ImposarRestriccio(nom, id);
                if (result == 0) {
                    System.out.println("S'ha imposat la restriccio al barri correctament");
                } else {
                    System.out.println("Error al imposar la restriccio");
                }
                break;
        }
    }

    private static void CreaEdifici() {
        String nom, classe, atribut;
        boolean esvalid;
        int x, y, imp, a, tipus, area;
        x = y = imp = a = tipus = area = 0;
        nom = classe = atribut = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del edifici");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }

        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix l'altura del edifici");
            try {
                x = Integer.parseInt(br.readLine());
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix capacitat del edifici");
            try {
                y = Integer.parseInt(br.readLine());
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Quin tipus d'edifici?");
            System.out.println("1. Habitatge");
            System.out.println("2. Negoci");
            System.out.println("3. Servei");
            try {
                int aux = Integer.parseInt(br.readLine());
                esvalid = true;
                switch (aux) {
                    case 1:
                        classe = "Habitatge";
                        break;
                    case 2:
                        classe = "Negoci";
                        break;
                    case 3:
                        classe = "Servei";
                        break;
                    default:
                        esvalid = false;
                }
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        if (classe.equals("Habitatge")) {
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix els impostos a pagar del edifici");
                try {
                    imp = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el nombre d'aparcaments del edifici");
                try {
                    a = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }

            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el tipus d'habitatge");
                ImprimirTipus("Habitatge");
                try {
                    tipus = Integer.parseInt(br.readLine());
                    esvalid = true;
                    if (tipus < 0) {
                        esvalid = false;
                    }
                    atribut = NumTipAString(tipus, "Habitatge");



                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("A quines classes socials pertany?");
                ImprimirClasses();
                try {
                    tipus = Integer.parseInt(br.readLine());

                    if (tipus < 1 || tipus > 7) {
                        throw new Exception();
                    }
                    esvalid = true;

                } catch (Exception e) {

                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            int result = controlador.CreaHabitatge(imp, a, nom, x, y, atribut);
            if (result == 0) {
                DefinirClasse(nom, tipus);
                System.out.println("S'ha creat l'habitatge correctament");
            } else {
                System.out.println("Error al crear l'habitatge");
            }

        } else if (classe.equals("Negoci")) {
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix els impostos a pagar del edifici");
                try {
                    imp = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el nombre d'aparcaments del edifici");
                try {
                    a = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }

            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el tipus de negoci");
                ImprimirTipus("Negoci");
                try {
                    tipus = Integer.parseInt(br.readLine());

                    if (tipus < 0) {
                        throw new Exception();
                    }
                    esvalid = true;
                    atribut = NumTipAString(tipus, "Negoci");



                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("A quines classes socials pertany?");
                ImprimirClasses();
                try {
                    tipus = Integer.parseInt(br.readLine());

                    if (tipus < 1 || tipus > 7) {
                        throw new Exception();
                    }
                    esvalid = true;

                } catch (Exception e) {

                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            int result = controlador.CreaNegoci(imp, a, nom, x, y, atribut);
            if (result == 0) {
                DefinirClasse(nom, tipus);
                System.out.println("S'ha creat el negoci correctament");
            } else {
                System.out.println("Error al crear el negoci");
            }
        } else if (classe.equals("Servei")) {

            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el cost de construccio del edifici");
                try {
                    imp = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el cost de manteniment del edifici");
                try {
                    a = Integer.parseInt(br.readLine());
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix l'area d'influencia del edifici (Minim 4)");
                try {
                    area = Integer.parseInt(br.readLine());
                    if (area < 4) {
                        throw new Exception();
                    }
                    esvalid = true;
                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }

            esvalid = false;
            while (!esvalid) {
                System.out.println("Introdueix el tipus de servei");
                ImprimirTipus("Servei");
                try {
                    tipus = Integer.parseInt(br.readLine());
                    esvalid = true;
                    if (tipus < 0) {
                        throw new Exception();
                    }
                    atribut = NumTipAString(tipus, "Servei");

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            esvalid = false;
            while (!esvalid) {
                System.out.println("A quines classes socials pertany?");
                ImprimirClasses();
                try {
                    tipus = Integer.parseInt(br.readLine());

                    if (tipus < 1 || tipus > 7) {
                        throw new Exception();
                    }
                    esvalid = true;

                } catch (Exception e) {
                    System.out.println("Parametre errorni, reintrodueix");
                }
            }
            int result = controlador.CreaServei(imp, a, area, nom, x, y, atribut);
            if (result == 0) {
                DefinirClasse(nom, tipus);
                System.out.println("S'ha creat el servei correctament");
            } else {
                System.out.println("Error al crear el servei");
            }
        }
    }

    private static void ModificaEdifici() {
        String nom, atribut, valor;
        nom = atribut = valor = " ";
        int tipus = 0;
        boolean esvalid;
        System.out.println("Introdueix nom del edifici");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }

        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix atribut a modificar");
            ImprimirModOp("Edifici");
            try {
                tipus = Integer.parseInt(br.readLine());
                if (tipus < 1) {
                    throw new Exception();
                }
                atribut = ModiOpcions(tipus, "Edifici");
                if (atribut == null) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix valor del atribut");
            try {
                valor = br.readLine();
                if (tipus != 3) {
                    if (Integer.parseInt(valor) < 1) {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        int result = controlador.ModificarEdifici(nom, atribut, valor);
        if (result == 0) {
            System.out.println("S'ha modificat l'edifici correctament");
        } else {
            System.out.println("Error al modificiar l'edifici");
        }
    }

    private static void CreaRestriccio() {
        String classe, valor;
        int id, tipus, x, y, area, imp, result;
        classe = valor = " ";
        id = tipus = x = y = area = imp = result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean esvalid, max;
        max = esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix identificador de la restriccio (La 0 esta reservada)");
            try {
                id = Integer.parseInt(br.readLine());

                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix tipus de restriccio");
            ImprimirTipus("Restriccions");
            try {
                tipus = Integer.parseInt(br.readLine());

                if (tipus < 1) {
                    throw new Exception();
                }
                switch (tipus) {
                    case 1:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix la distancia entre tipus d'edifici");
                            try {
                                x = Integer.parseInt(br.readLine());
                                if (x < 1) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Distancia maxima o minima?");
                            System.out.println("1. Maxima");
                            System.out.println("2. Minima");
                            try {
                                y = Integer.parseInt(br.readLine());
                                if (y == 1) {
                                    max = true;
                                } else if (y == 2) {
                                    max = false;
                                } else {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix tipus de restriccio");
                            ImprimirTipus("TipEdRestr");
                            try {
                                tipus = Integer.parseInt(br.readLine());

                                if (tipus < 1) {
                                    throw new Exception();
                                }
                                valor = NumTipAString(tipus, "TipEdRestr");
                                if (valor == null) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix tipus de restriccio");
                            ImprimirTipus("TipEdRestr");
                            try {
                                tipus = Integer.parseInt(br.readLine());

                                if (tipus < 1) {
                                    throw new Exception();
                                }
                                classe = NumTipAString(tipus, "TipEdRestr");
                                if (classe == null) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CrearRestriccioDistanciaTipus(id, x, max, valor, classe);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;


                    case 2:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix l'altura del edifici");
                            try {
                                x = Integer.parseInt(br.readLine());
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CrearRestriccioAlsada(id, x);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    case 3:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix cost de construccio");
                            try {
                                area = Integer.parseInt(br.readLine());
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Cost maxim o minim?");
                            System.out.println("1. Maxim");
                            System.out.println("2. Minim");
                            try {
                                y = Integer.parseInt(br.readLine());
                                if (y == 1) {
                                    max = true;
                                } else if (y == 2) {
                                    max = false;
                                } else {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CrearRestriccioCost(id, area, max);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    case 4:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix cost de manteniment maxim");
                            try {
                                area = Integer.parseInt(br.readLine());
                                esvalid = true;


                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");

                            }
                        }

                        result = controlador.CreaRestriccioManteniment(id, area);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    case 5:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix els impostos minims del barri");
                            try {
                                imp = Integer.parseInt(br.readLine());
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CreaRestriccioImpostos(id, imp);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    case 6:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix la quantitat d'edificis");
                            try {
                                x = Integer.parseInt(br.readLine());
                                if (x < 1) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Quantitat maxima o minima?");
                            System.out.println("1. Maxima");
                            System.out.println("2. Minima");
                            try {
                                y = Integer.parseInt(br.readLine());
                                if (y == 1) {
                                    max = true;
                                } else if (y == 2) {
                                    max = false;
                                } else {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        ArrayList<String> llistatEdificis = controlador.LlistatEdificis();
                        if (llistatEdificis.isEmpty()) {
                            System.out.println("No hi ha edificis disponibles");
                            throw new Exception();
                        }
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Selecciona un edifici");
                            ImprimirLlistat(llistatEdificis);
                            try {
                                x = Integer.parseInt(br.readLine());
                                valor = llistatEdificis.get(x);
                                if (valor == null) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CreaRestriccioQuantitat(id, x, max, valor);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    case 7:
                        esvalid = false;
                        while (!esvalid) {
                            System.out.println("Introdueix la quantitat minima d'aparcaments");
                            try {
                                x = Integer.parseInt(br.readLine());
                                if (x < 0) {
                                    throw new Exception();
                                }
                                esvalid = true;

                            } catch (Exception e) {
                                System.out.println("Parametre errorni, reintrodueix");
                            }
                        }
                        result = controlador.CreaRestriccioAparcament(id, x);
                        if (result == 0) {
                            System.out.println("S'ha creat la restriccio correctament");
                        } else {
                            System.out.println("Error al crear la restriccio");
                        }
                        break;
                    default:
                        throw new Exception();


                }


                esvalid = true;
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");

            }
        }

    }

    private static void GeneraBarri() {
        String nom = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.GeneraBarri(nom);
        if (result == 0) {
            System.out.println("El barri s'ha generat correctament");
        } else {
            System.out.println("Error al generar el barri");
        }
    }

    private static void EliminaRestriccio() {
        int id = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix l'identificador de la restriccio");
            try {
                id = Integer.parseInt(br.readLine());
                if (id <= 0) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }

        }
        int result = controlador.EliminarRestriccio(id);
        if (result == 0) {
            System.out.println("S'ha eliminat la restriccio correctament");
        } else {
            System.out.println("Error al eliminar la restriccio");
        }
    }

    private static void ModificaRestrccio() {
        int id, tipus;
        id = tipus = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String atribut, valor;
        atribut = valor = " ";
        boolean esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix l'identificador de la restriccio");
            try {
                id = Integer.parseInt(br.readLine());
                if (id < 0) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }

        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix atribut a modificar");
            ImprimirModOp("Restriccio");
            try {
                tipus = Integer.parseInt(br.readLine());
                if (tipus < 1) {
                    throw new Exception();
                }
                atribut = ModiOpcions(tipus, "Restriccio");
                if (atribut == null) {
                    throw new Exception();
                }
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix valor del atribut");
            try {
                valor = br.readLine();
                if (tipus == 1 || tipus == 2 || tipus == 3 || tipus == 6 || tipus == 7 || tipus == 8) {
                    if (Integer.parseInt(valor) < 1) {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        int result = controlador.ModificarRestriccio(id, atribut, valor);
        if (result == 0) {
            System.out.println("S'ha modificat correctament la restriccio");
        } else {
            System.out.println("Error al modificar la restriccio");
        }
    }

    private static void EliminarBarri() {
        String nom = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.EliminarBarri(nom);
        if (result == 0) {
            System.out.println("S'ha eliminat correctament el barri");
        } else {
            System.out.println("Error al eliminar el barri");
        }
    }

    private static void TreureEdifici() {
        String nom, valor;
        nom = valor = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        System.out.println("Introdueix nom del edifici");
        try {
            valor = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.TreuEdifici(nom, valor);
        if (result == 0) {
            System.out.println("S'ha eliminat l'edifici del barri correctament");
        } else {
            System.out.println("Error al eliminar l'edifici al barri");
        }
    }

    private static void TreureRestriccio() {
        String nom = " ";
        int id = 0;
        boolean esvalid;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix nom del barri");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }

        esvalid = false;
        while (!esvalid) {
            System.out.println("Introdueix id de la restriccio");
            try {
                id = Integer.parseInt(br.readLine());
                esvalid = true;

            } catch (Exception e) {
                System.out.println("Parametre errorni, reintrodueix");
            }
        }
        int result = controlador.TreuRestriccio(nom, id);
        if (result == 0) {
            System.out.println("S'ha eliminat la restriccio del barri correctament");
        } else {
            System.out.println("Error al eliminar la restriccio");
        }
    }

    private static void ImprimirClasses() {
        System.out.println("1.Alta");
        System.out.println("2.Mitja");
        System.out.println("3.Baixa");
        System.out.println("4.Alta i Mitja");
        System.out.println("5.Alta i Baixa");
        System.out.println("6. Mitja i Baixa");
        System.out.println("7.Alta , Mitja i Baixa");

    }

    private static void DefinirClasse(String nom, int tipus) {
        switch (tipus) {
            case 1:
                controlador.ModificarEdifici(nom, "classe", "Alta");
                break;
            case 2:
                controlador.ModificarEdifici(nom, "classe", "Mitja");
                break;
            case 3:
                controlador.ModificarEdifici(nom, "classe", "Baixa");
                break;
            case 4:
                controlador.ModificarEdifici(nom, "classe", "Alta");
                controlador.ModificarEdifici(nom, "classe", "Mitja");
                break;
            case 5:
                controlador.ModificarEdifici(nom, "classe", "Alta");
                controlador.ModificarEdifici(nom, "classe", "Baixa");
            case 6:
                controlador.ModificarEdifici(nom, "classe", "Mitja");
                controlador.ModificarEdifici(nom, "classe", "Baixa");
            case 7:
                controlador.ModificarEdifici(nom, "classe", "Alta");
                controlador.ModificarEdifici(nom, "classe", "Mitja");
                controlador.ModificarEdifici(nom, "classe", "Baixa");
        }
    }

    private static void EliminarEdifici() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nom;
        nom = " ";
        System.out.println("Introdueix nom del edifici");
        try {
            nom = br.readLine();
        } catch (Exception e) {
        }
        int result = controlador.EliminarEdifici(nom);
        if (result == 0) {
            System.out.println("S'ha eliminat l'edifici correctament");
        } else {
            System.out.println("Error al eliminar l'edifici");
        }
    }
}
