package barri;

import java.util.ArrayList;

import barri.CtrDomRestriccio.Atribut;
import barri.Edifici.TipusEd;

public class RGlobal extends RestriccioBarris{
	
	String atrib;
	int val, vact;
	
	public RGlobal(int id, String atrib, int val) {
		super(id);
		this.atrib = atrib;
		this.val = val;
		vact = 0;
	}

	@Override
	public String Info() {
		// TODO Auto-generated method stub
		return (atrib + " maxim = " + val);
	}

	@Override
	public boolean prop(ArrayList<Assignacions> va, Assignacio a) {
		if (va.size() >= 2 && va.get(1).val == true) vact = 0;
			int v = GetV(a.e);
			vact = vact + v;
			
			int sum = 0;	
			
			for (int i = 0; i < va.size(); i++) {
				Assignacions aux = va.get(i);
				if (aux.val) {
					int imax = 0;
					int iac = 0;
					for (int j = 0; j < aux.va.size(); j++) {
						Assignacio aa = aux.va.get(j);
						
						if (aa.val) {
							iac = GetV(aa.e);
						}
						
						if (iac > imax) imax = iac;
						
					}
					
					sum = sum + imax;
					
				}
			}
			//vact = vact + sum;
			System.out.println(" * vact = " + vact + " i val = " + val);
			if (vact + sum >= val) return true;
			else {
				vact = vact - v;
				return false;
			}
	}
	
	
	private int GetV(Edifici ed) {
		Atribut a = Atribut.valueOf(atrib);
		switch (a) {
		case COST:
			if (ed instanceof Servei) return ((Servei)ed).ConsultarCost();
			break;
			
		case IMPOSTOS:
			if (ed instanceof Habitatge) return ((Habitatge)ed).ConsultarImpost();
			else if (ed instanceof Negoci) return ((Negoci)ed).ConsultarImpost();
			break;
			
		case APARCAMENT:
			if (ed instanceof Habitatge) return ((Habitatge)ed).ConsultarAparcament();
			else if (ed instanceof Negoci) return ((Negoci)ed).ConsultarAparcament();
			break;
			
		case MANTENIMENT:
			if (ed instanceof Servei) return ((Servei)ed).ConsultarManteniment();
			break;
			

		default:
			return 0;
			
		}
		return 0;
	}

	@Override
	public boolean afecta(Assignacio a) {
		Atribut at = Atribut.valueOf(atrib);
		switch (at) {
		case COST:
			if (a.e instanceof Servei) return true;
			break;
			
		case IMPOSTOS:
			if (a.e instanceof Habitatge) return true;
			else if (a.e instanceof Negoci) return true;
			break;
			
		case APARCAMENT:
			if (a.e instanceof Habitatge) return true;
			else if (a.e instanceof Negoci) return true;
			break;
			
		case MANTENIMENT:
			if (a.e instanceof Servei) return true;
			break;
			

		default:
			return false;
			
		}
		return false;
	}

	@Override
	public boolean CompleixRes() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void AssignaVal(int v) {
		val = v;
	}
	
	public int ObteVal() {
		return val;
	}
	
	public void AssignaAtrib(String a) {
		atrib = a;
	}
	
	public String ObteAtrib() {
		return atrib;
	}

}
