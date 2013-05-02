package barri;
import java.util.ArrayList;

import barri.Edifici.TipusEd;
import static barri.Edifici.TipusEd.HAB;
import static barri.Edifici.TipusEd.NEG;
import static barri.Edifici.TipusEd.SER;

public class RDistTipus extends RDistancia {
	private Edifici e1, e2;

        /**
         * Crea una instancia de la Restricció de distancia segons el tipus dels edificis.
         * @param ID Identificador de la restricció.
         * @param d Distancia que aplicara la restricció.
         * @param m Indica si la distancia es mínima o màxima.
         * @param e1 Primer edifici del qual es comprovarà el tipus.
         * @param e2 Segon edifici del qual es comprovarà el tipus.
         * @param e Espai on es comprovarà la restricció.
         */
	public RDistTipus(int ID, int d, boolean m, Edifici e1, Edifici e2, Espai e) {
		super(ID, d, m, e);
		this.e1 = e1;
		this.e2 = e2;
		super.tr = TipusRest.DISTTIPUS;

	}

        /**
         * Comprova que es compleix la restricció.
         * @return Cert si es compleix la restricció.
         */
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
				Edifici ed = ((Illa) e.ConsultarElementxy(x, y)).ConsultaEdifici();

				if (ed.consultarSubclasse() == e1.consultarSubclasse()) {
					switch (ed.consultarSubclasse()) {
					case HAB:
						if (((Habitatge) ed).consultarTipus() == ((Habitatge) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}

						break;

					case NEG:
						if (((Negoci) ed).consultarTipus() == ((Negoci) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
				
						break;

					case SER:
						if (((Servei) ed).consultarTipus() == ((Servei) e1).consultarTipus()) {
							l1.add(new Pos(x, y));
						}
						break;

					default:
						break;
					}
					
				}
					if (ed.consultarSubclasse() == e2.consultarSubclasse()) {
						switch (ed.consultarSubclasse()) {
						case HAB:

							if (((Habitatge) ed).consultarTipus() == ((Habitatge) e2).consultarTipus()) {
								l2.add(new Pos(x, y));
							}
							break;

						case NEG:

							if (((Negoci) ed).consultarTipus() == ((Negoci) e2).consultarTipus()) {
								l2.add(new Pos(x, y));
							}
							break;

						case SER:

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

		Pos p1;
		Pos p2;
		int di = 999999999;
		for (int i = 0; i < l1.size(); i++) {
			p1 = l1.get(i);
			for (int j = 0; j < l2.size(); j++) {
				p2 = l2.get(j);
				
				if (dist(p1.x, p1.y, p2.x, p2.y) < di && dist(p1.x, p1.y, p2.x, p2.y) != 0) di = dist(p1.x, p1.y, p2.x, p2.y);

			}	
			
			
		}
		if(max && di > dist) return false;
		if (!max && di < dist) return false;
		return true;

	}

        /**
         * Consulta el primer edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public Edifici ConsultarEd1() {
		return e1;
	}

        /**
         * Modifica el primer edifici de la restricció.
         * @return Nou edifici de la restricció.
         */
	public void ModificarEd1(Edifici e) {
		e1 = e;
	}

        /**
         * Consulta el segon edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public Edifici ConsultarEd2() {
		return e2;
	}

        /**
         * Modifica el segon edifici de la restricció.
         * @return L'edifici de la restricció.
         */
	public void ModificarEd2(Edifici e) {
		e2 = e;
	}
	
        /**
         * Consulta informació sobre la restricció.
         * @return Informació sobre la restricció.
         */
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
