import java.util.*;

public class CtrDomGeneral {

  private static CtrDomGeneral ctrDomini= null;
  private CtrDomBarri ctrBarri;
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
  
  public void CreaBarri(){
  }
  public void CrearRestriccio(){
  }
  public void CrearEdifici(){
  }
  public void ModificaBarri() {
  }
  public void ModificarEdifici(){
  }
  public void ModificarRestriccio(){
  }
  public void EliminarEdifici(){
  }
  public void EliminarBarri(){
  }
  public void EliminarRestriccio(){
  }
  public void CarregarCatalegEdifici(){
  }
  public void CarregarCatalegRestriccio(){
  }
  public void CarregarBarri(){ //binari barri
  }
  
  public void AfegirEdifici(){//al barri
  }
  public void ImposarRestriccio(){
  }
  public void TreuEdifici(){
  }
  public void TreuRestriccio(){
  }
  public void GeneraBarri(){
  }
  
}