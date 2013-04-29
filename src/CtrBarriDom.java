import com.sun.tools.internal.jxc.gen.config.Classes;


public class CtrBarriDom {

    
 
  private static CtrBarriDom ctrBarri= null;

  private CjtBarris cjtBarris;
  
  private CtrBarriDom () {
  }
  public static CtrBarriDom GetInstancia() {
    if ( ctrBarri== null ) ctrBarri = new CtrBarriDom();
    return ctrBarri;
  }
  
  public void CreaBarri(String n, int po, int pr, int c, Classes cl, int a, int xx, int yy) {
    Barri barri = new Barri(n,po,pr,c,cl,a,xx,yy);
    cjtBarris.AfegirBarri(barri);
  }
  public void EliminarBarri(String n) {
    cjtBarris.EliminarBarri(n);
  }
  public Barri GetBarri(String n) {
    return cjtBarris.GetBarri(n);
  }
  public void AfegeixRestriccions(Barri b,Restriccio r) {
      b.AfegeixRestriccio(r);
    
  }
  public void GuardarBarri(String n) {
    //crida controlador persistencia
    
  }
  public void AfegirEdifici(Edifici e,String nomBarri) {
      Barri b = ctrBarri.GetBarri(nomBarri);
      if (b!=null) {
	  b.carregaEdifici(e);
      }
  }
  public void GenerarBarri(String n){
      Barri barri = cjtBarris.GetBarri(n);
  }
  public void TreureEdifici(String nomBarri,String nomEdifici) {
      Barri aux = ctrBarri.GetBarri(nomBarri);
      if (aux!=null) {
	  
      }
  }
  public void TreureRestriccio(String nomBarri,int idRest) {
      Barri aux = ctrBarri.GetBarri(nomBarri);
      if (aux!=null) {
	  aux.EliminarRestriccio(idRest);
      }
  }  
}