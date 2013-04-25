package barri;
import java.util.*;

public class CtrDomGeneral {

  private static CtrDomGeneral ctrDomini= null;
  private CtrBarriDom ctrBarri;
  private CtrDomEdificis ctrEdificis;
  private CtrDomRestriccions ctrRestric;
  
  private CtrDomGeneral(){
    ctrBarri = CtrBarriDom.GetInstancia();
    ctrEdificis = CtrDomEdificis.GetInstancia();
    ctrRestric = CtrDomRestriccions.GetInstancia();
  }
  public CtrDomGeneral GetInstancia() {
    if ( ctrDomini== null ) ctrDomini = new CtrBarriDom();
    return ctrDomini;
  }
  
  public void CreaBarri(String n, int po, int pr, int c, String cl, int a, int xx, int yy){
	 Classes tipClas;
	 if (cl.equals("Alta") ) tipClas = Classes.Alta;
	 else if (cl.equals("Mitja") ) tipClas = Classes.Mitja;
	 else tipClas = Classes.Baixa;
	 ctrBarri.CreaBarri(n,po,pr,c,tipClass,a,xx,yy);
  }
  public void CrearRestriccio(){ // esperar nova clase restriccio
  }
  public void CrearEdifici(String nom, int h, int capacitat,String clases,){
  }
  public void ModificaBarri(String nomBarri,String atribut, String valor) {
	 Barri tmpBarri = ctrBarri.GetBarri(nomBarri);
	 switch (atribut) {
	      //valors del atribut
	 
	 }
  }
  public void ModificarEdifici(String nomEdifici,String atribut ,String valor ){
	 Edifici tmpEdifici = ctrEdificis.GetEdifici(nomEdifici);
	 switch (atribut) {
	      //valors del atribut
	 
	 }
  }
  public void ModificarRestriccio(String nomRestriccio,String atribut,String valor){
  }
  public void EliminarEdifici(String nomEdifici){
	  
  }
  public void EliminarBarri(String nomBarri){
  }
  public void EliminarRestriccio(String nomRestriccio){
  }
  public void CarregarCatalegEdifici(){// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
  }
  public void CarregarCatalegRestriccio(String nomCataleg){// hauria de entrar el nom del fitxer per cridar al controlador de presitencia
  }
  public void CarregarBarri(String nomBarri){ //binari barri
  }
  
  public void AfegirEdifici(String nomBarri,String nomEdifici){//al barri
  }
  public void ImposarRestriccio(String nomBarri ,String nomRestriccio){
  }
  public void TreuEdifici(String nomBarri,String nomEdifici){
  }
  public void TreuRestriccio(String nomBarri,String nomRestriccio){
  }
  public void GeneraBarri(String nomBarri){
  }
  
}