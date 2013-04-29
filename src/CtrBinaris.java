package projecte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 * @author marc.lopez.llorach
 * 
 * Classe per guardar objectes en format binari.
 * Les classes que s'han de guardar en format binari han implementar la intericie Serializable (ex: class Nom implements Serializable)
 *
 */
public class CtrBinaris {
	
	public void escriuBinari (String nom, Object ob) throws FileNotFoundException, IOException {
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		File f = new File("./" + nom);
		//FileWriter fw = new FileWriter(f);
		fos = new FileOutputStream(f);
		oos = new ObjectOutputStream(fos);
		
        oos.writeObject(ob);
            
        fos.close();
        oos.close();

	}
	
	/**
	 * Sobre les excepcions: Aquestes funcions llencen les exepcions de FileNotFoundException quan no troba el fitxer,
	 * i IOException quan hi ha hagut un error al llegir/escriure.
	 * Es poden gestionar per separat (amb varis catch's) o les dues alhora.
	 * 
	 */
	
	public Object llegeixBinari (String nom) throws FileNotFoundException, IOException {
		Object ob = null;
		FileInputStream fis;
		ObjectInputStream ois;
		
		File f = new File("./" + nom);
		//FileWriter fw = new FileWriter(f);
		fis = new FileInputStream(f);
		ois = new ObjectInputStream(fis);
		
        try {
			ob = ois.readObject();
		} catch (ClassNotFoundException e) {
			// aix˜ no hauria de passar mai...
			System.err.println("ERROR");
		}
            
        fis.close();
        ois.close();
        
        return ob;

	}

}
