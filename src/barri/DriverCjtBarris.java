
package barri;

import barri.Edifici.Classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Carlos
 */
public class DriverCjtBarris {
    
    private static Classes StringToClase(String c) {
        
        if (c.equals("Alta")) {
            return Classes.Alta;
        } else if (c.equals("Mitja")) {
            return Classes.Mitja;
        } else {
            return Classes.Baixa;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Driver de la classe CjtBarris. ");
        System.out.println("");
        System.out.println("Creant un conjunt de barris.");
        
         CjtBarris cb = new CjtBarris();
         
        System.out.println("S'ha creat un conjunt de barris buit.");
        System.out.println("");
        
        int opt = -1000;
        String in;
        while(opt != 6){
            
        System.out.println("Selecciona una opció:");
        System.out.println("1. Afegir barri");
        System.out.println("2. Eliminar barri");
        System.out.println("3. Consultar existència d'un barri");
        System.out.println("4. Obtenir barri");
        System.out.println("5. Opcions");
        System.out.println("6. Sortir");
        
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
                    
                         System.out.println("Primer s'ha de crear el barri.");
                         System.out.println("Introdueix el nom del barri.");
                         
                         String n = br.readLine();
                         
                         if (cb.ExisteixBarri(n)) {
                             
                             System.out.println("ERROR: " + "El barri ja existeix.");
                             break;
                             
                         }
                           
                         System.out.println("Introdueix la classe del barri (Alta,Mitja o Baixa).");
                         
                         in = br.readLine();
                         
                         Classes mitja = StringToClase(in);
                         
                         System.out.println("Introdueix l'amplada del barri [x].");

                         int xx = -1000;
                         
                            while(xx == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                xx = LlegirEnter(in);
                                if(xx == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }
                         
                         System.out.println("Introdueix l'amplada del barri [y].");
                         
                         int yy = -1000;
                         
                            while(yy == -1000){
                                System.out.print("> ");
                                in = br.readLine();
                                yy = LlegirEnter(in);
                                if(yy == -1000)System.out.println("Valor incorrecte. Torna-ho a provar...");
                            }
                         
                         Barri barr = new Barri(n, mitja, xx, yy);
                         cb.AfegirBarri(barr);

                         if (cb.ExisteixBarri(n)) {
                             
                             System.out.println("El barri s'ha creat amb exit");
                             
                         }
                         
                         else {
                             
                             System.out.println("ERROR: " + "El barri no s'ha creat amb exit");
                             
                         }
                         
                    break;
                case 2:
                    
                      System.out.println("Introdueix el nom del barri a esborrar.");
                      in = br.readLine();
                      
                      if (cb.ExisteixBarri(in)) {
                          
                          cb.EliminarBarri(in);
                          
                          if (cb.ExisteixBarri(in)) {
                          
                                System.out.println("ERROR: " + "El barri no s'ha esborrat amb exit.");
                          
                          }
                          
                          else System.out.println("El barri s'ha esborrat amb exit.");
                      
                      }
                      
                      else { 
                          
                          System.out.println("ERROR: " + "El barri no existeix.");
                    
                       }
                      
                    break;
                case 3:
                    
                    System.out.println("Introdueix el nom del barri a consultar.");
                    in = br.readLine();
                    
                    if (cb.ExisteixBarri(in) ) {
                        
                         System.out.println("El barri existeix.");
                        
                    }
                    
                    else {
                        
                         System.out.println("El barri no existeix.");
                        
                    }
                    
                    break;
                case 4:
                    
                     System.out.println("Introdueix el nom del barri a obtenir.");
                     in = br.readLine();
                     
                     if (cb.ExisteixBarri(in) ) {
                        
                         Barri barrr = cb.GetBarri(in);
                        
                         System.out.println("El barri existeix i aquestes son les seves caracteristiques:");
                         
                         System.out.println("Barri amb nom: " + barrr.consultarNom() + ".");
                         System.out.println("Barri amb amplada [x]: " + barrr.consultarX() + ".");
                         System.out.println("Barri amb longitud [y]: " + barrr.consultarY() + ".");

                    }
                    
                    else {
                        
                         System.out.println("ERROR: " + "El barri no existeix.");
                        
                    }

                    break;
                case 5:
                    
                        System.out.println("Selecciona una opció:");
                        System.out.println("1. Afegir barri");
                        System.out.println("2. Eliminar barri");
                        System.out.println("3. Consultar existència d'un barri");
                        System.out.println("4. Obtenir barri");
                        System.out.println("5. Opcions");
                        System.out.println("6. Sortir");

                    break;
                case 6:

                    break;
                default:                            System.out.println("Opcio incorrecte. Torna-ho a provar.");
                    
            }
        }
        
    }
    
        
}
