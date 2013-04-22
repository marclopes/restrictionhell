import java.util.*;
import java.lang.Object;
/**
 *
 *
 @author albert
 */
 
public class EspaiDriver {
    private ArrayList<String> data;
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Testing Espai..");
	System.out.println("Carregant dades..");
	String linea;
	data= new ArrayList<String>;
	file = new FileReader("./Data/" + "EspaiDriverData" + ".txt"); 
        buffer = new BufferedReader(file);
        while (buffer.readLine().atChar(0)!='#' )
        
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Test
    public void ConsultarElement(){
      
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void ConsultarElementxy(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void ConsultarPosx(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void ConsultarPosy(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void EliminarElement(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void EliminarElementxy(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void ExisteixElement(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
    @Test
    public void ExisteixElementxy(){
      Edifici e = new Edifici(); //falta entrar dades de fitxer
      Illa i = new Illa(e);
    }
}