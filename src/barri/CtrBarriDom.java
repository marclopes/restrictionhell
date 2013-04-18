import java.util.*;

public class CtrBarriDom {
	

  private static ctrBarri= null;
  private cjtBarris;
  private CtrBarriDom () {
    cjtBarris = new CjtBarris();
  }
  public CtrBarriDom GetInstancia() {
    if ( ctrBarri== null ) ctrBarri = new CtrBarriDom();
    else return ctrBarri;
  }
  
  public void CreaBarri(String n, int po, int pr, int c, int cl, int a, int xx, int yy) {
    Barri barri = new Barri(n,po,pr,c,cl,a,xx,yy);
    cjtBarris.AfegirBarri(barri);
  }
  public void EliminarBarri(String n) {
    cjtBarris.EliminarBarri(n);
  }
  public Barri GetBarri(String n) {
    return cjtBarris.GetBarri(n);
  }
  public void AfegeixRestriccions(Barri b,String[] n) {
    for (int i=0; n[i] < n.length ; ++i) b.AfegeixRestriccions(n[i]);
  }
  public void GuardarBarri(String n) {
    //crida controlador persistencia
  }
  
  
}