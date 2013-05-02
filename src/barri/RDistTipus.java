package barri;
import java.util.ArrayList;

import barri.Edifici.TipusEd;

public class RDistTipus extends RDistancia {
	private Edifici e1, e2;

	public RDistTipus(int ID, int d, boolean m, Edifici e1, Edifici e2, Espai e) {
		super(ID, d, m, e);
		this.e1 = e1;
		this.e2 = e2;
		super.tr = TipusRest.DISTTIPUS;

	}

	public boolean CompleixRes() {
		int dist_act;
		int x, y;
		x = y = 0;

		ArrayList<Pos> l1, l2;
		l1 = new ArrayList<Pos>();
		l2 = new ArrayList<Pos>();

		while (x < e.ObteX() && y < e.ObteY() && e.ExisteixElementxy(x, y)) {

			if (e.ExisteixElementxy(x, y)) {
				Object o = e.ConsultarElementxy(x, y);
				if (o == null) System.out.println(e.ExisteixElementxy(x, y) + " pero ES NULLLLLL!!!!!");
				Edifici ed = ((Illa) e.ConsultarElementxy(x, y)).ConsultaEdifici();

				if (ed.consultarSubclasse() == e1.consultarSubclasse()) {
					switch (ed.consultarSubclasse()) {
					case HAB:
						if (((Habitatge) ed).consultarTipus() == ((Habitatge) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						if (((Habitatge) ed).consultarTipus() == ((Habitatge) e2).consultarTipus()) {
							l2.add(new Pos(x, y));
						}
						break;

					case NEG:
						if (((Negoci) ed).consultarTipus() == ((Negoci) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						if (((Negoci) ed).consultarTipus() == ((Negoci) e2).consultarTipus()) {
							l2.add(new Pos(x, y));
						}
						break;

					case SER:
						if (((Servei) ed).consultarTipus() == ((Servei) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						if (((Servei) ed).consultarTipus() == ((Servei) e2).consultarTipus()) {
							l2.add(new Pos(x, y));
						}
						break;

					default:
						break;
					}
				}

			}
			x++;
			if (x == e.ObteX()) {
				x = 0;
				y++;
			}
		}

		Pos p1, p2;
		
		boolean b = true;
		
		for (int i = 0; i < l1.size(); i++) {
			p1 = l1.get(i);
			for (int j = 0; j < l2.size(); j++) {
				p2 = l2.get(j);
				// System.err.println("RDistTipus: Distancia: " + dist(p1.x,
				// p1.y, p2.x, p2.y));
				if (max && (dist(p1.x, p1.y, p2.x, p2.y) > dist)
						&& dist(p1.x, p1.y, p2.x, p2.y) != 0)
					return false;
				else if (!max && (dist(p1.x, p1.y, p2.x, p2.y) < dist)
						&& dist(p1.x, p1.y, p2.x, p2.y) != 0)
					b = false;

			}
		}
		return b;

	}

	public Edifici ConsultarEd1() {
		return e1;
	}

	public void ModificarEd1(Edifici e) {
		e1 = e;
	}

	public Edifici ConsultarEd2() {
		return e2;
	}

	public void ModificarEd2(Edifici e) {
		e2 = e;
	}
	
	public String Info() {
		String s;
		if (max) s = "maxima";
		else s = "minima";
		String s2, s3;
		s2 = "null";
		s3 = "null";
		
		if (e1.consultarSubclasse() == TipusEd.NEG) s2 = ((Negoci)e1).consultarTipus().toString();
		else if (e1.consultarSubclasse() == TipusEd.HAB) s2 = ((Habitatge)e1).consultarTipus().toString();
		else if (e1.consultarSubclasse() == TipusEd.SER) s2 = ((Servei)e1).consultarTipus().toString();
		
		if (e2.consultarSubclasse() == TipusEd.NEG) s3 = ((Negoci)e2).consultarTipus().toString();
		else if (e2.consultarSubclasse() == TipusEd.HAB) s3 = ((Habitatge)e2).consultarTipus().toString();
		else if (e2.consultarSubclasse() == TipusEd.SER) s3 = ((Servei)e2).consultarTipus().toString();
		
		
		return ("Distancia " + s + " " + dist + " entre "+ s2 + " i " + s3);
	}

}
