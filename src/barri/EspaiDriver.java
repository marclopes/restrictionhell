package barri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * @author albert
 */
public class EspaiDriver {

    public static void main(String[] args) throws IOException {
        Espai espai = new Espai();
        int select, x, y,cordx,cordy;
        Object k;
        boolean aux;
        select = x = y = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (select != 11) {
            System.out.println("Elegeix l'accio que vols fer\n");
            System.out.println("1. Definir les mides del espai\n");
            System.out.println("2. Afegeir un element a una posicio\n");
            System.out.println("3. Consultar element per id\n");
            System.out.println("4. Consultar element per posicio\n");
            System.out.println("5. Existeix l'element a la posicio?\n");
            System.out.println("6. Existeix l'element amb el id?\n");
            System.out.println("7. Elimina l'element de la posicio\n");
            System.out.println("8. Elimina l'element per id\n");
            System.out.println("9. Consultar coordenada x del element per id\n");
            System.out.println("10. Consultar coordenada y del element per id\n");
            System.out.println("11. Sortir\n");
            switch (select) {
                case 1:
                    System.out.println("Introdueix un enter positiu (Cord X)");
                    in = br.readLine();
                    x = Integer.parseInt(in);
                    System.out.println("Introdueix un enter positiu (Cord Y)");
                    in = br.readLine();
                    y = Integer.parseInt(in);
                    espai = new Espai(x, y);
                    break;
                case 2:
                    System.out.println("Introdueix coordenada X");
                    System.out.println("Rang de Posicions : [0-"+x+"]");
                    in = br.readLine();
                    cordx = Integer.parseInt(in);
                    System.out.println("Introdueix coordenada Y)");
                    System.out.println("Rang de Posicions : [0-"+y+"]");
                    in = br.readLine();
                    cordy = Integer.parseInt(in);
                    System.out.println("Introdueix id del element ");
                    in = br.readLine();
                    k = new Object();
                    espai.InsertarElement(k,Integer.parseInt(in) , cordx, cordy);
                    System.out.println("L'objecte "+ k.toString() + " s'ha colocat a la posicio" +cordx +" " +cordy);
                    break;
                case 3:
                     System.out.println("Introdueix id del element");
                     in = br.readLine();
                      k= espai.ConsultarElement(Integer.parseInt(in));
                      System.out.println("L'objecte "+ k.toString() + " es el que te id " + Integer.parseInt(in));
                    break;
                case 4:
                    System.out.println("Introdueix posicio X");
                    in = br.readLine();
                    cordx = Integer.parseInt(in);
                    System.out.println("Introdueix posicio Y");
                    in = br.readLine();
                    cordy = Integer.parseInt(in);
                    k =  espai.ConsultarElementxy(cordx, cordy);
                    if (k!=null) {
                    System.out.println("L'objecte "+ k.toString() + " es el que esta a les posicio " +cordx + " " + cordy);
                    }
                    else {
                        System.out.println("No hi ha cap objecte a la posicio " +cordx + " " + cordy);
                    }
                    break;
                case 5:
                    System.out.println("Introdueix id del element");
                    in = br.readLine();
                    aux = espai.ExisteixElement(Integer.parseInt(in));
                    if(aux) System.out.println("Existeix un element amb id " + Integer.parseInt(in) );
                    else System.out.println("No existeix un element amb id " + Integer.parseInt(in) );
                    break;
                case 6:
                    System.out.println("Introdueix posicio X");
                    in = br.readLine();
                    cordx = Integer.parseInt(in);
                    System.out.println("Introdueix posicio Y");
                    in = br.readLine();
                    cordy = Integer.parseInt(in);
                    aux =  espai.ExisteixElementxy(cordx, cordy);
                    if(aux) System.out.println("Existeix un element amb posicio " + cordx + " " + cordy );
                    else System.out.println("No existeix un element amb posicio " +  cordx + " " + cordy );
                    break;
                case 7:
                    System.out.println("Introdueix id del element");
                    in = br.readLine();
                    espai.EliminarElement(Integer.parseInt(in));
                    if (!espai.ExisteixElement(Integer.parseInt(in))) System.out.println("S'ha eliminat l'element amb id " + Integer.parseInt(in) );
                    else System.out.println("No s'ha eliminat l'element amb id " +Integer.parseInt(in) );
                    break;
                case 8:
                    System.out.println("Introdueix posicio X");
                    in = br.readLine();
                    cordx = Integer.parseInt(in);
                    System.out.println("Introdueix posicio Y");
                    in = br.readLine();
                    cordy = Integer.parseInt(in);
                    espai.EliminarElementxy(cordx, cordy);
                    if (!espai.ExisteixElementxy(cordx, cordy)) System.out.println("S'ha eliminat l'element amb posicio " + cordx + " " + cordy );
                    else System.out.println("No s'ha eliminat l'element amb posicio " + cordx + " " + cordy );
                    break;
                case 9:
                    System.out.println("Introdueix id del element");
                    in = br.readLine();
                    cordx = espai.ConsultarPosx(Integer.parseInt(in));
                    System.out.println("La coordenada X del element amb id "+Integer.parseInt(in) + " es " +cordx );
                    break;
                case 10:
                                        System.out.println("Introdueix id del element");
                    in = br.readLine();
                    cordy = espai.ConsultarPosx(Integer.parseInt(in));
                    System.out.println("La coordenada Y del element amb id "+Integer.parseInt(in) + " es " +cordy );
                    break;
            }
        }


    }
}