package projecte;

import java.util.*;
import java.lang.Object;
/**
 *
 *
 @autor albert
 */
public class Espai<T> {
  
  public class Pos{
   int x;
   int y;
  }
  public class Dades{
    int id;
    T elem;
  }
 
  private Object MatriuElements[][];
  private TreeMap<Integer,Pos> Referencies;
  
     /**
        * Crea una instancia de la clase sense inicialitzar 
 */  
  Espai(){}
  /** 
        * Crea una instancia de la classe Espai.
        * @param a,b Son les mides de la matriu d'espai. 
  */
  public Espai(int a, int b){
    MatriuElements = new Object[a][b];
    Referencies = new TreeMap<Integer,Pos>();
  }
  /**
        * Inserta un element a la posició indicada
        * @param elem és l'element que es vol insertar
        * @param id és l'identificador del element
        * @param a,b son la posició a on s'insertaran
  */
  public void insertarElement(T elem,Integer id ,int a,int b) throws Exception{
  
	if (Referencies.get(id) != null) throw new Exception("L'element ja existeix\n");
	if (a<0 || b<0) throw new Exception("Posició invalida\n");
	Dades NovaDada= new Dades();
	NovaDada.id = id;
	NovaDada.elem=elem;
	MatriuElements[a][b] = (Object) NovaDada;
	Pos aux = new Pos();
	aux.x = a;
	aux.y = b;
	Referencies.put(id,aux);
  }
 /**
        * Elimina l'element amb l'identificador indicat 
        * @param id és l'identificador del objecte a eliminar
 */ 
  public void eliminarElement(Integer id) throws Exception{
      if (Referencies.get(id) == null) throw new Exception("L'element no existeix\n");
      Referencies.remove(id);
  }
   /**
        * Elimina l'element de la posició indicada 
        * @param a,b son la posició del objecte a eliminar 
 */ 
  public void eliminarElementxy(int a,int b) throws Exception{
      if (a<0 || b<0) throw new Exception("Posició invalida\n");
      Dades aux =(Dades) MatriuElements[a][b];
      if ( aux== null) throw new Exception("L'element no existeix\n");
      else if (Referencies.get(aux.id) == null) throw new Exception("L'element no existeix\n");
      Referencies.remove(aux.id);
  }
   /**
        * Comprova si l'element amb l'identificador indicat existex
        * @param id és el identificador de l'element que volem comprovar si existeix
 */  
  public Boolean existeixElement(Integer id) throws Exception{
      Pos aux = Referencies.get(id);
      if (aux == null ) return false;
      else return true;
  }
   /**
        * Retorna la coordenada X de l'element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
 */  
  public Integer consultarPosx (Integer id) throws Exception {
      Pos aux = Referencies.get(id);
      if (aux==null) throw new Exception("L'element no existeix\n");//excepcio
      return aux.x;
  }
     /**
        * Retorna la coordenada Y de l'element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
 */  
  public Integer consultarPosy (Integer id) throws Exception{
      Pos aux = Referencies.get(id);
      if (aux == null)throw new Exception("L'element no existeix\n");
      return aux.y;
  }
     /**
        * Retorna una copia del element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
 */  
  public T consultarElement(Integer id) throws Exception{
      Pos aux = Referencies.get(id);
      if (aux == null) throw new Exception("L'element no existeix\n");
      Dades aux2 =(Dades) MatriuElements[aux.x][aux.y];
      return aux2.elem;
  }
     /**
        * Retorna una copia del element situat a la posició donada 
        * @param a,b son la posició de l'element que volem consultar 
 */  
  public T consultarElementxy (int a,int b) throws Exception{
      if (a<0 || b<0) throw new Exception("Posició invalida\n");
      Dades aux =(Dades) MatriuElements[a][b];
      if (Referencies.get(aux.id)==null) throw new Exception("L'element no existeix\n");
      return aux.elem;
  }
  
  //--------
  
  public int tamX() {
	  return MatriuElements.length;
  }
  
  public int tamY() {
	  return MatriuElements[0].length;
  }
  

}