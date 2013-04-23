package barri;

import barri.Edifici.Classes;
import projecte.Restriccio;

public class CtrBarriDom {

    
 
  private static CtrBarriDom ctrBarri= null;

  private CjtBarris cjtBarris;
  
  private CtrBarriDom () {
  }
  public CtrBarriDom GetInstancia() {
    if ( ctrBarri== null ) ctrBarri = new CtrBarriDom();
    return ctrBarri;
  }
  
  public void CreaBarri(String n, int po, int pr, int c, String cl, int a, int xx, int yy) {
    Classes classe = null;
    if (cl.equals("alta")){classe = Classes.Alta;}
    else if(cl.equals("mitja")){classe = Classes.Mitja;}
    else if(cl.equals("baixa")){classe = Classes.Baixa;}
    Barri barri = new Barri(n,po,pr,c,classe,a,xx,yy);
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
  
  
}