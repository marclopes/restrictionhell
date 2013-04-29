
import java.util.ArrayList;

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

		while (x < e.obteX() && y < e.obteY()) {

			if (e.ExisteixElementxy(x, y)) {

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
						if (((Negoci) ed).consultarTipus() == ((Negoci) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						if (((Negoci) ed).consultarTipus() == ((Negoci) e2).consultarTipus()) {
							l2.add(new Pos(x, y));
						}
						break;

					default:
						break;
					}
				}

			}
			x++;
			if (x == 10) {
				x = 0;
				y++;
			}
		}

		Pos p1, p2;
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
					return false;

			}
		}
		return true;

	}

	public Edifici consultarEd1() {
		return e1;
	}

	public void modificarEd1(Edifici e) {
		e1 = e;
	}

	public Edifici consultarEd2() {
		return e2;
	}

	public void modificarEd2(Edifici e) {
		e2 = e;
	}

}
